package p162y;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p076a.AbstractBinderC0840b;
import p076a.C0839a;
import p076a.InterfaceC0841c;

/* JADX INFO: renamed from: y.o */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC2036o implements Handler.Callback, ServiceConnection {

    /* JADX INFO: renamed from: a */
    public final Context f7231a;

    /* JADX INFO: renamed from: b */
    public final Handler f7232b;

    /* JADX INFO: renamed from: c */
    public final HashMap f7233c = new HashMap();

    /* JADX INFO: renamed from: d */
    public HashSet f7234d = new HashSet();

    public ServiceConnectionC2036o(Context context) {
        this.f7231a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f7232b = new Handler(handlerThread.getLooper(), this);
    }

    /* JADX INFO: renamed from: a */
    public final void m4496a(C2035n c2035n) {
        boolean z3;
        ArrayDeque arrayDeque;
        boolean zIsLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = c2035n.f7226a;
        if (zIsLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + c2035n.f7229d.size() + " queued tasks");
        }
        if (c2035n.f7229d.isEmpty()) {
            return;
        }
        if (c2035n.f7227b) {
            z3 = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.f7231a;
            boolean zBindService = context.bindService(component, this, 33);
            c2035n.f7227b = zBindService;
            if (zBindService) {
                c2035n.f7230e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z3 = c2035n.f7227b;
        }
        if (!z3 || c2035n.f7228c == null) {
            m4497b(c2035n);
            return;
        }
        while (true) {
            arrayDeque = c2035n.f7229d;
            C2033l c2033l = (C2033l) arrayDeque.peek();
            if (c2033l == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + c2033l);
                }
                c2033l.m4495a(c2035n.f7228c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e3) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e3);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        m4497b(c2035n);
    }

    /* JADX INFO: renamed from: b */
    public final void m4497b(C2035n c2035n) {
        Handler handler = this.f7232b;
        ComponentName componentName = c2035n.f7226a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i3 = c2035n.f7230e;
        int i4 = i3 + 1;
        c2035n.f7230e = i4;
        if (i4 <= 6) {
            int i5 = (1 << i3) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i5 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i5);
            return;
        }
        StringBuilder sb = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = c2035n.f7229d;
        sb.append(arrayDeque.size());
        sb.append(" tasks to ");
        sb.append(componentName);
        sb.append(" after ");
        sb.append(c2035n.f7230e);
        sb.append(" retries");
        Log.w("NotifManCompat", sb.toString());
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashSet hashSet;
        int i3 = message.what;
        InterfaceC0841c interfaceC0841c = null;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return false;
                    }
                    C2035n c2035n = (C2035n) this.f7233c.get((ComponentName) message.obj);
                    if (c2035n != null) {
                        m4496a(c2035n);
                    }
                    return true;
                }
                C2035n c2035n2 = (C2035n) this.f7233c.get((ComponentName) message.obj);
                if (c2035n2 != null) {
                    if (c2035n2.f7227b) {
                        this.f7231a.unbindService(this);
                        c2035n2.f7227b = false;
                    }
                    c2035n2.f7228c = null;
                }
                return true;
            }
            C2034m c2034m = (C2034m) message.obj;
            ComponentName componentName = c2034m.f7224a;
            IBinder iBinder = c2034m.f7225b;
            C2035n c2035n3 = (C2035n) this.f7233c.get(componentName);
            if (c2035n3 != null) {
                int i4 = AbstractBinderC0840b.f2507a;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0841c)) {
                        C0839a c0839a = new C0839a();
                        c0839a.f2506a = iBinder;
                        interfaceC0841c = c0839a;
                    } else {
                        interfaceC0841c = (InterfaceC0841c) iInterfaceQueryLocalInterface;
                    }
                }
                c2035n3.f7228c = interfaceC0841c;
                c2035n3.f7230e = 0;
                m4496a(c2035n3);
            }
            return true;
        }
        C2033l c2033l = (C2033l) message.obj;
        String string = Settings.Secure.getString(this.f7231a.getContentResolver(), "enabled_notification_listeners");
        synchronized (C2037p.f7235c) {
            if (string != null) {
                try {
                    if (!string.equals(C2037p.f7236d)) {
                        String[] strArrSplit = string.split(":", -1);
                        HashSet hashSet2 = new HashSet(strArrSplit.length);
                        for (String str : strArrSplit) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null) {
                                hashSet2.add(componentNameUnflattenFromString.getPackageName());
                            }
                        }
                        C2037p.f7237e = hashSet2;
                        C2037p.f7236d = string;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            hashSet = C2037p.f7237e;
        }
        if (!hashSet.equals(this.f7234d)) {
            this.f7234d = hashSet;
            List<ResolveInfo> listQueryIntentServices = this.f7231a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet3 = new HashSet();
            for (ResolveInfo resolveInfo : listQueryIntentServices) {
                if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName2 = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName2 + ", not adding listener record.");
                    } else {
                        hashSet3.add(componentName2);
                    }
                }
            }
            for (ComponentName componentName3 : hashSet3) {
                if (!this.f7233c.containsKey(componentName3)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName3);
                    }
                    this.f7233c.put(componentName3, new C2035n(componentName3));
                }
            }
            Iterator it = this.f7233c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!hashSet3.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                    }
                    C2035n c2035n4 = (C2035n) entry.getValue();
                    if (c2035n4.f7227b) {
                        this.f7231a.unbindService(this);
                        c2035n4.f7227b = false;
                    }
                    c2035n4.f7228c = null;
                    it.remove();
                }
            }
        }
        for (C2035n c2035n5 : this.f7233c.values()) {
            c2035n5.f7229d.add(c2033l);
            m4496a(c2035n5);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f7232b.obtainMessage(1, new C2034m(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f7232b.obtainMessage(2, componentName).sendToTarget();
    }
}
