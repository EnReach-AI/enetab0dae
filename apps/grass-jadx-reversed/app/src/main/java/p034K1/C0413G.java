package p034K1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import p007B1.C0042b;
import p046P.AbstractC0573b;

/* JADX INFO: renamed from: K1.G */
/* JADX INFO: loaded from: classes.dex */
public final class C0413G extends AbstractC0573b {
    public static final Parcelable.Creator<C0413G> CREATOR = new C0042b(2);

    /* JADX INFO: renamed from: g */
    public CharSequence f940g;

    /* JADX INFO: renamed from: h */
    public boolean f941h;

    public C0413G(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f940g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f941h = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f940g) + "}";
    }

    @Override // p046P.AbstractC0573b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        TextUtils.writeToParcel(this.f940g, parcel, i3);
        parcel.writeInt(this.f941h ? 1 : 0);
    }
}
