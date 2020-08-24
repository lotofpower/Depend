package pers.dzk.jdk.math;

import pers.dzk.jdk.transverter.Transverter;
import pers.dzk.jdk.tool.Tool;

import java.util.ArrayList;

public class Math {

    private int[] fibonacciCache = null;

    /**
     * 计算斐波纳契数列
     * @param min 最小值
     * @param max 最大值
     * @return 一组斐波纳契数列
     */
    public static int[] fibonacciSequence(int min,int max){
        ArrayList<Integer> array = new ArrayList<>();
        return fibonacciSequence(min,max,array);
    }

    private static int[] fibonacciSequence(int min,int max,ArrayList<Integer> array){
        if(array.size() == 0){
            array.add(min);
            array.add(min);
        }
        if(array.get(array.size()-1) + array.get(array.size()-2) > max) {
            int[] array_ = array.stream().mapToInt(Integer::valueOf).toArray();
            return array_;
        }
        array.add(array.get(array.size()-1)+ array.get(array.size()-2));
        return fibonacciSequence(min,max,array);
    }

    /**
     * 计算阶乘
     * @param n 数字
     * @return n的阶乘
     */
    public static int factorial(int n) {
        return  n <= 2 ? n : n * factorial(--n);
    }

    /**
     * 使用加减实现乘法
     * @param n1 数字1
     * @param n2 数字2，不允许为负
     * @return n1*n2
     */
    public static long multiplication(long n1,long n2){
        return n1 == 1 ? n2 : multiplication(n1 - 1,n2) + n2;
    }

    /**
     * 使用加减实现计算n的m次方
     * 详细-> 如果使用第一行代码则会出现java.lang.StackOverflowError
     * ，因为构造函数的“层”太多了，以致于把栈区溢出了。通常来讲，一般栈区远远小
     * 于堆区的，因为函数调用过程往往不会多于上千层，而即便每个函数调用需
     * 要1K的空间(这个大约相当于在一个C函数内声明了256个int
     * 类型的变量)，那么栈区也不过是需要1MB的空间。通常栈的大小是1－2MB
     * 的。通常递归也不要递归的层次过多，很容易溢出
     * return m == 1 ? n : multiplication(pow(n,m-1),n);
     * @param n 底数
     * @param m 指数
     * @return 幂
     */
    public static double pow(double n,int m){
        return m == 1 ? n : pow(n,m-1)*n;
    }

    public static int pow(int n,int m){
        return m == 1 ? n : pow(n,m-1)*n;
    }

    /**
     * 计算第n项的斐波纳契数值
     * @param n 项
     * @return 斐波纳契数
     */
    public int fibonacci(int n){
        if(fibonacciCache == null){
            fibonacciCache = new int[n];
        }else if(fibonacciCache.length < n){
            int[] array = new int[n];
            for (int i = 0; i < fibonacciCache.length; i++){
                array[i] = fibonacciCache[i];
            }
            fibonacciCache = array;
        }
        if(n <= 2){
            return 1;
        }
        if(fibonacciCache[n-1] != 0){
            return fibonacciCache[n-1];
        }
        return fibonacciCache[n-1] = fibonacci(n-1) + fibonacci(n - 2);
    }

    /**
     * 是否为对称数
     * @param number
     * @return
     */
    public static boolean isSymmetryNumber(int number){
        int l = Tool.getLength(number);
        int[] a = new int[l/2];
        int[] b = new int[l/2];
        for (int i = 1,j=0;j < a.length;i*=10,j++){
            a[j] = number/i%10;
        }
        for (int i = pow(10,l-1),j=0;j < a.length;i/=10,j++){
            b[j] = number/i%10;
        }
        for (int i = 0;i < a.length;i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * 是否是完数
     * @param number
     * @return
     */
    public static boolean isWholeNumber(int number){
        int c = 0;
        for (int i = 1;i <= number/2;i++){
            if(number%i == 0){
                c += i;
            }
        }
        if(c == number){
            return true;
        }
        return false;
    }

    /**
     * 公约数
     * @param min
     * @param max
     * @return
     */
    public static int[] commonDivisor(int min,int max){
        ArrayList<Integer> list = new ArrayList();
        for (int i = min;i > 0;i--){
            if(min%i == 0 && max%i == 0){
                list.add(i);
            }
        }
        return Transverter.toIntArray(list);
    }

    /**
     * 最大公约数
     * @param min
     * @param max
     * @return
     */
    public static int maxCommonDivisor(int min,int max){
        return maxCommonDivisor(min,max,min);
    }

    private static int maxCommonDivisor(int min,int max,int i){
        return min%i == 0 && max%i == 0? i:maxCommonDivisor(min,max,i-1);
    }

    /**
     * 求某范围内的所有素数
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static int[]  primeNumber(int min,int max){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min;i <= max;i++){
            boolean b =true;
            if(i%2 != 0){
                for (int j = 2;j <= i/2;j++){   //此处的j<=i/2对应注释b，原始行在228
                    if(i%j == 0){
                        b = false;
                    }
                }
                if(b){
                    list.add(i);
                }
            }
        }
        return Transverter.toIntArray(list);
    }

    /**
     * 最小公倍数
     * @param min
     * @param max
     * @return
     */
    public static int minCommonMultiple(int min,int max){
        for (int i = max*2;;i+=max){
            if(i%min == 0 && i%max == 0){
                return i;
            }
        }
    }

    /**
     * 杨辉三角形
     * @param n 行数
     * @return
     */
    public static int[][] pascalTriangle(int n){
        int[][] a = new int[n][];
        for (int i = 0;i < n;i++){
            a[i] = new int[i+1];
            for (int j = 0;j < i+1;j++){
                if(j == 0 || j == i){
                    a[i][j] = 1;
                }else {
                    a[i][j] = a[i-1][j-1]+a[i-1][j];
                }
            }
        }
        return a;
    }

    public static int absolute(int value){
        return value < 0 ? -value: value;
    }

}
