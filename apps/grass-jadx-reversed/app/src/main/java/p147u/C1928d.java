package p147u;

import android.view.ViewGroup;
import p140s.C1864d;
import p140s.C1868h;

/* JADX INFO: renamed from: u.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1928d extends ViewGroup.MarginLayoutParams {

    /* JADX INFO: renamed from: A */
    public float f6754A;

    /* JADX INFO: renamed from: B */
    public String f6755B;

    /* JADX INFO: renamed from: C */
    public int f6756C;

    /* JADX INFO: renamed from: D */
    public float f6757D;

    /* JADX INFO: renamed from: E */
    public float f6758E;

    /* JADX INFO: renamed from: F */
    public int f6759F;

    /* JADX INFO: renamed from: G */
    public int f6760G;

    /* JADX INFO: renamed from: H */
    public int f6761H;

    /* JADX INFO: renamed from: I */
    public int f6762I;

    /* JADX INFO: renamed from: J */
    public int f6763J;

    /* JADX INFO: renamed from: K */
    public int f6764K;

    /* JADX INFO: renamed from: L */
    public int f6765L;

    /* JADX INFO: renamed from: M */
    public int f6766M;

    /* JADX INFO: renamed from: N */
    public float f6767N;

    /* JADX INFO: renamed from: O */
    public float f6768O;

    /* JADX INFO: renamed from: P */
    public int f6769P;

    /* JADX INFO: renamed from: Q */
    public int f6770Q;

    /* JADX INFO: renamed from: R */
    public int f6771R;

    /* JADX INFO: renamed from: S */
    public boolean f6772S;

    /* JADX INFO: renamed from: T */
    public boolean f6773T;

    /* JADX INFO: renamed from: U */
    public String f6774U;

    /* JADX INFO: renamed from: V */
    public boolean f6775V;

    /* JADX INFO: renamed from: W */
    public boolean f6776W;

    /* JADX INFO: renamed from: X */
    public boolean f6777X;

    /* JADX INFO: renamed from: Y */
    public boolean f6778Y;

    /* JADX INFO: renamed from: Z */
    public boolean f6779Z;

    /* JADX INFO: renamed from: a */
    public int f6780a;

    /* JADX INFO: renamed from: a0 */
    public int f6781a0;

    /* JADX INFO: renamed from: b */
    public int f6782b;

    /* JADX INFO: renamed from: b0 */
    public int f6783b0;

    /* JADX INFO: renamed from: c */
    public float f6784c;

    /* JADX INFO: renamed from: c0 */
    public int f6785c0;

    /* JADX INFO: renamed from: d */
    public int f6786d;

    /* JADX INFO: renamed from: d0 */
    public int f6787d0;

    /* JADX INFO: renamed from: e */
    public int f6788e;

    /* JADX INFO: renamed from: e0 */
    public int f6789e0;

    /* JADX INFO: renamed from: f */
    public int f6790f;

    /* JADX INFO: renamed from: f0 */
    public int f6791f0;

    /* JADX INFO: renamed from: g */
    public int f6792g;

    /* JADX INFO: renamed from: g0 */
    public float f6793g0;

    /* JADX INFO: renamed from: h */
    public int f6794h;

    /* JADX INFO: renamed from: h0 */
    public int f6795h0;

    /* JADX INFO: renamed from: i */
    public int f6796i;

    /* JADX INFO: renamed from: i0 */
    public int f6797i0;

    /* JADX INFO: renamed from: j */
    public int f6798j;

    /* JADX INFO: renamed from: j0 */
    public float f6799j0;

    /* JADX INFO: renamed from: k */
    public int f6800k;

    /* JADX INFO: renamed from: k0 */
    public C1864d f6801k0;

    /* JADX INFO: renamed from: l */
    public int f6802l;

    /* JADX INFO: renamed from: m */
    public int f6803m;

    /* JADX INFO: renamed from: n */
    public int f6804n;

    /* JADX INFO: renamed from: o */
    public float f6805o;

    /* JADX INFO: renamed from: p */
    public int f6806p;

    /* JADX INFO: renamed from: q */
    public int f6807q;

    /* JADX INFO: renamed from: r */
    public int f6808r;

    /* JADX INFO: renamed from: s */
    public int f6809s;

    /* JADX INFO: renamed from: t */
    public int f6810t;

    /* JADX INFO: renamed from: u */
    public int f6811u;

    /* JADX INFO: renamed from: v */
    public int f6812v;

    /* JADX INFO: renamed from: w */
    public int f6813w;

    /* JADX INFO: renamed from: x */
    public int f6814x;

    /* JADX INFO: renamed from: y */
    public int f6815y;

    /* JADX INFO: renamed from: z */
    public float f6816z;

    /* JADX INFO: renamed from: a */
    public final void m4325a() {
        this.f6778Y = false;
        this.f6775V = true;
        this.f6776W = true;
        int i3 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i3 == -2 && this.f6772S) {
            this.f6775V = false;
            if (this.f6761H == 0) {
                this.f6761H = 1;
            }
        }
        int i4 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i4 == -2 && this.f6773T) {
            this.f6776W = false;
            if (this.f6762I == 0) {
                this.f6762I = 1;
            }
        }
        if (i3 == 0 || i3 == -1) {
            this.f6775V = false;
            if (i3 == 0 && this.f6761H == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.f6772S = true;
            }
        }
        if (i4 == 0 || i4 == -1) {
            this.f6776W = false;
            if (i4 == 0 && this.f6762I == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.f6773T = true;
            }
        }
        if (this.f6784c == -1.0f && this.f6780a == -1 && this.f6782b == -1) {
            return;
        }
        this.f6778Y = true;
        this.f6775V = true;
        this.f6776W = true;
        if (!(this.f6801k0 instanceof C1868h)) {
            this.f6801k0 = new C1868h();
        }
        ((C1868h) this.f6801k0).m4185B(this.f6771R);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resolveLayoutDirection(int r10) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p147u.C1928d.resolveLayoutDirection(int):void");
    }
}
