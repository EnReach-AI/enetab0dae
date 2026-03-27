package p148u0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.InputFilter;
import com.facebook.AbstractC1117n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import p005B.AbstractC0032g;
import p008B2.AbstractC0089b0;
import p008B2.C0066F;
import p008B2.C0079T;
import p008B2.C0090c;
import p008B2.C0105j0;
import p008B2.C0117p0;
import p010C0.AbstractC0147a;
import p027I0.AbstractBinderC0299b;
import p027I0.C0298a;
import p027I0.InterfaceC0300c;
import p083b2.C1061f;
import p083b2.C1066k;
import p086c2.AbstractC1087f;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.C1763b;
import p119m2.InterfaceC1762a;
import p135q2.InterfaceC1840a;
import p135q2.InterfaceC1841b;
import p137r0.AbstractC1852a;
import p156w0.AbstractC1986a;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2072j;
import p166z0.C2068f;

/* JADX INFO: renamed from: u0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1946e {

    /* JADX INFO: renamed from: a */
    public static Boolean f6942a;

    /* JADX INFO: renamed from: b */
    public static final Class m4344b(InterfaceC1840a interfaceC1840a) {
        AbstractC1766e.m3920e("<this>", interfaceC1840a);
        Class clsMo3914a = ((InterfaceC1762a) interfaceC1840a).mo3914a();
        AbstractC1766e.m3918c("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>", clsMo3914a);
        return clsMo3914a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: c */
    public static final Class m4345c(InterfaceC1840a interfaceC1840a) {
        AbstractC1766e.m3920e("<this>", interfaceC1840a);
        Class clsMo3914a = ((InterfaceC1762a) interfaceC1840a).mo3914a();
        if (!clsMo3914a.isPrimitive()) {
            return clsMo3914a;
        }
        String name = clsMo3914a.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (!name.equals("float")) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return clsMo3914a;
    }

    /* JADX INFO: renamed from: d */
    public static Intent m4346d(Context context) {
        if (AbstractC0147a.f354a.contains(AbstractC1946e.class)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                Intent intent = new Intent("ReceiverService");
                intent.setPackage("com.facebook.katana");
                if (packageManager.resolveService(intent, 0) != null && AbstractC2072j.m4609a(context, "com.facebook.katana")) {
                    return intent;
                }
                Intent intent2 = new Intent("ReceiverService");
                intent2.setPackage("com.facebook.wakizashi");
                if (packageManager.resolveService(intent2, 0) != null) {
                    if (AbstractC2072j.m4609a(context, "com.facebook.wakizashi")) {
                        return intent2;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1946e.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static Typeface m4347e(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0 || typeface == null) {
            return null;
        }
        return Typeface.create(typeface, AbstractC1852a.m4126a(configuration.fontWeightAdjustment + typeface.getWeight(), 1, 1000), typeface.isItalic());
    }

    /* JADX INFO: renamed from: f */
    public static final InterfaceC2012a m4348f(InterfaceC1840a interfaceC1840a, List list, InterfaceC1678a interfaceC1678a) {
        InterfaceC2012a c0117p0;
        InterfaceC2012a c0105j0;
        AbstractC1766e.m3920e("<this>", interfaceC1840a);
        if (interfaceC1840a.equals(AbstractC1770i.m3927a(Collection.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(List.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(List.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(ArrayList.class))) {
            c0117p0 = new C0090c((InterfaceC2012a) list.get(0), 0);
        } else if (interfaceC1840a.equals(AbstractC1770i.m3927a(HashSet.class))) {
            c0117p0 = new C0090c((InterfaceC2012a) list.get(0), 1);
        } else {
            if (interfaceC1840a.equals(AbstractC1770i.m3927a(Set.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(Set.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(LinkedHashSet.class))) {
                c0117p0 = new C0090c((InterfaceC2012a) list.get(0), 2);
            } else if (interfaceC1840a.equals(AbstractC1770i.m3927a(HashMap.class))) {
                c0117p0 = new C0066F((InterfaceC2012a) list.get(0), (InterfaceC2012a) list.get(1), 0);
            } else {
                if (interfaceC1840a.equals(AbstractC1770i.m3927a(Map.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(Map.class)) ? true : interfaceC1840a.equals(AbstractC1770i.m3927a(LinkedHashMap.class))) {
                    c0117p0 = new C0066F((InterfaceC2012a) list.get(0), (InterfaceC2012a) list.get(1), 1);
                } else {
                    if (interfaceC1840a.equals(AbstractC1770i.m3927a(Map.Entry.class))) {
                        InterfaceC2012a interfaceC2012a = (InterfaceC2012a) list.get(0);
                        InterfaceC2012a interfaceC2012a2 = (InterfaceC2012a) list.get(1);
                        AbstractC1766e.m3920e("keySerializer", interfaceC2012a);
                        AbstractC1766e.m3920e("valueSerializer", interfaceC2012a2);
                        c0105j0 = new C0079T(interfaceC2012a, interfaceC2012a2, 0);
                    } else if (interfaceC1840a.equals(AbstractC1770i.m3927a(C1061f.class))) {
                        InterfaceC2012a interfaceC2012a3 = (InterfaceC2012a) list.get(0);
                        InterfaceC2012a interfaceC2012a4 = (InterfaceC2012a) list.get(1);
                        AbstractC1766e.m3920e("keySerializer", interfaceC2012a3);
                        AbstractC1766e.m3920e("valueSerializer", interfaceC2012a4);
                        c0105j0 = new C0079T(interfaceC2012a3, interfaceC2012a4, 1);
                    } else if (interfaceC1840a.equals(AbstractC1770i.m3927a(C1066k.class))) {
                        InterfaceC2012a interfaceC2012a5 = (InterfaceC2012a) list.get(0);
                        InterfaceC2012a interfaceC2012a6 = (InterfaceC2012a) list.get(1);
                        InterfaceC2012a interfaceC2012a7 = (InterfaceC2012a) list.get(2);
                        AbstractC1766e.m3920e("aSerializer", interfaceC2012a5);
                        AbstractC1766e.m3920e("bSerializer", interfaceC2012a6);
                        AbstractC1766e.m3920e("cSerializer", interfaceC2012a7);
                        c0117p0 = new C0117p0(interfaceC2012a5, interfaceC2012a6, interfaceC2012a7);
                    } else if (m4344b(interfaceC1840a).isArray()) {
                        Object objMo263a = interfaceC1678a.mo263a();
                        AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>", objMo263a);
                        InterfaceC2012a interfaceC2012a8 = (InterfaceC2012a) list.get(0);
                        AbstractC1766e.m3920e("elementSerializer", interfaceC2012a8);
                        c0105j0 = new C0105j0((InterfaceC1840a) objMo263a, interfaceC2012a8);
                    } else {
                        c0117p0 = null;
                    }
                    c0117p0 = c0105j0;
                }
            }
        }
        if (c0117p0 != null) {
            return c0117p0;
        }
        InterfaceC2012a[] interfaceC2012aArr = (InterfaceC2012a[]) list.toArray(new InterfaceC2012a[0]);
        return AbstractC0089b0.m257d(interfaceC1840a, (InterfaceC2012a[]) Arrays.copyOf(interfaceC2012aArr, interfaceC2012aArr.length));
    }

    /* JADX INFO: renamed from: g */
    public static int m4349g(int i3, String str, List list) {
        if (AbstractC0147a.f354a.contains(AbstractC1946e.class)) {
            return 0;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            Intent intentM4346d = m4346d(context);
            int i4 = 2;
            if (intentM4346d == null) {
                return 2;
            }
            ServiceConnectionC1945d serviceConnectionC1945d = new ServiceConnectionC1945d();
            try {
                if (context.bindService(intentM4346d, serviceConnectionC1945d, 1)) {
                    try {
                        serviceConnectionC1945d.f6940a.await(5L, TimeUnit.SECONDS);
                        IBinder iBinder = serviceConnectionC1945d.f6941b;
                        if (iBinder != null) {
                            InterfaceC0300c interfaceC0300cM574a = AbstractBinderC0299b.m574a(iBinder);
                            Bundle bundleM4339a = AbstractC1944c.m4339a(i3, str, list);
                            if (bundleM4339a != null) {
                                C0298a c0298a = (C0298a) interfaceC0300cM574a;
                                c0298a.getClass();
                                Parcel parcelObtain = Parcel.obtain();
                                Parcel parcelObtain2 = Parcel.obtain();
                                try {
                                    parcelObtain.writeInterfaceToken("com.facebook.ppml.receiver.IReceiverService");
                                    parcelObtain.writeInt(1);
                                    bundleM4339a.writeToParcel(parcelObtain, 0);
                                    c0298a.f799a.transact(1, parcelObtain, parcelObtain2, 0);
                                    parcelObtain2.readException();
                                    parcelObtain2.readInt();
                                    parcelObtain2.recycle();
                                    parcelObtain.recycle();
                                    bundleM4339a.toString();
                                } catch (Throwable th) {
                                    parcelObtain2.recycle();
                                    parcelObtain.recycle();
                                    throw th;
                                }
                            }
                            i4 = 1;
                        }
                        context.unbindService(serviceConnectionC1945d);
                        return i4;
                    } catch (RemoteException | InterruptedException unused) {
                        HashSet hashSet2 = AbstractC1117n.f3875a;
                        context.unbindService(serviceConnectionC1945d);
                    }
                }
                return 3;
            } catch (Throwable th2) {
                context.unbindService(serviceConnectionC1945d);
                HashSet hashSet3 = AbstractC1117n.f3875a;
                throw th2;
            }
        } catch (Throwable th3) {
            AbstractC0147a.m295a(th3, AbstractC1946e.class);
            return 0;
        }
    }

    /* JADX INFO: renamed from: h */
    public static final InterfaceC2012a m4350h(C2068f c2068f, InterfaceC1841b interfaceC1841b) {
        AbstractC1766e.m3920e("<this>", c2068f);
        AbstractC1766e.m3920e("type", interfaceC1841b);
        InterfaceC2012a interfaceC2012aM4390r = AbstractC1986a.m4390r(c2068f, interfaceC1841b, true);
        if (interfaceC2012aM4390r != null) {
            return interfaceC2012aM4390r;
        }
        InterfaceC1840a interfaceC1840aM260g = AbstractC0089b0.m260g(interfaceC1841b);
        AbstractC1766e.m3920e("<this>", interfaceC1840aM260g);
        String strM3915b = ((C1763b) interfaceC1840aM260g).m3915b();
        if (strM3915b == null) {
            strM3915b = "<local class name not available>";
        }
        throw new C2017f(AbstractC0032g.m154l("Serializer for class '", strM3915b, "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n"));
    }

    /* JADX INFO: renamed from: i */
    public static final ArrayList m4351i(C2068f c2068f, List list, boolean z3) {
        ArrayList arrayList;
        AbstractC1766e.m3920e("<this>", c2068f);
        AbstractC1766e.m3920e("typeArguments", list);
        if (z3) {
            arrayList = new ArrayList(AbstractC1087f.m2838v(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m4350h(c2068f, (InterfaceC1841b) it.next()));
            }
        } else {
            arrayList = new ArrayList(AbstractC1087f.m2838v(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                InterfaceC1841b interfaceC1841b = (InterfaceC1841b) it2.next();
                AbstractC1766e.m3920e("type", interfaceC1841b);
                InterfaceC2012a interfaceC2012aM4390r = AbstractC1986a.m4390r(c2068f, interfaceC1841b, false);
                if (interfaceC2012aM4390r == null) {
                    return null;
                }
                arrayList.add(interfaceC2012aM4390r);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public abstract InputFilter[] mo1442a(InputFilter[] inputFilterArr);

    /* JADX INFO: renamed from: j */
    public abstract void mo1443j(boolean z3);

    /* JADX INFO: renamed from: k */
    public abstract void mo1444k(boolean z3);
}
