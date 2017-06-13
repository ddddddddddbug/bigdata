import sun.text.resources.cldr.ia.FormatData_ia;

/**
 * Created by 超 on 2017/5/21.
 */
public  class Main2 {

    public static void main(String[] args) {
        CountThread[] countThreads = new CountThread[100];
        for (int i = 0; i < 100; i++) {
            countThreads[i] = new CountThread();
        }
        for (int i = 0; i < 100; i++) {
            countThreads[i].start();
        }
    }

}

class CountThread extends Thread{
    public static int count;
    private static void addCount(){
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count =" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}