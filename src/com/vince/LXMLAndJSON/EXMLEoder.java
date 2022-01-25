package com.vince.LXMLAndJSON;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3DomDriver;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**将对象转换为XML写入文件
 *  使用第三方的xstream组件实现xml的解析与写入
 *  可以快速的在xml文件与对象之间进行转换，适合以xml为信息传输格式时使用
 */
public class EXMLEoder {
    public static void main(String[] args) {
        //将对象转换为xml信息
        EPerson person = new EPerson("123456","bin","beijing",
                "17371608513","789456","237576856@qq.com");
        XStream xStream = new XStream(new Xpp3Driver());
        //设置过滤，设置根节点名称
        xStream.alias("person",EPerson.class);
        //将其中某一节点作为根节点的属性
        xStream.useAttributeFor(EPerson.class,"id");
        //转换为xml格式，并通过输出流写入文件
        String s = xStream.toXML(person);
        try {
            FileOutputStream out = new FileOutputStream(new File(
                    "D:\\java\\daima\\JiChuZongJie\\src\\com\\vince\\LXMLAndJSON\\person.xml"),false);
            out.write(s.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入完成");

        //从文件中读取xml信息
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/vince/LXMLAndJSON/person.xml");
        //直接读取时会存在类转换异常，需要设置允许类进行转换
        xStream.allowTypes(new Class[]{EPerson.class});
        EPerson person1 = (EPerson) xStream.fromXML(resourceAsStream);
        System.out.println(person1);
    }
}
class EPerson{
    private String id;
    private String name;
    private String address;
    private String tel;
    private String fax;
    private String email;

    public EPerson() {
    }

    public EPerson(String id, String name, String address, String tel, String fax, String email) {
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