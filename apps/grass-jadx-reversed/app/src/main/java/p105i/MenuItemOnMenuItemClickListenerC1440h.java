package p105i;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: i.h */
/* JADX INFO: loaded from: classes.dex */
public final class MenuItemOnMenuItemClickListenerC1440h implements MenuItem.OnMenuItemClickListener {

    /* JADX INFO: renamed from: c */
    public static final Class[] f5093c = {MenuItem.class};

    /* JADX INFO: renamed from: a */
    public Object f5094a;

    /* JADX INFO: renamed from: b */
    public Method f5095b;

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Method method = this.f5095b;
        try {
            Class<?> returnType = method.getReturnType();
            Class<?> cls = Boolean.TYPE;
            Object obj = this.f5094a;
            if (returnType == cls) {
                return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
            }
            method.invoke(obj, menuItem);
            return true;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }
}
