package p071Y0;

import p039M0.EnumC0511z;

/* JADX INFO: renamed from: Y0.d */
/* JADX INFO: loaded from: classes.dex */
public @interface InterfaceC0740d {
    EnumC0511z include() default EnumC0511z.f1183f;

    String name() default "";

    String namespace() default "";

    boolean required() default false;

    Class type() default Object.class;

    Class value();
}
