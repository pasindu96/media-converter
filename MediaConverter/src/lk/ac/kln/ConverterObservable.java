package lk.ac.kln;

import java.util.ArrayList;
import java.util.List;

public class ConverterObservable {
        private String path;
        private List<Channel> channels = new ArrayList<>();

        public void addObserver(Channel channel) {
            this.channels.add(channel);
        }

        public void removeObserver(Channel channel) {
            this.channels.remove(channel);
        }

        public void setPath(String filePath) {
            this.path = filePath;
            for (Channel channel : this.channels) {
                channel.update(this.path);
            }
        }
}
