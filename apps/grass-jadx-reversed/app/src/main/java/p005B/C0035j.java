package p005B;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v4.media.session.AbstractC0864a;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p001A.C0006g;
import p001A.C0007h;
import p021G.C0233j;
import p117m0.AbstractC1717l;

/* JADX INFO: renamed from: B.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0035j extends AbstractC0864a {

    /* JADX INFO: renamed from: h */
    public static Class f90h = null;

    /* JADX INFO: renamed from: i */
    public static Constructor f91i = null;

    /* JADX INFO: renamed from: j */
    public static Method f92j = null;

    /* JADX INFO: renamed from: k */
    public static Method f93k = null;

    /* JADX INFO: renamed from: l */
    public static boolean f94l = false;

    /* JADX INFO: renamed from: a */
    public final Class f95a;

    /* JADX INFO: renamed from: b */
    public final Constructor f96b;

    /* JADX INFO: renamed from: c */
    public final Method f97c;

    /* JADX INFO: renamed from: d */
    public final Method f98d;

    /* JADX INFO: renamed from: e */
    public final Method f99e;

    /* JADX INFO: renamed from: f */
    public final Method f100f;

    /* JADX INFO: renamed from: g */
    public final Method f101g;

    public C0035j() throws NoSuchMethodException {
        Method methodM185t;
        Constructor<?> constructor;
        Method methodM174s;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodM174s = m174s(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodM185t = m185t(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e3.getClass().getName()), e3);
            methodM185t = null;
            constructor = null;
            methodM174s = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f95a = cls;
        this.f96b = constructor;
        this.f97c = methodM174s;
        this.f98d = method;
        this.f99e = method2;
        this.f100f = method3;
        this.f101g = methodM185t;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m172l(Object obj, String str, int i3, boolean z3) throws NoSuchMethodException {
        m173p();
        try {
            return ((Boolean) f92j.invoke(obj, str, Integer.valueOf(i3), Boolean.valueOf(z3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m173p() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f94l) {
            return;
        }
        f94l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            Log.e("TypefaceCompatApi21Impl", e3.getClass().getName(), e3);
            method = null;
            cls = null;
            method2 = null;
        }
        f91i = constructor;
        f90h = cls;
        f92j = method2;
        f93k = method;
    }

    /* JADX INFO: renamed from: s */
    public static Method m174s(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: d */
    public final Typeface mo175d(Context context, C0006g c0006g, Resources resources, int i3) {
        if (!m183q()) {
            return m181n(context, c0006g, resources, i3);
        }
        Object objM184r = m184r();
        if (objM184r == null) {
            return null;
        }
        for (C0007h c0007h : c0006g.f18a) {
            if (!m179k(context, objM184r, c0007h.f19a, c0007h.f23e, c0007h.f20b, c0007h.f21c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0007h.f22d))) {
                m178j(objM184r);
                return null;
            }
        }
        if (m182o(objM184r)) {
            return m180m(objM184r);
        }
        return null;
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: e */
    public final Typeface mo176e(Context context, C0233j[] c0233jArr, int i3) {
        Typeface typefaceM180m;
        boolean zBooleanValue;
        if (c0233jArr.length < 1) {
            return null;
        }
        if (!m183q()) {
            C0233j c0233jMo188g = mo188g(c0233jArr, i3);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c0233jMo188g.f558a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(c0233jMo188g.f560c).setItalic(c0233jMo188g.f561d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap map = new HashMap();
        for (C0233j c0233j : c0233jArr) {
            if (c0233j.f562e == 0) {
                Uri uri = c0233j.f558a;
                if (!map.containsKey(uri)) {
                    map.put(uri, AbstractC1717l.m3804g(context, uri));
                }
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Object objM184r = m184r();
        if (objM184r == null) {
            return null;
        }
        int length = c0233jArr.length;
        int i4 = 0;
        boolean z3 = false;
        while (i4 < length) {
            C0233j c0233j2 = c0233jArr[i4];
            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(c0233j2.f558a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.f98d.invoke(objM184r, byteBuffer, Integer.valueOf(c0233j2.f559b), null, Integer.valueOf(c0233j2.f560c), Integer.valueOf(c0233j2.f561d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    m178j(objM184r);
                    return null;
                }
                z3 = true;
            }
            i4++;
            z3 = z3;
        }
        if (!z3) {
            m178j(objM184r);
            return null;
        }
        if (m182o(objM184r) && (typefaceM180m = m180m(objM184r)) != null) {
            return Typeface.create(typefaceM180m, i3);
        }
        return null;
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: f */
    public final Typeface mo177f(Context context, Resources resources, int i3, String str, int i4) {
        if (!m183q()) {
            return super.mo177f(context, resources, i3, str, i4);
        }
        Object objM184r = m184r();
        if (objM184r == null) {
            return null;
        }
        if (!m179k(context, objM184r, str, 0, -1, -1, null)) {
            m178j(objM184r);
            return null;
        }
        if (m182o(objM184r)) {
            return m180m(objM184r);
        }
        return null;
    }

    /* JADX INFO: renamed from: j */
    public final void m178j(Object obj) {
        try {
            this.f100f.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* JADX INFO: renamed from: k */
    public final boolean m179k(Context context, Object obj, String str, int i3, int i4, int i5, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f97c.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: m */
    public final Typeface m180m(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f95a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f101g.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: renamed from: n */
    public final Typeface m181n(Context context, C0006g c0006g, Resources resources, int i3) throws NoSuchMethodException {
        m173p();
        try {
            Object objNewInstance = f91i.newInstance(null);
            for (C0007h c0007h : c0006g.f18a) {
                File fileM3803f = AbstractC1717l.m3803f(context);
                if (fileM3803f == null) {
                    return null;
                }
                try {
                    if (!AbstractC1717l.m3800c(fileM3803f, resources, c0007h.f24f)) {
                        return null;
                    }
                    if (!m172l(objNewInstance, fileM3803f.getPath(), c0007h.f20b, c0007h.f21c)) {
                        return null;
                    }
                    fileM3803f.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileM3803f.delete();
                }
            }
            m173p();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f90h, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f93k.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX INFO: renamed from: o */
    public final boolean m182o(Object obj) {
        try {
            return ((Boolean) this.f99e.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: q */
    public final boolean m183q() {
        Method method = this.f97c;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    /* JADX INFO: renamed from: r */
    public final Object m184r() {
        try {
            return this.f96b.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: t */
    public final Method m185t(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, String.class, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
