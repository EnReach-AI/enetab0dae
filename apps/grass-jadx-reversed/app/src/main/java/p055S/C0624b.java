package p055S;

import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.C0898e;
import androidx.emoji2.text.C0902i;
import java.nio.ByteBuffer;
import p052R.C0604b;
import p166z0.C2068f;

/* JADX INFO: renamed from: S.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0624b extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a */
    public final TextView f1605a;

    /* JADX INFO: renamed from: b */
    public final C2068f f1606b;

    public C0624b(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        C2068f c2068f = new C2068f(3);
        super(inputConnection, false);
        this.f1605a = textView;
        this.f1606b = c2068f;
        if (C0902i.f2971j != null) {
            C0902i c0902iM2341a = C0902i.m2341a();
            if (c0902iM2341a.m2342b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            C0898e c0898e = c0902iM2341a.f2976e;
            c0898e.getClass();
            Bundle bundle = editorInfo.extras;
            C0604b c0604b = (C0604b) c0898e.f2969c.f6220f;
            int iM843a = c0604b.m843a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iM843a != 0 ? ((ByteBuffer) c0604b.f888d).getInt(iM843a + c0604b.f885a) : 0);
            Bundle bundle2 = editorInfo.extras;
            c0898e.f2967a.getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i3, int i4) {
        Editable editableText = this.f1605a.getEditableText();
        this.f1606b.getClass();
        return C2068f.m4575g(this, editableText, i3, i4, false) || super.deleteSurroundingText(i3, i4);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i3, int i4) {
        Editable editableText = this.f1605a.getEditableText();
        this.f1606b.getClass();
        return C2068f.m4575g(this, editableText, i3, i4, true) || super.deleteSurroundingTextInCodePoints(i3, i4);
    }
}
