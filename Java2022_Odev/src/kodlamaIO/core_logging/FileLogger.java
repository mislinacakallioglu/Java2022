package kodlamaIO.core_logging;

import kodlamaIO.core.Logger;

public class FileLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Dosyaya loglandi. "+ data);
    }
}
