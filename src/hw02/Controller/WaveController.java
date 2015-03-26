/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Controller;

import hw02.Model.WaveModel;
import hw02.View.WaveView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author huangjiayu
 */
public class WaveController implements ActionListener, AdjustmentListener {

    private WaveModel theModel;
    private WaveView theView;

    public WaveController(WaveModel theModel, WaveView theView) {
        this.theModel = theModel;
        this.theView = theView;
        theView.getNewMeunItem().addActionListener(this);
        theView.getOpenMeunItem().addActionListener(this);
        updatewave();
    }

    public void updatewave() {
        this.theView.getWaveFormComponent1().setRawWave(this.theModel.getRawWave());
        this.theView.getWaveFormComponent2().setRawWave(this.theModel.getRawWave2());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theView.getNewMeunItem()) {
            try {
                theModel.generateWaveModel(PopUpUtility.genWave());
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(WaveController.class.getName()).log(Level.SEVERE, null, ex);
            }
            updatewave();
        } else if (e.getSource() == theView.getOpenMeunItem()) {
            while (true) {

                try {
                    theModel.readFileWaveModel(PopUpUtility.getFile());
                    break;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Error", "Bad File", JOptionPane.ERROR_MESSAGE);
                    continue;

                } catch (UnsupportedAudioFileException ex) {
                    JOptionPane.showMessageDialog(null, "UnSupported Audio", "Bad File", JOptionPane.ERROR_MESSAGE);
                    continue;

                }

            }
            updatewave();

        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == theView.getScrpanLeft().getVerticalScrollBar()) {

        }
    }

}
