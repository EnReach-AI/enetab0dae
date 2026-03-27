package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.activity.result.C0880a;
import java.util.ArrayList;

/* JADX INFO: renamed from: androidx.fragment.app.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0931b implements Parcelable {
    public static final Parcelable.Creator<C0931b> CREATOR = new C0880a(2);

    /* JADX INFO: renamed from: e */
    public final int[] f3135e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f3136f;

    /* JADX INFO: renamed from: g */
    public final int[] f3137g;

    /* JADX INFO: renamed from: h */
    public final int[] f3138h;

    /* JADX INFO: renamed from: i */
    public final int f3139i;

    /* JADX INFO: renamed from: j */
    public final String f3140j;

    /* JADX INFO: renamed from: k */
    public final int f3141k;

    /* JADX INFO: renamed from: l */
    public final int f3142l;

    /* JADX INFO: renamed from: m */
    public final CharSequence f3143m;

    /* JADX INFO: renamed from: n */
    public final int f3144n;

    /* JADX INFO: renamed from: o */
    public final CharSequence f3145o;

    /* JADX INFO: renamed from: p */
    public final ArrayList f3146p;

    /* JADX INFO: renamed from: q */
    public final ArrayList f3147q;

    /* JADX INFO: renamed from: r */
    public final boolean f3148r;

    public C0931b(C0930a c0930a) {
        int size = c0930a.f3117a.size();
        this.f3135e = new int[size * 5];
        if (!c0930a.f3123g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f3136f = new ArrayList(size);
        this.f3137g = new int[size];
        this.f3138h = new int[size];
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            C0924J c0924j = (C0924J) c0930a.f3117a.get(i4);
            int i5 = i3 + 1;
            this.f3135e[i3] = c0924j.f3093a;
            ArrayList arrayList = this.f3136f;
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0924j.f3094b;
            arrayList.add(abstractComponentCallbacksC0944o != null ? abstractComponentCallbacksC0944o.f3226i : null);
            int[] iArr = this.f3135e;
            iArr[i5] = c0924j.f3095c;
            iArr[i3 + 2] = c0924j.f3096d;
            int i6 = i3 + 4;
            iArr[i3 + 3] = c0924j.f3097e;
            i3 += 5;
            iArr[i6] = c0924j.f3098f;
            this.f3137g[i4] = c0924j.f3099g.ordinal();
            this.f3138h[i4] = c0924j.f3100h.ordinal();
        }
        this.f3139i = c0930a.f3122f;
        this.f3140j = c0930a.f3124h;
        this.f3141k = c0930a.f3134r;
        this.f3142l = c0930a.f3125i;
        this.f3143m = c0930a.f3126j;
        this.f3144n = c0930a.f3127k;
        this.f3145o = c0930a.f3128l;
        this.f3146p = c0930a.f3129m;
        this.f3147q = c0930a.f3130n;
        this.f3148r = c0930a.f3131o;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeIntArray(this.f3135e);
        parcel.writeStringList(this.f3136f);
        parcel.writeIntArray(this.f3137g);
        parcel.writeIntArray(this.f3138h);
        parcel.writeInt(this.f3139i);
        parcel.writeString(this.f3140j);
        parcel.writeInt(this.f3141k);
        parcel.writeInt(this.f3142l);
        TextUtils.writeToParcel(this.f3143m, parcel, 0);
        parcel.writeInt(this.f3144n);
        TextUtils.writeToParcel(this.f3145o, parcel, 0);
        parcel.writeStringList(this.f3146p);
        parcel.writeStringList(this.f3147q);
        parcel.writeInt(this.f3148r ? 1 : 0);
    }

    public C0931b(Parcel parcel) {
        this.f3135e = parcel.createIntArray();
        this.f3136f = parcel.createStringArrayList();
        this.f3137g = parcel.createIntArray();
        this.f3138h = parcel.createIntArray();
        this.f3139i = parcel.readInt();
        this.f3140j = parcel.readString();
        this.f3141k = parcel.readInt();
        this.f3142l = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f3143m = (CharSequence) creator.createFromParcel(parcel);
        this.f3144n = parcel.readInt();
        this.f3145o = (CharSequence) creator.createFromParcel(parcel);
        this.f3146p = parcel.createStringArrayList();
        this.f3147q = parcel.createStringArrayList();
        this.f3148r = parcel.readInt() != 0;
    }
}
