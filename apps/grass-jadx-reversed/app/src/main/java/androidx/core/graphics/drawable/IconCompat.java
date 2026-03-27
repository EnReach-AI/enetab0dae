package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import p009C.AbstractC0141d;
import p009C.AbstractC0143f;

/* JADX INFO: loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* JADX INFO: renamed from: k */
    public static final PorterDuff.Mode f2921k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    public Object f2923b;

    /* JADX INFO: renamed from: j */
    public String f2931j;

    /* JADX INFO: renamed from: a */
    public int f2922a = -1;

    /* JADX INFO: renamed from: c */
    public byte[] f2924c = null;

    /* JADX INFO: renamed from: d */
    public Parcelable f2925d = null;

    /* JADX INFO: renamed from: e */
    public int f2926e = 0;

    /* JADX INFO: renamed from: f */
    public int f2927f = 0;

    /* JADX INFO: renamed from: g */
    public ColorStateList f2928g = null;

    /* JADX INFO: renamed from: h */
    public PorterDuff.Mode f2929h = f2921k;

    /* JADX INFO: renamed from: i */
    public String f2930i = null;

    /* JADX INFO: renamed from: a */
    public static IconCompat m2316a(int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2924c = null;
        iconCompat.f2925d = null;
        iconCompat.f2927f = 0;
        iconCompat.f2928g = null;
        iconCompat.f2929h = f2921k;
        iconCompat.f2930i = null;
        iconCompat.f2922a = 2;
        iconCompat.f2926e = i3;
        iconCompat.f2923b = "";
        iconCompat.f2931j = "";
        return iconCompat;
    }

    /* JADX INFO: renamed from: b */
    public final int m2317b() {
        int i3 = this.f2922a;
        if (i3 == -1) {
            return AbstractC0143f.m289a(this.f2923b);
        }
        if (i3 == 2) {
            return this.f2926e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    /* JADX INFO: renamed from: c */
    public final Uri m2318c() {
        int i3 = this.f2922a;
        if (i3 == -1) {
            return AbstractC0141d.m284a(this.f2923b);
        }
        if (i3 == 4 || i3 == 6) {
            return Uri.parse((String) this.f2923b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f2922a == -1) {
            return String.valueOf(this.f2923b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2922a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                str = "DATA";
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                str = "URI";
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                str = "BITMAP_MASKABLE";
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f2922a) {
            case 1:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2923b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2923b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2931j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m2317b())));
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                sb.append(" len=");
                sb.append(this.f2926e);
                if (this.f2927f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2927f);
                }
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                sb.append(" uri=");
                sb.append(this.f2923b);
                break;
        }
        if (this.f2928g != null) {
            sb.append(" tint=");
            sb.append(this.f2928g);
        }
        if (this.f2929h != f2921k) {
            sb.append(" mode=");
            sb.append(this.f2929h);
        }
        sb.append(")");
        return sb.toString();
    }
}
