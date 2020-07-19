package lk.ac.kln;

public class ConverterFactory {
   // public static enum converterType {MP4TOMP3,MP4TOFLV,MP4TOMKV};

    public Converter getInstance(String type){
        switch (type){
            case "mp4Tomp3":return MP4ToMP3Converter.getInstance();
            case "mp4Toflv":return MP4ToFLVConverter.getInstance();
            case "mp4Tomkv":return MP4ToMKVConverter.getInstance();
            default:return null;
        }
    }
}
