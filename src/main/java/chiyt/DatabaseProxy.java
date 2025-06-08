package chiyt;

public class DatabaseProxy implements Database {
    private RealDatabase realDatabase;

    public DatabaseProxy(String filePath) {
        this.realDatabase = new RealDatabase(filePath);
    }

    @Override
    public Employee getEmployeeById(int id) {
        String password = System.getenv("PASSWORD");
        if ("1qaz2wsx".equals(password)) {
            return realDatabase.getEmployeeById(id);
        } else {
            System.out.println("Access denied: Invalid PASSWORD.");
            return null;
        }
    }
}