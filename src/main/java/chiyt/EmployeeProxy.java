package chiyt;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProxy implements Employee {
    private final Employee realEmployee;
    private final Database database; // 用來查 subordinate
    private List<Employee> subordinates = null;
    private List<Integer> subordinateIds;

    public EmployeeProxy(Employee realEmployee, Database database, List<Integer> subordinateIds) {
        this.realEmployee = realEmployee;
        this.database = database;
        this.subordinateIds = subordinateIds;
    }

    @Override
    public int getId() { return realEmployee.getId(); }

    @Override
    public String getName() { return realEmployee.getName(); }

    @Override
    public int getAge() { return realEmployee.getAge(); }

    @Override
    public List<Employee> getSubordinates() {
        if (subordinates == null) {
            subordinates = new ArrayList<>();
            for (int subId : subordinateIds) {
                Employee emp = database.getEmployeeById(subId);
                if (emp!= null) {
                    subordinates.add(emp);
                }
            }
        }
        return subordinates;
    }
}
