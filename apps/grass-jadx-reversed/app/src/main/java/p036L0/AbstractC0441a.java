package p036L0;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: L0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0441a implements Parcelable {

    /* JADX INFO: renamed from: e */
    public final Uri f1074e;

    /* JADX INFO: renamed from: f */
    public final List f1075f;

    /* JADX INFO: renamed from: g */
    public final String f1076g;

    /* JADX INFO: renamed from: h */
    public final String f1077h;

    /* JADX INFO: renamed from: i */
    public final String f1078i;

    /* JADX INFO: renamed from: j */
    public final C0442b f1079j;

    public AbstractC0441a(Parcel parcel) {
        this.f1074e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f1075f = arrayList.size() == 0 ? null : Collections.unmodifiableList(arrayList);
        this.f1076g = parcel.readString();
        this.f1077h = parcel.readString();
        this.f1078i = parcel.readString();
        C0444d c0444d = new C0444d();
        C0442b c0442b = (C0442b) parcel.readParcelable(C0442b.class.getClassLoader());
        if (c0442b != null) {
            c0444d.f1085e = c0442b.f1080e;
        }
        this.f1079j = new C0442b(c0444d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f1074e, 0);
        parcel.writeStringList(this.f1075f);
        parcel.writeString(this.f1076g);
        parcel.writeString(this.f1077h);
        parcel.writeString(this.f1078i);
        parcel.writeParcelable(this.f1079j, 0);
    }
}
