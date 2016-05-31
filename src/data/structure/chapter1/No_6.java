package data.structure.chapter1;

import java.util.Arrays;

public class No_6 {
    static int count = 0;
    public static void permute(String str){
        char[] arr = str.toCharArray();
        permute(arr, 0, str.length()-1);
    }
    /** 全排列递归
     * @param arr
     * @param low
     * @param high
     */
    private static void permute(char[] arr, int low, int high){
        loop:
        for(int i = low ; i <= high; i++){
            String arrStr = Arrays.toString(arr);
            if(low == high){
                //判断八皇后问题
                for(int m=1;m<arr.length; m++){
                    for(int n = 0; n < m; n++){
                        int q1 = Integer.valueOf(arr[n]+"");
                        int q2 = Integer.valueOf(arr[m]+"");
                        if(m-n ==q2-q1  || m-n == q1-q2){
                            continue loop;
                        }
                    }
                }
                System.out.print(arrStr.substring(1, arrStr.length()-1).replace(", ", "")+",");
                count++;
                return;
            }  
            
            //排重
                    for(int j =low; j<i; j++){
                        if(arr[j] == arr[i]){
                            continue loop;
                        }
                    }
                char tmp = arr[low];
                arr[low] = arr[i];
                arr[i] = tmp;
                permute(arr, low + 1, high);
                tmp = arr[low];
                arr[low] = arr[i];
                arr[i] = tmp;
            }
        
    }
    
    /**求串的全排列，非递归
     * 思路： 把序列降序，组成最小的数，每次求一个较大的数，直到求出 最大值
     * @param str
     */
    public static void permute2(String str){
    }
    public static void main(String[] args) {
        permute ("01234567");
        System.out.println("符合条件的序列有："+count+"个");
    }
}
