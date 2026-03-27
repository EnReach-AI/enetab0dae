package p121n0;

import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import p010C0.AbstractC0147a;
import p129p0.AbstractC1823e;

/* JADX INFO: renamed from: n0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1777b {
    /* JADX INFO: renamed from: a */
    public static ArrayList m3932a(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1777b.class)) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList();
            arrayList.add(AbstractC1823e.m4062h(view));
            Object tag = view.getTag();
            if (tag != null) {
                arrayList.add(tag.toString());
            }
            CharSequence contentDescription = view.getContentDescription();
            if (contentDescription != null) {
                arrayList.add(contentDescription.toString());
            }
            try {
                if (view.getId() != -1) {
                    String[] strArrSplit = view.getResources().getResourceName(view.getId()).split("/");
                    if (strArrSplit.length == 2) {
                        arrayList.add(strArrSplit[1]);
                    }
                }
            } catch (Resources.NotFoundException unused) {
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str : arrayList) {
                if (!str.isEmpty() && str.length() <= 100) {
                    arrayList2.add(str.toLowerCase());
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1777b.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static ArrayList m3933b(View view) {
        if (AbstractC0147a.f354a.contains(AbstractC1777b.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (view instanceof EditText) {
                return arrayList;
            }
            if (!(view instanceof TextView)) {
                Iterator it = AbstractC1823e.m4056b(view).iterator();
                while (it.hasNext()) {
                    arrayList.addAll(m3933b((View) it.next()));
                }
                return arrayList;
            }
            String string = ((TextView) view).getText().toString();
            if (!string.isEmpty() && string.length() < 100) {
                arrayList.add(string.toLowerCase());
            }
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1777b.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static boolean m3934c(ArrayList arrayList, ArrayList arrayList2) {
        if (AbstractC0147a.f354a.contains(AbstractC1777b.class)) {
            return false;
        }
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!AbstractC0147a.f354a.contains(AbstractC1777b.class)) {
                    try {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            if (str.contains((String) it2.next())) {
                                return true;
                            }
                        }
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1777b.class);
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1777b.class);
            return false;
        }
    }
}
