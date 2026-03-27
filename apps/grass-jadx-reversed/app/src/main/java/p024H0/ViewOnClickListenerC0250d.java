package p024H0;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.google.android.material.datepicker.C1258j;
import com.google.android.material.datepicker.C1259k;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p010C0.AbstractC0147a;
import p033K0.C0404b;
import p098g.C1365d;
import p105i.AbstractC1434b;
import p108j.C1481o;
import p110k.C1569Z0;
import p166z0.DialogC2062K;

/* JADX INFO: renamed from: H0.d */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0250d implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f611e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f612f;

    public /* synthetic */ ViewOnClickListenerC0250d(int i3, Object obj) {
        this.f611e = i3;
        this.f612f = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f611e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    ((C0255i) this.f612f).m494V();
                    return;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, this);
                    return;
                }
            case 1:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    ((C0404b) this.f612f).f929o0.dismiss();
                    return;
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, this);
                    return;
                }
            case 2:
                C1258j c1258j = (C1258j) this.f612f;
                int i3 = c1258j.f4368a0;
                if (i3 == 2) {
                    c1258j.m3178Q(1);
                    return;
                } else {
                    if (i3 == 1) {
                        c1258j.m3178Q(2);
                        return;
                    }
                    return;
                }
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                C1259k c1259k = (C1259k) this.f612f;
                Button button = c1259k.f4379D0;
                c1259k.m3181S();
                throw null;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                C1365d c1365d = (C1365d) this.f612f;
                Button button2 = c1365d.f4883f;
                c1365d.f4900w.obtainMessage(1, c1365d.f4879b).sendToTarget();
                return;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                ((AbstractC1434b) this.f612f).mo3312a();
                return;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                C1569Z0 c1569z0 = ((Toolbar) this.f612f).f2824O;
                C1481o c1481o = c1569z0 == null ? null : c1569z0.f5593f;
                if (c1481o != null) {
                    c1481o.collapseActionView();
                    return;
                }
                return;
            default:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    ((DialogC2062K) this.f612f).cancel();
                    return;
                } catch (Throwable th3) {
                    AbstractC0147a.m295a(th3, this);
                    return;
                }
        }
    }
}
