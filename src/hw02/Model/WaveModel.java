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

    public static enum WaveChannel {

        MONO, DOUBLE;
    }

    private short[] rawWave;
    private short[] rawWave2;
    private int startIdx;
    private int endIdx;
    private WaveType wavetype;
    private WaveForm waveform;
    private WaveChannel channel;
    private double[] fwave;
    private Sound raw;

    public WaveModel() throws UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(0, 0, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.rawWave2 = this.rawWave;
        this.raw = hw02.Model.SoundBasic.genTone.translateToSound(this.rawWave);
        this.startIdx = 0;
        this.endIdx = 1000;
        this.wavetype = WaveType.GENARATED;
        this.waveform = WaveForm.TIME;
        this.channel = WaveChannel.MONO;
    }

    public void generateWaveModel(short[] raw) throws UnsupportedAudioFileException {
        this.rawWave = raw;
        this.rawWave2 = raw;
        this.raw = hw02.Model.SoundBasic.genTone.translateToSound(this.rawWave);
        this.wavetype = WaveType.GENARATED;
        this.waveform = WaveForm.TIME;
        this.channel = WaveChannel.MONO;
    }

    //TODO TEST
    public void readFileWaveModel(File fileinput) throws IOException, UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath()).getShortRepresentation();
        this.raw = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath());
        this.waveform = WaveForm.TIME;
        this.wavetype = WaveType.READFILE;
        if (this.raw.getAf().getChannels() == 1) {
            this.channel = WaveChannel.MONO;
            this.rawWave2 = this.rawWave;
        } else {
            this.channel = WaveChannel.DOUBLE;
            int temp = 0;
            for (short i : this.rawWave) {
                short j = (short) (i * 0xff);
                i = (short) (i >> 8);
                this.rawWave2[temp] = j;
                temp++;
            }

        }
    }

    public short[] getRawWave2() {
        return rawWave2;
    }

    public WaveChannel getChannel() {
        return channel;
    }

    public double[] getFwave() {
        return fwave;
    }

    public Sound getRaw() {
        return raw;
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
