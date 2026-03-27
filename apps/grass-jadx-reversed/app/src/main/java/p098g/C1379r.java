package p098g;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import androidx.fragment.app.AbstractC0935f;
import java.util.Calendar;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p165z.AbstractC2049e;
import p166z0.C2071i;

/* JADX INFO: renamed from: g.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1379r extends AbstractC0935f {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4928c = 0;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ LayoutInflaterFactory2C1382u f4929d;

    /* JADX INFO: renamed from: e */
    public final Object f4930e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1379r(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u, C2071i c2071i) {
        super(layoutInflaterFactory2C1382u);
        this.f4929d = layoutInflaterFactory2C1382u;
        this.f4930e = c2071i;
    }

    @Override // androidx.fragment.app.AbstractC0935f
    /* JADX INFO: renamed from: f */
    public final IntentFilter mo2451f() {
        switch (this.f4928c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // androidx.fragment.app.AbstractC0935f
    /* JADX INFO: renamed from: g */
    public final int mo2452g() {
        Location location;
        boolean z3;
        long j2;
        switch (this.f4928c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((PowerManager) this.f4930e).isPowerSaveMode() ? 2 : 1;
            default:
                C2071i c2071i = (C2071i) this.f4930e;
                C1358D c1358d = (C1358D) c2071i.f7316c;
                if (c1358d.f4832b <= System.currentTimeMillis()) {
                    Context context = (Context) c2071i.f7314a;
                    int iM4524b = AbstractC2049e.m4524b(context, "android.permission.ACCESS_COARSE_LOCATION");
                    Location lastKnownLocation = null;
                    LocationManager locationManager = (LocationManager) c2071i.f7315b;
                    if (iM4524b == 0) {
                        try {
                        } catch (Exception e3) {
                            Log.d("TwilightManager", "Failed to get last known location", e3);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (AbstractC2049e.m4524b(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e4) {
                            Log.d("TwilightManager", "Failed to get last known location", e4);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (C1357C.f4827d == null) {
                            C1357C.f4827d = new C1357C();
                        }
                        C1357C c1357c = C1357C.f4827d;
                        c1357c.m3311a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        c1357c.m3311a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z3 = c1357c.f4830c == 1;
                        long j3 = c1357c.f4829b;
                        long j4 = c1357c.f4828a;
                        c1357c.m3311a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
                        long j5 = c1357c.f4829b;
                        if (j3 == -1 || j4 == -1) {
                            j2 = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis <= j4) {
                                j5 = jCurrentTimeMillis > j3 ? j4 : j3;
                            }
                            j2 = j5 + 60000;
                        }
                        c1358d.f4831a = z3;
                        c1358d.f4832b = j2;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i3 = Calendar.getInstance().get(11);
                        if (i3 < 6 || i3 >= 22) {
                            z3 = true;
                        }
                    }
                    break;
                } else {
                    z3 = c1358d.f4831a;
                }
                return z3 ? 2 : 1;
        }
    }

    @Override // androidx.fragment.app.AbstractC0935f
    /* JADX INFO: renamed from: i */
    public final void mo2454i() {
        switch (this.f4928c) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f4929d.m3380n(true, true);
                break;
            default:
                this.f4929d.m3380n(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1379r(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u, Context context) {
        super(layoutInflaterFactory2C1382u);
        this.f4929d = layoutInflaterFactory2C1382u;
        this.f4930e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
