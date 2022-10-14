package kodlamaIO.entities;

public class Instructor {
    private int id;
    private String firstName;
    private String lastName;

    public Instructor(int id,String firstName,String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastName;
    }

    public void setLastNmae(String lastNmae) {
        this.lastName = lastNmae;
    }
}
