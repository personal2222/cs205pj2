/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Controller;

import hw02.Model.SoundBasic.genTone;
import hw02.Model.SoundBasic.genTone.ToneType;
import hw02.View.PopUps;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Zhengri Fan, Jiayu Huang
 */
public class PopUpUtility {

    /**
     * Ask the user's choices and generate a pure tone.
     *
     * @return a short array representing the generated tone; null if user
     * choose to cancel the generation.
     */
    public static short[] genWave() {
        ToneType toneType = PopUpUtility.getToneType();
        if (toneType == null) {
            return null;
        }
        int freq = PopUpUtility.getFreq();
        if (freq == -1) {
            return null;
        }
        double amplitude = PopUpUtility.getAmplitude();
        if (amplitude == -1) {
            return null;
        }
        double duration = PopUpUtility.getDuration();
        if (duration == -1) {
            return null;
        }
        return genTone.generatePureTone(freq, amplitude, duration, toneType);
    }

    /**
     * Ask the user for the toneType of the generated tone.
     *
     * @return the tonetype that the user want; null for user cancel the input.
     */
    private static ToneType getToneType() {
        boolean EXIT = false;
        while (true) {
            genTone.ToneType toneType = PopUps.toneTypePopUp();
            if (toneType == null) {
                EXIT = PopUps.cancelComfirm();
                if (EXIT) {
                    return null;
                } else {
                    continue;
                }
            }
            return toneType;
        }
    }

    /**
     * Ask the user for the frequency of the generated tone.
     *
     * @return the frequency that the user want; -1 for user cancel the input.
     */
    private static int getFreq() {
        int freq = 0;
        boolean EXIT = false;
        while (true) {
            String freqStr = PopUps.frequencyPopUp();
            if (freqStr == null) {
                EXIT = PopUps.cancelComfirm();
                if (EXIT) {
                    return -1;
                } else {
                    continue;
                }
            }
            try {
                freq = Integer.parseInt(freqStr);
                return freq;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input an interger for frequency.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
    }

    /**
     * Ask the user for the amplitude of the generated tone.
     *
     * @return the amplitude that the user want; -1 for user cancel the input.
     */
    private static double getAmplitude() {
        boolean EXIT = false;
        double amplitude = 0.0;
        while (true) {
            String amplitudeStr = PopUps.amplitudePopUp();
            if (amplitudeStr == null) {
                EXIT = PopUps.cancelComfirm();
                if (EXIT) {
                    return -1;
                } else {
                    continue;
                }
            }
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
                return amplitude;
            }
        }
    }

    /**
     * Ask the user for the duration of the generated tone.
     *
     * @return the duration that the user want; -1 for user cancel the input.
     */
    private static double getDuration() {
        boolean EXIT = false;
        double duration = 0.0;
        while (true) {
            String durationStr = PopUps.durationPopUp();
            if (durationStr == null) {
                EXIT = PopUps.cancelComfirm();
                if (EXIT) {
                    return -1;
                } else {
                    continue;
                }
            }
            try {
                duration = Double.parseDouble(durationStr);
                if (duration <= 100) {
                    return duration;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input, We cannot support duration greater than 100.", "Bad input", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input, plaese input a reael number for duration.", "Bad input", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }
    }

    /**
     * Ask the user to choose a audio file.
     *
     * @return the file that the user chose; null for user cancel the input.
     */
    public static File getFile() {
        boolean EXIT;
        while (true) {
            File toReturn = PopUps.chooseFile();
            if (toReturn == null) {
                EXIT = PopUps.cancelComfirm();
                if (EXIT) {
                    return null;
                } else {
                    continue;
                }
            } else {
                return toReturn;
            }
        }
    }
}
