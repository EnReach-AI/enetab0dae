package io.getgrass.www;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: io.getgrass.www.b */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC1455b implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5238e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ JsResult f5239f;

    public /* synthetic */ DialogInterfaceOnClickListenerC1455b(JsResult jsResult, int i3) {
        this.f5238e = i3;
        this.f5239f = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        JsResult jsResult = this.f5239f;
        switch (this.f5238e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i4 = RustWebChromeClient.f5206f;
                AbstractC1766e.m3920e("$result", jsResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsResult.confirm();
                break;
            case 1:
                int i5 = RustWebChromeClient.f5206f;
                AbstractC1766e.m3920e("$result", jsResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsResult.cancel();
                break;
            case 2:
                int i6 = RustWebChromeClient.f5206f;
                AbstractC1766e.m3920e("$result", jsResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsResult.confirm();
                break;
            default:
                int i7 = RustWebChromeClient.f5206f;
                JsPromptResult jsPromptResult = (JsPromptResult) jsResult;
                AbstractC1766e.m3920e("$result", jsPromptResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsPromptResult.cancel();
                break;
        }
    }
}
