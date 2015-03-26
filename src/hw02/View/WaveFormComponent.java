/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2015
 *
 * Name: Zhengri Fan
 * Date: 2015-3-22
 * Time: 17:16:09
 *
 * Project: csci205
 * Package: hw02.View
 * File: WaveFormComponent
 * Description:
 *
 * ****************************************
 */
package hw02.View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 *
 * @author Zhengri Fan
 */
public class WaveFormComponent extends JComponent {

    private short[] rawWave;
    private int startIdx;
    private int endIdx;
    private double amplifier;

    public WaveFormComponent() {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(400, 0.5, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.startIdx = 0;
        this.endIdx = 1000;
        this.amplifier = 1;
    }

    public WaveFormComponent(short[] rawWave, int startIdx, int endIdx) {
        this.rawWave = rawWave;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    // Setters
    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }

    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }

    //Getters
    public short[] getRawWave() {
        return rawWave;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public double getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(double amplifier) {
        this.amplifier = amplifier;
    }

    public void zoom(double percentage) {
        this.amplifier *= (1 + percentage);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point prevPoint = new Point(0, this.getHeight() / 2);
        Point curPoint;
        Line2D.Double lineToRender;
        g2d.setColor(Color.BLACK);
        lineToRender = new Line2D.Double(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g2d.draw(lineToRender);
        g2d.setColor(Color.BLUE);
        for (int i = this.startIdx; i < this.endIdx; ++i) {
            int yValue = (int) (((((double) this.getHeight() / 2) / Short.MAX_VALUE) * this.rawWave[i]) * this.amplifier);
            int xValue = (int) (((this.getWidth() / (double) (this.endIdx - this.startIdx)) * i) * this.amplifier);
            curPoint = new Point(xValue, yValue + this.getHeight() / 2);
            lineToRender = new Line2D.Double(prevPoint, curPoint);
            g2d.draw(lineToRender);
            prevPoint = curPoint;
        }
    }

}
