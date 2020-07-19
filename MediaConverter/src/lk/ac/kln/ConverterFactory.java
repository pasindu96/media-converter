package lk.ac.kln;

public class ConverterFactory {
    public static enum converterType {MP4TOMP3,MP4TOFLV,MP4TOMKV};

    public Converter getInstance(converterType type){
        switch (type){
            case MP4TOMP3:return MP4ToMP3Converter.getInstance();
            case MP4TOFLV:return MP4ToFLVConverter.getInstance();
            case MP4TOMKV:return MP4ToMKVConverter.getInstance();
            default:return null;
        }
    }
}
