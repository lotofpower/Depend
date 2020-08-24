package pers.dzk.jdk.file;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class File {
    /**
     * 文件写入
     * @param path 目录
     * @param name 文件名
     * @param content 内容
     */
    public static void writeTXT(String path,String name,String content){
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            java.io.File writename = new java.io.File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
            if(!writename.exists()){
                writename.mkdirs();
            }
            writename = new java.io.File(path+"\\"+name);// 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(content); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
