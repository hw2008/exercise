package example;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class Test {
public static void main(String[] args) {
    String[] a = {"a","b","c","d","e"};
    boolean b = Arrays.asList(a).contains("a");
    System.out.println(b);
    
    int[] intArray = { 1, 2, 3, 4, 5 };  
    int[] intArray2 = { 6, 7, 8, 9, 10 };  
    // Apache Commons Lang library  
    int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);  

}
}
