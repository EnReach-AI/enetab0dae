package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.exc.AbstractC1132c;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1165q;
import com.fasterxml.jackson.databind.deser.impl.C1166r;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import p039M0.EnumC0481b0;
import p039M0.EnumC0499n;
import p042N0.AbstractC0534b;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0716g;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p078a1.C0852d;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.C1738c;
import p118m1.C1739d;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public abstract class PrimitiveArrayDeserializers<T> extends StdDeserializer<T> implements InterfaceC1139f {
    private transient Object _emptyValue;
    protected final InterfaceC1178m _nuller;
    protected final Boolean _unwrapSingle;

    @InterfaceC0738b
    public static final class BooleanDeser extends PrimitiveArrayDeserializers<boolean[]> {
        private static final long serialVersionUID = 1;

        public BooleanDeser() {
            super(boolean[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new BooleanDeser(this, interfaceC1178m, bool);
        }

        public BooleanDeser(BooleanDeser booleanDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(booleanDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] _concat(boolean[] zArr, boolean[] zArr2) {
            int length = zArr.length;
            int length2 = zArr2.length;
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, length + length2);
            System.arraycopy(zArr2, 0, zArrCopyOf, length, length2);
            return zArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] _constructEmpty() {
            return new boolean[0];
        }

        @Override // p069X0.AbstractC0722m
        public boolean[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            boolean z_parseBooleanPrimitive;
            int i3;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6090a == null) {
                c1739dM1857v.f6090a = new C1738c(0);
            }
            C1738c c1738c = c1739dM1857v.f6090a;
            boolean[] zArr = (boolean[]) c1738c.m3867d();
            int i4 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (boolean[]) c1738c.m3866c(i4, zArr);
                    }
                    try {
                        if (enumC0548pMo1177V == EnumC0548p.VALUE_TRUE) {
                            z_parseBooleanPrimitive = true;
                        } else {
                            if (enumC0548pMo1177V != EnumC0548p.VALUE_FALSE) {
                                if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                                    InterfaceC1178m interfaceC1178m = this._nuller;
                                    if (interfaceC1178m != null) {
                                        interfaceC1178m.getNullValue(abstractC0718i);
                                    } else {
                                        _verifyNullForPrimitive(abstractC0718i);
                                    }
                                } else {
                                    z_parseBooleanPrimitive = _parseBooleanPrimitive(abstractC0545m, abstractC0718i);
                                }
                            }
                            z_parseBooleanPrimitive = false;
                        }
                        zArr[i4] = z_parseBooleanPrimitive;
                        i4 = i3;
                    } catch (Exception e3) {
                        e = e3;
                        i4 = i3;
                        throw C0724o.m1895h(e, zArr, c1738c.f6088d + i4);
                    }
                    if (i4 >= zArr.length) {
                        boolean[] zArr2 = (boolean[]) c1738c.m3865b(i4, zArr);
                        i4 = 0;
                        zArr = zArr2;
                    }
                    i3 = i4 + 1;
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public boolean[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new boolean[]{_parseBooleanPrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    @InterfaceC0738b
    public static final class ByteDeser extends PrimitiveArrayDeserializers<byte[]> {
        private static final long serialVersionUID = 1;

        public ByteDeser() {
            super(byte[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers, p069X0.AbstractC0722m
        public EnumC1664f logicalType() {
            return EnumC1664f.f5899o;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new ByteDeser(this, interfaceC1178m, bool);
        }

        public ByteDeser(ByteDeser byteDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(byteDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] _concat(byte[] bArr, byte[] bArr2) {
            int length = bArr.length;
            int length2 = bArr2.length;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, length + length2);
            System.arraycopy(bArr2, 0, bArrCopyOf, length, length2);
            return bArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] _constructEmpty() {
            return new byte[0];
        }

        @Override // p069X0.AbstractC0722m
        public byte[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            byte bMo1195j;
            int i3;
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == EnumC0548p.VALUE_STRING) {
                try {
                    return abstractC0545m.mo1193h(abstractC0718i.f1998g.f2481f.f2429o);
                } catch (AbstractC0716g | AbstractC1132c e3) {
                    String strMo1082a = e3.mo1082a();
                    if (strMo1082a.contains("base64")) {
                        abstractC0718i.m1829G(byte[].class, abstractC0545m.mo1157B(), strMo1082a, new Object[0]);
                        throw null;
                    }
                }
            }
            if (enumC0548pMo1190e == EnumC0548p.VALUE_EMBEDDED_OBJECT) {
                Object objMo1202q = abstractC0545m.mo1202q();
                if (objMo1202q == null) {
                    return null;
                }
                if (objMo1202q instanceof byte[]) {
                    return (byte[]) objMo1202q;
                }
            }
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6091b == null) {
                c1739dM1857v.f6091b = new C1738c(1);
            }
            C1738c c1738c = c1739dM1857v.f6091b;
            byte[] bArr = (byte[]) c1738c.m3867d();
            int i4 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (byte[]) c1738c.m3866c(i4, bArr);
                    }
                    try {
                        if (enumC0548pMo1177V == EnumC0548p.VALUE_NUMBER_INT) {
                            bMo1195j = abstractC0545m.mo1195j();
                        } else if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                            InterfaceC1178m interfaceC1178m = this._nuller;
                            if (interfaceC1178m != null) {
                                interfaceC1178m.getNullValue(abstractC0718i);
                            } else {
                                _verifyNullForPrimitive(abstractC0718i);
                                bMo1195j = 0;
                            }
                        } else {
                            bMo1195j = _parseBytePrimitive(abstractC0545m, abstractC0718i);
                        }
                        bArr[i4] = bMo1195j;
                        i4 = i3;
                    } catch (Exception e4) {
                        e = e4;
                        i4 = i3;
                        throw C0724o.m1895h(e, bArr, c1738c.f6088d + i4);
                    }
                    if (i4 >= bArr.length) {
                        byte[] bArr2 = (byte[]) c1738c.m3865b(i4, bArr);
                        i4 = 0;
                        bArr = bArr2;
                    }
                    i3 = i4 + 1;
                } catch (Exception e5) {
                    e = e5;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public byte[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == EnumC0548p.VALUE_NUMBER_INT) {
                return new byte[]{abstractC0545m.mo1195j()};
            }
            if (enumC0548pMo1190e != EnumC0548p.VALUE_NULL) {
                abstractC0718i.m1825C(abstractC0545m, this._valueClass.getComponentType());
                throw null;
            }
            InterfaceC1178m interfaceC1178m = this._nuller;
            if (interfaceC1178m != null) {
                interfaceC1178m.getNullValue(abstractC0718i);
                return (byte[]) getEmptyValue(abstractC0718i);
            }
            _verifyNullForPrimitive(abstractC0718i);
            return null;
        }
    }

    @InterfaceC0738b
    public static final class CharDeser extends PrimitiveArrayDeserializers<char[]> {
        private static final long serialVersionUID = 1;

        public CharDeser() {
            super(char[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return this;
        }

        public CharDeser(CharDeser charDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(charDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] _concat(char[] cArr, char[] cArr2) {
            int length = cArr.length;
            int length2 = cArr2.length;
            char[] cArrCopyOf = Arrays.copyOf(cArr, length + length2);
            System.arraycopy(cArr2, 0, cArrCopyOf, length, length2);
            return cArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] _constructEmpty() {
            return new char[0];
        }

        @Override // p069X0.AbstractC0722m
        public char[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            String strMo1157B;
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                char[] cArrMo1158C = abstractC0545m.mo1158C();
                int iMo1160E = abstractC0545m.mo1160E();
                int iMo1159D = abstractC0545m.mo1159D();
                char[] cArr = new char[iMo1159D];
                System.arraycopy(cArrMo1158C, iMo1160E, cArr, 0, iMo1159D);
                return cArr;
            }
            if (!abstractC0545m.mo1172Q()) {
                if (abstractC0545m.mo1168M(EnumC0548p.VALUE_EMBEDDED_OBJECT)) {
                    Object objMo1202q = abstractC0545m.mo1202q();
                    if (objMo1202q == null) {
                        return null;
                    }
                    if (objMo1202q instanceof char[]) {
                        return (char[]) objMo1202q;
                    }
                    if (objMo1202q instanceof String) {
                        return ((String) objMo1202q).toCharArray();
                    }
                    if (objMo1202q instanceof byte[]) {
                        return AbstractC0534b.f1228b.m1075e((byte[]) objMo1202q).toCharArray();
                    }
                }
                abstractC0718i.m1825C(abstractC0545m, this._valueClass);
                throw null;
            }
            StringBuilder sb = new StringBuilder(64);
            while (true) {
                EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                    return sb.toString().toCharArray();
                }
                if (enumC0548pMo1177V == EnumC0548p.VALUE_STRING) {
                    strMo1157B = abstractC0545m.mo1157B();
                } else {
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                        abstractC0718i.m1825C(abstractC0545m, Character.TYPE);
                        throw null;
                    }
                    InterfaceC1178m interfaceC1178m = this._nuller;
                    if (interfaceC1178m != null) {
                        interfaceC1178m.getNullValue(abstractC0718i);
                    } else {
                        _verifyNullForPrimitive(abstractC0718i);
                        strMo1157B = "\u0000";
                    }
                }
                if (strMo1157B.length() != 1) {
                    abstractC0718i.m1841S(this, "Cannot convert a JSON String of length %d into a char element of char array", Integer.valueOf(strMo1157B.length()));
                    throw null;
                }
                sb.append(strMo1157B.charAt(0));
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public char[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
    }

    @InterfaceC0738b
    public static final class DoubleDeser extends PrimitiveArrayDeserializers<double[]> {
        private static final long serialVersionUID = 1;

        public DoubleDeser() {
            super(double[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new DoubleDeser(this, interfaceC1178m, bool);
        }

        public DoubleDeser(DoubleDeser doubleDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(doubleDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] _concat(double[] dArr, double[] dArr2) {
            int length = dArr.length;
            int length2 = dArr2.length;
            double[] dArrCopyOf = Arrays.copyOf(dArr, length + length2);
            System.arraycopy(dArr2, 0, dArrCopyOf, length, length2);
            return dArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] _constructEmpty() {
            return new double[0];
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p069X0.AbstractC0722m
        public double[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            InterfaceC1178m interfaceC1178m;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6096g == null) {
                c1739dM1857v.f6096g = new C1738c(2);
            }
            C1738c c1738c = c1739dM1857v.f6096g;
            double[] dArr = (double[]) c1738c.m3867d();
            int i3 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (double[]) c1738c.m3866c(i3, dArr);
                    }
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL || (interfaceC1178m = this._nuller) == null) {
                        double d_parseDoublePrimitive = _parseDoublePrimitive(abstractC0545m, abstractC0718i);
                        if (i3 >= dArr.length) {
                            double[] dArr2 = (double[]) c1738c.m3865b(i3, dArr);
                            i3 = 0;
                            dArr = dArr2;
                        }
                        int i4 = i3 + 1;
                        try {
                            dArr[i3] = d_parseDoublePrimitive;
                            i3 = i4;
                        } catch (Exception e3) {
                            e = e3;
                            i3 = i4;
                            throw C0724o.m1895h(e, dArr, c1738c.f6088d + i3);
                        }
                    } else {
                        interfaceC1178m.getNullValue(abstractC0718i);
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public double[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new double[]{_parseDoublePrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    @InterfaceC0738b
    public static final class FloatDeser extends PrimitiveArrayDeserializers<float[]> {
        private static final long serialVersionUID = 1;

        public FloatDeser() {
            super(float[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new FloatDeser(this, interfaceC1178m, bool);
        }

        public FloatDeser(FloatDeser floatDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(floatDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] _concat(float[] fArr, float[] fArr2) {
            int length = fArr.length;
            int length2 = fArr2.length;
            float[] fArrCopyOf = Arrays.copyOf(fArr, length + length2);
            System.arraycopy(fArr2, 0, fArrCopyOf, length, length2);
            return fArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] _constructEmpty() {
            return new float[0];
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p069X0.AbstractC0722m
        public float[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            InterfaceC1178m interfaceC1178m;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6095f == null) {
                c1739dM1857v.f6095f = new C1738c(3);
            }
            C1738c c1738c = c1739dM1857v.f6095f;
            float[] fArr = (float[]) c1738c.m3867d();
            int i3 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (float[]) c1738c.m3866c(i3, fArr);
                    }
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL || (interfaceC1178m = this._nuller) == null) {
                        float f_parseFloatPrimitive = _parseFloatPrimitive(abstractC0545m, abstractC0718i);
                        if (i3 >= fArr.length) {
                            float[] fArr2 = (float[]) c1738c.m3865b(i3, fArr);
                            i3 = 0;
                            fArr = fArr2;
                        }
                        int i4 = i3 + 1;
                        try {
                            fArr[i3] = f_parseFloatPrimitive;
                            i3 = i4;
                        } catch (Exception e3) {
                            e = e3;
                            i3 = i4;
                            throw C0724o.m1895h(e, fArr, c1738c.f6088d + i3);
                        }
                    } else {
                        interfaceC1178m.getNullValue(abstractC0718i);
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public float[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new float[]{_parseFloatPrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    @InterfaceC0738b
    public static final class IntDeser extends PrimitiveArrayDeserializers<int[]> {
        public static final IntDeser instance = new IntDeser();
        private static final long serialVersionUID = 1;

        public IntDeser() {
            super(int[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new IntDeser(this, interfaceC1178m, bool);
        }

        public IntDeser(IntDeser intDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(intDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] _concat(int[] iArr, int[] iArr2) {
            int length = iArr.length;
            int length2 = iArr2.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
            System.arraycopy(iArr2, 0, iArrCopyOf, length, length2);
            return iArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] _constructEmpty() {
            return new int[0];
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p069X0.AbstractC0722m
        public int[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            int iMo1204s;
            int i3;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6093d == null) {
                c1739dM1857v.f6093d = new C1738c(4);
            }
            C1738c c1738c = c1739dM1857v.f6093d;
            int[] iArr = (int[]) c1738c.m3867d();
            int i4 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (int[]) c1738c.m3866c(i4, iArr);
                    }
                    try {
                        if (enumC0548pMo1177V == EnumC0548p.VALUE_NUMBER_INT) {
                            iMo1204s = abstractC0545m.mo1204s();
                        } else if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                            InterfaceC1178m interfaceC1178m = this._nuller;
                            if (interfaceC1178m != null) {
                                interfaceC1178m.getNullValue(abstractC0718i);
                            } else {
                                _verifyNullForPrimitive(abstractC0718i);
                                iMo1204s = 0;
                            }
                        } else {
                            iMo1204s = _parseIntPrimitive(abstractC0545m, abstractC0718i);
                        }
                        iArr[i4] = iMo1204s;
                        i4 = i3;
                    } catch (Exception e3) {
                        e = e3;
                        i4 = i3;
                        throw C0724o.m1895h(e, iArr, c1738c.f6088d + i4);
                    }
                    if (i4 >= iArr.length) {
                        int[] iArr2 = (int[]) c1738c.m3865b(i4, iArr);
                        i4 = 0;
                        iArr = iArr2;
                    }
                    i3 = i4 + 1;
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public int[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new int[]{_parseIntPrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    @InterfaceC0738b
    public static final class LongDeser extends PrimitiveArrayDeserializers<long[]> {
        public static final LongDeser instance = new LongDeser();
        private static final long serialVersionUID = 1;

        public LongDeser() {
            super(long[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new LongDeser(this, interfaceC1178m, bool);
        }

        public LongDeser(LongDeser longDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(longDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] _concat(long[] jArr, long[] jArr2) {
            int length = jArr.length;
            int length2 = jArr2.length;
            long[] jArrCopyOf = Arrays.copyOf(jArr, length + length2);
            System.arraycopy(jArr2, 0, jArrCopyOf, length, length2);
            return jArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] _constructEmpty() {
            return new long[0];
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // p069X0.AbstractC0722m
        public long[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            long jMo1205t;
            int i3;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6094e == null) {
                c1739dM1857v.f6094e = new C1738c(5);
            }
            C1738c c1738c = c1739dM1857v.f6094e;
            long[] jArr = (long[]) c1738c.m3867d();
            int i4 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (long[]) c1738c.m3866c(i4, jArr);
                    }
                    try {
                        if (enumC0548pMo1177V == EnumC0548p.VALUE_NUMBER_INT) {
                            jMo1205t = abstractC0545m.mo1205t();
                        } else if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                            InterfaceC1178m interfaceC1178m = this._nuller;
                            if (interfaceC1178m != null) {
                                interfaceC1178m.getNullValue(abstractC0718i);
                            } else {
                                _verifyNullForPrimitive(abstractC0718i);
                                jMo1205t = 0;
                            }
                        } else {
                            jMo1205t = _parseLongPrimitive(abstractC0545m, abstractC0718i);
                        }
                        jArr[i4] = jMo1205t;
                        i4 = i3;
                    } catch (Exception e3) {
                        e = e3;
                        i4 = i3;
                        throw C0724o.m1895h(e, jArr, c1738c.f6088d + i4);
                    }
                    if (i4 >= jArr.length) {
                        long[] jArr2 = (long[]) c1738c.m3865b(i4, jArr);
                        i4 = 0;
                        jArr = jArr2;
                    }
                    i3 = i4 + 1;
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public long[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new long[]{_parseLongPrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    @InterfaceC0738b
    public static final class ShortDeser extends PrimitiveArrayDeserializers<short[]> {
        private static final long serialVersionUID = 1;

        public ShortDeser() {
            super(short[].class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool) {
            return new ShortDeser(this, interfaceC1178m, bool);
        }

        public ShortDeser(ShortDeser shortDeser, InterfaceC1178m interfaceC1178m, Boolean bool) {
            super(shortDeser, interfaceC1178m, bool);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] _concat(short[] sArr, short[] sArr2) {
            int length = sArr.length;
            int length2 = sArr2.length;
            short[] sArrCopyOf = Arrays.copyOf(sArr, length + length2);
            System.arraycopy(sArr2, 0, sArrCopyOf, length, length2);
            return sArrCopyOf;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] _constructEmpty() {
            return new short[0];
        }

        @Override // p069X0.AbstractC0722m
        public short[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
            short s_parseShortPrimitive;
            int i3;
            if (!abstractC0545m.mo1172Q()) {
                return handleNonArray(abstractC0545m, abstractC0718i);
            }
            C1739d c1739dM1857v = abstractC0718i.m1857v();
            if (c1739dM1857v.f6092c == null) {
                c1739dM1857v.f6092c = new C1738c(6);
            }
            C1738c c1738c = c1739dM1857v.f6092c;
            short[] sArr = (short[]) c1738c.m3867d();
            int i4 = 0;
            while (true) {
                try {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                        return (short[]) c1738c.m3866c(i4, sArr);
                    }
                    try {
                        if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                            InterfaceC1178m interfaceC1178m = this._nuller;
                            if (interfaceC1178m != null) {
                                interfaceC1178m.getNullValue(abstractC0718i);
                            } else {
                                _verifyNullForPrimitive(abstractC0718i);
                                s_parseShortPrimitive = 0;
                            }
                        } else {
                            s_parseShortPrimitive = _parseShortPrimitive(abstractC0545m, abstractC0718i);
                        }
                        sArr[i4] = s_parseShortPrimitive;
                        i4 = i3;
                    } catch (Exception e3) {
                        e = e3;
                        i4 = i3;
                        throw C0724o.m1895h(e, sArr, c1738c.f6088d + i4);
                    }
                    if (i4 >= sArr.length) {
                        short[] sArr2 = (short[]) c1738c.m3865b(i4, sArr);
                        i4 = 0;
                        sArr = sArr2;
                    }
                    i3 = i4 + 1;
                } catch (Exception e4) {
                    e = e4;
                }
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.PrimitiveArrayDeserializers
        public short[] handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            return new short[]{_parseShortPrimitive(abstractC0545m, abstractC0718i)};
        }
    }

    public PrimitiveArrayDeserializers(Class<T> cls) {
        super((Class<?>) cls);
        this._unwrapSingle = null;
        this._nuller = null;
    }

    public static AbstractC0722m forType(Class<?> cls) {
        if (cls == Integer.TYPE) {
            return IntDeser.instance;
        }
        if (cls == Long.TYPE) {
            return LongDeser.instance;
        }
        if (cls == Byte.TYPE) {
            return new ByteDeser();
        }
        if (cls == Short.TYPE) {
            return new ShortDeser();
        }
        if (cls == Float.TYPE) {
            return new FloatDeser();
        }
        if (cls == Double.TYPE) {
            return new DoubleDeser();
        }
        if (cls == Boolean.TYPE) {
            return new BooleanDeser();
        }
        if (cls == Character.TYPE) {
            return new CharDeser();
        }
        throw new IllegalStateException();
    }

    public abstract T _concat(T t3, T t4);

    public abstract T _constructEmpty();

    public void _failOnNull(AbstractC0718i abstractC0718i) throws C0852d {
        abstractC0718i.m1848m(this._valueClass);
        throw C0852d.m2187i(abstractC0718i, null);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        Boolean boolFindFormatFeature = findFormatFeature(abstractC0718i, interfaceC0714e, this._valueClass, EnumC0499n.f1147e);
        EnumC0481b0 enumC0481b0FindContentNullStyle = findContentNullStyle(abstractC0718i, interfaceC0714e);
        InterfaceC1178m c1166r = enumC0481b0FindContentNullStyle == EnumC0481b0.f1122e ? C1165q.f4019f : enumC0481b0FindContentNullStyle == EnumC0481b0.f1123f ? interfaceC0714e == null ? new C1166r(null, abstractC0718i.m1848m(this._valueClass.getComponentType())) : new C1166r(interfaceC0714e.mo1803a(), interfaceC0714e.getType().mo1874i()) : null;
        return (Objects.equals(boolFindFormatFeature, this._unwrapSingle) && c1166r == this._nuller) ? this : withResolved(c1166r, boolFindFormatFeature);
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, T t3) {
        T t4 = (T) deserialize(abstractC0545m, abstractC0718i);
        return (t3 == null || Array.getLength(t3) == 0) ? t4 : _concat(t3, t4);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6082f;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        Object obj = this._emptyValue;
        if (obj != null) {
            return obj;
        }
        T t_constructEmpty = _constructEmpty();
        this._emptyValue = t_constructEmpty;
        return t_constructEmpty;
    }

    public T handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
            return _deserializeFromString(abstractC0545m, abstractC0718i);
        }
        Boolean bool = this._unwrapSingle;
        if (bool == Boolean.TRUE || (bool == null && abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return handleSingleElementUnwrapped(abstractC0545m, abstractC0718i);
        }
        abstractC0718i.m1825C(abstractC0545m, this._valueClass);
        throw null;
    }

    public abstract T handleSingleElementUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5889e;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    public abstract PrimitiveArrayDeserializers<?> withResolved(InterfaceC1178m interfaceC1178m, Boolean bool);

    public PrimitiveArrayDeserializers(PrimitiveArrayDeserializers<?> primitiveArrayDeserializers, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(primitiveArrayDeserializers._valueClass);
        this._unwrapSingle = bool;
        this._nuller = interfaceC1178m;
    }
}
