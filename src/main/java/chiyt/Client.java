package chiyt;

public class Client
{
    public static void main(String[] args) {
        Database db = new DatabaseProxy("employee.txt");
        Employee emp = db.getEmployeeById(2);
        if (emp != null) {
            System.out.println(emp.getName() + " (" + emp.getAge() + ")");
            for (Employee sub : emp.getSubordinates()) {
                System.out.println("  Subordinate: " + sub.getName());
            }
        } else {
            System.out.println("Employee not found or access denied.");
        }
    }
}
