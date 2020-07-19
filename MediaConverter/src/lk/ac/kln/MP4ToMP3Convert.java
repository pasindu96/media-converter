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

    public static MP4ToMP3Convert mp4ToMP3Convert;

    ConverterObservable observable = new ConverterObservable();

    private MP4ToMP3Convert() {}

    public static MP4ToMP3Convert getInstance(){
        if(mp4ToMP3Convert==null){
            mp4ToMP3Convert=new MP4ToMP3Convert();
        }
        return mp4ToMP3Convert;
    }

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
//            toMp3.encode(file1,file2,specification);
//            specification.setFormat("mp3");
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
        File[] inputFiles=sourceFile.listFiles();

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(128000));
        audio.setChannels(new Integer(2));
        audio.setSamplingRate(new Integer(44100));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Encoder encoder = new Encoder();

        File mp4ToMp3Converted=new File(output+"/mp4ToMp3-Converted");

        for(File file:inputFiles){
            //System.out.println(new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3"))+"\n");
            try {
                //encoder.encode(file, new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3")), attrs);
                encoder.encode(file, new File(mp4ToMp3Converted+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3")), attrs);

                file.delete();
            } catch (EncoderException e) {
                e.printStackTrace();
            }
        }
    }
}
