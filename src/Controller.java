/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieTicket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;


public class Controller{
    
    private View1 views;
    private static Model m;

    Controller (Model model, View1 view)
    {
        views = view;
        views.addALSeats(new seatListener());
        
    }
    
    class seatListener implements ActionListener {                                        
        public void actionPerformed(ActionEvent e) {
            views.checkout();
        }   
        
        public void btnSignup(View v)
    {
        m.createUser(v.getSignUpUser(), v.getSignUpPass());
        v.setStatus(m.getStatus());
        
    }
    }  
}

