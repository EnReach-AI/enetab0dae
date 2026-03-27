package com.fasterxml.jackson.core.exc;

import p042N0.AbstractC0545m;
import p042N0.AbstractC0546n;

/* JADX INFO: renamed from: com.fasterxml.jackson.core.exc.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1132c extends AbstractC0546n {
    static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: f */
    public transient AbstractC0545m f3925f;

    public AbstractC1132c(AbstractC0545m abstractC0545m, String str) {
        super(str, abstractC0545m == null ? null : abstractC0545m.mo1197l(), null);
        this.f3925f = abstractC0545m;
    }

    @Override // p042N0.AbstractC0546n, p042N0.AbstractC0535c
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AbstractC0545m mo1083b() {
        return this.f3925f;
    }
}
