package cn.wscfan.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author 王松
 * @Date 2020/4/19 21:42
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        clz = Iphone.class;
        clz = Class.forName("cn.wscfan.server.basic.Iphone");
        Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);

    }
}

class Iphone {
    public Iphone() {

    }
}
