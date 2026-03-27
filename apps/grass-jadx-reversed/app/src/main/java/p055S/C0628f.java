package p055S;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: S.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0628f extends AbstractC1946e {

    /* JADX INFO: renamed from: b */
    public final TextView f1613b;

    /* JADX INFO: renamed from: c */
    public final C0626d f1614c;

    /* JADX INFO: renamed from: d */
    public boolean f1615d = true;

    public C0628f(TextView textView) {
        this.f1613b = textView;
        this.f1614c = new C0626d(textView);
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: a */
    public final InputFilter[] mo1442a(InputFilter[] inputFilterArr) {
        if (!this.f1615d) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i3 = 0; i3 < inputFilterArr.length; i3++) {
                InputFilter inputFilter = inputFilterArr[i3];
                if (inputFilter instanceof C0626d) {
                    sparseArray.put(i3, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5++) {
                if (sparseArray.indexOfKey(i5) < 0) {
                    inputFilterArr2[i4] = inputFilterArr[i5];
                    i4++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i6 = 0;
        while (true) {
            C0626d c0626d = this.f1614c;
            if (i6 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = c0626d;
                return inputFilterArr3;
            }
            if (inputFilterArr[i6] == c0626d) {
                return inputFilterArr;
            }
            i6++;
        }
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: j */
    public final void mo1443j(boolean z3) {
        if (z3) {
            m1445l();
        }
    }

    @Override // p148u0.AbstractC1946e
    /* JADX INFO: renamed from: k */
    public final void mo1444k(boolean z3) {
        this.f1615d = z3;
        m1445l();
        TextView textView = this.f1613b;
        textView.setFilters(mo1442a(textView.getFilters()));
    }

    /* JADX INFO: renamed from: l */
    public final void m1445l() {
        TextView textView = this.f1613b;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (this.f1615d) {
            if (!(transformationMethod instanceof C0632j) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                transformationMethod = new C0632j(transformationMethod);
            }
        } else if (transformationMethod instanceof C0632j) {
            transformationMethod = ((C0632j) transformationMethod).f1622a;
        }
        textView.setTransformationMethod(transformationMethod);
    }
}
