package p053R0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p029J.C0364q0;
import p029J.InterfaceC0367s;
import p147u.AbstractC1940p;
import p147u.C1936l;

/* JADX INFO: renamed from: R0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0607c implements InterfaceC0367s {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f1565e;

    /* JADX INFO: renamed from: f */
    public int f1566f;

    /* JADX INFO: renamed from: g */
    public int f1567g;

    /* JADX INFO: renamed from: h */
    public Object f1568h;

    /* JADX INFO: renamed from: a */
    public void m1389a(C0607c c0607c) {
        int i3 = c0607c.f1567g;
        int i4 = this.f1567g;
        for (int i5 = 0; i5 < this.f1566f; i5++) {
            double[] dArr = (double[]) this.f1568h;
            double d = dArr[i4];
            int i6 = i4 + 1;
            double d3 = dArr[i6];
            double[] dArr2 = (double[]) c0607c.f1568h;
            int i7 = i3 + 1;
            dArr[i4] = (dArr2[i3] * d) + (dArr2[i7] * d3);
            dArr[i6] = ((-d) * dArr2[i7]) + (d3 * dArr2[i3]);
            i4 += 2;
            i3 += 2;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1390b(C0607c c0607c) {
        int i3 = c0607c.f1567g;
        int i4 = this.f1566f;
        int i5 = this.f1567g;
        int i6 = (i4 + i5) << 1;
        while (i5 < i6) {
            double[] dArr = (double[]) this.f1568h;
            double d = dArr[i5];
            double[] dArr2 = (double[]) c0607c.f1568h;
            dArr[i5] = dArr2[i3] * d;
            dArr[i5 + 1] = d * dArr2[i3 + 1];
            i3 += 2;
            i5 += 2;
        }
    }

    /* JADX INFO: renamed from: c */
    public byte m1391c(int i3, int i4) {
        return ((byte[][]) this.f1568h)[i4][i3];
    }

    /* JADX INFO: renamed from: d */
    public double m1392d(int i3) {
        return ((double[]) this.f1568h)[(i3 << 1) + this.f1567g + 1];
    }

    /* JADX INFO: renamed from: e */
    public void m1393e(int i3, double d) {
        ((double[]) this.f1568h)[(i3 << 1) + this.f1567g + 1] = d;
    }

    /* JADX INFO: renamed from: f */
    public int m1394f(int i3) {
        return (i3 << 1) + this.f1567g + 1;
    }

    /* JADX INFO: renamed from: g */
    public void m1395g(int i3, C0611g c0611g) {
        int iM1403p = m1403p(i3);
        int iM1394f = m1394f(i3);
        double[] dArr = (double[]) this.f1568h;
        double d = dArr[iM1403p];
        double d3 = dArr[iM1394f];
        double d4 = c0611g.f1577a;
        double d5 = c0611g.f1578b;
        dArr[iM1403p] = (d * d4) + ((-d3) * d5);
        dArr[iM1394f] = (d * d5) + (d3 * d4);
    }

    @Override // p029J.InterfaceC0367s
    /* JADX INFO: renamed from: h */
    public C0364q0 mo48h(View view, C0364q0 c0364q0) {
        int i3 = c0364q0.f874a.mo751f(7).f82b;
        int i4 = this.f1566f;
        View view2 = (View) this.f1568h;
        if (i4 >= 0) {
            view2.getLayoutParams().height = i4 + i3;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.f1567g + i3, view2.getPaddingRight(), view2.getPaddingBottom());
        return c0364q0;
    }

    /* JADX INFO: renamed from: i */
    public void m1396i(int i3, C0611g c0611g) {
        int iM1403p = m1403p(i3);
        int iM1394f = m1394f(i3);
        double[] dArr = (double[]) this.f1568h;
        double d = dArr[iM1403p];
        double d3 = dArr[iM1394f];
        double d4 = c0611g.f1578b;
        double d5 = -d3;
        double d6 = c0611g.f1577a;
        dArr[iM1403p] = ((-d) * d4) + (d5 * d6);
        dArr[iM1394f] = (d * d6) + (d5 * d4);
    }

    /* JADX INFO: renamed from: j */
    public void m1397j(int i3, C0611g c0611g) {
        int iM1403p = m1403p(i3);
        int iM1394f = m1394f(i3);
        double[] dArr = (double[]) this.f1568h;
        double d = dArr[iM1403p];
        double d3 = dArr[iM1394f];
        double d4 = c0611g.f1577a;
        double d5 = c0611g.f1578b;
        dArr[iM1403p] = (d * d4) + (d3 * d5);
        dArr[iM1394f] = ((-d) * d5) + (d3 * d4);
    }

    /* JADX INFO: renamed from: k */
    public void m1398k(int i3, C0611g c0611g) {
        int iM1403p = m1403p(i3);
        int iM1394f = m1394f(i3);
        double[] dArr = (double[]) this.f1568h;
        double d = dArr[iM1403p];
        double d3 = dArr[iM1394f];
        double d4 = -d;
        double d5 = c0611g.f1578b;
        double d6 = c0611g.f1577a;
        dArr[iM1403p] = (d4 * d5) + (d3 * d6);
        dArr[iM1394f] = (d4 * d6) + ((-d3) * d5);
    }

    /* JADX INFO: renamed from: l */
    public void m1399l(C0607c c0607c) {
        C0607c c0607c2 = this;
        C0607c c0607c3 = c0607c;
        int i3 = c0607c2.f1567g;
        int i4 = (c0607c2.f1566f + i3) << 1;
        int i5 = c0607c3.f1567g;
        while (i3 < i4) {
            double[] dArr = (double[]) c0607c2.f1568h;
            double d = dArr[i3];
            int i6 = i3 + 1;
            double d3 = dArr[i6];
            double[] dArr2 = (double[]) c0607c3.f1568h;
            double d4 = dArr2[i5];
            double d5 = dArr2[i5 + 1];
            dArr[i3] = (d * d4) + ((-d3) * d5);
            dArr[i6] = (d * d5) + (d3 * d4);
            i5 += 2;
            i3 += 2;
            c0607c2 = this;
            c0607c3 = c0607c;
        }
    }

    /* JADX INFO: renamed from: m */
    public void m1400m(Iterator it) {
        int i3 = this.f1566f;
        int i4 = this.f1567g;
        if (i3 < i4) {
            Iterator[] itArr = (Iterator[]) this.f1568h;
            this.f1566f = i3 + 1;
            itArr[i3] = it;
            return;
        }
        if (((Iterator[]) this.f1568h) == null) {
            this.f1567g = 10;
            this.f1568h = new Iterator[10];
        } else {
            int iMin = Math.min(4000, Math.max(20, i4 >> 1)) + i4;
            this.f1567g = iMin;
            this.f1568h = (Iterator[]) Arrays.copyOf((Iterator[]) this.f1568h, iMin);
        }
        Iterator[] itArr2 = (Iterator[]) this.f1568h;
        int i5 = this.f1566f;
        this.f1566f = i5 + 1;
        itArr2[i5] = it;
    }

    /* JADX INFO: renamed from: n */
    public double m1401n(int i3) {
        return ((double[]) this.f1568h)[(i3 << 1) + this.f1567g];
    }

    /* JADX INFO: renamed from: o */
    public void m1402o(int i3, double d) {
        ((double[]) this.f1568h)[(i3 << 1) + this.f1567g] = d;
    }

    /* JADX INFO: renamed from: p */
    public int m1403p(int i3) {
        return (i3 << 1) + this.f1567g;
    }

    /* JADX INFO: renamed from: q */
    public void m1404q(int i3, double d, double d3) {
        int iM1403p = m1403p(i3);
        double[] dArr = (double[]) this.f1568h;
        dArr[iM1403p] = d;
        dArr[iM1403p + 1] = d3;
    }

    /* JADX INFO: renamed from: r */
    public void m1405r(int i3, int i4, int i5) {
        ((byte[][]) this.f1568h)[i4][i3] = (byte) i5;
    }

    /* JADX INFO: renamed from: s */
    public void m1406s(int i3, int i4, boolean z3) {
        ((byte[][]) this.f1568h)[i4][i3] = z3 ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: renamed from: t */
    public void m1407t() {
        int i3 = this.f1566f;
        int i4 = this.f1567g;
        int i5 = (i3 + i4) << 1;
        while (i4 < i5) {
            double[] dArr = (double[]) this.f1568h;
            double d = dArr[i4];
            int i6 = i4 + 1;
            double d3 = dArr[i6];
            dArr[i4] = (d * d) + ((-d3) * d3);
            dArr[i6] = d * 2.0d * d3;
            i4 += 2;
        }
    }

    public String toString() {
        switch (this.f1565e) {
            case 2:
                int i3 = this.f1566f;
                int i4 = this.f1567g;
                StringBuilder sb = new StringBuilder((i3 * 2 * i4) + 2);
                for (int i5 = 0; i5 < i4; i5++) {
                    byte[] bArr = ((byte[][]) this.f1568h)[i5];
                    for (int i6 = 0; i6 < i3; i6++) {
                        byte b3 = bArr[i6];
                        if (b3 == 0) {
                            sb.append(" 0");
                        } else if (b3 != 1) {
                            sb.append("  ");
                        } else {
                            sb.append(" 1");
                        }
                    }
                    sb.append('\n');
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public C0607c(long j2) {
        this.f1565e = 0;
        if (j2 <= 0 || j2 >= 2147483647L) {
            throw new IllegalArgumentException("numBits=" + j2);
        }
        int i3 = (((int) ((j2 + 63) >>> 6)) + 1) << 1;
        this.f1566f = i3;
        this.f1568h = new int[i3];
        this.f1567g = i3;
    }

    public C0607c(int i3, int i4) {
        this.f1565e = 2;
        this.f1568h = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i4, i3);
        this.f1566f = i3;
        this.f1567g = i4;
    }

    public C0607c(Context context, XmlResourceParser xmlResourceParser) {
        this.f1565e = 5;
        this.f1568h = new ArrayList();
        this.f1567g = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), AbstractC1940p.f6930g);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            if (index == 0) {
                this.f1566f = typedArrayObtainStyledAttributes.getResourceId(index, this.f1566f);
            } else if (index == 1) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1567g);
                this.f1567g = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new C1936l().m4336b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public C0607c(View view, int i3, int i4) {
        this.f1565e = 3;
        this.f1566f = i3;
        this.f1568h = view;
        this.f1567g = i4;
    }

    public C0607c(int i3) {
        this.f1565e = 1;
        this.f1568h = new double[i3 << 1];
        this.f1566f = i3;
        this.f1567g = 0;
    }

    public C0607c(int i3, int i4, C0607c c0607c) {
        this.f1565e = 1;
        this.f1566f = i4 - i3;
        this.f1568h = (double[]) c0607c.f1568h;
        this.f1567g = i3 << 1;
    }
}
