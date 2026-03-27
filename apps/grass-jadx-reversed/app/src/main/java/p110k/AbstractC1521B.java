package p110k;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import p029J.AbstractC0323S;
import p029J.C0339e;
import p029J.InterfaceC0337d;
import p036L0.C0444d;

/* JADX INFO: renamed from: k.B */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1521B {
    /* JADX INFO: renamed from: a */
    public static boolean m3565a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC0337d c0444d;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                c0444d = new C0444d(clipData, 3);
            } else {
                C0339e c0339e = new C0339e();
                c0339e.f837f = clipData;
                c0339e.f838g = 3;
                c0444d = c0339e;
            }
            AbstractC0323S.m697g(textView, c0444d.mo731d());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3566b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC0337d c0444d;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            c0444d = new C0444d(clipData, 3);
        } else {
            C0339e c0339e = new C0339e();
            c0339e.f837f = clipData;
            c0339e.f838g = 3;
            c0444d = c0339e;
        }
        AbstractC0323S.m697g(view, c0444d.mo731d());
        return true;
    }
}
