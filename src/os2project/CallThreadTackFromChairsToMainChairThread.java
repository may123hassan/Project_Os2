/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2project;

import static java.util.Calendar.SECOND;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Mohab
 */
  public  class CallThreadTackFromChairsToMainChairThread implements Runnable{
      public Gui GUI;
      Thread thread3;
       public Semaphore Sema;
      public CallThreadTackFromChairsToMainChairThread(Gui g){
      this.GUI=g;
      this.Sema=g.taa;
      thread3 = new Thread( this);
      thread3.start();

      
      }

    @Override
    public  void run() {

            while(true){
                try{
            Sema.acquire();


                if(this.GUI.Isavlable){

                 this.GUI.GetStudentbyCount();
                }
               Thread.sleep(2000);

                
      
                } catch(Exception v) {
            //System.out.println(v);
        }

            }    }
   
   
   }
   