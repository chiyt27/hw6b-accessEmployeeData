package chiyt;

import java.util.ArrayList;
import java.util.List;

public class RealEmployee implements Employee {
    private int id;
    private String name;
    private int age;
    private List<RealEmployee> subordinates;

    public RealEmployee(int id, String name, int age, List<RealEmployee> subordinates) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subordinates = subordinates;
    }

    @Override
    public int getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public int getAge() { return age; }

    @Override
    public List<Employee> getSubordinates() {
        return new ArrayList<>(); // 由 Proxy 處理
    }
}
