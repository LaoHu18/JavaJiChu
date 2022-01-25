package com.vince.LXMLAndJSON;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**DOM解析
 * 1、基于树形结构，通过解析器一次性把文档加载到内存中，比较占用内存，可以随机访问
 * 2、更加灵活，更适用于在WEB中开发使用
 */
public class BDOM {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //1、创建一个DOM解析器工厂对象
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //2、通过工厂对象创建解析对象
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //3、解析文档
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/LXMLAndJSON/APeople.xml");
        //此代码完成后，整个XML文档已经被加载到内存中，以树状形式储存
        Document parse = documentBuilder.parse(inputStream);
        //4、从内存中读取对象
        //获取节点名称为person的所有节点，返回节点集合
        NodeList personNodeList = parse.getElementsByTagName("person");
        //创建person集合
        ArrayList<BPerson> personArrayList = new ArrayList<>();
        BPerson person = null;
        //遍历person节点集合
        for (int i = 0; i < personNodeList.getLength(); i++) {
            //创建第i个person节点
            Node personNode = personNodeList.item(i);
            person = new BPerson();
            //获取节点的属性值
            String id = personNode.getAttributes().getNamedItem("id").getNodeValue();
            person.setId(id);
            //获取当前节点的所有子节点
            NodeList childNodes = personNode.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                //创建person节点的第j个子节点,并获取该子节点的名称
                Node item = childNodes.item(j);
                String nodeName = item.getNodeName();
                if("name".equals(nodeName)){
                    person.setName(item.getFirstChild().getNodeValue());
                }else if("address".equals(nodeName)){
                    person.setAddress(item.getFirstChild().getNodeValue());
                }else if("tel".equals(nodeName)){
                    person.setTel(item.getFirstChild().getNodeValue());
                }else if("fax".equals(nodeName)){
                    person.setFax(item.getFirstChild().getNodeValue());
                }else if("email".equals(nodeName)){
                    person.setEmail(item.getFirstChild().getNodeValue());
                }
            }
            personArrayList.add(person);
        }
        System.out.println(Arrays.toString(personArrayList.toArray()));
    }
}

class BPerson{
    private String id;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;

    public BPerson() {
    }

    public BPerson(String id, String name, String address, String tel, String fax, String email) {
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