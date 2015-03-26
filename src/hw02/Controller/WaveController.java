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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        if (e.getSource() == theView.getScrpanLeft().getVerticalScrollBar()) {

        }
    }

}
