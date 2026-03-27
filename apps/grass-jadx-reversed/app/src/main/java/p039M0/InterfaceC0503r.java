package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.r */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0503r {
    EnumC0491g0 lenient() default EnumC0491g0.f1138f;

    String locale() default "##default";

    String pattern() default "";

    EnumC0501p shape() default EnumC0501p.f1157e;

    String timezone() default "##default";

    EnumC0499n[] with() default {};

    EnumC0499n[] without() default {};
}
