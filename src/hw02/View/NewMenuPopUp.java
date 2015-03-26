/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.View;

import hw02.Model.SoundBasic.genTone.ToneType;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruby
 */
public class NewMenuPopUp {

    public static void main(String[] args) {
        NewMenuPopUp.popUp();
    }

    public static void popUp() {
        boolean EXIT = false;
        while (true) {
            ToneType toneType = (ToneType) JOptionPane.showInputDialog(null, "Select wave type",
                                                                       "What type of wave do you want to generate?",
                                                                       JOptionPane.QUESTION_MESSAGE, null,
                                                                       ToneType.values(), ToneType.SINE);
            if (toneType == null) {
                EXIT = exit();
                if (EXIT) {
                    return;
                } else {
                    continue;
                }
            }
            break;
        }
        int freq = 0;
        while (true) {
            String freqStr = JOptionPane.showInputDialog(null, "What frequency do you want to generate?\nWe can only take in integers as input", 0);
            try {
                freq = Integer.parseInt(freqStr);
                break;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input an interger for frequency.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
        double amplitude = 0.0;
        while (true) {
            String amplitudeStr = JOptionPane.showInputDialog(null, "What amplitude do you want your generated tone have\n"
                                                                    + "We can only take real nunbers from 0 to 1 as input", 0);
            try {
                amplitude = Double.parseDouble(amplitudeStr);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input real number for amplitude.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (amplitude > 1 || amplitude < 0) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input  from 0 to 1 for amplitude.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            } else {
                break;
            }
        }

        double duration = 0.0;
        while (true) {
            String durationStr = JOptionPane.showInputDialog(null, "How long is your generated tone?\nWe can only take in real numbers as input", 0);
            try {
                duration = Double.parseDouble(durationStr);
                break;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input an interger for frequency.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            }

        }

    }

    public static boolean exit() {
        int isExit = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (isExit == 0) {
            return true;
        } else if (isExit == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static File chooseFile() {
        JFileChooser fChooser = new JFileChooser(".");
        fChooser.showOpenDialog(fChooser);
        return fChooser.getSelectedFile();
    }
}
