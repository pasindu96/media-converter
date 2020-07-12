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
        try {
            //Read the content inside the configuration file
            FileReader reader=new FileReader(configFile);
            Properties props=new Properties();
            props.load(reader);

            //Reading source path using the configuration file
            String sourcePath = props.getProperty("source");

            //Reading output path using the configuration file
            String outputPath = props.getProperty("output");

            System.out.println(sourcePath+" "+outputPath);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
