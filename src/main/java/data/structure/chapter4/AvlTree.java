package data.structure.chapter4;

public class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private AvlNode<AnyType> tree;
    private static class AvlNode<AnyType>{
        AnyType element;
        AvlNode<AnyType> left ;
        AvlNode<AnyType> right ;
        int height;
        
        AvlNode(AnyType theElement){
            this(theElement, null, null);
        }

        public AvlNode(AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
        
    }
    
    private int height(AvlNode<AnyType> t){
        return t == null ? -1 : t.height;
    }
    
    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t){
        if(t == null){
            return new AvlNode<AnyType>(x, null, null);
        }
        
        int compareResult = x.compareTo(t.element);
        
        if(compareResult < 0){
            t.left = insert(x, t.left);
            if(height(t.left) - height(t.right) == 2){
                if(x.compareTo(t.left.element) < 0){
                    t = rotateWithLeftChild(t);
                }else{
                    t = doubleWithLeftChild(t);
                }
            }
        }else if(compareResult > 0){
            t.right = insert(x, t.right);
            if(height(t.right) - height(t.left) == 2){
                if(x.compareTo(t.right.element) > 0){
                    t = rotateWithRightChild(t);
                }else{
                    t = doubleWithRightChild(t);
                }
            }
        }
        
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k1) {
        AvlNode<AnyType> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
    
}
