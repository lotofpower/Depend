package pers.dzk.jdk.transverter;

import pers.dzk.jdk.tool.Tool;
import pers.dzk.jdk.math.Math;

import java.util.ArrayList;

public class Transverter {

    public static int[] toIntArray(char[] array) throws Exception {
        int[] toInt = new int[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i] >= '0' && array[i] <= '9'){
                toInt[i] = array[i]-'0';
            }else if(array[i] >= 'A' && array[i] <= 'Z'){
                toInt[i] = array[i] - 'A' +10;
            }else if(array[i] >= 'a' && array[i] <= 'z' ){
                toInt[i] = array[i] - 'a' +10;
            } else {
                throw new Exception("只支持a-z,A-Z,0-9");
            }
        }
        return toInt;
    }

    public static Object[] toObjectArray(char[] array){
        Object[] toInt = new Object[array.length];
        for(int i=0;i<array.length;i++){
            toInt[i] = array[i];
        }
        return toInt;
    }

    public static int[] toIntArray(Object[] array){
        int[] toInt = new int[array.length];
        for(int i=0;i<array.length;i++){
            toInt[i] = Integer.parseInt(String.valueOf(array[i]));
        }
        return toInt;
    }

    public static Object[] toObjectArray(int[] array){
        Object[] toInt = new Object[array.length];
        for(int i=0;i<array.length;i++){
            toInt[i] = array[i];
        }
        return toInt;
    }
    public static char[] toCharArray(Object[] array){
        char[] toInt = new char[array.length];
        for(int i=0;i<array.length;i++){
            toInt[i] = (char)array[i];
        }
        return toInt;
    }

    public static int[] toIntArray(ArrayList<Integer> array){
        int[] a = new int[array.size()];
        for (int i = 0;i < array.size();i++){
            a[i] = array.get(i);
        }
        return a;
    }

    public static int[][] toTowIntArray(ArrayList<int[]> list){
        int[][] a = new int[list.size()][list.get(0).length];
        for (int i = 0;i < a.length;i++){
            for (int j = 0;j < list.get(0).length;j++){
                a[i][j] = list.get(i)[j];
            }
        }
        return a;
    }

    public static int[] toIntArray(int number){
        int l = Tool.getLength(number);
        int[] a = new int[l];
        for (int i = Math.pow(10,l-1), j = 0; j < a.length; i/=10,j++){
            a[j] = number/i%10;
        }
        return a;
    }

    public static int toInt(int[] number){
        int number2 = 0;
        for (int i = 0;i < number.length-1;i++){
            number2 += number[i]* Math.pow(10,number.length-i-1);
        }
        number2+=number[number.length-1];
        return number2;
    }

}
