package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.nio.charset.Charset;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p095f0.AbstractC1344a;
import p095f0.C1345b;

/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC1344a abstractC1344a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2922a = abstractC1344a.m3296f(iconCompat.f2922a, 1);
        byte[] bArr = iconCompat.f2924c;
        if (abstractC1344a.mo3295e(2)) {
            Parcel parcel = ((C1345b) abstractC1344a).f4807e;
            int i3 = parcel.readInt();
            if (i3 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i3];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f2924c = bArr;
        iconCompat.f2925d = abstractC1344a.m3297g(iconCompat.f2925d, 3);
        iconCompat.f2926e = abstractC1344a.m3296f(iconCompat.f2926e, 4);
        iconCompat.f2927f = abstractC1344a.m3296f(iconCompat.f2927f, 5);
        iconCompat.f2928g = (ColorStateList) abstractC1344a.m3297g(iconCompat.f2928g, 6);
        String string = iconCompat.f2930i;
        if (abstractC1344a.mo3295e(7)) {
            string = ((C1345b) abstractC1344a).f4807e.readString();
        }
        iconCompat.f2930i = string;
        String string2 = iconCompat.f2931j;
        if (abstractC1344a.mo3295e(8)) {
            string2 = ((C1345b) abstractC1344a).f4807e.readString();
        }
        iconCompat.f2931j = string2;
        iconCompat.f2929h = PorterDuff.Mode.valueOf(iconCompat.f2930i);
        switch (iconCompat.f2922a) {
            case -1:
                Parcelable parcelable = iconCompat.f2925d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f2923b = parcelable;
                return iconCompat;
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
            default:
                return iconCompat;
            case 1:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                Parcelable parcelable2 = iconCompat.f2925d;
                if (parcelable2 != null) {
                    iconCompat.f2923b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f2924c;
                    iconCompat.f2923b = bArr3;
                    iconCompat.f2922a = 3;
                    iconCompat.f2926e = 0;
                    iconCompat.f2927f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                String str = new String(iconCompat.f2924c, Charset.forName("UTF-16"));
                iconCompat.f2923b = str;
                if (iconCompat.f2922a == 2 && iconCompat.f2931j == null) {
                    iconCompat.f2931j = str.split(":", -1)[0];
                }
                return iconCompat;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                iconCompat.f2923b = iconCompat.f2924c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC1344a abstractC1344a) {
        abstractC1344a.getClass();
        iconCompat.f2930i = iconCompat.f2929h.name();
        switch (iconCompat.f2922a) {
            case -1:
                iconCompat.f2925d = (Parcelable) iconCompat.f2923b;
                break;
            case 1:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                iconCompat.f2925d = (Parcelable) iconCompat.f2923b;
                break;
            case 2:
                iconCompat.f2924c = ((String) iconCompat.f2923b).getBytes(Charset.forName("UTF-16"));
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                iconCompat.f2924c = (byte[]) iconCompat.f2923b;
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                iconCompat.f2924c = iconCompat.f2923b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i3 = iconCompat.f2922a;
        if (-1 != i3) {
            abstractC1344a.m3300j(i3, 1);
        }
        byte[] bArr = iconCompat.f2924c;
        if (bArr != null) {
            abstractC1344a.mo3299i(2);
            int length = bArr.length;
            Parcel parcel = ((C1345b) abstractC1344a).f4807e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f2925d;
        if (parcelable != null) {
            abstractC1344a.mo3299i(3);
            ((C1345b) abstractC1344a).f4807e.writeParcelable(parcelable, 0);
        }
        int i4 = iconCompat.f2926e;
        if (i4 != 0) {
            abstractC1344a.m3300j(i4, 4);
        }
        int i5 = iconCompat.f2927f;
        if (i5 != 0) {
            abstractC1344a.m3300j(i5, 5);
        }
        ColorStateList colorStateList = iconCompat.f2928g;
        if (colorStateList != null) {
            abstractC1344a.mo3299i(6);
            ((C1345b) abstractC1344a).f4807e.writeParcelable(colorStateList, 0);
        }
        String str = iconCompat.f2930i;
        if (str != null) {
            abstractC1344a.mo3299i(7);
            ((C1345b) abstractC1344a).f4807e.writeString(str);
        }
        String str2 = iconCompat.f2931j;
        if (str2 != null) {
            abstractC1344a.mo3299i(8);
            ((C1345b) abstractC1344a).f4807e.writeString(str2);
        }
    }
}
