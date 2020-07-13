package lk.ac.kln;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class MP4ToMP3Convert implements Converter{

    @Override
    public void Convert(String source,String output) {
//        Encoder toMp3=new Encoder();
//        EncodingAttributes specification=new EncodingAttributes();
//        AudioAttributes audio=new AudioAttributes();
//        audio.setVolume(256);
//        specification.setAudioAttributes(audio);

//        AudioFileFormat inFileFormat;
//        File inFile=null;
//        File outFile=null;
//        try {
//            inFile=new File(source);
//            outFile=new File(output);
////            toMp3.encode(file1,file2,specification);
////            specification.setFormat("mp3");
//
//        } catch (NullPointerException e) {
//            System.out.println("Error in the path. Please recheck the configurations");
//            e.printStackTrace();
//        }
//        try {
//            inFileFormat= AudioSystem.getAudioFileFormat(inFile);
//
//        } catch (UnsupportedAudioFileException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        File sourceFile=new File(source);
        File outputFile=new File(output);
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();
        try {
            encoder.encode(sourceFile, outputFile, attrs);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
