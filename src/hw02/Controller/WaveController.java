/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Controller;

import hw02.Model.WaveModel;
import hw02.Model.WaveModel.WaveChannel;
import hw02.Model.WaveModel.WaveForm;
import hw02.View.PopUps;
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
        theView.getExitMeunItem().addActionListener(this);
        theView.getRdbtnFreqView().addActionListener(this);
        updatewave();
    }

    public void updatewave() {
        if (this.theModel.getWaveform() == WaveForm.FREC) {
            //TODO DFT
        } else {
            if (this.theModel.getChannel() == WaveChannel.MONO) {
                theView.getWaveFormComponent1().setRawWave(theModel.getRawWave());
                theView.getWaveFormComponent2().setRawWave(theModel.getRawWave());
                theView.getWaveFormComponent1().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
                theView.getWaveFormComponent2().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
            } else if (this.theModel.getChannel() == WaveChannel.DOUBLE) {
                theView.getWaveFormComponent1().setRawByteWave(theModel.getRawWaveL());
                theView.getWaveFormComponent2().setRawByteWave(theModel.getRawWaveR());
                theView.getWaveFormComponent1().setWaveType(hw02.View.WaveFormComponent.WaveType.BYTE);
                theView.getWaveFormComponent2().setWaveType(hw02.View.WaveFormComponent.WaveType.BYTE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theView.getNewMeunItem()) {
            try {
                this.theModel.generateWaveModel(PopUpUtility.genWave());
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(WaveController.class.getName()).log(Level.SEVERE, null, ex);
            }
            updatewave();
        } else if (e.getSource() == theView.getOpenMeunItem()) {
            while (true) {

                try {
                    this.theModel.readFileWaveModel(PopUpUtility.getFile());
                    //this.theView.getWaveFormComponent1().setEndIdx(this.theModel.getEndIdx());
                    //this.theView.getWaveFormComponent2().setEndIdx(this.theModel.getEndIdx());
                    break;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "File Error", "Bad File", JOptionPane.ERROR_MESSAGE);
                    continue;
                } catch (UnsupportedAudioFileException ex) {
                    JOptionPane.showMessageDialog(null, "UnSupported Audio", "Bad File", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }
            this.theModel.setEndIdx(theModel.getRawWave().length);
            this.theView.getWaveFormComponent1().setEndIdx(this.theModel.getEndIdx());
            this.theView.getWaveFormComponent2().setEndIdx(this.theModel.getEndIdx());
            updatewave();
        } else if (e.getSource() == theView.getExitMeunItem()) {
            boolean isExit = PopUps.exitComfirm();
            if (isExit) {
                theView.dispose();
                System.exit(0);
            }
        } else if (e.getSource() == theView.getRdbtnFreqView()) {
            theModel.FT();
            theModel.setWaveform(WaveForm.FREC);
            updatewave();
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == theView.getScrpanLeft().getVerticalScrollBar()) {

        }
    }

}
