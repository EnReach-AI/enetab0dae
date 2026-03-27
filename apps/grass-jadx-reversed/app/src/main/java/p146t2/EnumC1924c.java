package p146t2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: t2.c */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC1924c {
    NANOSECONDS(TimeUnit.NANOSECONDS),
    /* JADX INFO: Fake field, exist only in values array */
    MICROSECONDS(TimeUnit.MICROSECONDS),
    MILLISECONDS(TimeUnit.MILLISECONDS),
    SECONDS(TimeUnit.SECONDS),
    MINUTES(TimeUnit.MINUTES),
    HOURS(TimeUnit.HOURS),
    DAYS(TimeUnit.DAYS);


    /* JADX INFO: renamed from: e */
    public final TimeUnit f6740e;

    EnumC1924c(TimeUnit timeUnit) {
        this.f6740e = timeUnit;
    }
}
