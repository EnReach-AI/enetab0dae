package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;
import p108j.C1481o;
import p108j.InterfaceC1461A;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC1461A, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: e */
    public C1481o f2664e;

    /* JADX INFO: renamed from: f */
    public ImageView f2665f;

    /* JADX INFO: renamed from: g */
    public RadioButton f2666g;

    /* JADX INFO: renamed from: h */
    public TextView f2667h;

    /* JADX INFO: renamed from: i */
    public CheckBox f2668i;

    /* JADX INFO: renamed from: j */
    public TextView f2669j;

    /* JADX INFO: renamed from: k */
    public ImageView f2670k;

    /* JADX INFO: renamed from: l */
    public ImageView f2671l;

    /* JADX INFO: renamed from: m */
    public LinearLayout f2672m;

    /* JADX INFO: renamed from: n */
    public final Drawable f2673n;

    /* JADX INFO: renamed from: o */
    public final int f2674o;

    /* JADX INFO: renamed from: p */
    public final Context f2675p;

    /* JADX INFO: renamed from: q */
    public boolean f2676q;

    /* JADX INFO: renamed from: r */
    public final Drawable f2677r;

    /* JADX INFO: renamed from: s */
    public final boolean f2678s;

    /* JADX INFO: renamed from: t */
    public LayoutInflater f2679t;

    /* JADX INFO: renamed from: u */
    public boolean f2680u;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C2071i c2071iM4591v = C2071i.m4591v(getContext(), attributeSet, AbstractC1343a.f4794r, R.attr.listMenuViewStyle, 0);
        this.f2673n = c2071iM4591v.m4601l(5);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        this.f2674o = typedArray.getResourceId(1, -1);
        this.f2676q = typedArray.getBoolean(7, false);
        this.f2675p = context;
        this.f2677r = c2071iM4591v.m4601l(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f2678s = typedArrayObtainStyledAttributes.hasValue(0);
        c2071iM4591v.m4608x();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f2679t == null) {
            this.f2679t = LayoutInflater.from(getContext());
        }
        return this.f2679t;
    }

    private void setSubMenuArrowVisible(boolean z3) {
        ImageView imageView = this.f2670k;
        if (imageView != null) {
            imageView.setVisibility(z3 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2671l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2671l.getLayoutParams();
        rect.top = this.f2671l.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // p108j.InterfaceC1461A
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo2221d(p108j.C1481o r11) {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.mo2221d(j.o):void");
    }

    @Override // p108j.InterfaceC1461A
    public C1481o getItemData() {
        return this.f2664e;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(this, this.f2673n);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f2667h = textView;
        int i3 = this.f2674o;
        if (i3 != -1) {
            textView.setTextAppearance(this.f2675p, i3);
        }
        this.f2669j = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f2670k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2677r);
        }
        this.f2671l = (ImageView) findViewById(R.id.group_divider);
        this.f2672m = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        if (this.f2665f != null && this.f2676q) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2665f.getLayoutParams();
            int i5 = layoutParams.height;
            if (i5 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i5;
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setCheckable(boolean z3) {
        CompoundButton compoundButton;
        View view;
        if (!z3 && this.f2666g == null && this.f2668i == null) {
            return;
        }
        if ((this.f2664e.f5397x & 4) != 0) {
            if (this.f2666g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2666g = radioButton;
                LinearLayout linearLayout = this.f2672m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2666g;
            view = this.f2668i;
        } else {
            if (this.f2668i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2668i = checkBox;
                LinearLayout linearLayout2 = this.f2672m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2668i;
            view = this.f2666g;
        }
        if (z3) {
            compoundButton.setChecked(this.f2664e.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f2668i;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f2666g;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z3) {
        CompoundButton compoundButton;
        if ((this.f2664e.f5397x & 4) != 0) {
            if (this.f2666g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2666g = radioButton;
                LinearLayout linearLayout = this.f2672m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2666g;
        } else {
            if (this.f2668i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2668i = checkBox;
                LinearLayout linearLayout2 = this.f2672m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2668i;
        }
        compoundButton.setChecked(z3);
    }

    public void setForceShowIcon(boolean z3) {
        this.f2680u = z3;
        this.f2676q = z3;
    }

    public void setGroupDividerEnabled(boolean z3) {
        ImageView imageView = this.f2671l;
        if (imageView != null) {
            imageView.setVisibility((this.f2678s || !z3) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2664e.f5387n.getClass();
        boolean z3 = this.f2680u;
        if (z3 || this.f2676q) {
            ImageView imageView = this.f2665f;
            if (imageView == null && drawable == null && !this.f2676q) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f2665f = imageView2;
                LinearLayout linearLayout = this.f2672m;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f2676q) {
                this.f2665f.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f2665f;
            if (!z3) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f2665f.getVisibility() != 0) {
                this.f2665f.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f2667h.getVisibility() != 8) {
                this.f2667h.setVisibility(8);
            }
        } else {
            this.f2667h.setText(charSequence);
            if (this.f2667h.getVisibility() != 0) {
                this.f2667h.setVisibility(0);
            }
        }
    }
}
