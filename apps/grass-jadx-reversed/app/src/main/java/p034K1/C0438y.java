package p034K1;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import io.getgrass.www.R;

/* JADX INFO: renamed from: K1.y */
/* JADX INFO: loaded from: classes.dex */
public final class C0438y extends AbstractC0431r {

    /* JADX INFO: renamed from: e */
    public final int f1061e;

    /* JADX INFO: renamed from: f */
    public EditText f1062f;

    /* JADX INFO: renamed from: g */
    public final ViewOnClickListenerC0414a f1063g;

    public C0438y(C0430q c0430q, int i3) {
        super(c0430q);
        this.f1061e = R.drawable.design_password_eye;
        this.f1063g = new ViewOnClickListenerC0414a(this, 2);
        if (i3 != 0) {
            this.f1061e = i3;
        }
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: b */
    public final void mo954b() {
        m956q();
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: c */
    public final int mo915c() {
        return R.string.password_toggle_content_description;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: d */
    public final int mo916d() {
        return this.f1061e;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: f */
    public final View.OnClickListener mo918f() {
        return this.f1063g;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: k */
    public final boolean mo955k() {
        return true;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: l */
    public final boolean mo930l() {
        EditText editText = this.f1062f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: m */
    public final void mo920m(EditText editText) {
        this.f1062f = editText;
        m956q();
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: r */
    public final void mo922r() {
        EditText editText = this.f1062f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f1062f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: s */
    public final void mo923s() {
        EditText editText = this.f1062f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
