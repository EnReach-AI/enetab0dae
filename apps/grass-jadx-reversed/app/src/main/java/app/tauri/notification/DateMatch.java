package app.tauri.notification;

import java.util.Calendar;
import java.util.Date;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class DateMatch {

    /* JADX INFO: renamed from: a */
    public Integer f3492a;

    /* JADX INFO: renamed from: b */
    public Integer f3493b;

    /* JADX INFO: renamed from: c */
    public Integer f3494c;

    /* JADX INFO: renamed from: d */
    public Integer f3495d;

    /* JADX INFO: renamed from: e */
    public Integer f3496e;

    /* JADX INFO: renamed from: f */
    public Integer f3497f;

    /* JADX INFO: renamed from: g */
    public Integer f3498g;

    /* JADX INFO: renamed from: h */
    public Integer f3499h;

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static Integer m2665a(String str) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final long m2664a(Date date) {
        Integer num;
        Integer num2;
        Calendar calendar = Calendar.getInstance();
        AbstractC1766e.m3919d("getInstance(...)", calendar);
        calendar.setTime(date);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        AbstractC1766e.m3919d("getInstance(...)", calendar2);
        calendar2.setTime(date);
        calendar2.set(14, 0);
        Integer num3 = this.f3492a;
        if (num3 != null) {
            calendar2.set(1, num3.intValue());
            Integer num4 = this.f3499h;
            if (num4 != null && num4.intValue() == -1) {
                this.f3499h = 1;
            }
        }
        Integer num5 = this.f3493b;
        int i3 = 2;
        if (num5 != null) {
            calendar2.set(2, num5.intValue());
            Integer num6 = this.f3499h;
            if (num6 != null && num6.intValue() == -1) {
                this.f3499h = 2;
            }
        }
        Integer num7 = this.f3494c;
        if (num7 != null) {
            calendar2.set(5, num7.intValue());
            Integer num8 = this.f3499h;
            if (num8 != null && num8.intValue() == -1) {
                this.f3499h = 5;
            }
        }
        Integer num9 = this.f3495d;
        if (num9 != null) {
            calendar2.set(7, num9.intValue());
            Integer num10 = this.f3499h;
            if (num10 != null && num10.intValue() == -1) {
                this.f3499h = 7;
            }
        }
        Integer num11 = this.f3496e;
        if (num11 != null) {
            calendar2.set(11, num11.intValue());
            Integer num12 = this.f3499h;
            if (num12 != null && num12.intValue() == -1) {
                this.f3499h = 11;
            }
        }
        Integer num13 = this.f3497f;
        if (num13 != null) {
            calendar2.set(12, num13.intValue());
            Integer num14 = this.f3499h;
            if (num14 != null && num14.intValue() == -1) {
                this.f3499h = 12;
            }
        }
        Integer num15 = this.f3498g;
        if (num15 != null) {
            calendar2.set(13, num15.intValue());
            Integer num16 = this.f3499h;
            if (num16 != null && num16.intValue() == -1) {
                this.f3499h = 13;
            }
        }
        if (calendar2.getTimeInMillis() <= calendar.getTimeInMillis() && ((num = this.f3499h) == null || num.intValue() != -1)) {
            Integer num17 = this.f3499h;
            if ((num17 != null && num17.intValue() == 1) || ((num2 = this.f3499h) != null && num2.intValue() == 2)) {
                i3 = 1;
            } else {
                Integer num18 = this.f3499h;
                if (num18 == null || num18.intValue() != 5) {
                    Integer num19 = this.f3499h;
                    if (num19 != null && num19.intValue() == 7) {
                        i3 = 4;
                    } else {
                        Integer num20 = this.f3499h;
                        if (num20 != null && num20.intValue() == 11) {
                            i3 = 5;
                        } else {
                            Integer num21 = this.f3499h;
                            if (num21 != null && num21.intValue() == 12) {
                                i3 = 11;
                            } else {
                                Integer num22 = this.f3499h;
                                i3 = (num22 != null && num22.intValue() == 13) ? 12 : -1;
                            }
                        }
                    }
                }
            }
            if (i3 != -1) {
                calendar2.set(i3, calendar2.get(i3) + 1);
            }
        }
        return calendar2.getTimeInMillis();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !DateMatch.class.equals(obj.getClass())) {
            return false;
        }
        DateMatch dateMatch = (DateMatch) obj;
        Integer num = this.f3492a;
        if (num == null ? dateMatch.f3492a != null : !AbstractC1766e.m3916a(num, dateMatch.f3492a)) {
            return false;
        }
        Integer num2 = this.f3493b;
        if (num2 == null ? dateMatch.f3493b != null : !AbstractC1766e.m3916a(num2, dateMatch.f3493b)) {
            return false;
        }
        Integer num3 = this.f3494c;
        if (num3 == null ? dateMatch.f3494c != null : !AbstractC1766e.m3916a(num3, dateMatch.f3494c)) {
            return false;
        }
        Integer num4 = this.f3495d;
        if (num4 == null ? dateMatch.f3495d != null : !AbstractC1766e.m3916a(num4, dateMatch.f3495d)) {
            return false;
        }
        Integer num5 = this.f3496e;
        if (num5 == null ? dateMatch.f3496e != null : !AbstractC1766e.m3916a(num5, dateMatch.f3496e)) {
            return false;
        }
        Integer num6 = this.f3497f;
        if (num6 == null ? dateMatch.f3497f != null : !AbstractC1766e.m3916a(num6, dateMatch.f3497f)) {
            return false;
        }
        Integer num7 = this.f3498g;
        Integer num8 = dateMatch.f3498g;
        return num7 != null ? AbstractC1766e.m3916a(num7, num8) : num8 == null;
    }

    public final int hashCode() {
        Integer num = this.f3492a;
        int iHashCode = 0;
        int iHashCode2 = ((num == null || num == null) ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f3493b;
        int iHashCode3 = (iHashCode2 + ((num2 == null || num2 == null) ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f3494c;
        int iHashCode4 = (iHashCode3 + ((num3 == null || num3 == null) ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f3495d;
        int iHashCode5 = (iHashCode4 + ((num4 == null || num4 == null) ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f3496e;
        int iHashCode6 = (iHashCode5 + ((num5 == null || num5 == null) ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f3497f;
        int iHashCode7 = iHashCode6 + ((num6 == null || num6 == null) ? 0 : num6.hashCode());
        Integer num7 = this.f3498g;
        if (num7 != null && num7 != null) {
            iHashCode = num7.hashCode();
        }
        return 31 + iHashCode + iHashCode7;
    }

    public final String toString() {
        return "DateMatch{year=" + this.f3492a + ", month=" + this.f3493b + ", day=" + this.f3494c + ", weekday=" + this.f3495d + ", hour=" + this.f3496e + ", minute=" + this.f3497f + ", second=" + this.f3498g + '}';
    }
}
