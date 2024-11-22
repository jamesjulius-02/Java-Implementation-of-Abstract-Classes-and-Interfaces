// Removed package declaration for simplicity

// Abstract Account class
abstract class Account {
    protected int id;
    protected String name;
    private DataSource myData;

    // Method to perform an operation on a DataSource
    public void performOperation(DataSource _myData) {
        myData = _myData;
        myData.execute();
    }
}

// Admin class extending Account
class Admin extends Account {
    private String authPassword;

    public Admin(int _id, String _name, String _password) {
        this.id = _id;
        this.name = _name;
        this.authPassword = _password;
    }
}

// Interface DataSource
interface DataSource {
    void execute();
}

// Delete class implementing DataSource
class Delete implements DataSource {
    @Override
    public void execute() {
        System.out.println("Data has been deleted.");
    }
}

// Update class implementing DataSource
class Update implements DataSource {
    @Override
    public void execute() {
        System.out.println("Data has been updated successfully!");
    }
}

// View class implementing DataSource
class View implements DataSource {
    @Override
    public void execute() {
        System.out.println("Displaying the data...");
    }
}

// User class extending Account
class User extends Account {
    public User(int _id, String _name) {
        this.id = _id;
        this.name = _name;
    }
}

// Main Application
public class MainApplication {
    public static void main(String[] args) {
        // Create an Admin and a User
        Admin admin = new Admin(1, "AdminUser", "securePassword123");
        User user = new User(2, "RegularUser");

        // Admin performs update and delete operations
        admin.performOperation(new Update());
        admin.performOperation(new Delete());

        // User performs view operation
        user.performOperation(new View());
    }
}
