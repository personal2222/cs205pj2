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
import java.awt.Dimension;
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

    public enum WaveType {

        DOUBLE, BYTE, SHORT;
    }

    private short[] rawWave;
    private int startIdx;
    private int endIdx;
    private WaveType waveType;
    private byte[] rawByteWave;
    private double[] rawDoubleWave;
    private double amplifier;
    public final double DEFAULTAMP = 0.03125;

    public WaveFormComponent() {
        this.rawWave = null;
        this.startIdx = 0;
        this.endIdx = 0;
        this.rawByteWave = null;
        this.rawDoubleWave = null;
        this.waveType = WaveType.SHORT;
        this.amplifier = DEFAULTAMP;
    }

    public void setRawWave(short[] rawWave) {
        this.rawWave = rawWave;
        this.repaint();
    }

    // Setters
    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
        this.repaint();
    }

    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
        this.repaint();
    }

    public WaveType getWaveType() {
        return waveType;
    }

    public void setWaveType(WaveType waveType) {
        this.waveType = waveType;
        this.repaint();
    }

    public byte[] getRawByteWave() {
        return rawByteWave;
    }

    public void setRawByteWave(byte[] rawByteWave) {
        this.rawByteWave = rawByteWave;
        this.repaint();
    }

    public double[] getRawDoubleWave() {
        return rawDoubleWave;
    }

    public void setRawDoubleWave(double[] rawDoubleWave) {
        this.rawDoubleWave = rawDoubleWave;
        this.repaint();
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

    @Override
    protected void paintComponent(Graphics g) {
        if (this.waveType == WaveType.SHORT) {
            this.paintShort(g);
        } else if (this.waveType == WaveType.SHORT) {
            this.paintByte(g);
        } else if (this.waveType == WaveType.DOUBLE) {
            this.paintDouble(g);
        }
    }

    private void paintShort(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point prevPoint = new Point(0, this.getHeight() / 2);
        Point curPoint;
        Line2D.Double lineToRender;
        g2d.setColor(Color.BLACK);
        lineToRender = new Line2D.Double(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g2d.draw(lineToRender);
        g2d.setColor(Color.BLUE);
        for (int i = this.startIdx; i < this.endIdx; ++i) {
            int yValue = (int) (((((double) this.getHeight() / 2) / Short.MAX_VALUE) * this.rawWave[i]));
            int xValue = (int) (i * this.amplifier);
            curPoint = new Point(xValue, yValue + this.getHeight() / 2);
            lineToRender = new Line2D.Double(prevPoint, curPoint);
            g2d.draw(lineToRender);
            prevPoint = curPoint;
        }
    }

    private void paintByte(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point prevPoint = new Point(0, this.getHeight() / 2);
        Point curPoint;
        Line2D.Double lineToRender;
        g2d.setColor(Color.BLACK);
        lineToRender = new Line2D.Double(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g2d.draw(lineToRender);
        g2d.setColor(Color.BLUE);
        for (int i = this.startIdx; i < this.endIdx; ++i) {
            int yValue = (int) (((((double) this.getHeight() / 2) / Byte.MAX_VALUE) * this.rawByteWave[i]));
            int xValue = (int) (i * this.amplifier);
            curPoint = new Point(xValue, yValue + this.getHeight() / 2);
            lineToRender = new Line2D.Double(prevPoint, curPoint);
            g2d.draw(lineToRender);
            prevPoint = curPoint;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.endIdx, 100); //To change body of generated methods, choose Tools | Templates.
    }

    private void paintDouble(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Point prevPoint = new Point(0, this.getHeight() / 2);
        Point curPoint;
        Line2D.Double lineToRender;
        g2d.setColor(Color.BLACK);
        lineToRender = new Line2D.Double(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2);
        g2d.draw(lineToRender);
        g2d.setColor(Color.BLUE);
        double max = this.maxAbsDouble();
        for (int i = this.startIdx; i < this.endIdx; ++i) {
            int yValue = (int) (((((double) this.getHeight() / 2) / max) * this.rawDoubleWave[i]));
            int xValue = (int) (i * this.amplifier);
            curPoint = new Point(xValue, yValue + this.getHeight() / 2);
            lineToRender = new Line2D.Double(prevPoint, curPoint);
            g2d.draw(lineToRender);
            prevPoint = curPoint;
        }
    }

    public double getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(double amplifier) {
        this.amplifier = amplifier;
    }

    private double maxAbsDouble() {
        double max = Double.MIN_VALUE;
        for (double x : this.rawDoubleWave) {
            double absX = Math.abs(x);
            if (absX > max) {
                max = absX;
            }
        }
        return max;
    }

}
