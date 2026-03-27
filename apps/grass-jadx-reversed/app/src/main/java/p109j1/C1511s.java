package p109j1;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import p066W0.C0674a;
import p066W0.C0676c;

/* JADX INFO: renamed from: j1.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1511s implements Serializable, Externalizable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public byte[] f5462e;

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        int i3;
        byte[] bArrM1639f;
        int i4 = objectInput.readInt();
        if (i4 <= 100000) {
            bArrM1639f = new byte[i4];
            objectInput.readFully(bArrM1639f, 0, i4);
        } else {
            C0676c c0676c = new C0676c((C0674a) null, 100000);
            c0676c.m1638e();
            byte[] bArr = c0676c.f1842h;
            loop0: while (true) {
                i3 = 0;
                do {
                    int iMin = Math.min(bArr.length - i3, i4);
                    objectInput.readFully(bArr, 0, iMin);
                    i4 -= iMin;
                    i3 += iMin;
                    if (i4 == 0) {
                        break loop0;
                    }
                } while (i3 != bArr.length);
                c0676c.m1634a();
                bArr = c0676c.f1842h;
            }
            c0676c.f1843i = i3;
            bArrM1639f = c0676c.m1639f();
        }
        this.f5462e = bArrM1639f;
    }

    public Object readResolve() {
        try {
            return AbstractC1504l.m3549a(this.f5462e);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Failed to JDK deserialize `JsonNode` value: " + e3.getMessage(), e3);
        }
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.f5462e.length);
        objectOutput.write(this.f5462e);
    }
}
