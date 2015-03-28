/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Model;

import hw02.Model.SoundBasic.Sound;
import hw02.Model.SoundBasic.genTone;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author huangjiayu
 */
public class WaveModel {

    public static enum WaveForm {

        TIME, FREC;
    }

    public static enum WaveChannel {

        MONO, DOUBLE;
    }

    private short[] rawWave;
    private double[] fftWaveL;
    private double[] fftWaveR;
    private short[] rawWaveL;
    private short[] rawWaveR;
    private int startIdx;
    private int endIdx;
    private WaveForm waveform;
    private WaveChannel channel;
    private double amplifier;
    private double sampleRate;
    public final double DEFAULTAMP = 0.0625;

    /**
     * The constructor of the wave model. It initialize all necessary attributes
     * and provides a basic wave to avoid null exceptions for drawing.
     *
     */
    public WaveModel() {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(0, 0, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.fftWaveL = null;
        this.fftWaveR = null;
        this.rawWaveL = null;
        this.rawWaveR = null;
        this.startIdx = 0;
        this.endIdx = this.rawWave.length;
        this.waveform = WaveForm.TIME;
        this.channel = WaveChannel.MONO;
        this.amplifier = DEFAULTAMP;
    }

    /**
     * Callen when the user want a generated wave; if null is given, do nothing.
     *
     * @param raw the raw wave that is generated with the uesr's specifications.
     */
    public void generateWaveModel(short[] raw) {
        if (raw != null) {
            this.rawWave = raw;
            this.waveform = WaveForm.TIME;
            this.channel = WaveChannel.MONO;
            this.startIdx = 0;
            this.endIdx = this.rawWave.length;
            this.sampleRate = genTone.getStdFreq();
        }
    }

    /**
     * Called when user want to open a file.
     *
     * @param fileinput the file that the user intend to open; if null, do
     * nothing.
     * @throws IOException
     * @throws UnsupportedAudioFileException
     */
    public void readFileWaveModel(File fileinput) throws IOException, UnsupportedAudioFileException {
        if (fileinput == null) {
            return;
        }
        Sound rawSound = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath());
        this.sampleRate = rawSound.getAf().getSampleRate();
        this.rawWave = rawSound.getShortRepresentation();
        this.waveform = WaveForm.TIME;
        if (rawSound.getAf().getChannels() == 1) {
            this.channel = WaveChannel.MONO;
            this.startIdx = 0;
            this.endIdx = this.rawWave.length;
        } else {
            this.channel = WaveChannel.DOUBLE;
            separateLeftAndRightChannel();
            this.startIdx = 0;
            this.endIdx = this.rawWaveL.length;
        }
    }

    /**
     * called when the opened file is a dual channel file, and separate the left
     * and the right channel.
     */
    private void separateLeftAndRightChannel() {
        this.rawWaveL = new short[this.rawWave.length / 2];
        this.rawWaveR = new short[this.rawWave.length / 2];
        for (int i = 0; i < this.rawWave.length / 2; ++i) {
            this.rawWaveL[i] = this.rawWave[2 * i];
            this.rawWaveR[i] = this.rawWave[2 * i + 1];
        }
    }

    /**
     * Called when the user want to view the sound wave in the frequency domain.
     */
    public void FT() {
        if (this.channel == WaveChannel.DOUBLE) {
            this.waveform = WaveForm.FREC;
            this.fftWaveL = hw02.Model.MathBasic.DFT.getMagnitudeResult(rawWaveL);
            this.fftWaveR = hw02.Model.MathBasic.DFT.getMagnitudeResult(rawWaveR);
        } else if (this.channel == WaveChannel.MONO) {
            this.waveform = WaveForm.FREC;
            this.fftWaveL = hw02.Model.MathBasic.DFT.getMagnitudeResult(rawWave);
            this.fftWaveR = this.fftWaveL;
        }
    }

    /**
     * Called when the user want to zoom in the wave
     */
    public void zoomIn() {
        this.amplifier *= 2;
    }

    /**
     * Called when the user want to zoom out the wave
     */
    public void zoomOut() {
        if (this.isShrinkable()) {
            this.amplifier = this.amplifier / 2;
        } else {
            return;
        }
    }

    //Getters and Setters.
    public WaveChannel getChannel() {
        return channel;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public WaveForm getWaveform() {
        return waveform;
    }

    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }

    public double getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public void setWaveform(WaveForm waveform) {
        this.waveform = waveform;
    }

    public void setChannel(WaveChannel channel) {
        this.channel = channel;
    }

    public short[] getRawWave() {
        return rawWave;
    }

    public void setRawWave(short[] rawWave) {
        this.rawWave = rawWave;
    }

    public double[] getFftWaveL() {
        return fftWaveL;
    }

    public void setFftWaveL(double[] fftWaveL) {
        this.fftWaveL = fftWaveL;
    }

    public double[] getFftWaveR() {
        return fftWaveR;
    }

    public void setFftWaveR(double[] fftWaveR) {
        this.fftWaveR = fftWaveR;
    }

    public short[] getRawWaveL() {
        return rawWaveL;
    }

    public void setRawWaveL(short[] rawWaveL) {
        this.rawWaveL = rawWaveL;
    }

    public short[] getRawWaveR() {
        return rawWaveR;
    }

    public void setRawWaveR(short[] rawWaveR) {
        this.rawWaveR = rawWaveR;
    }

    public boolean isShrinkable() {
        return (this.amplifier > DEFAULTAMP);
    }

    public double getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(double amplifier) {
        this.amplifier = amplifier;
    }

}
