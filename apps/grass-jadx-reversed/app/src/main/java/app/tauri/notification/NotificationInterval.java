package app.tauri.notification;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationInterval {

    /* JADX INFO: renamed from: e */
    public static final /* synthetic */ NotificationInterval[] f3506e = {new NotificationInterval("Year", 0), new NotificationInterval("Month", 1), new NotificationInterval("TwoWeeks", 2), new NotificationInterval("Week", 3), new NotificationInterval("Day", 4), new NotificationInterval("Hour", 5), new NotificationInterval("Minute", 6), new NotificationInterval("Second", 7)};

    /* JADX INFO: Fake field, exist only in values array */
    NotificationInterval EF5;

    public static NotificationInterval valueOf(String str) {
        return (NotificationInterval) Enum.valueOf(NotificationInterval.class, str);
    }

    public static NotificationInterval[] values() {
        return (NotificationInterval[]) f3506e.clone();
    }
}
