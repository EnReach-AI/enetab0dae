package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l;
import com.google.android.material.internal.CheckableImageButton;
import io.getgrass.www.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p024H0.ViewOnClickListenerC0250d;
import p025H1.C0278g;
import p029J.AbstractC0310E;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.AbstractC0334b0;
import p029J.AbstractC0336c0;
import p029J.C0366r0;
import p029J.C0368s0;
import p053R0.C0607c;
import p125o0.AbstractC1800j;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;
import p164y1.ViewOnTouchListenerC2044a;
import p165z.AbstractC2048d;

/* JADX INFO: renamed from: com.google.android.material.datepicker.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1259k<S> extends DialogInterfaceOnCancelListenerC0941l {

    /* JADX INFO: renamed from: A0 */
    public TextView f4376A0;

    /* JADX INFO: renamed from: B0 */
    public CheckableImageButton f4377B0;

    /* JADX INFO: renamed from: C0 */
    public C0278g f4378C0;

    /* JADX INFO: renamed from: D0 */
    public Button f4379D0;

    /* JADX INFO: renamed from: E0 */
    public boolean f4380E0;

    /* JADX INFO: renamed from: F0 */
    public CharSequence f4381F0;

    /* JADX INFO: renamed from: G0 */
    public CharSequence f4382G0;

    /* JADX INFO: renamed from: m0 */
    public final LinkedHashSet f4383m0;

    /* JADX INFO: renamed from: n0 */
    public final LinkedHashSet f4384n0;

    /* JADX INFO: renamed from: o0 */
    public int f4385o0;

    /* JADX INFO: renamed from: p0 */
    public AbstractC1266r f4386p0;

    /* JADX INFO: renamed from: q0 */
    public C1250b f4387q0;

    /* JADX INFO: renamed from: r0 */
    public C1258j f4388r0;

    /* JADX INFO: renamed from: s0 */
    public int f4389s0;

    /* JADX INFO: renamed from: t0 */
    public CharSequence f4390t0;

    /* JADX INFO: renamed from: u0 */
    public boolean f4391u0;

    /* JADX INFO: renamed from: v0 */
    public int f4392v0;

    /* JADX INFO: renamed from: w0 */
    public int f4393w0;

    /* JADX INFO: renamed from: x0 */
    public CharSequence f4394x0;

    /* JADX INFO: renamed from: y0 */
    public int f4395y0;

    /* JADX INFO: renamed from: z0 */
    public CharSequence f4396z0;

    public C1259k() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f4383m0 = new LinkedHashSet();
        this.f4384n0 = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: T */
    public static int m3179T(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar calendarM3190b = AbstractC1269u.m3190b();
        calendarM3190b.set(5, 1);
        Calendar calendarM3189a = AbstractC1269u.m3189a(calendarM3190b);
        calendarM3189a.get(2);
        calendarM3189a.get(1);
        int maximum = calendarM3189a.getMaximum(7);
        calendarM3189a.getActualMaximum(5);
        calendarM3189a.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    /* JADX INFO: renamed from: U */
    public static boolean m3180U(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1919e.m4298s(context, R.attr.materialCalendarStyle, C1258j.class.getCanonicalName()).data, new int[]{i3});
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z3;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: A */
    public final void mo2466A() {
        this.f4386p0.f4418W.clear();
        super.mo2466A();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l
    /* JADX INFO: renamed from: Q */
    public final Dialog mo492Q() {
        Context contextM2481I = m2481I();
        m2481I();
        int i3 = this.f4385o0;
        if (i3 == 0) {
            m3181S();
            throw null;
        }
        Dialog dialog = new Dialog(contextM2481I, i3);
        Context context = dialog.getContext();
        this.f4391u0 = m3180U(context, android.R.attr.windowFullscreen);
        int i4 = AbstractC1919e.m4298s(context, R.attr.colorSurface, C1259k.class.getCanonicalName()).data;
        C0278g c0278g = new C0278g(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f4378C0 = c0278g;
        c0278g.m545i(context);
        this.f4378C0.m547k(ColorStateList.valueOf(i4));
        C0278g c0278g2 = this.f4378C0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        c0278g2.m546j(AbstractC0313H.m636i(decorView));
        return dialog;
    }

    /* JADX INFO: renamed from: S */
    public final void m3181S() {
        AbstractC0032g.m158p(this.f3227j.getParcelable("DATE_SELECTOR_KEY"));
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f4383m0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f4384n0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.f3210J;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        super.mo518q(bundle);
        if (bundle == null) {
            bundle = this.f3227j;
        }
        this.f4385o0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        AbstractC0032g.m158p(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f4387q0 = (C1250b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        AbstractC0032g.m158p(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f4389s0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f4390t0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f4392v0 = bundle.getInt("INPUT_MODE_KEY");
        this.f4393w0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f4394x0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f4395y0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f4396z0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence text = this.f4390t0;
        if (text == null) {
            text = m2481I().getResources().getText(this.f4389s0);
        }
        this.f4381F0 = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.f4382G0 = text;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f4391u0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f4391u0) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(m3179T(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(m3179T(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0310E.m623f(textView, 1);
        this.f4377B0 = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.f4376A0 = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.f4377B0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.f4377B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, AbstractC1800j.m3991i(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], AbstractC1800j.m3991i(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.f4377B0.setChecked(this.f4392v0 != 0);
        AbstractC0323S.m701k(this.f4377B0, null);
        CheckableImageButton checkableImageButton2 = this.f4377B0;
        this.f4377B0.setContentDescription(checkableImageButton2.f4424h ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.f4377B0.setOnClickListener(new ViewOnClickListenerC0250d(3, this));
        this.f4379D0 = (Button) viewInflate.findViewById(R.id.confirm_button);
        m3181S();
        throw null;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        super.mo502y(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f4385o0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        C1250b c1250b = this.f4387q0;
        C1249a c1249a = new C1249a();
        int i3 = C1249a.f4341b;
        int i4 = C1249a.f4341b;
        long j2 = c1250b.f4343e.f4404j;
        long j3 = c1250b.f4344f.f4404j;
        c1249a.f4342a = Long.valueOf(c1250b.f4346h.f4404j);
        C1261m c1261m = this.f4388r0.f4367Z;
        if (c1261m != null) {
            c1249a.f4342a = Long.valueOf(c1261m.f4404j);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", c1250b.f4345g);
        C1261m c1261mM3183b = C1261m.m3183b(j2);
        C1261m c1261mM3183b2 = C1261m.m3183b(j3);
        C1252d c1252d = (C1252d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l3 = c1249a.f4342a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new C1250b(c1261mM3183b, c1261mM3183b2, c1252d, l3 == null ? null : C1261m.m3183b(l3.longValue()), c1250b.f4347i));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f4389s0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f4390t0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f4393w0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f4394x0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f4395y0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f4396z0);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: z */
    public final void mo2475z() {
        int iM4520a;
        super.mo2475z();
        Dialog dialog = this.f3183h0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.f4391u0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f4378C0);
            if (!this.f4380E0) {
                View viewFindViewById = m2482J().findViewById(R.id.fullscreen_header);
                Integer numValueOf = viewFindViewById.getBackground() instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) viewFindViewById.getBackground()).getColor()) : null;
                int i3 = Build.VERSION.SDK_INT;
                boolean z3 = numValueOf == null || numValueOf.intValue() == 0;
                Context context = window.getContext();
                TypedValue typedValueM4296q = AbstractC1919e.m4296q(context, android.R.attr.colorBackground);
                if (typedValueM4296q != null) {
                    int i4 = typedValueM4296q.resourceId;
                    iM4520a = i4 != 0 ? AbstractC2048d.m4520a(context, i4) : typedValueM4296q.data;
                } else {
                    iM4520a = -16777216;
                }
                if (z3) {
                    numValueOf = Integer.valueOf(iM4520a);
                }
                if (i3 >= 30) {
                    AbstractC0336c0.m730a(window, false);
                } else {
                    AbstractC0334b0.m722a(window, false);
                }
                window.getContext();
                window.getContext();
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                boolean z4 = AbstractC1920f.m4307j(0) || AbstractC1920f.m4307j(numValueOf.intValue());
                window.getDecorView();
                (Build.VERSION.SDK_INT >= 30 ? new C0368s0(window) : new C0366r0(window)).mo837n(z4);
                boolean z5 = AbstractC1920f.m4307j(0) || AbstractC1920f.m4307j(iM4520a);
                window.getDecorView();
                (Build.VERSION.SDK_INT >= 30 ? new C0368s0(window) : new C0366r0(window)).mo836m(z5);
                C0607c c0607c = new C0607c(viewFindViewById, viewFindViewById.getLayoutParams().height, viewFindViewById.getPaddingTop());
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0313H.m648u(viewFindViewById, c0607c);
                this.f4380E0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = m2495m().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f4378C0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView = window.getDecorView();
            Dialog dialog2 = this.f3183h0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView.setOnTouchListener(new ViewOnTouchListenerC2044a(dialog2, rect));
        }
        m2481I();
        int i5 = this.f4385o0;
        if (i5 == 0) {
            m3181S();
            throw null;
        }
        m3181S();
        C1250b c1250b = this.f4387q0;
        C1258j c1258j = new C1258j();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i5);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c1250b);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", c1250b.f4346h);
        c1258j.m2485M(bundle);
        this.f4388r0 = c1258j;
        boolean z6 = this.f4377B0.f4424h;
        AbstractC1266r abstractC1266r = c1258j;
        if (z6) {
            m3181S();
            C1250b c1250b2 = this.f4387q0;
            C1260l c1260l = new C1260l();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i5);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", c1250b2);
            c1260l.m2485M(bundle2);
            abstractC1266r = c1260l;
        }
        this.f4386p0 = abstractC1266r;
        this.f4376A0.setText((z6 && m2495m().getConfiguration().orientation == 2) ? this.f4382G0 : this.f4381F0);
        m3181S();
        m2492j();
        throw null;
    }
}
