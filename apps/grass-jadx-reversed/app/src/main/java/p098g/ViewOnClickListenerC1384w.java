package p098g;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: g.w */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1384w implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final View f5003e;

    /* JADX INFO: renamed from: f */
    public final String f5004f;

    /* JADX INFO: renamed from: g */
    public Method f5005g;

    /* JADX INFO: renamed from: h */
    public Context f5006h;

    public ViewOnClickListenerC1384w(View view, String str) {
        this.f5003e = view;
        this.f5004f = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        if (this.f5005g == null) {
            View view2 = this.f5003e;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f5004f;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    throw new IllegalStateException("Could not find method " + str2 + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + view2.getClass() + str);
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f5005g = method;
                        this.f5006h = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f5005g.invoke(this.f5006h, view);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException("Could not execute method for android:onClick", e4);
        }
    }
}
