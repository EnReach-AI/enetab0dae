package p035L;

import android.graphics.Path;
import android.view.animation.PathInterpolator;

/* JADX INFO: renamed from: L.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0440a {
    /* JADX INFO: renamed from: a */
    public static PathInterpolator m973a(float f3, float f4) {
        return new PathInterpolator(f3, f4);
    }

    /* JADX INFO: renamed from: b */
    public static PathInterpolator m974b(float f3, float f4, float f5, float f6) {
        return new PathInterpolator(f3, f4, f5, f6);
    }

    /* JADX INFO: renamed from: c */
    public static PathInterpolator m975c(Path path) {
        return new PathInterpolator(path);
    }
}
