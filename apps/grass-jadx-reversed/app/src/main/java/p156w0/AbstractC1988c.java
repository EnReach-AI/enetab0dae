package p156w0;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p129p0.AbstractC1823e;

/* JADX INFO: renamed from: w0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1988c {

    /* JADX INFO: renamed from: a */
    public static final ArrayList f7054a = new ArrayList(Arrays.asList(Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class));

    /* JADX INFO: renamed from: a */
    public static ArrayList m4396a(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1988c.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Iterator it = f7054a.iterator();
            while (it.hasNext()) {
                if (((Class) it.next()).isInstance(view)) {
                    return arrayList;
                }
            }
            if (view.isClickable()) {
                arrayList.add(view);
            }
            Iterator it2 = AbstractC1823e.m4056b(view).iterator();
            while (it2.hasNext()) {
                arrayList.addAll(m4396a((View) it2.next()));
            }
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1988c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static JSONObject m4397b(View view, View view2) {
        if (AbstractC0147a.f354a.contains(AbstractC1988c.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (view == view2) {
                try {
                    jSONObject.put("is_interacted", true);
                } catch (JSONException unused) {
                }
            }
            m4400e(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            Iterator it = AbstractC1823e.m4056b(view).iterator();
            while (it.hasNext()) {
                jSONArray.put(m4397b((View) it.next(), view2));
            }
            jSONObject.put("childviews", jSONArray);
            return jSONObject;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1988c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static ArrayList m4398c(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1988c.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (View view2 : AbstractC1823e.m4056b(view)) {
                String strM4064j = AbstractC1823e.m4064j(view2);
                if (!strM4064j.isEmpty()) {
                    arrayList.add(strM4064j);
                }
                arrayList.addAll(m4398c(view2));
            }
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1988c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static String m4399d(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1988c.class)) {
            return null;
        }
        try {
            String strM4064j = AbstractC1823e.m4064j(view);
            return !strM4064j.isEmpty() ? strM4064j : TextUtils.join(" ", m4398c(view));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1988c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4400e(View view, JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(AbstractC1988c.class)) {
            return;
        }
        try {
            String strM4064j = AbstractC1823e.m4064j(view);
            String strM4062h = AbstractC1823e.m4062h(view);
            jSONObject.put("classname", view.getClass().getSimpleName());
            jSONObject.put("classtypebitmask", AbstractC1823e.m4057c(view));
            if (!strM4064j.isEmpty()) {
                jSONObject.put("text", strM4064j);
            }
            if (!strM4062h.isEmpty()) {
                jSONObject.put("hint", strM4062h);
            }
            if (view instanceof EditText) {
                jSONObject.put("inputtype", ((EditText) view).getInputType());
            }
        } catch (JSONException unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1988c.class);
        }
    }
}
