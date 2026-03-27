package p021G;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.C1107d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p001A.AbstractC0001b;
import p005B.AbstractC0032g;
import p015D2.C0192p;

/* JADX INFO: renamed from: G.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0228e {

    /* JADX INFO: renamed from: a */
    public static final C0226c f544a = new C0226c();

    /* JADX INFO: renamed from: a */
    public static C0192p m473a(Context context, C1107d c1107d) {
        Cursor cursorM472a;
        PackageManager packageManager = context.getPackageManager();
        Resources resources = context.getResources();
        String str = (String) c1107d.f3847b;
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException(AbstractC0032g.m152j("No package found for authority: ", str));
        }
        String str2 = providerInfoResolveContentProvider.packageName;
        String str3 = (String) c1107d.f3848c;
        if (!str2.equals(str3)) {
            throw new PackageManager.NameNotFoundException(AbstractC0032g.m155m("Found content provider ", str, ", but package was not ", str3));
        }
        Signature[] signatureArr = packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures;
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        C0226c c0226c = f544a;
        Collections.sort(arrayList, c0226c);
        List listM9j = (List) c1107d.f3850e;
        if (listM9j == null) {
            listM9j = AbstractC0001b.m9j(resources, 0);
        }
        int i3 = 0;
        loop1: while (true) {
            cursorM472a = null;
            if (i3 >= listM9j.size()) {
                providerInfoResolveContentProvider = null;
                break;
            }
            ArrayList arrayList2 = new ArrayList((Collection) listM9j.get(i3));
            Collections.sort(arrayList2, c0226c);
            if (arrayList.size() == arrayList2.size()) {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    if (!Arrays.equals((byte[]) arrayList.get(i4), (byte[]) arrayList2.get(i4))) {
                        break;
                    }
                }
                break loop1;
            }
            i3++;
        }
        if (providerInfoResolveContentProvider == null) {
            return new C0192p(1, 1, null);
        }
        String str4 = providerInfoResolveContentProvider.authority;
        ArrayList arrayList3 = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str4).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str4).appendPath("file").build();
        try {
            cursorM472a = AbstractC0227d.m472a(context.getContentResolver(), uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{(String) c1107d.f3849d}, null, null);
            if (cursorM472a != null && cursorM472a.getCount() > 0) {
                int columnIndex = cursorM472a.getColumnIndex("result_code");
                arrayList3 = new ArrayList();
                int columnIndex2 = cursorM472a.getColumnIndex("_id");
                int columnIndex3 = cursorM472a.getColumnIndex("file_id");
                int columnIndex4 = cursorM472a.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorM472a.getColumnIndex("font_weight");
                int columnIndex6 = cursorM472a.getColumnIndex("font_italic");
                while (cursorM472a.moveToNext()) {
                    arrayList3.add(new C0233j(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorM472a.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorM472a.getLong(columnIndex3)), columnIndex4 != -1 ? cursorM472a.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorM472a.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorM472a.getInt(columnIndex6) == 1, columnIndex != -1 ? cursorM472a.getInt(columnIndex) : 0));
                }
            }
            if (cursorM472a != null) {
                cursorM472a.close();
            }
            return new C0192p(0, 1, (C0233j[]) arrayList3.toArray(new C0233j[0]));
        } catch (Throwable th) {
            if (cursorM472a != null) {
                cursorM472a.close();
            }
            throw th;
        }
    }
}
