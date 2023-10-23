package org.example;

public class main {


    public static void main() {
        B a = new A();
        A b = (A) new B();
        A.count++;

        System.out.println(A.count);
        System.out.println(b.f3());
    }

}
class B {
    B(){

    }
    public void f() {
    }
}

class A extends B {

    static Integer count;
    Integer count2;


    A(){

    }
    static void incrementStatic(){
        count++;
    }
    void increment(){
         count2++;
    }

    public Integer f3() {
            return count;
    }
}

