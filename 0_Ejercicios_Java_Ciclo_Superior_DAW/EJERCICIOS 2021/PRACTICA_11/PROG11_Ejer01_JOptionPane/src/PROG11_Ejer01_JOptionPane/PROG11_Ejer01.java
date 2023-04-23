package PROG11_Ejer01_JOptionPane;

import JFrames.JFramePrincipal;

/**
 *
 * @author IVAN
 */
public class PROG11_Ejer01 {

    public static void main(String[] args) {
        JFramePrincipal jf=new JFramePrincipal();             //crear un objeto del Frame
        jf.setVisible(true);                //hacer Frame visible
        jf.setLocationRelativeTo(null);     //posición relativa nula del Frame
        
        BBDD.ConectarBBDD();
    }   
    
}