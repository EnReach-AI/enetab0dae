package p079a2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import p119m2.AbstractC1766e;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: a2.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0861f {

    /* JADX INFO: renamed from: a */
    public final SharedPreferences f2540a;

    public C0861f(Context context) {
        C0862g c0862g = C0862g.f2541f;
        AbstractC1766e.m3920e("context", context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(c0862g.f2542e, 0);
        AbstractC1766e.m3919d("getSharedPreferences(...)", sharedPreferences);
        this.f2540a = sharedPreferences;
    }

    /* JADX INFO: renamed from: a */
    public String m2188a(String str) {
        Log.d(toString(), "Getting value for key: ".concat(str));
        return this.f2540a.getString(str, null);
    }

    /* JADX INFO: renamed from: b */
    public void m2189b(String str, String str2) {
        Log.d(toString(), "Setting value for key: ".concat(str));
        SharedPreferences.Editor editorEdit = this.f2540a.edit();
        AbstractC1766e.m3917b(editorEdit);
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public C0861f() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        this.f2540a = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
    }
}
