package p147u;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.xmlpull.v1.XmlPullParserException;
import p005B.AbstractC0032g;
import p132q.AbstractC1836a;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: u.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1936l {

    /* JADX INFO: renamed from: d */
    public static final int[] f6919d = {0, 4, 8};

    /* JADX INFO: renamed from: e */
    public static final SparseIntArray f6920e;

    /* JADX INFO: renamed from: a */
    public final HashMap f6921a = new HashMap();

    /* JADX INFO: renamed from: b */
    public final boolean f6922b = true;

    /* JADX INFO: renamed from: c */
    public final HashMap f6923c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6920e = sparseIntArray;
        sparseIntArray.append(76, 25);
        sparseIntArray.append(77, 26);
        sparseIntArray.append(79, 29);
        sparseIntArray.append(80, 30);
        sparseIntArray.append(86, 36);
        sparseIntArray.append(85, 35);
        sparseIntArray.append(58, 4);
        sparseIntArray.append(57, 3);
        sparseIntArray.append(55, 1);
        sparseIntArray.append(94, 6);
        sparseIntArray.append(95, 7);
        sparseIntArray.append(65, 17);
        sparseIntArray.append(66, 18);
        sparseIntArray.append(67, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(81, 32);
        sparseIntArray.append(82, 33);
        sparseIntArray.append(64, 10);
        sparseIntArray.append(63, 9);
        sparseIntArray.append(98, 13);
        sparseIntArray.append(101, 16);
        sparseIntArray.append(99, 14);
        sparseIntArray.append(96, 11);
        sparseIntArray.append(100, 15);
        sparseIntArray.append(97, 12);
        sparseIntArray.append(89, 40);
        sparseIntArray.append(74, 39);
        sparseIntArray.append(73, 41);
        sparseIntArray.append(88, 42);
        sparseIntArray.append(72, 20);
        sparseIntArray.append(87, 37);
        sparseIntArray.append(62, 5);
        sparseIntArray.append(75, 82);
        sparseIntArray.append(84, 82);
        sparseIntArray.append(78, 82);
        sparseIntArray.append(56, 82);
        sparseIntArray.append(54, 82);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(90, 54);
        sparseIntArray.append(68, 55);
        sparseIntArray.append(91, 56);
        sparseIntArray.append(69, 57);
        sparseIntArray.append(92, 58);
        sparseIntArray.append(70, 59);
        sparseIntArray.append(59, 61);
        sparseIntArray.append(61, 62);
        sparseIntArray.append(60, 63);
        sparseIntArray.append(27, 64);
        sparseIntArray.append(106, 65);
        sparseIntArray.append(33, 66);
        sparseIntArray.append(107, 67);
        sparseIntArray.append(103, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(102, 68);
        sparseIntArray.append(93, 69);
        sparseIntArray.append(71, 70);
        sparseIntArray.append(31, 71);
        sparseIntArray.append(29, 72);
        sparseIntArray.append(30, 73);
        sparseIntArray.append(32, 74);
        sparseIntArray.append(28, 75);
        sparseIntArray.append(104, 76);
        sparseIntArray.append(83, 77);
        sparseIntArray.append(108, 78);
        sparseIntArray.append(53, 80);
        sparseIntArray.append(52, 81);
    }

    /* JADX INFO: renamed from: c */
    public static int[] m4332c(Barrier barrier, String str) {
        int iIntValue;
        HashMap map;
        String[] strArrSplit = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < strArrSplit.length) {
            String strTrim = strArrSplit[i3].trim();
            Object obj = null;
            try {
                iIntValue = AbstractC1939o.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                constraintLayout.getClass();
                if ((strTrim instanceof String) && (map = constraintLayout.f2884q) != null && map.containsKey(strTrim)) {
                    obj = constraintLayout.f2884q.get(strTrim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i4] = iIntValue;
            i3++;
            i4++;
        }
        return i4 != strArrSplit.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    /* JADX INFO: renamed from: d */
    public static C1931g m4333d(Context context, AttributeSet attributeSet) {
        C1931g c1931g = new C1931g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1940p.f6924a);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i3);
            C1934j c1934j = c1931g.f6830b;
            C1933i c1933i = c1931g.f6831c;
            C1935k c1935k = c1931g.f6833e;
            C1932h c1932h = c1931g.f6832d;
            if (index != 1 && 23 != index && 24 != index) {
                c1933i.getClass();
                c1932h.getClass();
                c1934j.getClass();
                c1935k.getClass();
            }
            SparseIntArray sparseIntArray = f6920e;
            switch (sparseIntArray.get(index)) {
                case 1:
                    c1932h.f6885o = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6885o);
                    break;
                case 2:
                    c1932h.f6841F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6841F);
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    c1932h.f6884n = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6884n);
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    c1932h.f6883m = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6883m);
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    c1932h.f6892v = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    c1932h.f6896z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1932h.f6896z);
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    c1932h.f6836A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1932h.f6836A);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    c1932h.f6842G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6842G);
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    c1932h.f6889s = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6889s);
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    c1932h.f6888r = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6888r);
                    break;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    c1932h.f6847L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6847L);
                    break;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    c1932h.f6848M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6848M);
                    break;
                case 13:
                    c1932h.f6844I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6844I);
                    break;
                case 14:
                    c1932h.f6846K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6846K);
                    break;
                case 15:
                    c1932h.f6849N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6849N);
                    break;
                case 16:
                    c1932h.f6845J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6845J);
                    break;
                case 17:
                    c1932h.f6868d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1932h.f6868d);
                    break;
                case 18:
                    c1932h.f6870e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, c1932h.f6870e);
                    break;
                case 19:
                    c1932h.f6872f = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6872f);
                    break;
                case 20:
                    c1932h.f6890t = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6890t);
                    break;
                case 21:
                    c1932h.f6866c = typedArrayObtainStyledAttributes.getLayoutDimension(index, c1932h.f6866c);
                    break;
                case 22:
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, c1934j.f6902a);
                    c1934j.f6902a = i4;
                    c1934j.f6902a = f6919d[i4];
                    break;
                case 23:
                    c1932h.f6864b = typedArrayObtainStyledAttributes.getLayoutDimension(index, c1932h.f6864b);
                    break;
                case 24:
                    c1932h.f6838C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6838C);
                    break;
                case 25:
                    c1932h.f6874g = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6874g);
                    break;
                case 26:
                    c1932h.f6876h = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6876h);
                    break;
                case 27:
                    c1932h.f6837B = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6837B);
                    break;
                case 28:
                    c1932h.f6839D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6839D);
                    break;
                case 29:
                    c1932h.f6878i = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6878i);
                    break;
                case 30:
                    c1932h.f6880j = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6880j);
                    break;
                case 31:
                    c1932h.f6843H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6843H);
                    break;
                case 32:
                    c1932h.f6886p = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6886p);
                    break;
                case 33:
                    c1932h.f6887q = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6887q);
                    break;
                case 34:
                    c1932h.f6840E = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6840E);
                    break;
                case 35:
                    c1932h.f6882l = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6882l);
                    break;
                case 36:
                    c1932h.f6881k = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6881k);
                    break;
                case 37:
                    c1932h.f6891u = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6891u);
                    break;
                case 38:
                    c1931g.f6829a = typedArrayObtainStyledAttributes.getResourceId(index, c1931g.f6829a);
                    break;
                case 39:
                    c1932h.f6851P = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6851P);
                    break;
                case 40:
                    c1932h.f6850O = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6850O);
                    break;
                case 41:
                    c1932h.f6852Q = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6852Q);
                    break;
                case 42:
                    c1932h.f6853R = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6853R);
                    break;
                case 43:
                    c1934j.f6904c = typedArrayObtainStyledAttributes.getFloat(index, c1934j.f6904c);
                    break;
                case 44:
                    c1935k.f6917k = true;
                    c1935k.f6918l = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6918l);
                    break;
                case 45:
                    c1935k.f6908b = typedArrayObtainStyledAttributes.getFloat(index, c1935k.f6908b);
                    break;
                case 46:
                    c1935k.f6909c = typedArrayObtainStyledAttributes.getFloat(index, c1935k.f6909c);
                    break;
                case 47:
                    c1935k.f6910d = typedArrayObtainStyledAttributes.getFloat(index, c1935k.f6910d);
                    break;
                case 48:
                    c1935k.f6911e = typedArrayObtainStyledAttributes.getFloat(index, c1935k.f6911e);
                    break;
                case 49:
                    c1935k.f6912f = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6912f);
                    break;
                case 50:
                    c1935k.f6913g = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6913g);
                    break;
                case 51:
                    c1935k.f6914h = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6914h);
                    break;
                case 52:
                    c1935k.f6915i = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6915i);
                    break;
                case 53:
                    c1935k.f6916j = typedArrayObtainStyledAttributes.getDimension(index, c1935k.f6916j);
                    break;
                case 54:
                    c1932h.f6854S = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6854S);
                    break;
                case 55:
                    c1932h.f6855T = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6855T);
                    break;
                case 56:
                    c1932h.f6856U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6856U);
                    break;
                case 57:
                    c1932h.f6857V = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6857V);
                    break;
                case 58:
                    c1932h.f6858W = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6858W);
                    break;
                case 59:
                    c1932h.f6859X = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6859X);
                    break;
                case 60:
                    c1935k.f6907a = typedArrayObtainStyledAttributes.getFloat(index, c1935k.f6907a);
                    break;
                case 61:
                    c1932h.f6893w = m4334f(typedArrayObtainStyledAttributes, index, c1932h.f6893w);
                    break;
                case 62:
                    c1932h.f6894x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6894x);
                    break;
                case 63:
                    c1932h.f6895y = typedArrayObtainStyledAttributes.getFloat(index, c1932h.f6895y);
                    break;
                case 64:
                    c1933i.f6898a = m4334f(typedArrayObtainStyledAttributes, index, c1933i.f6898a);
                    break;
                case 65:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        c1933i.getClass();
                    } else {
                        String str = AbstractC1836a.f6353a[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        c1933i.getClass();
                    }
                    break;
                case 66:
                    typedArrayObtainStyledAttributes.getInt(index, 0);
                    c1933i.getClass();
                    break;
                case 67:
                    c1933i.f6901d = typedArrayObtainStyledAttributes.getFloat(index, c1933i.f6901d);
                    break;
                case 68:
                    c1934j.f6905d = typedArrayObtainStyledAttributes.getFloat(index, c1934j.f6905d);
                    break;
                case 69:
                    c1932h.f6860Y = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 70:
                    c1932h.f6861Z = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    c1932h.f6863a0 = typedArrayObtainStyledAttributes.getInt(index, c1932h.f6863a0);
                    break;
                case 73:
                    c1932h.f6865b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, c1932h.f6865b0);
                    break;
                case 74:
                    c1932h.f6871e0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 75:
                    c1932h.f6879i0 = typedArrayObtainStyledAttributes.getBoolean(index, c1932h.f6879i0);
                    break;
                case 76:
                    c1933i.f6899b = typedArrayObtainStyledAttributes.getInt(index, c1933i.f6899b);
                    break;
                case 77:
                    c1932h.f6873f0 = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 78:
                    c1934j.f6903b = typedArrayObtainStyledAttributes.getInt(index, c1934j.f6903b);
                    break;
                case 79:
                    c1933i.f6900c = typedArrayObtainStyledAttributes.getFloat(index, c1933i.f6900c);
                    break;
                case 80:
                    c1932h.f6875g0 = typedArrayObtainStyledAttributes.getBoolean(index, c1932h.f6875g0);
                    break;
                case 81:
                    c1932h.f6877h0 = typedArrayObtainStyledAttributes.getBoolean(index, c1932h.f6877h0);
                    break;
                case 82:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return c1931g;
    }

    /* JADX INFO: renamed from: f */
    public static int m4334f(TypedArray typedArray, int i3, int i4) {
        int resourceId = typedArray.getResourceId(i3, i4);
        return resourceId == -1 ? typedArray.getInt(i3, -1) : resourceId;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: a */
    public final void m4335a(ConstraintLayout constraintLayout) {
        int i3;
        Iterator it;
        String resourceEntryName;
        C1936l c1936l = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = c1936l.f6923c;
        HashSet<Integer> hashSet = new HashSet(map.keySet());
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = constraintLayout.getChildAt(i4);
            int id = childAt.getId();
            if (!map.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (c1936l.f6922b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        C1931g c1931g = (C1931g) map.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            c1931g.f6832d.f6867c0 = 1;
                        }
                        int i5 = c1931g.f6832d.f6867c0;
                        if (i5 != -1 && i5 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            C1932h c1932h = c1931g.f6832d;
                            barrier.setType(c1932h.f6863a0);
                            barrier.setMargin(c1932h.f6865b0);
                            barrier.setAllowsGoneWidget(c1932h.f6879i0);
                            int[] iArr = c1932h.f6869d0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = c1932h.f6871e0;
                                if (str != null) {
                                    int[] iArrM4332c = m4332c(barrier, str);
                                    c1932h.f6869d0 = iArrM4332c;
                                    barrier.setReferencedIds(iArrM4332c);
                                }
                            }
                        }
                        C1928d c1928d = (C1928d) childAt.getLayoutParams();
                        c1928d.m4325a();
                        c1931g.m4327a(c1928d);
                        HashMap map2 = c1931g.f6834f;
                        Class<?> cls = childAt.getClass();
                        Iterator it2 = map2.keySet().iterator();
                        while (it2.hasNext()) {
                            String str2 = (String) it2.next();
                            C1925a c1925a = (C1925a) map2.get(str2);
                            int i6 = childCount;
                            String strM152j = AbstractC0032g.m152j("set", str2);
                            HashMap map3 = map2;
                            try {
                                switch (AbstractC1849h.m4118b(c1925a.f6741a)) {
                                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                                        it = it2;
                                        cls.getMethod(strM152j, Integer.TYPE).invoke(childAt, Integer.valueOf(c1925a.f6742b));
                                        break;
                                    case 1:
                                        it = it2;
                                        cls.getMethod(strM152j, Float.TYPE).invoke(childAt, Float.valueOf(c1925a.f6743c));
                                        break;
                                    case 2:
                                        it = it2;
                                        cls.getMethod(strM152j, Integer.TYPE).invoke(childAt, Integer.valueOf(c1925a.f6746f));
                                        break;
                                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                                        Method method = cls.getMethod(strM152j, Drawable.class);
                                        it = it2;
                                        try {
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(c1925a.f6746f);
                                            method.invoke(childAt, colorDrawable);
                                        } catch (IllegalAccessException e3) {
                                            e = e3;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                        } catch (NoSuchMethodException e4) {
                                            e = e4;
                                            Log.e("TransitionLayout", e.getMessage());
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            Log.e("TransitionLayout", cls.getName() + " must have a method " + strM152j);
                                        } catch (InvocationTargetException e5) {
                                            e = e5;
                                            Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                            e.printStackTrace();
                                        }
                                        break;
                                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                                        cls.getMethod(strM152j, CharSequence.class).invoke(childAt, c1925a.f6744d);
                                        it = it2;
                                        break;
                                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                                        cls.getMethod(strM152j, Boolean.TYPE).invoke(childAt, Boolean.valueOf(c1925a.f6745e));
                                        it = it2;
                                        break;
                                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                                        cls.getMethod(strM152j, Float.TYPE).invoke(childAt, Float.valueOf(c1925a.f6743c));
                                        it = it2;
                                        break;
                                    default:
                                        it = it2;
                                        break;
                                }
                            } catch (IllegalAccessException e6) {
                                e = e6;
                                it = it2;
                            } catch (NoSuchMethodException e7) {
                                e = e7;
                                it = it2;
                            } catch (InvocationTargetException e8) {
                                e = e8;
                                it = it2;
                            }
                            childCount = i6;
                            map2 = map3;
                            it2 = it;
                        }
                        i3 = childCount;
                        childAt.setLayoutParams(c1928d);
                        C1934j c1934j = c1931g.f6830b;
                        if (c1934j.f6903b == 0) {
                            childAt.setVisibility(c1934j.f6902a);
                        }
                        childAt.setAlpha(c1934j.f6904c);
                        C1935k c1935k = c1931g.f6833e;
                        childAt.setRotation(c1935k.f6907a);
                        childAt.setRotationX(c1935k.f6908b);
                        childAt.setRotationY(c1935k.f6909c);
                        childAt.setScaleX(c1935k.f6910d);
                        childAt.setScaleY(c1935k.f6911e);
                        if (!Float.isNaN(c1935k.f6912f)) {
                            childAt.setPivotX(c1935k.f6912f);
                        }
                        if (!Float.isNaN(c1935k.f6913g)) {
                            childAt.setPivotY(c1935k.f6913g);
                        }
                        childAt.setTranslationX(c1935k.f6914h);
                        childAt.setTranslationY(c1935k.f6915i);
                        childAt.setTranslationZ(c1935k.f6916j);
                        if (c1935k.f6917k) {
                            childAt.setElevation(c1935k.f6918l);
                        }
                    } else {
                        i3 = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i4++;
                c1936l = this;
                childCount = i3;
            }
            i3 = childCount;
            i4++;
            c1936l = this;
            childCount = i3;
        }
        for (Integer num : hashSet) {
            C1931g c1931g2 = (C1931g) map.get(num);
            C1932h c1932h2 = c1931g2.f6832d;
            int i7 = c1932h2.f6867c0;
            if (i7 != -1 && i7 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = c1932h2.f6869d0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = c1932h2.f6871e0;
                    if (str3 != null) {
                        int[] iArrM4332c2 = m4332c(barrier2, str3);
                        c1932h2.f6869d0 = iArrM4332c2;
                        barrier2.setReferencedIds(iArrM4332c2);
                    }
                }
                barrier2.setType(c1932h2.f6863a0);
                barrier2.setMargin(c1932h2.f6865b0);
                C1928d c1928dM2292a = ConstraintLayout.m2292a();
                barrier2.m4324g();
                c1931g2.m4327a(c1928dM2292a);
                constraintLayout.addView(barrier2, c1928dM2292a);
            }
            if (c1932h2.f6862a) {
                View c1938n = new C1938n(constraintLayout.getContext());
                c1938n.setId(num.intValue());
                C1928d c1928dM2292a2 = ConstraintLayout.m2292a();
                c1931g2.m4327a(c1928dM2292a2);
                constraintLayout.addView(c1938n, c1928dM2292a2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4336b(ConstraintLayout constraintLayout) {
        C1936l c1936l = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = c1936l.f6923c;
        map.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            C1928d c1928d = (C1928d) childAt.getLayoutParams();
            int id = childAt.getId();
            if (c1936l.f6922b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new C1931g());
            }
            C1931g c1931g = (C1931g) map.get(Integer.valueOf(id));
            HashMap map2 = c1936l.f6921a;
            HashMap map3 = new HashMap();
            Class<?> cls = childAt.getClass();
            for (String str : map2.keySet()) {
                C1925a c1925a = (C1925a) map2.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        map3.put(str, new C1925a(c1925a, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        map3.put(str, new C1925a(c1925a, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                    }
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                } catch (InvocationTargetException e5) {
                    e5.printStackTrace();
                }
            }
            c1931g.f6834f = map3;
            c1931g.f6829a = id;
            int i4 = c1928d.f6786d;
            C1932h c1932h = c1931g.f6832d;
            c1932h.f6874g = i4;
            c1932h.f6876h = c1928d.f6788e;
            c1932h.f6878i = c1928d.f6790f;
            c1932h.f6880j = c1928d.f6792g;
            c1932h.f6881k = c1928d.f6794h;
            c1932h.f6882l = c1928d.f6796i;
            c1932h.f6883m = c1928d.f6798j;
            c1932h.f6884n = c1928d.f6800k;
            c1932h.f6885o = c1928d.f6802l;
            c1932h.f6886p = c1928d.f6806p;
            c1932h.f6887q = c1928d.f6807q;
            c1932h.f6888r = c1928d.f6808r;
            c1932h.f6889s = c1928d.f6809s;
            c1932h.f6890t = c1928d.f6816z;
            c1932h.f6891u = c1928d.f6754A;
            c1932h.f6892v = c1928d.f6755B;
            c1932h.f6893w = c1928d.f6803m;
            c1932h.f6894x = c1928d.f6804n;
            c1932h.f6895y = c1928d.f6805o;
            c1932h.f6896z = c1928d.f6769P;
            c1932h.f6836A = c1928d.f6770Q;
            c1932h.f6837B = c1928d.f6771R;
            c1932h.f6872f = c1928d.f6784c;
            c1932h.f6868d = c1928d.f6780a;
            c1932h.f6870e = c1928d.f6782b;
            c1932h.f6864b = ((ViewGroup.MarginLayoutParams) c1928d).width;
            c1932h.f6866c = ((ViewGroup.MarginLayoutParams) c1928d).height;
            c1932h.f6838C = ((ViewGroup.MarginLayoutParams) c1928d).leftMargin;
            c1932h.f6839D = ((ViewGroup.MarginLayoutParams) c1928d).rightMargin;
            c1932h.f6840E = ((ViewGroup.MarginLayoutParams) c1928d).topMargin;
            c1932h.f6841F = ((ViewGroup.MarginLayoutParams) c1928d).bottomMargin;
            c1932h.f6850O = c1928d.f6758E;
            c1932h.f6851P = c1928d.f6757D;
            c1932h.f6853R = c1928d.f6760G;
            c1932h.f6852Q = c1928d.f6759F;
            c1932h.f6875g0 = c1928d.f6772S;
            c1932h.f6877h0 = c1928d.f6773T;
            c1932h.f6854S = c1928d.f6761H;
            c1932h.f6855T = c1928d.f6762I;
            c1932h.f6856U = c1928d.f6765L;
            c1932h.f6857V = c1928d.f6766M;
            c1932h.f6858W = c1928d.f6763J;
            c1932h.f6859X = c1928d.f6764K;
            c1932h.f6860Y = c1928d.f6767N;
            c1932h.f6861Z = c1928d.f6768O;
            c1932h.f6873f0 = c1928d.f6774U;
            c1932h.f6845J = c1928d.f6811u;
            c1932h.f6847L = c1928d.f6813w;
            c1932h.f6844I = c1928d.f6810t;
            c1932h.f6846K = c1928d.f6812v;
            c1932h.f6849N = c1928d.f6814x;
            c1932h.f6848M = c1928d.f6815y;
            c1932h.f6842G = c1928d.getMarginEnd();
            c1932h.f6843H = c1928d.getMarginStart();
            int visibility = childAt.getVisibility();
            C1934j c1934j = c1931g.f6830b;
            c1934j.f6902a = visibility;
            c1934j.f6904c = childAt.getAlpha();
            float rotation = childAt.getRotation();
            C1935k c1935k = c1931g.f6833e;
            c1935k.f6907a = rotation;
            c1935k.f6908b = childAt.getRotationX();
            c1935k.f6909c = childAt.getRotationY();
            c1935k.f6910d = childAt.getScaleX();
            c1935k.f6911e = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                c1935k.f6912f = pivotX;
                c1935k.f6913g = pivotY;
            }
            c1935k.f6914h = childAt.getTranslationX();
            c1935k.f6915i = childAt.getTranslationY();
            c1935k.f6916j = childAt.getTranslationZ();
            if (c1935k.f6917k) {
                c1935k.f6918l = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                c1932h.f6879i0 = barrier.f2871m.f6436g0;
                c1932h.f6869d0 = barrier.getReferencedIds();
                c1932h.f6863a0 = barrier.getType();
                c1932h.f6865b0 = barrier.getMargin();
            }
            i3++;
            c1936l = this;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m4337e(Context context, int i3) {
        XmlResourceParser xml = context.getResources().getXml(i3);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    C1931g c1931gM4333d = m4333d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        c1931gM4333d.f6832d.f6862a = true;
                    }
                    this.f6923c.put(Integer.valueOf(c1931gM4333d.f6829a), c1931gM4333d);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
        }
    }
}
