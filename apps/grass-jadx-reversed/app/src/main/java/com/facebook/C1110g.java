package com.facebook;

import p129p0.AbstractC1822d;
import p166z0.InterfaceC2075m;

/* JADX INFO: renamed from: com.facebook.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1110g implements InterfaceC2075m {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f3861e;

    /* JADX INFO: renamed from: f */
    public final String f3862f;

    public /* synthetic */ C1110g(int i3, String str) {
        this.f3861e = i3;
        this.f3862f = str;
    }

    @Override // p166z0.InterfaceC2075m
    /* JADX INFO: renamed from: d */
    public void mo430d(boolean z3) {
        if (z3) {
            try {
                AbstractC1822d.m4053g(this.f3862f);
            } catch (Exception unused) {
            }
        }
    }

    public String toString() {
        switch (this.f3861e) {
            case 1:
                return "<" + this.f3862f + '>';
            default:
                return super.toString();
        }
    }
}
