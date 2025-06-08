package chiyt;

import java.util.ArrayList;
import java.util.List;

public class RealEmployee implements Employee {
    private int id;
    private String name;
    private int age;
    private List<Integer> subordinateIds;
    private List<Employee> subordinates;
    private Database database;

    public RealEmployee(int id, String name, int age, List<Integer> subordinateIds, Database database) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subordinateIds = subordinateIds;
        this.database = database;
        this.subordinates = null; // Lazy load
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getAge() { return age; }

    @Override
    public List<Employee> getSubordinates() {
        if (subordinates == null) {
            subordinates = new ArrayList<>();
            for (int subId : subordinateIds) {
                Employee emp = database.getEmployeeById(subId);
                if (emp != null) subordinates.add(emp);
            }
        }
        return subordinates;
    }
}
