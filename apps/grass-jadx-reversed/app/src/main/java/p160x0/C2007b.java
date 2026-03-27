package p160x0;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: x0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C2007b {

    /* JADX INFO: renamed from: a */
    public boolean f7155a;

    /* JADX INFO: renamed from: b */
    public Object f7156b;

    /* JADX INFO: renamed from: c */
    public Field f7157c;

    /* JADX INFO: renamed from: d */
    public Field f7158d;

    /* JADX INFO: renamed from: a */
    public final ArrayList m4461a() {
        if (!this.f7155a) {
            this.f7155a = true;
            try {
                Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
                this.f7156b = cls.getMethod("getInstance", null).invoke(null, null);
                Field declaredField = cls.getDeclaredField("mViews");
                this.f7157c = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = cls.getDeclaredField("mParams");
                this.f7158d = declaredField2;
                declaredField2.setAccessible(true);
            } catch (ClassNotFoundException e3) {
                Log.d("b", "could not find class: ".concat("android.view.WindowManagerGlobal"), e3);
            } catch (IllegalAccessException e4) {
                Log.d("b", "reflective setup failed using obj: android.view.WindowManagerGlobal method: getInstance field: mViews", e4);
            } catch (NoSuchFieldException e5) {
                Log.d("b", "could not find field: mParams or mViews on ".concat("android.view.WindowManagerGlobal"), e5);
            } catch (NoSuchMethodException e6) {
                Log.d("b", "could not find method: getInstance on android.view.WindowManagerGlobal", e6);
            } catch (RuntimeException e7) {
                Log.d("b", "reflective setup failed using obj: android.view.WindowManagerGlobal method: getInstance field: mViews", e7);
            } catch (InvocationTargetException e8) {
                Log.d("b", "could not invoke: getInstance on android.view.WindowManagerGlobal", e8.getCause());
            }
        }
        Object obj = this.f7156b;
        if (obj == null) {
            Log.d("b", "No reflective access to windowmanager object.");
            return null;
        }
        Field field = this.f7157c;
        if (field == null) {
            Log.d("b", "No reflective access to mViews");
            return null;
        }
        if (this.f7158d == null) {
            Log.d("b", "No reflective access to mPArams");
            return null;
        }
        try {
            List list = (List) field.get(obj);
            List list2 = (List) this.f7158d.get(this.f7156b);
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(new C2006a((View) list.get(i3), (WindowManager.LayoutParams) list2.get(i3)));
            }
            return arrayList;
        } catch (IllegalAccessException e9) {
            Log.d("b", String.format("Reflective access to %s or %s on %s failed.", this.f7157c, this.f7158d, this.f7156b), e9);
            return null;
        } catch (RuntimeException e10) {
            Log.d("b", String.format("Reflective access to %s or %s on %s failed.", this.f7157c, this.f7158d, this.f7156b), e10);
            return null;
        }
    }
}
