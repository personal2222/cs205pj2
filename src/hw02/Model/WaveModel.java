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

    public static enum WaveType {

        GENARATED, READFILE;
    }

    public static enum WaveForm {

        TIME, FREC;
    }

    private short[] rawWave;
    private int startIdx;
    private int endIdx;
    private WaveType wavetype;
    private WaveForm waveform;
    private double[] fwave;
    private Sound raw;

    public WaveModel() throws UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(400, 0.5, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.raw = hw02.Model.SoundBasic.genTone.translateToSound(this.rawWave);
        this.startIdx = 0;
        this.endIdx = 1000;
        this.wavetype = WaveType.GENARATED;
        this.waveform = WaveForm.TIME;
    }

    public WaveModel(double freq, double amp, double dur) throws UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(freq, amp, dur, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.raw = hw02.Model.SoundBasic.genTone.translateToSound(this.rawWave);
        this.startIdx = 0;
        this.endIdx = 1000;
        this.wavetype = WaveType.GENARATED;
        this.waveform = WaveForm.TIME;
    }

    public WaveModel(File fileinput) throws IOException, UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath()).getShortRepresentation();
        this.raw = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath());
        this.startIdx = 0;
        this.endIdx = 1000;
        this.waveform = WaveForm.TIME;
        this.wavetype = WaveType.READFILE;
    }

    public short[] getRawWave() {
        return rawWave;
    }

    public void setRawWave(short[] rawWave) {
        this.rawWave = rawWave;
    }

    public int getStartIdx() {
        return startIdx;
    }

    public WaveType getWavetype() {
        return wavetype;
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

    //TODO USEFT HERE
}
