package p041N;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/* JADX INFO: renamed from: N.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0528p {
    /* JADX INFO: renamed from: a */
    public static Drawable[] m1051a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    /* JADX INFO: renamed from: b */
    public static int m1052b(View view) {
        return view.getLayoutDirection();
    }

    /* JADX INFO: renamed from: c */
    public static int m1053c(View view) {
        return view.getTextDirection();
    }

    /* JADX INFO: renamed from: d */
    public static Locale m1054d(TextView textView) {
        return textView.getTextLocale();
    }

    /* JADX INFO: renamed from: e */
    public static void m1055e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: renamed from: f */
    public static void m1056f(TextView textView, int i3, int i4, int i5, int i6) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    /* JADX INFO: renamed from: g */
    public static void m1057g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX INFO: renamed from: h */
    public static void m1058h(View view, int i3) {
        view.setTextDirection(i3);
    }
}
