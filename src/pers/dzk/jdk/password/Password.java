package pers.dzk.jdk.password;

public class Password {

    private String[] list;
    private char[] dict;
    private int length;
    private int count;
    private int index;

    public Password(char[] dict, int length) throws Exception {
        if (dict == null){
            throw new Exception();
        }else if(length < 1){
            throw new Exception("长度错误：密码长度不能为负！");
        } else {
            this.dict = dict;
            this.length = length;
        }
    }

    public void setDict(char[] dict) throws Exception {
        if (dict == null){
            throw new Exception();
        }else {
            this.dict = dict;
        }
    }

    public void setLength(int length) throws Exception {
        if(length < 1){
            throw new Exception("长度错误：密码长度不能为负！");
        } else {
            this.length = length;
        }
    }

    public int getCount(){
        if(count == 0){
            return count = (int) Math.pow(dict.length,length-1)*dict.length;
        }else {
            return count;
        }
    }

    public String[] getList(){
        list = new String[getCount()];
        getList(0,"");
        index = 0;
        return list;
    }

    private void getList(int index,String str){
        if(index == length){
            list[this.index++] = str;
        }else {
            for (int i = 0;i < dict.length;i++){
                String s = str + dict[i];
                getList(index+1,s);
            }
        }
    }







}
