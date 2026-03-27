package app.tauri.clipboard;

import app.tauri.clipboard.ReadClipData;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p119m2.AbstractC1764c;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class ReadClipDataSerializer extends StdSerializer<ReadClipData> {
    public ReadClipDataSerializer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ReadClipDataSerializer(Class cls, int i3, AbstractC1764c abstractC1764c) {
        this((i3 & 1) != 0 ? null : cls);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(ReadClipData readClipData, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws Exception {
        AbstractC1766e.m3920e("value", readClipData);
        AbstractC1766e.m3920e("jgen", abstractC0540h);
        AbstractC1766e.m3920e("provider", abstractC0709K);
        abstractC0540h.mo1120M();
        if (!(readClipData instanceof ReadClipData.PlainText)) {
            throw new Exception("unimplemented ReadClipData");
        }
        abstractC0540h.mo1145r("plainText");
        abstractC0540h.mo1120M();
        String str = ((ReadClipData.PlainText) readClipData).f3483a;
        if (str == null) {
            AbstractC1766e.m3924i("text");
            throw null;
        }
        abstractC0540h.mo1145r("text");
        abstractC0540h.mo1125R(str);
        abstractC0540h.mo1143p();
        abstractC0540h.mo1143p();
    }

    public ReadClipDataSerializer(Class<ReadClipData> cls) {
        super(cls);
    }
}
