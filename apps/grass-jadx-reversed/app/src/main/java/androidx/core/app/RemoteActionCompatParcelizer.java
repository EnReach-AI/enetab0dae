package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import p095f0.AbstractC1344a;
import p095f0.C1345b;
import p095f0.InterfaceC1346c;

/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1344a abstractC1344a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC1346c interfaceC1346cM3298h = remoteActionCompat.f2911a;
        if (abstractC1344a.mo3295e(1)) {
            interfaceC1346cM3298h = abstractC1344a.m3298h();
        }
        remoteActionCompat.f2911a = (IconCompat) interfaceC1346cM3298h;
        CharSequence charSequence = remoteActionCompat.f2912b;
        if (abstractC1344a.mo3295e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C1345b) abstractC1344a).f4807e);
        }
        remoteActionCompat.f2912b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f2913c;
        if (abstractC1344a.mo3295e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C1345b) abstractC1344a).f4807e);
        }
        remoteActionCompat.f2913c = charSequence2;
        remoteActionCompat.f2914d = (PendingIntent) abstractC1344a.m3297g(remoteActionCompat.f2914d, 4);
        boolean z3 = remoteActionCompat.f2915e;
        if (abstractC1344a.mo3295e(5)) {
            z3 = ((C1345b) abstractC1344a).f4807e.readInt() != 0;
        }
        remoteActionCompat.f2915e = z3;
        boolean z4 = remoteActionCompat.f2916f;
        if (abstractC1344a.mo3295e(6)) {
            z4 = ((C1345b) abstractC1344a).f4807e.readInt() != 0;
        }
        remoteActionCompat.f2916f = z4;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1344a abstractC1344a) {
        abstractC1344a.getClass();
        IconCompat iconCompat = remoteActionCompat.f2911a;
        abstractC1344a.mo3299i(1);
        abstractC1344a.m3301k(iconCompat);
        CharSequence charSequence = remoteActionCompat.f2912b;
        abstractC1344a.mo3299i(2);
        Parcel parcel = ((C1345b) abstractC1344a).f4807e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f2913c;
        abstractC1344a.mo3299i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        PendingIntent pendingIntent = remoteActionCompat.f2914d;
        abstractC1344a.mo3299i(4);
        parcel.writeParcelable(pendingIntent, 0);
        boolean z3 = remoteActionCompat.f2915e;
        abstractC1344a.mo3299i(5);
        parcel.writeInt(z3 ? 1 : 0);
        boolean z4 = remoteActionCompat.f2916f;
        abstractC1344a.mo3299i(6);
        parcel.writeInt(z4 ? 1 : 0);
    }
}
