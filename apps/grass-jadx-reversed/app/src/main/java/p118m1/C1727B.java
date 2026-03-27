package p118m1;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: m1.B */
/* JADX INFO: loaded from: classes.dex */
public final class C1727B extends DateFormat {

    /* JADX INFO: renamed from: k */
    public static final Pattern f6026k = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* JADX INFO: renamed from: l */
    public static final Pattern f6027l;

    /* JADX INFO: renamed from: m */
    public static final String[] f6028m;

    /* JADX INFO: renamed from: n */
    public static final TimeZone f6029n;

    /* JADX INFO: renamed from: o */
    public static final Locale f6030o;

    /* JADX INFO: renamed from: p */
    public static final SimpleDateFormat f6031p;

    /* JADX INFO: renamed from: q */
    public static final C1727B f6032q;

    /* JADX INFO: renamed from: r */
    public static final GregorianCalendar f6033r;

    /* JADX INFO: renamed from: e */
    public transient TimeZone f6034e;

    /* JADX INFO: renamed from: f */
    public final Locale f6035f;

    /* JADX INFO: renamed from: g */
    public Boolean f6036g;

    /* JADX INFO: renamed from: h */
    public transient Calendar f6037h;

    /* JADX INFO: renamed from: i */
    public transient DateFormat f6038i;

    /* JADX INFO: renamed from: j */
    public final boolean f6039j;

    static {
        try {
            f6027l = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            f6028m = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f6029n = timeZone;
            Locale locale = Locale.US;
            f6030o = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f6031p = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            f6032q = new C1727B();
            f6033r = new GregorianCalendar(timeZone, locale);
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }

    public C1727B() {
        this.f6039j = true;
        this.f6035f = f6030o;
    }

    /* JADX INFO: renamed from: b */
    public static int m3837b(int i3, String str) {
        return (str.charAt(i3 + 1) - '0') + ((str.charAt(i3) - '0') * 10);
    }

    /* JADX INFO: renamed from: c */
    public static int m3838c(String str) {
        return (str.charAt(3) - '0') + ((str.charAt(2) - '0') * 10) + ((str.charAt(1) - '0') * 100) + ((str.charAt(0) - '0') * 1000);
    }

    /* JADX INFO: renamed from: f */
    public static void m3839f(StringBuffer stringBuffer, int i3) {
        int i4 = i3 / 10;
        if (i4 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i4 + 48));
            i3 -= i4 * 10;
        }
        stringBuffer.append((char) (i3 + 48));
    }

    /* JADX INFO: renamed from: g */
    public static void m3840g(StringBuffer stringBuffer, int i3) {
        int i4 = i3 / 100;
        if (i4 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i4 > 99) {
                stringBuffer.append(i4);
            } else {
                m3839f(stringBuffer, i4);
            }
            i3 -= i4 * 100;
        }
        m3839f(stringBuffer, i3);
    }

    /* JADX INFO: renamed from: a */
    public final Calendar m3841a(TimeZone timeZone) {
        Calendar calendar = this.f6037h;
        if (calendar == null) {
            calendar = (Calendar) f6033r.clone();
            this.f6037h = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat, java.text.Format
    public final Object clone() {
        return new C1727B(this.f6034e, this.f6035f, this.f6036g, this.f6039j);
    }

    /* JADX INFO: renamed from: d */
    public final Date m3842d(String str) throws ParseException {
        String str2;
        int length = str.length();
        Calendar calendarM3841a = m3841a((this.f6034e == null || 'Z' == str.charAt(length + (-1))) ? f6029n : this.f6034e);
        calendarM3841a.clear();
        int iCharAt = 0;
        if (length > 10) {
            Matcher matcher = f6027l.matcher(str);
            if (matcher.matches()) {
                int iStart = matcher.start(2);
                int iEnd = matcher.end(2);
                int i3 = iEnd - iStart;
                if (i3 > 1) {
                    int iM3837b = m3837b(iStart + 1, str) * 3600;
                    if (i3 >= 5) {
                        iM3837b += m3837b(iEnd - 2, str) * 60;
                    }
                    calendarM3841a.set(15, str.charAt(iStart) == '-' ? iM3837b * (-1000) : iM3837b * 1000);
                    calendarM3841a.set(16, 0);
                }
                calendarM3841a.set(m3838c(str), m3837b(5, str) - 1, m3837b(8, str), m3837b(11, str), m3837b(14, str), (length <= 16 || str.charAt(16) != ':') ? 0 : m3837b(17, str));
                int iStart2 = matcher.start(1);
                int i4 = iStart2 + 1;
                int iEnd2 = matcher.end(1);
                if (i4 >= iEnd2) {
                    calendarM3841a.set(14, 0);
                } else {
                    int i5 = iEnd2 - i4;
                    if (i5 != 0) {
                        if (i5 != 1) {
                            if (i5 != 2) {
                                if (i5 != 3 && i5 > 9) {
                                    throw new ParseException(AbstractC0032g.m156n("Cannot parse date \"", str, "\": invalid fractional seconds '", matcher.group(1).substring(1), "'; can use at most 9 digits"), i4);
                                }
                                iCharAt = str.charAt(iStart2 + 3) - '0';
                            }
                            iCharAt += (str.charAt(iStart2 + 2) - '0') * 10;
                        }
                        iCharAt += (str.charAt(i4) - '0') * 100;
                    }
                    calendarM3841a.set(14, iCharAt);
                }
                return calendarM3841a.getTime();
            }
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (f6026k.matcher(str).matches()) {
                calendarM3841a.set(m3838c(str), m3837b(5, str) - 1, m3837b(8, str), 0, 0, 0);
                calendarM3841a.set(14, 0);
                return calendarM3841a.getTime();
            }
            str2 = "yyyy-MM-dd";
        }
        throw new ParseException("Cannot parse date \"" + str + "\": while it seems to fit format '" + str2 + "', parsing fails (leniency? " + this.f6036g + ")", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        if (r2 < 0) goto L63;
     */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Date m3843e(java.lang.String r6, java.text.ParsePosition r7) throws java.text.ParseException {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p118m1.C1727B.m3843e(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    @Override // java.text.DateFormat
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // java.text.DateFormat
    public final StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f6034e;
        if (timeZone == null) {
            timeZone = f6029n;
        }
        Calendar calendarM3841a = m3841a(timeZone);
        calendarM3841a.setTime(date);
        int i3 = calendarM3841a.get(1);
        if (calendarM3841a.get(0) != 0) {
            if (i3 > 9999) {
                stringBuffer.append('+');
            }
            m3840g(stringBuffer, i3);
        } else if (i3 == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append('-');
            m3840g(stringBuffer, i3 - 1);
        }
        stringBuffer.append('-');
        m3839f(stringBuffer, calendarM3841a.get(2) + 1);
        stringBuffer.append('-');
        m3839f(stringBuffer, calendarM3841a.get(5));
        stringBuffer.append('T');
        m3839f(stringBuffer, calendarM3841a.get(11));
        stringBuffer.append(':');
        m3839f(stringBuffer, calendarM3841a.get(12));
        stringBuffer.append(':');
        m3839f(stringBuffer, calendarM3841a.get(13));
        stringBuffer.append('.');
        int i4 = calendarM3841a.get(14);
        int i5 = i4 / 100;
        if (i5 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i5 + 48));
            i4 -= i5 * 100;
        }
        m3839f(stringBuffer, i4);
        int offset = timeZone.getOffset(calendarM3841a.getTimeInMillis());
        boolean z3 = this.f6039j;
        if (offset != 0) {
            int i6 = offset / 60000;
            int iAbs = Math.abs(i6 / 60);
            int iAbs2 = Math.abs(i6 % 60);
            stringBuffer.append(offset < 0 ? '-' : '+');
            m3839f(stringBuffer, iAbs);
            if (z3) {
                stringBuffer.append(':');
            }
            m3839f(stringBuffer, iAbs2);
        } else if (z3) {
            stringBuffer.append("+00:00");
        } else {
            stringBuffer.append("+0000");
        }
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public final TimeZone getTimeZone() {
        return this.f6034e;
    }

    @Override // java.text.DateFormat
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // java.text.DateFormat
    public final boolean isLenient() {
        Boolean bool = this.f6036g;
        return bool == null || bool.booleanValue();
    }

    @Override // java.text.DateFormat
    public final Date parse(String str) throws ParseException {
        String strTrim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date dateM3843e = m3843e(strTrim, parsePosition);
        if (dateM3843e != null) {
            return dateM3843e;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : f6028m) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(AbstractC0032g.m156n("Cannot parse date \"", strTrim, "\": not compatible with any of standard forms (", sb.toString(), ")"), parsePosition.getErrorIndex());
    }

    @Override // java.text.DateFormat
    public final void setLenient(boolean z3) {
        Boolean boolValueOf = Boolean.valueOf(z3);
        Boolean bool = this.f6036g;
        if (boolValueOf == bool || boolValueOf.equals(bool)) {
            return;
        }
        this.f6036g = boolValueOf;
        this.f6038i = null;
    }

    @Override // java.text.DateFormat
    public final void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.f6034e)) {
            return;
        }
        this.f6038i = null;
        this.f6034e = timeZone;
    }

    public final String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", C1727B.class.getName(), this.f6034e, this.f6035f, this.f6036g);
    }

    public C1727B(TimeZone timeZone, Locale locale, Boolean bool, boolean z3) {
        this.f6034e = timeZone;
        this.f6035f = locale;
        this.f6036g = bool;
        this.f6039j = z3;
    }

    @Override // java.text.DateFormat
    public final Date parse(String str, ParsePosition parsePosition) {
        try {
            return m3843e(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
