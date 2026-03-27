package p042N0;

/* JADX INFO: renamed from: N0.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0546n extends AbstractC0535c {
    private static final long serialVersionUID = 123;

    /* JADX INFO: renamed from: e */
    public C0541i f1307e;

    public AbstractC0546n(String str, C0541i c0541i, Throwable th) {
        super(str, th);
        this.f1307e = c0541i;
    }

    @Override // p042N0.AbstractC0535c
    /* JADX INFO: renamed from: a */
    public final String mo1082a() {
        return super.getMessage();
    }

    @Override // p042N0.AbstractC0535c
    /* JADX INFO: renamed from: b */
    public Object mo1083b() {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public String mo1212c() {
        return null;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        C0541i c0541i = this.f1307e;
        String strMo1212c = mo1212c();
        if (c0541i == null && strMo1212c == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (strMo1212c != null) {
            sb.append(strMo1212c);
        }
        if (c0541i != null) {
            sb.append("\n at ");
            sb.append(c0541i.toString());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
