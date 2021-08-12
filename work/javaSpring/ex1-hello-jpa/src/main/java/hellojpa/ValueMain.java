package hellojpa;

public class ValueMain {

    public static void main(String[] args){

        String a = new String("eee");
        String b= a;

        a = "aaa";

        System.out.println("b = " + b);
        System.out.println("a = " + a);
    }
}
