package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.B */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0454B {
    EnumC0511z content() default EnumC0511z.f1182e;

    Class contentFilter() default Void.class;

    EnumC0511z value() default EnumC0511z.f1182e;

    Class valueFilter() default Void.class;
}
