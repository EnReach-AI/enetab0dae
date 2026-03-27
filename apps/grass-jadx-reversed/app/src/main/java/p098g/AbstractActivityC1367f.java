package p098g;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.AbstractActivityC0947r;
import java.util.ArrayList;
import p020F2.AbstractC0223a;
import p105i.C1442j;
import p105i.C1444l;
import p110k.AbstractC1590g1;
import p110k.C1532G0;
import p110k.C1584e1;
import p110k.C1613r;
import p119m2.AbstractC1766e;
import p128p.C1811e;
import p162y.AbstractC2022a;
import p162y.AbstractC2028g;
import p165z.AbstractC2045a;

/* JADX INFO: renamed from: g.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC1367f extends AbstractActivityC0947r implements InterfaceC1368g {

    /* JADX INFO: renamed from: x */
    public LayoutInflaterFactory2C1382u f4907x;

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3343o();
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        layoutInflaterFactory2C1382u.m3387w();
        ((ViewGroup) layoutInflaterFactory2C1382u.f4956E.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C1382u.f4992q.m3365a(layoutInflaterFactory2C1382u.f4991p.getCallback());
    }

    /* JADX WARN: Removed duplicated region for block: B:167:0x0217 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0  */
    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.AbstractActivityC1367f.attachBaseContext(android.content.Context):void");
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((LayoutInflaterFactory2C1382u) m3342n()).m3371A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((LayoutInflaterFactory2C1382u) m3342n()).m3371A();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i3) {
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        layoutInflaterFactory2C1382u.m3387w();
        return layoutInflaterFactory2C1382u.f4991p.findViewById(i3);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        if (layoutInflaterFactory2C1382u.f4995t == null) {
            layoutInflaterFactory2C1382u.m3371A();
            C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
            layoutInflaterFactory2C1382u.f4995t = new C1442j(c1361g != null ? c1361g.m3327k() : layoutInflaterFactory2C1382u.f4990o);
        }
        return layoutInflaterFactory2C1382u.f4995t;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i3 = AbstractC1590g1.f5638a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        m3342n().mo3350b();
    }

    @Override // androidx.activity.AbstractActivityC0873h
    /* JADX INFO: renamed from: l */
    public final void mo2206l() {
        m3342n().mo3350b();
    }

    /* JADX INFO: renamed from: n */
    public final AbstractC1371j m3342n() {
        if (this.f4907x == null) {
            ExecutorC1355A executorC1355A = AbstractC1371j.f4908e;
            this.f4907x = new LayoutInflaterFactory2C1382u(this, null, this, this);
        }
        return this.f4907x;
    }

    /* JADX INFO: renamed from: o */
    public final void m3343o() {
        getWindow().getDecorView().setTag(io.getgrass.www.R.id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(io.getgrass.www.R.id.view_tree_view_model_store_owner, this);
        View decorView = getWindow().getDecorView();
        AbstractC1766e.m3920e("<this>", decorView);
        decorView.setTag(io.getgrass.www.R.id.view_tree_saved_state_registry_owner, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC1766e.m3920e("<this>", decorView2);
        decorView2.setTag(io.getgrass.www.R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        if (layoutInflaterFactory2C1382u.f4961J && layoutInflaterFactory2C1382u.f4955D) {
            layoutInflaterFactory2C1382u.m3371A();
            C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
            if (c1361g != null) {
                c1361g.m3330n(c1361g.f4842a.getResources().getBoolean(io.getgrass.www.R.bool.abc_action_bar_embed_tabs));
            }
        }
        C1613r c1613rM3680a = C1613r.m3680a();
        Context context = layoutInflaterFactory2C1382u.f4990o;
        synchronized (c1613rM3680a) {
            C1532G0 c1532g0 = c1613rM3680a.f5723a;
            synchronized (c1532g0) {
                C1811e c1811e = (C1811e) c1532g0.f5491b.get(context);
                if (c1811e != null) {
                    c1811e.m4023a();
                }
            }
        }
        layoutInflaterFactory2C1382u.f4973V = new Configuration(layoutInflaterFactory2C1382u.f4990o.getResources().getConfiguration());
        layoutInflaterFactory2C1382u.m3380n(false, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m3342n().mo3352g();
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        Intent intentM467d;
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        layoutInflaterFactory2C1382u.m3371A();
        C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
        if (menuItem.getItemId() == 16908332 && c1361g != null && (((C1584e1) c1361g.f4846e).f5619b & 4) != 0 && (intentM467d = AbstractC0223a.m467d(this)) != null) {
            if (!AbstractC2028g.m4484c(this, intentM467d)) {
                AbstractC2028g.m4483b(this, intentM467d);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentM467d2 = AbstractC0223a.m467d(this);
            if (intentM467d2 == null) {
                intentM467d2 = AbstractC0223a.m467d(this);
            }
            if (intentM467d2 != null) {
                ComponentName component = intentM467d2.getComponent();
                if (component == null) {
                    component = intentM467d2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent intentM468e = AbstractC0223a.m468e(this, component);
                    while (intentM468e != null) {
                        arrayList.add(size, intentM468e);
                        intentM468e = AbstractC0223a.m468e(this, intentM468e.getComponent());
                    }
                    arrayList.add(intentM467d2);
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e3);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            AbstractC2045a.m4512a(this, intentArr, null);
            try {
                AbstractC2022a.m4467a(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((LayoutInflaterFactory2C1382u) m3342n()).m3387w();
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        layoutInflaterFactory2C1382u.m3371A();
        C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
        if (c1361g != null) {
            c1361g.f4861t = true;
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onStart() {
        super.onStart();
        ((LayoutInflaterFactory2C1382u) m3342n()).m3380n(true, false);
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public void onStop() {
        super.onStop();
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3342n();
        layoutInflaterFactory2C1382u.m3371A();
        C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
        if (c1361g != null) {
            c1361g.f4861t = false;
            C1444l c1444l = c1361g.f4860s;
            if (c1444l != null) {
                c1444l.m3450a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
        m3342n().mo3357m(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((LayoutInflaterFactory2C1382u) m3342n()).m3371A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void setContentView(int i3) {
        m3343o();
        m3342n().mo3354j(i3);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i3) {
        super.setTheme(i3);
        ((LayoutInflaterFactory2C1382u) m3342n()).f4975X = i3;
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public void setContentView(View view) {
        m3343o();
        m3342n().mo3355k(view);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3343o();
        m3342n().mo3356l(view, layoutParams);
    }
}
