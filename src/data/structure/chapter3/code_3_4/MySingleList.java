package data.structure.chapter3.code_3_4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleList<AnyType> implements Iterable<AnyType>{
    private int theSize;
    private int modCount;
    private Node<AnyType> headNode;
    
    public void add(AnyType data){
        add(size()-1, data);
    }
    
    public void add(int idx, AnyType data) {
        addAfter(getNode(idx), data);
    }

    private void addAfter(Node<AnyType> node, AnyType data) {
        Node<AnyType> newNode = new Node<AnyType>(data, null); 
        node.next = newNode;
        theSize++;
        modCount++;
    }

    private Node<AnyType> getNode(int idx){
        Node<AnyType> p;
        if(idx < 0 || idx > size()-1){
            throw new IndexOutOfBoundsException();
        }
        
            p = headNode.next;
            for(int i = 0; i < idx; i++){
                p = p.next;
            }
        return p;
    }

    public int size() {
        return this.theSize;
    }
    public void remove(){
        remove(size()-1);
    }








    private void remove(int i) {
        removeAfter(getNode(i));
    }








    private void removeAfter(Node<AnyType> node) {
        node.next = null;
        this.theSize --;
        this.modCount++;
                
    }








    private class Node<AnyType>{
        public Node(AnyType d, Node<AnyType> n){
            this.data = d;
            this.next = n;
        }
        public AnyType data;
        public Node<AnyType> next;
    }









    @Override
    public Iterator<AnyType> iterator() {
        return new SingleLinkedListIterator();
    }
    
    private class SingleLinkedListIterator  implements Iterator<AnyType>{
        private Node<AnyType> current = headNode.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        @Override
        public boolean hasNext() {
            return current == null;
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
            okToRemove = false;
            expectedModCount++;
        }
        
    }









}
