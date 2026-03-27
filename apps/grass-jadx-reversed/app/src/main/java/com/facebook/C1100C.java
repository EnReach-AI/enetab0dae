package com.facebook;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.C0934e;
import androidx.recyclerview.widget.RecyclerView;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p009C.AbstractC0141d;
import p018F.InterfaceC0209a;
import p024H0.C0259m;
import p024H0.C0261o;
import p024H0.C0262p;
import p024H0.C0263q;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p068X.C0698c;
import p069X0.AbstractC0721l;
import p073Z.AbstractC0777X;
import p073Z.C0755A;
import p073Z.C0782b;
import p079a2.C0861f;
import p140s.C1864d;
import p140s.C1865e;
import p143t.C1903b;
import p147u.C1929e;
import p162y.C2029h;
import p162y.C2031j;
import p162y.C2041t;
import p166z0.AbstractC2069g;
import p166z0.InterfaceC2055D;

/* JADX INFO: renamed from: com.facebook.C */
/* JADX INFO: loaded from: classes.dex */
public final class C1100C implements InterfaceC2055D, InterfaceC0209a {

    /* JADX INFO: renamed from: i */
    public static volatile C1100C f3797i;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3798e;

    /* JADX INFO: renamed from: f */
    public final Object f3799f;

    /* JADX INFO: renamed from: g */
    public final Object f3800g;

    /* JADX INFO: renamed from: h */
    public Object f3801h;

    public /* synthetic */ C1100C(Object obj, Object obj2, Object obj3, int i3) {
        this.f3798e = i3;
        this.f3799f = obj;
        this.f3800g = obj2;
        this.f3801h = obj3;
    }

    /* JADX INFO: renamed from: i */
    public static C1100C m2844i() {
        if (f3797i == null) {
            synchronized (C1100C.class) {
                try {
                    if (f3797i == null) {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        f3797i = new C1100C(C0698c.m1678a(AbstractC1117n.f3882h), new C0861f());
                    }
                } finally {
                }
            }
        }
        return f3797i;
    }

    @Override // p166z0.InterfaceC2055D
    /* JADX INFO: renamed from: a */
    public void mo2845a(C1111h c1111h) {
        C0263q c0263q = ((C0259m) this.f3801h).f688f;
        c0263q.m511c(C0262p.m507a(c0263q.f675k, "Caught exception", c1111h.getMessage(), null));
    }

    @Override // p166z0.InterfaceC2055D
    /* JADX INFO: renamed from: b */
    public void mo2846b(JSONObject jSONObject) {
        C0259m c0259m = (C0259m) this.f3801h;
        Bundle bundle = (Bundle) this.f3799f;
        try {
            bundle.putString("com.facebook.platform.extra.USER_ID", jSONObject.getString("id"));
            c0259m.m505j((C0261o) this.f3800g, bundle);
        } catch (JSONException e3) {
            C0263q c0263q = c0259m.f688f;
            c0263q.m511c(C0262p.m507a(c0263q.f675k, "Caught exception", e3.getMessage(), null));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2847c(String str, Integer num) {
        HashMap map = (HashMap) this.f3801h;
        Object obj = map.get(str);
        if (obj == null) {
            map.put(str, num);
            return;
        }
        if (obj instanceof List) {
            ((List) obj).add(num);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(obj);
        linkedList.add(num);
        map.put(str, linkedList);
    }

    /* JADX INFO: renamed from: d */
    public void m2848d(View view, int i3, boolean z3) {
        C0755A c0755a = (C0755A) this.f3799f;
        int childCount = i3 < 0 ? c0755a.f2126a.getChildCount() : m2853j(i3);
        ((C0782b) this.f3800g).m2071e(childCount, z3);
        if (z3) {
            m2856m(view);
        }
        c0755a.f2126a.addView(view, childCount);
        RecyclerView.m2571I(view);
    }

    /* JADX INFO: renamed from: e */
    public void m2849e(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        C0755A c0755a = (C0755A) this.f3799f;
        int childCount = i3 < 0 ? c0755a.f2126a.getChildCount() : m2853j(i3);
        ((C0782b) this.f3800g).m2071e(childCount, z3);
        if (z3) {
            m2856m(view);
        }
        c0755a.getClass();
        AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
        RecyclerView recyclerView = c0755a.f2126a;
        if (abstractC0777XM2571I != null) {
            if (!abstractC0777XM2571I.m2060k() && !abstractC0777XM2571I.m2065p()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + abstractC0777XM2571I + recyclerView.m2624y());
            }
            abstractC0777XM2571I.f2211j &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    /* JADX INFO: renamed from: f */
    public void m2850f(int i3) {
        AbstractC0777X abstractC0777XM2571I;
        int iM2853j = m2853j(i3);
        ((C0782b) this.f3800g).m2072f(iM2853j);
        RecyclerView recyclerView = ((C0755A) this.f3799f).f2126a;
        View childAt = recyclerView.getChildAt(iM2853j);
        if (childAt != null && (abstractC0777XM2571I = RecyclerView.m2571I(childAt)) != null) {
            if (abstractC0777XM2571I.m2060k() && !abstractC0777XM2571I.m2065p()) {
                throw new IllegalArgumentException("called detach on an already detached child " + abstractC0777XM2571I + recyclerView.m2624y());
            }
            abstractC0777XM2571I.m2050a(256);
        }
        recyclerView.detachViewFromParent(iM2853j);
    }

    /* JADX INFO: renamed from: g */
    public View m2851g(int i3) {
        return ((C0755A) this.f3799f).f2126a.getChildAt(m2853j(i3));
    }

    /* JADX INFO: renamed from: h */
    public int m2852h() {
        return ((C0755A) this.f3799f).f2126a.getChildCount() - ((ArrayList) this.f3801h).size();
    }

    /* JADX INFO: renamed from: j */
    public int m2853j(int i3) {
        if (i3 < 0) {
            return -1;
        }
        int childCount = ((C0755A) this.f3799f).f2126a.getChildCount();
        int i4 = i3;
        while (i4 < childCount) {
            C0782b c0782b = (C0782b) this.f3800g;
            int iM2068b = i3 - (i4 - c0782b.m2068b(i4));
            if (iM2068b == 0) {
                while (c0782b.m2070d(i4)) {
                    i4++;
                }
                return i4;
            }
            i4 += iM2068b;
        }
        return -1;
    }

    /* JADX INFO: renamed from: k */
    public View m2854k(int i3) {
        return ((C0755A) this.f3799f).f2126a.getChildAt(i3);
    }

    /* JADX INFO: renamed from: l */
    public int m2855l() {
        return ((C0755A) this.f3799f).f2126a.getChildCount();
    }

    /* JADX INFO: renamed from: m */
    public void m2856m(View view) {
        ((ArrayList) this.f3801h).add(view);
        C0755A c0755a = (C0755A) this.f3799f;
        c0755a.getClass();
        AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
        if (abstractC0777XM2571I != null) {
            int i3 = abstractC0777XM2571I.f2218q;
            View view2 = abstractC0777XM2571I.f2202a;
            if (i3 != -1) {
                abstractC0777XM2571I.f2217p = i3;
            } else {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                abstractC0777XM2571I.f2217p = AbstractC0307B.m587c(view2);
            }
            RecyclerView recyclerView = c0755a.f2126a;
            if (recyclerView.m2586L()) {
                abstractC0777XM2571I.f2218q = 4;
                recyclerView.f3443t0.add(abstractC0777XM2571I);
            } else {
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                AbstractC0307B.m603s(view2, 4);
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public boolean m2857n(View view) {
        return ((ArrayList) this.f3801h).contains(view);
    }

    /* JADX INFO: renamed from: o */
    public boolean m2858o(C1929e c1929e, C1864d c1864d, boolean z3) {
        int[] iArr = c1864d.f6493c0;
        int i3 = iArr[0];
        C1903b c1903b = (C1903b) this.f3800g;
        c1903b.f6648a = i3;
        c1903b.f6649b = iArr[1];
        c1903b.f6650c = c1864d.m4156l();
        c1903b.f6651d = c1864d.m4153i();
        c1903b.f6656i = false;
        c1903b.f6657j = z3;
        boolean z4 = c1903b.f6648a == 3;
        boolean z5 = c1903b.f6649b == 3;
        boolean z6 = z4 && c1864d.f6473L > 0.0f;
        boolean z7 = z5 && c1864d.f6473L > 0.0f;
        int[] iArr2 = c1864d.f6502l;
        if (z6 && iArr2[0] == 4) {
            c1903b.f6648a = 1;
        }
        if (z7 && iArr2[1] == 4) {
            c1903b.f6649b = 1;
        }
        c1929e.m4326a(c1864d, c1903b);
        c1864d.m4169y(c1903b.f6652e);
        c1864d.m4166v(c1903b.f6653f);
        c1864d.f6513w = c1903b.f6655h;
        int i4 = c1903b.f6654g;
        c1864d.f6477P = i4;
        c1864d.f6513w = i4 > 0;
        c1903b.f6657j = false;
        return c1903b.f6656i;
    }

    /* JADX INFO: renamed from: p */
    public void m2859p(C1099B c1099b, boolean z3) {
        C1099B c1099b2 = (C1099B) this.f3801h;
        this.f3801h = c1099b;
        if (z3) {
            C0861f c0861f = (C0861f) this.f3800g;
            if (c1099b != null) {
                c0861f.getClass();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", c1099b.f3791e);
                    jSONObject.put("first_name", c1099b.f3792f);
                    jSONObject.put("middle_name", c1099b.f3793g);
                    jSONObject.put("last_name", c1099b.f3794h);
                    jSONObject.put("name", c1099b.f3795i);
                    Uri uri = c1099b.f3796j;
                    if (uri != null) {
                        jSONObject.put("link_uri", uri.toString());
                    }
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    c0861f.f2540a.edit().putString("com.facebook.ProfileManager.CachedProfile", jSONObject.toString()).apply();
                }
            } else {
                c0861f.f2540a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
            }
        }
        if (c1099b2 == null ? c1099b == null : c1099b2.equals(c1099b)) {
            return;
        }
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", c1099b2);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", c1099b);
        ((C0698c) this.f3799f).m1680c(intent);
    }

    /* JADX INFO: renamed from: q */
    public void m2860q(C1865e c1865e, int i3, int i4) {
        int i5 = c1865e.f6478Q;
        int i6 = c1865e.f6479R;
        c1865e.f6478Q = 0;
        c1865e.f6479R = 0;
        c1865e.m4169y(i3);
        c1865e.m4166v(i4);
        if (i5 < 0) {
            c1865e.f6478Q = 0;
        } else {
            c1865e.f6478Q = i5;
        }
        if (i6 < 0) {
            c1865e.f6479R = 0;
        } else {
            c1865e.f6479R = i6;
        }
        ((C1865e) this.f3801h).m4174E();
    }

    @Override // p018F.InterfaceC0209a
    /* JADX INFO: renamed from: r */
    public void mo415r() {
        View view = (View) this.f3799f;
        view.clearAnimation();
        ((ViewGroup) this.f3800g).endViewTransition(view);
        ((C0934e) this.f3801h).m2450e();
    }

    /* JADX INFO: renamed from: s */
    public void m2861s(View view) {
        if (((ArrayList) this.f3801h).remove(view)) {
            C0755A c0755a = (C0755A) this.f3799f;
            c0755a.getClass();
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
            if (abstractC0777XM2571I != null) {
                int i3 = abstractC0777XM2571I.f2217p;
                RecyclerView recyclerView = c0755a.f2126a;
                if (recyclerView.m2586L()) {
                    abstractC0777XM2571I.f2218q = i3;
                    recyclerView.f3443t0.add(abstractC0777XM2571I);
                } else {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0307B.m603s(abstractC0777XM2571I.f2202a, i3);
                }
                abstractC0777XM2571I.f2217p = 0;
            }
        }
    }

    public String toString() {
        switch (this.f3798e) {
            case 2:
                return ((C0782b) this.f3800g).toString() + ", hidden list:" + ((ArrayList) this.f3801h).size();
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                StringBuilder sb = new StringBuilder("[ClassStack (self-refs: ");
                ArrayList arrayList = (ArrayList) this.f3801h;
                sb.append(arrayList == null ? "0" : String.valueOf(arrayList.size()));
                sb.append(')');
                for (C1100C c1100c = this; c1100c != null; c1100c = (C1100C) c1100c.f3799f) {
                    sb.append(' ');
                    sb.append(((Class) c1100c.f3800g).getName());
                }
                sb.append(']');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public C1100C(C1100C c1100c, Class cls) {
        this.f3798e = 6;
        this.f3799f = c1100c;
        this.f3800g = cls;
    }

    public C1100C(C0698c c0698c, C0861f c0861f) {
        this.f3798e = 0;
        AbstractC2069g.m4582f("localBroadcastManager", c0698c);
        this.f3799f = c0698c;
        this.f3800g = c0861f;
    }

    public C1100C(C0755A c0755a) {
        this.f3798e = 2;
        this.f3799f = c0755a;
        this.f3800g = new C0782b();
        this.f3801h = new ArrayList();
    }

    public C1100C(C2031j c2031j) {
        String str;
        String str2;
        Bundle bundle;
        ArrayList arrayList;
        String str3;
        String str4;
        int i3;
        Bundle bundle2;
        int i4;
        C1100C c1100c = this;
        c1100c.f3798e = 8;
        new ArrayList();
        c1100c.f3801h = new Bundle();
        c1100c.f3800g = c2031j;
        Context context = c2031j.f7199a;
        Context context2 = c2031j.f7199a;
        String str5 = c2031j.f7216r;
        Notification.Builder builder = new Notification.Builder(context2, str5);
        c1100c.f3799f = builder;
        Notification notification = c2031j.f7218t;
        Bundle[] bundleArr = null;
        int i5 = 0;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c2031j.f7203e).setContentText(c2031j.f7204f).setContentInfo(null).setContentIntent(c2031j.f7205g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(c2031j.f7206h).setNumber(0).setProgress(0, 0, false);
        builder.setSubText(c2031j.f7210l).setUsesChronometer(false).setPriority(c2031j.f7207i);
        Iterator it = c2031j.f7200b.iterator();
        while (true) {
            str = "android.support.allowGeneratedReplies";
            if (!it.hasNext()) {
                break;
            }
            C2029h c2029h = (C2029h) it.next();
            if (c2029h.f7185b == null && (i4 = c2029h.f7190g) != 0) {
                c2029h.f7185b = IconCompat.m2316a(i4);
            }
            IconCompat iconCompat = c2029h.f7185b;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat != null ? AbstractC0141d.m286c(iconCompat, null) : null, c2029h.f7191h, c2029h.f7192i);
            C2041t[] c2041tArr = c2029h.f7186c;
            if (c2041tArr != null) {
                int length = c2041tArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                for (int i6 = 0; i6 < c2041tArr.length; i6++) {
                    remoteInputArr[i6] = C2041t.m4506a(c2041tArr[i6]);
                }
                for (int i7 = 0; i7 < length; i7++) {
                    builder2.addRemoteInput(remoteInputArr[i7]);
                }
            }
            Bundle bundle3 = c2029h.f7184a;
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            boolean z3 = c2029h.f7187d;
            bundle2.putBoolean("android.support.allowGeneratedReplies", z3);
            int i8 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z3);
            int i9 = c2029h.f7189f;
            bundle2.putInt("android.support.action.semanticAction", i9);
            builder2.setSemanticAction(i9);
            if (i8 >= 29) {
                builder2.setContextual(false);
            }
            if (i8 >= 31) {
                builder2.setAuthenticationRequired(false);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", c2029h.f7188e);
            builder2.addExtras(bundle2);
            ((Notification.Builder) c1100c.f3799f).addAction(builder2.build());
        }
        Bundle bundle4 = c2031j.f7213o;
        if (bundle4 != null) {
            ((Bundle) c1100c.f3801h).putAll(bundle4);
        }
        ((Notification.Builder) c1100c.f3799f).setShowWhen(c2031j.f7208j);
        ((Notification.Builder) c1100c.f3799f).setLocalOnly(false).setGroup(c2031j.f7211m).setGroupSummary(c2031j.f7212n).setSortKey(null);
        ((Notification.Builder) c1100c.f3799f).setCategory(null).setColor(c2031j.f7214p).setVisibility(c2031j.f7215q).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList2 = c2031j.f7219u;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((Notification.Builder) c1100c.f3799f).addPerson((String) it2.next());
            }
        }
        ArrayList arrayList3 = c2031j.f7202d;
        if (arrayList3.size() > 0) {
            if (c2031j.f7213o == null) {
                c2031j.f7213o = new Bundle();
            }
            Bundle bundle5 = c2031j.f7213o.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i10 = 0;
            while (i10 < arrayList3.size()) {
                String string = Integer.toString(i10);
                C2029h c2029h2 = (C2029h) arrayList3.get(i10);
                Bundle bundle8 = new Bundle();
                if (c2029h2.f7185b == null && (i3 = c2029h2.f7190g) != 0) {
                    c2029h2.f7185b = IconCompat.m2316a(i3);
                }
                IconCompat iconCompat2 = c2029h2.f7185b;
                bundle8.putInt("icon", iconCompat2 != null ? iconCompat2.m2317b() : i5);
                bundle8.putCharSequence("title", c2029h2.f7191h);
                bundle8.putParcelable("actionIntent", c2029h2.f7192i);
                Bundle bundle9 = c2029h2.f7184a;
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean(str, c2029h2.f7187d);
                bundle8.putBundle("extras", bundle);
                C2041t[] c2041tArr2 = c2029h2.f7186c;
                if (c2041tArr2 == null) {
                    arrayList = arrayList3;
                    str4 = str5;
                    str3 = str;
                } else {
                    bundleArr = new Bundle[c2041tArr2.length];
                    arrayList = arrayList3;
                    str3 = str;
                    int i11 = 0;
                    while (i11 < c2041tArr2.length) {
                        C2041t c2041t = c2041tArr2[i11];
                        C2041t[] c2041tArr3 = c2041tArr2;
                        Bundle bundle10 = new Bundle();
                        String str6 = str5;
                        bundle10.putString("resultKey", c2041t.f7242a);
                        bundle10.putCharSequence("label", c2041t.f7243b);
                        bundle10.putCharSequenceArray("choices", null);
                        bundle10.putBoolean("allowFreeFormInput", c2041t.f7244c);
                        bundle10.putBundle("extras", c2041t.f7245d);
                        Set set = c2041t.f7246e;
                        if (set != null && !set.isEmpty()) {
                            ArrayList<String> arrayList4 = new ArrayList<>(set.size());
                            Iterator it3 = set.iterator();
                            while (it3.hasNext()) {
                                arrayList4.add((String) it3.next());
                            }
                            bundle10.putStringArrayList("allowedDataTypes", arrayList4);
                        }
                        bundleArr[i11] = bundle10;
                        i11++;
                        c2041tArr2 = c2041tArr3;
                        str5 = str6;
                    }
                    str4 = str5;
                }
                bundle8.putParcelableArray("remoteInputs", bundleArr);
                bundle8.putBoolean("showsUserInterface", c2029h2.f7188e);
                bundle8.putInt("semanticAction", c2029h2.f7189f);
                bundle7.putBundle(string, bundle8);
                i10++;
                i5 = 0;
                arrayList3 = arrayList;
                str = str3;
                str5 = str4;
                bundleArr = null;
            }
            str2 = str5;
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (c2031j.f7213o == null) {
                c2031j.f7213o = new Bundle();
            }
            c2031j.f7213o.putBundle("android.car.EXTENSIONS", bundle5);
            c1100c = this;
            ((Bundle) c1100c.f3801h).putBundle("android.car.EXTENSIONS", bundle6);
        } else {
            str2 = str5;
        }
        int i12 = Build.VERSION.SDK_INT;
        ((Notification.Builder) c1100c.f3799f).setExtras(c2031j.f7213o).setRemoteInputHistory(null);
        ((Notification.Builder) c1100c.f3799f).setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(str2)) {
            ((Notification.Builder) c1100c.f3799f).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it4 = c2031j.f7201c.iterator();
        if (it4.hasNext()) {
            AbstractC0032g.m162t(it4.next());
            throw null;
        }
        if (i12 >= 29) {
            ((Notification.Builder) c1100c.f3799f).setAllowSystemGeneratedContextualActions(c2031j.f7217s);
            ((Notification.Builder) c1100c.f3799f).setBubbleMetadata(null);
        }
    }

    public C1100C(C1865e c1865e) {
        this.f3798e = 7;
        this.f3799f = new ArrayList();
        this.f3800g = new C1903b();
        this.f3801h = c1865e;
    }

    public C1100C(C0259m c0259m, Bundle bundle, C0261o c0261o) {
        this.f3798e = 1;
        this.f3801h = c0259m;
        this.f3799f = bundle;
        this.f3800g = c0261o;
    }

    public C1100C(AbstractC0721l abstractC0721l) {
        this.f3798e = 5;
        this.f3800g = new ArrayList();
        this.f3801h = new HashMap();
        this.f3799f = abstractC0721l;
    }
}
