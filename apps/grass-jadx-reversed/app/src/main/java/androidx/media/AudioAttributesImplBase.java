package androidx.media;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.Arrays;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a */
    public int f3355a = 0;

    /* JADX INFO: renamed from: b */
    public int f3356b = 0;

    /* JADX INFO: renamed from: c */
    public int f3357c = 0;

    /* JADX INFO: renamed from: d */
    public int f3358d = -1;

    public final boolean equals(Object obj) {
        int i3;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f3356b == audioAttributesImplBase.f3356b) {
            int i4 = this.f3357c;
            int i5 = audioAttributesImplBase.f3357c;
            int i6 = audioAttributesImplBase.f3358d;
            if (i6 == -1) {
                int i7 = audioAttributesImplBase.f3355a;
                int i8 = AudioAttributesCompat.f3351b;
                if ((i5 & 1) != 1) {
                    if ((i5 & 4) != 4) {
                        switch (i7) {
                            case 2:
                                i3 = 0;
                                break;
                            case FromStringDeserializer.Std.STD_URI /* 3 */:
                                i3 = 8;
                                break;
                            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                                i3 = 4;
                                break;
                            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                                i3 = 5;
                                break;
                            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                                i3 = 2;
                                break;
                            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                                i3 = 10;
                                break;
                            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                            default:
                                i3 = 3;
                                break;
                            case 13:
                                i3 = 1;
                                break;
                        }
                    } else {
                        i3 = 6;
                    }
                } else {
                    i3 = 7;
                }
            } else {
                i3 = i6;
            }
            if (i3 == 6) {
                i5 |= 4;
            } else if (i3 == 7) {
                i5 |= 1;
            }
            if (i4 == (i5 & 273) && this.f3355a == audioAttributesImplBase.f3355a && this.f3358d == i6) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3356b), Integer.valueOf(this.f3357c), Integer.valueOf(this.f3355a), Integer.valueOf(this.f3358d)});
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3358d != -1) {
            sb.append(" stream=");
            sb.append(this.f3358d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i3 = this.f3355a;
        int i4 = AudioAttributesCompat.f3351b;
        switch (i3) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                str = "USAGE_UNKNOWN";
                break;
            case 1:
                str = "USAGE_MEDIA";
                break;
            case 2:
                str = "USAGE_VOICE_COMMUNICATION";
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                str = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                str = "USAGE_ALARM";
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                str = "USAGE_NOTIFICATION";
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                str = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                str = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                str = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                str = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                str = "USAGE_NOTIFICATION_EVENT";
                break;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                str = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                str = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                str = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                str = "USAGE_GAME";
                break;
            case 15:
            default:
                str = "unknown usage " + i3;
                break;
            case 16:
                str = "USAGE_ASSISTANT";
                break;
        }
        sb.append(str);
        sb.append(" content=");
        sb.append(this.f3356b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3357c).toUpperCase());
        return sb.toString();
    }
}
