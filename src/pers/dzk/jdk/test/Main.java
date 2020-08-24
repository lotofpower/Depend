package pers.dzk.jdk.test;

import pers.dzk.jdk.file.Img;
import pers.dzk.jdk.password.Encryption;
import pers.dzk.jdk.random.Random;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import pers.dzk.jdk.math.Math;
import pers.dzk.jdk.tool.Tool;
import pers.dzk.jdk.password.Password;
import pers.dzk.jdk.serializable.Serializable;
import pers.dzk.jdk.transverter.Transverter;

public class Main {

    public static void main(String[] args) {
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public final static void Encryption(){
        String txt = "https://www.baidu.com/";
        System.out.println("原始数据："+txt);
        String txt2 = Encryption.encryption(txt);
        System.out.println("加密后："+txt2);
        System.out.println("解密后："+ Encryption.decode(txt2));
    }

    public final static void Img_toString() throws IOException {
        String imgPath = "C:\\Users\\Administrator\\Desktop\\ins\\insect fuck girl xx ";
        String txtPath = "D:\\Element\\txt\\test\\";
        String fileName = "000";
        int maxCount = 10;
        for (int i = 1;i <= 4833;i++){
            if(i == maxCount){
                maxCount*=10;
                fileName = fileName.substring(1);
            }
            String imgPath2 = imgPath+fileName+i+".jpg";
            String txtPath2 = txtPath+i+".txt";
            System.out.println(imgPath2);
            Img.toString(imgPath2,txtPath2);
        }
    }

    public final static void Math_split(){
        for (int z = 50;z < 1000;z+=50){
            System.out.println("****"+z+"的组合"+"****");
            int[][] list = Tool.multiplicationSplit(z);
            Tool.println(list);
        }
    }


    public final static void CreatureSwap_toIntArray() throws Exception {
        int[] ar = Transverter.toIntArray(new char[]{'8','9','a','B'});
        for (int i:ar) {
            System.out.println(i);
        }
    }

    public final static void Password() throws Exception {
        Password password = new Password(new char[]{'0','1'},4);
        String[] str = password.getList();
        for (int i = 0;i < str.length;i++){
            System.out.println(str[i]);
        }
    }

    public final static void Random_getArray(){
        for (int i = 0;i < 100;i++){
            int[] array = Transverter.toIntArray(Random.getArray(Transverter.toObjectArray(new int[]{1,2,3})));
            for (int j = 0;j < array.length;j++){
                System.out.print(array[j]);
            }
            System.out.println();
        }
    }

    public final static void Math_factorial(){
        Math math = new Math();
        System.out.println(math.factorial(3));
    }

    public final static void Math_fibonacciSequence(){
        Math math = new Math();
        int[] array = math.fibonacciSequence(1,500);
            for (int i = 0;i < array.length;i++){
            System.out.println("["+i+"]"+array[i]);
            if(i>0){
                System.out.println("前后值比："+(double)array[i-1]/(double)array[i]);
            }
        }

    }
    public final static void Math_reversalTwo(){
        Object[] array = Tool.reversalTwo(new Object[]{1,2,3,4,5,6,7,8});
        for (Object i:
                array) {
            System.out.println("array："+i);
        }
    }

    public final static void SerializableTool() throws IOException, ClassNotFoundException {
        Person ps = new Person();
        ps.setAge(18);
        ps.setName("张三");
        Serializable.Serialize("G:\\Guest\\out.txt",ps);
        Person ps2 = (Person) Serializable.Deserialization("G:\\Guest\\out.txt");
        System.out.println(ps2.toString());
    }


}