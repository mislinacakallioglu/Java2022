package classesWithAttributes;

public class ProductManager {
    //JDBC
    public void Add(Product product )
    {
        System.out.println("Urun eklendi: " + product.getName());
    }
    public void Add2(int Id,String name,String descriription,int stockAmount,double price,String colour)
    {

    }
}
