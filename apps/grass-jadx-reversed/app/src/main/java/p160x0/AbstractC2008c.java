package p160x0;

import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;
import p144t0.AbstractC1919e;

/* JADX INFO: renamed from: x0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2008c {

    /* JADX INFO: renamed from: a */
    public static Field f7159a;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mKeyedTags");
            f7159a = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static JSONObject m4462a(View view) {
        String strM4288i;
        try {
            if (f7159a == null) {
                Field declaredField = View.class.getDeclaredField("mKeyedTags");
                f7159a = declaredField;
                declaredField.setAccessible(true);
            }
            SparseArray sparseArray = (SparseArray) f7159a.get(view);
            if (sparseArray == null || sparseArray.size() <= 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    view.getContext();
                    Resources resources = view.getResources();
                    int iKeyAt = sparseArray.keyAt(i3);
                    try {
                        strM4288i = AbstractC1919e.m4288i(resources, iKeyAt);
                    } catch (Resources.NotFoundException unused) {
                        strM4288i = "#" + Integer.toHexString(iKeyAt);
                    }
                    try {
                        jSONObject.put(strM4288i, sparseArray.valueAt(i3));
                    } catch (JSONException unused2) {
                    }
                }
            } catch (Exception unused3) {
            }
            return jSONObject;
        } catch (Exception unused4) {
            return null;
        }
    }
}
