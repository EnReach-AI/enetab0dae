package p078a1;

import java.util.Collection;
import java.util.Iterator;
import p042N0.AbstractC0545m;
import p042N0.C0541i;

/* JADX INFO: renamed from: a1.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0854f extends C0850b {

    /* JADX INFO: renamed from: i */
    public final Collection f2523i;

    /* JADX INFO: renamed from: j */
    public transient String f2524j;

    public AbstractC0854f(AbstractC0545m abstractC0545m, String str, C0541i c0541i, Collection collection) {
        super(abstractC0545m, str, c0541i);
        this.f2523i = collection;
    }

    @Override // p042N0.AbstractC0546n
    /* JADX INFO: renamed from: c */
    public final String mo1212c() {
        Collection collection;
        String str = this.f2524j;
        if (str != null || (collection = this.f2523i) == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(100);
        int size = collection.size();
        if (size != 1) {
            sb.append(" (");
            sb.append(size);
            sb.append(" known properties: ");
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                sb.append('\"');
                sb.append(String.valueOf(it.next()));
                sb.append('\"');
                if (sb.length() > 1000) {
                    sb.append(" [truncated]");
                    break;
                }
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append(" (one known property: \"");
            sb.append(String.valueOf(collection.iterator().next()));
            sb.append('\"');
        }
        sb.append("])");
        String string = sb.toString();
        this.f2524j = string;
        return string;
    }
}
