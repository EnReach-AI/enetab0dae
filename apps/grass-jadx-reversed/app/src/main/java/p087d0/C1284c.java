package p087d0;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0309D;
import p029J.AbstractC0323S;

/* JADX INFO: renamed from: d0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1284c extends Property {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4588a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1284c(Class cls, String str, int i3) {
        super(cls, str);
        this.f4588a = i3;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f4588a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return null;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return null;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return Float.valueOf(AbstractC1299r.f4645a.mo1939f((View) obj));
            default:
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                return AbstractC0309D.m615a((View) obj);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f4588a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1287f c1287f = (C1287f) obj;
                PointF pointF = (PointF) obj2;
                c1287f.getClass();
                c1287f.f4591a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                c1287f.f4592b = iRound;
                int i3 = c1287f.f4596f + 1;
                c1287f.f4596f = i3;
                if (i3 == c1287f.f4597g) {
                    AbstractC1299r.m3277a(c1287f.f4595e, c1287f.f4591a, iRound, c1287f.f4593c, c1287f.f4594d);
                    c1287f.f4596f = 0;
                    c1287f.f4597g = 0;
                }
                break;
            case 1:
                C1287f c1287f2 = (C1287f) obj;
                PointF pointF2 = (PointF) obj2;
                c1287f2.getClass();
                c1287f2.f4593c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                c1287f2.f4594d = iRound2;
                int i4 = c1287f2.f4597g + 1;
                c1287f2.f4597g = i4;
                if (c1287f2.f4596f == i4) {
                    AbstractC1299r.m3277a(c1287f2.f4595e, c1287f2.f4591a, c1287f2.f4592b, c1287f2.f4593c, iRound2);
                    c1287f2.f4596f = 0;
                    c1287f2.f4597g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                AbstractC1299r.m3277a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                AbstractC1299r.m3277a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                AbstractC1299r.m3277a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                float fFloatValue = ((Float) obj2).floatValue();
                AbstractC1299r.f4645a.mo1940h((View) obj, fFloatValue);
                break;
            default:
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0309D.m617c((View) obj, (Rect) obj2);
                break;
        }
    }
}
