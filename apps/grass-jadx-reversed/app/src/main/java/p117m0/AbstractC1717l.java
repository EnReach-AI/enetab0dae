package p117m0;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.facebook.AbstractC1117n;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import p005B.AbstractC0037l;
import p010C0.AbstractC0147a;
import p036L0.C0444d;
import p041N.InterfaceC0523k;
import p052R.C0604b;
import p131p2.C1832f;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: m0.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1717l implements InterfaceC0523k {
    /* JADX INFO: renamed from: a */
    public static void m3798a() {
        if (10 <= new C1832f(2, 36, 1).f6339f) {
            return;
        }
        throw new IllegalArgumentException("radix 10 was not in valid range " + new C1832f(2, 36, 1));
    }

    /* JADX INFO: renamed from: b */
    public static void m3799b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3800c(File file, Resources resources, int i3) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i3);
        } catch (Throwable th) {
            th = th;
            inputStreamOpenRawResource = null;
        }
        try {
            boolean zM3801d = m3801d(file, inputStreamOpenRawResource);
            m3799b(inputStreamOpenRawResource);
            return zM3801d;
        } catch (Throwable th2) {
            th = th2;
            m3799b(inputStreamOpenRawResource);
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean m3801d(File file, InputStream inputStream) throws Throwable {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i3 = inputStream.read(bArr);
                        if (i3 == -1) {
                            m3799b(fileOutputStream2);
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                            return true;
                        }
                        fileOutputStream2.write(bArr, 0, i3);
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                    m3799b(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    m3799b(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    /* JADX INFO: renamed from: e */
    public static final boolean m3802e(char c3, char c4, boolean z3) {
        if (c3 == c4) {
            return true;
        }
        if (!z3) {
            return false;
        }
        char upperCase = Character.toUpperCase(c3);
        char upperCase2 = Character.toUpperCase(c4);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    /* JADX INFO: renamed from: f */
    public static File m3803f(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i3 = 0; i3 < 100; i3++) {
            File file = new File(cacheDir, str + i3);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public static MappedByteBuffer m3804g(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorM189a = AbstractC0037l.m189a(context.getContentResolver(), uri, "r", null);
            if (parcelFileDescriptorM189a == null) {
                if (parcelFileDescriptorM189a != null) {
                    parcelFileDescriptorM189a.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorM189a.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorM189a.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public static synchronized void m3805h(C0444d c0444d) {
        Set<C1707b> setKeySet;
        C1724s c1724s;
        if (AbstractC0147a.f354a.contains(AbstractC1717l.class)) {
            return;
        }
        try {
            C1723r c1723rM3808k = m3808k();
            synchronized (c0444d) {
                setKeySet = ((HashMap) c0444d.f1085e).keySet();
            }
            for (C1707b c1707b : setKeySet) {
                synchronized (c0444d) {
                    c1724s = (C1724s) ((HashMap) c0444d.f1085e).get(c1707b);
                }
                c1723rM3808k.m3823a(c1707b, c1724s.m3826c());
            }
            m3809l(c1723rM3808k);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1717l.class);
        }
    }

    /* JADX INFO: renamed from: i */
    public static synchronized void m3806i(C1707b c1707b, C1724s c1724s) {
        if (AbstractC0147a.f354a.contains(AbstractC1717l.class)) {
            return;
        }
        try {
            C1723r c1723rM3808k = m3808k();
            c1723rM3808k.m3823a(c1707b, c1724s.m3826c());
            m3809l(c1723rM3808k);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1717l.class);
        }
    }

    /* JADX INFO: renamed from: j */
    public static C0604b m3807j(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i3 = byteBufferDuplicate.getShort() & 65535;
        if (i3 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                j2 = -1;
                break;
            }
            int i5 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i5) {
                break;
            }
            i4++;
        }
        if (j2 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j2 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i6 = 0; i6 < j3; i6++) {
                int i7 = byteBufferDuplicate.getInt();
                long j4 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i7 || 1701669481 == i7) {
                    byteBufferDuplicate.position((int) (j4 + j2));
                    C0604b c0604b = new C0604b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    c0604b.f888d = byteBufferDuplicate;
                    c0604b.f885a = iPosition;
                    int i8 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    c0604b.f886b = i8;
                    c0604b.f887c = ((ByteBuffer) c0604b.f888d).getShort(i8);
                    return c0604b;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009e A[Catch: all -> 0x003b, TRY_LEAVE, TryCatch #10 {all -> 0x003b, blocks: (B:9:0x0010, B:12:0x002d, B:13:0x0030, B:51:0x009e, B:18:0x003f, B:38:0x0072, B:39:0x0075, B:43:0x0087, B:42:0x0080, B:32:0x005c, B:33:0x005f, B:37:0x006e, B:44:0x0088, B:45:0x008b), top: B:68:0x0010, outer: #4, inners: #0, #2 }] */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.content.Context] */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized p117m0.C1723r m3808k() {
        /*
            java.lang.Class<m0.l> r0 = p117m0.AbstractC1717l.class
            monitor-enter(r0)
            java.lang.Class<m0.l> r1 = p117m0.AbstractC1717l.class
            java.util.Set r2 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> Lb3
            boolean r1 = r2.contains(r1)     // Catch: java.lang.Throwable -> Lb3
            r2 = 0
            if (r1 == 0) goto L10
            monitor-exit(r0)
            return r2
        L10:
            java.util.HashSet r1 = com.facebook.AbstractC1117n.f3875a     // Catch: java.lang.Throwable -> L3b
            p166z0.AbstractC2069g.m4584h()     // Catch: java.lang.Throwable -> L3b
            android.content.Context r1 = com.facebook.AbstractC1117n.f3882h     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.io.FileNotFoundException -> L4f java.lang.Throwable -> L51 java.lang.Exception -> L53
            m0.k r4 = new m0.k     // Catch: java.io.FileNotFoundException -> L4f java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.io.FileNotFoundException -> L4f java.lang.Throwable -> L51 java.lang.Exception -> L53
            r5.<init>(r3)     // Catch: java.io.FileNotFoundException -> L4f java.lang.Throwable -> L51 java.lang.Exception -> L53
            r4.<init>(r5)     // Catch: java.io.FileNotFoundException -> L4f java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49 java.io.FileNotFoundException -> L88
            m0.r r3 = (p117m0.C1723r) r3     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L49 java.io.FileNotFoundException -> L88
            p166z0.AbstractC2056E.m4535d(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3e
            goto L9c
        L3b:
            r1 = move-exception
            goto Lac
        L3e:
            r1 = move-exception
            java.lang.String r4 = "m0.l"
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L3b
            goto L9c
        L47:
            r3 = move-exception
            goto L72
        L49:
            r3 = move-exception
            goto L55
        L4b:
            r4 = r2
            goto L72
        L4d:
            r4 = r2
            goto L55
        L4f:
            r4 = r2
            goto L88
        L51:
            r3 = move-exception
            goto L4b
        L53:
            r3 = move-exception
            goto L4d
        L55:
            java.lang.String r5 = "m0.l"
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L47
            p166z0.AbstractC2056E.m4535d(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L69
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L69
            goto L9b
        L69:
            r1 = move-exception
            java.lang.String r3 = "m0.l"
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L6e:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L3b
            goto L9b
        L72:
            p166z0.AbstractC2056E.m4535d(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L7f
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L7f
            goto L87
        L7f:
            r1 = move-exception
            java.lang.String r4 = "m0.l"
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L3b
        L87:
            throw r3     // Catch: java.lang.Throwable -> L3b
        L88:
            p166z0.AbstractC2056E.m4535d(r4)     // Catch: java.lang.Throwable -> L3b
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L95
            r1.delete()     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L95
            goto L9b
        L95:
            r1 = move-exception
            java.lang.String r3 = "m0.l"
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L6e
        L9b:
            r3 = r2
        L9c:
            if (r3 != 0) goto Laa
            m0.r r3 = new m0.r     // Catch: java.lang.Throwable -> L3b
            r3.<init>()     // Catch: java.lang.Throwable -> L3b
            java.util.HashMap r1 = new java.util.HashMap     // Catch: java.lang.Throwable -> L3b
            r1.<init>()     // Catch: java.lang.Throwable -> L3b
            r3.f6011e = r1     // Catch: java.lang.Throwable -> L3b
        Laa:
            monitor-exit(r0)
            return r3
        Lac:
            java.lang.Class<m0.l> r3 = p117m0.AbstractC1717l.class
            p010C0.AbstractC0147a.m295a(r1, r3)     // Catch: java.lang.Throwable -> Lb3
            monitor-exit(r0)
            return r2
        Lb3:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p117m0.AbstractC1717l.m3808k():m0.r");
    }

    /* JADX INFO: renamed from: l */
    public static void m3809l(C1723r c1723r) {
        if (AbstractC0147a.f354a.contains(AbstractC1717l.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            ObjectOutputStream objectOutputStream = null;
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput("AppEventsLogger.persistedevents", 0)));
                try {
                    objectOutputStream2.writeObject(c1723r);
                    AbstractC2056E.m4535d(objectOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    try {
                        Log.w("m0.l", "Got unexpected exception while persisting events: ", th);
                        try {
                            context.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        } catch (Exception unused) {
                        }
                    } finally {
                        AbstractC2056E.m4535d(objectOutputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            AbstractC0147a.m295a(th3, AbstractC1717l.class);
        }
    }

    /* JADX INFO: renamed from: m */
    public abstract void mo836m(boolean z3);

    /* JADX INFO: renamed from: n */
    public abstract void mo837n(boolean z3);
}
