package p053R0;

import java.math.BigInteger;

/* JADX INFO: renamed from: R0.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0615k {

    /* JADX INFO: renamed from: a */
    public static final C0613i f1584a = new C0613i();

    /* JADX INFO: renamed from: a */
    public static BigInteger m1437a(CharSequence charSequence) {
        int length = charSequence.length();
        f1584a.getClass();
        if (length >= 0) {
            try {
                if (length <= charSequence.length() && length <= 1292782622) {
                    int i3 = 0;
                    char cCharAt = charSequence.charAt(0);
                    boolean z3 = cCharAt == '-';
                    if (z3 || cCharAt == '+') {
                        if (AbstractC0606b.m1387a(charSequence, 1, length) == 0) {
                            throw new NumberFormatException("illegal syntax");
                        }
                        i3 = 1;
                    }
                    return C0613i.m1434d(charSequence, i3, length, z3);
                }
            } catch (ArithmeticException e3) {
                NumberFormatException numberFormatException = new NumberFormatException("value exceeds limits");
                numberFormatException.initCause(e3);
                throw numberFormatException;
            }
        }
        throw new IllegalArgumentException("offset < 0 or length > str.length");
    }
}
