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
 * @author Ruby
 */
public class PopUpUtility {

    public static short[] genWave() {
        ToneType toneType = PopUpUtility.getToneType();
        int freq = PopUpUtility.getFreq();
        double amplitude = PopUpUtility.getAmplitude();
        double duration = PopUpUtility.getDuration();
        if (freq == -1 || amplitude == -1 || duration == -1) {
            return null;
        } else {
            return genTone.generatePureTone(freq, amplitude, duration, toneType);
        }
    }

    public static ToneType getToneType() {
        boolean EXIT = false;
        while (true) {
            genTone.ToneType toneType = PopUps.toneTypePopUp();
            if (toneType == null) {
                EXIT = PopUps.exitComfirm();
                if (EXIT) {
                    return null;
                } else {
                    continue;
                }
            }
            return toneType;
        }
    }

    public static int getFreq() {
        int freq = 0;
        boolean EXIT = false;
        while (true) {
            String freqStr = PopUps.frequencyPopUp();
            if (freqStr == null) {
                EXIT = PopUps.exitComfirm();
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

    public static double getAmplitude() {
        boolean EXIT = false;
        double amplitude = 0.0;
        while (true) {
            String amplitudeStr = PopUps.amplitudePopUp();
            if (amplitudeStr == null) {
                EXIT = PopUps.exitComfirm();
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

    public static double getDuration() {
        boolean EXIT = false;
        double duration = 0.0;
        while (true) {
            String durationStr = PopUps.durationPopUp();
            if (durationStr == null) {
                EXIT = PopUps.exitComfirm();
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

    public static File getFile() {
        return PopUps.chooseFile();
    }
}
