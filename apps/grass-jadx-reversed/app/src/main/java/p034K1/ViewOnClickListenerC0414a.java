package p034K1;

import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: K1.a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0414a implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f942e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ AbstractC0431r f943f;

    public /* synthetic */ ViewOnClickListenerC0414a(AbstractC0431r abstractC0431r, int i3) {
        this.f942e = i3;
        this.f943f = abstractC0431r;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f942e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0418e c0418e = (C0418e) this.f943f;
                EditText editText = c0418e.f954i;
                if (editText != null) {
                    Editable text = editText.getText();
                    if (text != null) {
                        text.clear();
                    }
                    c0418e.m956q();
                    break;
                }
                break;
            case 1:
                ((C0425l) this.f943f).m934u();
                break;
            default:
                C0438y c0438y = (C0438y) this.f943f;
                EditText editText2 = c0438y.f1062f;
                if (editText2 != null) {
                    int selectionEnd = editText2.getSelectionEnd();
                    EditText editText3 = c0438y.f1062f;
                    if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        c0438y.f1062f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    } else {
                        c0438y.f1062f.setTransformationMethod(null);
                    }
                    if (selectionEnd >= 0) {
                        c0438y.f1062f.setSelection(selectionEnd);
                    }
                    c0438y.m956q();
                    break;
                }
                break;
        }
    }
}
