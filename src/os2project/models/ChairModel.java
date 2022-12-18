/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2project.models;

import java.util.Date;
import javax.swing.JPanel;

/**
 *
 * @author Mohab
 */
public class ChairModel {
    public int Id;
    public char Status;
    public int StudentId;
    public boolean Isavlable; 
    public Date DateGetOut;
    public JPanel ChairSt ; 
    public JPanel ChairTa ;  
    public JPanel MeatingPanel ;




    public ChairModel(int id,char status,int studentid,Date d){
    
        this.Id=id;
        this.Status=status;   
        this.StudentId=studentid;
        this.DateGetOut=d;


    }
    
    
    
     public ChairModel(int id,JPanel chair,JPanel chairTa,JPanel meatingPanel ){
    
        this.Id=id;
        this.Status='E';   
        this.StudentId=0; 
        this.ChairSt=chair;
        this.Isavlable=true;
        this.ChairTa=chairTa;
        this.MeatingPanel=meatingPanel;
        DateGetOut=new Date();



    }
}
