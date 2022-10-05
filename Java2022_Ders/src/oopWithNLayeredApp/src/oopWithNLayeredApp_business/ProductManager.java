package oopWithNLayeredApp_business;

import oopWithNLayeredApp_core.Logger;
import oopWithNLayeredApp_dataAccess.ProductDao;
import oopWithNLayeredApp_entities.Product;


import java.util.List;

public class ProductManager {

    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao,Logger[] loggers)
    {
        this.productDao=productDao;
        this.loggers=loggers;
    }

    public void add(Product product)throws Exception{
        //iş kuralları
        if (product.getUnitPrice()<10){
            throw new Exception("Urun fiyati 10'dan kucuk olamaz. ");
        }
        productDao.add(product);

        for (Logger logger: loggers) { //[db,file]
            logger.log(product.getName());
        }
    }
}
