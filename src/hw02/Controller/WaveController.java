/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2015
 *
 * Name: Zhengri Fan, Jiayu Huang
 * Date: 2015-3-29
 * Time: 17:53:00
 *
 * Project: csci205
 * Package: hw02.Controller
 * File: WaveController
 * Description: MainController (MVC Structure)
 *
 * ****************************************
 */
package hw02.Controller;

import hw02.Model.WaveModel;
import hw02.Model.WaveModel.WaveChannel;
import hw02.Model.WaveModel.WaveForm;
import hw02.View.PopUps;
import hw02.View.WaveFormComponent;
import hw02.View.WaveView;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 * The main Controller of the Wave Generator
 *
 * @author Zhengri Fan, Jiayu Huang
 */
public class WaveController implements ActionListener {

    private WaveModel theModel;
    private WaveView theView;

    /**
     * Constructor of the contorller. It links the model and the view and add
     * proper actionlisteners to the components.
     *
     * @param theModel
     * @param theView
     */
    public WaveController(WaveModel theModel, WaveView theView) {
        this.theModel = theModel;
        this.theView = theView;
        addActionListener();
        updateView();
    }

    /**
     * Add action linteners.
     */
    private void addActionListener() {
        theView.getNewMeunItem().addActionListener(this);
        theView.getOpenMeunItem().addActionListener(this);
        theView.getExitMeunItem().addActionListener(this);
        theView.getRdbtnFreqView().addActionListener(this);
        theView.getRdbtnTimeView().addActionListener(this);
        theView.getPlusBTN().addActionListener(this);
        theView.getMinusBTN().addActionListener(this);
        theView.getResetSizeMenuBotton().addActionListener(this);
        theView.getResetWaveMeunBotton().addActionListener(this);
    }

    /**
     * update the view, mainly the waveView, from the model.
     */
    private void updateView() {
        if (this.theModel.getWaveform() == WaveForm.FREC) {
            theView.getRdbtnFreqView().setSelected(true);
            FFTUpdate();
        } else if (this.theModel.getWaveform() == WaveForm.TIME) {
            theView.getRdbtnTimeView().setSelected(true);
            if (this.theModel.getChannel() == WaveChannel.MONO) {
                updateMonoSound();
            } else if (this.theModel.getChannel() == WaveChannel.DOUBLE) {
                updateDualChannelSound();
            }
        }
        if (!this.theModel.isShrinkable()) {
            this.theView.getMinusBTN().setEnabled(false);
        } else {
            this.theView.getMinusBTN().setEnabled(true);
        }
        this.theView.getWaveFormComponent1().setSampleRate(this.theModel.getSampleRate());
        this.theView.getWaveFormComponent2().setSampleRate(this.theModel.getSampleRate());
    }

    /**
     * Helper method for updating the view when the sound is a dual channel
     * sound.
     */
    private void updateDualChannelSound() {
        theView.getWaveFormComponent1().setRawWave(theModel.getRawWaveL());
        theView.getWaveFormComponent2().setRawWave(theModel.getRawWaveR());
        theView.getWaveFormComponent1().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
        theView.getWaveFormComponent2().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
        theView.getWaveFormComponent1().setStartIdx(theModel.getStartIdx());
        theView.getWaveFormComponent1().setEndIdx(theModel.getEndIdx());
        theView.getWaveFormComponent2().setStartIdx(theModel.getStartIdx());
        theView.getWaveFormComponent2().setEndIdx(theModel.getEndIdx());
        this.theView.getWaveFormComponent1().setAmplifier(this.theModel.getAmplifier());
        this.theView.getWaveFormComponent2().setAmplifier(this.theModel.getAmplifier());
        this.theView.getChannelLab().setText("Stereo Sound");
    }

    /**
     * Helper method for updating the view when the sound is a mono channel
     * sound.
     */
    private void updateMonoSound() {
        theView.getWaveFormComponent1().setRawWave(theModel.getRawWave());
        theView.getWaveFormComponent2().setRawWave(theModel.getRawWave());
        theView.getWaveFormComponent1().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
        theView.getWaveFormComponent2().setWaveType(hw02.View.WaveFormComponent.WaveType.SHORT);
        theView.getWaveFormComponent1().setStartIdx(theModel.getStartIdx());
        theView.getWaveFormComponent1().setEndIdx(theModel.getEndIdx());
        theView.getWaveFormComponent2().setStartIdx(theModel.getStartIdx());
        theView.getWaveFormComponent2().setEndIdx(theModel.getEndIdx());
        theView.getWaveFormComponent1().setAmplifier(this.theModel.getAmplifier());
        theView.getWaveFormComponent2().setAmplifier(this.theModel.getAmplifier());
        this.theView.getChannelLab().setText("Mono Sound");
    }

    /**
     * Helper method for updating the view when the the user asks for the FFT
     * result.
     */
    private void FFTUpdate() {
        this.theView.getWaveFormComponent1().setRawDoubleWave(theModel.getFftWaveL());
        this.theView.getWaveFormComponent2().setRawDoubleWave(theModel.getFftWaveR());
        this.theView.getWaveFormComponent2().setWaveType(WaveFormComponent.WaveType.DOUBLE);
        this.theView.getWaveFormComponent1().setWaveType(WaveFormComponent.WaveType.DOUBLE);
        this.theView.getWaveFormComponent1().setAmplifier(this.theModel.getAmplifier());
        this.theView.getWaveFormComponent2().setAmplifier(this.theModel.getAmplifier());
        this.theView.getChannelLab().setText("Freq vs. Amp");
    }

    /**
     * Action listener of several components in the view.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theView.getNewMeunItem()) {
            this.theModel.generateWaveModel(PopUpUtility.genWave());
            this.theModel.resetAmplifier();
            updateView();
        } else if (e.getSource() == theView.getOpenMeunItem()) {
            openFile();
            this.theModel.resetAmplifier();
            updateView();

        } else if (e.getSource() == theView.getExitMeunItem()) {
            boolean isExit = PopUps.exitComfirm();
            if (isExit) {
                theView.dispose();
                System.exit(0);
            }

        } else if (e.getSource() == theView.getRdbtnFreqView()) {
            theModel.FT();
            updateView();
        } else if (e.getSource() == theView.getRdbtnTimeView()) {
            theModel.setWaveform(WaveForm.TIME);
            updateView();
        } else if (e.getSource() == theView.getPlusBTN()) {
            theModel.zoomIn();
            updateView();
        } else if (e.getSource() == theView.getMinusBTN()) {
            theModel.zoomOut();
            updateView();
        } else if (e.getSource() == theView.getResetSizeMenuBotton()) {
            theModel.resetAmplifier();
            updateView();
        } else if (e.getSource() == theView.getResetWaveMeunBotton()) {
            theModel = new WaveModel();
            updateView();
        }
    }

    /**
     * Helper method. Called when the open button is clicked.
     *
     * @throws HeadlessException
     */
    private void openFile() throws HeadlessException {
        while (true) {
            try {
                this.theModel.readFileWaveModel(PopUpUtility.getFile());
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "File Error", "Bad File", JOptionPane.ERROR_MESSAGE);
                continue;
            } catch (UnsupportedAudioFileException ex) {
                JOptionPane.showMessageDialog(null, "Unsupported Audio", "Bad File", JOptionPane.ERROR_MESSAGE);
                continue;
            }
        }

    }
}
