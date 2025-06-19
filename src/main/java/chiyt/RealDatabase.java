package chiyt;

import java.io.*;

public class RealDatabase implements Database {
    private String filePath;

    public RealDatabase(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Employee getEmployeeById(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int empId = Integer.parseInt(parts[0]);
                if (empId == id) {
                    String name = parts[1];
                    int age = Integer.parseInt(parts[2]);
                    String subordinateIds = parts.length > 3 ? parts[3] : "";
                    return new RealEmployee(empId, name, age, subordinateIds);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }
}
