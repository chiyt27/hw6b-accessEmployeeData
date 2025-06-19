package chiyt;
import java.util.List;

public interface Employee {
    int getId();
    String getName();
    int getAge();
    List<Integer> getSubordinateIds();
    List<Employee> getSubordinates();
}
