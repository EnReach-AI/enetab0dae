package io.getgrass.www;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class Logger {

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static String m3466a(String... strArr) {
            if (!(!(strArr.length == 0))) {
                return "Tauri";
            }
            return "Tauri/" + TextUtils.join("/", strArr);
        }
    }
}
