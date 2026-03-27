package p005B;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import android.support.v4.media.session.AbstractC0864a;
import java.io.IOException;
import p001A.C0006g;
import p001A.C0007h;
import p021G.C0233j;

/* JADX INFO: renamed from: B.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0036k extends AbstractC0864a {
    /* JADX INFO: renamed from: j */
    public static Font m186j(FontFamily fontFamily, int i3) {
        FontStyle fontStyle = new FontStyle((i3 & 1) != 0 ? 700 : 400, (i3 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iM187k = m187k(fontStyle, font.getStyle());
        for (int i4 = 1; i4 < fontFamily.getSize(); i4++) {
            Font font2 = fontFamily.getFont(i4);
            int iM187k2 = m187k(fontStyle, font2.getStyle());
            if (iM187k2 < iM187k) {
                font = font2;
                iM187k = iM187k2;
            }
        }
        return font;
    }

    /* JADX INFO: renamed from: k */
    public static int m187k(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: d */
    public final Typeface mo175d(Context context, C0006g c0006g, Resources resources, int i3) {
        try {
            FontFamily.Builder builder = null;
            for (C0007h c0007h : c0006g.f18a) {
                try {
                    Font fontBuild = new Font.Builder(resources, c0007h.f24f).setWeight(c0007h.f20b).setSlant(c0007h.f21c ? 1 : 0).setTtcIndex(c0007h.f23e).setFontVariationSettings(c0007h.f22d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m186j(fontFamilyBuild, i3).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: e */
    public final Typeface mo176e(Context context, C0233j[] c0233jArr, int i3) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (C0233j c0233j : c0233jArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(c0233j.f558a, "r", null);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(c0233j.f560c).setSlant(c0233j.f561d ? 1 : 0).setTtcIndex(c0233j.f559b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(m186j(fontFamilyBuild, i3).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: f */
    public final Typeface mo177f(Context context, Resources resources, int i3, String str, int i4) {
        try {
            Font fontBuild = new Font.Builder(resources, i3).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.support.v4.media.session.AbstractC0864a
    /* JADX INFO: renamed from: g */
    public final C0233j mo188g(C0233j[] c0233jArr, int i3) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
