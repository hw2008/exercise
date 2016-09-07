package data.structure.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**已排序的表L1和L2，只使用基本的表操作编写计算L1∩L2  L1∪L2
 * @author Aaron
 *
 */
public class No_3_4  {
    
    /**   3.4     L1∩L2
     * @param L1
     * @param L2
     * @return
     */
    public static  <AnyType extends Comparable<? super AnyType>> List<AnyType> intersection(List<AnyType> L1, List<AnyType> L2 ){
        List<AnyType> l = new ArrayList<AnyType>();
        Iterator<AnyType> it1 = L1.iterator();
        Iterator<AnyType> it2 = L2.iterator();
        AnyType l1 = null;
        AnyType l2 = null;
        if(it1.hasNext() && it2.hasNext()){
            l1 = it1.next();
            l2 = it2.next();
        }
        while(l1 != null && l2 != null){
            int comp = l1.compareTo(l2);
            if(comp == 0){
                l.add(l1);
                l1 = it1.hasNext()?it1.next():null;
                l2 = it2.hasNext()?it2.next():null;
            }else if(comp < 0){
                l1 = it1.hasNext()?it1.next():null;
            }else{
                l2 = it2.hasNext()?it2.next():null;
            }
        }
        
        return l;
    }
    
    
    /**  3.5    L1∪L2
     * @param L1
     * @param L2
     * @return
     */
    public static <AnyType extends Comparable<? super AnyType>> List<AnyType> union(List<AnyType> L1, List<AnyType> L2 ){
        List<AnyType> l = new ArrayList<AnyType>();
        Iterator<AnyType> it1 = L1.iterator();
        Iterator<AnyType> it2 = L2.iterator();
        AnyType l1 = it1.hasNext() ? it1.next() : null;
        AnyType l2 = it2.hasNext() ? it2.next() : null;
        
        while(l1 != null && l2 != null){
            int comp = l1.compareTo(l2);
            if(comp == 0){
                l.add(l1);
                l1 = it1.hasNext()?it1.next():null;
                l2 = it2.hasNext()?it2.next():null;
            }else if(comp < 0){
                l.add(l1);
                l1 = it1.hasNext()?it1.next():null;
            }else{
                l.add(l2);
                l2 = it2.hasNext()?it2.next():null;
            }
        }
         while(l1 != null){
            l.add(l1);
            l1 = it1.hasNext()?it1.next():null;
        }
        while(l2 != null){
            l.add(l2);
            l2 = it2.hasNext()?it2.next():null;
        } 
        return l;
    }
    
    public static void main(String[] args) {
        List<Integer> L1 = Arrays.asList( 1,3,5,7,9 , 10, 11, 12 ,13 );
        List<Integer> L2 = Arrays.asList( 1,4,5,8,9);
//        System.out.println(L1.toString());
//        System.out.println(L2.toString());
        Integer in1 = 4;
        Integer in2 = null;
        System.out.println(intersection(L1, L2).toString());
        System.out.println(union(L1, L2).toString());
    }
}
