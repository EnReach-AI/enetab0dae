package p038M;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import p019F0.C0221e;
import p029J.AbstractC0323S;
import p029J.C0339e;
import p029J.InterfaceC0337d;
import p034K1.C0423j;
import p036L0.C0444d;

/* JADX INFO: renamed from: M.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0452b extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0423j f1094a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0452b(InputConnection inputConnection, C0423j c0423j) {
        super(inputConnection, false);
        this.f1094a = c0423j;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i3, Bundle bundle) {
        Bundle bundle2;
        InterfaceC0337d c0444d;
        C0444d c0444d2 = inputContentInfo == null ? null : new C0444d(new C0221e(inputContentInfo));
        C0423j c0423j = this.f1094a;
        c0423j.getClass();
        if ((i3 & 1) != 0) {
            try {
                ((C0221e) c0444d2.f1085e).m441A();
                InputContentInfo inputContentInfo2 = (InputContentInfo) ((C0221e) c0444d2.f1085e).f534f;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e3) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e3);
            }
        } else {
            bundle2 = bundle;
        }
        ClipDescription description = ((InputContentInfo) ((C0221e) c0444d2.f1085e).f534f).getDescription();
        C0221e c0221e = (C0221e) c0444d2.f1085e;
        ClipData clipData = new ClipData(description, new ClipData.Item(((InputContentInfo) c0221e.f534f).getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            c0444d = new C0444d(clipData, 2);
        } else {
            C0339e c0339e = new C0339e();
            c0339e.f837f = clipData;
            c0339e.f838g = 2;
            c0444d = c0339e;
        }
        c0444d.mo733g(((InputContentInfo) c0221e.f534f).getLinkUri());
        c0444d.mo732e(bundle2);
        if (AbstractC0323S.m697g((View) c0423j.f964a, c0444d.mo731d()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i3, bundle);
    }
}
