package p044O;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import p110k.ViewOnClickListenerC1559U0;

/* JADX INFO: renamed from: O.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0566c extends BaseAdapter implements Filterable, InterfaceC0567d {

    /* JADX INFO: renamed from: e */
    public boolean f1372e;

    /* JADX INFO: renamed from: f */
    public boolean f1373f;

    /* JADX INFO: renamed from: g */
    public Cursor f1374g;

    /* JADX INFO: renamed from: h */
    public int f1375h;

    /* JADX INFO: renamed from: i */
    public C0564a f1376i;

    /* JADX INFO: renamed from: j */
    public C0565b f1377j;

    /* JADX INFO: renamed from: k */
    public C0568e f1378k;

    /* JADX INFO: renamed from: a */
    public abstract void mo1241a(View view, Cursor cursor);

    /* JADX INFO: renamed from: b */
    public void mo1242b(Cursor cursor) {
        Cursor cursor2 = this.f1374g;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0564a c0564a = this.f1376i;
                if (c0564a != null) {
                    cursor2.unregisterContentObserver(c0564a);
                }
                C0565b c0565b = this.f1377j;
                if (c0565b != null) {
                    cursor2.unregisterDataSetObserver(c0565b);
                }
            }
            this.f1374g = cursor;
            if (cursor != null) {
                C0564a c0564a2 = this.f1376i;
                if (c0564a2 != null) {
                    cursor.registerContentObserver(c0564a2);
                }
                C0565b c0565b2 = this.f1377j;
                if (c0565b2 != null) {
                    cursor.registerDataSetObserver(c0565b2);
                }
                this.f1375h = cursor.getColumnIndexOrThrow("_id");
                this.f1372e = true;
                notifyDataSetChanged();
            } else {
                this.f1375h = -1;
                this.f1372e = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract String mo1243c(Cursor cursor);

    /* JADX INFO: renamed from: d */
    public abstract View mo1244d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f1372e || (cursor = this.f1374g) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f1372e) {
            return null;
        }
        this.f1374g.moveToPosition(i3);
        if (view == null) {
            ViewOnClickListenerC1559U0 viewOnClickListenerC1559U0 = (ViewOnClickListenerC1559U0) this;
            view = viewOnClickListenerC1559U0.f5552n.inflate(viewOnClickListenerC1559U0.f5551m, viewGroup, false);
        }
        mo1241a(view, this.f1374g);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f1378k == null) {
            C0568e c0568e = new C0568e();
            c0568e.f1379a = this;
            this.f1378k = c0568e;
        }
        return this.f1378k;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        Cursor cursor;
        if (!this.f1372e || (cursor = this.f1374g) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f1374g;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        Cursor cursor;
        if (this.f1372e && (cursor = this.f1374g) != null && cursor.moveToPosition(i3)) {
            return this.f1374g.getLong(this.f1375h);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f1372e) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f1374g.moveToPosition(i3)) {
            throw new IllegalStateException("couldn't move cursor to position " + i3);
        }
        if (view == null) {
            view = mo1244d(viewGroup);
        }
        mo1241a(view, this.f1374g);
        return view;
    }
}
