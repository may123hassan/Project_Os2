
package os2project;


import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;



public class Os2Project{

static Gui x;
    public static void main(String[] args) {
        
         x=new Gui();
        // CallThreadTackFromChairsToMainChairThread thread1=new CallThreadTackFromChairsToMainChairThread(x);
        
         CallThreadStudentsProducer thread=new CallThreadStudentsProducer(x);
         CallThreadRemoveFromMainChair threadb=new CallThreadRemoveFromMainChair(x);
        

    }

   
    
    
    
}
