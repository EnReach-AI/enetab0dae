package p105i;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import p094f.AbstractC1343a;
import p108j.ActionProviderVisibilityListenerC1482p;
import p108j.MenuC1479m;
import p110k.AbstractC1589g0;
import p165z.AbstractC2049e;

/* JADX INFO: renamed from: i.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1442j extends MenuInflater {

    /* JADX INFO: renamed from: e */
    public static final Class[] f5127e;

    /* JADX INFO: renamed from: f */
    public static final Class[] f5128f;

    /* JADX INFO: renamed from: a */
    public final Object[] f5129a;

    /* JADX INFO: renamed from: b */
    public final Object[] f5130b;

    /* JADX INFO: renamed from: c */
    public final Context f5131c;

    /* JADX INFO: renamed from: d */
    public Object f5132d;

    static {
        Class[] clsArr = {Context.class};
        f5127e = clsArr;
        f5128f = clsArr;
    }

    public C1442j(Context context) {
        super(context);
        this.f5131c = context;
        Object[] objArr = {context};
        this.f5129a = objArr;
        this.f5130b = objArr;
    }

    /* JADX INFO: renamed from: a */
    public static Object m3448a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m3448a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [i.j] */
    /* JADX WARN: Type inference failed for: r3v15, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX INFO: renamed from: b */
    public final void m3449b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r4;
        int i3;
        ?? r6;
        ColorStateList colorStateList;
        int resourceId;
        C1441i c1441i = new C1441i(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r4 = 1;
            i3 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z3 = false;
        boolean z4 = false;
        String str = null;
        while (!z3) {
            if (eventType == r4) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i3) {
                if (eventType != 3) {
                    r6 = r4;
                    z3 = z3;
                } else {
                    String name2 = xmlResourceParser.getName();
                    if (z4 && name2.equals(str)) {
                        r6 = r4;
                        z4 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            c1441i.f5102b = 0;
                            c1441i.f5103c = 0;
                            c1441i.f5104d = 0;
                            c1441i.f5105e = 0;
                            c1441i.f5106f = r4;
                            c1441i.f5107g = r4;
                        } else if (name2.equals("item")) {
                            if (!c1441i.f5108h) {
                                ActionProviderVisibilityListenerC1482p actionProviderVisibilityListenerC1482p = c1441i.f5126z;
                                if (actionProviderVisibilityListenerC1482p == null || !actionProviderVisibilityListenerC1482p.f5400a.hasSubMenu()) {
                                    c1441i.f5108h = r4;
                                    c1441i.m3447b(c1441i.f5101a.add(c1441i.f5102b, c1441i.f5109i, c1441i.f5110j, c1441i.f5111k));
                                } else {
                                    c1441i.f5108h = r4;
                                    c1441i.m3447b(c1441i.f5101a.addSubMenu(c1441i.f5102b, c1441i.f5109i, c1441i.f5110j, c1441i.f5111k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            ?? r62 = r4;
                            z3 = r62 == true ? 1 : 0;
                            r6 = r62;
                        }
                        r6 = r4;
                        z3 = z3;
                    }
                }
                eventType = xmlResourceParser.next();
                r4 = r6;
                i3 = 2;
                z3 = z3;
                z4 = z4;
            } else {
                if (!z4) {
                    String name3 = xmlResourceParser.getName();
                    boolean zEquals = name3.equals("group");
                    C1442j c1442j = c1441i.f5100E;
                    if (zEquals) {
                        ?? ObtainStyledAttributes = c1442j.f5131c.obtainStyledAttributes(attributeSet, AbstractC1343a.f4792p);
                        c1441i.f5102b = ObtainStyledAttributes.getResourceId(r4, 0);
                        c1441i.f5103c = ObtainStyledAttributes.getInt(3, 0);
                        c1441i.f5104d = ObtainStyledAttributes.getInt(4, 0);
                        c1441i.f5105e = ObtainStyledAttributes.getInt(5, 0);
                        c1441i.f5106f = ObtainStyledAttributes.getBoolean(2, r4);
                        c1441i.f5107g = ObtainStyledAttributes.getBoolean(0, r4);
                        ObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            Context context = c1442j.f5131c;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4793q);
                            c1441i.f5109i = typedArrayObtainStyledAttributes.getResourceId(2, 0);
                            c1441i.f5110j = (typedArrayObtainStyledAttributes.getInt(5, c1441i.f5103c) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(6, c1441i.f5104d) & 65535);
                            c1441i.f5111k = typedArrayObtainStyledAttributes.getText(7);
                            c1441i.f5112l = typedArrayObtainStyledAttributes.getText(8);
                            c1441i.f5113m = typedArrayObtainStyledAttributes.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes.getString(9);
                            c1441i.f5114n = string == null ? (char) 0 : string.charAt(0);
                            c1441i.f5115o = typedArrayObtainStyledAttributes.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes.getString(10);
                            c1441i.f5116p = string2 == null ? (char) 0 : string2.charAt(0);
                            c1441i.f5117q = typedArrayObtainStyledAttributes.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes.hasValue(11)) {
                                c1441i.f5118r = typedArrayObtainStyledAttributes.getBoolean(11, false) ? 1 : 0;
                            } else {
                                c1441i.f5118r = c1441i.f5105e;
                            }
                            c1441i.f5119s = typedArrayObtainStyledAttributes.getBoolean(3, false);
                            c1441i.f5120t = typedArrayObtainStyledAttributes.getBoolean(4, c1441i.f5106f);
                            c1441i.f5121u = typedArrayObtainStyledAttributes.getBoolean(1, c1441i.f5107g);
                            c1441i.f5122v = typedArrayObtainStyledAttributes.getInt(21, -1);
                            c1441i.f5125y = typedArrayObtainStyledAttributes.getString(12);
                            c1441i.f5123w = typedArrayObtainStyledAttributes.getResourceId(13, 0);
                            c1441i.f5124x = typedArrayObtainStyledAttributes.getString(15);
                            String string3 = typedArrayObtainStyledAttributes.getString(14);
                            boolean z5 = string3 != null;
                            if (z5 && c1441i.f5123w == 0 && c1441i.f5124x == null) {
                                c1441i.f5126z = (ActionProviderVisibilityListenerC1482p) c1441i.m3446a(string3, f5128f, c1442j.f5130b);
                            } else {
                                if (z5) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                c1441i.f5126z = null;
                            }
                            c1441i.f5096A = typedArrayObtainStyledAttributes.getText(17);
                            c1441i.f5097B = typedArrayObtainStyledAttributes.getText(22);
                            if (typedArrayObtainStyledAttributes.hasValue(19)) {
                                c1441i.f5099D = AbstractC1589g0.m3652b(typedArrayObtainStyledAttributes.getInt(19, -1), c1441i.f5099D);
                            } else {
                                c1441i.f5099D = null;
                            }
                            if (typedArrayObtainStyledAttributes.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(18, 0)) == 0 || (colorStateList = AbstractC2049e.m4525c(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes.getColorStateList(18);
                                }
                                c1441i.f5098C = colorStateList;
                            } else {
                                c1441i.f5098C = null;
                            }
                            typedArrayObtainStyledAttributes.recycle();
                            c1441i.f5108h = false;
                            r6 = 1;
                        } else if (name3.equals("menu")) {
                            r6 = 1;
                            c1441i.f5108h = true;
                            SubMenu subMenuAddSubMenu = c1441i.f5101a.addSubMenu(c1441i.f5102b, c1441i.f5109i, c1441i.f5110j, c1441i.f5111k);
                            c1441i.m3447b(subMenuAddSubMenu.getItem());
                            m3449b(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                        } else {
                            r6 = 1;
                            str = name3;
                            z4 = true;
                        }
                        eventType = xmlResourceParser.next();
                        r4 = r6;
                        i3 = 2;
                        z3 = z3;
                        z4 = z4;
                    }
                }
                r6 = r4;
                z3 = z3;
            }
            eventType = xmlResourceParser.next();
            r4 = r6;
            i3 = 2;
            z3 = z3;
            z4 = z4;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i3, Menu menu) {
        if (!(menu instanceof MenuC1479m)) {
            super.inflate(i3, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f5131c.getResources().getLayout(i3);
                    m3449b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (XmlPullParserException e3) {
                    throw new InflateException("Error inflating menu XML", e3);
                }
            } catch (IOException e4) {
                throw new InflateException("Error inflating menu XML", e4);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
