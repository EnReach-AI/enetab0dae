package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.HashMap;
import p005B.AbstractC0032g;
import p057T.AbstractC0635a;

/* JADX INFO: renamed from: androidx.fragment.app.u */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterFactory2C0950u implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: e */
    public final C0918D f3263e;

    public LayoutInflaterFactory2C0950u(C0918D c0918d) {
        this.f3263e = c0918d;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        C0923I c0923iM2390f;
        View view2;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        C0918D c0918d = this.f3263e;
        if (zEquals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f3074h = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0635a.f1629b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
            }
            String string = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM2407w = c0918d.m2407w(id);
            if (classAttribute != null && abstractComponentCallbacksC0944oM2407w == null) {
                if (id <= 0) {
                    throw new IllegalStateException(AbstractC0032g.m154l("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                C0953x c0953xM2410z = c0918d.m2410z();
                context.getClassLoader();
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM2500a = c0953xM2410z.m2500a(classAttribute);
                abstractComponentCallbacksC0944oM2500a.f3208H = true;
                C0946q c0946q = abstractComponentCallbacksC0944oM2500a.f3240w;
                if ((c0946q == null ? null : c0946q.f3246e) != null) {
                    abstractComponentCallbacksC0944oM2500a.f3208H = true;
                }
                C0930a c0930a = new C0930a(c0918d);
                c0930a.f3131o = true;
                abstractComponentCallbacksC0944oM2500a.f3209I = fragmentContainerView;
                c0930a.m2442e(fragmentContainerView.getId(), abstractComponentCallbacksC0944oM2500a, string, 1);
                if (c0930a.f3123g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                C0918D c0918d2 = c0930a.f3132p;
                if (c0918d2.f3042n != null && !c0918d2.f3022A) {
                    c0918d2.m2403s(true);
                    c0930a.mo2363a(c0918d2.f3024C, c0918d2.f3025D);
                    c0918d2.f3030b = true;
                    try {
                        c0918d2.m2375K(c0918d2.f3024C, c0918d2.f3025D);
                        c0918d2.m2388d();
                        c0918d2.m2384U();
                        if (c0918d2.f3023B) {
                            c0918d2.f3023B = false;
                            c0918d2.m2383T();
                        }
                        ((HashMap) c0918d2.f3031c.f7315b).values().removeAll(Collections.singleton(null));
                    } catch (Throwable th) {
                        c0918d2.m2388d();
                        throw th;
                    }
                }
            }
            for (C0923I c0923i : c0918d.f3031c.m4598h()) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
                if (abstractComponentCallbacksC0944o.f3201A == fragmentContainerView.getId() && (view2 = abstractComponentCallbacksC0944o.f3210J) != null && view2.getParent() == null) {
                    abstractComponentCallbacksC0944o.f3209I = fragmentContainerView;
                    c0923i.m2416b();
                }
            }
            return fragmentContainerView;
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0635a.f1628a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes2.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes2.getString(2);
        typedArrayObtainStyledAttributes2.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = AbstractComponentCallbacksC0944o.class.isAssignableFrom(C0953x.m2498b(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id2 = view != null ? view.getId() : 0;
                if (id2 == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM2407w2 = resourceId != -1 ? c0918d.m2407w(resourceId) : null;
                if (abstractComponentCallbacksC0944oM2407w2 == null && string2 != null) {
                    abstractComponentCallbacksC0944oM2407w2 = c0918d.m2408x(string2);
                }
                if (abstractComponentCallbacksC0944oM2407w2 == null && id2 != -1) {
                    abstractComponentCallbacksC0944oM2407w2 = c0918d.m2407w(id2);
                }
                if (abstractComponentCallbacksC0944oM2407w2 == null) {
                    C0953x c0953xM2410z2 = c0918d.m2410z();
                    context.getClassLoader();
                    abstractComponentCallbacksC0944oM2407w2 = c0953xM2410z2.m2500a(attributeValue);
                    abstractComponentCallbacksC0944oM2407w2.f3234q = true;
                    abstractComponentCallbacksC0944oM2407w2.f3243z = resourceId != 0 ? resourceId : id2;
                    abstractComponentCallbacksC0944oM2407w2.f3201A = id2;
                    abstractComponentCallbacksC0944oM2407w2.f3202B = string2;
                    abstractComponentCallbacksC0944oM2407w2.f3235r = true;
                    abstractComponentCallbacksC0944oM2407w2.f3239v = c0918d;
                    C0946q c0946q2 = c0918d.f3042n;
                    abstractComponentCallbacksC0944oM2407w2.f3240w = c0946q2;
                    Context context2 = c0946q2.f3247f;
                    abstractComponentCallbacksC0944oM2407w2.f3208H = true;
                    if ((c0946q2 != null ? c0946q2.f3246e : null) != null) {
                        abstractComponentCallbacksC0944oM2407w2.f3208H = true;
                    }
                    c0923iM2390f = c0918d.m2385a(abstractComponentCallbacksC0944oM2407w2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Fragment " + abstractComponentCallbacksC0944oM2407w2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    if (abstractComponentCallbacksC0944oM2407w2.f3235r) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                    }
                    abstractComponentCallbacksC0944oM2407w2.f3235r = true;
                    abstractComponentCallbacksC0944oM2407w2.f3239v = c0918d;
                    C0946q c0946q3 = c0918d.f3042n;
                    abstractComponentCallbacksC0944oM2407w2.f3240w = c0946q3;
                    Context context3 = c0946q3.f3247f;
                    abstractComponentCallbacksC0944oM2407w2.f3208H = true;
                    if ((c0946q3 != null ? c0946q3.f3246e : null) != null) {
                        abstractComponentCallbacksC0944oM2407w2.f3208H = true;
                    }
                    c0923iM2390f = c0918d.m2390f(abstractComponentCallbacksC0944oM2407w2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Retained Fragment " + abstractComponentCallbacksC0944oM2407w2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                }
                abstractComponentCallbacksC0944oM2407w2.f3209I = (ViewGroup) view;
                c0923iM2390f.m2425k();
                c0923iM2390f.m2424j();
                View view3 = abstractComponentCallbacksC0944oM2407w2.f3210J;
                if (view3 == null) {
                    throw new IllegalStateException(AbstractC0032g.m154l("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view3.setId(resourceId);
                }
                if (abstractComponentCallbacksC0944oM2407w2.f3210J.getTag() == null) {
                    abstractComponentCallbacksC0944oM2407w2.f3210J.setTag(string2);
                }
                abstractComponentCallbacksC0944oM2407w2.f3210J.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0949t(this, c0923iM2390f));
                return abstractComponentCallbacksC0944oM2407w2.f3210J;
            }
        }
        return null;
    }
}
