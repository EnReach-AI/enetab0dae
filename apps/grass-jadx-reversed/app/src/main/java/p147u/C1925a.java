package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.HashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: u.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1925a {

    /* JADX INFO: renamed from: a */
    public int f6741a;

    /* JADX INFO: renamed from: b */
    public int f6742b;

    /* JADX INFO: renamed from: c */
    public float f6743c;

    /* JADX INFO: renamed from: d */
    public String f6744d;

    /* JADX INFO: renamed from: e */
    public boolean f6745e;

    /* JADX INFO: renamed from: f */
    public int f6746f;

    public C1925a(C1925a c1925a, Object obj) {
        c1925a.getClass();
        this.f6741a = c1925a.f6741a;
        m4319b(obj);
    }

    /* JADX INFO: renamed from: a */
    public static void m4318a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC1940p.f6926c);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i3 = 0;
        Object string2 = null;
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 1) {
                string2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i3 = 6;
            } else {
                int i5 = 3;
                if (index == 3) {
                    string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    i5 = 4;
                    if (index == 2) {
                        string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            string2 = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            string2 = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                        } else {
                            i5 = 5;
                            if (index == 5) {
                                string2 = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                                i3 = 2;
                            } else if (index == 6) {
                                string2 = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                                i3 = 1;
                            } else if (index == 8) {
                                string2 = typedArrayObtainStyledAttributes.getString(index);
                            }
                        }
                        i3 = 7;
                    }
                }
                i3 = i5;
            }
        }
        if (string != null && string2 != null) {
            C1925a c1925a = new C1925a();
            c1925a.f6741a = i3;
            c1925a.m4319b(string2);
            map.put(string, c1925a);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: b */
    public final void m4319b(Object obj) {
        switch (AbstractC1849h.m4118b(this.f6741a)) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f6742b = ((Integer) obj).intValue();
                break;
            case 1:
                this.f6743c = ((Float) obj).floatValue();
                break;
            case 2:
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                this.f6746f = ((Integer) obj).intValue();
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                this.f6744d = (String) obj;
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                this.f6745e = ((Boolean) obj).booleanValue();
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                this.f6743c = ((Float) obj).floatValue();
                break;
        }
    }
}
