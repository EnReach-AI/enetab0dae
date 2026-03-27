package app.tauri.notification;

import app.tauri.notification.NotificationSchedule;
import p042N0.AbstractC0545m;
import p042N0.InterfaceC0557y;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0725p;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationScheduleDeserializer extends AbstractC0722m {
    @Override // p069X0.AbstractC0722m
    public NotificationSchedule deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        AbstractC1766e.m3920e("jsonParser", abstractC0545m);
        AbstractC1766e.m3920e("deserializationContext", abstractC0718i);
        InterfaceC0557y interfaceC0557yMo1221a = abstractC0545m.mo1196k().mo1221a(abstractC0545m);
        AbstractC1766e.m3919d("readTree(...)", interfaceC0557yMo1221a);
        AbstractC0725p abstractC0725p = (AbstractC0725p) interfaceC0557yMo1221a;
        AbstractC0725p abstractC0725pMo1904l = abstractC0725p.mo1904l("at");
        if (abstractC0725pMo1904l != null) {
            Object objMo1222b = abstractC0545m.mo1196k().mo1222b(abstractC0725pMo1904l, NotificationSchedule.C0994At.class);
            AbstractC1766e.m3919d("treeToValue(...)", objMo1222b);
            return (NotificationSchedule) objMo1222b;
        }
        AbstractC0725p abstractC0725pMo1904l2 = abstractC0725p.mo1904l("interval");
        if (abstractC0725pMo1904l2 != null) {
            Object objMo1222b2 = abstractC0545m.mo1196k().mo1222b(abstractC0725pMo1904l2, NotificationSchedule.Interval.class);
            AbstractC1766e.m3919d("treeToValue(...)", objMo1222b2);
            return (NotificationSchedule) objMo1222b2;
        }
        AbstractC0725p abstractC0725pMo1904l3 = abstractC0725p.mo1904l("every");
        if (abstractC0725pMo1904l3 != null) {
            Object objMo1222b3 = abstractC0545m.mo1196k().mo1222b(abstractC0725pMo1904l3, NotificationSchedule.Every.class);
            AbstractC1766e.m3919d("treeToValue(...)", objMo1222b3);
            return (NotificationSchedule) objMo1222b3;
        }
        throw new Error("unknown schedule kind " + abstractC0725p);
    }
}
