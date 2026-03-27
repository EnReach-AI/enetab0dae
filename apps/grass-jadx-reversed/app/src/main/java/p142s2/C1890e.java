package p142s2;

import java.io.Serializable;
import java.util.regex.Pattern;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: s2.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1890e implements Serializable {

    /* JADX INFO: renamed from: e */
    public final Pattern f6644e;

    public C1890e(Pattern pattern) {
        this.f6644e = pattern;
    }

    private final Object writeReplace() {
        Pattern pattern = this.f6644e;
        String strPattern = pattern.pattern();
        AbstractC1766e.m3919d("pattern(...)", strPattern);
        return new C1889d(pattern.flags(), strPattern);
    }

    public final String toString() {
        String string = this.f6644e.toString();
        AbstractC1766e.m3919d("toString(...)", string);
        return string;
    }

    public C1890e() {
        Pattern patternCompile = Pattern.compile("[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
        AbstractC1766e.m3919d("compile(...)", patternCompile);
        this.f6644e = patternCompile;
    }
}
