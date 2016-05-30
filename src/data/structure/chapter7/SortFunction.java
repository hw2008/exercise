package data.structure.chapter7;

import java.util.Date;

public class SortFunction {
    /**冒泡排序   O(n^2)
     * @param arr
     * @return
     */
    public static void bubblingSort(int[] arr){
        int k = arr.length;
        System.out.println("----------冒泡排序开始-----------");
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
        System.out.println("----------冒泡排序结束-----------");
        System.out.println("----------冒泡排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
    
    /**插入降序排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        System.out.println("----------插入排序开始-----------");
        Date d1 = new Date();
        int j;
         for(int i=1;i< arr.length-1;i++){
             int tmp = arr[i];
             for(j=i; j>0 && tmp>arr[j-1]; j--){
                     arr[j]=arr[j-1];
             }
             arr[j]=tmp;
         }
        System.out.println("----------插入排序结束-----------");
        System.out.println("----------插入排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
    
    public static void shellSort(int[] arr){
        System.out.println("----------shell排序开始-----------");
        Date d1 = new Date();
        int j;
        int length = arr.length;
//        for(int s=length/2; s > 0; s/=2){
//            for(int i=s;i<length;i++){
//                int tmp = arr[j];
//                for(){
//                    
//                }
//            }
//        }
         for(int i=1;i< arr.length-1;i++){
             int tmp = arr[i];
             for(j=i; j>0 && tmp>arr[j-1]; j--){
                     arr[j]=arr[j-1];
             }
             arr[j]=tmp;
         }
        System.out.println("----------shell排序结束-----------");
        System.out.println("----------shell排序时间："+(new Date().getTime()-d1.getTime())+"毫秒-----------");
    }
}
