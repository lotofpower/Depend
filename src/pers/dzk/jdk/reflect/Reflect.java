package pers.dzk.jdk.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect<T> {
    private T object;
    private Class<T> c;
    private Constructor<T> constructor;
    private Field[] fields;
    private Method[] methods;
    private String[] fieldsName;
    private String[] methodsName;

    public Reflect(Class<T> c , Object... parameter) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.c = c;
        if(parameter != null){
            Class[] type = new Class[parameter.length];
            for (int i = 0;i < parameter.length;i++){
                type[i] = parameter[i].getClass();
            }
            constructor = c.getDeclaredConstructor(type);
        }else {
            constructor = c.getDeclaredConstructor();
        }
        constructor.setAccessible(true);
        object = constructor.newInstance(parameter);
        initialize();
    }

    public Reflect(Class<T> c) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        this.c = c;
        constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        object = constructor.newInstance();
        initialize();
    }

    public Reflect(T object) throws NoSuchMethodException {
        this.object = object;
        c = (Class<T>) object.getClass();
        constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        initialize();
    }

    private void initialize(){
        fields = c.getDeclaredFields(); // 返回所有的属性
        for(int i = 0;i < fields.length;i++){
            fields[i].setAccessible(true);
        }
        methods = c.getMethods();
        fieldsName = new String[fields.length];
        for (int i = 0;i < fieldsName.length;i++){
            fieldsName[i] = fields[i].getName();
        }
        methodsName = new String[methods.length];
        for (int i = 0;i < methodsName.length;i++){
            methodsName[i] = methods[i].getName();
        }
    }

    public String getClassName(){
        return c.getSimpleName();
    }

    public T getNewObject(Object... parameter) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class[] type = new Class[parameter.length];
        for (int i = 0;i < parameter.length;i++){
            type[i] = parameter[i].getClass();
        }
        Constructor<T> constructor = c.getDeclaredConstructor(type);
        constructor.setAccessible(true);
        return constructor.newInstance(parameter);
    }

    public String[] getFieldsName(){
        return fieldsName;
    }

    public void setFieldValue(String fieldName, Object value) throws IllegalAccessException {
        for (int i = 0;i < fieldsName.length;i++){
            if(fieldName == fieldsName[i]){
                fields[i].set(object,value);
            }
        }
    }

    public Object getFieldValue(String fieldName) throws IllegalAccessException {
        for (int i = 0;i < fieldsName.length;i++){
            if(fieldName == fieldsName[i]){
                return fields[i].get(object);
            }
        }
        return null;
    }

    public Object[] getFieldsValue() throws IllegalAccessException {
        Object[] results = new Object[fields.length];
        for (int i = 0;i < fields.length;i++){
            results[i] = fields[i].get(object);
        }
        return results;
    }
    
    public Field[] getFields(){
        return fields;
    }

    public String[] getMethodsName(){
        return methodsName;
    }

    public Method getMethod(String methodName){
        for (int i = 0;i < methodsName.length;i++){
            if(methodName == methodsName[i]){
                return methods[i];
            }
        }
        return null;
    }


    public void invoke(String methodName,Object... parameter) throws InvocationTargetException, IllegalAccessException {
        getMethod(methodName).invoke(object,parameter);
    }

    public T getObject(){
        return object;
    }

}
