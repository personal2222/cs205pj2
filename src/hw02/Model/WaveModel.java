/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Model;

import hw02.Model.SoundBasic.Sound;
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
    private byte[] rawWaveL;
    private byte[] rawWaveR;
    private int startIdx;
    private int endIdx;
    private WaveForm waveform;
    private WaveChannel channel;

    public WaveModel() throws UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(0, 0, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.fftWaveL = null;
        this.fftWaveR = null;
        this.rawWaveL = null;
        this.rawWaveR = null;
        this.startIdx = 0;
        this.endIdx = this.rawWave.length;
        this.waveform = WaveForm.TIME;
        this.channel = WaveChannel.MONO;
    }

    public void generateWaveModel(short[] raw) throws UnsupportedAudioFileException {
        if (raw != null) {
            this.rawWave = raw;
            this.waveform = WaveForm.TIME;
            this.channel = WaveChannel.MONO;
            this.startIdx = 0;
            this.endIdx = this.rawWave.length;
        }
    }

    //TODO TEST
    public void readFileWaveModel(File fileinput) throws IOException, UnsupportedAudioFileException {
        Sound rawSound = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath());
        if (rawSound == null) {
            return;
        }
        this.rawWave = rawSound.getShortRepresentation();
        this.waveform = WaveForm.TIME;
        if (rawSound.getAf().getChannels() == 1) {
            this.channel = WaveChannel.MONO;
            this.startIdx = 0;
            this.endIdx = this.rawWave.length;
        } else {
            this.rawWaveL = new byte[this.rawWave.length];
            this.rawWaveR = new byte[this.rawWave.length];
            this.channel = WaveChannel.DOUBLE;
            int idx = 0;
            for (short i : this.rawWaveL) {
                this.rawWaveL[idx] = (byte) (i >> 8);
                this.rawWaveR[idx] = (byte) (i & 0xff);
                idx++;
            }
            this.startIdx = 0;
            this.endIdx = this.rawWaveL.length;
        }
    }

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

    public byte[] getRawWaveL() {
        return rawWaveL;
    }

    public void setRawWaveL(byte[] rawWaveL) {
        this.rawWaveL = rawWaveL;
    }

    public byte[] getRawWaveR() {
        return rawWaveR;
    }

    public void setRawWaveR(byte[] rawWaveR) {
        this.rawWaveR = rawWaveR;
    }

}
