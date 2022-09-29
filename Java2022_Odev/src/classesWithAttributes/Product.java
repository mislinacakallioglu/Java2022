package classesWithAttributes;

public class Product {

    public Product(int Id,String name,String description,double price,int stockAmount,String colour){
        System.out.println("Yapici blok calstir. ");
        this.Id=Id;
        this.colour=colour;
        this.name=name;
        this.price=price;
        this.stockAmount=stockAmount;
        this.description=description;
    }
    public Product(){

    }

    //attribute veya field
    private int Id;
    private String name;
    private String description;
    private double price;
    private int stockAmount;
    private String colour;
    private String code;

    // this kullanıldığında bu classın içinde demektir
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getCode() {
        return this.name.substring(0,1) + Id;
    }

}
