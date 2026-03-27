package p073Z;

/* JADX INFO: renamed from: Z.U */
/* JADX INFO: loaded from: classes.dex */
public final class C0774U {

    /* JADX INFO: renamed from: a */
    public int f2180a;

    /* JADX INFO: renamed from: b */
    public int f2181b;

    /* JADX INFO: renamed from: c */
    public int f2182c;

    /* JADX INFO: renamed from: d */
    public int f2183d;

    /* JADX INFO: renamed from: e */
    public int f2184e;

    /* JADX INFO: renamed from: f */
    public boolean f2185f;

    /* JADX INFO: renamed from: g */
    public boolean f2186g;

    /* JADX INFO: renamed from: h */
    public boolean f2187h;

    /* JADX INFO: renamed from: i */
    public boolean f2188i;

    /* JADX INFO: renamed from: j */
    public boolean f2189j;

    /* JADX INFO: renamed from: k */
    public boolean f2190k;

    /* JADX INFO: renamed from: l */
    public int f2191l;

    /* JADX INFO: renamed from: m */
    public long f2192m;

    /* JADX INFO: renamed from: n */
    public int f2193n;

    /* JADX INFO: renamed from: a */
    public final void m2046a(int i3) {
        if ((this.f2183d & i3) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i3) + " but it is " + Integer.toBinaryString(this.f2183d));
    }

    /* JADX INFO: renamed from: b */
    public final int m2047b() {
        return this.f2186g ? this.f2181b - this.f2182c : this.f2184e;
    }

    public final String toString() {
        return "State{mTargetPosition=" + this.f2180a + ", mData=null, mItemCount=" + this.f2184e + ", mIsMeasuring=" + this.f2188i + ", mPreviousLayoutItemCount=" + this.f2181b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2182c + ", mStructureChanged=" + this.f2185f + ", mInPreLayout=" + this.f2186g + ", mRunSimpleAnimations=" + this.f2189j + ", mRunPredictiveAnimations=" + this.f2190k + '}';
    }
}
