package data.structure.chapter4;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class ComputeAdjacentWords {
    /** 1、根据长度分组
     *  2、在每一组内计算只差一个字母的单词映射
     * @param theWords
     * @return
     */
    public static Map<String, List<String>> computeAdjacentWords(List<String> theWords){
        Map<Integer, List<String>> groupByLengthMap = new TreeMap<Integer, List<String>>();
        Map<String, List<String>> groupByWordMap = new TreeMap<String, List<String>>();
        for(String word : theWords){
            update(groupByLengthMap, word.length(), word);
        }
        
        for(List<String> lst : groupByLengthMap.values()){
            
        }
        
        
        return null;
        
    }
    
    private static <KeyType> void update(Map<KeyType, List<String>> m, KeyType key, String value){
        List<String> lst = m.get(key);
        if(lst == null){
            lst = new ArrayList<String>();
            m.put(key, lst);
            
        }
        lst.add(value);
    }
    public static void main(String[] args) {
        //File f=new File("D:/download/英语词汇大全.txt");  
        char[] buffer=new char[512];   //一次取出的字节数大小,缓冲区大小  
        int numberRead=0;  
        FileReader reader=null;        //读取字符文件的流  
        PrintWriter writer=null;    //写字符到控制台的流  
        
        try {
            //4722个单词
            reader = new FileReader("D:/download/英语词汇大全.txt");
            writer = new PrintWriter("D:/download/aaaaa.txt");
            List<Character> a = new ArrayList<Character>();
            List<String> b = new ArrayList<String>();
            while ((numberRead=reader.read(buffer))!=-1 ) { 
                for(int i=0; i<buffer.length; i++){
                    if((buffer[i] > 64 && buffer[i] < 123) && (buffer[i] < 91 || buffer[i] > 96)){
                        a.add(buffer[i]);
                    }else{
                        if(a.size() > 0){
                            b.add(StringUtils.join(a.toArray(new Character[a.size()])));
                            a = new ArrayList<Character>();
                        }
                    }
                }
                    //writer.write(buffer, 0, numberRead);  
             }
            
            System.out.println(b.size());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            writer.close();
        }

    }
}
