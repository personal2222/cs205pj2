/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2015
 *
 * Name: Zhengri Fan, Jiayu Huang
 * Date: 2015-3-29
 * Time: 17:53:00
 *
 * Project: csci205
 * Package: hw02
 * File: WaveMain
 * Description: Project2 Main File
 *
 * ****************************************
 */
package hw02;

import hw02.Controller.WaveController;
import hw02.Model.WaveModel;
import hw02.View.WaveView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Main Program to Run the Wave Generator
 *
 * @author Zhengri Fan, Jiayu Huang
 */
public class WaveMain {

    /**
     * The main function of the whole project. used in order to start the
     * project.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(WaveView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WaveView theView = new WaveView();
                WaveModel theModel = new WaveModel();
                WaveController theController = new WaveController(theModel, theView);
                theView.setVisible(true);
            }
        });
    }
}
