package com.vince.LXMLAndJSON;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**XML:是一个以文本来描述数据的文档
 *  1、用来保存数据，而且这些数据具有自我描述性
 *  2、它还可以做为项目或者模块的配置文件，充当显示数据
 *  3、还可以做为网络传输数据的格式（现在 JSON 为主）
 *  XML的解析：目前解析可以分为两种：SAX、DOM(DOM JDOM DOM4J)
 *
 *  SAX：用于解析XML
 *  SAX解析特点：
 *  1、基于事件驱动
 *  2、顺序读取，速度快
 *  3、灵活性较差，不能任意读取节点
 *  4、解析时占用的内存小
 *  5、SAX适用于性能要求更高的设备中，如移动开发
 */
public class AXML{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       //SAX解析XML的步骤
        //1、创建一个SAX解析工厂类
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        //2、通过工厂对象创建SAX解析器
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //3、创建一个数据处理器（需要自己编写）
        PersonHandler personHandler = new PersonHandler();
        //4、开始解析数据:首先创读取XML文件的输入流
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/vince/LXMLAndJSON/APeople.xml");
        saxParser.parse(inputStream,personHandler);
        //返回数据处理器中解析后创建的数据集合
        List<Person> personList = personHandler.getPersonList();
        for (Person p:personList){
            System.out.println(p);
        }
    }
}
//创建一个数据处理器
class PersonHandler extends DefaultHandler {
    private List<Person> personList = null;
    private Person person;          //当前解析的对象
    private String tag;             //用于记录当前解析的标签名
    public List<Person> getPersonList(){
        return personList;
    }
    //开始解析文档时调用
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        personList = new ArrayList<>();
        System.out.println("开始解析文档.........");
    }
    //文档解析完成时调用
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("解析文档结束.........");
    }

    /**解析开始元素时调用  <标签名>代表开始，即遇到该类标签名调用此方法
     * @param uri 命名空间
     * @param localName 不带前缀的标签名
     * @param qName 带前缀的标签名
     * @param attributes    当前标签的属性集合
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if("person".equals(qName)){
            person = new Person();
            person.setId(attributes.getValue("id"));
        }
        tag = qName;
    }
    //解析结束元素时调用     </标签名>代表结束，即遇到该类标签名调用此方法
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if("person".equals(qName)){
            personList.add(person);
        }
        tag = null;
    }
    //解析文本内容时调用，即解析<标签名>.....</标签名>中间的内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(tag != null){
            if("name".equals(tag)){
                person.setName(new String(ch,start,length));
            }else if ("address".equals(tag)){
                person.setAddress(new String(ch,start,length));
            }else if ("tel".equals(tag)){
                person.setTel(new String(ch,start,length));
            }else if ("fax".equals(tag)){
                person.setFax(new String(ch,start,length));
            }else if ("email".equals(tag)){
                person.setEmail(new String(ch,start,length));
            }
        }
    }
}

class Person{
    private String id;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;

    public Person() {
    }

    public Person(String id, String name, String address, String tel, String fax, String email) {
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