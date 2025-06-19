package chiyt;

public class Client
{
    public static void main(String[] args) {
        Database db = new DatabaseProxy("src/main/resources/employee.txt");
        Employee emp = db.getEmployeeById(2);
        if (emp != null) {
            System.out.println(String.format("[%s] %s, age: %d", emp.getId(), emp.getName(), emp.getAge()));
            for (Employee sub : emp.getSubordinates()) {
                System.out.println(String.format("  Subordinate: [%s] %s, age: %d", sub.getId(), sub.getName(), sub.getAge()));
            }
        } else {
            System.out.println("Employee not found.");
        }
    }
}