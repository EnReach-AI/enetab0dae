package p117m0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: renamed from: m0.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1716k extends ObjectInputStream {
    @Override // java.io.ObjectInputStream
    public final ObjectStreamClass readClassDescriptor() throws ClassNotFoundException, IOException {
        ObjectStreamClass classDescriptor = super.readClassDescriptor();
        return classDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1") ? ObjectStreamClass.lookup(C1706a.class) : classDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(AbstractC1709d.class) : classDescriptor;
    }
}
