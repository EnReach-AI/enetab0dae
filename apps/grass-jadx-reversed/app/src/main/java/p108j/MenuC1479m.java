package p108j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p029J.AbstractC0325U;
import p165z.AbstractC2047c;

/* JADX INFO: renamed from: j.m */
/* JADX INFO: loaded from: classes.dex */
public class MenuC1479m implements Menu {

    /* JADX INFO: renamed from: y */
    public static final int[] f5343y = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a */
    public final Context f5344a;

    /* JADX INFO: renamed from: b */
    public final Resources f5345b;

    /* JADX INFO: renamed from: c */
    public boolean f5346c;

    /* JADX INFO: renamed from: d */
    public final boolean f5347d;

    /* JADX INFO: renamed from: e */
    public InterfaceC1477k f5348e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f5349f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f5350g;

    /* JADX INFO: renamed from: h */
    public boolean f5351h;

    /* JADX INFO: renamed from: i */
    public final ArrayList f5352i;

    /* JADX INFO: renamed from: j */
    public final ArrayList f5353j;

    /* JADX INFO: renamed from: k */
    public boolean f5354k;

    /* JADX INFO: renamed from: m */
    public CharSequence f5356m;

    /* JADX INFO: renamed from: n */
    public Drawable f5357n;

    /* JADX INFO: renamed from: o */
    public View f5358o;

    /* JADX INFO: renamed from: v */
    public C1481o f5365v;

    /* JADX INFO: renamed from: x */
    public boolean f5367x;

    /* JADX INFO: renamed from: l */
    public int f5355l = 0;

    /* JADX INFO: renamed from: p */
    public boolean f5359p = false;

    /* JADX INFO: renamed from: q */
    public boolean f5360q = false;

    /* JADX INFO: renamed from: r */
    public boolean f5361r = false;

    /* JADX INFO: renamed from: s */
    public boolean f5362s = false;

    /* JADX INFO: renamed from: t */
    public final ArrayList f5363t = new ArrayList();

    /* JADX INFO: renamed from: u */
    public final CopyOnWriteArrayList f5364u = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: w */
    public boolean f5366w = false;

    public MenuC1479m(Context context) {
        boolean z3 = false;
        this.f5344a = context;
        Resources resources = context.getResources();
        this.f5345b = resources;
        this.f5349f = new ArrayList();
        this.f5350g = new ArrayList();
        this.f5351h = true;
        this.f5352i = new ArrayList();
        this.f5353j = new ArrayList();
        this.f5354k = true;
        if (resources.getConfiguration().keyboard != 1 && AbstractC0325U.m706b(ViewConfiguration.get(context))) {
            z3 = true;
        }
        this.f5347d = z3;
    }

    /* JADX INFO: renamed from: a */
    public final C1481o m3511a(int i3, int i4, int i5, CharSequence charSequence) {
        int i6;
        int i7 = ((-65536) & i5) >> 16;
        if (i7 < 0 || i7 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i8 = (f5343y[i7] << 16) | (65535 & i5);
        C1481o c1481o = new C1481o(this, i3, i4, i5, i8, charSequence, this.f5355l);
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i6 = 0;
                break;
            }
            if (((C1481o) arrayList.get(size)).f5377d <= i8) {
                i6 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i6, c1481o);
        m3518p(true);
        return c1481o;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return m3511a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.f5344a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            C1481o c1481oM3511a = m3511a(i3, i4, i5, resolveInfo.loadLabel(packageManager));
            c1481oM3511a.setIcon(resolveInfo.loadIcon(packageManager));
            c1481oM3511a.f5380g = intent2;
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = c1481oM3511a;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* JADX INFO: renamed from: b */
    public final void m3512b(InterfaceC1492z interfaceC1492z, Context context) {
        this.f5364u.add(new WeakReference(interfaceC1492z));
        interfaceC1492z.mo3506c(context, this);
        this.f5354k = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m3513c(boolean z3) {
        if (this.f5362s) {
            return;
        }
        this.f5362s = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC1492z interfaceC1492z = (InterfaceC1492z) weakReference.get();
            if (interfaceC1492z == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC1492z.mo3478a(this, z3);
            }
        }
        this.f5362s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        C1481o c1481o = this.f5365v;
        if (c1481o != null) {
            mo3491d(c1481o);
        }
        this.f5349f.clear();
        m3518p(true);
    }

    public final void clearHeader() {
        this.f5357n = null;
        this.f5356m = null;
        this.f5358o = null;
        m3518p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        m3513c(true);
    }

    /* JADX INFO: renamed from: d */
    public boolean mo3491d(C1481o c1481o) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
        boolean zMo3508h = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f5365v == c1481o) {
            m3525w();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                InterfaceC1492z interfaceC1492z = (InterfaceC1492z) weakReference.get();
                if (interfaceC1492z != null) {
                    zMo3508h = interfaceC1492z.mo3508h(c1481o);
                    if (zMo3508h) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            m3524v();
            if (zMo3508h) {
                this.f5365v = null;
            }
        }
        return zMo3508h;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo3492e(MenuC1479m menuC1479m, MenuItem menuItem) {
        InterfaceC1477k interfaceC1477k = this.f5348e;
        return interfaceC1477k != null && interfaceC1477k.mo445d(menuC1479m, menuItem);
    }

    /* JADX INFO: renamed from: f */
    public boolean mo3493f(C1481o c1481o) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
        boolean zMo3507e = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        m3525w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC1492z interfaceC1492z = (InterfaceC1492z) weakReference.get();
            if (interfaceC1492z != null) {
                zMo3507e = interfaceC1492z.mo3507e(c1481o);
                if (zMo3507e) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        m3524v();
        if (zMo3507e) {
            this.f5365v = c1481o;
        }
        return zMo3507e;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i3) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1481o c1481o = (C1481o) arrayList.get(i4);
            if (c1481o.f5374a == i3) {
                return c1481o;
            }
            if (c1481o.hasSubMenu() && (menuItemFindItem = c1481o.f5388o.findItem(i3)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public final C1481o m3514g(int i3, KeyEvent keyEvent) {
        ArrayList arrayList = this.f5363t;
        arrayList.clear();
        m3515h(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (C1481o) arrayList.get(0);
        }
        boolean zMo3497n = mo3497n();
        for (int i4 = 0; i4 < size; i4++) {
            C1481o c1481o = (C1481o) arrayList.get(i4);
            char c3 = zMo3497n ? c1481o.f5383j : c1481o.f5381h;
            char[] cArr = keyData.meta;
            if ((c3 == cArr[0] && (metaState & 2) == 0) || ((c3 == cArr[2] && (metaState & 2) != 0) || (zMo3497n && c3 == '\b' && i3 == 67))) {
                return c1481o;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i3) {
        return (MenuItem) this.f5349f.get(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3515h(java.util.List r17, int r18, android.view.KeyEvent r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r16.mo3497n()
            int r4 = r19.getModifiers()
            android.view.KeyCharacterMap$KeyData r5 = new android.view.KeyCharacterMap$KeyData
            r5.<init>()
            boolean r6 = r2.getKeyData(r5)
            r7 = 67
            if (r6 != 0) goto L1e
            if (r1 == r7) goto L1e
            return
        L1e:
            r6 = r16
            java.util.ArrayList r8 = r6.f5349f
            int r9 = r8.size()
            r10 = 0
            r11 = r10
        L28:
            if (r11 >= r9) goto L7a
            java.lang.Object r12 = r8.get(r11)
            j.o r12 = (p108j.C1481o) r12
            boolean r13 = r12.hasSubMenu()
            if (r13 == 0) goto L3b
            j.F r13 = r12.f5388o
            r13.m3515h(r0, r1, r2)
        L3b:
            if (r3 == 0) goto L40
            char r13 = r12.f5383j
            goto L42
        L40:
            char r13 = r12.f5381h
        L42:
            if (r3 == 0) goto L47
            int r14 = r12.f5384k
            goto L49
        L47:
            int r14 = r12.f5382i
        L49:
            r15 = 69647(0x1100f, float:9.7596E-41)
            r7 = r4 & r15
            r14 = r14 & r15
            if (r7 != r14) goto L69
            if (r13 == 0) goto L69
            char[] r7 = r5.meta
            char r14 = r7[r10]
            if (r13 == r14) goto L6c
            r14 = 2
            char r7 = r7[r14]
            if (r13 == r7) goto L6c
            if (r3 == 0) goto L69
            r7 = 8
            if (r13 != r7) goto L69
            r7 = 67
            if (r1 != r7) goto L77
            goto L6e
        L69:
            r7 = 67
            goto L77
        L6c:
            r7 = 67
        L6e:
            boolean r13 = r12.isEnabled()
            if (r13 == 0) goto L77
            r0.add(r12)
        L77:
            int r11 = r11 + 1
            goto L28
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p108j.MenuC1479m.m3515h(java.util.List, int, android.view.KeyEvent):void");
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f5367x) {
            return true;
        }
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((C1481o) arrayList.get(i3)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public final void m3516i() {
        ArrayList arrayListM3517l = m3517l();
        if (this.f5354k) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
            boolean zMo3479d = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                InterfaceC1492z interfaceC1492z = (InterfaceC1492z) weakReference.get();
                if (interfaceC1492z == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zMo3479d |= interfaceC1492z.mo3479d();
                }
            }
            ArrayList arrayList = this.f5352i;
            ArrayList arrayList2 = this.f5353j;
            if (zMo3479d) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListM3517l.size();
                for (int i3 = 0; i3 < size; i3++) {
                    C1481o c1481o = (C1481o) arrayListM3517l.get(i3);
                    if (c1481o.m3529f()) {
                        arrayList.add(c1481o);
                    } else {
                        arrayList2.add(c1481o);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(m3517l());
            }
            this.f5354k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return m3514g(i3, keyEvent) != null;
    }

    /* JADX INFO: renamed from: j */
    public String mo3494j() {
        return "android:menu:actionviewstates";
    }

    /* JADX INFO: renamed from: k */
    public MenuC1479m mo3495k() {
        return this;
    }

    /* JADX INFO: renamed from: l */
    public final ArrayList m3517l() {
        boolean z3 = this.f5351h;
        ArrayList arrayList = this.f5350g;
        if (!z3) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f5349f;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            C1481o c1481o = (C1481o) arrayList2.get(i3);
            if (c1481o.isVisible()) {
                arrayList.add(c1481o);
            }
        }
        this.f5351h = false;
        this.f5354k = true;
        return arrayList;
    }

    /* JADX INFO: renamed from: m */
    public boolean mo3496m() {
        return this.f5366w;
    }

    /* JADX INFO: renamed from: n */
    public boolean mo3497n() {
        return this.f5346c;
    }

    /* JADX INFO: renamed from: o */
    public boolean mo3498o() {
        return this.f5347d;
    }

    /* JADX INFO: renamed from: p */
    public final void m3518p(boolean z3) {
        if (this.f5359p) {
            this.f5360q = true;
            if (z3) {
                this.f5361r = true;
                return;
            }
            return;
        }
        if (z3) {
            this.f5351h = true;
            this.f5354k = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        m3525w();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC1492z interfaceC1492z = (InterfaceC1492z) weakReference.get();
            if (interfaceC1492z == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                interfaceC1492z.mo3480g();
            }
        }
        m3524v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i3, int i4) {
        return m3519q(findItem(i3), null, i4);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        C1481o c1481oM3514g = m3514g(i3, keyEvent);
        boolean zM3519q = c1481oM3514g != null ? m3519q(c1481oM3514g, null, i4) : false;
        if ((i4 & 2) != 0) {
            m3513c(true);
        }
        return zM3519q;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3519q(android.view.MenuItem r7, p108j.InterfaceC1492z r8, int r9) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p108j.MenuC1479m.m3519q(android.view.MenuItem, j.z, int):boolean");
    }

    /* JADX INFO: renamed from: r */
    public final void m3520r(InterfaceC1492z interfaceC1492z) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.f5364u;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            InterfaceC1492z interfaceC1492z2 = (InterfaceC1492z) weakReference.get();
            if (interfaceC1492z2 == null || interfaceC1492z2 == interfaceC1492z) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i3) {
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                i5 = -1;
                break;
            } else if (((C1481o) arrayList.get(i5)).f5375b == i3) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 >= 0) {
            int size2 = arrayList.size() - i5;
            while (true) {
                int i6 = i4 + 1;
                if (i4 >= size2 || ((C1481o) arrayList.get(i5)).f5375b != i3) {
                    break;
                }
                if (i5 >= 0) {
                    ArrayList arrayList2 = this.f5349f;
                    if (i5 < arrayList2.size()) {
                        arrayList2.remove(i5);
                    }
                }
                i4 = i6;
            }
            m3518p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i3) {
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (((C1481o) arrayList.get(i4)).f5374a == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 >= 0) {
            ArrayList arrayList2 = this.f5349f;
            if (i4 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i4);
            m3518p(true);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m3521s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo3494j());
        int size = this.f5349f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC1466F) item.getSubMenu()).m3521s(bundle);
            }
        }
        int i4 = bundle.getInt("android:menu:expandedactionview");
        if (i4 <= 0 || (menuItemFindItem = findItem(i4)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i3, boolean z3, boolean z4) {
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1481o c1481o = (C1481o) arrayList.get(i4);
            if (c1481o.f5375b == i3) {
                c1481o.f5397x = (c1481o.f5397x & (-5)) | (z4 ? 4 : 0);
                c1481o.setCheckable(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.f5366w = z3;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i3, boolean z3) {
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C1481o c1481o = (C1481o) arrayList.get(i4);
            if (c1481o.f5375b == i3) {
                c1481o.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i3, boolean z3) {
        ArrayList arrayList = this.f5349f;
        int size = arrayList.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            C1481o c1481o = (C1481o) arrayList.get(i4);
            if (c1481o.f5375b == i3) {
                int i5 = c1481o.f5397x;
                int i6 = (i5 & (-9)) | (z3 ? 0 : 8);
                c1481o.f5397x = i6;
                if (i5 != i6) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            m3518p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.f5346c = z3;
        m3518p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f5349f.size();
    }

    /* JADX INFO: renamed from: t */
    public final void m3522t(Bundle bundle) {
        int size = this.f5349f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC1466F) item.getSubMenu()).m3522t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo3494j(), sparseArray);
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m3523u(int i3, CharSequence charSequence, int i4, Drawable drawable, View view) {
        if (view != null) {
            this.f5358o = view;
            this.f5356m = null;
            this.f5357n = null;
        } else {
            if (i3 > 0) {
                this.f5356m = this.f5345b.getText(i3);
            } else if (charSequence != null) {
                this.f5356m = charSequence;
            }
            if (i4 > 0) {
                this.f5357n = AbstractC2047c.m4518b(this.f5344a, i4);
            } else if (drawable != null) {
                this.f5357n = drawable;
            }
            this.f5358o = null;
        }
        m3518p(false);
    }

    /* JADX INFO: renamed from: v */
    public final void m3524v() {
        this.f5359p = false;
        if (this.f5360q) {
            this.f5360q = false;
            m3518p(this.f5361r);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m3525w() {
        if (this.f5359p) {
            return;
        }
        this.f5359p = true;
        this.f5360q = false;
        this.f5361r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3) {
        return m3511a(0, 0, 0, this.f5345b.getString(i3));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.f5345b.getString(i3));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return m3511a(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        C1481o c1481oM3511a = m3511a(i3, i4, i5, charSequence);
        SubMenuC1466F subMenuC1466F = new SubMenuC1466F(this.f5344a, this, c1481oM3511a);
        c1481oM3511a.f5388o = subMenuC1466F;
        subMenuC1466F.setHeaderTitle(c1481oM3511a.f5378e);
        return subMenuC1466F;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i3, int i4, int i5, int i6) {
        return m3511a(i3, i4, i5, this.f5345b.getString(i6));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return addSubMenu(i3, i4, i5, this.f5345b.getString(i6));
    }
}
