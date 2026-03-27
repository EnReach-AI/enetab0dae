package app.tauri.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.WebView;
import androidx.activity.result.C0883d;
import androidx.activity.result.InterfaceC0882c;
import androidx.fragment.app.C0955z;
import app.tauri.JniMethod;
import app.tauri.Logger;
import app.tauri.notification.PluginConfig;
import app.tauri.plugin.PluginManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p069X0.C0717h;
import p069X0.C0734y;
import p069X0.EnumC0719j;
import p083b2.AbstractC1056a;
import p098g.AbstractActivityC1367f;
import p106i1.C1448a;
import p106i1.C1449b;
import p114l1.C1660b;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1886a;

/* JADX INFO: loaded from: classes.dex */
public final class PluginManager {

    /* JADX INFO: renamed from: a */
    public final AbstractActivityC1367f f3549a;

    /* JADX INFO: renamed from: b */
    public final HashMap f3550b;

    /* JADX INFO: renamed from: c */
    public final C0883d f3551c;

    /* JADX INFO: renamed from: d */
    public RequestPermissionsCallback f3552d;

    /* JADX INFO: renamed from: e */
    public final C0734y f3553e;

    public interface ActivityResultCallback {
    }

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static Object m2691a(Context context) throws IllegalAccessException, IOException, InvocationTargetException {
            AbstractC1766e.m3920e("context", context);
            AssetManager assets = context.getAssets();
            AbstractC1766e.m3919d("getAssets(...)", assets);
            InputStream inputStreamOpen = assets.open("tauri.conf.json");
            AbstractC1766e.m3919d("open(...)", inputStreamOpen);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, AbstractC1886a.f6631a), 8192);
            try {
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[8192];
                for (int i3 = bufferedReader.read(cArr); i3 >= 0; i3 = bufferedReader.read(cArr)) {
                    stringWriter.write(cArr, 0, i3);
                }
                String string = stringWriter.toString();
                AbstractC1766e.m3919d("toString(...)", string);
                bufferedReader.close();
                C0734y c0734y = new C0734y();
                EnumC0719j enumC0719j = EnumC0719j.FAIL_ON_UNKNOWN_PROPERTIES;
                C0717h c0717h = c0734y.f2090j;
                c0717h.getClass();
                int i4 = ~enumC0719j.f2035f;
                int i5 = c0717h.f1991u;
                int i6 = i5 & i4;
                if (i6 != i5) {
                    c0717h = new C0717h(c0717h, c0717h.f2480e, i6, c0717h.f1992v, c0717h.f1993w, c0717h.f1994x, c0717h.f1995y);
                }
                c0734y.f2090j = c0717h;
                return c0734y.m1918k(PluginConfig.class, String.valueOf(((Config) c0734y.m1918k(Config.class, string)).getPlugins().get("notification")));
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        AbstractC1056a.m2814a(th, th3);
                    }
                    throw th2;
                }
            }
        }
    }

    public interface RequestPermissionsCallback {
        /* JADX INFO: renamed from: a */
        void mo2692a(Map map);
    }

    public PluginManager(AbstractActivityC1367f abstractActivityC1367f) {
        C0717h c0717h;
        AbstractC1766e.m3920e("activity", abstractActivityC1367f);
        this.f3549a = abstractActivityC1367f;
        this.f3550b = new HashMap();
        final int i3 = 0;
        abstractActivityC1367f.m2204j(new C0955z(2), new InterfaceC0882c(this) { // from class: app.tauri.plugin.b

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ PluginManager f3563f;

            {
                this.f3563f = this;
            }

            @Override // androidx.activity.result.InterfaceC0882c
            /* JADX INFO: renamed from: j */
            public final void mo449j(Object obj) {
                switch (i3) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    case 1:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    default:
                        Map map = (Map) obj;
                        PluginManager pluginManager = this.f3563f;
                        AbstractC1766e.m3920e("this$0", pluginManager);
                        PluginManager.RequestPermissionsCallback requestPermissionsCallback = pluginManager.f3552d;
                        if (requestPermissionsCallback != null) {
                            AbstractC1766e.m3917b(map);
                            requestPermissionsCallback.mo2692a(map);
                        }
                        break;
                }
            }
        });
        final int i4 = 1;
        abstractActivityC1367f.m2204j(new C0955z(3), new InterfaceC0882c(this) { // from class: app.tauri.plugin.b

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ PluginManager f3563f;

            {
                this.f3563f = this;
            }

            @Override // androidx.activity.result.InterfaceC0882c
            /* JADX INFO: renamed from: j */
            public final void mo449j(Object obj) {
                switch (i4) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    case 1:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    default:
                        Map map = (Map) obj;
                        PluginManager pluginManager = this.f3563f;
                        AbstractC1766e.m3920e("this$0", pluginManager);
                        PluginManager.RequestPermissionsCallback requestPermissionsCallback = pluginManager.f3552d;
                        if (requestPermissionsCallback != null) {
                            AbstractC1766e.m3917b(map);
                            requestPermissionsCallback.mo2692a(map);
                        }
                        break;
                }
            }
        });
        final int i5 = 2;
        this.f3551c = abstractActivityC1367f.m2204j(new C0955z(1), new InterfaceC0882c(this) { // from class: app.tauri.plugin.b

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ PluginManager f3563f;

            {
                this.f3563f = this;
            }

            @Override // androidx.activity.result.InterfaceC0882c
            /* JADX INFO: renamed from: j */
            public final void mo449j(Object obj) {
                switch (i5) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    case 1:
                        AbstractC1766e.m3920e("this$0", this.f3563f);
                        break;
                    default:
                        Map map = (Map) obj;
                        PluginManager pluginManager = this.f3563f;
                        AbstractC1766e.m3920e("this$0", pluginManager);
                        PluginManager.RequestPermissionsCallback requestPermissionsCallback = pluginManager.f3552d;
                        if (requestPermissionsCallback != null) {
                            AbstractC1766e.m3917b(map);
                            requestPermissionsCallback.mo2692a(map);
                        }
                        break;
                }
            }
        });
        C0734y c0734y = new C0734y();
        EnumC0719j enumC0719j = EnumC0719j.FAIL_ON_UNKNOWN_PROPERTIES;
        C0717h c0717h2 = c0734y.f2090j;
        c0717h2.getClass();
        int i6 = ~enumC0719j.f2035f;
        int i7 = c0717h2.f1991u;
        int i8 = i7 & i6;
        if (i8 == i7) {
            c0717h = c0717h2;
        } else {
            c0717h = new C0717h(c0717h2, c0717h2.f2480e, i8, c0717h2.f1992v, c0717h2.f1993w, c0717h2.f1994x, c0717h2.f1995y);
        }
        c0734y.f2090j = c0717h;
        int i9 = EnumC0719j.FAIL_ON_NULL_FOR_PRIMITIVES.f2035f;
        int i10 = c0717h.f1991u;
        int i11 = i9 | i10;
        if (i11 != i10) {
            c0717h = new C0717h(c0717h, c0717h.f2480e, i11, c0717h.f1992v, c0717h.f1993w, c0717h.f1994x, c0717h.f1995y);
        }
        c0734y.f2090j = c0717h;
        this.f3553e = c0734y;
        ChannelDeserializer channelDeserializer = new ChannelDeserializer(new PluginManager$channelDeserializer$1(this), c0734y);
        C1449b c1449b = new C1449b();
        if (c1449b.f5148g == null) {
            c1449b.f5148g = new C1448a();
        }
        C1448a c1448a = c1449b.f5148g;
        c1448a.getClass();
        C1660b c1660b = new C1660b(Channel.class);
        if (c1448a.f5143e == null) {
            c1448a.f5143e = new HashMap();
        }
        c1448a.f5143e.put(c1660b, channelDeserializer);
        c0734y.m1919l(c1449b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void handlePluginResponse(int i3, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void sendChannelData(long j2, String str);

    @JniMethod
    public final void load(WebView webView, String str, Plugin plugin, String str2) {
        AbstractC1766e.m3920e("name", str);
        AbstractC1766e.m3920e("plugin", plugin);
        AbstractC1766e.m3920e("config", str2);
        this.f3550b.put(str, new PluginHandle(this, str, plugin, str2, this.f3553e));
        if (webView != null) {
            plugin.mo2660b(webView);
        }
    }

    @JniMethod
    public final void onWebViewCreated(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
        Iterator it = this.f3550b.entrySet().iterator();
        while (it.hasNext()) {
            PluginHandle pluginHandle = (PluginHandle) ((Map.Entry) it.next()).getValue();
            if (!pluginHandle.f3548i) {
                pluginHandle.f3541b.mo2660b(webView);
                pluginHandle.f3548i = true;
            }
        }
    }

    @JniMethod
    public final void runCommand(int i3, String str, String str2, String str3) {
        AbstractC1766e.m3920e("pluginId", str);
        AbstractC1766e.m3920e("command", str2);
        AbstractC1766e.m3920e("data", str3);
        Invoke invoke = new Invoke(str2, new PluginManager$runCommand$invoke$1(this, i3), str3, this.f3553e);
        String strM2657b = Logger.Companion.m2657b("Plugin");
        String strM155m = AbstractC0032g.m155m("Tauri plugin: pluginId: ", str, ", command: ", str2);
        AbstractC1766e.m3920e("tag", strM2657b);
        AbstractC1766e.m3920e("message", strM155m);
        HashMap map = this.f3550b;
        try {
            if (((PluginHandle) map.get(str)) == null) {
                invoke.m2681b("Plugin " + str + " not initialized");
            } else {
                PluginHandle pluginHandle = (PluginHandle) map.get(str);
                if (pluginHandle != null) {
                    pluginHandle.m2688a(invoke);
                }
            }
        } catch (Exception e3) {
            e = e3;
            String message = e.getMessage();
            if ((message == null || message.length() == 0) && (e instanceof InvocationTargetException)) {
                e = ((InvocationTargetException) e).getTargetException();
                AbstractC1766e.m3919d("getTargetException(...)", e);
            }
            String message2 = e.getMessage();
            invoke.m2681b((message2 == null || message2.length() == 0) ? e.toString() : e.getMessage());
        }
    }
}
