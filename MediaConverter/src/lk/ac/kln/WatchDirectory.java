package lk.ac.kln;


import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchDirectory extends ConverterObservable {

    public void watchMediaFile() throws IOException,
            InterruptedException {

        Path faxFolder = Paths.get("src/lk/ac/kln/MP4toMP3/");
        String filePath = faxFolder.toAbsolutePath().toString();
        WatchService watchService = FileSystems.getDefault().newWatchService();
        faxFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        boolean valid = true;
        do {
            WatchKey watchKey = watchService.take();

            for (WatchEvent event : watchKey.pollEvents()) {
                WatchEvent.Kind kind = event.kind();
                if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
                    String fileName = event.context().toString();
                    System.out.println("File Created:" + fileName);
                    filePath += '/' + fileName;
                    System.out.println("File Path:" + filePath);
                    this.setPath(filePath);
                }
            }
            valid = watchKey.reset();

        } while (valid);

    }
}