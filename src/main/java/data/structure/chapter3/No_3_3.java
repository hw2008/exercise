package data.structure.chapter3;


public class No_3_3<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;
    
    private static class Node<AnyType>{
       public Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
           data = d;
           prev = p;
           next = n;
       }
       public AnyType data;
       public Node<AnyType> prev;
       public Node<AnyType> next;
    }
    
    /**  No_3_3
     * @param newItem
     * @return
     */
    public boolean contains(AnyType newItem){
//        Node<AnyType> p = this.beginMarker;
//        while(true){
//            if(p.next == null){
//                return false;
//            }
//            p = p.next;
//            if(p.data.equals(newItem)){
//                return true;
//            }
//        }
        Node<AnyType> p = this.beginMarker.next;
        while( p != this.endMarker && !(p.data.equals(newItem))){
            p = p.next;
        }
        return p != this.endMarker;
        
    }
}
