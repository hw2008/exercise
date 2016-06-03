package data.structure.chapter3;

import java.util.Iterator;
import java.util.List;

public class No_3_1 {
//    private ArrayList<Integer> L;
//    private ArrayList<Integer> P;
//    public void printLots(ArrayList<Integer> L, ArrayList<Integer> P){
//        for(Integer i: P){
//            System.out.println(L.get(i));
//        }
//    }
    
    //只用Collection接口的public方法
    public static <AnyType> void printLots(List<AnyType> L, List<Integer> P){
        Iterator<AnyType> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();
        
        AnyType itemL = null;
        Integer itemP = 0;
        int start = 0;
        
        while(iterL.hasNext() && iterP.hasNext()){
            itemP = iterP.next();
            System.out.println("looking for position " + itemP);
            while( start < itemP && iterL.hasNext()){
                start++;
                itemL = iterL.next();
            }
            System.out.println(itemL);
        }
    }
}


