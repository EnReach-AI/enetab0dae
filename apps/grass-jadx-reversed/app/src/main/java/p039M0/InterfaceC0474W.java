package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.W */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0474W {
    Class defaultImpl() default InterfaceC0474W.class;

    EnumC0471T include() default EnumC0471T.f1107e;

    String property() default "";

    EnumC0472U use();

    boolean visible() default false;
}
