package codetop_byte;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Test implements Cloneable,Serializable{
    A a;
    int c = 20;
    String name = "hh";

    @Override
    protected Test clone() throws CloneNotSupportedException {
        Test cloneTest = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            cloneTest = (Test)objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneTest;
    }
}
class A implements Serializable,Cloneable{
    int a = 10;
    int b = 20;
}



//    private static final Object ob = new Object();
//    private volatile static Test t;
//    private Test(){
//        if(t != null) {
//            throw new RuntimeException("该类已经被实例化,请勿再实例");
//        }
//    }
//    private static Test getInstance() {
//        if(t == null) {
//            synchronized (ob){
//                if(t == null) {
//                    t = new Test();
//                }
//            }
//        }
//        return t;
//    }
//    @org.junit.jupiter.api.Test
//    public void show() {
//        Test t = Test.getInstance();
//        Class objClass = Test.class;
//        System.out.println("t:"+t);
//        try {
//            Constructor constructor = objClass.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            Test newT = (Test)constructor.newInstance();
//            System.out.println("newT:"+newT);
//            System.out.println(t == newT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
