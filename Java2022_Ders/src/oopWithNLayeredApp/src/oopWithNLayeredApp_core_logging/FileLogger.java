package oopWithNLayeredApp_core_logging;

import oopWithNLayeredApp_core.Logger;

public class FileLogger implements Logger {

    public void log(String data){
        System.out.println("Dosyaya loglandi: " + data);
    }
}
