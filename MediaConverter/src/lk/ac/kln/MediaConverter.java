package lk.ac.kln;

import it.sauronsoftware.jave.Encoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Properties;
import java.util.Scanner;

public class MediaConverter{

    public static void main(String args[]) {

        //Make a file instance to hold configuration file
        File configFile =new File("config.properties");
        ConverterFactory factory=new ConverterFactory();



        try {
            //Read the content inside the configuration file
            FileReader reader=new FileReader(configFile);
            Properties props=new Properties();
            props.load(reader);

            //Reading output path using the configuration file
            String outputPath = props.getProperty("output");

            // scanner class to read user inputs
            Scanner scan = new Scanner(System.in);

            while(true) {
                System.out.println("welcome to Java Media Files Converter\n\n");
                System.out.println("Please select a conversion Type: \n 1. MP4toMP3 \n 2. MP4toFLV \n 3. MP4to MKV \n 4.Exit");
                Integer option = scan.nextInt();

               if ( option == 1) {
                   //Getting a mp4tomp3Convert object using Factory
                   WatchDirectory watchMP3Dir = new WatchDirectory("mp4Tomp3");
                   watchMP3Dir.convertMediaFile();
               } else if ( option == 2) {
                   //Getting a mp4toflvConvert object using Factory
                   WatchDirectory watchFLVDir = new WatchDirectory("mp4Toflv");
                    watchFLVDir.convertMediaFile();
               } else if ( option == 3) {
                   //Getting a mp4tomkvConvert object using Factory
                   WatchDirectory watchMKVDir = new WatchDirectory("mp4Tomkv");
                   watchMKVDir.convertMediaFile();
               } else if ( option == 4)   {
                 System.exit(0);
               } else {
                   System.out.println("Invalid Input.. Restarting...");
               }
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
