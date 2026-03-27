package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.Y */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0476Y {
    boolean enabled() default true;

    String prefix() default "";

    String suffix() default "";
}
