package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import java.io.Serializable;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import p033K0.AbstractC0406d;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ext.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1212d implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final Class f4119g = Node.class;

    /* JADX INFO: renamed from: h */
    public static final Class f4120h = Document.class;

    /* JADX INFO: renamed from: i */
    public static final C1210b f4121i;

    /* JADX INFO: renamed from: j */
    public static final C1212d f4122j;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final HashMap f4123e;

    /* JADX INFO: renamed from: f */
    public final HashMap f4124f;

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    static {
        C1210b c1210b = null;
        try {
            c1210b = C1210b.f4117a;
        } catch (Throwable th) {
            AbstractC0406d.m904n(th);
        }
        f4121i = c1210b;
        f4122j = new C1212d();
    }

    public C1212d() {
        HashMap map = new HashMap();
        this.f4123e = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this.f4124f = map2;
        map2.put("java.sql.Timestamp", DateSerializer.instance);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    /* JADX INFO: renamed from: a */
    public static Object m3082a(AbstractC0721l abstractC0721l, Class cls) {
        try {
            return AbstractC1745j.m3885h(cls, false);
        } catch (Throwable th) {
            AbstractC0406d.m904n(th);
            throw new IllegalStateException("Failed to create instance of `" + cls.getName() + "` for handling values of type " + AbstractC1745j.m3895r(abstractC0721l) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }

    /* JADX INFO: renamed from: b */
    public static Object m3083b(AbstractC0721l abstractC0721l, String str) {
        try {
            return m3082a(abstractC0721l, Class.forName(str));
        } catch (Throwable th) {
            AbstractC0406d.m904n(th);
            throw new IllegalStateException("Failed to find class `" + str + "` for handling values of type " + AbstractC1745j.m3895r(abstractC0721l) + ", problem: (" + th.getClass().getName() + ") " + th.getMessage());
        }
    }
}
