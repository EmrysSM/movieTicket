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
import java.util.ArrayList;
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
    private String dateTime;
    private String movie;
    private String seat;
    
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
//    public String getdateTime(){
//        return dateTime;
//    }
//    public String getMovie(){
//        return movie;
//    }
//    public String getSeat(){
//        return seat;
//    }
    
      
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
          views.setTab(2);
       }
   } ; views.loginButton(listenerButtonLogin);
   
   
   // Date - taking the date and calling method from Model to insert date to darabase
   listenerButtonDate= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
           dateTime = views.getDate() + " " + views.getTime() + ":00";
           ArrayList<String> list = m.getMovie(dateTime);
           
           views.setMovies(list);
           views.setTab(3);
         //   views.getDateTextField().setText(views.getDateTextField()+ " ");
       }
   } ; views.submitDate(listenerButtonDate);
//   
//    listenerButtonTime= new ActionListener(){
//       public void actionPerformed(ActionEvent evt){
//           m.createDate(views.getTime());
//       }
//   } ; views.submitTime(listenerButtonTime);
//   
   listenerButtonMovie= new ActionListener(){
     public void actionPerformed(ActionEvent evt){
           //m.createDate(views.getMovie());
           movie = views.getMovie();
           views.setTab(4);
       }
   } ; views.submitMovie(listenerButtonMovie);
   
    listenerseatD4= new ActionListener(){
       public void actionPerformed(ActionEvent evt){
           seat = views.getSeat();
          m.createSeat(dateTime, movie, seat);
          views.setTab(5); 
          views.setConfirmation(seat, dateTime, movie);
       }
   } ; views.submitSeats(listenerseatD4);
   
   /* 
        Getting date, time, and movie should be used to access existing db 
        entries in times table. Should there be another table in the DB for
        saving confirmed tickets?
   */
   
   // provide datetime values in 'YYYY-MM-DD HH:MM:SS' format
   
   
   
   
   
      }
      
      
    }  


