package app.tauri.clipboard;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import app.tauri.annotation.Command;
import app.tauri.annotation.TauriPlugin;
import app.tauri.clipboard.ReadClipData;
import app.tauri.clipboard.WriteOptions;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.Plugin;
import p042N0.AbstractC0546n;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin
public final class ClipboardPlugin extends Plugin {

    /* JADX INFO: renamed from: d */
    public final ClipboardManager f3482d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardPlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        Object systemService = activity.getSystemService("clipboard");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.content.ClipboardManager", systemService);
        this.f3482d = (ClipboardManager) systemService;
    }

    @Command
    public final void clear(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        ClipboardManager clipboardManager = this.f3482d;
        if (clipboardManager.hasPrimaryClip()) {
            clipboardManager.clearPrimaryClip();
        }
        invoke.m2682c();
    }

    @Command
    public final void readText(Invoke invoke) throws AbstractC0546n {
        AbstractC1766e.m3920e("invoke", invoke);
        ClipboardManager clipboardManager = this.f3482d;
        if (!clipboardManager.hasPrimaryClip()) {
            invoke.m2681b("Clipboard is empty");
            return;
        }
        ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
        if (primaryClipDescription == null || !primaryClipDescription.hasMimeType("text/plain")) {
            invoke.m2681b("Clipboard content reader not implemented");
            return;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        AbstractC1766e.m3917b(primaryClip);
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        AbstractC1766e.m3919d("getItemAt(...)", itemAt);
        ReadClipData.PlainText plainText = new ReadClipData.PlainText(null);
        String string = itemAt.getText().toString();
        AbstractC1766e.m3920e("<set-?>", string);
        plainText.f3483a = string;
        invoke.m2684e(plainText);
    }

    @Command
    public final void writeText(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        WriteOptions writeOptions = (WriteOptions) invoke.m2680a(WriteOptions.class);
        if (!(writeOptions instanceof WriteOptions.PlainText)) {
            invoke.m2681b("unimplemented WriteOptions");
            return;
        }
        WriteOptions.PlainText plainText = (WriteOptions.PlainText) writeOptions;
        this.f3482d.setPrimaryClip(ClipData.newPlainText(plainText.getLabel(), plainText.getText()));
        invoke.m2682c();
    }
}
