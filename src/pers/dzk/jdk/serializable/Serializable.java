package pers.dzk.jdk.serializable;

import java.io.*;

public class Serializable {

    public static void Serialize(String url,Object object) throws IOException {
        // 序列化
        FileOutputStream fos = new FileOutputStream(url);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
    }

    public static Object Deserialization(String url) throws IOException, ClassNotFoundException {
        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(url));
        return ois.readObject();
    }

}
