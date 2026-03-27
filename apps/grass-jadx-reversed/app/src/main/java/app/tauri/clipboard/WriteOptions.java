package app.tauri.clipboard;

import app.tauri.annotation.InvokeArg;
import p071Y0.InterfaceC0742f;
import p119m2.AbstractC1764c;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0742f(using = WriteOptionsDeserializer.class)
@InvokeArg
public abstract class WriteOptions {

    @InterfaceC0742f
    public static final class PlainText extends WriteOptions {
        private String label;
        public String text;

        public PlainText() {
            super(null);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getText() {
            String str = this.text;
            if (str != null) {
                return str;
            }
            AbstractC1766e.m3924i("text");
            throw null;
        }

        public final void setLabel(String str) {
            this.label = str;
        }

        public final void setText(String str) {
            AbstractC1766e.m3920e("<set-?>", str);
            this.text = str;
        }
    }

    public /* synthetic */ WriteOptions(AbstractC1764c abstractC1764c) {
        this();
    }

    private WriteOptions() {
    }
}
