package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import p132q.AbstractC1836a;

/* JADX INFO: renamed from: u.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1933i {

    /* JADX INFO: renamed from: e */
    public static final SparseIntArray f6897e;

    /* JADX INFO: renamed from: a */
    public int f6898a;

    /* JADX INFO: renamed from: b */
    public int f6899b;

    /* JADX INFO: renamed from: c */
    public float f6900c;

    /* JADX INFO: renamed from: d */
    public float f6901d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6897e = sparseIntArray;
        sparseIntArray.append(2, 1);
        sparseIntArray.append(4, 2);
        sparseIntArray.append(5, 3);
        sparseIntArray.append(1, 4);
        sparseIntArray.append(0, 5);
        sparseIntArray.append(3, 6);
    }

    /* JADX INFO: renamed from: a */
    public final void m4329a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1940p.f6928e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            switch (f6897e.get(index)) {
                case 1:
                    this.f6901d = typedArrayObtainStyledAttributes.getFloat(index, this.f6901d);
                    break;
                case 2:
                    this.f6899b = typedArrayObtainStyledAttributes.getInt(index, this.f6899b);
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        String str = AbstractC1836a.f6353a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    this.f6898a = C1936l.m4334f(typedArrayObtainStyledAttributes, index, this.f6898a);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    this.f6900c = typedArrayObtainStyledAttributes.getFloat(index, this.f6900c);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
