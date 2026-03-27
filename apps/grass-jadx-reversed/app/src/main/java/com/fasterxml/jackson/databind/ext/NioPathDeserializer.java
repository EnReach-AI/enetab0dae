package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p078a1.C0850b;

/* JADX INFO: loaded from: classes.dex */
public class NioPathDeserializer extends StdScalarDeserializer<Path> {
    private static final boolean areWindowsFilePathsSupported;
    private static final long serialVersionUID = 1;

    static {
        File[] fileArrListRoots = File.listRoots();
        int length = fileArrListRoots.length;
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String path = fileArrListRoots[i3].getPath();
            if (path.length() >= 2 && Character.isLetter(path.charAt(0)) && path.charAt(1) == ':') {
                z3 = true;
                break;
            }
            i3++;
        }
        areWindowsFilePathsSupported = z3;
    }

    public NioPathDeserializer() {
        super((Class<?>) Path.class);
    }

    @Override // p069X0.AbstractC0722m
    public Path deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (!abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
            abstractC0718i.m1825C(abstractC0545m, Path.class);
            throw null;
        }
        String strMo1157B = abstractC0545m.mo1157B();
        if (strMo1157B.indexOf(58) < 0) {
            return Paths.get(strMo1157B, new String[0]);
        }
        if (areWindowsFilePathsSupported && strMo1157B.length() >= 2 && Character.isLetter(strMo1157B.charAt(0)) && strMo1157B.charAt(1) == ':') {
            return Paths.get(strMo1157B, new String[0]);
        }
        try {
            URI uri = new URI(strMo1157B);
            try {
                return Paths.get(uri);
            } catch (FileSystemNotFoundException e3) {
                try {
                    String scheme = uri.getScheme();
                    for (FileSystemProvider fileSystemProvider : ServiceLoader.load(FileSystemProvider.class)) {
                        if (fileSystemProvider.getScheme().equalsIgnoreCase(scheme)) {
                            return fileSystemProvider.getPath(uri);
                        }
                    }
                    abstractC0718i.m1859x(handledType(), e3);
                    throw null;
                } catch (ServiceConfigurationError e4) {
                    e4.addSuppressed(e3);
                    abstractC0718i.m1859x(handledType(), e4);
                    throw null;
                }
            } catch (Exception e5) {
                abstractC0718i.m1859x(handledType(), e5);
                throw null;
            }
        } catch (URISyntaxException e6) {
            abstractC0718i.m1859x(handledType(), e6);
            throw null;
        }
    }
}
