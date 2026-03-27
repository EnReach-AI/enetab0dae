package p068X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import p001A.C0009j;

/* JADX INFO: renamed from: X.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0698c {

    /* JADX INFO: renamed from: f */
    public static final Object f1898f = new Object();

    /* JADX INFO: renamed from: g */
    public static C0698c f1899g;

    /* JADX INFO: renamed from: a */
    public final Context f1900a;

    /* JADX INFO: renamed from: b */
    public final HashMap f1901b = new HashMap();

    /* JADX INFO: renamed from: c */
    public final HashMap f1902c = new HashMap();

    /* JADX INFO: renamed from: d */
    public final ArrayList f1903d = new ArrayList();

    /* JADX INFO: renamed from: e */
    public final HandlerC0696a f1904e;

    public C0698c(Context context) {
        this.f1900a = context;
        this.f1904e = new HandlerC0696a(this, context.getMainLooper());
    }

    /* JADX INFO: renamed from: a */
    public static C0698c m1678a(Context context) {
        C0698c c0698c;
        synchronized (f1898f) {
            try {
                if (f1899g == null) {
                    f1899g = new C0698c(context.getApplicationContext());
                }
                c0698c = f1899g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0698c;
    }

    /* JADX INFO: renamed from: b */
    public final void m1679b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1901b) {
            try {
                C0697b c0697b = new C0697b(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.f1901b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f1901b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(c0697b);
                for (int i3 = 0; i3 < intentFilter.countActions(); i3++) {
                    String action = intentFilter.getAction(i3);
                    ArrayList arrayList2 = (ArrayList) this.f1902c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f1902c.put(action, arrayList2);
                    }
                    arrayList2.add(c0697b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: c */
    public final void m1680c(Intent intent) {
        ArrayList arrayList;
        int i3;
        String str;
        boolean z3;
        synchronized (this.f1901b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1900a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z4 = true;
                boolean z5 = false;
                byte b3 = (intent.getFlags() & 8) != 0;
                if (b3 != false) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList2 = (ArrayList) this.f1902c.get(intent.getAction());
                if (arrayList2 != null) {
                    if (b3 != false) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                    }
                    ArrayList arrayList3 = null;
                    int i4 = 0;
                    while (i4 < arrayList2.size()) {
                        C0697b c0697b = (C0697b) arrayList2.get(i4);
                        if (b3 != false) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + c0697b.f1894a);
                        }
                        if (c0697b.f1896c) {
                            if (b3 != false) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            arrayList = arrayList2;
                            i3 = i4;
                            str = action;
                            z3 = z4;
                        } else {
                            String str2 = action;
                            arrayList = arrayList2;
                            i3 = i4;
                            str = action;
                            z3 = z4;
                            int iMatch = c0697b.f1894a.match(str2, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (b3 != false) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                }
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(c0697b);
                                c0697b.f1896c = z3;
                            } else if (b3 != false) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                            }
                        }
                        i4 = i3 + 1;
                        z4 = z3;
                        arrayList2 = arrayList;
                        action = str;
                        z5 = false;
                    }
                    boolean z6 = z4;
                    if (arrayList3 != null) {
                        for (int i5 = 0; i5 < arrayList3.size(); i5++) {
                            ((C0697b) arrayList3.get(i5)).f1896c = false;
                        }
                        this.f1903d.add(new C0009j(intent, 13, arrayList3));
                        if (!this.f1904e.hasMessages(z6 ? 1 : 0)) {
                            this.f1904e.sendEmptyMessage(z6 ? 1 : 0);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m1681d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1901b) {
            try {
                ArrayList arrayList = (ArrayList) this.f1901b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C0697b c0697b = (C0697b) arrayList.get(size);
                    c0697b.f1897d = true;
                    for (int i3 = 0; i3 < c0697b.f1894a.countActions(); i3++) {
                        String action = c0697b.f1894a.getAction(i3);
                        ArrayList arrayList2 = (ArrayList) this.f1902c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                C0697b c0697b2 = (C0697b) arrayList2.get(size2);
                                if (c0697b2.f1895b == broadcastReceiver) {
                                    c0697b2.f1897d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f1902c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
