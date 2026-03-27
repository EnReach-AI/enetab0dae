package com.fasterxml.jackson.databind.deser.std;

import java.util.Arrays;
import p109j1.AbstractC1498f;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1185a {

    /* JADX INFO: renamed from: a */
    public AbstractC1498f[] f4050a;

    /* JADX INFO: renamed from: b */
    public int f4051b;

    /* JADX INFO: renamed from: c */
    public int f4052c;

    /* JADX INFO: renamed from: a */
    public final void m3037a(AbstractC1498f abstractC1498f) {
        int i3 = this.f4051b;
        int i4 = this.f4052c;
        if (i3 < i4) {
            AbstractC1498f[] abstractC1498fArr = this.f4050a;
            this.f4051b = i3 + 1;
            abstractC1498fArr[i3] = abstractC1498f;
            return;
        }
        if (this.f4050a == null) {
            this.f4052c = 10;
            this.f4050a = new AbstractC1498f[10];
        } else {
            int iMin = Math.min(4000, Math.max(20, i4 >> 1)) + i4;
            this.f4052c = iMin;
            this.f4050a = (AbstractC1498f[]) Arrays.copyOf(this.f4050a, iMin);
        }
        AbstractC1498f[] abstractC1498fArr2 = this.f4050a;
        int i5 = this.f4051b;
        this.f4051b = i5 + 1;
        abstractC1498fArr2[i5] = abstractC1498f;
    }
}
