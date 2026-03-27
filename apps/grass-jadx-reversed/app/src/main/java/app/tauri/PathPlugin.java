package app.tauri;

import android.app.Activity;
import android.os.Environment;
import app.tauri.annotation.Command;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.JSObject;
import app.tauri.plugin.Plugin;
import java.io.File;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin
public final class PathPlugin extends Plugin {

    /* JADX INFO: renamed from: d */
    public final Activity f3476d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PathPlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        this.f3476d = activity;
    }

    /* JADX INFO: renamed from: f */
    public static void m2658f(Invoke invoke, String str) {
        JSObject jSObject = new JSObject();
        jSObject.put("path", str);
        invoke.m2683d(jSObject);
    }

    @Command
    public final void getAudioDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalFilesDir = this.f3476d.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        m2658f(invoke, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    @Command
    public final void getCacheDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        m2658f(invoke, this.f3476d.getCacheDir().getAbsolutePath());
    }

    @Command
    public final void getConfigDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        m2658f(invoke, this.f3476d.getDataDir().getAbsolutePath());
    }

    @Command
    public final void getDataDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        m2658f(invoke, this.f3476d.getDataDir().getAbsolutePath());
    }

    @Command
    public final void getDocumentDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalFilesDir = this.f3476d.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        m2658f(invoke, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    @Command
    public final void getDownloadDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalFilesDir = this.f3476d.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        m2658f(invoke, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    @Command
    public final void getExternalCacheDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalCacheDir = this.f3476d.getExternalCacheDir();
        m2658f(invoke, externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    @app.tauri.annotation.Command
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getFileNameFromUri(app.tauri.plugin.Invoke r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "invoke"
            p119m2.AbstractC1766e.m3920e(r0, r10)
            X0.y r0 = r10.f3536f
            java.lang.String r1 = r10.f3535e
            java.lang.Class<app.tauri.GetFileNameFromUriArgs> r2 = app.tauri.GetFileNameFromUriArgs.class
            java.lang.Object r0 = r0.m1918k(r2, r1)
            app.tauri.GetFileNameFromUriArgs r0 = (app.tauri.GetFileNameFromUriArgs) r0
            java.lang.String r0 = r0.getUri()
            android.net.Uri r2 = android.net.Uri.parse(r0)
            java.lang.String r0 = "parse(...)"
            p119m2.AbstractC1766e.m3919d(r0, r2)
            java.lang.String r0 = "_display_name"
            java.lang.String r7 = "failed to get real name from URI "
            android.app.Activity r1 = r9.f3476d
            java.lang.String r3 = "activity"
            p119m2.AbstractC1766e.m3920e(r3, r1)
            r8 = 0
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            if (r1 == 0) goto L52
            int r0 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
            if (r2 == 0) goto L52
            java.lang.String r8 = r1.getString(r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L50
        L49:
            r1.close()
            goto L72
        L4d:
            r10 = move-exception
            r8 = r1
            goto L80
        L50:
            r0 = move-exception
            goto L59
        L52:
            if (r1 == 0) goto L72
            goto L49
        L55:
            r10 = move-exception
            goto L80
        L57:
            r0 = move-exception
            r1 = r8
        L59:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4d
            r2.append(r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = "message"
            p119m2.AbstractC1766e.m3920e(r2, r0)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = "Tauri"
            app.tauri.Logger.Companion.m2656a(r2, r0)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L72
            goto L49
        L72:
            app.tauri.plugin.JSObject r0 = new app.tauri.plugin.JSObject
            r0.<init>()
            java.lang.String r1 = "name"
            r0.put(r1, r8)
            r10.m2683d(r0)
            return
        L80:
            if (r8 == 0) goto L85
            r8.close()
        L85:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: app.tauri.PathPlugin.getFileNameFromUri(app.tauri.plugin.Invoke):void");
    }

    @Command
    public final void getHomeDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        m2658f(invoke, Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    @Command
    public final void getPictureDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalFilesDir = this.f3476d.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        m2658f(invoke, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    @Command
    public final void getPublicDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalFilesDir = this.f3476d.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        m2658f(invoke, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    @Command
    public final void getResourcesDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        m2658f(invoke, "asset://localhost/");
    }

    @Command
    public final void getVideoDir(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        File externalCacheDir = this.f3476d.getExternalCacheDir();
        m2658f(invoke, externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null);
    }
}
