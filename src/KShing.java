import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

/**
 * Created by 超 on 2017/6/6.
 */
public class KShing {

    public static void main(String[] args) {
        KShing kShing = new KShing();
        //需要过滤的字符串表
        List<String> filterWords = new LinkedList<>();
        filterWords.add("\\(");
        filterWords.add("\\)");
        filterWords.add(",");
        filterWords.add("-");
        filterWords.add("/");
        filterWords.add("by");
        filterWords.add("of");
        filterWords.add("and");
        filterWords.add("or");
        filterWords.add("with");
        filterWords.add("in");
        filterWords.add(" ");
        //待比较的字符串
        String s1 = "IELTS (International English Language Testing System) " +
            "conducted by the British Council, University of Cambridge Local " +
            "Examinations Syndicate and International Development Program of " +
            "Australian Universities and College: providing grade 6.5 or " +
            "higher (i.e. 7, 8, 9) overall has been obtained with a breakdown " +
            "of 6.0 in reading and writing and 5.5 in listening and speaking.";
        String s2 = "IELTS / UKVI –IELTS 6.5 overall with 6.0 in reading and " +
            "writing, 5.5 in listening and speaking for Law, Psychology, Architecture, " +
            "English, Accounting and Finance";
        List<String> stringList = new ArrayList<>(2);
        stringList.add(s1);
        stringList.add(s2);
        //调用过滤函数
        kShing.makeword(stringList,filterWords);
        Set<String> wordSet1 = new HashSet<>();
        Set<String> wordSet2 = new HashSet<>();
        s1 = stringList.get(0);
        s2 = stringList.get(1);
        System.out.println(s1);
        System.out.println(s2);
        //进行Kshing生成子串
        kShing.KShing2(stringList, wordSet1, wordSet2);
        Set<String> totalSet = new HashSet<>();
        totalSet.addAll(wordSet1);
        totalSet.addAll(wordSet2);
        //生成集合矩阵
        int[][] listArray = new int[totalSet.size()][2];
        String[] totalArray = new String[totalSet.size()];
        totalArray=totalSet.toArray(totalArray);
        for (int i = 0; i < totalSet.size(); i++) {
            if (wordSet1.contains(totalArray[i])){
                listArray[i][0] = 1;
            }
            if (wordSet2.contains(totalArray[i])){
                listArray[i][1] = 1;
            }
        }
        System.out.println("生成的子串如下：");
        for (String s : wordSet1){
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : wordSet2){
            System.out.print(s + " ");
        }
        for (int i = 0; i < listArray.length; i++) {
            System.out.println(listArray[i][0] + " " + listArray[i][1]);
        }
        int[] hashArray1 = new int[listArray.length];
        int[] hashArray2 = new int[listArray.length];
        //两条hash处理函数
        for (int i = 0; i < listArray.length; i++) {
            hashArray1[i] = (3*i+1)%7;
            hashArray2[i] = (5*i+1)%7;
        }
        for (int i = 0; i < hashArray1.length; i++) {
            System.out.print(hashArray1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < hashArray2.length; i++) {
            System.out.print(hashArray2[i]+" ");
        }
        System.out.println();
        //生成hash矩阵
        int[][] IDarray = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++){
                IDarray[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < listArray.length; i++) {
            if(listArray[i][0] == 1){
                if(hashArray1[i]<IDarray[0][0]){
                    IDarray[0][0] = hashArray1[i];
                }
                if(hashArray2[i]<IDarray[0][1]){
                    IDarray[0][1] = hashArray2[i];
                }
            }
            if(listArray[i][1] == 1){
                if(hashArray1[i]<IDarray[1][0]){
                    IDarray[1][0] = hashArray1[i];
                }
                if(hashArray2[i]<IDarray[1][1]){
                    IDarray[1][1] = hashArray2[i];
                }
            }
        }
        int p = 0;
        if(IDarray[0][0] == IDarray[0][1]){
            p++;
        }
        if(IDarray[1][0] == IDarray[1][1]){
            p++;
        }
        System.out.println("生成的hash矩阵如下：");
        for (int i = 0; i < IDarray.length; i++) {
            for (int j = 0; j < IDarray[i].length; j++) {
                System.out.print(IDarray[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Jaccard 数值是:" + (float)p/2);
    }
    //Kshing2的处理
    public void KShing2(List<String> stringList, Set<String> wordSet1, Set<String> wordSet2){
        String s1CharArray = stringList.get(0);
        String s2CharArray = stringList.get(1);
        for (int i = 0; i < s1CharArray.length()-1; i++) {
            wordSet1.add(s1CharArray.substring(i,i+2));
        }
        for (int i = 0; i < s2CharArray.length()-1; i++) {
            wordSet2.add(s2CharArray.substring(i,i+2));
        }
    }

    //字符串的处理
    public void makeword(List<String> stringsList, List<String> filterwords){
        String s1 = stringsList.get(0);
        String s2 = stringsList.get(1);
        for(String replace : filterwords){
            s1 = s1.replaceAll(replace+"", "");
            s2 = s2.replaceAll(replace, "");
        }
        stringsList.add(0,s1);
        stringsList.add(1,s2);
    }

}
