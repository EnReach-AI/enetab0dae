package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

/* JADX INFO: renamed from: u.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1935k {

    /* JADX INFO: renamed from: m */
    public static final SparseIntArray f6906m;

    /* JADX INFO: renamed from: a */
    public float f6907a;

    /* JADX INFO: renamed from: b */
    public float f6908b;

    /* JADX INFO: renamed from: c */
    public float f6909c;

    /* JADX INFO: renamed from: d */
    public float f6910d;

    /* JADX INFO: renamed from: e */
    public float f6911e;

    /* JADX INFO: renamed from: f */
    public float f6912f;

    /* JADX INFO: renamed from: g */
    public float f6913g;

    /* JADX INFO: renamed from: h */
    public float f6914h;

    /* JADX INFO: renamed from: i */
    public float f6915i;

    /* JADX INFO: renamed from: j */
    public float f6916j;

    /* JADX INFO: renamed from: k */
    public boolean f6917k;

    /* JADX INFO: renamed from: l */
    public float f6918l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6906m = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
    }

    /* JADX INFO: renamed from: a */
    public final void m4331a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1940p.f6931h);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            switch (f6906m.get(index)) {
                case 1:
                    this.f6907a = typedArrayObtainStyledAttributes.getFloat(index, this.f6907a);
                    break;
                case 2:
                    this.f6908b = typedArrayObtainStyledAttributes.getFloat(index, this.f6908b);
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    this.f6909c = typedArrayObtainStyledAttributes.getFloat(index, this.f6909c);
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    this.f6910d = typedArrayObtainStyledAttributes.getFloat(index, this.f6910d);
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    this.f6911e = typedArrayObtainStyledAttributes.getFloat(index, this.f6911e);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    this.f6912f = typedArrayObtainStyledAttributes.getDimension(index, this.f6912f);
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    this.f6913g = typedArrayObtainStyledAttributes.getDimension(index, this.f6913g);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    this.f6914h = typedArrayObtainStyledAttributes.getDimension(index, this.f6914h);
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    this.f6915i = typedArrayObtainStyledAttributes.getDimension(index, this.f6915i);
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    this.f6916j = typedArrayObtainStyledAttributes.getDimension(index, this.f6916j);
                    break;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    this.f6917k = true;
                    this.f6918l = typedArrayObtainStyledAttributes.getDimension(index, this.f6918l);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
