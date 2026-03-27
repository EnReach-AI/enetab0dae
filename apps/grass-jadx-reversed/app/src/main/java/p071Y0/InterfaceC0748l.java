package p071Y0;

import com.fasterxml.jackson.databind.JsonSerializer$None;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p118m1.AbstractC1747l;

/* JADX INFO: renamed from: Y0.l */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0748l {
    /* JADX INFO: renamed from: as */
    Class m1931as() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default AbstractC1747l.class;

    Class contentUsing() default JsonSerializer$None.class;

    Class converter() default AbstractC1747l.class;

    EnumC0746j include() default EnumC0746j.f2106e;

    Class keyAs() default Void.class;

    Class keyUsing() default JsonSerializer$None.class;

    Class nullsUsing() default JsonSerializer$None.class;

    EnumC0747k typing() default EnumC0747k.f2110g;

    Class using() default JsonSerializer$None.class;
}
