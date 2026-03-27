package p044O;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;

/* JADX INFO: renamed from: O.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0564a extends ContentObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC0566c f1369a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0564a(AbstractC0566c abstractC0566c) {
        super(new Handler());
        this.f1369a = abstractC0566c;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z3) {
        Cursor cursor;
        AbstractC0566c abstractC0566c = this.f1369a;
        if (!abstractC0566c.f1373f || (cursor = abstractC0566c.f1374g) == null || cursor.isClosed()) {
            return;
        }
        abstractC0566c.f1372e = abstractC0566c.f1374g.requery();
    }
}
