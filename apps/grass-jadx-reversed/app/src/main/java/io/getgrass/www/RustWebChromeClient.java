package io.getgrass.www;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.activity.result.C0881b;
import androidx.activity.result.C0883d;
import androidx.activity.result.InterfaceC0882c;
import androidx.core.content.FileProvider;
import androidx.fragment.app.C0955z;
import io.getgrass.www.Logger;
import io.getgrass.www.RustWebChromeClient;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p086c2.AbstractC1086e;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;
import p165z.C2051g;

/* JADX INFO: loaded from: classes.dex */
public final class RustWebChromeClient extends WebChromeClient {

    /* JADX INFO: renamed from: f */
    public static final /* synthetic */ int f5206f = 0;

    /* JADX INFO: renamed from: a */
    public final WryActivity f5207a;

    /* JADX INFO: renamed from: b */
    public final C0883d f5208b;

    /* JADX INFO: renamed from: c */
    public final C0883d f5209c;

    /* JADX INFO: renamed from: d */
    public PermissionListener f5210d;

    /* JADX INFO: renamed from: e */
    public ActivityResultListener f5211e;

    public interface ActivityResultListener {
        /* JADX INFO: renamed from: a */
        void mo3472a(C0881b c0881b);
    }

    public interface PermissionListener {
        /* JADX INFO: renamed from: a */
        void mo3473a(Boolean bool);
    }

    public RustWebChromeClient(WryActivity wryActivity) {
        AbstractC1766e.m3920e("appActivity", wryActivity);
        this.f5207a = wryActivity;
        final int i3 = 0;
        this.f5208b = wryActivity.m2204j(new C0955z(1), new InterfaceC0882c(this) { // from class: io.getgrass.www.d

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ RustWebChromeClient f5243f;

            {
                this.f5243f = this;
            }

            @Override // androidx.activity.result.InterfaceC0882c
            /* JADX INFO: renamed from: j */
            public final void mo449j(Object obj) {
                RustWebChromeClient rustWebChromeClient = this.f5243f;
                switch (i3) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        Map map = (Map) obj;
                        int i4 = RustWebChromeClient.f5206f;
                        AbstractC1766e.m3920e("this$0", rustWebChromeClient);
                        AbstractC1766e.m3920e("isGranted", map);
                        if (rustWebChromeClient.f5210d != null) {
                            Iterator it = map.entrySet().iterator();
                            boolean z3 = true;
                            while (it.hasNext()) {
                                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                                    z3 = false;
                                }
                            }
                            RustWebChromeClient.PermissionListener permissionListener = rustWebChromeClient.f5210d;
                            AbstractC1766e.m3917b(permissionListener);
                            permissionListener.mo3473a(Boolean.valueOf(z3));
                        }
                        break;
                    default:
                        C0881b c0881b = (C0881b) obj;
                        int i5 = RustWebChromeClient.f5206f;
                        AbstractC1766e.m3920e("this$0", rustWebChromeClient);
                        RustWebChromeClient.ActivityResultListener activityResultListener = rustWebChromeClient.f5211e;
                        if (activityResultListener != null) {
                            activityResultListener.mo3472a(c0881b);
                        }
                        break;
                }
            }
        });
        final int i4 = 1;
        this.f5209c = wryActivity.m2204j(new C0955z(2), new InterfaceC0882c(this) { // from class: io.getgrass.www.d

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ RustWebChromeClient f5243f;

            {
                this.f5243f = this;
            }

            @Override // androidx.activity.result.InterfaceC0882c
            /* JADX INFO: renamed from: j */
            public final void mo449j(Object obj) {
                RustWebChromeClient rustWebChromeClient = this.f5243f;
                switch (i4) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        Map map = (Map) obj;
                        int i42 = RustWebChromeClient.f5206f;
                        AbstractC1766e.m3920e("this$0", rustWebChromeClient);
                        AbstractC1766e.m3920e("isGranted", map);
                        if (rustWebChromeClient.f5210d != null) {
                            Iterator it = map.entrySet().iterator();
                            boolean z3 = true;
                            while (it.hasNext()) {
                                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                                    z3 = false;
                                }
                            }
                            RustWebChromeClient.PermissionListener permissionListener = rustWebChromeClient.f5210d;
                            AbstractC1766e.m3917b(permissionListener);
                            permissionListener.mo3473a(Boolean.valueOf(z3));
                        }
                        break;
                    default:
                        C0881b c0881b = (C0881b) obj;
                        int i5 = RustWebChromeClient.f5206f;
                        AbstractC1766e.m3920e("this$0", rustWebChromeClient);
                        RustWebChromeClient.ActivityResultListener activityResultListener = rustWebChromeClient.f5211e;
                        if (activityResultListener != null) {
                            activityResultListener.mo3472a(c0881b);
                        }
                        break;
                }
            }
        });
    }

    private final native void handleReceivedTitle(WebView webView, String str);

    /* JADX INFO: renamed from: a */
    public final Uri m3469a() throws IOException {
        String strM153k = AbstractC0032g.m153k("JPEG_", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()), '_');
        String str = Environment.DIRECTORY_PICTURES;
        WryActivity wryActivity = this.f5207a;
        File fileCreateTempFile = File.createTempFile(strM153k, ".jpg", wryActivity.getExternalFilesDir(str));
        AbstractC1766e.m3919d("createTempFile(...)", fileCreateTempFile);
        C2051g c2051gM2314a = FileProvider.m2314a(wryActivity, wryActivity.getPackageName() + ".fileprovider");
        try {
            String canonicalPath = fileCreateTempFile.getCanonicalPath();
            Map.Entry entry = null;
            for (Map.Entry entry2 : c2051gM2314a.f7255b.entrySet()) {
                String path = ((File) entry2.getValue()).getPath();
                if (canonicalPath.startsWith(path) && (entry == null || path.length() > ((File) entry.getValue()).getPath().length())) {
                    entry = entry2;
                }
            }
            if (entry == null) {
                throw new IllegalArgumentException(AbstractC0032g.m152j("Failed to find configured root that contains ", canonicalPath));
            }
            String path2 = ((File) entry.getValue()).getPath();
            Uri uriBuild = new Uri.Builder().scheme("content").authority(c2051gM2314a.f7254a).encodedPath(Uri.encode((String) entry.getKey()) + '/' + Uri.encode(path2.endsWith("/") ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), "/")).build();
            AbstractC1766e.m3919d("getUriForFile(...)", uriBuild);
            return uriBuild;
        } catch (IOException unused) {
            throw new IllegalArgumentException("Failed to resolve canonical path for " + fileCreateTempFile);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3470b(final android.webkit.ValueCallback r11, android.webkit.WebChromeClient.FileChooserParams r12) {
        /*
            r10 = this;
            android.content.Intent r0 = r12.createIntent()
            int r1 = r12.getMode()
            r2 = 1
            if (r1 != r2) goto L10
            java.lang.String r1 = "android.intent.extra.ALLOW_MULTIPLE"
            r0.putExtra(r1, r2)
        L10:
            java.lang.String[] r1 = r12.getAcceptTypes()
            int r1 = r1.length
            java.lang.String r3 = "."
            if (r1 > r2) goto L26
            java.lang.String r1 = r0.getType()
            p119m2.AbstractC1766e.m3917b(r1)
            boolean r1 = r1.startsWith(r3)
            if (r1 == 0) goto L9a
        L26:
            java.lang.String[] r12 = r12.getAcceptTypes()
            java.lang.String r1 = "getAcceptTypes(...)"
            p119m2.AbstractC1766e.m3919d(r1, r12)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.webkit.MimeTypeMap r4 = android.webkit.MimeTypeMap.getSingleton()
            int r5 = r12.length
            r6 = 0
            r7 = r6
        L3b:
            if (r7 >= r5) goto L6f
            r8 = r12[r7]
            java.lang.String r9 = "<this>"
            p119m2.AbstractC1766e.m3920e(r9, r8)
            boolean r9 = r8.startsWith(r3)
            if (r9 == 0) goto L63
            java.lang.String r8 = r8.substring(r2)
            java.lang.String r9 = "substring(...)"
            p119m2.AbstractC1766e.m3919d(r9, r8)
            java.lang.String r8 = r4.getMimeTypeFromExtension(r8)
            if (r8 == 0) goto L6c
            boolean r9 = r1.contains(r8)
            if (r9 != 0) goto L6c
            r1.add(r8)
            goto L6c
        L63:
            boolean r9 = r1.contains(r8)
            if (r9 != 0) goto L6c
            r1.add(r8)
        L6c:
            int r7 = r7 + 1
            goto L3b
        L6f:
            java.lang.Object[] r12 = new java.lang.Object[r6]
            java.lang.Object[] r12 = r1.toArray(r12)
            int r1 = r12.length
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r1, r2)
            java.lang.String r1 = "copyOf(...)"
            p119m2.AbstractC1766e.m3919d(r1, r12)
            java.lang.String[] r12 = (java.lang.String[]) r12
            java.lang.String r1 = "android.intent.extra.MIME_TYPES"
            r0.putExtra(r1, r12)
            java.lang.String r1 = r0.getType()
            p119m2.AbstractC1766e.m3917b(r1)
            boolean r1 = r1.startsWith(r3)
            if (r1 == 0) goto L9a
            r12 = r12[r6]
            r0.setType(r12)
        L9a:
            io.getgrass.www.RustWebChromeClient$showFilePicker$1 r12 = new io.getgrass.www.RustWebChromeClient$showFilePicker$1     // Catch: android.content.ActivityNotFoundException -> La7
            r12.<init>()     // Catch: android.content.ActivityNotFoundException -> La7
            r10.f5211e = r12     // Catch: android.content.ActivityNotFoundException -> La7
            androidx.activity.result.d r12 = r10.f5209c     // Catch: android.content.ActivityNotFoundException -> La7
            r12.m2213f(r0)     // Catch: android.content.ActivityNotFoundException -> La7
            goto Lab
        La7:
            r12 = 0
            r11.onReceiveValue(r12)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.getgrass.www.RustWebChromeClient.m3470b(android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):void");
    }

    /* JADX INFO: renamed from: c */
    public final void m3471c(final ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams, boolean z3) {
        C0883d c0883d = this.f5209c;
        WryActivity wryActivity = this.f5207a;
        if (z3) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            if (intent.resolveActivity(wryActivity.getPackageManager()) != null) {
                this.f5211e = new ActivityResultListener() { // from class: io.getgrass.www.RustWebChromeClient$showVideoCapturePicker$1
                    @Override // io.getgrass.www.RustWebChromeClient.ActivityResultListener
                    /* JADX INFO: renamed from: a */
                    public final void mo3472a(C0881b c0881b) {
                        Uri[] uriArr;
                        if (c0881b == null || c0881b.f2627e != -1) {
                            uriArr = null;
                        } else {
                            Intent intent2 = c0881b.f2628f;
                            AbstractC1766e.m3917b(intent2);
                            uriArr = new Uri[]{intent2.getData()};
                        }
                        valueCallback.onReceiveValue(uriArr);
                    }
                };
                c0883d.m2213f(intent);
                return;
            }
        } else {
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent2.resolveActivity(wryActivity.getPackageManager()) != null) {
                try {
                    final Uri uriM3469a = m3469a();
                    intent2.putExtra("output", uriM3469a);
                    this.f5211e = new ActivityResultListener() { // from class: io.getgrass.www.RustWebChromeClient$showImageCapturePicker$1
                        @Override // io.getgrass.www.RustWebChromeClient.ActivityResultListener
                        /* JADX INFO: renamed from: a */
                        public final void mo3472a(C0881b c0881b) {
                            valueCallback.onReceiveValue((c0881b == null || c0881b.f2627e != -1) ? null : new Uri[]{uriM3469a});
                        }
                    };
                    c0883d.m2213f(intent2);
                    return;
                } catch (Exception e3) {
                    AbstractC1766e.m3920e("message", "Unable to create temporary media capture file: " + e3.getMessage());
                }
            }
        }
        AbstractC1766e.m3920e("tag", Logger.Companion.m3466a("FileChooser"));
        m3470b(valueCallback, fileChooserParams);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AbstractC1766e.m3920e("consoleMessage", consoleMessage);
        String strM3466a = Logger.Companion.m3466a("Console");
        if (consoleMessage.message() == null) {
            return true;
        }
        String strMessage = consoleMessage.message();
        AbstractC1766e.m3919d("message(...)", strMessage);
        if (AbstractC1892g.m4217j(strMessage, "%cresult %c") || AbstractC1892g.m4217j(strMessage, "%cnative %c") || strMessage.equalsIgnoreCase("[object Object]") || strMessage.equalsIgnoreCase("console.groupEnd")) {
            return true;
        }
        String.format("File: %s - Line %d - Msg: %s", Arrays.copyOf(new Object[]{consoleMessage.sourceId(), Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.message()}, 3));
        String strName = consoleMessage.messageLevel().name();
        if ("ERROR".equalsIgnoreCase(strName)) {
            AbstractC1766e.m3920e("tag", strM3466a);
            return true;
        }
        if ("WARNING".equalsIgnoreCase(strName)) {
            AbstractC1766e.m3920e("tag", strM3466a);
            return true;
        }
        if ("TIP".equalsIgnoreCase(strName)) {
            AbstractC1766e.m3920e("tag", strM3466a);
            return true;
        }
        AbstractC1766e.m3920e("tag", strM3466a);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        AbstractC1766e.m3920e("origin", str);
        AbstractC1766e.m3920e("callback", callback);
        super.onGeolocationPermissionsShowPrompt(str, callback);
        AbstractC1766e.m3920e("message", "onGeolocationPermissionsShowPrompt: DOING IT HERE FOR ORIGIN: ".concat(str));
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        if (PermissionHelper.m3468a(this.f5207a, strArr)) {
            callback.invoke(str, true, false);
        } else {
            this.f5210d = new PermissionListener() { // from class: io.getgrass.www.RustWebChromeClient.onGeolocationPermissionsShowPrompt.1
                @Override // io.getgrass.www.RustWebChromeClient.PermissionListener
                /* JADX INFO: renamed from: a */
                public final void mo3473a(Boolean bool) {
                    boolean zEquals = bool.equals(Boolean.TRUE);
                    String str2 = str;
                    GeolocationPermissions.Callback callback2 = callback;
                    if (zEquals) {
                        callback2.invoke(str2, true, false);
                        return;
                    }
                    String[] strArr2 = {"android.permission.ACCESS_COARSE_LOCATION"};
                    if (Build.VERSION.SDK_INT < 31 || !PermissionHelper.m3468a(this.f5207a, strArr2)) {
                        callback2.invoke(str2, false, false);
                    } else {
                        callback2.invoke(str2, true, false);
                    }
                }
            };
            this.f5208b.m2213f(strArr);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("url", str);
        AbstractC1766e.m3920e("message", str2);
        AbstractC1766e.m3920e("result", jsResult);
        if (this.f5207a.isFinishing()) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setMessage(str2).setPositiveButton("OK", new DialogInterfaceOnClickListenerC1455b(jsResult, 2)).setOnCancelListener(new DialogInterfaceOnCancelListenerC1456c(jsResult, 1));
        builder.create().show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("url", str);
        AbstractC1766e.m3920e("message", str2);
        AbstractC1766e.m3920e("result", jsResult);
        if (this.f5207a.isFinishing()) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        builder.setMessage(str2).setPositiveButton("OK", new DialogInterfaceOnClickListenerC1455b(jsResult, 0)).setNegativeButton("Cancel", new DialogInterfaceOnClickListenerC1455b(jsResult, 1)).setOnCancelListener(new DialogInterfaceOnCancelListenerC1456c(jsResult, 0));
        builder.create().show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("url", str);
        AbstractC1766e.m3920e("message", str2);
        AbstractC1766e.m3920e("defaultValue", str3);
        AbstractC1766e.m3920e("result", jsPromptResult);
        if (this.f5207a.isFinishing()) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webView.getContext());
        final EditText editText = new EditText(webView.getContext());
        builder.setMessage(str2).setView(editText).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: io.getgrass.www.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                int i4 = RustWebChromeClient.f5206f;
                EditText editText2 = editText;
                AbstractC1766e.m3920e("$input", editText2);
                JsPromptResult jsPromptResult2 = jsPromptResult;
                AbstractC1766e.m3920e("$result", jsPromptResult2);
                AbstractC1766e.m3920e("dialog", dialogInterface);
                dialogInterface.dismiss();
                String string = editText2.getText().toString();
                int length = string.length() - 1;
                int i5 = 0;
                boolean z3 = false;
                while (i5 <= length) {
                    boolean z4 = AbstractC1766e.m3921f(string.charAt(!z3 ? i5 : length), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z4) {
                        i5++;
                    } else {
                        z3 = true;
                    }
                }
                jsPromptResult2.confirm(string.subSequence(i5, length + 1).toString());
            }
        }).setNegativeButton("Cancel", new DialogInterfaceOnClickListenerC1455b(jsPromptResult, 3)).setOnCancelListener(new DialogInterfaceOnCancelListenerC1456c(jsPromptResult, 2));
        builder.create().show();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(final PermissionRequest permissionRequest) {
        AbstractC1766e.m3920e("request", permissionRequest);
        ArrayList arrayList = new ArrayList();
        String[] resources = permissionRequest.getResources();
        AbstractC1766e.m3919d("getResources(...)", resources);
        if (AbstractC1086e.m2837u(Arrays.copyOf(resources, resources.length)).contains("android.webkit.resource.VIDEO_CAPTURE")) {
            arrayList.add("android.permission.CAMERA");
        }
        String[] resources2 = permissionRequest.getResources();
        AbstractC1766e.m3919d("getResources(...)", resources2);
        if (AbstractC1086e.m2837u(Arrays.copyOf(resources2, resources2.length)).contains("android.webkit.resource.AUDIO_CAPTURE")) {
            arrayList.add("android.permission.MODIFY_AUDIO_SETTINGS");
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (!(!arrayList.isEmpty())) {
            permissionRequest.grant(permissionRequest.getResources());
            return;
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.f5210d = new PermissionListener() { // from class: io.getgrass.www.RustWebChromeClient.onPermissionRequest.1
            @Override // io.getgrass.www.RustWebChromeClient.PermissionListener
            /* JADX INFO: renamed from: a */
            public final void mo3473a(Boolean bool) {
                boolean zEquals = bool.equals(Boolean.TRUE);
                PermissionRequest permissionRequest2 = permissionRequest;
                if (zEquals) {
                    permissionRequest2.grant(permissionRequest2.getResources());
                } else {
                    permissionRequest2.deny();
                }
            }
        };
        this.f5208b.m2213f(strArr);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        AbstractC1766e.m3920e("view", webView);
        AbstractC1766e.m3920e("title", str);
        handleReceivedTitle(webView, str);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AbstractC1766e.m3920e("view", view);
        AbstractC1766e.m3920e("callback", customViewCallback);
        customViewCallback.onCustomViewHidden();
        super.onShowCustomView(view, customViewCallback);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onShowFileChooser(android.webkit.WebView r7, final android.webkit.ValueCallback r8, final android.webkit.WebChromeClient.FileChooserParams r9) {
        /*
            r6 = this;
            java.lang.String r0 = "webView"
            p119m2.AbstractC1766e.m3920e(r0, r7)
            java.lang.String r7 = "filePathCallback"
            p119m2.AbstractC1766e.m3920e(r7, r8)
            java.lang.String r7 = "fileChooserParams"
            p119m2.AbstractC1766e.m3920e(r7, r9)
            java.lang.String[] r7 = r9.getAcceptTypes()
            java.lang.String r0 = "getAcceptTypes(...)"
            p119m2.AbstractC1766e.m3919d(r0, r7)
            int r0 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r0)
            java.util.List r7 = p086c2.AbstractC1086e.m2837u(r7)
            boolean r0 = r9.isCaptureEnabled()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L33
            java.lang.String r3 = "image/*"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L33
            r3 = r2
            goto L34
        L33:
            r3 = r1
        L34:
            if (r0 == 0) goto L3f
            java.lang.String r0 = "video/*"
            boolean r7 = r7.contains(r0)
            if (r7 == 0) goto L3f
            r1 = r2
        L3f:
            if (r3 != 0) goto L48
            if (r1 == 0) goto L44
            goto L48
        L44:
            r6.m3470b(r8, r9)
            goto Lb0
        L48:
            java.lang.String r7 = "android.permission.CAMERA"
            java.lang.String[] r0 = new java.lang.String[]{r7}
            io.getgrass.www.WryActivity r3 = r6.f5207a
            boolean r0 = io.getgrass.www.PermissionHelper.m3468a(r3, r0)
            if (r0 != 0) goto Lad
            java.lang.String r0 = "context"
            p119m2.AbstractC1766e.m3920e(r0, r3)
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch: java.lang.Exception -> L81
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L81
            r5 = 33
            if (r4 < r5) goto L72
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L81
            android.content.pm.PackageManager$PackageInfoFlags r4 = p032K.AbstractC0388f.m854b()     // Catch: java.lang.Exception -> L81
            android.content.pm.PackageInfo r0 = p032K.AbstractC0388f.m853a(r0, r3, r4)     // Catch: java.lang.Exception -> L81
            goto L7c
        L72:
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L81
            r4 = 4096(0x1000, float:5.74E-42)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L81
        L7c:
            if (r0 == 0) goto L81
            java.lang.String[] r0 = r0.requestedPermissions     // Catch: java.lang.Exception -> L81
            goto L82
        L81:
            r0 = 0
        L82:
            if (r0 == 0) goto Lad
            int r3 = r0.length
            if (r3 != 0) goto L88
            goto Lad
        L88:
            int r3 = r0.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r3)
            java.util.List r0 = p086c2.AbstractC1086e.m2837u(r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r0)
            boolean r0 = r3.contains(r7)
            if (r0 == 0) goto Lad
            io.getgrass.www.RustWebChromeClient$onShowFileChooser$1 r0 = new io.getgrass.www.RustWebChromeClient$onShowFileChooser$1
            r0.<init>()
            r6.f5210d = r0
            java.lang.String[] r7 = new java.lang.String[]{r7}
            androidx.activity.result.d r8 = r6.f5208b
            r8.m2213f(r7)
            goto Lb0
        Lad:
            r6.m3471c(r8, r9, r1)
        Lb0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.getgrass.www.RustWebChromeClient.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
    }
}
