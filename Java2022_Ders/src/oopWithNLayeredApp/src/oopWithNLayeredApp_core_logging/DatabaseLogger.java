package oopWithNLayeredApp_core_logging;

import oopWithNLayeredApp_core.Logger;

public class DatabaseLogger implements Logger {
    public void log(String data)
    {
        System.out.println("Veritabanina loglandi:  "+ data );
    }
}
