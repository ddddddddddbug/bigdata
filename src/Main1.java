import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
       String s1 = "IELTS (International English Language Testing System) " +
           "conducted by the British Council, University of Cambridge Local " +
           "Examinations Syndicate and International Development Program of " +
           "Australian Universities and College: providing grade 6.5 or " +
           "higher (i.e. 7, 8, 9) overall has been obtained with a breakdown " +
           "of 6.0 in reading and writing and 5.5 in listening and speaking.";
      String s2 =  s1.replaceAll("\\.","");
        System.out.println(s2);
    }
}

