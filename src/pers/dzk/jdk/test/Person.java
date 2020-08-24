package pers.dzk.jdk.test;


/**
 * 测试类实验体
 */
public class Person {
    private String name;
    private int age;

    public Person(){

    }

    public Person(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public void test(){
        System.out.println("test2");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

}