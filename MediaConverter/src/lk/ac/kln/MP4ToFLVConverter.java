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

    }
}
