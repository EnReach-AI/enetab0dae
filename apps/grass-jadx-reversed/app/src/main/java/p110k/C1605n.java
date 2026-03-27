package p110k;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AbstractC1117n;
import com.facebook.C1124u;
import java.util.HashSet;
import java.util.UUID;
import java.util.WeakHashMap;
import p015D2.C0181e;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;
import p166z0.AbstractC2069g;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1605n {

    /* JADX INFO: renamed from: a */
    public int f5693a;

    /* JADX INFO: renamed from: b */
    public final Object f5694b;

    /* JADX INFO: renamed from: c */
    public Object f5695c;

    /* JADX INFO: renamed from: d */
    public Object f5696d;

    /* JADX INFO: renamed from: e */
    public Object f5697e;

    /* JADX INFO: renamed from: f */
    public Object f5698f;

    public C1605n(View view) {
        this.f5693a = -1;
        this.f5694b = view;
        this.f5695c = C1613r.m3680a();
    }

    /* JADX INFO: renamed from: b */
    public static void m3667b() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h).edit();
        editorEdit.remove("com.facebook.appevents.SessionInfo.sessionStartTime");
        editorEdit.remove("com.facebook.appevents.SessionInfo.sessionEndTime");
        editorEdit.remove("com.facebook.appevents.SessionInfo.interruptionCount");
        editorEdit.remove("com.facebook.appevents.SessionInfo.sessionId");
        editorEdit.apply();
        AbstractC2069g.m4584h();
        SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h).edit();
        editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        editorEdit2.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        editorEdit2.apply();
    }

    /* JADX INFO: renamed from: c */
    public static C1605n m3668c() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h);
        long j2 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionStartTime", 0L);
        long j3 = defaultSharedPreferences.getLong("com.facebook.appevents.SessionInfo.sessionEndTime", 0L);
        C0181e c0181e = null;
        String string = defaultSharedPreferences.getString("com.facebook.appevents.SessionInfo.sessionId", null);
        if (j2 == 0 || j3 == 0 || string == null) {
            return null;
        }
        C1605n c1605n = new C1605n(Long.valueOf(j2), Long.valueOf(j3));
        c1605n.f5693a = defaultSharedPreferences.getInt("com.facebook.appevents.SessionInfo.interruptionCount", 0);
        AbstractC2069g.m4584h();
        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h);
        if (defaultSharedPreferences2.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
            String string2 = defaultSharedPreferences2.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null);
            boolean z3 = defaultSharedPreferences2.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false);
            c0181e = new C0181e();
            c0181e.f423c = string2;
            c0181e.f422b = z3;
        }
        c1605n.f5697e = c0181e;
        c1605n.f5696d = Long.valueOf(System.currentTimeMillis());
        c1605n.f5698f = UUID.fromString(string);
        return c1605n;
    }

    /* JADX INFO: renamed from: a */
    public void m3669a() {
        View view = (View) this.f5694b;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((C1124u) this.f5696d) != null) {
                if (((C1124u) this.f5698f) == null) {
                    this.f5698f = new C1124u();
                }
                C1124u c1124u = (C1124u) this.f5698f;
                c1124u.f3898g = null;
                c1124u.f3897f = false;
                c1124u.f3899h = null;
                c1124u.f3896e = false;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                ColorStateList colorStateListM634g = AbstractC0313H.m634g(view);
                if (colorStateListM634g != null) {
                    c1124u.f3897f = true;
                    c1124u.f3898g = colorStateListM634g;
                }
                PorterDuff.Mode modeM635h = AbstractC0313H.m635h(view);
                if (modeM635h != null) {
                    c1124u.f3896e = true;
                    c1124u.f3899h = modeM635h;
                }
                if (c1124u.f3897f || c1124u.f3896e) {
                    C1613r.m3682d(background, c1124u, view.getDrawableState());
                    return;
                }
            }
            C1124u c1124u2 = (C1124u) this.f5697e;
            if (c1124u2 != null) {
                C1613r.m3682d(background, c1124u2, view.getDrawableState());
                return;
            }
            C1124u c1124u3 = (C1124u) this.f5696d;
            if (c1124u3 != null) {
                C1613r.m3682d(background, c1124u3, view.getDrawableState());
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public ColorStateList m3670d() {
        C1124u c1124u = (C1124u) this.f5697e;
        if (c1124u != null) {
            return (ColorStateList) c1124u.f3898g;
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public PorterDuff.Mode m3671e() {
        C1124u c1124u = (C1124u) this.f5697e;
        if (c1124u != null) {
            return (PorterDuff.Mode) c1124u.f3899h;
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public void m3672f(AttributeSet attributeSet, int i3) {
        ColorStateList colorStateListM3585h;
        View view = (View) this.f5694b;
        Context context = view.getContext();
        int[] iArr = AbstractC1343a.f4802z;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, i3, 0);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        View view2 = (View) this.f5694b;
        AbstractC0323S.m700j(view2, view2.getContext(), iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, i3);
        try {
            if (typedArray.hasValue(0)) {
                this.f5693a = typedArray.getResourceId(0, -1);
                C1613r c1613r = (C1613r) this.f5695c;
                Context context2 = view.getContext();
                int i4 = this.f5693a;
                synchronized (c1613r) {
                    colorStateListM3585h = c1613r.f5723a.m3585h(context2, i4);
                }
                if (colorStateListM3585h != null) {
                    m3675i(colorStateListM3585h);
                }
            }
            if (typedArray.hasValue(1)) {
                AbstractC0313H.m644q(view, c2071iM4591v.m4600j(1));
            }
            if (typedArray.hasValue(2)) {
                AbstractC0313H.m645r(view, AbstractC1589g0.m3652b(typedArray.getInt(2, -1), null));
            }
            c2071iM4591v.m4608x();
        } catch (Throwable th) {
            c2071iM4591v.m4608x();
            throw th;
        }
    }

    /* JADX INFO: renamed from: g */
    public void m3673g() {
        this.f5693a = -1;
        m3675i(null);
        m3669a();
    }

    /* JADX INFO: renamed from: h */
    public void m3674h(int i3) {
        ColorStateList colorStateListM3585h;
        this.f5693a = i3;
        C1613r c1613r = (C1613r) this.f5695c;
        if (c1613r != null) {
            Context context = ((View) this.f5694b).getContext();
            synchronized (c1613r) {
                colorStateListM3585h = c1613r.f5723a.m3585h(context, i3);
            }
        } else {
            colorStateListM3585h = null;
        }
        m3675i(colorStateListM3585h);
        m3669a();
    }

    /* JADX INFO: renamed from: i */
    public void m3675i(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((C1124u) this.f5696d) == null) {
                this.f5696d = new C1124u();
            }
            C1124u c1124u = (C1124u) this.f5696d;
            c1124u.f3898g = colorStateList;
            c1124u.f3897f = true;
        } else {
            this.f5696d = null;
        }
        m3669a();
    }

    /* JADX INFO: renamed from: j */
    public void m3676j(ColorStateList colorStateList) {
        if (((C1124u) this.f5697e) == null) {
            this.f5697e = new C1124u();
        }
        C1124u c1124u = (C1124u) this.f5697e;
        c1124u.f3898g = colorStateList;
        c1124u.f3897f = true;
        m3669a();
    }

    /* JADX INFO: renamed from: k */
    public void m3677k(PorterDuff.Mode mode) {
        if (((C1124u) this.f5697e) == null) {
            this.f5697e = new C1124u();
        }
        C1124u c1124u = (C1124u) this.f5697e;
        c1124u.f3899h = mode;
        c1124u.f3896e = true;
        m3669a();
    }

    /* JADX INFO: renamed from: l */
    public void m3678l() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h).edit();
        editorEdit.putLong("com.facebook.appevents.SessionInfo.sessionStartTime", ((Long) this.f5694b).longValue());
        editorEdit.putLong("com.facebook.appevents.SessionInfo.sessionEndTime", ((Long) this.f5695c).longValue());
        editorEdit.putInt("com.facebook.appevents.SessionInfo.interruptionCount", this.f5693a);
        editorEdit.putString("com.facebook.appevents.SessionInfo.sessionId", ((UUID) this.f5698f).toString());
        editorEdit.apply();
        C0181e c0181e = (C0181e) this.f5697e;
        if (c0181e != null) {
            c0181e.getClass();
            AbstractC2069g.m4584h();
            SharedPreferences.Editor editorEdit2 = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h).edit();
            editorEdit2.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", (String) c0181e.f423c);
            editorEdit2.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", c0181e.f422b);
            editorEdit2.apply();
        }
    }

    public C1605n(Long l3, Long l4) {
        UUID uuidRandomUUID = UUID.randomUUID();
        this.f5694b = l3;
        this.f5695c = l4;
        this.f5698f = uuidRandomUUID;
    }
}
