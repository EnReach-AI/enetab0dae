package p007B1;

import android.view.View;
import java.util.WeakHashMap;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: B1.p */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0056p implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
