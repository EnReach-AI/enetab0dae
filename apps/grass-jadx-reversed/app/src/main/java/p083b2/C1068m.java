package p083b2;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p086c2.C1096o;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1068m implements Iterator {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3750e;

    /* JADX INFO: renamed from: f */
    public int f3751f;

    /* JADX INFO: renamed from: g */
    public final Object f3752g;

    public /* synthetic */ C1068m(int i3, Object obj) {
        this.f3750e = i3;
        this.f3752g = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3750e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return this.f3751f < ((byte[]) this.f3752g).length;
            case 1:
                return this.f3751f < ((int[]) this.f3752g).length;
            case 2:
                return this.f3751f < ((long[]) this.f3752g).length;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return this.f3751f < ((short[]) this.f3752g).length;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return ((Iterator) this.f3752g).hasNext();
            default:
                return this.f3751f < ((Object[]) this.f3752g).length;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3750e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i3 = this.f3751f;
                byte[] bArr = (byte[]) this.f3752g;
                if (i3 >= bArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f3751f));
                }
                this.f3751f = i3 + 1;
                return new C1067l(bArr[i3]);
            case 1:
                int i4 = this.f3751f;
                int[] iArr = (int[]) this.f3752g;
                if (i4 >= iArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f3751f));
                }
                this.f3751f = i4 + 1;
                return new C1070o(iArr[i4]);
            case 2:
                int i5 = this.f3751f;
                long[] jArr = (long[]) this.f3752g;
                if (i5 >= jArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f3751f));
                }
                this.f3751f = i5 + 1;
                return new C1072q(jArr[i5]);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                int i6 = this.f3751f;
                short[] sArr = (short[]) this.f3752g;
                if (i6 >= sArr.length) {
                    throw new NoSuchElementException(String.valueOf(this.f3751f));
                }
                this.f3751f = i6 + 1;
                return new C1075t(sArr[i6]);
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                int i7 = this.f3751f;
                this.f3751f = i7 + 1;
                if (i7 >= 0) {
                    return new C1096o(i7, ((Iterator) this.f3752g).next());
                }
                throw new ArithmeticException("Index overflow has happened.");
            default:
                try {
                    Object[] objArr = (Object[]) this.f3752g;
                    int i8 = this.f3751f;
                    this.f3751f = i8 + 1;
                    return objArr[i8];
                } catch (ArrayIndexOutOfBoundsException e3) {
                    this.f3751f--;
                    throw new NoSuchElementException(e3.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3750e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C1068m(Object[] objArr) {
        this.f3750e = 5;
        AbstractC1766e.m3920e("array", objArr);
        this.f3752g = objArr;
    }

    public C1068m(Iterator it) {
        this.f3750e = 4;
        AbstractC1766e.m3920e("iterator", it);
        this.f3752g = it;
    }
}
