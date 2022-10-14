package interfaces;

import abstractDemo.OracleDatabaseManager;

public class CustomerManager {

   private ICustomerDal customerDal;
    public CustomerManager(ICustomerDal customerDal){
        this.customerDal=customerDal;
    }
    public void add() {
        //iş kodları
       customerDal.Add();;

    }
}
