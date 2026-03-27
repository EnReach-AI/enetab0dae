package p166z0;

import com.facebook.C1111h;
import com.facebook.C1112i;
import com.facebook.C1114k;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: renamed from: z0.I */
/* JADX INFO: loaded from: classes.dex */
public final class C2060I implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String[] f7273a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7274b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ CountDownLatch f7275c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ AsyncTaskC2061J f7276d;

    public C2060I(AsyncTaskC2061J asyncTaskC2061J, String[] strArr, int i3, CountDownLatch countDownLatch) {
        this.f7276d = asyncTaskC2061J;
        this.f7273a = strArr;
        this.f7274b = i3;
        this.f7275c = countDownLatch;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        C1114k c1114k;
        String str;
        int i3 = this.f7274b;
        try {
            c1114k = c1128y.f3921c;
            str = "Error staging photo.";
        } catch (Exception e3) {
            this.f7276d.f7279c[i3] = e3;
        }
        if (c1114k != null) {
            String localizedMessage = c1114k.f3868i;
            if (localizedMessage == null) {
                localizedMessage = c1114k.f3872m.getLocalizedMessage();
            }
            if (localizedMessage != null) {
                str = localizedMessage;
            }
            throw new C1112i(c1128y, str);
        }
        JSONObject jSONObject = c1128y.f3920b;
        if (jSONObject == null) {
            throw new C1111h("Error staging photo.");
        }
        String strOptString = jSONObject.optString("uri");
        if (strOptString == null) {
            throw new C1111h("Error staging photo.");
        }
        this.f7273a[i3] = strOptString;
        this.f7275c.countDown();
    }
}
