package p166z0;

import android.R;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

/* JADX INFO: renamed from: z0.n */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC2076n {
    Unknown(-1),
    Core(0),
    AppEvents(65536),
    CodelessEvents(65792),
    RestrictiveDataFiltering(66048),
    AAM(66304),
    PrivacyProtection(66560),
    SuggestedEvents(66561),
    IntelligentIntegrity(66562),
    ModelRequest(66563),
    EventDeactivation(66816),
    OnDeviceEventProcessing(67072),
    OnDevicePostInstallEventProcessing(67073),
    Instrument(131072),
    CrashReport(131328),
    CrashShield(131329),
    ThreadCheck(131330),
    ErrorReport(131584),
    Monitoring(196608),
    /* JADX INFO: Fake field, exist only in values array */
    Login(16777216),
    ChromeCustomTabsPrefetching(R.attr.theme),
    IgnoreAppSwitchToLoggedOut(R.id.background),
    /* JADX INFO: Fake field, exist only in values array */
    Share(33554432),
    /* JADX INFO: Fake field, exist only in values array */
    Places(50331648);


    /* JADX INFO: renamed from: e */
    public final int f7344e;

    EnumC2076n(int i3) {
        this.f7344e = i3;
    }

    /* JADX INFO: renamed from: a */
    public static EnumC2076n m4611a(int i3) {
        for (EnumC2076n enumC2076n : values()) {
            if (enumC2076n.f7344e == i3) {
                return enumC2076n;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum
    public final String toString() {
        switch (ordinal()) {
            case 1:
                return "CoreKit";
            case 2:
                return "AppEvents";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return "CodelessEvents";
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return "RestrictiveDataFiltering";
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return "AAM";
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return "PrivacyProtection";
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return "SuggestedEvents";
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return "IntelligentIntegrity";
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return "ModelRequest";
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return "EventDeactivation";
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return "OnDeviceEventProcessing";
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return "OnDevicePostInstallEventProcessing";
            case 13:
                return "Instrument";
            case 14:
                return "CrashReport";
            case 15:
                return "CrashShield";
            case 16:
                return "ThreadCheck";
            case 17:
                return "ErrorReport";
            case 18:
                return "Monitoring";
            case 19:
                return "LoginKit";
            case 20:
                return "ChromeCustomTabsPrefetching";
            case 21:
                return "IgnoreAppSwitchToLoggedOut";
            case 22:
                return "ShareKit";
            case 23:
                return "PlacesKit";
            default:
                return "unknown";
        }
    }
}
