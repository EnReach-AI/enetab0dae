package p055S;

import android.text.Editable;
import androidx.emoji2.text.C0912s;

/* JADX INFO: renamed from: S.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0623a extends Editable.Factory {

    /* JADX INFO: renamed from: a */
    public static final Object f1602a = new Object();

    /* JADX INFO: renamed from: b */
    public static volatile C0623a f1603b;

    /* JADX INFO: renamed from: c */
    public static Class f1604c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f1604c;
        return cls != null ? new C0912s(cls, charSequence) : super.newEditable(charSequence);
    }
}
