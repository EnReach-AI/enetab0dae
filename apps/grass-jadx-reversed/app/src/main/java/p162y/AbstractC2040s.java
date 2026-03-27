package p162y;

import android.app.RemoteInput;

/* JADX INFO: renamed from: y.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2040s {
    /* JADX INFO: renamed from: a */
    public static int m4504a(Object obj) {
        return ((RemoteInput) obj).getEditChoicesBeforeSending();
    }

    /* JADX INFO: renamed from: b */
    public static RemoteInput.Builder m4505b(RemoteInput.Builder builder, int i3) {
        return builder.setEditChoicesBeforeSending(i3);
    }
}
