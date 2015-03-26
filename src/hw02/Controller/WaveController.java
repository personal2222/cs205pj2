/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Controller;

import hw02.Model.WaveModel;
import hw02.Model.WaveModel.WaveChannel;
import hw02.View.WaveView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

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
    }

    public void updatewave() {
        if (this.theModel.getChannel() == WaveChannel.MONO) {
            this.theView.getWaveFormComponent1().setRawWave(this.theModel.getRawWave());
        } else {
            this.theView.getWaveFormComponent1().setRawWave(this.theModel.getRawWave());
            this.theView.getWaveFormComponent2().setRawWave(this.theModel.getRawWave2());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theView.getNewMeunItem()) {
            theView.getWaveFormComponent1().setRawWave(PopUpUtility.genWave());
        }
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == theView.getScrpanLeft().getVerticalScrollBar()) {

        }
    }

}
