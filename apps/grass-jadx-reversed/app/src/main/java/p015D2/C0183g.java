package p015D2;

/* JADX INFO: renamed from: D2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0183g extends C0181e {

    /* JADX INFO: renamed from: d */
    public final boolean f425d;

    public C0183g(C0192p c0192p, boolean z3) {
        super(c0192p);
        this.f425d = z3;
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: e */
    public final void mo307e(byte b3) {
        if (this.f425d) {
            mo313k(String.valueOf(b3 & 255));
        } else {
            m311i(String.valueOf(b3 & 255));
        }
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: g */
    public final void mo309g(int i3) {
        boolean z3 = this.f425d;
        String unsignedString = Integer.toUnsignedString(i3);
        if (z3) {
            mo313k(unsignedString);
        } else {
            m311i(unsignedString);
        }
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: h */
    public final void mo310h(long j2) {
        boolean z3 = this.f425d;
        String unsignedString = Long.toUnsignedString(j2);
        if (z3) {
            mo313k(unsignedString);
        } else {
            m311i(unsignedString);
        }
    }

    @Override // p015D2.C0181e
    /* JADX INFO: renamed from: j */
    public final void mo312j(short s3) {
        if (this.f425d) {
            mo313k(String.valueOf(s3 & 65535));
        } else {
            m311i(String.valueOf(s3 & 65535));
        }
    }
}
