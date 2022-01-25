package com.vince.LXMLAndJSON;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**使用JDOM进行解析
 *
 */
public class CJDOM {
    public static void main(String[] args) throws IOException, JDOMException {
        //创建JDOM解析器
        SAXBuilder saxBuilder = new SAXBuilder();
        //将配置文件以输入流的形式进行创建
        InputStream inputstream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/LXMLAndJSON/APeople.xml");
        //通过解析器对输入流进行解析生成Document对象
        Document build = saxBuilder.build(inputstream);
        //获取根元素
        Element rootElement = build.getRootElement();
        //创建一个用于存储对象的管理类集合，以及一个空对象
        ArrayList<CPerson> personArrayList = new ArrayList<>();
        CPerson person = null;
        //创建根元素下的子元素集合
        List<Element> children = rootElement.getChildren();
        //遍历子元素
        for(Element element:children){
            person = new CPerson();
            //获取子元素指定内容的解析
            String id = element.getAttributeValue("id");
            person.setId(id);
            //创建子元素下的子元素集合
            List<Element> children1 = element.getChildren();
            //进行遍历
            for (Element element1:children1){
                if("name".equals(element1.getName())){
                    person.setName(element1.getValue());
                }else if("address".equals(element1.getName())){
                    person.setAddress(element1.getValue());
                }else if("tel".equals(element1.getName())){
                    person.setTel(element1.getValue());
                }else if("fax".equals(element1.getName())){
                    person.setFax(element1.getValue());
                }else if("email".equals(element1.getName())){
                    person.setEmail(element1.getValue());
                }
            }
            personArrayList.add(person);
        }
        System.out.println(Arrays.toString(personArrayList.toArray()));
    }
}

class CPerson{
    private String id;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;

    public CPerson() {
    }

    public CPerson(String id, String name, String address, String tel, String fax, String email) {
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