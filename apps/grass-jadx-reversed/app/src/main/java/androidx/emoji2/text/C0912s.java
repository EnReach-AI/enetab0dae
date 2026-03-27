package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import p039M0.AbstractC0493h0;

/* JADX INFO: renamed from: androidx.emoji2.text.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0912s extends SpannableStringBuilder {

    /* JADX INFO: renamed from: e */
    public final Class f3010e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f3011f;

    public C0912s(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f3011f = new ArrayList();
        AbstractC0493h0.m1010c("watcherClass cannot be null", cls);
        this.f3010e = cls;
    }

    /* JADX INFO: renamed from: a */
    public final void m2358a() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f3011f;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((C0911r) arrayList.get(i3)).f3009f.incrementAndGet();
            i3++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final void m2359b() {
        m2362e();
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f3011f;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((C0911r) arrayList.get(i3)).onTextChanged(this, 0, length(), length());
            i3++;
        }
    }

    /* JADX INFO: renamed from: c */
    public final C0911r m2360c(Object obj) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f3011f;
            if (i3 >= arrayList.size()) {
                return null;
            }
            C0911r c0911r = (C0911r) arrayList.get(i3);
            if (c0911r.f3008e == obj) {
                return c0911r;
            }
            i3++;
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2361d(Object obj) {
        if (obj != null) {
            if (this.f3010e == obj.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable delete(int i3, int i4) {
        super.delete(i3, i4);
        return this;
    }

    /* JADX INFO: renamed from: e */
    public final void m2362e() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f3011f;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((C0911r) arrayList.get(i3)).f3009f.decrementAndGet();
            i3++;
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        C0911r c0911rM2360c;
        if (m2361d(obj) && (c0911rM2360c = m2360c(obj)) != null) {
            obj = c0911rM2360c;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        C0911r c0911rM2360c;
        if (m2361d(obj) && (c0911rM2360c = m2360c(obj)) != null) {
            obj = c0911rM2360c;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        C0911r c0911rM2360c;
        if (m2361d(obj) && (c0911rM2360c = m2360c(obj)) != null) {
            obj = c0911rM2360c;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final Object[] getSpans(int i3, int i4, Class cls) {
        if (this.f3010e != cls) {
            return super.getSpans(i3, i4, cls);
        }
        C0911r[] c0911rArr = (C0911r[]) super.getSpans(i3, i4, C0911r.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, c0911rArr.length);
        for (int i5 = 0; i5 < c0911rArr.length; i5++) {
            objArr[i5] = c0911rArr[i5].f3008e;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i3, int i4, Class cls) {
        if (cls == null || this.f3010e == cls) {
            cls = C0911r.class;
        }
        return super.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        C0911r c0911rM2360c;
        if (m2361d(obj)) {
            c0911rM2360c = m2360c(obj);
            if (c0911rM2360c != null) {
                obj = c0911rM2360c;
            }
        } else {
            c0911rM2360c = null;
        }
        super.removeSpan(obj);
        if (c0911rM2360c != null) {
            this.f3011f.remove(c0911rM2360c);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i3, int i4, CharSequence charSequence) {
        replace(i3, i4, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i3, int i4, int i5) {
        if (m2361d(obj)) {
            C0911r c0911r = new C0911r(obj);
            this.f3011f.add(c0911r);
            obj = c0911r;
        }
        super.setSpan(obj, i3, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i4) {
        return new C0912s(this.f3010e, this, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i3, int i4) {
        super.delete(i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        replace(i3, i4, charSequence, i5, i6);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final Editable insert(int i3, CharSequence charSequence, int i4, int i5) {
        super.insert(i3, charSequence, i4, i5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence) {
        m2358a();
        super.replace(i3, i4, charSequence);
        m2362e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i3, CharSequence charSequence, int i4, int i5) {
        super.insert(i3, charSequence, i4, i5);
        return this;
    }

    public C0912s(Class cls, CharSequence charSequence, int i3, int i4) {
        super(charSequence, i3, i4);
        this.f3011f = new ArrayList();
        AbstractC0493h0.m1010c("watcherClass cannot be null", cls);
        this.f3010e = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        m2358a();
        super.replace(i3, i4, charSequence, i5, i6);
        m2362e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i3) {
        super.append(charSequence, obj, i3);
        return this;
    }
}
