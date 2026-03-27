package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.t */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0505t {
    Class generator();

    String property() default "@id";

    Class resolver() default AbstractC0493h0.class;

    Class scope() default Object.class;
}
