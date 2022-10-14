package kodlamaIO.core_logging;

import kodlamaIO.core.Logger;

public class EmailLogger implements Logger {
    @Override
    public void log(String data) {
        System.out.println("Mail gonderildi. " + data);
    }
}
