#!/bin/bash

set -e
VM_IP_OUTPUT=$(virsh domifaddr aro-pcdn-client-1 | tail -n 2 | awk '{print $4}' | head -n 1)
VM_IP=$(echo $VM_IP_OUTPUT | cut -d'/' -f1)
WAN_IF=$(echo nmcli -t -f DEVICE,TYPE,STATE device | grep "ppp:disconnected" | cut -d: -f1)
LAN_IF="virbr0"

# 1. 开启 IP 转发
sysctl -w net.ipv4.ip_forward=1

# 2. 清空旧规则
iptables -t nat -F
iptables -F FORWARD

# 3. SNAT/MASQUERADE：让 VM 能通过宿主机上网
iptables -t nat -A POSTROUTING -o $WAN_IF -j MASQUERADE

# 4. TCP DNAT：80,443,9500-9700
iptables -t nat -A PREROUTING -i $WAN_IF -p tcp -m multiport --dports 80,443,9500:9700 -j DNAT --to-destination $VM_IP

# 5. UDP DNAT：全转发
iptables -t nat -A PREROUTING -i $WAN_IF -p udp -j DNAT --to-destination $VM_IP

# 6. FORWARD 规则：允许 TCP + UDP
iptables -I FORWARD 1 -i $WAN_IF -o $LAN_IF -d $VM_IP -p tcp -m multiport --dports 80,443,9500:9700 -j ACCEPT
iptables -I FORWARD 1 -i $WAN_IF -o $LAN_IF -d $VM_IP -p udp -j ACCEPT

iptables -I FORWARD 1 -o $WAN_IF -i $LAN_IF -s $VM_IP -p tcp -m multiport --sports 80,443,9500:9700 -j ACCEPT
iptables -I FORWARD 1 -o $WAN_IF -i $LAN_IF -s $VM_IP -p udp -j ACCEPT
