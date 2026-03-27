package p155w;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import p005B.AbstractC0032g;
import p151v.AbstractC1971a;

/* JADX INFO: renamed from: w.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1982d extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: a */
    public AbstractC1979a f7026a;

    /* JADX INFO: renamed from: b */
    public boolean f7027b;

    /* JADX INFO: renamed from: c */
    public final int f7028c;

    /* JADX INFO: renamed from: d */
    public final int f7029d;

    /* JADX INFO: renamed from: e */
    public final int f7030e;

    /* JADX INFO: renamed from: f */
    public final int f7031f;

    /* JADX INFO: renamed from: g */
    public final int f7032g;

    /* JADX INFO: renamed from: h */
    public int f7033h;

    /* JADX INFO: renamed from: i */
    public int f7034i;

    /* JADX INFO: renamed from: j */
    public int f7035j;

    /* JADX INFO: renamed from: k */
    public View f7036k;

    /* JADX INFO: renamed from: l */
    public View f7037l;

    /* JADX INFO: renamed from: m */
    public boolean f7038m;

    /* JADX INFO: renamed from: n */
    public boolean f7039n;

    /* JADX INFO: renamed from: o */
    public boolean f7040o;

    /* JADX INFO: renamed from: p */
    public final Rect f7041p;

    public C1982d() {
        super(-2, -2);
        this.f7027b = false;
        this.f7028c = 0;
        this.f7029d = 0;
        this.f7030e = -1;
        this.f7031f = -1;
        this.f7032g = 0;
        this.f7033h = 0;
        this.f7041p = new Rect();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m4371a(int i3) {
        if (i3 == 0) {
            return this.f7039n;
        }
        if (i3 != 1) {
            return false;
        }
        return this.f7040o;
    }

    public C1982d(Context context, AttributeSet attributeSet) {
        AbstractC1979a abstractC1979a;
        super(context, attributeSet);
        this.f7027b = false;
        this.f7028c = 0;
        this.f7029d = 0;
        this.f7030e = -1;
        this.f7031f = -1;
        this.f7032g = 0;
        this.f7033h = 0;
        this.f7041p = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1971a.f6988b);
        this.f7028c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f7031f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f7029d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        this.f7030e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        this.f7032g = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.f7033h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        this.f7027b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f2889x;
            if (TextUtils.isEmpty(string)) {
                abstractC1979a = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f2889x;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f2891z;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f2890y);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    abstractC1979a = (AbstractC1979a) constructor.newInstance(context, attributeSet);
                } catch (Exception e3) {
                    throw new RuntimeException(AbstractC0032g.m152j("Could not inflate Behavior subclass ", string), e3);
                }
            }
            this.f7026a = abstractC1979a;
        }
        typedArrayObtainStyledAttributes.recycle();
        AbstractC1979a abstractC1979a2 = this.f7026a;
        if (abstractC1979a2 != null) {
            abstractC1979a2.mo3148c(this);
        }
    }

    public C1982d(C1982d c1982d) {
        super((ViewGroup.MarginLayoutParams) c1982d);
        this.f7027b = false;
        this.f7028c = 0;
        this.f7029d = 0;
        this.f7030e = -1;
        this.f7031f = -1;
        this.f7032g = 0;
        this.f7033h = 0;
        this.f7041p = new Rect();
    }

    public C1982d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f7027b = false;
        this.f7028c = 0;
        this.f7029d = 0;
        this.f7030e = -1;
        this.f7031f = -1;
        this.f7032g = 0;
        this.f7033h = 0;
        this.f7041p = new Rect();
    }

    public C1982d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f7027b = false;
        this.f7028c = 0;
        this.f7029d = 0;
        this.f7030e = -1;
        this.f7031f = -1;
        this.f7032g = 0;
        this.f7033h = 0;
        this.f7041p = new Rect();
    }
}
