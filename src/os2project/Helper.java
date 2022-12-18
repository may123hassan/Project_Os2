/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static os2project.Gui.SetImageToPanel;
import os2project.models.ChairModel;

/**
 *
 * @author mohab
 */
public class Helper {
    public int MainHeigth;  
    public int MainWidth;
    public int ItemHeight;  
    public int ItemWidth;
    public int ItemCount;

    public Helper(){
    
     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
     MainWidth = (int)screenSize.getWidth();
     MainHeigth = (int)screenSize.getHeight();
     ItemHeight=147;   
     ItemWidth=147;
     ItemCount=MainWidth-200/ItemHeight+5;
     
    }
    public ArrayList<ChairModel> GetGridOfFreeChairs(int ChairsCount){
     ArrayList<ChairModel> AllChairs=new ArrayList<ChairModel>();
         int Space_x=400; 
         int Space_y=15;
        for(int x=1;x<ChairsCount;x++){
              
             JPanel SingelCahir = new JPanel(); 
                if(this.MainWidth-50<Space_x+ this.ItemWidth+5){
                Space_y=Space_y+147+5;
                Space_x=400;
                }

             SingelCahir.setBounds(Space_x, Space_y, this.ItemWidth, this.ItemHeight);   
             SingelCahir.setBackground(Color.white);
             
             ChairModel model=new ChairModel(x+1,SingelCahir,null,null);
             AllChairs.add(model);
            
             SetImageToPanel(SingelCahir,"E.jpg");
             

             

             Space_x =Space_x+ this.ItemWidth+5;

         
         
         }
       return AllChairs; 
    
    }

    
    
    public ArrayList<ChairModel> GetListOfTeachersChairs(int ChairsCount){
     ArrayList<ChairModel> AllChairs=new ArrayList<ChairModel>();
         int Space_x=10; 
         int Space_y=15;
        for(int x=1;x<ChairsCount;x++){
            
              
             JPanel MeatingPanel = new JPanel(); 
             JPanel SingelCahir = new JPanel();   
  
             JPanel SingelTeacherCahir = new JPanel(); 

            SingelCahir
             .setBounds(Space_x, Space_y, this.ItemWidth, this.ItemHeight);     
             SingelTeacherCahir.setBounds(Space_x+5+147, Space_y, this.ItemWidth+30, this.ItemHeight);       
       
             MeatingPanel.setBounds(Space_x, Space_y, this.ItemWidth*2+30, this.ItemHeight+5);
             Space_y=Space_y+147+5;
             MeatingPanel.add(SingelCahir);
             MeatingPanel.add(SingelTeacherCahir);
             MeatingPanel.setBackground(Color.white);  
             SingelCahir.setBackground(Color.white);  
             SingelTeacherCahir.setBackground(Color.white);




             
             
             
             
             ChairModel model=new ChairModel(x+1,SingelCahir,SingelTeacherCahir,MeatingPanel);
             AllChairs.add(model);
            
             SetImageToPanel(SingelCahir,"E.jpg");   
             SetImageToPanel(SingelTeacherCahir,"sleep.png");
        }
             return AllChairs; 
    
    }

    
    
}
