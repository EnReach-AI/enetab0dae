package io.getgrass.plugin;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import io.getgrass.plugin.ForegroundService;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import p001A.RunnableC0014o;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p011C2.C0148a;
import p017E2.AbstractC0208a;
import p028I1.RunnableC0304d;
import p079a2.AbstractC0860e;
import p079a2.C0861f;
import p079a2.C0862g;
import p083b2.C1058c;
import p090e.InterfaceC1319a;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.C1763b;
import p119m2.C1774m;
import p148u0.AbstractC1946e;
import p162y.C2031j;
import p166z0.C2068f;

/* JADX INFO: loaded from: classes.dex */
public final class ForegroundService extends Service {

    /* JADX INFO: renamed from: k */
    public static final Companion f5157k;

    /* JADX INFO: renamed from: l */
    public static boolean f5158l;

    /* JADX INFO: renamed from: m */
    public static NotificationManager f5159m;

    /* JADX INFO: renamed from: n */
    public static ForegroundService f5160n;

    /* JADX INFO: renamed from: e */
    public PowerManager.WakeLock f5161e;

    /* JADX INFO: renamed from: f */
    public C0861f f5162f;

    /* JADX INFO: renamed from: g */
    public ConnectivityManager f5163g;

    /* JADX INFO: renamed from: h */
    public Handler f5164h;

    /* JADX INFO: renamed from: i */
    public RunnableC0055o f5165i;

    /* JADX INFO: renamed from: j */
    public boolean f5166j;

    public static final class Companion {
        @InterfaceC1319a
        public final int getActiveNetworkTypeName() {
            Log.d(toString(), "ForegroundService:getActiveNetworkTypeName");
            ForegroundService foregroundService = ForegroundService.f5160n;
            NetworkCapabilities networkCapabilities = null;
            if (foregroundService != null) {
                ConnectivityManager connectivityManager = foregroundService.f5163g;
                if (connectivityManager == null) {
                    AbstractC1766e.m3924i("connectivityManager");
                    throw null;
                }
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork != null) {
                    ConnectivityManager connectivityManager2 = foregroundService.f5163g;
                    if (connectivityManager2 == null) {
                        AbstractC1766e.m3924i("connectivityManager");
                        throw null;
                    }
                    networkCapabilities = connectivityManager2.getNetworkCapabilities(activeNetwork);
                }
            }
            if (networkCapabilities == null) {
                return -1;
            }
            int i3 = 1;
            if (!networkCapabilities.hasTransport(1)) {
                i3 = 0;
                if (!networkCapabilities.hasTransport(0)) {
                    return -1;
                }
            }
            return i3;
        }

        @InterfaceC1319a
        public final void incBandwidthUsage(int i3, String str) throws Exception {
            Object objValueOf;
            long jLongValue;
            Object objValueOf2;
            Long lValueOf;
            AbstractC1766e.m3920e("networkType", str);
            Log.d(toString(), "ForegroundService:incBandwidthUsage: " + i3 + ", " + str);
            if (str.equals("cellular")) {
                ForegroundService foregroundService = ForegroundService.f5160n;
                if (foregroundService != null) {
                    Date date = new Date();
                    C0861f c0861f = foregroundService.f5162f;
                    AbstractC1766e.m3917b(c0861f);
                    String strM2188a = c0861f.m2188a("cellularUsageTimestamp");
                    if (strM2188a == null || strM2188a.length() == 0) {
                        C1763b c1763bM3927a = AbstractC1770i.m3927a(Long.class);
                        if (c1763bM3927a.equals(AbstractC1770i.m3927a(String.class))) {
                            objValueOf = (Long) "";
                        } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                            objValueOf = (Long) 0;
                        } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                            objValueOf = 0L;
                        } else {
                            if (!c1763bM3927a.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                                throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(Long.class));
                            }
                            objValueOf = (Long) Boolean.FALSE;
                        }
                    } else {
                        try {
                            C0148a c0148a = C0148a.f356d;
                            objValueOf = c0148a.m296a(strM2188a, AbstractC1946e.m4350h(c0148a.f358b, AbstractC1770i.m3928b(Long.TYPE)));
                        } catch (Exception e3) {
                            if ("cellularUsageTimestamp".equals("cellularUsageTimestamp")) {
                                try {
                                    Date date2 = DateFormat.getDateTimeInstance().parse(strM2188a);
                                    objValueOf = date2 != null ? Long.valueOf(date2.getTime()) : null;
                                    if (objValueOf == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                    }
                                } catch (Exception e4) {
                                    Log.w(foregroundService.getPackageName(), "Failed to parse cellularUsageTimestamp, using current time: " + e4.getMessage());
                                    objValueOf = Long.valueOf(new Date().getTime());
                                }
                            } else {
                                C1763b c1763bM3927a2 = AbstractC1770i.m3927a(Long.class);
                                if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                                    objValueOf = (Long) Integer.valueOf(Integer.parseInt(strM2188a));
                                } else if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                                    objValueOf = Long.valueOf(Long.parseLong(strM2188a));
                                } else {
                                    if (!c1763bM3927a2.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                                        throw e3;
                                    }
                                    objValueOf = (Long) Boolean.valueOf(Boolean.parseBoolean(strM2188a));
                                }
                            }
                        }
                    }
                    if (ForegroundService.m3461h(new Date(((Number) objValueOf).longValue()), date)) {
                        C0861f c0861f2 = foregroundService.f5162f;
                        AbstractC1766e.m3917b(c0861f2);
                        String strM2188a2 = c0861f2.m2188a("cellularUsage");
                        if (strM2188a2 == null || strM2188a2.length() == 0) {
                            C1763b c1763bM3927a3 = AbstractC1770i.m3927a(Long.class);
                            if (c1763bM3927a3.equals(AbstractC1770i.m3927a(String.class))) {
                                objValueOf2 = (Long) "";
                            } else if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                                objValueOf2 = (Long) 0;
                            } else if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                                objValueOf2 = 0L;
                            } else {
                                if (!c1763bM3927a3.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(Long.class));
                                }
                                objValueOf2 = (Long) Boolean.FALSE;
                            }
                        } else {
                            try {
                                C0148a c0148a2 = C0148a.f356d;
                                objValueOf2 = c0148a2.m296a(strM2188a2, AbstractC1946e.m4350h(c0148a2.f358b, AbstractC1770i.m3928b(Long.TYPE)));
                            } catch (Exception e5) {
                                if ("cellularUsage".equals("cellularUsageTimestamp")) {
                                    try {
                                        Date date3 = DateFormat.getDateTimeInstance().parse(strM2188a2);
                                        lValueOf = date3 != null ? Long.valueOf(date3.getTime()) : null;
                                        if (lValueOf == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                        }
                                    } catch (Exception e6) {
                                        Log.w(foregroundService.getPackageName(), "Failed to parse cellularUsageTimestamp, using current time: " + e6.getMessage());
                                        lValueOf = Long.valueOf(new Date().getTime());
                                    }
                                    objValueOf2 = lValueOf;
                                } else {
                                    C1763b c1763bM3927a4 = AbstractC1770i.m3927a(Long.class);
                                    if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                                        objValueOf2 = (Long) Integer.valueOf(Integer.parseInt(strM2188a2));
                                    } else if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                                        objValueOf2 = Long.valueOf(Long.parseLong(strM2188a2));
                                    } else {
                                        if (!c1763bM3927a4.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                                            throw e5;
                                        }
                                        objValueOf2 = (Long) Boolean.valueOf(Boolean.parseBoolean(strM2188a2));
                                    }
                                }
                            }
                        }
                        jLongValue = ((Number) objValueOf2).longValue() + ((long) i3);
                    } else {
                        jLongValue = i3;
                    }
                    Long lValueOf2 = Long.valueOf(jLongValue);
                    C0148a c0148a3 = C0148a.f356d;
                    Class cls = Long.TYPE;
                    C1774m c1774mM3928b = AbstractC1770i.m3928b(cls);
                    C2068f c2068f = AbstractC0208a.f512a;
                    String strM297b = c0148a3.m297b(AbstractC1946e.m4350h(c2068f, c1774mM3928b), lValueOf2);
                    C0861f c0861f3 = foregroundService.f5162f;
                    AbstractC1766e.m3917b(c0861f3);
                    c0861f3.m2189b("cellularUsage", strM297b);
                    String strM297b2 = c0148a3.m297b(AbstractC1946e.m4350h(c2068f, AbstractC1770i.m3928b(cls)), Long.valueOf(date.getTime()));
                    C0861f c0861f4 = foregroundService.f5162f;
                    AbstractC1766e.m3917b(c0861f4);
                    c0861f4.m2189b("cellularUsageTimestamp", strM297b2);
                    if (foregroundService.m3464g() && foregroundService.m3462e()) {
                        Log.w(toString(), "Cellular limit exceeded. Stopping websocket.");
                        new Thread(new RunnableC0014o(foregroundService, 1, this)).start();
                    }
                }
            }
        }

        public final native void sendWebsocketState(String str);

        public final native void updateClassLoader(ClassLoader classLoader);

        @InterfaceC1319a
        public final void updateWebsocketState(String str) {
            StatusBarNotification statusBarNotification;
            Notification notification;
            Bundle bundle;
            CharSequence charSequence;
            AbstractC1766e.m3920e("state", str);
            Log.d(toString(), "ForegroundService:updateWebsocketState: ".concat(str));
            ForegroundService foregroundService = ForegroundService.f5160n;
            if (foregroundService != null) {
                String strM297b = C0148a.f356d.m297b(AbstractC1946e.m4350h(AbstractC0208a.f512a, AbstractC1770i.m3928b(String.class)), str);
                C0861f c0861f = foregroundService.f5162f;
                AbstractC1766e.m3917b(c0861f);
                c0861f.m2189b("status", strM297b);
                try {
                    ForegroundService.f5157k.sendWebsocketState(str);
                } catch (UnsatisfiedLinkError unused) {
                    Log.e(toString(), "Error running sendWebsocketState");
                }
                if (str.equals("CONNECTING")) {
                    return;
                }
                String str2 = (foregroundService.m3464g() && foregroundService.m3462e()) ? (String) AbstractC0860e.f2539a.get("CELLULAR_LIMIT_EXCEEDED") : (String) AbstractC0860e.f2539a.get(str);
                if (str2 != null) {
                    NotificationManager notificationManager = ForegroundService.f5159m;
                    String string = null;
                    StatusBarNotification[] activeNotifications = notificationManager != null ? notificationManager.getActiveNotifications() : null;
                    if (activeNotifications != null) {
                        int length = activeNotifications.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            statusBarNotification = activeNotifications[i3];
                            int id = statusBarNotification.getId();
                            Companion companion = ForegroundService.f5157k;
                            if (id == -1) {
                                break;
                            }
                        }
                        statusBarNotification = null;
                    } else {
                        statusBarNotification = null;
                    }
                    if (statusBarNotification != null && (notification = statusBarNotification.getNotification()) != null && (bundle = notification.extras) != null && (charSequence = bundle.getCharSequence("android.title")) != null) {
                        string = charSequence.toString();
                    }
                    if (AbstractC1766e.m3916a(string, str2)) {
                        return;
                    }
                    Notification notificationM3463f = foregroundService.m3463f(str2);
                    NotificationManager notificationManager2 = ForegroundService.f5159m;
                    if (notificationManager2 != null) {
                        notificationManager2.notify(-1, notificationM3463f);
                    }
                }
            }
        }
    }

    static {
        Companion companion = new Companion();
        f5157k = companion;
        try {
            System.loadLibrary("rust_wynd_proxy");
            Log.d(companion.toString(), "Successfully loaded rust_wynd_proxy library");
        } catch (UnsatisfiedLinkError unused) {
            Log.e("ForegroundService", "Error loading rust_wynd_proxy library");
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3457a(ForegroundService foregroundService) {
        AbstractC1766e.m3920e("this$0", foregroundService);
        try {
            foregroundService.f5166j = false;
            Log.d(foregroundService.getPackageName(), "Trying to run stopWebsocket");
            foregroundService.stopWebsocket();
        } catch (UnsatisfiedLinkError unused) {
            Log.e(foregroundService.getPackageName(), "Error running stopWebsocket");
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m3458b(ForegroundService foregroundService, C1058c c1058c, C1058c c1058c2, C1058c c1058c3, C1058c c1058c4, C1058c c1058c5, C1058c c1058c6) {
        AbstractC1766e.m3920e("this$0", foregroundService);
        try {
            Log.d(foregroundService.getPackageName(), "Trying to run startWebsocket");
            foregroundService.f5166j = true;
            foregroundService.startWebsocket((String) c1058c.f3734f, (String) c1058c2.f3734f, (String) c1058c3.f3734f, (String) c1058c4.f3734f, (String) c1058c5.f3734f, "mobile", (String) c1058c6.f3734f);
        } catch (Exception e3) {
            Log.e(foregroundService.getPackageName(), "Failed to run startWebsocket " + e3.getMessage());
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m3459c(ForegroundService foregroundService) {
        Object objM296a;
        Log.d(foregroundService.getPackageName(), "Checking if websocket should be running");
        if (foregroundService.m3464g()) {
            C0861f c0861f = foregroundService.f5162f;
            AbstractC1766e.m3917b(c0861f);
            String strM2188a = c0861f.m2188a("isCellularAllowed");
            if (strM2188a == null || strM2188a.length() == 0) {
                C1763b c1763bM3927a = AbstractC1770i.m3927a(String.class);
                if (c1763bM3927a.equals(AbstractC1770i.m3927a(String.class))) {
                    objM296a = "";
                } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                    objM296a = (String) 0;
                } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                    objM296a = (String) 0L;
                } else {
                    if (!c1763bM3927a.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                        throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                    }
                    objM296a = (String) Boolean.FALSE;
                }
            } else {
                try {
                    C0148a c0148a = C0148a.f356d;
                    objM296a = c0148a.m296a(strM2188a, AbstractC1946e.m4350h(c0148a.f358b, AbstractC1770i.m3928b(String.class)));
                } catch (Exception unused) {
                    "isCellularAllowed".equals("cellularUsageTimestamp");
                    if (strM2188a.startsWith("\"") && strM2188a.endsWith("\"")) {
                        C0148a c0148a2 = C0148a.f356d;
                        objM296a = c0148a2.m296a(strM2188a, AbstractC1946e.m4350h(c0148a2.f358b, AbstractC1770i.m3928b(String.class)));
                    } else {
                        C0148a c0148a3 = C0148a.f356d;
                        objM296a = c0148a3.m296a(AbstractC0032g.m153k("\"", strM2188a, '\"'), AbstractC1946e.m4350h(c0148a3.f358b, AbstractC1770i.m3928b(String.class)));
                    }
                }
            }
            if (!AbstractC1766e.m3916a((String) objM296a, "true") || foregroundService.m3462e()) {
                if (foregroundService.f5166j) {
                    Log.d(foregroundService.getPackageName(), "checkIfWebsocketShouldBeRunning: stopping websocket due to cellular limit exceeded");
                    try {
                        foregroundService.f5166j = false;
                        foregroundService.stopWebsocket();
                        return;
                    } catch (Exception e3) {
                        foregroundService.f5166j = true;
                        Log.e(foregroundService.getPackageName(), "Error stopping websocket: " + e3.getMessage());
                        return;
                    }
                }
                return;
            }
        }
        if (foregroundService.f5166j) {
            return;
        }
        Log.d(foregroundService.getPackageName(), "checkIfWebsocketShouldBeRunning: starting websocket");
        try {
            foregroundService.f5166j = true;
            foregroundService.m3465i();
        } catch (Exception e4) {
            foregroundService.f5166j = false;
            Log.e(foregroundService.getPackageName(), "Error starting websocket: " + e4.getMessage());
        }
    }

    @InterfaceC1319a
    public static final int getActiveNetworkTypeName() {
        return f5157k.getActiveNetworkTypeName();
    }

    /* JADX INFO: renamed from: h */
    public static boolean m3461h(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(2) == calendar2.get(2) && calendar.get(1) == calendar2.get(1);
    }

    @InterfaceC1319a
    public static final void incBandwidthUsage(int i3, String str) throws Exception {
        f5157k.incBandwidthUsage(i3, str);
    }

    private final native void initialize();

    private final native void startWebsocket(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void stopWebsocket();

    @InterfaceC1319a
    public static final void updateWebsocketState(String str) {
        f5157k.updateWebsocketState(str);
    }

    /* JADX INFO: renamed from: e */
    public final boolean m3462e() throws Exception {
        Object objM296a;
        Object objValueOf;
        Object objValueOf2;
        boolean z3;
        Object objValueOf3;
        Long lValueOf;
        C0861f c0861f = this.f5162f;
        AbstractC1766e.m3917b(c0861f);
        String strM2188a = c0861f.m2188a("isCellularUsageLimited");
        if (strM2188a == null || strM2188a.length() == 0) {
            C1763b c1763bM3927a = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a = "";
            } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a = (String) 0;
            } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a = (String) 0L;
            } else {
                if (!c1763bM3927a.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a = C0148a.f356d;
                objM296a = c0148a.m296a(strM2188a, AbstractC1946e.m4350h(c0148a.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused) {
                "isCellularUsageLimited".equals("cellularUsageTimestamp");
                if (strM2188a.startsWith("\"") && strM2188a.endsWith("\"")) {
                    C0148a c0148a2 = C0148a.f356d;
                    objM296a = c0148a2.m296a(strM2188a, AbstractC1946e.m4350h(c0148a2.f358b, AbstractC1770i.m3928b(String.class)));
                } else {
                    C0148a c0148a3 = C0148a.f356d;
                    objM296a = c0148a3.m296a(AbstractC0032g.m153k("\"", strM2188a, '\"'), AbstractC1946e.m4350h(c0148a3.f358b, AbstractC1770i.m3928b(String.class)));
                }
            }
        }
        String str = (String) objM296a;
        C0861f c0861f2 = this.f5162f;
        AbstractC1766e.m3917b(c0861f2);
        String strM2188a2 = c0861f2.m2188a("cellularUsage");
        if (strM2188a2 == null || strM2188a2.length() == 0) {
            C1763b c1763bM3927a2 = AbstractC1770i.m3927a(Long.class);
            if (c1763bM3927a2.equals(AbstractC1770i.m3927a(String.class))) {
                objValueOf = (Long) "";
            } else if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objValueOf = (Long) 0;
            } else if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objValueOf = 0L;
            } else {
                if (!c1763bM3927a2.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(Long.class));
                }
                objValueOf = (Long) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a4 = C0148a.f356d;
                objValueOf = c0148a4.m296a(strM2188a2, AbstractC1946e.m4350h(c0148a4.f358b, AbstractC1770i.m3928b(Long.TYPE)));
            } catch (Exception e3) {
                if ("cellularUsage".equals("cellularUsageTimestamp")) {
                    try {
                        Date date = DateFormat.getDateTimeInstance().parse(strM2188a2);
                        objValueOf = date != null ? Long.valueOf(date.getTime()) : null;
                        if (objValueOf == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                    } catch (Exception e4) {
                        Log.w(getPackageName(), "Failed to parse cellularUsageTimestamp, using current time: " + e4.getMessage());
                        objValueOf = Long.valueOf(new Date().getTime());
                    }
                } else {
                    C1763b c1763bM3927a3 = AbstractC1770i.m3927a(Long.class);
                    if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                        objValueOf = (Long) Integer.valueOf(Integer.parseInt(strM2188a2));
                    } else if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                        objValueOf = Long.valueOf(Long.parseLong(strM2188a2));
                    } else {
                        if (!c1763bM3927a3.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                            throw e3;
                        }
                        objValueOf = (Long) Boolean.valueOf(Boolean.parseBoolean(strM2188a2));
                    }
                }
            }
        }
        long jLongValue = ((Number) objValueOf).longValue();
        C0861f c0861f3 = this.f5162f;
        AbstractC1766e.m3917b(c0861f3);
        String strM2188a3 = c0861f3.m2188a("cellularAllowedLimit");
        if (strM2188a3 == null || strM2188a3.length() == 0) {
            C1763b c1763bM3927a4 = AbstractC1770i.m3927a(Long.class);
            if (c1763bM3927a4.equals(AbstractC1770i.m3927a(String.class))) {
                objValueOf2 = (Long) "";
            } else if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objValueOf2 = (Long) 0;
            } else if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objValueOf2 = 0L;
            } else {
                if (!c1763bM3927a4.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(Long.class));
                }
                objValueOf2 = (Long) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a5 = C0148a.f356d;
                objValueOf2 = c0148a5.m296a(strM2188a3, AbstractC1946e.m4350h(c0148a5.f358b, AbstractC1770i.m3928b(Long.TYPE)));
            } catch (Exception e5) {
                if ("cellularAllowedLimit".equals("cellularUsageTimestamp")) {
                    try {
                        Date date2 = DateFormat.getDateTimeInstance().parse(strM2188a3);
                        objValueOf2 = date2 != null ? Long.valueOf(date2.getTime()) : null;
                        if (objValueOf2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                    } catch (Exception e6) {
                        Log.w(getPackageName(), "Failed to parse cellularUsageTimestamp, using current time: " + e6.getMessage());
                        objValueOf2 = Long.valueOf(new Date().getTime());
                    }
                } else {
                    C1763b c1763bM3927a5 = AbstractC1770i.m3927a(Long.class);
                    if (c1763bM3927a5.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                        objValueOf2 = (Long) Integer.valueOf(Integer.parseInt(strM2188a3));
                    } else if (c1763bM3927a5.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                        objValueOf2 = Long.valueOf(Long.parseLong(strM2188a3));
                    } else {
                        if (!c1763bM3927a5.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                            throw e5;
                        }
                        objValueOf2 = (Long) Boolean.valueOf(Boolean.parseBoolean(strM2188a3));
                    }
                }
            }
        }
        long jLongValue2 = ((Number) objValueOf2).longValue();
        C0861f c0861f4 = this.f5162f;
        AbstractC1766e.m3917b(c0861f4);
        String strM2188a4 = c0861f4.m2188a("cellularUsageTimestamp");
        if (strM2188a4 == null || strM2188a4.length() == 0) {
            C1763b c1763bM3927a6 = AbstractC1770i.m3927a(Long.class);
            if (!c1763bM3927a6.equals(AbstractC1770i.m3927a(String.class))) {
                if (c1763bM3927a6.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                    z3 = false;
                    objValueOf3 = (Long) 0;
                } else {
                    z3 = false;
                    if (c1763bM3927a6.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                        objValueOf3 = 0L;
                    } else {
                        if (!c1763bM3927a6.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                            throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(Long.class));
                        }
                        objValueOf3 = (Long) Boolean.FALSE;
                    }
                }
                Date date3 = new Date(((Number) objValueOf3).longValue());
                Date date4 = new Date();
                if (AbstractC1766e.m3916a(str, "true") || !m3461h(date3, date4) || jLongValue < jLongValue2) {
                    return z3;
                }
                return true;
            }
            objValueOf3 = (Long) "";
        } else {
            try {
                C0148a c0148a6 = C0148a.f356d;
                objValueOf3 = c0148a6.m296a(strM2188a4, AbstractC1946e.m4350h(c0148a6.f358b, AbstractC1770i.m3928b(Long.TYPE)));
            } catch (Exception e7) {
                if ("cellularUsageTimestamp".equals("cellularUsageTimestamp")) {
                    try {
                        Date date5 = DateFormat.getDateTimeInstance().parse(strM2188a4);
                        lValueOf = date5 != null ? Long.valueOf(date5.getTime()) : null;
                        if (lValueOf == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                    } catch (Exception e8) {
                        Log.w(getPackageName(), "Failed to parse cellularUsageTimestamp, using current time: " + e8.getMessage());
                        lValueOf = Long.valueOf(new Date().getTime());
                    }
                    objValueOf3 = lValueOf;
                } else {
                    C1763b c1763bM3927a7 = AbstractC1770i.m3927a(Long.class);
                    if (c1763bM3927a7.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                        objValueOf3 = (Long) Integer.valueOf(Integer.parseInt(strM2188a4));
                    } else if (c1763bM3927a7.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                        objValueOf3 = Long.valueOf(Long.parseLong(strM2188a4));
                    } else {
                        if (!c1763bM3927a7.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                            throw e7;
                        }
                        objValueOf3 = (Long) Boolean.valueOf(Boolean.parseBoolean(strM2188a4));
                    }
                }
            }
        }
        z3 = false;
        Date date32 = new Date(((Number) objValueOf3).longValue());
        Date date42 = new Date();
        if (AbstractC1766e.m3916a(str, "true")) {
        }
        return z3;
    }

    /* JADX INFO: renamed from: f */
    public final Notification m3463f(String str) {
        C2031j c2031j = new C2031j(this, "ForegroundService");
        c2031j.f7203e = C2031j.m4488b(str);
        c2031j.m4490c(2, true);
        c2031j.m4490c(16, false);
        c2031j.f7208j = true;
        int i3 = getApplicationInfo().icon;
        Resources resources = getResources();
        String packageName = getPackageName();
        int identifier = resources.getIdentifier("fsicon", "mipmap", packageName);
        if (identifier == 0) {
            identifier = resources.getIdentifier("fsicon", "drawable", packageName);
        }
        if (identifier != 0) {
            i3 = identifier;
        }
        c2031j.f7218t.icon = i3;
        Notification notificationM4489a = c2031j.m4489a();
        AbstractC1766e.m3919d("build(...)", notificationM4489a);
        return notificationM4489a;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m3464g() {
        ConnectivityManager connectivityManager = this.f5163g;
        NetworkCapabilities networkCapabilities = null;
        if (connectivityManager == null) {
            AbstractC1766e.m3924i("connectivityManager");
            throw null;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork != null) {
            ConnectivityManager connectivityManager2 = this.f5163g;
            if (connectivityManager2 == null) {
                AbstractC1766e.m3924i("connectivityManager");
                throw null;
            }
            networkCapabilities = connectivityManager2.getNetworkCapabilities(activeNetwork);
        }
        if (networkCapabilities != null) {
            return networkCapabilities.hasTransport(0);
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final void m3465i() {
        Object objM296a;
        Object objM296a2;
        Object objM296a3;
        Object objM296a4;
        Object objM296a5;
        Object objM296a6;
        C0148a c0148a;
        C0148a c0148a2;
        C0148a c0148a3;
        C0148a c0148a4;
        C0148a c0148a5;
        C0148a c0148a6;
        Log.d(getPackageName(), "Trying to run startWebsocket");
        final C1058c c1058c = new C1058c();
        final C1058c c1058c2 = new C1058c();
        final C1058c c1058c3 = new C1058c();
        final C1058c c1058c4 = new C1058c();
        final C1058c c1058c5 = new C1058c();
        final C1058c c1058c6 = new C1058c();
        C0861f c0861f = this.f5162f;
        AbstractC1766e.m3917b(c0861f);
        String strM2188a = c0861f.m2188a("checkinUrl");
        String str = "";
        if (strM2188a == null || strM2188a.length() == 0) {
            C1763b c1763bM3927a = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a = "";
            } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a = (String) 0;
            } else if (c1763bM3927a.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a = (String) 0L;
            } else {
                if (!c1763bM3927a.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a7 = C0148a.f356d;
                objM296a = c0148a7.m296a(strM2188a, AbstractC1946e.m4350h(c0148a7.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused) {
                "checkinUrl".equals("cellularUsageTimestamp");
                if (strM2188a.startsWith("\"") && strM2188a.endsWith("\"")) {
                    c0148a6 = C0148a.f356d;
                } else {
                    c0148a6 = C0148a.f356d;
                    strM2188a = AbstractC0032g.m153k("\"", strM2188a, '\"');
                }
                objM296a = c0148a6.m296a(strM2188a, AbstractC1946e.m4350h(c0148a6.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c.f3734f = objM296a;
        C0861f c0861f2 = this.f5162f;
        AbstractC1766e.m3917b(c0861f2);
        String strM2188a2 = c0861f2.m2188a("version");
        if (strM2188a2 == null || strM2188a2.length() == 0) {
            C1763b c1763bM3927a2 = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a2.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a2 = "";
            } else if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a2 = (String) 0;
            } else if (c1763bM3927a2.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a2 = (String) 0L;
            } else {
                if (!c1763bM3927a2.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a2 = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a8 = C0148a.f356d;
                objM296a2 = c0148a8.m296a(strM2188a2, AbstractC1946e.m4350h(c0148a8.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused2) {
                "version".equals("cellularUsageTimestamp");
                if (strM2188a2.startsWith("\"") && strM2188a2.endsWith("\"")) {
                    c0148a5 = C0148a.f356d;
                } else {
                    c0148a5 = C0148a.f356d;
                    strM2188a2 = AbstractC0032g.m153k("\"", strM2188a2, '\"');
                }
                objM296a2 = c0148a5.m296a(strM2188a2, AbstractC1946e.m4350h(c0148a5.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c2.f3734f = objM296a2;
        C0861f c0861f3 = this.f5162f;
        AbstractC1766e.m3917b(c0861f3);
        String strM2188a3 = c0861f3.m2188a("browserId");
        if (strM2188a3 == null || strM2188a3.length() == 0) {
            C1763b c1763bM3927a3 = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a3.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a3 = "";
            } else if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a3 = (String) 0;
            } else if (c1763bM3927a3.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a3 = (String) 0L;
            } else {
                if (!c1763bM3927a3.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a3 = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a9 = C0148a.f356d;
                objM296a3 = c0148a9.m296a(strM2188a3, AbstractC1946e.m4350h(c0148a9.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused3) {
                "browserId".equals("cellularUsageTimestamp");
                if (strM2188a3.startsWith("\"") && strM2188a3.endsWith("\"")) {
                    c0148a4 = C0148a.f356d;
                } else {
                    c0148a4 = C0148a.f356d;
                    strM2188a3 = AbstractC0032g.m153k("\"", strM2188a3, '\"');
                }
                objM296a3 = c0148a4.m296a(strM2188a3, AbstractC1946e.m4350h(c0148a4.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c3.f3734f = objM296a3;
        C0861f c0861f4 = this.f5162f;
        AbstractC1766e.m3917b(c0861f4);
        String strM2188a4 = c0861f4.m2188a("userId");
        if (strM2188a4 == null || strM2188a4.length() == 0) {
            C1763b c1763bM3927a4 = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a4.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a4 = "";
            } else if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a4 = (String) 0;
            } else if (c1763bM3927a4.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a4 = (String) 0L;
            } else {
                if (!c1763bM3927a4.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a4 = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a10 = C0148a.f356d;
                objM296a4 = c0148a10.m296a(strM2188a4, AbstractC1946e.m4350h(c0148a10.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused4) {
                "userId".equals("cellularUsageTimestamp");
                if (strM2188a4.startsWith("\"") && strM2188a4.endsWith("\"")) {
                    c0148a3 = C0148a.f356d;
                } else {
                    c0148a3 = C0148a.f356d;
                    strM2188a4 = AbstractC0032g.m153k("\"", strM2188a4, '\"');
                }
                objM296a4 = c0148a3.m296a(strM2188a4, AbstractC1946e.m4350h(c0148a3.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c4.f3734f = objM296a4;
        C0861f c0861f5 = this.f5162f;
        AbstractC1766e.m3917b(c0861f5);
        String strM2188a5 = c0861f5.m2188a("userAgent");
        if (strM2188a5 == null || strM2188a5.length() == 0) {
            C1763b c1763bM3927a5 = AbstractC1770i.m3927a(String.class);
            if (c1763bM3927a5.equals(AbstractC1770i.m3927a(String.class))) {
                objM296a5 = "";
            } else if (c1763bM3927a5.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                objM296a5 = (String) 0;
            } else if (c1763bM3927a5.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                objM296a5 = (String) 0L;
            } else {
                if (!c1763bM3927a5.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                    throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                }
                objM296a5 = (String) Boolean.FALSE;
            }
        } else {
            try {
                C0148a c0148a11 = C0148a.f356d;
                objM296a5 = c0148a11.m296a(strM2188a5, AbstractC1946e.m4350h(c0148a11.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused5) {
                "userAgent".equals("cellularUsageTimestamp");
                if (strM2188a5.startsWith("\"") && strM2188a5.endsWith("\"")) {
                    c0148a2 = C0148a.f356d;
                } else {
                    c0148a2 = C0148a.f356d;
                    strM2188a5 = AbstractC0032g.m153k("\"", strM2188a5, '\"');
                }
                objM296a5 = c0148a2.m296a(strM2188a5, AbstractC1946e.m4350h(c0148a2.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c5.f3734f = objM296a5;
        C0861f c0861f6 = this.f5162f;
        AbstractC1766e.m3917b(c0861f6);
        String strM2188a6 = c0861f6.m2188a("deviceType");
        if (strM2188a6 == null || strM2188a6.length() == 0) {
            C1763b c1763bM3927a6 = AbstractC1770i.m3927a(String.class);
            if (!c1763bM3927a6.equals(AbstractC1770i.m3927a(String.class))) {
                if (c1763bM3927a6.equals(AbstractC1770i.m3927a(Integer.TYPE))) {
                    str = (String) 0;
                } else if (c1763bM3927a6.equals(AbstractC1770i.m3927a(Long.TYPE))) {
                    str = (String) 0L;
                } else {
                    if (!c1763bM3927a6.equals(AbstractC1770i.m3927a(Boolean.TYPE))) {
                        throw new IllegalArgumentException("Cannot handle empty value for type " + AbstractC1770i.m3927a(String.class));
                    }
                    str = (String) Boolean.FALSE;
                }
            }
            objM296a6 = str;
        } else {
            try {
                C0148a c0148a12 = C0148a.f356d;
                objM296a6 = c0148a12.m296a(strM2188a6, AbstractC1946e.m4350h(c0148a12.f358b, AbstractC1770i.m3928b(String.class)));
            } catch (Exception unused6) {
                "deviceType".equals("cellularUsageTimestamp");
                if (strM2188a6.startsWith("\"") && strM2188a6.endsWith("\"")) {
                    c0148a = C0148a.f356d;
                } else {
                    c0148a = C0148a.f356d;
                    strM2188a6 = AbstractC0032g.m153k("\"", strM2188a6, '\"');
                }
                objM296a6 = c0148a.m296a(strM2188a6, AbstractC1946e.m4350h(c0148a.f358b, AbstractC1770i.m3928b(String.class)));
            }
        }
        c1058c6.f3734f = objM296a6;
        new Thread(new Runnable() { // from class: a2.d
            @Override // java.lang.Runnable
            public final void run() {
                ForegroundService.m3458b(this.f2532e, c1058c, c1058c2, c1058c3, c1058c4, c1058c5, c1058c6);
            }
        }).start();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d(getPackageName(), "ForegroundService:onCreate");
        if (f5158l) {
            stopSelf();
            Log.d(getPackageName(), "ForegroundService:stopSelf");
            return;
        }
        f5158l = true;
        Context applicationContext = getApplicationContext();
        AbstractC1766e.m3919d("getApplicationContext(...)", applicationContext);
        C0862g c0862g = C0862g.f2541f;
        this.f5162f = new C0861f(applicationContext);
        Companion companion = f5157k;
        ClassLoader classLoader = getClassLoader();
        AbstractC1766e.m3919d("getClassLoader(...)", classLoader);
        companion.updateClassLoader(classLoader);
        f5160n = this;
        Object systemService = getSystemService("notification");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.NotificationManager", systemService);
        f5159m = (NotificationManager) systemService;
        Object systemService2 = getSystemService("connectivity");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.net.ConnectivityManager", systemService2);
        this.f5163g = (ConnectivityManager) systemService2;
        NotificationChannel notificationChannel = new NotificationChannel("ForegroundService", "Foreground Service Channel", 3);
        NotificationManager notificationManager = f5159m;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        try {
            Log.d(getPackageName(), "Trying to run initialize");
            initialize();
        } catch (UnsatisfiedLinkError unused) {
            Log.e(getPackageName(), "Error running initialize");
        }
        Object systemService3 = getSystemService("power");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.os.PowerManager", systemService3);
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) systemService3).newWakeLock(1, "grass:wakeLock");
        this.f5161e = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock != null) {
            wakeLockNewWakeLock.acquire();
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Handler handler;
        super.onDestroy();
        f5158l = false;
        Log.w(getPackageName(), "ForegroundService:onDestroy");
        Log.d(getPackageName(), "Stopping periodic checks");
        RunnableC0055o runnableC0055o = this.f5165i;
        if (runnableC0055o != null && (handler = this.f5164h) != null) {
            handler.removeCallbacks(runnableC0055o);
        }
        this.f5164h = null;
        this.f5165i = null;
        Log.d(getPackageName(), "Periodic checks stopped");
        new Thread(new RunnableC0304d(3, this)).start();
        stopForeground(1);
        NotificationManager notificationManager = f5159m;
        if (notificationManager != null) {
            notificationManager.cancel(-1);
        }
        PowerManager.WakeLock wakeLock = this.f5161e;
        if (wakeLock != null) {
            wakeLock.release();
            this.f5161e = null;
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        f5158l = true;
        Log.d(getPackageName(), "Starting periodic checks");
        Handler handler = new Handler(Looper.getMainLooper());
        this.f5164h = handler;
        RunnableC0055o runnableC0055o = new RunnableC0055o(8, this);
        this.f5165i = runnableC0055o;
        handler.post(runnableC0055o);
        Log.d(getPackageName(), "Periodic checks started");
        if (m3464g() && m3462e()) {
            String str = (String) AbstractC0860e.f2539a.get("CELLULAR_LIMIT_EXCEEDED");
            startForeground(-1, str != null ? m3463f(str) : null);
            return 1;
        }
        String str2 = (String) AbstractC0860e.f2539a.get("CONNECTING");
        startForeground(-1, str2 != null ? m3463f(str2) : null);
        try {
            this.f5166j = true;
            m3465i();
        } catch (Exception e3) {
            this.f5166j = false;
            Log.e(getPackageName(), "Error starting websocket: " + e3.getMessage());
        }
        return 1;
    }
}
