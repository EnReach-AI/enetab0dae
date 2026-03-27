package p110k;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.emoji2.text.C0902i;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p009C.AbstractC0146i;
import p009C.InterfaceC0145h;
import p019F0.C0221e;
import p039M0.AbstractC0493h0;
import p055S.C0624b;
import p055S.C0627e;
import p055S.C0630h;
import p055S.C0631i;
import p094f.AbstractC1343a;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.y */
/* JADX INFO: loaded from: classes.dex */
public class C1627y implements InterfaceC1562W {

    /* JADX INFO: renamed from: d */
    public static final int[] f5760d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5761a;

    /* JADX INFO: renamed from: b */
    public final View f5762b;

    /* JADX INFO: renamed from: c */
    public Object f5763c;

    public C1627y(EditText editText) {
        this.f5761a = 1;
        this.f5762b = editText;
        this.f5763c = new C0221e(editText);
    }

    @Override // p110k.InterfaceC1562W
    /* JADX INFO: renamed from: a */
    public void mo3632a(int i3) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i3);
    }

    @Override // p110k.InterfaceC1562W
    /* JADX INFO: renamed from: b */
    public void mo3633b(int i3) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i3);
    }

    /* JADX INFO: renamed from: c */
    public KeyListener m3695c(KeyListener keyListener) {
        if (!(!(keyListener instanceof NumberKeyListener))) {
            return keyListener;
        }
        ((C0009j) ((C0221e) this.f5763c).f534f).getClass();
        if (keyListener instanceof C0627e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new C0627e(keyListener);
    }

    /* JADX INFO: renamed from: d */
    public void mo3569d(AttributeSet attributeSet, int i3) {
        switch (this.f5761a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ProgressBar progressBar = (ProgressBar) this.f5762b;
                C2071i c2071iM4591v = C2071i.m4591v(progressBar.getContext(), attributeSet, f5760d, i3, 0);
                Drawable drawableM4602m = c2071iM4591v.m4602m(0);
                if (drawableM4602m != null) {
                    if (drawableM4602m instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableM4602m;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i4 = 0; i4 < numberOfFrames; i4++) {
                            Drawable drawableM3698g = m3698g(animationDrawable.getFrame(i4), true);
                            drawableM3698g.setLevel(10000);
                            animationDrawable2.addFrame(drawableM3698g, animationDrawable.getDuration(i4));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableM4602m = animationDrawable2;
                    }
                    progressBar.setIndeterminateDrawable(drawableM4602m);
                }
                Drawable drawableM4602m2 = c2071iM4591v.m4602m(1);
                if (drawableM4602m2 != null) {
                    progressBar.setProgressDrawable(m3698g(drawableM4602m2, false));
                }
                c2071iM4591v.m4608x();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f5762b).getContext().obtainStyledAttributes(attributeSet, AbstractC1343a.f4785i, i3, 0);
                try {
                    boolean z3 = true;
                    if (typedArrayObtainStyledAttributes.hasValue(14)) {
                        z3 = typedArrayObtainStyledAttributes.getBoolean(14, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    m3697f(z3);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    /* JADX INFO: renamed from: e */
    public C0624b m3696e(InputConnection inputConnection, EditorInfo editorInfo) {
        C0221e c0221e = (C0221e) this.f5763c;
        if (inputConnection == null) {
            c0221e.getClass();
            inputConnection = null;
        } else {
            C0009j c0009j = (C0009j) c0221e.f534f;
            c0009j.getClass();
            if (!(inputConnection instanceof C0624b)) {
                inputConnection = new C0624b((EditText) c0009j.f30f, inputConnection, editorInfo);
            }
        }
        return (C0624b) inputConnection;
    }

    /* JADX INFO: renamed from: f */
    public void m3697f(boolean z3) {
        C0631i c0631i = (C0631i) ((C0009j) ((C0221e) this.f5763c).f534f).f31g;
        if (c0631i.f1621h != z3) {
            if (c0631i.f1620g != null) {
                C0902i c0902iM2341a = C0902i.m2341a();
                C0630h c0630h = c0631i.f1620g;
                c0902iM2341a.getClass();
                AbstractC0493h0.m1010c("initCallback cannot be null", c0630h);
                ReentrantReadWriteLock reentrantReadWriteLock = c0902iM2341a.f2972a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    c0902iM2341a.f2973b.remove(c0630h);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            c0631i.f1621h = z3;
            if (z3) {
                C0631i.m1446a(c0631i.f1618e, C0902i.m2341a().m2342b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: g */
    public Drawable m3698g(Drawable drawable, boolean z3) {
        if (drawable instanceof InterfaceC0145h) {
            ((AbstractC0146i) ((InterfaceC0145h) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    int id = layerDrawable.getId(i3);
                    drawableArr[i3] = m3698g(layerDrawable.getDrawable(i3), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i4 = 0; i4 < numberOfLayers; i4++) {
                    layerDrawable2.setId(i4, layerDrawable.getId(i4));
                    layerDrawable2.setLayerGravity(i4, layerDrawable.getLayerGravity(i4));
                    layerDrawable2.setLayerWidth(i4, layerDrawable.getLayerWidth(i4));
                    layerDrawable2.setLayerHeight(i4, layerDrawable.getLayerHeight(i4));
                    layerDrawable2.setLayerInsetLeft(i4, layerDrawable.getLayerInsetLeft(i4));
                    layerDrawable2.setLayerInsetRight(i4, layerDrawable.getLayerInsetRight(i4));
                    layerDrawable2.setLayerInsetTop(i4, layerDrawable.getLayerInsetTop(i4));
                    layerDrawable2.setLayerInsetBottom(i4, layerDrawable.getLayerInsetBottom(i4));
                    layerDrawable2.setLayerInsetStart(i4, layerDrawable.getLayerInsetStart(i4));
                    layerDrawable2.setLayerInsetEnd(i4, layerDrawable.getLayerInsetEnd(i4));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f5763c) == null) {
                    this.f5763c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z3 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public C1627y(ProgressBar progressBar) {
        this.f5761a = 0;
        this.f5762b = progressBar;
    }

    public C1627y(C1564X c1564x) {
        this.f5761a = 2;
        this.f5763c = c1564x;
        this.f5761a = 2;
        this.f5762b = c1564x;
    }
}
