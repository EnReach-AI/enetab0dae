package p129p0;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.inputmethod.EditorInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p033K0.AbstractC0406d;
import p069X0.AbstractC0721l;
import p082b1.InterfaceC1027X;
import p102h0.AbstractC1405e;
import p114l1.C1674p;
import p119m2.AbstractC1766e;
import p146t2.EnumC1924c;

/* JADX INFO: renamed from: p0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1822d {
    /* JADX INFO: renamed from: a */
    public static final double m4047a(double d, EnumC1924c enumC1924c, EnumC1924c enumC1924c2) {
        AbstractC1766e.m3920e("targetUnit", enumC1924c2);
        long jConvert = enumC1924c2.f6740e.convert(1L, enumC1924c.f6740e);
        return jConvert > 0 ? d * jConvert : d / r8.convert(1L, r9);
    }

    /* JADX INFO: renamed from: b */
    public static InvocationHandler m4048b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, AbstractC1405e.m3415b()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
    
        if ((r5 % 10) != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0082, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #6 {all -> 0x010f, blocks: (B:5:0x000c, B:7:0x0010, B:19:0x0033, B:47:0x008a, B:57:0x00a5, B:67:0x00c0, B:77:0x00da, B:91:0x0107, B:75:0x00d4, B:65:0x00ba, B:55:0x009f, B:45:0x0084, B:17:0x002d, B:70:0x00ca, B:22:0x003d, B:27:0x0056, B:29:0x005b, B:34:0x0068, B:36:0x006c, B:38:0x0072, B:41:0x0078, B:42:0x007e, B:80:0x00e4, B:83:0x00ee, B:85:0x00f4, B:88:0x00fb, B:60:0x00af, B:11:0x001b, B:14:0x0025, B:50:0x0094), top: B:113:0x000c, inners: #0, #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5 A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #6 {all -> 0x010f, blocks: (B:5:0x000c, B:7:0x0010, B:19:0x0033, B:47:0x008a, B:57:0x00a5, B:67:0x00c0, B:77:0x00da, B:91:0x0107, B:75:0x00d4, B:65:0x00ba, B:55:0x009f, B:45:0x0084, B:17:0x002d, B:70:0x00ca, B:22:0x003d, B:27:0x0056, B:29:0x005b, B:34:0x0068, B:36:0x006c, B:38:0x0072, B:41:0x0078, B:42:0x007e, B:80:0x00e4, B:83:0x00ee, B:85:0x00f4, B:88:0x00fb, B:60:0x00af, B:11:0x001b, B:14:0x0025, B:50:0x0094), top: B:113:0x000c, inners: #0, #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0 A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #6 {all -> 0x010f, blocks: (B:5:0x000c, B:7:0x0010, B:19:0x0033, B:47:0x008a, B:57:0x00a5, B:67:0x00c0, B:77:0x00da, B:91:0x0107, B:75:0x00d4, B:65:0x00ba, B:55:0x009f, B:45:0x0084, B:17:0x002d, B:70:0x00ca, B:22:0x003d, B:27:0x0056, B:29:0x005b, B:34:0x0068, B:36:0x006c, B:38:0x0072, B:41:0x0078, B:42:0x007e, B:80:0x00e4, B:83:0x00ee, B:85:0x00f4, B:88:0x00fb, B:60:0x00af, B:11:0x001b, B:14:0x0025, B:50:0x0094), top: B:113:0x000c, inners: #0, #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #6 {all -> 0x010f, blocks: (B:5:0x000c, B:7:0x0010, B:19:0x0033, B:47:0x008a, B:57:0x00a5, B:67:0x00c0, B:77:0x00da, B:91:0x0107, B:75:0x00d4, B:65:0x00ba, B:55:0x009f, B:45:0x0084, B:17:0x002d, B:70:0x00ca, B:22:0x003d, B:27:0x0056, B:29:0x005b, B:34:0x0068, B:36:0x006c, B:38:0x0072, B:41:0x0078, B:42:0x007e, B:80:0x00e4, B:83:0x00ee, B:85:0x00f4, B:88:0x00fb, B:60:0x00af, B:11:0x001b, B:14:0x0025, B:50:0x0094), top: B:113:0x000c, inners: #0, #1, #2, #3, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4049c(android.view.View r9) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p129p0.AbstractC1822d.m4049c(android.view.View):boolean");
    }

    /* JADX INFO: renamed from: d */
    public static ParameterizedType m4050d(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return m4050d(upperBounds[0]);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public static TypeVariable m4051e(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return m4051e(upperBounds[0]);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m4052f(InterfaceC1027X interfaceC1027X, AbstractC0721l abstractC0721l, Type type) {
        if (!abstractC0721l.m1891z(interfaceC1027X.mo42b(type).f2036e)) {
            return false;
        }
        ParameterizedType parameterizedTypeM4050d = m4050d(type);
        if (parameterizedTypeM4050d == null) {
            return true;
        }
        if (!Objects.equals(abstractC0721l.f2036e, parameterizedTypeM4050d.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = parameterizedTypeM4050d.getActualTypeArguments();
        C1674p c1674pMo1873h = abstractC0721l.mo1873h();
        if (c1674pMo1873h.f5929f.length != actualTypeArguments.length) {
            return false;
        }
        for (int i3 = 0; i3 < c1674pMo1873h.f5929f.length; i3++) {
            if (!m4052f(interfaceC1027X, c1674pMo1873h.m3764d(i3), actualTypeArguments[i3])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static void m4053g(String str) {
        try {
            Long lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
            StringBuffer stringBuffer = new StringBuffer("error_log_");
            stringBuffer.append(lValueOf);
            stringBuffer.append(".json");
            String string = stringBuffer.toString();
            if (str != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("timestamp", lValueOf);
                    jSONObject.put("error_message", str);
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                AbstractC0406d.m906p(string, jSONObject != null ? jSONObject.toString() : null);
            }
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m4054h(EditorInfo editorInfo, CharSequence charSequence, int i3, int i4) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i3);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i4);
    }
}
