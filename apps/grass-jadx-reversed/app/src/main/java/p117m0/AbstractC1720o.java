package p117m0;

import android.graphics.drawable.Drawable;
import p009C.AbstractC0139b;

/* JADX INFO: renamed from: m0.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1720o {
    /* JADX WARN: Removed duplicated region for block: B:32:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3820a(android.content.Context r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "locales"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = "Storing App Locales : Failed to persist app-locales: "
            java.lang.String r3 = "Storing App Locales : app-locales: "
            java.lang.String r4 = ""
            boolean r4 = r9.equals(r4)
            java.lang.String r5 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            if (r4 == 0) goto L16
            r8.deleteFile(r5)
            return
        L16:
            r4 = 0
            java.io.FileOutputStream r8 = r8.openFileOutput(r5, r4)     // Catch: java.io.FileNotFoundException -> L66
            org.xmlpull.v1.XmlSerializer r4 = android.util.Xml.newSerializer()
            r5 = 0
            r4.setOutput(r8, r5)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r6 = "UTF-8"
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.startDocument(r6, r7)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.startTag(r5, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r6 = "application_locales"
            r4.attribute(r5, r6, r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.endTag(r5, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r4.endDocument()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            r0.append(r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r3 = " persisted successfully."
            r0.append(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            android.util.Log.d(r1, r0)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54
            if (r8 == 0) goto L5f
        L4e:
            r8.close()     // Catch: java.io.IOException -> L5f
            goto L5f
        L52:
            r9 = move-exception
            goto L60
        L54:
            r0 = move-exception
            java.lang.String r9 = r2.concat(r9)     // Catch: java.lang.Throwable -> L52
            android.util.Log.w(r1, r9, r0)     // Catch: java.lang.Throwable -> L52
            if (r8 == 0) goto L5f
            goto L4e
        L5f:
            return
        L60:
            if (r8 == 0) goto L65
            r8.close()     // Catch: java.io.IOException -> L65
        L65:
            throw r9
        L66:
            java.lang.String r8 = "Storing App Locales : FileNotFoundException: Cannot open file androidx.appcompat.app.AppCompatDelegate.application_locales_record_file for writing "
            android.util.Log.w(r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p117m0.AbstractC1720o.m3820a(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r2 = r4.getAttributeValue(null, "application_locales");
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0045 A[EXC_TOP_SPLITTER, PHI: r2
      0x0045: PHI (r2v2 java.lang.String) = (r2v0 java.lang.String), (r2v4 java.lang.String) binds: [B:25:0x004e, B:21:0x0043] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m3821b(android.content.Context r9) {
        /*
            java.lang.String r0 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.String r1 = "AppLocalesStorageHelper"
            java.lang.String r2 = ""
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch: java.io.FileNotFoundException -> L6b
            org.xmlpull.v1.XmlPullParser r4 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r5 = "UTF-8"
            r4.setInput(r3, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            int r5 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L17:
            int r6 = r4.next()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            r7 = 1
            if (r6 == r7) goto L43
            r7 = 3
            if (r6 != r7) goto L2a
            int r8 = r4.getDepth()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r8 <= r5) goto L43
            goto L2a
        L28:
            r9 = move-exception
            goto L65
        L2a:
            if (r6 == r7) goto L17
            r7 = 4
            if (r6 != r7) goto L30
            goto L17
        L30:
            java.lang.String r6 = r4.getName()     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            java.lang.String r7 = "locales"
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
            if (r6 == 0) goto L17
            java.lang.String r5 = "application_locales"
            r6 = 0
            java.lang.String r2 = r4.getAttributeValue(r6, r5)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L49
        L43:
            if (r3 == 0) goto L51
        L45:
            r3.close()     // Catch: java.io.IOException -> L51
            goto L51
        L49:
            java.lang.String r4 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r3 == 0) goto L51
            goto L45
        L51:
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L61
            java.lang.String r9 = "Reading app Locales : Locales read from file: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file , appLocales: "
            java.lang.String r9 = r9.concat(r2)
            android.util.Log.d(r1, r9)
            goto L64
        L61:
            r9.deleteFile(r0)
        L64:
            return r2
        L65:
            if (r3 == 0) goto L6a
            r3.close()     // Catch: java.io.IOException -> L6a
        L6a:
            throw r9
        L6b:
            java.lang.String r9 = "Reading app Locales : Locales record file not found: androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r1, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p117m0.AbstractC1720o.m3821b(android.content.Context):java.lang.String");
    }

    /* JADX INFO: renamed from: c */
    public static void m3822c(Drawable drawable, int i3) {
        AbstractC0139b.m279g(drawable, i3);
    }
}
