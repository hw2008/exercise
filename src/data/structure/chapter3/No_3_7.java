package data.structure.chapter3;

import java.util.ArrayList;
import java.util.List;

public class No_3_7 {
    public static List<Integer> makeList(int n){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        //n次
        for( int i = 0; i < n; i++){
            lst.add(i);
            //n次
            lst.trimToSize();
        }
        return null;
    }
}
