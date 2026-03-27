package p029J;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: J.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0339e implements InterfaceC0337d, InterfaceC0341f {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f836e = 0;

    /* JADX INFO: renamed from: f */
    public ClipData f837f;

    /* JADX INFO: renamed from: g */
    public int f838g;

    /* JADX INFO: renamed from: h */
    public int f839h;

    /* JADX INFO: renamed from: i */
    public Uri f840i;

    /* JADX INFO: renamed from: j */
    public Bundle f841j;

    public /* synthetic */ C0339e() {
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: b */
    public ClipData mo443b() {
        return this.f837f;
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: d */
    public C0343g mo731d() {
        return new C0343g(new C0339e(this));
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: e */
    public void mo732e(Bundle bundle) {
        this.f841j = bundle;
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: f */
    public int mo446f() {
        return this.f839h;
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: g */
    public void mo733g(Uri uri) {
        this.f840i = uri;
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: h */
    public ContentInfo mo448h() {
        return null;
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: j */
    public void mo734j(int i3) {
        this.f839h = i3;
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: n */
    public int mo453n() {
        return this.f838g;
    }

    public String toString() {
        String str;
        switch (this.f836e) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f837f.getDescription());
                sb.append(", source=");
                int i3 = this.f838g;
                sb.append(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? String.valueOf(i3) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i4 = this.f839h;
                sb.append((i4 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i4));
                Uri uri = this.f840i;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return AbstractC0032g.m157o(sb, this.f841j != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public C0339e(C0339e c0339e) {
        ClipData clipData = c0339e.f837f;
        clipData.getClass();
        this.f837f = clipData;
        int i3 = c0339e.f838g;
        if (i3 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i3 > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.f838g = i3;
        int i4 = c0339e.f839h;
        if ((i4 & 1) == i4) {
            this.f839h = i4;
            this.f840i = c0339e.f840i;
            this.f841j = c0339e.f841j;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i4) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
