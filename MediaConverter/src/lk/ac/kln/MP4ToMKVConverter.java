package lk.ac.kln;

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
        System.out.println("MP4 --> MKV ==> To be implemented");
    }
}
