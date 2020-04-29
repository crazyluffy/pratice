package org.renm;

public class Cons {
    public Cons (){
        System.out.println("org.renm.Cons contructor");
    }
    public int Cons(){
        System.out.println("org.renm.Cons method");
        return 0;
    }

    public static void main(String[] args) {
        Cons  co = new Cons();
        co.Cons();
    }
}
