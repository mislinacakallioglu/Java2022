package kodlamaIO.core_logging;

import kodlamaIO.core.Logger;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Veritabanina loglandi. " + data);
    }
}
