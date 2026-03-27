package com.fasterxml.jackson.databind.deser.std;

import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1188d {

    /* JADX INFO: renamed from: a */
    public static final HashSet f4055a = new HashSet();

    static {
        Class[] clsArr = {UUID.class, AtomicBoolean.class, AtomicInteger.class, AtomicLong.class, StackTraceElement.class, ByteBuffer.class, Void.class};
        for (int i3 = 0; i3 < 7; i3++) {
            f4055a.add(clsArr[i3].getName());
        }
        for (Class<?> cls : FromStringDeserializer.types()) {
            f4055a.add(cls.getName());
        }
    }
}
