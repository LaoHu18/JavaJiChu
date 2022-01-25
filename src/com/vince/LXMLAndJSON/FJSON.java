package com.vince.LXMLAndJSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/**JSON数据格式，轻量级的数据交换格式
 *  JSON数据格式的两种结构
 *  1、名称/值对的方式：{"名称"："字符串","名称"：数值}
 *  2、表示数组：{“数组名”:[{"名称"："字符串","名称"：数值},{"名称"："字符串","名称"：数值}]}
 */
public class FJSON {
    public static void main(String[] args) {
        //解析一个json数组
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().
                getResourceAsStream("com/vince/LXMLAndJSON/names.json");
        InputStreamReader isr = new InputStreamReader(resourceAsStream);
        //创建JSON解析对象
        JsonReader reader = new JsonReader(isr);
        ArrayList<Name> nameArrayList = new ArrayList<>();
        try {
            //开始解析数组
            reader.beginArray();
            while(reader.hasNext()){
                nameArrayList.add(parsename(reader));
            }
            //结束解析数组
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(nameArrayList.toArray()));
    }
    //创建一个专门用来解析的方法
    public static Name parsename(JsonReader reader) throws IOException {
        Name name = null;
        //开始解析数组中的对象
        reader.beginObject();
        name = new Name();
        while (reader.hasNext()){
            String attrname = reader.nextName();
            if("firstname".equals(attrname)){
                name.setFirstname(reader.nextString());
            }else if("lastname".equals(attrname)){
                name.setLastname(reader.nextString());
            }else if("email".equals(attrname)){
                name.setEmail(reader.nextString());
            }
        }
        //结束解析数组中的对象
        reader.endObject();
        return name;
    }
    @Test
    //用于将对象生成为json文件
    public void json(){
        //生成一个对象
        ArrayList<Name> nameArrayList = new ArrayList<>();
        nameArrayList.add(new Name("laohu","chibaobao","85564@qq.com"));
        nameArrayList.add(new Name("xiaoxu","nihao","768549@qq.com"));
        //创建一个json数组对象
        JsonArray jsonArray = new JsonArray();
        for(Name name:nameArrayList){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("firstname",name.getFirstname());
            jsonObject.addProperty("lastname",name.getLastname());
            jsonObject.addProperty("email",name.getEmail());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
    }
}
class Name{
    private String firstname;
    private String lastname;
    private String email;

    public Name() {
    }

    public Name(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}