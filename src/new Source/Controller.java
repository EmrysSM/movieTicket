/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;


public class Controller{
    
    public View1 views;
    public static Model m;

    //Listeners
    private ActionListener listenerButtonSignup;
    private ActionListener listenerButtonLogin;
    private ActionListener listenerButtonDate;
    private ActionListener listenerButtonTime;
    private ActionListener listenerButtonMovie;
    private ActionListener listenerseatD4;
    
    public Controller()
    {
        init();
    }
    public void init(){
    m= new Model();
    views= new View1();
    setActions();
    views.setVisible(true);
    
}
    
    
        /*
        public void btnSignUp(View1 v)
    {
        m.createUser(v.gettxtUserName2(), v.gettxtPasswordSignUp());
        
    }
        
        public void btnLogin(View1 v)
    {
        m.login(v.getLoginUser(), v.getLoginPass());
       
    }
      public void btnDate(View1 v)
    {
        m.createDate(v.getDate());
       
    }
      public void btnTime(View1 v)
    {
        m.createTime(v.getTime());
       
    }
      public void btnMovie(View1 v)
    {
        m.createMovie(v.getTime());
       
    } */
      
      
      //The method using our listeners from our view. 
      public void setActions(){
          
      //Sign up 
      listenerButtonSignup= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
          m.createUser(views.gettxtUserName2(), views.gettxtPasswordSignUp());
       }
   } ; views.signUpButton(listenerButtonSignup);
   
   //Login
   listenerButtonLogin= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
          m.login(views.getLoginUser(), views.getLoginPass());
       }
   } ; views.loginButton(listenerButtonLogin);
   
   //Date - taking the date and calling method from Model to insert date to darabase
   listenerButtonDate= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
           m.createDate(views.getDate());
         //   views.getDateTextField().setText(views.getDateTextField()+ " ");
       }
   } ; views.submitDate(listenerButtonDate);
   
    listenerButtonTime= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
           m.createDate(views.getTime());
       }
   } ; views.submitTime(listenerButtonTime);
   
   listenerButtonMovie= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
           m.createDate(views.getMovie());
       }
   } ; views.submitMovie(listenerButtonMovie);
   
    listenerseatD4= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
          m.createDate(views.getSeat());
       }
   } ; views.submitSeats(listenerseatD4);
   
   
   
   
   
   
      }
      
      
    }  


