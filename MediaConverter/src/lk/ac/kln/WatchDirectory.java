package lk.ac.kln;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

public class WatchDirectory extends ConverterObservable {

    private String folderName;

    // class constructor to set folder name
    public WatchDirectory(String folderName) {
        this.folderName = folderName;
    }

    // accessing path config file
    File configFile =new File("config.properties");

    // method to check for file changes in a given directory
    public void watchMediaFile() throws IOException,
            InterruptedException {

        try {
            //Read the content inside the configuration file
            FileReader reader=new FileReader(configFile);
            Properties props=new Properties();
            props.load(reader);

            //Reading source path using the configuration file
            String sourcePath = props.getProperty("source");

            String filePath =  sourcePath + "/" + folderName +"/";
            Path mediaFolder = Paths.get(filePath);
           // String filePath = mediaFolder.toAbsolutePath().toString();
            System.out.println("File Path:" + filePath);

            // instantiating watch service
            WatchService watchService = FileSystems.getDefault().newWatchService();
            mediaFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            boolean valid = true;
            do {
                WatchKey watchKey = watchService.take();

                for (WatchEvent event : watchKey.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();
                    if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                        String fileName = event.context().toString();
                        System.out.println("File Created:" + fileName);
                        filePath += '/' + fileName;
                        this.setPath(filePath);
                    }
                }
                valid = watchKey.reset();

            } while (valid);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}