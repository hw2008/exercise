package data.structure.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public  class No_3_6  {
    public static void pass(int m, int n){
        int i, j, mPrime, numLeft;
        ArrayList<Integer> l = new ArrayList<>();
        
        for(i=1; i<=n; i++){
            l.add(i);
        }
        
        ListIterator<Integer> iter = l.listIterator();
        Integer item = 0;
        //剩下元素个数
        numLeft = n;
        //移动步长
        mPrime = m % n;
        
        for(i=0; i<n; i++){
            mPrime = m % numLeft;
            //如果右移位数小于剩余元素的一半，则向右移动找下一个待移除元素；否则向左移动
            if(mPrime <= numLeft/2){
                if(iter.hasNext()){
                    //下一轮第一个元素
                    item = iter.next();
                    //往后找m个元素
                    for(j=0; j<mPrime; j++){
                        if(!iter.hasNext()){
                            iter = l.listIterator();
                        }
                        item = iter.next();
                    }
                }
            }else{
                for(j=0; j<numLeft-mPrime; j++){
                    if(!iter.hasPrevious()){
                        iter = l.listIterator(l.size());
                    }
                    item = iter.previous();
                }
            }
            System.out.println("Removed " + item + " ");
            //remove操作后iter后退一位，需要.next()操作找到下一轮第一位
            iter.remove();
            if(!iter.hasNext()){
                //startMarker
                iter = l.listIterator();
            }
            
            System.out.println();
            for(Integer x : l){
                System.out.print(x + ",");
            }
            System.out.println();
            numLeft--;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        List<Integer>  l = new ArrayList<Integer>();
        pass(5, 10);
    }
}
