package lk.ac.kln;

import it.sauronsoftware.jave.*;

import java.io.File;

public class MP4ToMKVConverter implements Converter {

    public static MP4ToMKVConverter mp4ToMKVConverter;

    private MP4ToMKVConverter() {}

    public static MP4ToMKVConverter getInstance(){
        if(mp4ToMKVConverter==null){
            mp4ToMKVConverter=new MP4ToMKVConverter();
        }
        return mp4ToMKVConverter;
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

        File mp4ToMFLVConverted=new File(output+"/mp4Tomkv-Converted");

        for(File file:inputFiles){
//            System.out.println("Converting file :"+ source);
            //System.out.println(new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3"))+"\n");
            try {
                //encoder.encode(file, new File(output+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mp3")), attrs);
                encoder.encode(file, new File(mp4ToMFLVConverted+(file.toString().replace(sourceFile.toString(),"//")).replace(".mp4",".mkv")), attrs);
//                System.out.println("Conversion Successfull! MKV file Saved! in" + output);
                System.out.println(file.toString()+" : Converted Successfully ");
                // delete source file after conversion
                file.delete();
            } catch (EncoderException e) {
                e.printStackTrace();
            }
        }
    }
}
