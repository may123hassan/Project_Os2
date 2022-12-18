/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package os2project.models;

/**
 *
 * @author Mohab
 */
public class StudentModel {
    public int Id;
    public int Status;
     public StudentModel(){
     
     }
    
    public StudentModel(int id,int status){
        this.Id=id;
        this.Status=status;
    
    
    }
    
    public StudentModel CreateNewStudent(int Id){
    return  new StudentModel(Id, 'S');
    }
    
}