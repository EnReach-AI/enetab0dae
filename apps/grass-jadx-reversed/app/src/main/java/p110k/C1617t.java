package p110k;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import io.getgrass.www.R;
import p029J.AbstractC0323S;
import p029J.C0339e;
import p029J.C0343g;
import p029J.InterfaceC0337d;
import p029J.InterfaceC0370u;
import p034K1.C0423j;
import p036L0.C0444d;
import p038M.C0452b;
import p041N.C0531s;
import p144t0.AbstractC1919e;

/* JADX INFO: renamed from: k.t */
/* JADX INFO: loaded from: classes.dex */
public class C1617t extends EditText implements InterfaceC0370u {

    /* JADX INFO: renamed from: e */
    public final C1605n f5742e;

    /* JADX INFO: renamed from: f */
    public final C1560V f5743f;

    /* JADX INFO: renamed from: g */
    public final C0531s f5744g;

    /* JADX INFO: renamed from: h */
    public final C1627y f5745h;

    /* JADX INFO: renamed from: i */
    public C1615s f5746i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1617t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.editTextStyle);
        AbstractC1563W0.m3634a(context);
        AbstractC1561V0.m3628a(this, getContext());
        C1605n c1605n = new C1605n(this);
        this.f5742e = c1605n;
        c1605n.m3672f(attributeSet, R.attr.editTextStyle);
        C1560V c1560v = new C1560V(this);
        this.f5743f = c1560v;
        c1560v.m3623f(attributeSet, R.attr.editTextStyle);
        c1560v.m3620b();
        this.f5744g = new C0531s();
        C1627y c1627y = new C1627y(this);
        this.f5745h = c1627y;
        c1627y.mo3569d(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean zIsFocusable = super.isFocusable();
            boolean zIsClickable = super.isClickable();
            boolean zIsLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener keyListenerM3695c = c1627y.m3695c(keyListener);
            if (keyListenerM3695c == keyListener) {
                return;
            }
            super.setKeyListener(keyListenerM3695c);
            super.setRawInputType(inputType);
            super.setFocusable(zIsFocusable);
            super.setClickable(zIsClickable);
            super.setLongClickable(zIsLongClickable);
        }
    }

    private C1615s getSuperCaller() {
        if (this.f5746i == null) {
            this.f5746i = new C1615s(this);
        }
        return this.f5746i;
    }

    @Override // p029J.InterfaceC0370u
    /* JADX INFO: renamed from: a */
    public final C0343g mo838a(C0343g c0343g) {
        return this.f5744g.m1070a(this, c0343g);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
        C1560V c1560v = this.f5743f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return super.getCustomSelectionActionModeCallback();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f5743f.m3621d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f5743f.m3622e();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArrM695e;
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f5743f.getClass();
        C1560V.m3618h(this, inputConnectionOnCreateInputConnection, editorInfo);
        AbstractC1919e.m4294o(inputConnectionOnCreateInputConnection, editorInfo, this);
        if (inputConnectionOnCreateInputConnection != null && Build.VERSION.SDK_INT <= 30 && (strArrM695e = AbstractC0323S.m695e(this)) != null) {
            editorInfo.contentMimeTypes = strArrM695e;
            inputConnectionOnCreateInputConnection = new C0452b(inputConnectionOnCreateInputConnection, new C0423j(this));
        }
        return this.f5745h.m3696e(inputConnectionOnCreateInputConnection, editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean zM3565a = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && AbstractC0323S.m695e(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                zM3565a = AbstractC1521B.m3565a(dragEvent, this, activity);
            }
        }
        if (zM3565a) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i3) {
        InterfaceC0337d c0444d;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 31 || AbstractC0323S.m695e(this) == null || !(i3 == 16908322 || i3 == 16908337)) {
            return super.onTextContextMenuItem(i3);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i4 >= 31) {
                c0444d = new C0444d(primaryClip, 1);
            } else {
                C0339e c0339e = new C0339e();
                c0339e.f837f = primaryClip;
                c0339e.f838g = 1;
                c0444d = c0339e;
            }
            c0444d.mo734j(i3 == 16908322 ? 0 : 1);
            AbstractC0323S.m697g(this, c0444d.mo731d());
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5743f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C1560V c1560v = this.f5743f;
        if (c1560v != null) {
            c1560v.m3620b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f5745h.m3697f(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f5745h.m3695c(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5742e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        C1560V c1560v = this.f5743f;
        c1560v.m3625i(colorStateList);
        c1560v.m3620b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        C1560V c1560v = this.f5743f;
        c1560v.m3626j(mode);
        c1560v.m3620b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1560V c1560v = this.f5743f;
        if (c1560v != null) {
            c1560v.m3624g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        super.setTextClassifier(textClassifier);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }
}
