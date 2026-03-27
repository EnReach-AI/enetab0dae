package app.tauri.notification;

import java.util.Date;
import p039M0.EnumC0501p;
import p039M0.InterfaceC0503r;
import p071Y0.InterfaceC0742f;
import p071Y0.InterfaceC0748l;
import p119m2.AbstractC1764c;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0742f(using = NotificationScheduleDeserializer.class)
@InterfaceC0748l(using = NotificationScheduleSerializer.class)
public abstract class NotificationSchedule {

    /* JADX INFO: renamed from: app.tauri.notification.NotificationSchedule$At */
    @InterfaceC0742f
    public static final class C0994At extends NotificationSchedule {
        private boolean allowWhileIdle;

        @InterfaceC0503r(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = EnumC0501p.f1165m)
        public Date date;
        private boolean repeating;

        public C0994At() {
            super(null);
        }

        public final boolean getAllowWhileIdle() {
            return this.allowWhileIdle;
        }

        public final Date getDate() {
            Date date = this.date;
            if (date != null) {
                return date;
            }
            AbstractC1766e.m3924i("date");
            throw null;
        }

        public final boolean getRepeating() {
            return this.repeating;
        }

        public final void setAllowWhileIdle(boolean z3) {
            this.allowWhileIdle = z3;
        }

        public final void setDate(Date date) {
            AbstractC1766e.m3920e("<set-?>", date);
            this.date = date;
        }

        public final void setRepeating(boolean z3) {
            this.repeating = z3;
        }
    }

    @InterfaceC0742f
    public static final class Every extends NotificationSchedule {
        private boolean allowWhileIdle;
        private int count;
        public NotificationInterval interval;

        public Every() {
            super(null);
        }

        public final boolean getAllowWhileIdle() {
            return this.allowWhileIdle;
        }

        public final int getCount() {
            return this.count;
        }

        public final NotificationInterval getInterval() {
            NotificationInterval notificationInterval = this.interval;
            if (notificationInterval != null) {
                return notificationInterval;
            }
            AbstractC1766e.m3924i("interval");
            throw null;
        }

        public final void setAllowWhileIdle(boolean z3) {
            this.allowWhileIdle = z3;
        }

        public final void setCount(int i3) {
            this.count = i3;
        }

        public final void setInterval(NotificationInterval notificationInterval) {
            AbstractC1766e.m3920e("<set-?>", notificationInterval);
            this.interval = notificationInterval;
        }
    }

    @InterfaceC0742f
    public static final class Interval extends NotificationSchedule {
        private boolean allowWhileIdle;
        public DateMatch interval;

        public Interval() {
            super(null);
        }

        public final boolean getAllowWhileIdle() {
            return this.allowWhileIdle;
        }

        public final DateMatch getInterval() {
            DateMatch dateMatch = this.interval;
            if (dateMatch != null) {
                return dateMatch;
            }
            AbstractC1766e.m3924i("interval");
            throw null;
        }

        public final void setAllowWhileIdle(boolean z3) {
            this.allowWhileIdle = z3;
        }

        public final void setInterval(DateMatch dateMatch) {
            AbstractC1766e.m3920e("<set-?>", dateMatch);
            this.interval = dateMatch;
        }
    }

    public /* synthetic */ NotificationSchedule(AbstractC1764c abstractC1764c) {
        this();
    }

    public final boolean allowWhileIdle() {
        if (this instanceof C0994At) {
            return ((C0994At) this).getAllowWhileIdle();
        }
        if (this instanceof Interval) {
            return ((Interval) this).getAllowWhileIdle();
        }
        if (this instanceof Every) {
            return ((Every) this).getAllowWhileIdle();
        }
        return false;
    }

    public final boolean isRemovable() {
        return (this instanceof C0994At) && !((C0994At) this).getRepeating();
    }

    private NotificationSchedule() {
    }
}
