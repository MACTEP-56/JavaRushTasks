package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringWriter;

/*
Комментарий внутри xml
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj,writer);

        String result = writer.toString();
        String cdata = "<" + result.substring(result.indexOf("![CDATA["), result.indexOf("]]")) + ">";

        if (result.contains("<" + tagName)) {
            result = result.
                    replace("<" + tagName, "<!--" + comment + "-->\n\t" + "<" + tagName).
                    replace("&gt;", ">").
                    replace("&lt;", "<").
                    replace(result.substring(result.indexOf("![CDATA["), result.indexOf("]]")), cdata).
                    replace("standalone=\"yes\"?>", "standalone=\"no\"?>");
//                    replaceAll("<second></second>");

        }
        return result;
    }

    public static void main(String[] args) throws JAXBException {
        First first = new First();
        first.second = new String[]{"some string", "some string", "![CDATA[need CDATA <second> because of < and >]]", ""};
        System.out.println(toXmlWithComment(first, "second", "it's a comment"));
    }
}

@XmlType(name = "first")
@XmlRootElement
class First {
    @XmlElement
    public String[] second;
}