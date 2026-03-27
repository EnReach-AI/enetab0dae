package p039M0;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: renamed from: M0.h */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0492h {
    EnumC0490g creatorVisibility() default EnumC0490g.f1135h;

    EnumC0490g fieldVisibility() default EnumC0490g.f1135h;

    EnumC0490g getterVisibility() default EnumC0490g.f1135h;

    EnumC0490g isGetterVisibility() default EnumC0490g.f1135h;

    EnumC0490g setterVisibility() default EnumC0490g.f1135h;
}
