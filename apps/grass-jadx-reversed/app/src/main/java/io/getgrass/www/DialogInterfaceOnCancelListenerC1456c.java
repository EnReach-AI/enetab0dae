package io.getgrass.www;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: io.getgrass.www.c */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnCancelListenerC1456c implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5240e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ JsResult f5241f;

    public /* synthetic */ DialogInterfaceOnCancelListenerC1456c(JsResult jsResult, int i3) {
        this.f5240e = i3;
        this.f5241f = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        JsResult jsResult = this.f5241f;
        switch (this.f5240e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i3 = RustWebChromeClient.f5206f;
                AbstractC1766e.m3920e("$result", jsResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsResult.cancel();
                break;
            case 1:
                int i4 = RustWebChromeClient.f5206f;
                AbstractC1766e.m3920e("$result", jsResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsResult.cancel();
                break;
            default:
                int i5 = RustWebChromeClient.f5206f;
                JsPromptResult jsPromptResult = (JsPromptResult) jsResult;
                AbstractC1766e.m3920e("$result", jsPromptResult);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                jsPromptResult.cancel();
                break;
        }
    }
}
