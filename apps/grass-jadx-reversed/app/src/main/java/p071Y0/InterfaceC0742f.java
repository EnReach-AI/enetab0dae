package p071Y0;

import com.fasterxml.jackson.databind.JsonDeserializer$None;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import p069X0.AbstractC0729t;
import p118m1.AbstractC1747l;

/* JADX INFO: renamed from: Y0.f */
/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0742f {
    /* JADX INFO: renamed from: as */
    Class m1930as() default Void.class;

    Class builder() default Void.class;

    Class contentAs() default Void.class;

    Class contentConverter() default AbstractC1747l.class;

    Class contentUsing() default JsonDeserializer$None.class;

    Class converter() default AbstractC1747l.class;

    Class keyAs() default Void.class;

    Class keyUsing() default AbstractC0729t.class;

    Class using() default JsonDeserializer$None.class;
}
