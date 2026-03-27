package com.facebook;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Locale;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.C2085w;

/* JADX INFO: renamed from: com.facebook.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1124u implements InterfaceC1122s {

    /* JADX INFO: renamed from: e */
    public boolean f3896e;

    /* JADX INFO: renamed from: f */
    public boolean f3897f;

    /* JADX INFO: renamed from: g */
    public Object f3898g;

    /* JADX INFO: renamed from: h */
    public Object f3899h;

    /* JADX INFO: renamed from: a */
    public void m2901a(String str, Object... objArr) throws IOException {
        boolean z3 = this.f3897f;
        OutputStream outputStream = (OutputStream) this.f3898g;
        if (z3) {
            outputStream.write(URLEncoder.encode(String.format(Locale.US, str, objArr), "UTF-8").getBytes());
            return;
        }
        if (this.f3896e) {
            outputStream.write("--".getBytes());
            outputStream.write(C1125v.f3900j.getBytes());
            outputStream.write("\r\n".getBytes());
            this.f3896e = false;
        }
        outputStream.write(String.format(str, objArr).getBytes());
    }

    /* JADX INFO: renamed from: b */
    public void m2902b(String str, String str2, String str3) throws IOException {
        if (this.f3897f) {
            ((OutputStream) this.f3898g).write((str + "=").getBytes());
            return;
        }
        m2901a("Content-Disposition: form-data; name=\"%s\"", str);
        if (str2 != null) {
            m2901a("; filename=\"%s\"", str2);
        }
        m2905e("", new Object[0]);
        if (str3 != null) {
            m2905e("%s: %s", "Content-Type", str3);
        }
        m2905e("", new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    public void m2903c(String str, Uri uri, String str2) throws Throwable {
        if (str2 == null) {
            str2 = "content/unknown";
        }
        m2902b(str, str, str2);
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        AbstractC2056E.m4538g(AbstractC1117n.f3882h.getContentResolver().openInputStream(uri), (OutputStream) this.f3898g);
        m2905e("", new Object[0]);
        m2907h();
        if (((C2085w) this.f3899h) != null) {
            Locale locale = Locale.ROOT;
            AbstractC1117n.m2896f();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m2904d(String str, ParcelFileDescriptor parcelFileDescriptor, String str2) throws Throwable {
        if (str2 == null) {
            str2 = "content/unknown";
        }
        m2902b(str, str, str2);
        AbstractC2056E.m4538g(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), (OutputStream) this.f3898g);
        m2905e("", new Object[0]);
        m2907h();
        if (((C2085w) this.f3899h) != null) {
            Locale locale = Locale.ROOT;
            AbstractC1117n.m2896f();
        }
    }

    /* JADX INFO: renamed from: e */
    public void m2905e(String str, Object... objArr) throws IOException {
        m2901a(str, objArr);
        if (this.f3897f) {
            return;
        }
        m2901a("\r\n", new Object[0]);
    }

    @Override // com.facebook.InterfaceC1122s
    /* JADX INFO: renamed from: f */
    public void mo980f(String str, String str2) throws IOException {
        m2902b(str, null, null);
        m2905e("%s", str2);
        m2907h();
        if (((C2085w) this.f3899h) != null) {
            AbstractC1117n.m2896f();
        }
    }

    /* JADX INFO: renamed from: g */
    public void m2906g(String str, Object obj, C1125v c1125v) {
        if (C1125v.m2912k(obj)) {
            mo980f(str, C1125v.m2914m(obj));
            return;
        }
        boolean z3 = obj instanceof Bitmap;
        OutputStream outputStream = (OutputStream) this.f3898g;
        C2085w c2085w = (C2085w) this.f3899h;
        if (z3) {
            m2902b(str, str, "image/png");
            ((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            m2905e("", new Object[0]);
            m2907h();
            if (c2085w != null) {
                AbstractC1117n.m2896f();
                return;
            }
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            m2902b(str, str, "content/unknown");
            outputStream.write(bArr);
            m2905e("", new Object[0]);
            m2907h();
            if (c2085w != null) {
                Locale locale = Locale.ROOT;
                int length = bArr.length;
                AbstractC1117n.m2896f();
                return;
            }
            return;
        }
        if (obj instanceof Uri) {
            m2903c(str, (Uri) obj, null);
            return;
        }
        if (obj instanceof ParcelFileDescriptor) {
            m2904d(str, (ParcelFileDescriptor) obj, null);
            return;
        }
        if (!(obj instanceof C1123t)) {
            throw new IllegalArgumentException("value is not a supported type.");
        }
        C1123t c1123t = (C1123t) obj;
        Parcelable parcelable = c1123t.f3895f;
        boolean z4 = parcelable instanceof ParcelFileDescriptor;
        String str2 = c1123t.f3894e;
        if (z4) {
            m2904d(str, (ParcelFileDescriptor) parcelable, str2);
        } else {
            if (!(parcelable instanceof Uri)) {
                throw new IllegalArgumentException("value is not a supported type.");
            }
            m2903c(str, (Uri) parcelable, str2);
        }
    }

    /* JADX INFO: renamed from: h */
    public void m2907h() throws IOException {
        if (!this.f3897f) {
            m2905e("--%s", C1125v.f3900j);
        } else {
            ((OutputStream) this.f3898g).write("&".getBytes());
        }
    }
}
