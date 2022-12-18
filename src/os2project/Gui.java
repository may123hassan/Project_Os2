/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.util.Calendar.HOUR;
import static java.util.Calendar.SECOND;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import os2project.models.*;

/**
 *
 * @author Mohab
 */
public class Gui extends JFrame{
     public JFrame frame = new JFrame("JList demo");  
     public JPanel Chair1 = new JPanel();  
     public JPanel Chair2 = new JPanel();  
     public JPanel Chair3 = new JPanel();    
     public JPanel MainChairPanel = new JPanel(); 

     public JPanel ta = new JPanel();
     Date now=new Date();

     public ChairModel MainChair=new ChairModel(0,'E',0 ,new Date(now.getTime() + 10* SECOND));   
     public ChairModel Chairmodel1=new ChairModel(1,'E',0,null);  
     public ChairModel Chairmodel2=new ChairModel(2,'E',0,null);   
     public ChairModel Chairmodel3=new ChairModel(3,'E',0,null);
     Random random=new Random(System.currentTimeMillis());
   
     public int Counter=1;
     public boolean Isavlable=true;   
     public int Next=1;  
     public Semaphore  Chairs=new Semaphore(20);   
     public Semaphore  taa=new Semaphore(1000);   
     public Semaphore  Re=new Semaphore(1000);
     public Helper myhelper=new Helper();
     public ArrayList<ChairModel> GridOfStudentChairsData=new ArrayList<ChairModel> ();
     public ArrayList<ChairModel> ListOfTeacherChairsData=new ArrayList<ChairModel> (); 
     public ArrayList<Integer> Queue = new ArrayList<Integer>();





    public Gui(){
        Chair1.setBounds(100, 300, 250, 250);      
        Chair2.setBounds(370, 300, 250, 250);
        Chair3.setBounds(630,300,250,250);        
        ta.setBounds(0,0,250,250); 

   
        MainChairPanel.setBounds(250,0,250,250);     
     
        Chair1.setBackground(Color.white); 
        Chair2.setBackground(Color.white); 
        Chair3.setBackground(Color.white); 
        MainChairPanel.setBackground(Color.white);



            GridOfStudentChairsData=myhelper.GetGridOfFreeChairs(30);
        for (int x=0;x<GridOfStudentChairsData.size()-1;x++){
             frame.add(GridOfStudentChairsData.get(x).ChairSt);

        }
     
        
        ListOfTeacherChairsData=myhelper.GetListOfTeachersChairs(5);

         for (int x=0;x<ListOfTeacherChairsData.size();x++){
          
             frame.add(ListOfTeacherChairsData.get(x).MeatingPanel);

        }
        frame.setSize(myhelper.MainWidth, myhelper.MainHeigth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
       public synchronized void AddStdToChar(ChairModel chair,StudentModel std ,JPanel panel){
        chair.Status='S';       
        chair.StudentId=std.Id;   
        System.out.println("Studen "+Integer.toString(std.Id)+" Added To Chair "+Integer.toString(chair.Id));
   }
       public synchronized void SetStudentToMainChairByStudent(StudentModel std){
           boolean Enteredtomaincahir=false;
           for(int x=0;x<=ListOfTeacherChairsData.size()-1;x++){
           if(ListOfTeacherChairsData.get(x).Isavlable){
            ListOfTeacherChairsData.get(x).Isavlable=false;
           SetImageToPanel(ListOfTeacherChairsData.get(x).ChairTa,"weak.png"); 
           SetImageToPanel(ListOfTeacherChairsData.get(x).ChairSt,"S.jpg");
           ListOfTeacherChairsData.get(x).Status='S';
           ListOfTeacherChairsData.get(x).StudentId=std.Id;
           System.out.println("Student "+Integer.toString(std.Id)+" Add To Main Chair"+Integer.toString(x+1));
           
           Random rn = new Random();
           int answer = rn.nextInt(10) + 1;
           ListOfTeacherChairsData.get(x).DateGetOut.setTime(new Date().getTime() + 10000);
           System.err.println(ListOfTeacherChairsData.get(x).DateGetOut.toString()); 
           Enteredtomaincahir=true;
           break;
           }

           
           }
           if(!Enteredtomaincahir){
           SetStudentChair(std);
           }
           

    }
     
     public synchronized  void SetMainChaireFree(ChairModel chair){
      chair.Isavlable=true;
      chair.Status='E';
      System.out.println("Student "+Integer.toString(chair.StudentId)+" Left Main Chair"+Integer.toString(chair.Id)+" ,Chair Is Free Now");
      MainChairPanel.setBackground(Color.white);   
      SetImageToPanel(chair.ChairTa,"sleep.png");  
      SetImageToPanel(chair.ChairSt,"E.jpg");



    }
     
       public synchronized ChairModel GetChairByQueueId(int Q){
         
         if(!GridOfStudentChairsData.isEmpty()){
              for(int x=0;x<GridOfStudentChairsData.size();x++){
                 if(GridOfStudentChairsData.get(x).StudentId==Q){
                 
                 return GridOfStudentChairsData.get(x);
                 }
                 
             
             }
         
         
         }
     return null; 
     }     
        
     
     
     public synchronized void GetStudentbyCount(){
         if(!Queue.isEmpty()){
            ChairModel MyChair=GetChairByQueueId(Queue.get(0));
            //(MyChair.ChairSt)
            
         }
         
         
         
   
         
         
  
         
         
         
         
     


    if(Counter==1&&Chairmodel1.Status=='S'&&this.Isavlable){
        System.out.println(1);
        this.Isavlable=false;
        Chairmodel1.Status='E';
        MainChair.StudentId=Chairmodel1.StudentId;
        SetChairFreeAndAddToMainChair(Chairmodel1,Chair1);
        Counter=2;

    }else
      if(Counter==2&&Chairmodel2.Status=='S'&&this.Isavlable){
                  System.out.println(2);

        this.Isavlable=false;
        Chairmodel2.Status='E';
        MainChair.StudentId=Chairmodel2.StudentId;
        SetChairFreeAndAddToMainChair(Chairmodel2,Chair2);
        Counter=3;
    }
      else if(Counter==3&&Chairmodel3.Status=='S'&&this.Isavlable){
                  System.out.println(3);

        this.Isavlable=false;
        Chairmodel3.Status='E';
        MainChair.StudentId=Chairmodel3.StudentId;
        SetChairFreeAndAddToMainChair(Chairmodel3,Chair3);
        Counter=1;
    }
    
    
    
    
    
    
    }
     public  void SetChairFreeAndAddToMainChair(ChairModel Chairmodel,JPanel pan){
       
        Chairmodel.Status='E';
        MainChair.Status='S';
              SetImageToPanel(ta,"weak.png");

        MainChair.StudentId=Chairmodel.StudentId;
        System.out.println("Student From Chair "+Integer.toString(Chairmodel.Id)+" Add To Main Chair");
        pan.setBackground(Color.white);
        MainChairPanel.setBackground(Color.red);
        Date noww=new Date();
        MainChair.DateGetOut.setTime(noww.getTime() + 3000);

    }
     public static void  SetImageToPanel(JPanel panel,String image){
       System.out.print(Path.of("").toAbsolutePath().toString());
       ImageIcon img = new ImageIcon( Path.of("").toAbsolutePath().toString()+"/src/os2project/"+image);
       JLabel l = new JLabel(img);
       panel.removeAll();
       panel.revalidate();
       panel.repaint(); 
       panel.add(l);
        
   
    
    }
     public synchronized void SetStudentChair(StudentModel std){
     
           for(int x=0;x<GridOfStudentChairsData.size()-1;x++){
           if(GridOfStudentChairsData.get(x).Isavlable){
           GridOfStudentChairsData.get(x).Isavlable=false;
           Queue.add(std.Id);
           SetImageToPanel(GridOfStudentChairsData.get(x).ChairSt,"S.jpg");
           GridOfStudentChairsData.get(x).Status='S';
           GridOfStudentChairsData.get(x).StudentId=std.Id;
           System.out.println("Student "+Integer.toString(std.Id)+" Add To Chair"+Integer.toString(x+1));

           break;
           }
           }
           
           
           
     }
     
     
}
