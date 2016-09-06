package data.structure.chapter3.code_3_4;


/**练习  3.12
 * @author Aaron
 *
 * @param <Comparable>
 */
public class SingleList2 {
    private int size;
    private Node<Comparable> headNode ;
    
    public SingleList2(){
        this.size=0;
        this.headNode = new Node<Comparable>(null);
    }
    
    private class Node<Comparable> {
        public Node(Comparable d){
            this.data = d;
        }
        public Node(Comparable d, Node<Comparable> n){
            this.data = d;
            this.next = n;
        }
        public Comparable data;
        public Node<Comparable> next;
    }
    
    /** 保持排序降序
     * @param newData
     */
    public void add(Comparable newData){
        Node<Comparable> p = this.headNode;
        if(size() == 0){
            add(0, newData);
            return ;
        }else{
            for(int i=0; i<size(); i++){
                p = p.next;
                if(newData.compareTo(p.data) > 0){
                    add(i, newData);
                    return;
                }
            }
            //新增最小的节点
            add(size(), newData);
            
        }
    }

    private void add(int idx, Comparable newData) {
        addAfter(getPrevNode(idx), newData);
    }

    private void addAfter(Node<Comparable> node, Comparable newData) {
        Node<Comparable> newNode = new Node<Comparable>(newData, node.next);
        node.next = newNode;
        this.size++;
    }

    /**获取第idx+1个节点的前置节点
     * @param idx
     * @return
     */
    private Node<Comparable> getPrevNode(int idx) {
        if(idx < 0 || idx > size()){
            throw new IndexOutOfBoundsException();
        }
        Node<Comparable> p = headNode;
        for(int i=0; i<idx; i++){
            p = p.next;
        }
        return p;
    }

    private int size() {
        return this.size;
    }
    
    public String toString(){
        Node<Comparable> p = this.headNode;
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

    private void removeIfHave(Comparable item) {
        Node<Comparable> p = this.headNode;
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

    private void remove(Node<Comparable> prevNode) {
        if(prevNode.next != null){
            prevNode.next = prevNode.next.next;
            this.size--;
        }
    }

    private void addIfLess(Comparable item) {
        if(!this.contain(item)){
            this.add(item);
        }
    }

    private boolean contain(Comparable item) {
        //TODO 判空
        
        //遍历
        Node<Comparable> p = this.headNode;
        for(int i=0; i<size(); i++){
            p = p.next;
            if(item.equals(p.data)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SingleList2  l = new SingleList2();
        for(int i=0; i< 5; i++){
            l.add(i);
        }
        l.add(2);
        l.add(2);
        l.print();
        System.out.println(l.size());
        System.out.println(l.contain(7));
        l.addIfLess(-1);
        l.print();
        System.out.println(l.size());
        l.removeIfHave(2);
        l.print();
        System.out.println(l.size());
    }
}
