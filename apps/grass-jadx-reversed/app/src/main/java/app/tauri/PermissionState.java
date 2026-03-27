package app.tauri;

/* JADX INFO: loaded from: classes.dex */
public enum PermissionState {
    f3478g("granted"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("denied"),
    f3479h("prompt"),
    /* JADX INFO: Fake field, exist only in values array */
    EF41("prompt-with-rationale");


    /* JADX INFO: renamed from: f */
    public static final Companion f3477f = new Companion();

    /* JADX INFO: renamed from: e */
    public final String f3481e;

    public static final class Companion {
    }

    PermissionState(String str) {
        this.f3481e = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f3481e;
    }
}
