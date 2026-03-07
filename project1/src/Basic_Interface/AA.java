package Basic_Interface;

public interface AA {
    public void m1();
}
class Bb {
    public static void main(String[] args){
        //@override
        //        public void m1(){
        //    System.out.println("over ride m1");}

        AA a = new AA(){
            @Override
            public void m1() {
                System.out.println("over riding m1 in class");
            }
        };
        a.m1();
    }
}
