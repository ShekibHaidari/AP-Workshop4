public class Person {

    //========================= Att
    private String name;
    private String lastName;
    //====================== constractor
    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    // ====================== getter and setters
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
