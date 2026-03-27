package app.tauri.notification;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import app.tauri.Logger;
import app.tauri.notification.DateMatch;
import app.tauri.notification.NotificationPlugin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p042N0.AbstractC0546n;
import p069X0.C0734y;
import p086c2.AbstractC1085d;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p144t0.AbstractC1920f;

/* JADX INFO: loaded from: classes.dex */
public final class TimedNotificationPublisher extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f3521a = 0;

    public static final class Companion {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws AbstractC0546n {
        List listM4310m;
        ArrayList arrayList;
        AbstractC1766e.m3920e("context", context);
        AbstractC1766e.m3920e("intent", intent);
        Object systemService = context.getSystemService("notification");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.NotificationManager", systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        android.app.Notification notification = Build.VERSION.SDK_INT >= 33 ? (android.app.Notification) intent.getParcelableExtra("NotificationPublisher.notification", android.app.Notification.class) : (android.app.Notification) intent.getParcelableExtra("NotificationPublisher.notification");
        if (notification != null) {
            notification.when = System.currentTimeMillis();
        }
        int intExtra = intent.getIntExtra("NotificationId", Integer.MIN_VALUE);
        if (intExtra == Integer.MIN_VALUE) {
            Logger.Companion.m2656a(Logger.Companion.m2657b("Notification"), "No valid id supplied");
        }
        NotificationStorage notificationStorage = new NotificationStorage(context, new C0734y());
        Notification notificationM2671c = notificationStorage.m2671c(String.valueOf(intExtra));
        if (notificationM2671c != null) {
            NotificationPlugin.Companion.m2668a(notificationM2671c);
        }
        notificationManager.notify(intExtra, notification);
        String stringExtra = intent.getStringExtra("NotificationPublisher.cron");
        if (stringExtra == null) {
            notificationStorage.m2670b(String.valueOf(intExtra));
            return;
        }
        DateMatch dateMatch = new DateMatch();
        dateMatch.f3499h = -1;
        Pattern patternCompile = Pattern.compile(" ");
        AbstractC1766e.m3919d("compile(...)", patternCompile);
        Matcher matcher = patternCompile.matcher(stringExtra);
        if (matcher.find()) {
            ArrayList arrayList2 = new ArrayList(10);
            int iEnd = 0;
            do {
                arrayList2.add(stringExtra.subSequence(iEnd, matcher.start()).toString());
                iEnd = matcher.end();
            } while (matcher.find());
            arrayList2.add(stringExtra.subSequence(iEnd, stringExtra.length()).toString());
            listM4310m = arrayList2;
        } else {
            listM4310m = AbstractC1920f.m4310m(stringExtra.toString());
        }
        boolean zIsEmpty = listM4310m.isEmpty();
        List listM4310m2 = C1093l.f3782e;
        if (!zIsEmpty) {
            ListIterator listIterator = listM4310m.listIterator(listM4310m.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                if (((String) listIterator.previous()).length() != 0) {
                    int iNextIndex = listIterator.nextIndex() + 1;
                    if (iNextIndex < 0) {
                        throw new IllegalArgumentException(("Requested element count " + iNextIndex + " is less than zero.").toString());
                    }
                    if (iNextIndex != 0) {
                        if (iNextIndex >= listM4310m.size()) {
                            AbstractC1766e.m3920e("<this>", listM4310m);
                            boolean z3 = listM4310m instanceof Collection;
                            listM4310m2 = C1093l.f3782e;
                            if (z3) {
                                List list = listM4310m;
                                int size = list.size();
                                if (size != 0) {
                                    if (size != 1) {
                                        listM4310m2 = new ArrayList(list);
                                    } else {
                                        listM4310m2 = AbstractC1920f.m4310m(listM4310m instanceof List ? listM4310m.get(0) : listM4310m.iterator().next());
                                    }
                                }
                            } else {
                                if (z3) {
                                    arrayList = new ArrayList(listM4310m);
                                } else {
                                    arrayList = new ArrayList();
                                    AbstractC1085d.m2835y(listM4310m, arrayList);
                                }
                                int size2 = arrayList.size();
                                if (size2 != 0) {
                                    listM4310m2 = size2 != 1 ? arrayList : AbstractC1920f.m4310m(arrayList.get(0));
                                }
                            }
                        } else if (iNextIndex != 1) {
                            ArrayList arrayList3 = new ArrayList(iNextIndex);
                            Iterator it = listM4310m.iterator();
                            int i3 = 0;
                            while (it.hasNext()) {
                                arrayList3.add(it.next());
                                i3++;
                                if (i3 == iNextIndex) {
                                    break;
                                }
                            }
                            int size3 = arrayList3.size();
                            if (size3 != 0) {
                                listM4310m2 = size3 != 1 ? arrayList3 : AbstractC1920f.m4310m(arrayList3.get(0));
                            }
                        } else {
                            if (listM4310m.isEmpty()) {
                                throw new NoSuchElementException("List is empty.");
                            }
                            listM4310m2 = AbstractC1920f.m4310m(listM4310m.get(0));
                        }
                    }
                }
            }
        }
        String[] strArr = (String[]) listM4310m2.toArray(new String[0]);
        if (strArr.length == 7) {
            dateMatch.f3492a = DateMatch.Companion.m2665a(strArr[0]);
            dateMatch.f3493b = DateMatch.Companion.m2665a(strArr[1]);
            dateMatch.f3494c = DateMatch.Companion.m2665a(strArr[2]);
            dateMatch.f3495d = DateMatch.Companion.m2665a(strArr[3]);
            dateMatch.f3496e = DateMatch.Companion.m2665a(strArr[4]);
            dateMatch.f3497f = DateMatch.Companion.m2665a(strArr[5]);
            dateMatch.f3499h = DateMatch.Companion.m2665a(strArr[6]);
        }
        if (strArr.length == 8) {
            dateMatch.f3492a = DateMatch.Companion.m2665a(strArr[0]);
            dateMatch.f3493b = DateMatch.Companion.m2665a(strArr[1]);
            dateMatch.f3494c = DateMatch.Companion.m2665a(strArr[2]);
            dateMatch.f3495d = DateMatch.Companion.m2665a(strArr[3]);
            dateMatch.f3496e = DateMatch.Companion.m2665a(strArr[4]);
            dateMatch.f3497f = DateMatch.Companion.m2665a(strArr[5]);
            dateMatch.f3498g = DateMatch.Companion.m2665a(strArr[6]);
            dateMatch.f3499h = DateMatch.Companion.m2665a(strArr[7]);
        }
        Object systemService2 = context.getSystemService("alarm");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.AlarmManager", systemService2);
        AlarmManager alarmManager = (AlarmManager) systemService2;
        long jM2664a = dateMatch.m2664a(new Date());
        Object objClone = intent.clone();
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.content.Intent", objClone);
        Intent intent2 = (Intent) objClone;
        int i4 = Build.VERSION.SDK_INT;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, intExtra, intent2, i4 >= 31 ? 301989888 : 268435456);
        if (i4 < 31 || alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExact(1, jM2664a, broadcast);
        } else {
            alarmManager.set(1, jM2664a, broadcast);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strM2657b = Logger.Companion.m2657b("Notification");
        String str = "notification " + intExtra + " will next fire at " + simpleDateFormat.format(new Date(jM2664a));
        AbstractC1766e.m3920e("tag", strM2657b);
        AbstractC1766e.m3920e("message", str);
    }
}
