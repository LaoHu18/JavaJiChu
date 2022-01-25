package com.vince.NJAVASE_Exemple.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.vince.NJAVASE_Exemple.bean.Clothes;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析产品xml
 */
public class ProductsXmlutils {
    public static List<Clothes> parserProductsXmlutils(){
        List<Clothes> products = new ArrayList<>();
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("products.xml"));
            xStream.allowTypes(new Class[]{Clothes.class});
            products = (List<Clothes>)xStream.fromXML(bufferedInputStream);
            bufferedInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void writeProductXml(List<Clothes> products){
        XStream xStream = new XStream(new Xpp3Driver());
        xStream.alias("list",products.getClass());
        xStream.alias("clothes",Clothes.class);
        xStream.useAttributeFor(Clothes.class,"id");
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("products.xml"));
            bufferedOutputStream.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>".getBytes());
            xStream.toXML(products,bufferedOutputStream);
            bufferedOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
