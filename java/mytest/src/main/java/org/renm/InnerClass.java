package org.renm;

public class InnerClass {
    private int i;

    public class InClass {
        public void print(){
            System.out.println(i);
        }
    }

}
