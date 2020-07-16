package lk.ac.kln;

import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MediaConverter {

    public static void main(String[] args) {

//        System.out.println(System.getProperty("user.dir"));

        //Make a file instance to hold configuration file
        File configFile =new File("config.properties");
        ConverterFactory factory=new ConverterFactory();
        try {
            //Read the content inside the configuration file
            FileReader reader=new FileReader(configFile);
            Properties props=new Properties();
            props.load(reader);

            //Reading source path using the configuration file
            String sourcePath = props.getProperty("source");

            //Reading output path using the configuration file
            String outputPath = props.getProperty("output");

//            System.out.println(sourcePath+" "+outputPath);
            //new MP4ToMP3Convert().Convert(sourcePath,outputPath);
            //MP4ToMP3Convert.getInstance().Convert(sourcePath,outputPath);
            //Getting a mp4tomp3Convert object using Factory
            Converter toMP3Convert=factory.getInstance(ConverterFactory.converterType.MP4ToMP3);
            toMP3Convert.Convert(sourcePath,outputPath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
