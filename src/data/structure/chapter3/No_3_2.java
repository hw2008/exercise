package data.structure.chapter3;

public class No_3_2 {
//单链
    public static void swapWithNext(Node beforeP){
        Node p = beforeP.next;
        Node afterP = p.next;
        
        p.next = afterP.next;
        beforeP.next = afterP;
        afterP.next = p;
    }
    
    private class Node<AnyType>{
        private AnyType data;
        private Node next;
    }
    
    //双链
    public static void swapWithNext2(Node2 beforeP){
        Node2 p = beforeP.next;
        Node2 afterP = p.next;

//        beforeP.next = afterP;
//        afterP.prev = beforeP;
//        
//        p.next = afterP.next;
//        p.prev = afterP;
//        
//        
//        afterP.next.prev = p;
//        afterP.next = p;
        //先换头尾链
        beforeP.next = afterP;
        afterP.next.prev = p;
        //依次换节点的链方向
        //由于没有指定尾节点的引用，先指定尾节点的上游节点
        p.next = afterP.next;
        p.prev = afterP;
        
        afterP.next = p;
        afterP.prev = beforeP;
    }
    
    private static class Node2<AnyType>{
        private AnyType data;
        private Node2<AnyType> next;
        private Node2<AnyType> prev;
        
        public Node2(AnyType data1, Node2<AnyType> next1, Node2<AnyType> prev1){
            this.data = data1;
            this.next = next1;
            this.prev = prev1;
        }
    }
    
    public static void main(String[] args) {
        Node2<Integer> a = new Node2<Integer>(1, null, null);
        Node2<Integer> b = new Node2<Integer>(2, null, a);
        Node2<Integer> c = new Node2<Integer>(3, null, b);
        Node2<Integer> d = new Node2<Integer>(4, null, c);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(a.data); 
        System.out.println(a.next.data); 
        System.out.println(a.next.next.data); 
        System.out.println(a.next.next.next.data); 
        System.out.println(d.data); 
        System.out.println(d.prev.data); 
        System.out.println(d.prev.prev.data); 
        System.out.println(d.prev.prev.prev.data); 
        swapWithNext2(a);
        System.out.println(a.data); 
        System.out.println(a.next.data); 
        System.out.println(a.next.next.data); 
        System.out.println(a.next.next.next.data); 
        System.out.println(d.data); 
        System.out.println(d.prev.data); 
        System.out.println(d.prev.prev.data); 
        System.out.println(d.prev.prev.prev.data); 
    }
}
