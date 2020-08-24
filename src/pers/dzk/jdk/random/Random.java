package pers.dzk.jdk.random;

import pers.dzk.jdk.dictionaries.Dictionaries;
import pers.dzk.jdk.tool.Tool;
import pers.dzk.jdk.transverter.Transverter;

import java.util.ArrayList;

public class Random {

    private static java.util.Random random_ = new java.util.Random();
    private static StringBuffer sb = new StringBuffer();
    private static java.util.Random random = new java.util.Random();
    private static char[] dict = new Dictionaries().getKey();
    private static Tool orphan = new Tool();

    public static Object[] getArray(Object[] array){
        //这里还有另一种做法核心概念一样但一个是有序随机一个是无序随机，具体步骤：新键一个arraylist，里面存放数组
        // ，然后在该数组内随机删一个值并将该值添加到字符串里，当把arraylist值删完的时候，字符串就是随机数了。
        for (int i = 0;i < array.length;i++){
            int j = getInt(i,array.length-1);
            Object t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
        return array;
    }

    public static int getInt(int min,int max){
        return random_.nextInt(max-min+1)+min;
    }

    public static int[][] getTwoArray(int maxXLength,int minXLength,int maxYLength,int minYLength){
        maxXLength++;
        maxYLength++;
        int[][] a;
        int Y =  random_.nextInt(maxYLength-minYLength)+minYLength;
        a = new int[Y][];
        for (int i = 0;i < Y;i++){
            int X = random_.nextInt(maxXLength-minXLength)+minXLength;
            a[i] = new int[X];
        }
        return a;
    }

    /**
     * 获取随机多少才能出现重复值(平均值)
     * 比如：随机0-100: 第一次 2 第二次 57 第n次 79 第n+1次 2 那么就返回n+1
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static double getCount(int min,int max){
        int[] counts = new int[10000];
        int i = 0;
        while (i < counts.length){
            ArrayList<Integer> list = new ArrayList();
            while (true){
                list.add(Random.getInt(min, max));
                boolean b = false;
                for(int j = list.size()-1-1;j >= 0;j--){
                    if(list.get(list.size()-1) == list.get(j)){
                        b = true;
                    }
                }
                if(b){
                    counts[i] = list.size();
                    i++;
                    break;
                }
            }
        }
        return (double) Tool.sum(counts)/counts.length;
    }

    public static void setDict(char[] dict) throws Exception {
        if (dict == null){
            throw new Exception();
        }else if(!orphan.isNotRepetition(Transverter.toObjectArray(dict))){
            throw new Exception("字典错误：字典内有重复值！");
        }else {
            Random.dict = dict;
        }
    }

    public static String getString(int length){
        for (int i = 0;i < length;i++){
            sb.append(dict[random.nextInt(dict.length)]);
        }
        String str = sb.toString();
        sb.setLength(0);
        return str;
    }

}
