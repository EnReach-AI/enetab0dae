package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import io.getgrass.www.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p034K1.C0408B;
import p034K1.C0435v;
import p044O.AbstractC0566c;
import p094f.AbstractC1343a;
import p097f2.C1352e;
import p105i.InterfaceC1435c;
import p110k.AbstractC1587f1;
import p110k.AbstractC1614r0;
import p110k.C1546N0;
import p110k.C1553R0;
import p110k.C1555S0;
import p110k.C1603m;
import p110k.C1616s0;
import p110k.InterfaceC1548O0;
import p110k.InterfaceC1550P0;
import p110k.InterfaceC1552Q0;
import p110k.RunnableC1540K0;
import p110k.ViewOnClickListenerC1559U0;
import p110k.ViewOnFocusChangeListenerC1542L0;
import p110k.ViewOnLayoutChangeListenerC1544M0;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends AbstractC1614r0 implements InterfaceC1435c {

    /* JADX INFO: renamed from: k0 */
    public static final C1352e f2765k0;

    /* JADX INFO: renamed from: A */
    public final ImageView f2766A;

    /* JADX INFO: renamed from: B */
    public final View f2767B;

    /* JADX INFO: renamed from: C */
    public C1555S0 f2768C;

    /* JADX INFO: renamed from: D */
    public final Rect f2769D;

    /* JADX INFO: renamed from: E */
    public final Rect f2770E;

    /* JADX INFO: renamed from: F */
    public final int[] f2771F;

    /* JADX INFO: renamed from: G */
    public final int[] f2772G;

    /* JADX INFO: renamed from: H */
    public final ImageView f2773H;

    /* JADX INFO: renamed from: I */
    public final Drawable f2774I;

    /* JADX INFO: renamed from: J */
    public final int f2775J;

    /* JADX INFO: renamed from: K */
    public final int f2776K;

    /* JADX INFO: renamed from: L */
    public final Intent f2777L;

    /* JADX INFO: renamed from: M */
    public final Intent f2778M;

    /* JADX INFO: renamed from: N */
    public final CharSequence f2779N;

    /* JADX INFO: renamed from: O */
    public View.OnFocusChangeListener f2780O;

    /* JADX INFO: renamed from: P */
    public View.OnClickListener f2781P;

    /* JADX INFO: renamed from: Q */
    public boolean f2782Q;

    /* JADX INFO: renamed from: R */
    public boolean f2783R;

    /* JADX INFO: renamed from: S */
    public AbstractC0566c f2784S;

    /* JADX INFO: renamed from: T */
    public boolean f2785T;

    /* JADX INFO: renamed from: U */
    public CharSequence f2786U;

    /* JADX INFO: renamed from: V */
    public boolean f2787V;

    /* JADX INFO: renamed from: W */
    public boolean f2788W;

    /* JADX INFO: renamed from: a0 */
    public int f2789a0;

    /* JADX INFO: renamed from: b0 */
    public boolean f2790b0;

    /* JADX INFO: renamed from: c0 */
    public CharSequence f2791c0;

    /* JADX INFO: renamed from: d0 */
    public boolean f2792d0;

    /* JADX INFO: renamed from: e0 */
    public int f2793e0;

    /* JADX INFO: renamed from: f0 */
    public SearchableInfo f2794f0;

    /* JADX INFO: renamed from: g0 */
    public Bundle f2795g0;

    /* JADX INFO: renamed from: h0 */
    public final RunnableC1540K0 f2796h0;

    /* JADX INFO: renamed from: i0 */
    public final RunnableC1540K0 f2797i0;

    /* JADX INFO: renamed from: j0 */
    public final WeakHashMap f2798j0;

    /* JADX INFO: renamed from: t */
    public final SearchAutoComplete f2799t;

    /* JADX INFO: renamed from: u */
    public final View f2800u;

    /* JADX INFO: renamed from: v */
    public final View f2801v;

    /* JADX INFO: renamed from: w */
    public final View f2802w;

    /* JADX INFO: renamed from: x */
    public final ImageView f2803x;

    /* JADX INFO: renamed from: y */
    public final ImageView f2804y;

    /* JADX INFO: renamed from: z */
    public final ImageView f2805z;

    public static class SearchAutoComplete extends C1603m {

        /* JADX INFO: renamed from: i */
        public int f2806i;

        /* JADX INFO: renamed from: j */
        public SearchView f2807j;

        /* JADX INFO: renamed from: k */
        public boolean f2808k;

        /* JADX INFO: renamed from: l */
        public final RunnableC0892d f2809l;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2809l = new RunnableC0892d(this);
            this.f2806i = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i4 = configuration.screenHeightDp;
            if (i3 >= 960 && i4 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i3 < 600) {
                return (i3 < 640 || i4 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* JADX INFO: renamed from: a */
        public final void m2264a() {
            if (Build.VERSION.SDK_INT >= 29) {
                AbstractC0891c.m2287b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            C1352e c1352e = SearchView.f2765k0;
            c1352e.getClass();
            C1352e.m3309a();
            Method method = c1352e.f4820c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.f2806i <= 0 || super.enoughToFilter();
        }

        @Override // p110k.C1603m, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2808k) {
                RunnableC0892d runnableC0892d = this.f2809l;
                removeCallbacks(runnableC0892d);
                post(runnableC0892d);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z3, int i3, Rect rect) {
            super.onFocusChanged(z3, i3, rect);
            SearchView searchView = this.f2807j;
            searchView.m2263y(searchView.f2783R);
            searchView.post(searchView.f2796h0);
            if (searchView.f2799t.hasFocus()) {
                searchView.m2252n();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2807j.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z3) {
            super.onWindowFocusChanged(z3);
            if (z3 && this.f2807j.hasFocus() && getVisibility() == 0) {
                this.f2808k = true;
                Context context = getContext();
                C1352e c1352e = SearchView.f2765k0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    m2264a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z3) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            RunnableC0892d runnableC0892d = this.f2809l;
            if (!z3) {
                this.f2808k = false;
                removeCallbacks(runnableC0892d);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f2808k = true;
                    return;
                }
                this.f2808k = false;
                removeCallbacks(runnableC0892d);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f2807j = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.f2806i = i3;
        }
    }

    static {
        C1352e c1352e = null;
        if (Build.VERSION.SDK_INT < 29) {
            C1352e c1352e2 = new C1352e();
            c1352e2.f4818a = null;
            c1352e2.f4819b = null;
            c1352e2.f4820c = null;
            C1352e.m3309a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                c1352e2.f4818a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                c1352e2.f4819b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                c1352e2.f4820c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            c1352e = c1352e2;
        }
        f2765k0 = c1352e;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f2799t;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // p105i.InterfaceC1435c
    /* JADX INFO: renamed from: c */
    public final void mo2248c() {
        if (this.f2792d0) {
            return;
        }
        this.f2792d0 = true;
        SearchAutoComplete searchAutoComplete = this.f2799t;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f2793e0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f2788W = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f2799t;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f2788W = false;
    }

    @Override // p105i.InterfaceC1435c
    /* JADX INFO: renamed from: e */
    public final void mo2249e() {
        SearchAutoComplete searchAutoComplete = this.f2799t;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f2791c0 = "";
        clearFocus();
        m2263y(true);
        searchAutoComplete.setImeOptions(this.f2793e0);
        this.f2792d0 = false;
    }

    public int getImeOptions() {
        return this.f2799t.getImeOptions();
    }

    public int getInputType() {
        return this.f2799t.getInputType();
    }

    public int getMaxWidth() {
        return this.f2789a0;
    }

    public CharSequence getQuery() {
        return this.f2799t.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f2786U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f2794f0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f2779N : getContext().getText(this.f2794f0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f2776K;
    }

    public int getSuggestionRowLayout() {
        return this.f2775J;
    }

    public AbstractC0566c getSuggestionsAdapter() {
        return this.f2784S;
    }

    /* JADX INFO: renamed from: l */
    public final Intent m2250l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2791c0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2795g0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f2794f0.getSearchActivity());
        return intent;
    }

    /* JADX INFO: renamed from: m */
    public final Intent m2251m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2795g0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* JADX INFO: renamed from: n */
    public final void m2252n() {
        int i3 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f2799t;
        if (i3 >= 29) {
            AbstractC0891c.m2286a(searchAutoComplete);
            return;
        }
        C1352e c1352e = f2765k0;
        c1352e.getClass();
        C1352e.m3309a();
        Method method = c1352e.f4818a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        c1352e.getClass();
        C1352e.m3309a();
        Method method2 = c1352e.f4819b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m2253o() {
        SearchAutoComplete searchAutoComplete = this.f2799t;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f2782Q) {
            clearFocus();
            m2263y(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2796h0);
        post(this.f2797i0);
        super.onDetachedFromWindow();
    }

    @Override // p110k.AbstractC1614r0, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (z3) {
            int[] iArr = this.f2771F;
            SearchAutoComplete searchAutoComplete = this.f2799t;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f2772G;
            getLocationInWindow(iArr2);
            int i7 = iArr[1] - iArr2[1];
            int i8 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i8;
            int height = searchAutoComplete.getHeight() + i7;
            Rect rect = this.f2769D;
            rect.set(i8, i7, width, height);
            int i9 = rect.left;
            int i10 = rect.right;
            int i11 = i6 - i4;
            Rect rect2 = this.f2770E;
            rect2.set(i9, 0, i10, i11);
            C1555S0 c1555s0 = this.f2768C;
            if (c1555s0 == null) {
                C1555S0 c1555s02 = new C1555S0(rect2, rect, searchAutoComplete);
                this.f2768C = c1555s02;
                setTouchDelegate(c1555s02);
            } else {
                c1555s0.f5538b.set(rect2);
                Rect rect3 = c1555s0.f5540d;
                rect3.set(rect2);
                int i12 = -c1555s0.f5541e;
                rect3.inset(i12, i12);
                c1555s0.f5539c.set(rect);
            }
        }
    }

    @Override // p110k.AbstractC1614r0, android.view.View
    public final void onMeasure(int i3, int i4) {
        int i5;
        if (this.f2783R) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i6 = this.f2789a0;
            size = i6 > 0 ? Math.min(i6, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f2789a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i5 = this.f2789a0) > 0) {
            size = Math.min(i5, size);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1553R0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1553R0 c1553r0 = (C1553R0) parcelable;
        super.onRestoreInstanceState(c1553r0.f1425e);
        m2263y(c1553r0.f5536g);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C1553R0 c1553r0 = new C1553R0(super.onSaveInstanceState());
        c1553r0.f5536g = this.f2783R;
        return c1553r0;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        post(this.f2796h0);
    }

    /* JADX INFO: renamed from: p */
    public final void m2254p(int i3) {
        int position;
        String strM3613h;
        Cursor cursor = this.f2784S.f1374g;
        if (cursor != null && cursor.moveToPosition(i3)) {
            Intent intentM2250l = null;
            try {
                int i4 = ViewOnClickListenerC1559U0.f5548B;
                String strM3613h2 = ViewOnClickListenerC1559U0.m3613h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strM3613h2 == null) {
                    strM3613h2 = this.f2794f0.getSuggestIntentAction();
                }
                if (strM3613h2 == null) {
                    strM3613h2 = "android.intent.action.SEARCH";
                }
                String strM3613h3 = ViewOnClickListenerC1559U0.m3613h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strM3613h3 == null) {
                    strM3613h3 = this.f2794f0.getSuggestIntentData();
                }
                if (strM3613h3 != null && (strM3613h = ViewOnClickListenerC1559U0.m3613h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strM3613h3 = strM3613h3 + "/" + Uri.encode(strM3613h);
                }
                intentM2250l = m2250l(strM3613h2, strM3613h3 == null ? null : Uri.parse(strM3613h3), ViewOnClickListenerC1559U0.m3613h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), ViewOnClickListenerC1559U0.m3613h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e3) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e3);
            }
            if (intentM2250l != null) {
                try {
                    getContext().startActivity(intentM2250l);
                } catch (RuntimeException e4) {
                    Log.e("SearchView", "Failed launch activity: " + intentM2250l, e4);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f2799t;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    /* JADX INFO: renamed from: q */
    public final void m2255q(int i3) {
        Editable text = this.f2799t.getText();
        Cursor cursor = this.f2784S.f1374g;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        String strMo1243c = this.f2784S.mo1243c(cursor);
        if (strMo1243c != null) {
            setQuery(strMo1243c);
        } else {
            setQuery(text);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m2256r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i3, Rect rect) {
        if (this.f2788W || !isFocusable()) {
            return false;
        }
        if (this.f2783R) {
            return super.requestFocus(i3, rect);
        }
        boolean zRequestFocus = this.f2799t.requestFocus(i3, rect);
        if (zRequestFocus) {
            m2263y(false);
        }
        return zRequestFocus;
    }

    /* JADX INFO: renamed from: s */
    public final void m2257s() {
        SearchAutoComplete searchAutoComplete = this.f2799t;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f2794f0 != null) {
            getContext().startActivity(m2250l("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2795g0 = bundle;
    }

    public void setIconified(boolean z3) {
        if (z3) {
            m2253o();
            return;
        }
        m2263y(false);
        SearchAutoComplete searchAutoComplete = this.f2799t;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f2781P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z3) {
        if (this.f2782Q == z3) {
            return;
        }
        this.f2782Q = z3;
        m2263y(z3);
        m2260v();
    }

    public void setImeOptions(int i3) {
        this.f2799t.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f2799t.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.f2789a0 = i3;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC1548O0 interfaceC1548O0) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2780O = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC1550P0 interfaceC1550P0) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2781P = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC1552Q0 interfaceC1552Q0) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2786U = charSequence;
        m2260v();
    }

    public void setQueryRefinementEnabled(boolean z3) {
        this.f2787V = z3;
        AbstractC0566c abstractC0566c = this.f2784S;
        if (abstractC0566c instanceof ViewOnClickListenerC1559U0) {
            ((ViewOnClickListenerC1559U0) abstractC0566c).f5558t = z3 ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f2794f0 = searchableInfo;
        Intent intent = null;
        SearchAutoComplete searchAutoComplete = this.f2799t;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f2794f0.getImeOptions());
            int inputType = this.f2794f0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f2794f0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            AbstractC0566c abstractC0566c = this.f2784S;
            if (abstractC0566c != null) {
                abstractC0566c.mo1242b(null);
            }
            if (this.f2794f0.getSuggestAuthority() != null) {
                ViewOnClickListenerC1559U0 viewOnClickListenerC1559U0 = new ViewOnClickListenerC1559U0(getContext(), this, this.f2794f0, this.f2798j0);
                this.f2784S = viewOnClickListenerC1559U0;
                searchAutoComplete.setAdapter(viewOnClickListenerC1559U0);
                ((ViewOnClickListenerC1559U0) this.f2784S).f5558t = this.f2787V ? 2 : 1;
            }
            m2260v();
        }
        SearchableInfo searchableInfo2 = this.f2794f0;
        boolean z3 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f2794f0.getVoiceSearchLaunchWebSearch()) {
                intent = this.f2777L;
            } else if (this.f2794f0.getVoiceSearchLaunchRecognizer()) {
                intent = this.f2778M;
            }
            if (intent != null) {
                z3 = getContext().getPackageManager().resolveActivity(intent, 65536) != null;
            }
        }
        this.f2790b0 = z3;
        if (z3) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        m2263y(this.f2783R);
    }

    public void setSubmitButtonEnabled(boolean z3) {
        this.f2785T = z3;
        m2263y(this.f2783R);
    }

    public void setSuggestionsAdapter(AbstractC0566c abstractC0566c) {
        this.f2784S = abstractC0566c;
        this.f2799t.setAdapter(abstractC0566c);
    }

    /* JADX INFO: renamed from: t */
    public final void m2258t() {
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(this.f2799t.getText());
        if (!z4 && (!this.f2782Q || this.f2792d0)) {
            z3 = false;
        }
        int i3 = z3 ? 0 : 8;
        ImageView imageView = this.f2805z;
        imageView.setVisibility(i3);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(z4 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m2259u() {
        int[] iArr = this.f2799t.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2801v.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2802w.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: v */
    public final void m2260v() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z3 = this.f2782Q;
        SearchAutoComplete searchAutoComplete = this.f2799t;
        CharSequence charSequence2 = charSequence;
        if (z3) {
            Drawable drawable = this.f2774I;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    /* JADX INFO: renamed from: w */
    public final void m2261w() {
        this.f2802w.setVisibility(((this.f2785T || this.f2790b0) && !this.f2783R && (this.f2804y.getVisibility() == 0 || this.f2766A.getVisibility() == 0)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: x */
    public final void m2262x(boolean z3) {
        boolean z4 = this.f2785T;
        this.f2804y.setVisibility((!z4 || !(z4 || this.f2790b0) || this.f2783R || !hasFocus() || (!z3 && this.f2790b0)) ? 8 : 0);
    }

    /* JADX INFO: renamed from: y */
    public final void m2263y(boolean z3) {
        this.f2783R = z3;
        int i3 = 8;
        int i4 = z3 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f2799t.getText());
        this.f2803x.setVisibility(i4);
        m2262x(!zIsEmpty);
        this.f2800u.setVisibility(z3 ? 8 : 0);
        ImageView imageView = this.f2773H;
        imageView.setVisibility((imageView.getDrawable() == null || this.f2782Q) ? 8 : 0);
        m2258t();
        if (this.f2790b0 && !this.f2783R && zIsEmpty) {
            this.f2804y.setVisibility(8);
            i3 = 0;
        }
        this.f2766A.setVisibility(i3);
        m2261w();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2769D = new Rect();
        this.f2770E = new Rect();
        this.f2771F = new int[2];
        this.f2772G = new int[2];
        this.f2796h0 = new RunnableC1540K0(this, 0);
        this.f2797i0 = new RunnableC1540K0(this, 1);
        this.f2798j0 = new WeakHashMap();
        ViewOnClickListenerC0889a viewOnClickListenerC0889a = new ViewOnClickListenerC0889a(this);
        ViewOnKeyListenerC0890b viewOnKeyListenerC0890b = new ViewOnKeyListenerC0890b(this);
        C1546N0 c1546n0 = new C1546N0(this);
        C0435v c0435v = new C0435v(2, this);
        C1616s0 c1616s0 = new C1616s0(1, this);
        C0408B c0408b = new C0408B(this, 1);
        int[] iArr = AbstractC1343a.f4797u;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, 0);
        C2071i c2071i = new C2071i(context, typedArrayObtainStyledAttributes);
        AbstractC0323S.m700j(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i3);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(17, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f2799t = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f2800u = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f2801v = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f2802w = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f2803x = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f2804y = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f2805z = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f2766A = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f2773H = imageView5;
        AbstractC0307B.m601q(viewFindViewById, c2071i.m4601l(18));
        AbstractC0307B.m601q(viewFindViewById2, c2071i.m4601l(23));
        imageView.setImageDrawable(c2071i.m4601l(21));
        imageView2.setImageDrawable(c2071i.m4601l(13));
        imageView3.setImageDrawable(c2071i.m4601l(10));
        imageView4.setImageDrawable(c2071i.m4601l(26));
        imageView5.setImageDrawable(c2071i.m4601l(21));
        this.f2774I = c2071i.m4601l(20);
        AbstractC1587f1.m3650a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f2775J = typedArrayObtainStyledAttributes.getResourceId(24, R.layout.abc_search_dropdown_item_icons_2line);
        this.f2776K = typedArrayObtainStyledAttributes.getResourceId(11, 0);
        imageView.setOnClickListener(viewOnClickListenerC0889a);
        imageView3.setOnClickListener(viewOnClickListenerC0889a);
        imageView2.setOnClickListener(viewOnClickListenerC0889a);
        imageView4.setOnClickListener(viewOnClickListenerC0889a);
        searchAutoComplete.setOnClickListener(viewOnClickListenerC0889a);
        searchAutoComplete.addTextChangedListener(c0408b);
        searchAutoComplete.setOnEditorActionListener(c1546n0);
        searchAutoComplete.setOnItemClickListener(c0435v);
        searchAutoComplete.setOnItemSelectedListener(c1616s0);
        searchAutoComplete.setOnKeyListener(viewOnKeyListenerC0890b);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC1542L0(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(16, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f2779N = typedArrayObtainStyledAttributes.getText(12);
        this.f2786U = typedArrayObtainStyledAttributes.getText(19);
        int i4 = typedArrayObtainStyledAttributes.getInt(6, -1);
        if (i4 != -1) {
            setImeOptions(i4);
        }
        int i5 = typedArrayObtainStyledAttributes.getInt(5, -1);
        if (i5 != -1) {
            setInputType(i5);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(1, true));
        c2071i.m4608x();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f2777L = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2778M = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2767B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1544M0(0, this));
        }
        m2263y(this.f2782Q);
        m2260v();
    }
}
