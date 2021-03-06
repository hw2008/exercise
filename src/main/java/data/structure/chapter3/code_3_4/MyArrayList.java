package data.structure.chapter3.code_3_4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType>{

    private static final int DEFAULT_CAPACITY = 10;
    
    private int theSize;
    private AnyType[] theItems;
    
    public MyArrayList(){
        clear();
    }
    private void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
        
    }
    
    public int size(){
        return theSize;
    }
    
    public boolean isEmpty(){
        return size() == 0;
    }
    
    public void trimToSize(){
        ensureCapacity(size());
    }
    
    public AnyType get(int idx){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }
    
    public AnyType set (int idx, AnyType newVal){
        if(idx < 0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }
    
    
    
    private void ensureCapacity(int newCapacity) {
        if(newCapacity < theSize){
            return;
        }
        
        AnyType [] old = theItems;
        theItems = (AnyType [])new Object[ newCapacity ];
        for(int i = 0; i < size(); i++){
            theItems[i] = old[i];
        }
    }
    
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }
    public void add(int idx, AnyType x) {
        if(theItems.length == size()){
            ensureCapacity( size() * 2 + 1);
        }
        for( int i = theSize; i > idx; i--){
            theItems[ i ] = theItems[ i - 1 ];
        }
        theItems[ idx ] = x;
        theSize++;
    }
    
    public AnyType remove ( int idx ){
        AnyType removedItem = theItems[ idx ];
        for( int i = idx; i < size() - 1; i++){
            theItems[ i ] = theItems[ i + 1 ];
        }
        theSize--;
        return removedItem;
    }
    
    public void addAll(Iterable<? extends AnyType> items){
        Iterator<? extends AnyType> it = (Iterator<? extends AnyType>) items.iterator();
        while(it.hasNext()){
            this.add(it.next());
        }
        //O(n)
    }
    
    
    
    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }
    
    private class ArrayListIterator implements Iterator<AnyType>{
        private int current = 0;
        
        public boolean hasNext(){
            return current < size();
        }

        public AnyType next() {
            if( !hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }
        
        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }
    
    public ListIterator<AnyType> listIterator() {
        return new MyListIterator();
    }
    
    private class MyListIterator implements ListIterator<AnyType>{
        private int current = 0;
        
        public boolean hasNext(){
            return current < size();
        }

        public AnyType next() {
            if( !hasNext()){
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }
        
        public void remove(){
            MyArrayList.this.remove(--current);
        }

        @Override
        public boolean hasPrevious() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public AnyType previous() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("nextIndex");
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("previousIndex");
        }

        @Override
        public void set(AnyType e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void add(AnyType e) {
            // TODO Auto-generated method stub
            
        }
    }
    public static void main(String[] args) {
    }
}
