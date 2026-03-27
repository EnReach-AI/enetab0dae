package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.deser.AbstractC1177l;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ext.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1209a extends AbstractC1177l {

    /* JADX INFO: renamed from: e */
    public static final DatatypeFactory f4116e;

    static {
        try {
            f4116e = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e3) {
            throw new RuntimeException(e3);
        }
    }
}
