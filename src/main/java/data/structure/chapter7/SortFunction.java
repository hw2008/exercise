package data.structure.chapter7;

import java.util.Date;

public class SortFunction {
    /**冒泡排序   O(n^2)
     * @param arr
     * @return
     */
    public static void bubblingSort(int[] arr){
        int k = arr.length;
        System.out.println("----------冒泡递减排序开始-----------");
        Date d1 = new Date();
        for(int i=0; i<k-1; i++){
            int tmp =  arr[i];
            for(int j=i+1;j<k;j++){
                if(arr[i] < arr[j]){
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println("----------冒泡递减排序结束-----------");
        System.out.println("----------冒泡排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
    
    /**插入降序排序
     * @param arr
     */
    public static void insertionSort(int[] a){
        System.out.println("----------插入递减排序开始-----------");
        Date d1 = new Date();
        int j;
         for(int i=1;i< a.length-1;i++){
             int tmp = a[i];
             for(j=i; j>0 && tmp>a[j-1]; j--){
                     a[j]=a[j-1];
             }
             a[j]=tmp;
         }
        System.out.println("----------插入递减排序结束-----------");
        System.out.println("----------插入排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
    
    public static void shellSort(int[] a){
        System.out.println("----------shell 递减排序开始-----------");
        Date d1 = new Date();
        int j;
        for(int gap = a.length / 2; gap > 0; gap /= 2){//循环增量序列
            for(int i = gap; i < a.length; i++){//插入排序
                int tmp = a[i];
                for(j = i; j >= gap && tmp < a[j-gap]; j -= gap){
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
        System.out.println("----------shell递减排序结束-----------");
        System.out.println("----------shell排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
}
