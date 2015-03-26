/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw02.Model;

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

    private short[] rawWave;
    private int startIdx;
    private int endIdx;

    public WaveModel() {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(400, 0.5, 3, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.startIdx = 0;
        this.endIdx = 1000;
    }

    public WaveModel(double freq, double amp, double dur) {
        this.rawWave = hw02.Model.SoundBasic.genTone.generatePureTone(freq, amp, dur, hw02.Model.SoundBasic.genTone.ToneType.SINE);
        this.startIdx = 0;
        this.endIdx = 1000;
    }

    public WaveModel(File fileinput) throws IOException, UnsupportedAudioFileException {
        this.rawWave = hw02.Model.SoundBasic.SoundIO.read(fileinput.getPath()).getShortRepresentation();
        this.startIdx = 0;
        this.endIdx = 1000;
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

    public void setStartIdx(int startIdx) {
        this.startIdx = startIdx;
    }

    public int getEndIdx() {
        return endIdx;
    }

    public void setEndIdx(int endIdx) {
        this.endIdx = endIdx;
    }

}
