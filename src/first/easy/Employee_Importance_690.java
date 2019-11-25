package first.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/1.
 */
public class Employee_Importance_690 {
    private static int sum = 0;
    private static Map<Integer, Employee> map = new HashMap();
    public static void main(String[] args) {

    }

    public static int getImportance(List<Employee> employees, int id) {
        Employee employee = null;
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
            if (employees.get(i).id == id) {
                employee = employees.get(i);
            }
        }
        sum += employee.importance;
        getSubSum(employee.subordinates);
        return sum;
    }

    public static void getSubSum(List<Integer> employees) {
        for (int i = 0; i < employees.size(); i++) {
            sum += map.get(employees.get(i)).importance;
            getSubSum(map.get(employees.get(i)).subordinates);
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
