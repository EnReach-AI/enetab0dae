package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import p042N0.AbstractC0540h;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p042N0.InterfaceC0551s;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.InterfaceC0727r;
import p071Y0.InterfaceC0738b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p118m1.C1729D;
import p118m1.C1730E;
import p118m1.C1760y;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class TokenBufferSerializer extends StdSerializer<C1730E> {
    public TokenBufferSerializer() {
        super(C1730E.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("any", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(C1730E c1730e, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0538f {
        boolean z3 = c1730e.f6062l;
        C1729D c1729d = c1730e.f6063m;
        boolean z4 = z3 && c1729d.f6054d != null;
        int i3 = -1;
        while (true) {
            i3++;
            if (i3 >= 16) {
                c1729d = c1729d.f6051a;
                if (c1729d == null) {
                    return;
                }
                z4 = z3 && c1729d.f6054d != null;
                i3 = 0;
            }
            EnumC0548p enumC0548pM3850d = c1729d.m3850d(i3);
            if (enumC0548pM3850d == null) {
                return;
            }
            if (z4) {
                Object objM3849c = c1729d.m3849c(i3);
                if (objM3849c != null) {
                    abstractC0540h.mo1110C(objM3849c);
                }
                TreeMap treeMap = c1729d.f6054d;
                Object obj = treeMap == null ? null : treeMap.get(Integer.valueOf(i3 + i3));
                if (obj != null) {
                    abstractC0540h.mo1126S(obj);
                }
            }
            int iOrdinal = enumC0548pM3850d.ordinal();
            Object[] objArr = c1729d.f6053c;
            switch (iOrdinal) {
                case 1:
                    abstractC0540h.mo1120M();
                    break;
                case 2:
                    abstractC0540h.mo1143p();
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    abstractC0540h.mo1117J();
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    abstractC0540h.mo1142o();
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    Object obj2 = objArr[i3];
                    if (!(obj2 instanceof InterfaceC0551s)) {
                        abstractC0540h.mo1145r((String) obj2);
                    } else {
                        abstractC0540h.mo1144q((InterfaceC0551s) obj2);
                    }
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    Object obj3 = objArr[i3];
                    if (obj3 instanceof C1760y) {
                        Object obj4 = ((C1760y) obj3).f6138e;
                        if (obj4 instanceof InterfaceC0727r) {
                            abstractC0540h.mo1109B(obj4);
                        } else if (!(obj4 instanceof InterfaceC0551s)) {
                            abstractC0540h.mo1116I(String.valueOf(obj4));
                        } else {
                            abstractC0540h.mo1115H((InterfaceC0551s) obj4);
                        }
                    } else if (!(obj3 instanceof InterfaceC0727r)) {
                        abstractC0540h.mo1141n(obj3);
                    } else {
                        abstractC0540h.mo1109B(obj3);
                    }
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    Object obj5 = objArr[i3];
                    if (!(obj5 instanceof InterfaceC0551s)) {
                        abstractC0540h.mo1125R((String) obj5);
                    } else {
                        abstractC0540h.mo1124Q((InterfaceC0551s) obj5);
                    }
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    Object obj6 = objArr[i3];
                    if (obj6 instanceof Integer) {
                        abstractC0540h.mo1149v(((Integer) obj6).intValue());
                    } else if (obj6 instanceof BigInteger) {
                        abstractC0540h.mo1153z((BigInteger) obj6);
                    } else if (obj6 instanceof Long) {
                        abstractC0540h.mo1150w(((Long) obj6).longValue());
                    } else if (!(obj6 instanceof Short)) {
                        abstractC0540h.mo1149v(((Number) obj6).intValue());
                    } else {
                        abstractC0540h.mo1108A(((Short) obj6).shortValue());
                    }
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    Object obj7 = objArr[i3];
                    if (obj7 instanceof Double) {
                        abstractC0540h.mo1147t(((Double) obj7).doubleValue());
                    } else if (obj7 instanceof BigDecimal) {
                        abstractC0540h.mo1152y((BigDecimal) obj7);
                    } else if (obj7 instanceof Float) {
                        abstractC0540h.mo1148u(((Float) obj7).floatValue());
                    } else if (obj7 == null) {
                        abstractC0540h.mo1146s();
                    } else {
                        if (!(obj7 instanceof String)) {
                            c1730e.m1129a("Unrecognized value type for VALUE_NUMBER_FLOAT: " + obj7.getClass().getName() + ", cannot serialize");
                            throw null;
                        }
                        abstractC0540h.mo1151x((String) obj7);
                    }
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    abstractC0540h.mo1140m(true);
                    break;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    abstractC0540h.mo1140m(false);
                    break;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    abstractC0540h.mo1146s();
                    break;
                default:
                    throw new RuntimeException("Internal error: should never end up through this code path");
            }
        }
    }

    @Override // p069X0.AbstractC0728s
    public final void serializeWithType(C1730E c1730e, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws C0538f {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_EMBEDDED_OBJECT, c1730e));
        serialize(c1730e, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }
}
