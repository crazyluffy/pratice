package org.renm;

interface Tinterface<T>{
    public void test (T arg);
}

class TestA<T> implements Tinterface<T>{

/*
    public void test(Object arg) {
        System.out.println("test(Object)");
    }
*/

/*
    public void test(Integer arg){
        System.out.println("test(Integer)");
    }

    public void test(String arg){
       System.out.println("test(String)");
    }
*/

    public void work(Integer arg){

    }

    public  void work(String arg){

    }

    @Override
    public void test(T arg) {
        System.out.println("test(<T>)");
//        this.work(arg);
    }
}

class UseA{
    public void doSth(){
        Tinterface ti = new TestA();
        ti.test(10);
        ti.test("some arg");
        ti.test(3.14);
    }
}

public class Ti {
    public static void main(String[] args) {
        new UseA().doSth();
    }
}
