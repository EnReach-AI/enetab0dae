package p024H0;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1111h;
import com.facebook.CustomTabMainActivity;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import io.getgrass.www.R;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p036L0.C0444d;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: H0.r */
/* JADX INFO: loaded from: classes.dex */
public class C0264r extends AbstractComponentCallbacksC0944o {

    /* JADX INFO: renamed from: W */
    public String f681W;

    /* JADX INFO: renamed from: X */
    public C0263q f682X;

    /* JADX INFO: renamed from: Y */
    public C0261o f683Y;

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: o */
    public final void mo517o(int i3, int i4, Intent intent) {
        super.mo517o(i3, i4, intent);
        C0263q c0263q = this.f682X;
        c0263q.f679o++;
        if (c0263q.f675k != null) {
            if (intent != null) {
                int i5 = CustomTabMainActivity.f3803g;
                if (intent.getBooleanExtra("CustomTabMainActivity.no_activity_exception", false)) {
                    c0263q.m516i();
                    return;
                }
            }
            AbstractC0268v abstractC0268vM513e = c0263q.m513e();
            abstractC0268vM513e.getClass();
            if ((abstractC0268vM513e instanceof C0260n) && intent == null && c0263q.f679o < c0263q.f680p) {
                return;
            }
            c0263q.m513e().mo486g(i3, i4, intent);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        Bundle bundleExtra;
        super.mo518q(bundle);
        if (bundle != null) {
            C0263q c0263q = (C0263q) bundle.getParcelable("loginClient");
            this.f682X = c0263q;
            if (c0263q.f671g != null) {
                throw new C1111h("Can't set fragment once it is already set.");
            }
            c0263q.f671g = this;
        } else {
            C0263q c0263q2 = new C0263q();
            c0263q2.f670f = -1;
            c0263q2.f679o = 0;
            c0263q2.f680p = 0;
            c0263q2.f671g = this;
            this.f682X = c0263q2;
        }
        this.f682X.f672h = new C0444d(this);
        AbstractActivityC0947r abstractActivityC0947rM2490h = m2490h();
        if (abstractActivityC0947rM2490h == null) {
            return;
        }
        ComponentName callingActivity = abstractActivityC0947rM2490h.getCallingActivity();
        if (callingActivity != null) {
            this.f681W = callingActivity.getPackageName();
        }
        Intent intent = abstractActivityC0947rM2490h.getIntent();
        if (intent == null || (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) == null) {
            return;
        }
        this.f683Y = (C0261o) bundleExtra.getParcelable("request");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.com_facebook_login_fragment, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.f682X.f673i = new C0221e(3, viewFindViewById);
        return viewInflate;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: s */
    public final void mo519s() {
        C0263q c0263q = this.f682X;
        if (c0263q.f670f >= 0) {
            c0263q.m513e().mo504b();
        }
        this.f3208H = true;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: w */
    public final void mo520w() {
        this.f3208H = true;
        View view = this.f3210J;
        View viewFindViewById = view == null ? null : view.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: x */
    public final void mo521x() {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7 = false;
        this.f3208H = true;
        if (this.f681W == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            m2490h().finish();
            return;
        }
        C0263q c0263q = this.f682X;
        C0261o c0261o = this.f683Y;
        C0261o c0261o2 = c0263q.f675k;
        if ((c0261o2 == null || c0263q.f670f < 0) && c0261o != null) {
            if (c0261o2 != null) {
                throw new C1111h("Attempted to authorize while a request is pending.");
            }
            if (!C1104a.m2876b() || c0263q.m510b()) {
                c0263q.f675k = c0261o;
                ArrayList arrayList = new ArrayList();
                int i3 = c0261o.f653e;
                switch (i3) {
                    case 1:
                    case 2:
                        z3 = true;
                        break;
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        z3 = false;
                        break;
                    default:
                        throw null;
                }
                if (z3) {
                    arrayList.add(new C0259m(c0263q));
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        z4 = true;
                        break;
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        z4 = false;
                        break;
                    default:
                        throw null;
                }
                if (z4) {
                    arrayList.add(new C0260n(c0263q));
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        z5 = true;
                        break;
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        z5 = false;
                        break;
                    default:
                        throw null;
                }
                if (z5) {
                    arrayList.add(new C0257k(c0263q));
                }
                if (AbstractC0032g.m150h(i3)) {
                    C0248b c0248b = new C0248b(c0263q);
                    c0248b.f608j = "";
                    c0248b.f607i = new BigInteger(100, new Random()).toString(32);
                    C0248b.f605k = false;
                    StringBuilder sb = new StringBuilder("fb");
                    HashSet hashSet = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    sb.append(AbstractC1117n.f3877c);
                    sb.append("://authorize");
                    c0248b.f608j = AbstractC2069g.m4579c(sb.toString());
                    arrayList.add(c0248b);
                }
                switch (i3) {
                    case 1:
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        z6 = true;
                        break;
                    case 2:
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        z6 = false;
                        break;
                    default:
                        throw null;
                }
                if (z6) {
                    arrayList.add(new C0271y(c0263q));
                }
                switch (i3) {
                    case 1:
                    case 2:
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        break;
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        z7 = true;
                        break;
                    default:
                        throw null;
                }
                if (z7) {
                    arrayList.add(new C0256j(c0263q));
                }
                AbstractC0268v[] abstractC0268vArr = new AbstractC0268v[arrayList.size()];
                arrayList.toArray(abstractC0268vArr);
                c0263q.f669e = abstractC0268vArr;
                c0263q.m516i();
            }
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        bundle.putParcelable("loginClient", this.f682X);
    }
}
