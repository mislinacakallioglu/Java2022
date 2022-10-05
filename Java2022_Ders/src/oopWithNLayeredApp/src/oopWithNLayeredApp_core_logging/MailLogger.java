package oopWithNLayeredApp_core_logging;

import oopWithNLayeredApp_core.Logger;

public class MailLogger implements Logger {

    public void log(String data){
        System.out.println("Mail gonderildi: " + data);
    }
}
