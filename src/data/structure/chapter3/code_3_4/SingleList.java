package data.structure.chapter3.code_3_4;

/**练习  3.11
 * @author Aaron
 *
 * @param <AnyType>
 */
public class SingleList<AnyType> {
    private int size;
    private Node<AnyType> headNode ;
    
    public SingleList(){
        this.size=0;
        this.headNode = new Node<AnyType>(null);
    }
    
    private class Node<AnyType>{
        public Node(AnyType d){
            this.data = d;
        }
        public AnyType data;
        public Node<AnyType> next;
    }
    
    public void add(AnyType newData){
        add(size(), newData);
    }

    private void add(int idx, AnyType newData) {
        addAfter(getPrevNode(idx), newData);
    }

    private void addAfter(Node<AnyType> node, AnyType newData) {
        node.next = new Node<AnyType>(newData);
        this.size++;
    }

    /**获取第idx+1个节点的前置节点
     * @param idx
     * @return
     */
    private Node<AnyType> getPrevNode(int idx) {
        if(idx < 0 || idx > size()){
            throw new IndexOutOfBoundsException();
        }
        Node<AnyType> p = headNode;
        for(int i=0; i<idx; i++){
            p = p.next;
        }
        return p;
    }

    private int size() {
        return this.size;
    }
    
    public String toString(){
        Node<AnyType> p = this.headNode;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<size(); i++){
            p = p.next;
            sb.append(p.data.toString()+",");
        }
        return sb.toString();
    }
    public void print(){
        System.out.println(this.toString());
    }

    private void removeIfHave(AnyType item) {
        Node<AnyType> p = this.headNode;
        int theSize = size();
        for(int i=0; i<theSize; i++){
            p = p.next;
            if(item.equals(p.data)){
                this.remove(i);
                theSize = size();
                i--;
            }
        }
    }

    private void remove(int idx) {
        remove(getPrevNode(idx));
    }

    private void remove(Node<AnyType> prevNode) {
        if(prevNode.next != null){
            prevNode.next = prevNode.next.next;
            this.size--;
        }
    }


    private void addIfLess(AnyType item) {
        if(!this.contain(item)){
            this.add(item);
        }
    }

    private boolean contain(AnyType item) {
        //TODO 判空
        
        //遍历
        Node<AnyType> p = this.headNode;
        for(int i=0; i<size(); i++){
            p = p.next;
            if(item.equals(p.data)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SingleList<Integer> l = new SingleList<Integer>();
        for(int i=0; i< 5; i++){
            l.add(i);
        }
        l.add(2);
        l.add(2);
        l.print();
        System.out.println(l.size());
        System.out.println(l.contain(7));
        l.addIfLess(7);
        l.print();
        System.out.println(l.size());
        l.removeIfHave(2);
        l.print();
        System.out.println(l.size());
    }
}
