package data.structure.chapter1;

public class No_1_5 {
    public static int f(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n % 2 ==0){
            return f(n/2);
        }else{
            return f(n/2)+1;
        }
    }
    public static void main(String[] args) {
        System.out.println(f(2));
        System.out.println(f(3));
        System.out.println(f(4));
        System.out.println(f(5));
        System.out.println(f(6));
        System.out.println(f(7));
        System.out.println(f(8));
        System.out.println(f(9));
        System.out.println(f(10));
        System.out.println(f(255));
        System.out.println(f(256));
        
        
    }
}
