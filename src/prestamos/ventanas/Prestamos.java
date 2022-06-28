/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestamos.ventanas;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import javax.swing.UIManager;

/**
 *
 * @author Elisvan
 */
public class Prestamos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
        } catch (Exception e) {
        }
      ventanaprincipal vp = new ventanaprincipal();
        vp.setResizable(false);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
    }
    
}
