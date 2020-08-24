package pers.dzk.jdk.test;

import pers.dzk.jdk.reflect.Reflect;

public class Out {
    public static <T> void println(T object) throws IllegalAccessException, NoSuchMethodException {
        Reflect<T> lotReflect = new <T>Reflect(object);
        String[] fieldsName = lotReflect.getFieldsName();
        Object[] results = lotReflect.getFields();
        for (int i = 0;i < fieldsName.length;i++){
            System.out.println(String.format("%s : %s",fieldsName[i],results[i]));
        }
    }
}
