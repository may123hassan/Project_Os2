
package os2project;

import java.util.Date;
import java.util.concurrent.Semaphore;

import static java.util.Calendar.SECOND;

/**
 *
 * @author Mohab
 */
public class CallThreadRemoveFromMainChair implements Runnable{
 public Gui GUI;   
 public Semaphore Sema;
 Thread t;
public CallThreadRemoveFromMainChair(Gui g){
    this.GUI=g;
    Sema=g.Re;
    t=new Thread(this);
    t.start();


}
     @Override
     public  void run() {
        try {
            while(true){
                Sema.acquire();
                for(int x=0;x<=GUI.ListOfTeacherChairsData.size();x++){
                    if(!this.GUI.ListOfTeacherChairsData.get(x).Isavlable&&this.GUI.ListOfTeacherChairsData.get(x).DateGetOut.getTime()<new Date().getTime()){
                    this.GUI.SetMainChaireFree(this.GUI.ListOfTeacherChairsData.get(x)); }
                
                
                
                
                
                }
                Thread.sleep(3*SECOND);

           

          
            }
        } catch(Exception v) {
            System.out.println(v);
        }

}


}
    

