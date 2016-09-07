package data.structure.chapter1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import data.structure.chapter7.SortFunction;

/**第一题  选择问题
 * 有N个随机排列的数，找出第k大的数，其中k=N/2,写出不同的N对应解题时间
 * @author Aaron
 *
 */
public class No_1_1 {
    //方法1： 前k位  冒泡排序
    /**
     * 
     * @param arr
     * @return
     * 数组长度：    100  1000  10000   100000
     * 计算时间：     2           307     22553 
     */
    public static int chooseMidInt(Integer[] arr){
        Date time1 = new Date();
        int length = arr.length;
        int k = length / 2;
        //第一步  前k位排序
        for(int i=0; i<k-1; i++){
            for(int j=i+1;j<k;j++){
                if(arr[i]<arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(" 前k位排序后数组："+Arrays.toString(arr));
        //第二步  遍历第k到第length位的元素，找到它的正确位置
        int m = k-1;
        for(int n = m+1;n < length;n++){
            if(arr[n] > arr[m] && m >= 0){
                arr[m] = arr[n];
                for(int o = m; o > 0; o--){
                    if(arr[o] > arr[o-1]){
                        int tmp = arr[o-1];
                        arr[o-1] = arr[o];
                        arr[o]=tmp;
                    }
                }
            }
        }
        System.out.println("第k大的数是："+arr[k-1]);
        System.out.println("算法结束时间："+(new Date().getTime()-time1.getTime()) +"毫秒");
        return arr[k-1];
    }
    
    /**
     * 以字符为单位读取文件，常用于读文本，数字等类型的文件
     */
    public static int[] readFileByChars(String fileName) {
        File file = new File(fileName);
        Reader reader = null;
        StringBuffer sb = new StringBuffer();
        ArrayList<String> list = new ArrayList<String>();
        int[] arr = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != ',') {
                    sb.append((char)tempchar);
                }else{
                    list.add(sb.toString());
                    sb = new StringBuffer();
                }
            }
            arr = new int[list.size()];
            int i = 0;
            for(String item: list){
                arr[i++] = Integer.valueOf(item);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    
    public static void main(String[] args) {
        int[] arr = readFileByChars("D:\\private\\learnDatas\\text1000000.txt");
        //chooseMidInt(arr);
            SortFunction.bubblingSort(arr);
            System.out.println(arr[arr.length/2-1]);
    }
}
