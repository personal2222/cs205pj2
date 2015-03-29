/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.View;

import hw02.Model.SoundBasic.genTone.ToneType;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Zhengri Fan, Jiayu Huang
 */
public class PopUps {

    /**
     * a popup menu for asking the duration
     *
     * @return the input of the user.
     */
    public static String durationPopUp() {
        String durationStr = JOptionPane.showInputDialog(null, "How long is your generated tone in seconds?\nWe can only take in real numbers as input", 0);
        return durationStr;
    }

    /**
     * a popup menu for asking the amplitude
     *
     * @return the input of the user.
     */
    public static String amplitudePopUp() {
        String amplitudeStr = JOptionPane.showInputDialog(null, "What amplitude do you want your generated tone have\n"
                                                                + "We can only take real nunbers from 0 to 1 as input", 0);
        return amplitudeStr;
    }

    /**
     * a popup menu for asking the frequency
     *
     * @return the input of the user.
     */
    public static String frequencyPopUp() {
        String freqStr = JOptionPane.showInputDialog(null, "What frequency do you want to generate?\nWe can only take in integers as input", 0);
        return freqStr;
    }

    /**
     * a popup menu for asking the tonetype
     *
     * @return the ToneType object that the user chose.
     */
    public static ToneType toneTypePopUp() throws HeadlessException {
        ToneType toneType = (ToneType) JOptionPane.showInputDialog(null, "Select wave type",
                                                                   "What type of wave do you want to generate?",
                                                                   JOptionPane.QUESTION_MESSAGE, null,
                                                                   ToneType.values(), ToneType.SINE);
        return toneType;
    }

    /**
     * a popup menu for comfirmation to exit.
     *
     * @return true for comfirmed for exit, otherwise not.
     */
    public static boolean exitComfirm() {
        int isExit = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (isExit == 0) {
            return true;
        } else if (isExit == 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * a popup menu for comfirmation to cancel the input.
     *
     * @return true for comfirmed for cancel, otherwise not.
     */
    public static boolean cancelComfirm() {
        int isExit = JOptionPane.showConfirmDialog(null, "Do you want to cancel?", "cancel?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (isExit == 0) {
            return true;
        } else if (isExit == 1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * A popup menu for choose a file from user.
     *
     * @return the File object representing the file that the user chose.
     */
    public static File chooseFile() {
        JFileChooser fChooser = new JFileChooser(".");
        fChooser.showOpenDialog(fChooser);
        return fChooser.getSelectedFile();
    }
}
