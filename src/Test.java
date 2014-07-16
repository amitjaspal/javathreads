import java.util.concurrent.CyclicBarrier;

class Tmp extends Thread{
    Integer x;
    CyclicBarrier cb;
    Tmp(CyclicBarrier cb, Integer x){
        this.cb = cb;
        this.x = x;
    }
    
    public void run(){
        System.out.println("Calling await - 1");
        
        try{
           x = x + 1;
           Thread.sleep(1000);
           cb.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Await done - 1");
        System.out.println("xt = " + x);
    }
}


/*class Tmp1 extends Thread{
    
    CyclicBarrier cb;
    Tmp1(CyclicBarrier cb){
        this.cb = cb;
    }
    
    public void run(){
        System.out.println("Calling await - 2");
        
        try{
            Thread.sleep(1000);
           cb.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Await done - 2");
    }
}*/



public class Test{
    
    public static void main(String arg[]){
        CyclicBarrier cb = new CyclicBarrier(2);
        Integer x = new Integer(10);
        Tmp t = new Tmp(cb, x);
//        Tmp1 t1 = new Tmp1(cb);
        t.start();
 //       t1.start();
        System.out.println("Calling await - 3");
        try{
           cb.await();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Await done - 3");
        System.out.println("x = " + x);
    }

}
