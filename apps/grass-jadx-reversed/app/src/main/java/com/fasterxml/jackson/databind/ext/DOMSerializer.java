package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.StringWriter;
import java.lang.reflect.Type;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.C0724o;
import p092e1.InterfaceC1338c;
import p112k1.AbstractC1640h;

/* JADX INFO: loaded from: classes.dex */
public class DOMSerializer extends StdSerializer<Node> {
    protected final TransformerFactory transformerFactory;

    public DOMSerializer() {
        super(Node.class);
        try {
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            this.transformerFactory = transformerFactoryNewInstance;
            transformerFactoryNewInstance.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            setTransformerFactoryAttribute(transformerFactoryNewInstance, "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
            setTransformerFactoryAttribute(transformerFactoryNewInstance, "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        } catch (Exception e3) {
            throw new IllegalStateException("Could not instantiate `TransformerFactory`: " + e3.getMessage(), e3);
        }
    }

    private static void setTransformerFactoryAttribute(TransformerFactory transformerFactory, String str, Object obj) {
        try {
            transformerFactory.setAttribute(str, obj);
        } catch (Exception unused) {
            System.err.println("[DOMSerializer] Failed to set TransformerFactory attribute: " + str);
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Node node, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0724o {
        try {
            Transformer transformerNewTransformer = this.transformerFactory.newTransformer();
            transformerNewTransformer.setOutputProperty("omit-xml-declaration", "yes");
            transformerNewTransformer.setOutputProperty("indent", "no");
            StreamResult streamResult = new StreamResult(new StringWriter());
            transformerNewTransformer.transform(new DOMSource(node), streamResult);
            abstractC0540h.mo1125R(streamResult.getWriter().toString());
        } catch (TransformerConfigurationException e3) {
            throw new IllegalStateException("Could not create XML Transformer for writing DOM `Node` value: " + e3.getMessage(), e3);
        } catch (TransformerException e4) {
            Object[] objArr = {e4.getMessage()};
            abstractC0709K.getClass();
            throw new C0724o(((AbstractC1640h) abstractC0709K).f5838u, String.format("DOM `Node` value serialization failed: %s", objArr), e4);
        }
    }
}
