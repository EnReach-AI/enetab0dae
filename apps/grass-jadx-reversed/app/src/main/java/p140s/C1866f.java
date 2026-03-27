package p140s;

/* JADX INFO: renamed from: s.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1866f {

    /* JADX INFO: renamed from: a */
    public int f6532a;

    /* JADX INFO: renamed from: d */
    public C1863c f6535d;

    /* JADX INFO: renamed from: e */
    public C1863c f6536e;

    /* JADX INFO: renamed from: f */
    public C1863c f6537f;

    /* JADX INFO: renamed from: g */
    public C1863c f6538g;

    /* JADX INFO: renamed from: h */
    public int f6539h;

    /* JADX INFO: renamed from: i */
    public int f6540i;

    /* JADX INFO: renamed from: j */
    public int f6541j;

    /* JADX INFO: renamed from: k */
    public int f6542k;

    /* JADX INFO: renamed from: q */
    public int f6548q;

    /* JADX INFO: renamed from: r */
    public final /* synthetic */ C1867g f6549r;

    /* JADX INFO: renamed from: b */
    public C1864d f6533b = null;

    /* JADX INFO: renamed from: c */
    public int f6534c = 0;

    /* JADX INFO: renamed from: l */
    public int f6543l = 0;

    /* JADX INFO: renamed from: m */
    public int f6544m = 0;

    /* JADX INFO: renamed from: n */
    public int f6545n = 0;

    /* JADX INFO: renamed from: o */
    public int f6546o = 0;

    /* JADX INFO: renamed from: p */
    public int f6547p = 0;

    public C1866f(C1867g c1867g, int i3, C1863c c1863c, C1863c c1863c2, C1863c c1863c3, C1863c c1863c4, int i4) {
        this.f6549r = c1867g;
        this.f6539h = 0;
        this.f6540i = 0;
        this.f6541j = 0;
        this.f6542k = 0;
        this.f6548q = 0;
        this.f6532a = i3;
        this.f6535d = c1863c;
        this.f6536e = c1863c2;
        this.f6537f = c1863c3;
        this.f6538g = c1863c4;
        this.f6539h = c1867g.f6569j0;
        this.f6540i = c1867g.f6565f0;
        this.f6541j = c1867g.f6570k0;
        this.f6542k = c1867g.f6566g0;
        this.f6548q = i4;
    }

    /* JADX INFO: renamed from: a */
    public final void m4175a(C1864d c1864d) {
        int i3 = this.f6532a;
        C1867g c1867g = this.f6549r;
        if (i3 == 0) {
            int iM4183D = c1867g.m4183D(c1864d, this.f6548q);
            if (c1864d.f6493c0[0] == 3) {
                this.f6547p++;
                iM4183D = 0;
            }
            this.f6543l = iM4183D + (c1864d.f6483V != 8 ? c1867g.f6552C0 : 0) + this.f6543l;
            int iM4182C = c1867g.m4182C(c1864d, this.f6548q);
            if (this.f6533b == null || this.f6534c < iM4182C) {
                this.f6533b = c1864d;
                this.f6534c = iM4182C;
                this.f6544m = iM4182C;
            }
        } else {
            int iM4183D2 = c1867g.m4183D(c1864d, this.f6548q);
            int iM4182C2 = c1867g.m4182C(c1864d, this.f6548q);
            if (c1864d.f6493c0[1] == 3) {
                this.f6547p++;
                iM4182C2 = 0;
            }
            this.f6544m = iM4182C2 + (c1864d.f6483V != 8 ? c1867g.f6553D0 : 0) + this.f6544m;
            if (this.f6533b == null || this.f6534c < iM4183D2) {
                this.f6533b = c1864d;
                this.f6534c = iM4183D2;
                this.f6543l = iM4183D2;
            }
        }
        this.f6546o++;
    }

    /* JADX INFO: renamed from: b */
    public final void m4176b(int i3, boolean z3, boolean z4) {
        C1867g c1867g;
        int i4;
        C1864d c1864d;
        char c3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.f6546o;
        int i10 = 0;
        while (true) {
            c1867g = this.f6549r;
            if (i10 >= i9 || (i8 = this.f6545n + i10) >= c1867g.f6564O0) {
                break;
            }
            C1864d c1864d2 = c1867g.f6563N0[i8];
            if (c1864d2 != null) {
                c1864d2.m4164t();
            }
            i10++;
        }
        if (i9 == 0 || this.f6533b == null) {
            return;
        }
        boolean z5 = z4 && i3 == 0;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < i9; i13++) {
            int i14 = this.f6545n + (z3 ? (i9 - 1) - i13 : i13);
            if (i14 >= c1867g.f6564O0) {
                break;
            }
            if (c1867g.f6563N0[i14].f6483V == 0) {
                if (i11 == -1) {
                    i11 = i13;
                }
                i12 = i13;
            }
        }
        if (this.f6532a != 0) {
            C1864d c1864d3 = this.f6533b;
            c1864d3.f6485X = c1867g.f6576q0;
            int i15 = this.f6539h;
            if (i3 > 0) {
                i15 += c1867g.f6552C0;
            }
            C1863c c1863c = c1864d3.f6514x;
            C1863c c1863c2 = c1864d3.f6516z;
            if (z3) {
                c1863c2.m4137a(this.f6537f, i15);
                if (z4) {
                    c1863c.m4137a(this.f6535d, this.f6541j);
                }
                if (i3 > 0) {
                    this.f6537f.f6456b.f6514x.m4137a(c1863c2, 0);
                }
            } else {
                c1863c.m4137a(this.f6535d, i15);
                if (z4) {
                    c1863c2.m4137a(this.f6537f, this.f6541j);
                }
                if (i3 > 0) {
                    this.f6535d.f6456b.f6516z.m4137a(c1863c, 0);
                }
            }
            int i16 = 0;
            C1864d c1864d4 = null;
            while (i16 < i9) {
                int i17 = this.f6545n + i16;
                if (i17 >= c1867g.f6564O0) {
                    return;
                }
                C1864d c1864d5 = c1867g.f6563N0[i17];
                if (i16 == 0) {
                    c1864d5.m4149e(c1864d5.f6515y, this.f6536e, this.f6540i);
                    int i18 = c1867g.f6577r0;
                    float f3 = c1867g.f6583x0;
                    if (this.f6545n == 0) {
                        int i19 = c1867g.f6579t0;
                        i4 = -1;
                        if (i19 != -1) {
                            f3 = c1867g.f6585z0;
                        }
                        i18 = i19;
                        c1864d5.f6486Y = i18;
                        c1864d5.f6481T = f3;
                    } else {
                        i4 = -1;
                    }
                    if (z4 && (i19 = c1867g.f6581v0) != i4) {
                        f3 = c1867g.f6551B0;
                        i18 = i19;
                    }
                    c1864d5.f6486Y = i18;
                    c1864d5.f6481T = f3;
                }
                if (i16 == i9 - 1) {
                    c1864d5.m4149e(c1864d5.f6462A, this.f6538g, this.f6542k);
                }
                if (c1864d4 != null) {
                    C1863c c1863c3 = c1864d5.f6515y;
                    int i20 = c1867g.f6553D0;
                    C1863c c1863c4 = c1864d4.f6462A;
                    c1863c3.m4137a(c1863c4, i20);
                    C1863c c1863c5 = c1864d5.f6515y;
                    if (i16 == i11) {
                        int i21 = this.f6540i;
                        if (c1863c5.m4142f()) {
                            c1863c5.f6460f = i21;
                        }
                    }
                    c1863c4.m4137a(c1863c5, 0);
                    if (i16 == i12 + 1) {
                        int i22 = this.f6542k;
                        if (c1863c4.m4142f()) {
                            c1863c4.f6460f = i22;
                        }
                    }
                }
                if (c1864d5 != c1864d3) {
                    if (z3) {
                        int i23 = c1867g.f6554E0;
                        if (i23 == 0) {
                            c1864d5.f6516z.m4137a(c1863c2, 0);
                        } else if (i23 == 1) {
                            c1864d5.f6514x.m4137a(c1863c, 0);
                        } else if (i23 == 2) {
                            c1864d5.f6514x.m4137a(c1863c, 0);
                            c1864d5.f6516z.m4137a(c1863c2, 0);
                        }
                    } else {
                        int i24 = c1867g.f6554E0;
                        if (i24 == 0) {
                            c1864d5.f6514x.m4137a(c1863c, 0);
                        } else if (i24 == 1) {
                            c1864d5.f6516z.m4137a(c1863c2, 0);
                        } else if (i24 == 2) {
                            if (z5) {
                                c1864d5.f6514x.m4137a(this.f6535d, this.f6539h);
                                c1864d5.f6516z.m4137a(this.f6537f, this.f6541j);
                            } else {
                                c1864d5.f6514x.m4137a(c1863c, 0);
                                c1864d5.f6516z.m4137a(c1863c2, 0);
                            }
                        }
                    }
                }
                i16++;
                c1864d4 = c1864d5;
            }
            return;
        }
        C1864d c1864d6 = this.f6533b;
        c1864d6.f6486Y = c1867g.f6577r0;
        int i25 = this.f6540i;
        if (i3 > 0) {
            i25 += c1867g.f6553D0;
        }
        C1863c c1863c6 = this.f6536e;
        C1863c c1863c7 = c1864d6.f6515y;
        c1863c7.m4137a(c1863c6, i25);
        C1863c c1863c8 = c1864d6.f6462A;
        if (z4) {
            c1863c8.m4137a(this.f6538g, this.f6542k);
        }
        if (i3 > 0) {
            this.f6536e.f6456b.f6462A.m4137a(c1863c7, 0);
        }
        if (c1867g.f6555F0 != 3 || c1864d6.f6513w) {
            c1864d = c1864d6;
        } else {
            for (int i26 = 0; i26 < i9; i26++) {
                int i27 = this.f6545n + (z3 ? (i9 - 1) - i26 : i26);
                if (i27 >= c1867g.f6564O0) {
                    break;
                }
                c1864d = c1867g.f6563N0[i27];
                if (c1864d.f6513w) {
                    break;
                }
            }
            c1864d = c1864d6;
        }
        int i28 = 0;
        C1864d c1864d7 = null;
        while (i28 < i9) {
            int i29 = z3 ? (i9 - 1) - i28 : i28;
            int i30 = this.f6545n + i29;
            if (i30 >= c1867g.f6564O0) {
                return;
            }
            C1864d c1864d8 = c1867g.f6563N0[i30];
            if (i28 == 0) {
                c1864d8.m4149e(c1864d8.f6514x, this.f6535d, this.f6539h);
            }
            if (i29 == 0) {
                int i31 = c1867g.f6576q0;
                float f4 = c1867g.f6582w0;
                if (this.f6545n == 0) {
                    int i32 = c1867g.f6578s0;
                    i5 = i31;
                    i6 = -1;
                    if (i32 != -1) {
                        f4 = c1867g.f6584y0;
                    }
                    i7 = i32;
                    c1864d8.f6485X = i7;
                    c1864d8.f6480S = f4;
                } else {
                    i5 = i31;
                    i6 = -1;
                }
                if (!z4 || (i32 = c1867g.f6580u0) == i6) {
                    i7 = i5;
                    c1864d8.f6485X = i7;
                    c1864d8.f6480S = f4;
                } else {
                    f4 = c1867g.f6550A0;
                    i7 = i32;
                    c1864d8.f6485X = i7;
                    c1864d8.f6480S = f4;
                }
            }
            if (i28 == i9 - 1) {
                c1864d8.m4149e(c1864d8.f6516z, this.f6537f, this.f6541j);
            }
            if (c1864d7 != null) {
                C1863c c1863c9 = c1864d8.f6514x;
                int i33 = c1867g.f6552C0;
                C1863c c1863c10 = c1864d7.f6516z;
                c1863c9.m4137a(c1863c10, i33);
                C1863c c1863c11 = c1864d8.f6514x;
                if (i28 == i11) {
                    int i34 = this.f6539h;
                    if (c1863c11.m4142f()) {
                        c1863c11.f6460f = i34;
                    }
                }
                c1863c10.m4137a(c1863c11, 0);
                if (i28 == i12 + 1) {
                    int i35 = this.f6541j;
                    if (c1863c10.m4142f()) {
                        c1863c10.f6460f = i35;
                    }
                }
            }
            if (c1864d8 != c1864d6) {
                int i36 = c1867g.f6555F0;
                c3 = 3;
                if (i36 == 3 && c1864d.f6513w && c1864d8 != c1864d && c1864d8.f6513w) {
                    c1864d8.f6463B.m4137a(c1864d.f6463B, 0);
                } else if (i36 == 0) {
                    c1864d8.f6515y.m4137a(c1863c7, 0);
                } else if (i36 == 1) {
                    c1864d8.f6462A.m4137a(c1863c8, 0);
                } else if (z5) {
                    c1864d8.f6515y.m4137a(this.f6536e, this.f6540i);
                    c1864d8.f6462A.m4137a(this.f6538g, this.f6542k);
                } else {
                    c1864d8.f6515y.m4137a(c1863c7, 0);
                    c1864d8.f6462A.m4137a(c1863c8, 0);
                }
            } else {
                c3 = 3;
            }
            i28++;
            c1864d7 = c1864d8;
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m4177c() {
        return this.f6532a == 1 ? this.f6544m - this.f6549r.f6553D0 : this.f6544m;
    }

    /* JADX INFO: renamed from: d */
    public final int m4178d() {
        return this.f6532a == 0 ? this.f6543l - this.f6549r.f6552C0 : this.f6543l;
    }

    /* JADX INFO: renamed from: e */
    public final void m4179e(int i3) {
        C1867g c1867g;
        int i4;
        int i5 = this.f6547p;
        if (i5 == 0) {
            return;
        }
        int i6 = this.f6546o;
        int i7 = i3 / i5;
        int i8 = 0;
        while (true) {
            c1867g = this.f6549r;
            if (i8 >= i6 || (i4 = this.f6545n + i8) >= c1867g.f6564O0) {
                break;
            }
            C1864d c1864d = c1867g.f6563N0[i4];
            if (this.f6532a == 0) {
                if (c1864d != null) {
                    int[] iArr = c1864d.f6493c0;
                    if (iArr[0] == 3 && c1864d.f6500j == 0) {
                        c1867g.m4184E(1, i7, iArr[1], c1864d.m4153i(), c1864d);
                    }
                }
            } else if (c1864d != null) {
                int[] iArr2 = c1864d.f6493c0;
                if (iArr2[1] == 3 && c1864d.f6501k == 0) {
                    c1867g.m4184E(iArr2[0], c1864d.m4156l(), 1, i7, c1864d);
                }
            }
            i8++;
        }
        this.f6543l = 0;
        this.f6544m = 0;
        this.f6533b = null;
        this.f6534c = 0;
        int i9 = this.f6546o;
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = this.f6545n + i10;
            if (i11 >= c1867g.f6564O0) {
                return;
            }
            C1864d c1864d2 = c1867g.f6563N0[i11];
            if (this.f6532a == 0) {
                int iM4156l = c1864d2.m4156l();
                int i12 = c1867g.f6552C0;
                if (c1864d2.f6483V == 8) {
                    i12 = 0;
                }
                this.f6543l = iM4156l + i12 + this.f6543l;
                int iM4182C = c1867g.m4182C(c1864d2, this.f6548q);
                if (this.f6533b == null || this.f6534c < iM4182C) {
                    this.f6533b = c1864d2;
                    this.f6534c = iM4182C;
                    this.f6544m = iM4182C;
                }
            } else {
                int iM4183D = c1867g.m4183D(c1864d2, this.f6548q);
                int iM4182C2 = c1867g.m4182C(c1864d2, this.f6548q);
                int i13 = c1867g.f6553D0;
                if (c1864d2.f6483V == 8) {
                    i13 = 0;
                }
                this.f6544m = iM4182C2 + i13 + this.f6544m;
                if (this.f6533b == null || this.f6534c < iM4183D) {
                    this.f6533b = c1864d2;
                    this.f6534c = iM4183D;
                    this.f6543l = iM4183D;
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m4180f(int i3, C1863c c1863c, C1863c c1863c2, C1863c c1863c3, C1863c c1863c4, int i4, int i5, int i6, int i7, int i8) {
        this.f6532a = i3;
        this.f6535d = c1863c;
        this.f6536e = c1863c2;
        this.f6537f = c1863c3;
        this.f6538g = c1863c4;
        this.f6539h = i4;
        this.f6540i = i5;
        this.f6541j = i6;
        this.f6542k = i7;
        this.f6548q = i8;
    }
}
