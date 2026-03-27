package p110k;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import io.getgrass.www.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
import p044O.AbstractC0566c;
import p044O.C0564a;
import p044O.C0565b;

/* JADX INFO: renamed from: k.U0 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1559U0 extends AbstractC0566c implements View.OnClickListener {

    /* JADX INFO: renamed from: B */
    public static final /* synthetic */ int f5548B = 0;

    /* JADX INFO: renamed from: A */
    public int f5549A;

    /* JADX INFO: renamed from: l */
    public final int f5550l;

    /* JADX INFO: renamed from: m */
    public final int f5551m;

    /* JADX INFO: renamed from: n */
    public final LayoutInflater f5552n;

    /* JADX INFO: renamed from: o */
    public final SearchView f5553o;

    /* JADX INFO: renamed from: p */
    public final SearchableInfo f5554p;

    /* JADX INFO: renamed from: q */
    public final Context f5555q;

    /* JADX INFO: renamed from: r */
    public final WeakHashMap f5556r;

    /* JADX INFO: renamed from: s */
    public final int f5557s;

    /* JADX INFO: renamed from: t */
    public int f5558t;

    /* JADX INFO: renamed from: u */
    public ColorStateList f5559u;

    /* JADX INFO: renamed from: v */
    public int f5560v;

    /* JADX INFO: renamed from: w */
    public int f5561w;

    /* JADX INFO: renamed from: x */
    public int f5562x;

    /* JADX INFO: renamed from: y */
    public int f5563y;

    /* JADX INFO: renamed from: z */
    public int f5564z;

    public ViewOnClickListenerC1559U0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f1373f = true;
        this.f1374g = null;
        this.f1372e = false;
        this.f1375h = -1;
        this.f1376i = new C0564a(this);
        this.f1377j = new C0565b(0, this);
        this.f5551m = suggestionRowLayout;
        this.f5550l = suggestionRowLayout;
        this.f5552n = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f5558t = 1;
        this.f5560v = -1;
        this.f5561w = -1;
        this.f5562x = -1;
        this.f5563y = -1;
        this.f5564z = -1;
        this.f5549A = -1;
        this.f5553o = searchView;
        this.f5554p = searchableInfo;
        this.f5557s = searchView.getSuggestionCommitIconResId();
        this.f5555q = context;
        this.f5556r = weakHashMap;
    }

    /* JADX INFO: renamed from: h */
    public static String m3613h(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e3);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0145  */
    @Override // p044O.AbstractC0566c
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo1241a(android.view.View r22, android.database.Cursor r23) {
        /*
            Method dump skipped, instruction units count: 439
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.ViewOnClickListenerC1559U0.mo1241a(android.view.View, android.database.Cursor):void");
    }

    @Override // p044O.AbstractC0566c
    /* JADX INFO: renamed from: b */
    public final void mo1242b(Cursor cursor) {
        try {
            super.mo1242b(cursor);
            if (cursor != null) {
                this.f5560v = cursor.getColumnIndex("suggest_text_1");
                this.f5561w = cursor.getColumnIndex("suggest_text_2");
                this.f5562x = cursor.getColumnIndex("suggest_text_2_url");
                this.f5563y = cursor.getColumnIndex("suggest_icon_1");
                this.f5564z = cursor.getColumnIndex("suggest_icon_2");
                this.f5549A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e3) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e3);
        }
    }

    @Override // p044O.AbstractC0566c
    /* JADX INFO: renamed from: c */
    public final String mo1243c(Cursor cursor) {
        String strM3613h;
        String strM3613h2;
        if (cursor == null) {
            return null;
        }
        String strM3613h3 = m3613h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (strM3613h3 != null) {
            return strM3613h3;
        }
        SearchableInfo searchableInfo = this.f5554p;
        if (searchableInfo.shouldRewriteQueryFromData() && (strM3613h2 = m3613h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return strM3613h2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (strM3613h = m3613h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return strM3613h;
    }

    @Override // p044O.AbstractC0566c
    /* JADX INFO: renamed from: d */
    public final View mo1244d(ViewGroup viewGroup) {
        View viewInflate = this.f5552n.inflate(this.f5550l, viewGroup, false);
        viewInflate.setTag(new C1557T0(viewInflate));
        ((ImageView) viewInflate.findViewById(R.id.edit_query)).setImageResource(this.f5557s);
        return viewInflate;
    }

    /* JADX INFO: renamed from: e */
    public final Drawable m3614e(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f5555q.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable m3615f(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.ViewOnClickListenerC1559U0.m3615f(java.lang.String):android.graphics.drawable.Drawable");
    }

    /* JADX INFO: renamed from: g */
    public final Cursor m3616g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        builderFragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f5555q.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // p044O.AbstractC0566c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewInflate = this.f5552n.inflate(this.f5551m, viewGroup, false);
            if (viewInflate != null) {
                ((C1557T0) viewInflate.getTag()).f5543a.setText(e3.toString());
            }
            return viewInflate;
        }
    }

    @Override // p044O.AbstractC0566c, android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e3) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e3);
            View viewMo1244d = mo1244d(viewGroup);
            ((C1557T0) viewMo1244d.getTag()).f5543a.setText(e3.toString());
            return viewMo1244d;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f1374g;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f1374g;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f5553o.m2256r((CharSequence) tag);
        }
    }
}
