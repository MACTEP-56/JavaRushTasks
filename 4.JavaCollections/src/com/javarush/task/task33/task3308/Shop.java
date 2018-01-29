package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    @XmlElement
    public Goods goods;

    @XmlElement
    public int count;

    @XmlElement
    public double profit;

    @XmlElement
    public String[] secretData;

    public static class Goods {
        @XmlAnyElement
        public List<String> names;
    }
}
