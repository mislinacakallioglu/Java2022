
import oopWithNLayeredApp_business.ProductManager;
import oopWithNLayeredApp_core.Logger;
import oopWithNLayeredApp_core_logging.DatabaseLogger;
import oopWithNLayeredApp_core_logging.FileLogger;
import oopWithNLayeredApp_core_logging.MailLogger;
import oopWithNLayeredApp_dataAccess.JdbcProductDao;
import oopWithNLayeredApp_entities.Product;
import oopWithNLayeredApp_dataAccess.HibernateProductDao;


public class Main {

    public static void main(String[] args) throws Exception {

    Product product1=new Product(1,"Iphone XR",9000);

    Logger [] loggers={};

    ProductManager productManager=new ProductManager(new HibernateProductDao(),loggers);
    productManager.add(product1);

    }
}
