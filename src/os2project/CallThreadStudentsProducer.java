
package os2project;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import os2project.models.StudentModel;


public class CallThreadStudentsProducer implements Runnable{
    public Gui GUI;
     public Semaphore Sema;
         
      Thread thread1;
    public CallThreadStudentsProducer(Gui G){
        this.GUI=G;
        Sema=G.Chairs;

        thread1 = new Thread( this);
        thread1.start();
    
    
    }
    

    @Override
    public synchronized void run(){


        try {
            while(true){
            Sema.acquire();
            StudentModel std= new StudentModel().CreateNewStudent(this.GUI.Next);
            System.out.println(this.GUI.Queue.size());
            if(this.GUI.Queue.isEmpty()){
               this.GUI.SetStudentToMainChairByStudent(std);
            
            }else{
                this.GUI.SetStudentChair(std);
            
            
            }
            
            
            
            
            
            
             GUI.taa.release();
             GUI.Re.release();
            Random random = new Random();

           Long Duration=Math.abs(random.nextLong()%5000)+2;
           Thread.sleep(Duration);
           this.GUI.Next=this.GUI.Next+1;
 }
        } catch(InterruptedException v) {
            System.out.println(v);
        }


    }
    
}
