/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.View;

import hw02.Model.SoundBasic.genTone.ToneType;
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
        ToneType toneType = (ToneType) JOptionPane.showInputDialog(null, "Select wave type",
                                                                   "What type of wave do you want to generate?",
                                                                   JOptionPane.QUESTION_MESSAGE, null,
                                                                   ToneType.values(), ToneType.SINE);
        String freqStr = JOptionPane.showInputDialog(null, "What frequency do you want to generate?\nWe can only take in integers as input", 0);
        int freq = 0;
        try {
            freq = Integer.parseInt(freqStr);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Invalid input, plaese input an interger for frequency.", "Bad input", JOptionPane.ERROR_MESSAGE);
        }

    }

}
