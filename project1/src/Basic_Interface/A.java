package Basic_Interface;

public interface A {
    public void m1();
    public void m2();
    public void m3();
    default void m4(){
        System.out.println("m4 in interface A only");
    }
}

class B implements A{
    public void m1(){
        System.out.println("method m1 in class B");
    }
    public void m2(){
        System.out.println("method m2 in class B");
    }
    public void m3(){
        System.out.println("method m3 in class B");
    }
}

class C implements A {
    public void m1() {
        System.out.println("method m1 in class C");
    }
    public void m2(){
        System.out.println("method m2 in class C");
    }
    public void m3(){
        System.out.println("method m3 in class C");
    }
    public void m4(){
        System.out.println("m4 in interface A but is over ride in C");
    }
}
