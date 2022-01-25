package com.vince.KEnum;

import org.junit.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**枚举
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只一个对象，则可以作为单例模式的实现方式。
 */
public class AEnum {
    public static void main(String[] args) {
        //创建对象只能从现有的枚举类中进行选择
        Color color = Color.BLACK;
        System.out.println(color.getcolor());
        System.out.println(color.name());           //获取枚举的名字
        System.out.println(color.ordinal());      //获取枚举的序号

        Color color1 = Color.RED;
        System.out.println(color1.getcolor());          //优先使用定义的重写方法

        //获取枚举中的所有定义变量
        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));            //以数组形式输出所有枚举定义变量
        //使用forEach方法输出定义变量名字
        for(Color v:values){
            System.out.println(v.name());
        }
    }
    @Test
    //用于操作枚举变量的集合EnumSet、EnumMap
    public void test(){
        //创建一个包含指定元素类型的所有元素的枚举 set。
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        for (Color color:enumSet){
            System.out.println(color.getcolor());
        }
        //创建一个key为枚举元素，value自定义的EnumMap
        EnumMap<Color,String> enumMap = new EnumMap<Color, String>(Color.class);
        enumMap.put(Color.RED,"red");
        enumMap.put(Color.GREEN,"green");
        System.out.println(enumMap.get(Color.GREEN));
    }
}

interface Info{
    public String getcolor();
}

//使用关键字定义枚举类
enum Color implements Info{
    //1.提供当前枚举类的对象，多个对象之间用","隔开，末尾对象";"结束
    //2、枚举对象必须放在枚举类的行首.
    RED("this is red"){
        @Override       //可以自定义重写方法
        public String getcolor() {
            return "this is red1";
        }
    },
    GREEN("this is green"),
    BLACK("this is black");
    private String color;
    private Color() {}
    private Color(String color){
        this.color = color;
    }

    @Override
    public String getcolor() {
        return color;
    }
}