package data.structure.chapter3.code_3_4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
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
    
    public MyLinkedList(){
        clear();
    }

    public void clear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;
        
        theSize = 0;
        modCount ++;
        
    }
    
    public int size(){
        return theSize;
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
    
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }
    
    public void add(int idx, AnyType x){
        addBefore(getNode(idx), x);
    }
    
    public AnyType get( int idx){
        return getNode(idx).data;
    }
    
    public AnyType set(int idx, AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }
    
    public AnyType remove (int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<AnyType> p, AnyType x){
        Node<AnyType> newNode = new Node<AnyType>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    
    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        
        return p.data;
    }
    private Node<AnyType> getNode(int idx){
        Node<AnyType> p;
        if(idx < 0 || idx > size()){
            throw new IndexOutOfBoundsException();
        }
        
        if( idx < size() / 2){
            p = beginMarker.next;
            for(int i = 0; i < idx; i++){
                p = p.next;
            }
        }else{
            p = endMarker;
            for( int i = size(); i > idx; i--){
                p = p.prev;
            }
        }
        return p;
    }
    
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
        
    }
    
    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        
        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }


        public void remove(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if( !okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount++;
        }
    }

}
