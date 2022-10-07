package abstractDemo;

import polymorphismDemo.DatabaseLogger;

public class OracleDatabaseManager extends BaseDatabaseManager {
    @Override
    public void getData() {
        System.out.println("Veri getirildi: Oracle ");
    }
}
