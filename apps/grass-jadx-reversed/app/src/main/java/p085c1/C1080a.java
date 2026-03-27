package p085c1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import io.getgrass.www.R;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p001A.C0009j;
import p005B.AbstractC0026a;
import p069X0.AbstractC0711b;
import p074Z0.AbstractC0832r;
import p082b1.C1033d;
import p082b1.C1036g;
import p110k.AbstractC1561V0;
import p110k.AbstractC1589g0;
import p110k.C1532G0;
import p110k.C1613r;
import p118m1.AbstractC1745j;
import p165z.AbstractC2049e;

/* JADX INFO: renamed from: c1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1080a {

    /* JADX INFO: renamed from: a */
    public final Object f3764a;

    /* JADX INFO: renamed from: b */
    public final Serializable f3765b;

    /* JADX INFO: renamed from: c */
    public final Serializable f3766c;

    /* JADX INFO: renamed from: d */
    public final Object f3767d;

    /* JADX INFO: renamed from: e */
    public final Serializable f3768e;

    /* JADX INFO: renamed from: f */
    public final Object f3769f;

    /* JADX WARN: Type inference failed for: r0v3, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int[], java.io.Serializable] */
    public C1080a() {
        this.f3764a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        this.f3765b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.f3766c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        this.f3767d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.f3768e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.f3769f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2817a(int[] iArr, int i3) {
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m2818b(Context context, int i3) {
        int iM3630c = AbstractC1561V0.m3630c(context, R.attr.colorControlHighlight);
        int iM3629b = AbstractC1561V0.m3629b(context, R.attr.colorButtonNormal);
        int[] iArr = AbstractC1561V0.f5579b;
        int[] iArr2 = AbstractC1561V0.f5581d;
        int iM105b = AbstractC0026a.m105b(iM3630c, i3);
        return new ColorStateList(new int[][]{iArr, iArr2, AbstractC1561V0.f5580c, AbstractC1561V0.f5583f}, new int[]{iM3629b, iM105b, AbstractC0026a.m105b(iM3630c, i3), i3});
    }

    /* JADX INFO: renamed from: c */
    public static LayerDrawable m2819c(C1532G0 c1532g0, Context context, int i3) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i3);
        Drawable drawableM3583e = c1532g0.m3583e(context, R.drawable.abc_star_black_48dp);
        Drawable drawableM3583e2 = c1532g0.m3583e(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableM3583e instanceof BitmapDrawable) && drawableM3583e.getIntrinsicWidth() == dimensionPixelSize && drawableM3583e.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableM3583e;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableM3583e.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableM3583e.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableM3583e2 instanceof BitmapDrawable) && drawableM3583e2.getIntrinsicWidth() == dimensionPixelSize && drawableM3583e2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableM3583e2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableM3583e2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableM3583e2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    /* JADX INFO: renamed from: e */
    public static void m2820e(Drawable drawable, int i3) {
        PorterDuffColorFilter porterDuffColorFilterM3579g;
        PorterDuff.Mode mode = C1613r.f5721b;
        int[] iArr = AbstractC1589g0.f5636a;
        Drawable drawableMutate = drawable.mutate();
        synchronized (C1613r.class) {
            porterDuffColorFilterM3579g = C1532G0.m3579g(i3, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterM3579g);
    }

    /* JADX INFO: renamed from: d */
    public ColorStateList m2821d(Context context, int i3) {
        if (i3 == R.drawable.abc_edit_text_material) {
            return AbstractC2049e.m4525c(context, R.color.abc_tint_edittext);
        }
        if (i3 == R.drawable.abc_switch_track_mtrl_alpha) {
            return AbstractC2049e.m4525c(context, R.color.abc_tint_switch_track);
        }
        if (i3 != R.drawable.abc_switch_thumb_material) {
            if (i3 == R.drawable.abc_btn_default_mtrl_shape) {
                return m2818b(context, AbstractC1561V0.m3630c(context, R.attr.colorButtonNormal));
            }
            if (i3 == R.drawable.abc_btn_borderless_material) {
                return m2818b(context, 0);
            }
            if (i3 == R.drawable.abc_btn_colored_material) {
                return m2818b(context, AbstractC1561V0.m3630c(context, R.attr.colorAccent));
            }
            if (i3 == R.drawable.abc_spinner_mtrl_am_alpha || i3 == R.drawable.abc_spinner_textfield_background_material) {
                return AbstractC2049e.m4525c(context, R.color.abc_tint_spinner);
            }
            if (m2817a((int[]) this.f3765b, i3)) {
                return AbstractC1561V0.m3631d(context, R.attr.colorControlNormal);
            }
            if (m2817a((int[]) this.f3768e, i3)) {
                return AbstractC2049e.m4525c(context, R.color.abc_tint_default);
            }
            if (m2817a((int[]) this.f3769f, i3)) {
                return AbstractC2049e.m4525c(context, R.color.abc_tint_btn_checkable);
            }
            if (i3 == R.drawable.abc_seekbar_thumb_material) {
                return AbstractC2049e.m4525c(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM3631d = AbstractC1561V0.m3631d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListM3631d == null || !colorStateListM3631d.isStateful()) {
            iArr[0] = AbstractC1561V0.f5579b;
            iArr2[0] = AbstractC1561V0.m3629b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = AbstractC1561V0.f5582e;
            iArr2[1] = AbstractC1561V0.m3630c(context, R.attr.colorControlActivated);
            iArr[2] = AbstractC1561V0.f5583f;
            iArr2[2] = AbstractC1561V0.m3630c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = AbstractC1561V0.f5579b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListM3631d.getColorForState(iArr3, 0);
            iArr[1] = AbstractC1561V0.f5582e;
            iArr2[1] = AbstractC1561V0.m3630c(context, R.attr.colorControlActivated);
            iArr[2] = AbstractC1561V0.f5583f;
            iArr2[2] = colorStateListM3631d.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public C1080a(C1033d c1033d, AbstractC0711b abstractC0711b, AbstractC0832r abstractC0832r) {
        C0009j[] c0009jArr;
        this.f3764a = c1033d;
        this.f3766c = abstractC0711b;
        this.f3765b = abstractC0832r;
        RuntimeException runtimeException = C1081b.f3771e;
        if (runtimeException == null) {
            C1081b c1081b = C1081b.f3770d;
            Class cls = c1033d.f3666f;
            Object[] objArrM2822a = c1081b.m2822a(cls);
            C1036g c1036g = null;
            if (objArrM2822a == null) {
                c0009jArr = null;
            } else {
                c0009jArr = new C0009j[objArrM2822a.length];
                for (int i3 = 0; i3 < objArrM2822a.length; i3++) {
                    try {
                        try {
                            c0009jArr[i3] = new C0009j((Class) c1081b.f3774c.invoke(objArrM2822a[i3], null), 21, (String) c1081b.f3773b.invoke(objArrM2822a[i3], null));
                        } catch (Exception e3) {
                            throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i3), Integer.valueOf(objArrM2822a.length), AbstractC1745j.m3903z(cls)), e3);
                        }
                    } catch (Exception e4) {
                        throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i3), Integer.valueOf(objArrM2822a.length), AbstractC1745j.m3903z(cls)), e4);
                    }
                }
            }
            this.f3769f = c0009jArr;
            if (c0009jArr == null) {
                this.f3767d = (List) c1033d.m2776h().f3800g;
                this.f3768e = null;
                return;
            }
            int length = c0009jArr.length;
            if (length == 0) {
                c1036g = (C1036g) c1033d.m2776h().f3799f;
                this.f3767d = Collections.singletonList(c1036g);
            } else {
                List list = (List) c1033d.m2776h().f3800g;
                this.f3767d = list;
                Iterator it = list.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C1036g c1036g2 = (C1036g) it.next();
                    if (c1036g2.f3687h.getParameterCount() == length) {
                        for (int i4 = 0; i4 < length; i4++) {
                            if (!c1036g2.mo2792u(i4).equals((Class) ((C0009j[]) this.f3769f)[i4].f30f)) {
                                break;
                            }
                        }
                        c1036g = c1036g2;
                        break loop0;
                    }
                }
            }
            if (c1036g != null) {
                this.f3768e = c1036g;
                return;
            }
            throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + AbstractC1745j.m3895r(((C1033d) this.f3764a).f3665e));
        }
        throw runtimeException;
    }
}
