package p166z0;

import android.os.Bundle;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: z0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C2066d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7304a;

    public /* synthetic */ C2066d(int i3) {
        this.f7304a = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m4572a(Bundle bundle, String str, Object obj) throws JSONException {
        switch (this.f7304a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                return;
            case 1:
                bundle.putInt(str, ((Integer) obj).intValue());
                return;
            case 2:
                bundle.putLong(str, ((Long) obj).longValue());
                return;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                bundle.putString(str, (String) obj);
                return;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                throw new IllegalArgumentException("Unexpected type from JSON");
            default:
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList<String> arrayList = new ArrayList<>();
                if (jSONArray.length() == 0) {
                    bundle.putStringArrayList(str, arrayList);
                    return;
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    Object obj2 = jSONArray.get(i3);
                    if (!(obj2 instanceof String)) {
                        throw new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                    }
                    arrayList.add((String) obj2);
                }
                bundle.putStringArrayList(str, arrayList);
                return;
        }
    }
}
