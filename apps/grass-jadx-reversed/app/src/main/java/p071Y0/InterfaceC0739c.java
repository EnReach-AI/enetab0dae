package p071Y0;

import p039M0.EnumC0511z;

/* JADX INFO: renamed from: Y0.c */
/* JADX INFO: loaded from: classes.dex */
public @interface InterfaceC0739c {
    EnumC0511z include() default EnumC0511z.f1183f;

    String propName() default "";

    String propNamespace() default "";

    boolean required() default false;

    String value();
}
