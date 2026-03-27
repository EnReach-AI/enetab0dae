package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import p005B.AbstractC0032g;
import p165z.AbstractC2046b;
import p165z.AbstractC2050f;
import p165z.C2051g;

/* JADX INFO: loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: f */
    public static final String[] f2917f = {"_display_name", "_size"};

    /* JADX INFO: renamed from: g */
    public static final File f2918g = new File("/");

    /* JADX INFO: renamed from: h */
    public static final HashMap f2919h = new HashMap();

    /* JADX INFO: renamed from: e */
    public C2051g f2920e;

    /* JADX INFO: renamed from: a */
    public static C2051g m2314a(Context context, String str) {
        C2051g c2051gM2315b;
        HashMap map = f2919h;
        synchronized (map) {
            try {
                c2051gM2315b = (C2051g) map.get(str);
                if (c2051gM2315b == null) {
                    try {
                        try {
                            c2051gM2315b = m2315b(context, str);
                            map.put(str, c2051gM2315b);
                        } catch (XmlPullParserException e3) {
                            throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e3);
                        }
                    } catch (IOException e4) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2051gM2315b;
    }

    /* JADX INFO: renamed from: b */
    public static C2051g m2315b(Context context, String str) throws XmlPullParserException, IOException {
        C2051g c2051g = new C2051g(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException(AbstractC0032g.m152j("Couldn't find meta-data for provider with authority ", str));
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return c2051g;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f2918g;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrM4515b = AbstractC2046b.m4515b(context, null);
                    if (fileArrM4515b.length > 0) {
                        externalStorageDirectory = fileArrM4515b[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrM4514a = AbstractC2046b.m4514a(context);
                    if (fileArrM4514a.length > 0) {
                        externalStorageDirectory = fileArrM4514a[0];
                    }
                } else if ("external-media-path".equals(name)) {
                    File[] fileArrM4526a = AbstractC2050f.m4526a(context);
                    if (fileArrM4526a.length > 0) {
                        externalStorageDirectory = fileArrM4526a[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    String[] strArr = {attributeValue2};
                    for (int i3 = 0; i3 < 1; i3++) {
                        String str2 = strArr[i3];
                        if (str2 != null) {
                            externalStorageDirectory = new File(externalStorageDirectory, str2);
                        }
                    }
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        c2051g.f7255b.put(attributeValue, externalStorageDirectory.getCanonicalFile());
                    } catch (IOException e3) {
                        throw new IllegalArgumentException("Failed to resolve canonical path for " + externalStorageDirectory, e3);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        HashMap map = f2919h;
        synchronized (map) {
            map.remove(str);
        }
        this.f2920e = m2314a(context, str);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return this.f2920e.m4527a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        File fileM4527a = this.f2920e.m4527a(uri);
        int iLastIndexOf = fileM4527a.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileM4527a.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) {
        int i3;
        File fileM4527a = this.f2920e.m4527a(uri);
        if ("r".equals(str)) {
            i3 = 268435456;
        } else if ("w".equals(str) || "wt".equals(str)) {
            i3 = 738197504;
        } else if ("wa".equals(str)) {
            i3 = 704643072;
        } else if ("rw".equals(str)) {
            i3 = 939524096;
        } else {
            if (!"rwt".equals(str)) {
                throw new IllegalArgumentException(AbstractC0032g.m152j("Invalid mode: ", str));
            }
            i3 = 1006632960;
        }
        return ParcelFileDescriptor.open(fileM4527a, i3);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        File fileM4527a = this.f2920e.m4527a(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = f2917f;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i4 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i4] = "_display_name";
                i3 = i4 + 1;
                objArr[i4] = queryParameter == null ? fileM4527a.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i4] = "_size";
                i3 = i4 + 1;
                objArr[i4] = Long.valueOf(fileM4527a.length());
            }
            i4 = i3;
        }
        String[] strArr4 = new String[i4];
        System.arraycopy(strArr3, 0, strArr4, 0, i4);
        Object[] objArr2 = new Object[i4];
        System.arraycopy(objArr, 0, objArr2, 0, i4);
        MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
        matrixCursor.addRow(objArr2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
