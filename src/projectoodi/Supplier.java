package projectoodi;

public class Supplier extends Person {

    private String supplierID;
    private String address;

    public Supplier(String supplierID,
                    String supplierName,
                    String phoneNumber,
                    String email,
                    String address) {

        super(supplierName, phoneNumber, email);

        this.supplierID = supplierID;
        this.address = address;
    }

    // Getter Methods
    public String getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // Setter Methods
    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setSupplierName(String supplierName) {
        this.name = supplierName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Polymorphism (Method Overriding)
    public String displayInfo() {
        return "Supplier ID: " + supplierID +
               "\nSupplier Name: " + name +
               "\nPhone Number: " + phoneNumber +
               "\nEmail: " + email +
               "\nAddress: " + address;
    }
}