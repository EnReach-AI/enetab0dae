package io.getgrass.www;

import android.content.Context;
import p119m2.AbstractC1766e;
import p165z.AbstractC2049e;

/* JADX INFO: loaded from: classes.dex */
public final class PermissionHelper {
    /* JADX INFO: renamed from: a */
    public static boolean m3468a(Context context, String[] strArr) {
        for (String str : strArr) {
            AbstractC1766e.m3917b(context);
            if (AbstractC2049e.m4523a(context, str) != 0) {
                return false;
            }
        }
        return true;
    }
}
