package p125o0;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.AbstractC1117n;
import java.lang.ref.WeakReference;
import p129p0.C1819a;
import p141s0.AbstractC1875e;

/* JADX INFO: renamed from: o0.i */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC1799i implements View.OnTouchListener {

    /* JADX INFO: renamed from: e */
    public C1819a f6213e;

    /* JADX INFO: renamed from: f */
    public WeakReference f6214f;

    /* JADX INFO: renamed from: g */
    public WeakReference f6215g;

    /* JADX INFO: renamed from: h */
    public View.OnTouchListener f6216h;

    /* JADX INFO: renamed from: i */
    public boolean f6217i;

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1819a c1819a;
        if (motionEvent.getAction() == 1 && (c1819a = this.f6213e) != null) {
            Bundle bundleM3967i = C1798h.m3967i(c1819a, (View) this.f6215g.get(), (View) this.f6214f.get());
            if (bundleM3967i.containsKey("_valueToSum")) {
                bundleM3967i.putDouble("_valueToSum", AbstractC1875e.m4198d(bundleM3967i.getString("_valueToSum")));
            }
            bundleM3967i.putString("_is_fb_codeless", "1");
            AbstractC1117n.m2891a().execute(new RunnableC1791a(c1819a.f6302a, bundleM3967i, 1));
        }
        View.OnTouchListener onTouchListener = this.f6216h;
        return onTouchListener != null && onTouchListener.onTouch(view, motionEvent);
    }
}
