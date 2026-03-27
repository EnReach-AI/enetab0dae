package app.tauri.notification;

import android.annotation.SuppressLint;
import app.tauri.notification.NotificationSchedule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p119m2.AbstractC1764c;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationScheduleSerializer extends StdSerializer<NotificationSchedule> {
    public NotificationScheduleSerializer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ NotificationScheduleSerializer(Class cls, int i3, AbstractC1764c abstractC1764c) {
        this((i3 & 1) != 0 ? null : cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    @SuppressLint({"SimpleDateFormat"})
    public void serialize(NotificationSchedule notificationSchedule, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC1766e.m3920e("value", notificationSchedule);
        AbstractC1766e.m3920e("jgen", abstractC0540h);
        AbstractC1766e.m3920e("provider", abstractC0709K);
        abstractC0540h.mo1120M();
        if (notificationSchedule instanceof NotificationSchedule.C0994At) {
            abstractC0540h.mo1145r("at");
            abstractC0540h.mo1120M();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            NotificationSchedule.C0994At c0994At = (NotificationSchedule.C0994At) notificationSchedule;
            String str = simpleDateFormat.format(c0994At.getDate());
            abstractC0540h.mo1145r("date");
            abstractC0540h.mo1125R(str);
            boolean repeating = c0994At.getRepeating();
            abstractC0540h.mo1145r("repeating");
            abstractC0540h.mo1140m(repeating);
            abstractC0540h.mo1143p();
        } else if (notificationSchedule instanceof NotificationSchedule.Interval) {
            abstractC0540h.mo1145r("interval");
            abstractC0540h.mo1120M();
            DateMatch interval = ((NotificationSchedule.Interval) notificationSchedule).getInterval();
            abstractC0540h.mo1145r("interval");
            abstractC0540h.mo1109B(interval);
            abstractC0540h.mo1143p();
        } else if (notificationSchedule instanceof NotificationSchedule.Every) {
            abstractC0540h.mo1145r("every");
            abstractC0540h.mo1120M();
            NotificationSchedule.Every every = (NotificationSchedule.Every) notificationSchedule;
            NotificationInterval interval2 = every.getInterval();
            abstractC0540h.mo1145r("interval");
            abstractC0540h.mo1109B(interval2);
            int count = every.getCount();
            abstractC0540h.mo1145r("count");
            abstractC0540h.mo1149v(count);
            abstractC0540h.mo1143p();
        }
        abstractC0540h.mo1143p();
    }

    public NotificationScheduleSerializer(Class<NotificationSchedule> cls) {
        super(cls);
    }
}
