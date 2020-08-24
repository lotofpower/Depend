package pers.dzk.jdk.datetype;

import pers.dzk.jdk.tool.Tool;

public class OrderlyInt {
    private int[] a;
    private boolean bigToLittle = false;
    public OrderlyInt(int... v) throws Exception {
        set(v);
    }
    public int[] get(){
        return a;
    }
    public void set(int... v) throws Exception {
        if(Tool.isOrderly(v)){
            a = v;
            if(v[0] > v[1]){
                bigToLittle = true;
            }
        }else if(v.length == 1){
            throw new Exception("长度不允许为1");
        }else {
            throw new Exception("数据无序");
        }
    }

    /**
     * 获取这个有序数组是从大到小还是从小到大排列,如数组[0,1,2]返回false，[2,1,0]返回true
     * @return
     */
    public boolean getOrder(){
        return  bigToLittle;
    }
}
