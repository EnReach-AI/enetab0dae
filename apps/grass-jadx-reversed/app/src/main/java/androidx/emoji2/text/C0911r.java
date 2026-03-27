package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: androidx.emoji2.text.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0911r implements TextWatcher, SpanWatcher {

    /* JADX INFO: renamed from: e */
    public final Object f3008e;

    /* JADX INFO: renamed from: f */
    public final AtomicInteger f3009f = new AtomicInteger(0);

    public C0911r(Object obj) {
        this.f3008e = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f3008e).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        ((TextWatcher) this.f3008e).beforeTextChanged(charSequence, i3, i4, i5);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i3, int i4) {
        if (this.f3009f.get() <= 0 || !(obj instanceof C0913t)) {
            ((SpanWatcher) this.f3008e).onSpanAdded(spannable, obj, i3, i4);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i3, int i4, int i5, int i6) {
        if (this.f3009f.get() <= 0 || !(obj instanceof C0913t)) {
            ((SpanWatcher) this.f3008e).onSpanChanged(spannable, obj, i3, i4, i5, i6);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i3, int i4) {
        if (this.f3009f.get() <= 0 || !(obj instanceof C0913t)) {
            ((SpanWatcher) this.f3008e).onSpanRemoved(spannable, obj, i3, i4);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        ((TextWatcher) this.f3008e).onTextChanged(charSequence, i3, i4, i5);
    }
}
