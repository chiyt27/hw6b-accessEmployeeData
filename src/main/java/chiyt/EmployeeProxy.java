package chiyt;

import java.util.ArrayList;
import java.util.List;

public class EmployeeProxy implements Employee {
    private final Employee realEmployee;
    private final Database database; // 用來查 subordinate
    private List<Employee> subordinates = null;

    public EmployeeProxy(Employee realEmployee, Database database) {
        this.realEmployee = realEmployee;
        this.database = database;
    }

    @Override
    public int getId() { return realEmployee.getId(); }

    @Override
    public String getName() { return realEmployee.getName(); }

    @Override
    public int getAge() { return realEmployee.getAge(); }

    @Override
    public List<Integer> getSubordinateIds() { return realEmployee.getSubordinateIds(); }

    @Override
    public List<Employee> getSubordinates() {
        if (subordinates == null) {
            subordinates = new ArrayList<>();
            for (int subId : getSubordinateIds()) {
                Employee emp = database.getEmployeeById(subId);
                if (emp!= null) {
                    subordinates.add(emp);
                }
            }
        }
        return subordinates;
    }
}
