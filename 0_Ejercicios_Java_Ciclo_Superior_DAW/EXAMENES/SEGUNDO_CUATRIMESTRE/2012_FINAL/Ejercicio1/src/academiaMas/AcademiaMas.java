package academiaMas;

import ventanas.MenuPrincipal;

/**
 *
 * @author IVAN
 */
public class AcademiaMas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuPrincipal jf=new MenuPrincipal();             //crear un objeto del Frame
        jf.setVisible(true);                //hacer Frame visible
        jf.setLocationRelativeTo(null);     //posición relativa nula del Frame
    }
    
}