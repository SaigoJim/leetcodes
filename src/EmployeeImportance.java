import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> id2Employee = new HashMap<>();
        for (Employee employee : employees) {
            id2Employee.put(employee.id, employee);
        }
        return getImportance(id2Employee, id);
    }
    private int getImportance(HashMap<Integer, Employee> id2Employee, int id) {
        Employee curEmployee= id2Employee.get(id);
        int totalImportance = curEmployee.importance;
        for (int subID : curEmployee.subordinates) {
            totalImportance += getImportance(id2Employee, subID);
        }
        return totalImportance;
    }
}
