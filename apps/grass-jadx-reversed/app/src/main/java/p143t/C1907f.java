package p143t;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: t.f */
/* JADX INFO: loaded from: classes.dex */
public class C1907f implements InterfaceC1905d {

    /* JADX INFO: renamed from: d */
    public final AbstractC1914m f6671d;

    /* JADX INFO: renamed from: f */
    public int f6673f;

    /* JADX INFO: renamed from: g */
    public int f6674g;

    /* JADX INFO: renamed from: a */
    public AbstractC1914m f6668a = null;

    /* JADX INFO: renamed from: b */
    public boolean f6669b = false;

    /* JADX INFO: renamed from: c */
    public boolean f6670c = false;

    /* JADX INFO: renamed from: e */
    public int f6672e = 1;

    /* JADX INFO: renamed from: h */
    public int f6675h = 1;

    /* JADX INFO: renamed from: i */
    public C1908g f6676i = null;

    /* JADX INFO: renamed from: j */
    public boolean f6677j = false;

    /* JADX INFO: renamed from: k */
    public final ArrayList f6678k = new ArrayList();

    /* JADX INFO: renamed from: l */
    public final ArrayList f6679l = new ArrayList();

    public C1907f(AbstractC1914m abstractC1914m) {
        this.f6671d = abstractC1914m;
    }

    @Override // p143t.InterfaceC1905d
    /* JADX INFO: renamed from: a */
    public final void mo4233a(InterfaceC1905d interfaceC1905d) {
        ArrayList<C1907f> arrayList = this.f6679l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C1907f) it.next()).f6677j) {
                return;
            }
        }
        this.f6670c = true;
        AbstractC1914m abstractC1914m = this.f6668a;
        if (abstractC1914m != null) {
            abstractC1914m.mo4233a(this);
        }
        if (this.f6669b) {
            this.f6671d.mo4233a(this);
            return;
        }
        C1907f c1907f = null;
        int i3 = 0;
        for (C1907f c1907f2 : arrayList) {
            if (!(c1907f2 instanceof C1908g)) {
                i3++;
                c1907f = c1907f2;
            }
        }
        if (c1907f != null && i3 == 1 && c1907f.f6677j) {
            C1908g c1908g = this.f6676i;
            if (c1908g != null) {
                if (!c1908g.f6677j) {
                    return;
                } else {
                    this.f6673f = this.f6675h * c1908g.f6674g;
                }
            }
            mo4250d(c1907f.f6674g + this.f6673f);
        }
        AbstractC1914m abstractC1914m2 = this.f6668a;
        if (abstractC1914m2 != null) {
            abstractC1914m2.mo4233a(this);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4248b(InterfaceC1905d interfaceC1905d) {
        this.f6678k.add(interfaceC1905d);
        if (this.f6677j) {
            interfaceC1905d.mo4233a(interfaceC1905d);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4249c() {
        this.f6679l.clear();
        this.f6678k.clear();
        this.f6677j = false;
        this.f6674g = 0;
        this.f6670c = false;
        this.f6669b = false;
    }

    /* JADX INFO: renamed from: d */
    public void mo4250d(int i3) {
        if (this.f6677j) {
            return;
        }
        this.f6677j = true;
        this.f6674g = i3;
        for (InterfaceC1905d interfaceC1905d : this.f6678k) {
            interfaceC1905d.mo4233a(interfaceC1905d);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6671d.f6687b.f6484W);
        sb.append(":");
        switch (this.f6672e) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                str = "VERTICAL_DIMENSION";
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                str = "LEFT";
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                str = "RIGHT";
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                str = "TOP";
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                str = "BOTTOM";
                break;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.f6677j ? Integer.valueOf(this.f6674g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f6679l.size());
        sb.append(":d=");
        sb.append(this.f6678k.size());
        sb.append(">");
        return sb.toString();
    }
}
