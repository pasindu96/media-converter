package lk.ac.kln;

import it.sauronsoftware.jave.*;

import java.io.File;

public class MP4ToFLVConverter implements Converter{

    public static MP4ToFLVConverter mp4ToFLVConverter;

    private MP4ToFLVConverter() {}

    public static MP4ToFLVConverter getInstance(){
        if(mp4ToFLVConverter==null){
            mp4ToFLVConverter=new MP4ToFLVConverter();
        }
        return mp4ToFLVConverter;
    }

    @Override
    public void Convert(String source, String output) {

        File sourceFile=new File(source);
        File outputFile=new File(output);
        File[] inputFiles=sourceFile.listFiles();

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(new Integer(64000));
        audio.setChannels(new Integer(1));
        audio.setSamplingRate(new Integer(22050));
        VideoAttributes video = new VideoAttributes();
        video.setCodec("flv");
        video.setBitRate(new Integer(160000));
        video.setFrameRate(new Integer(25));
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("flv");
        attrs.setAudioAttributes(audio);
        attrs.setVideoAttributes(video);

        Encoder encoder = new Encoder();

        File mp4ToFLVConverted=new File(output+"/mp4Toflv-Converted");

        for(File file:inputFiles){
//            System.out.println("Converting file :"+ source);
            //System.out.println(new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3"))+"\n");
            try {
                //encoder.encode(file, new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3")), attrs);
                encoder.encode(file, new File(mp4ToFLVConverted+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".flv")), attrs);
//                System.out.println("Conversion Successfull! FLV file Saved! in" + output);
                System.out.println(file.toString()+" : Converted Successfully ");
                // delete source file after conversion
                file.delete();
            } catch (EncoderException e) {
                e.printStackTrace();
            }
        }
    }
}
