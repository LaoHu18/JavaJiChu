package com.vince.BObject;

import java.util.Arrays;

/**面向对象三大特征之一：继承
 * 就是子类继承父类的属性和行为，使得子类对象具有与父类相同的属性、相同的行为。子类可以直接 访问父类中的非私有的属性和行为。
 */
public class CInheritance {
    public static void main(String[] args) {
        CosmeticManager CM = new CosmeticManager();
        CM.add(new Cosmetic("香奈儿","进口",1000));
        CM.add(new Cosmetic("圣罗兰","进口",500));
        CM.add(new Cosmetic("花西子","国产",400));
        CM.add(new Cosmetic("SOD蜜","国产",50));
        CM.PrintAll();

        System.out.println("排序后的输出为");
        SortCosmeticManager CM1 = new SortCosmeticManager();
        CM1.add(new Cosmetic("香奈儿","进口",1000));
        CM1.add(new Cosmetic("圣罗兰","进口",500));
        CM1.add(new Cosmetic("花西子","国产",400));
        CM1.add(new Cosmetic("SOD蜜","国产",50));
        CM1.PrintPaixu();
    }
}
//定义一个化妆品类
class Cosmetic{
    private String name;
    private String type;
    private int price;
    public Cosmetic(){}
    public Cosmetic(String name,String type,int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getPrice(){
        return price;
    }
}

//定义一个化妆品管理类
class CosmeticManager{
    protected Cosmetic[] CS = new Cosmetic[4];			//访问私有变量的两种方法：将private改为protected，或者在父类中设置一个get函数，在子类中直接调用
    private int count = 0;
    //实现进货功能
    public void add(Cosmetic cs){
        if(count>=CS.length){
            int newlength = CS.length*2;
            CS = Arrays.copyOf(CS,newlength);
        }
        CS[count] = cs;
        count++;
    }
    //实现输出所有化妆品信息
    public void PrintAll(){
        for(int i=0;i<count;i++){
            System.out.println("化妆品名字为："+CS[i].getName()+",类型为："+CS[i].getType()+"价格为："+CS[i].getPrice());
        }
    }
    public int getCount(){
        return count;
    }
}

//定义使用继承实现一个可按单价排序输出所有化妆品的功能
class SortCosmeticManager extends CosmeticManager{
    //排序输出所有产品
    public void PrintPaixu(){
        Cosmetic[] temp = Arrays.copyOf(CS,getCount());
        for(int i=0;i<temp.length-1;i++){
            for(int j=0;j<temp.length-1-i;j++){
                if(temp[j].getPrice()>temp[j+1].getPrice()){
                    Cosmetic a = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = a;
                }
            }
        }
        for(int i= 0;i<temp.length;i++){
            System.out.println("排序后的化妆品名字为："+temp[i].getName()+",类型为："+temp[i].getType()+"价格为："+temp[i].getPrice());
        }
    }
}

//定义使用继承实现只输出进口化妆品的功能
class ImportCosmeticManager extends CosmeticManager{
    public void PrintImpot(){
        for(int i=0;i<getCount();i++){
            if("进口".equals(CS[i].getType())){
                System.out.println("进口化妆品名字为："+CS[i].getName()+",类型为："+CS[i].getType()+"价格为："+CS[i].getPrice());
            }
        }
    }
}