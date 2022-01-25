package com.vince.LXMLAndJSON;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**DOM4J解析XML
 * 1、基于树形结构，第三方组件
 * 2、解析速度快，效率高，使用Java中的迭代器实现数据读取，在web框架中使用较多
 * 3、目前使用较多
 */
public class DDOM4J {
    public static void main(String[] args) throws DocumentException {
        //1、创建DOM4J的解析器对象,生成Document对象
        SAXReader reader = new SAXReader();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/LXMLAndJSON/APeople.xml");
        Document document = reader.read(inputStream);
        //2、通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        //3、创建对象集合、以及空对象，同时创建根元素迭代器
        ArrayList<DPerson> personArrayList = new ArrayList<>();
        DPerson person = null;
        Iterator<Element> elementIterator = rootElement.elementIterator();
        //4、通过迭代器遍历根元素下的元素
        while (elementIterator.hasNext()){
            person = new DPerson();
            //获取根元素下的元素，简称二级元素
            Element next = elementIterator.next();
            person.setId(next.attributeValue("id"));
            //创建第三级元素的迭代器
            Iterator<Element> elementIterator1 = next.elementIterator();
            //遍历其中元素
            while (elementIterator1.hasNext()){
                //获取第三级元素对象
                Element next1 = elementIterator1.next();
                String tag = next1.getName();
                if("name".equals(tag)){
                   person.setName(next1.getText());
                }else if("tel".equals(tag)){
                    person.setTel(next1.getText());
                }else if("fax".equals(tag)){
                    person.setFax(next1.getText());
                }else if("address".equals(tag)){
                    person.setAddress(next1.getText());
                }else if("email".equals(tag)){
                    person.setEmail(next1.getText());
                }
            }
            personArrayList.add(person);
        }
        System.out.println(Arrays.toString(personArrayList.toArray()));
    }
}


class DPerson{
    private String id;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;

    public DPerson() {
    }

    public DPerson(String id, String name, String address, String tel, String fax, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}