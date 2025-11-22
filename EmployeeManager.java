import java.io.*;
import java.util.*;

public class EmployeeManager {

    private static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Options:");
            System.out.println(" l");
            System.out.println(" s");
            System.out.println(" +");
            System.out.println(" ?");
            System.out.println(" c");
            System.out.println(" u");
            System.out.println(" d");
            return;
        }

        String command = args[0];

        if (command.equals("l")) {
            System.out.println("Loading data ...");
            List<String> employees = readEmployees();
            employees.forEach(System.out::println);
            System.out.println("Data Loaded.");
        }

        else if (command.equals("s")) {
            System.out.println("Loading data ...");
            List<String> employees = readEmployees();
            Random random = new Random();
            System.out.println("Random employee: " + employees.get(random.nextInt(employees.size())));
            System.out.println("Data Loaded.");
        }

        else if (command.startsWith("+")) {
            System.out.println("Loading data ...");
            String name = command.substring(1);
            appendEmployee(name);
            System.out.println("Data Loaded.");
        }

        else if (command.startsWith("?")) {
            System.out.println("Loading data ...");
            String search = command.substring(1).trim();
            List<String> employees = readEmployees();

            if (employees.stream().anyMatch(e -> e.trim().equalsIgnoreCase(search))) {
                System.out.println("Employee found!");
            } else {
                System.out.println("Employee NOT found.");
            }
            System.out.println("Data Loaded.");
        }

        else if (command.equals("c")) {
            System.out.println("Loading data ...");
            List<String> employees = readEmployees();
            int count = employees.size();
            System.out.println(count + " employee(s) found.");
            System.out.println("Data Loaded.");
        }

        else if (command.startsWith("u")) {
            System.out.println("Loading data ...");
            String target = command.substring(1).trim();
            List<String> employees = readEmployees();

            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).trim().equalsIgnoreCase(target)) {
                    employees.set(i, "Updated");
                }
            }

            writeEmployees(employees);
            System.out.println("Data Updated.");
        }

        else if (command.startsWith("d")) {
            System.out.println("Loading data ...");
            String target = command.substring(1).trim();
            List<String> employees = readEmployees();

            employees.removeIf(e -> e.trim().equalsIgnoreCase(target));

            writeEmployees(employees);
            System.out.println("Data Deleted.");
        }
    }

    private static List<String> readEmployees() {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                String[] data = line.split(",");
                for (String item : data) {
                    list.add(item.trim());
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return list;
    }

    private static void writeEmployees(List<String> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(String.join(", ", employees));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /** Appends a new employee to the file */
    private static void appendEmployee(String employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            List<String> current = readEmployees();
            if (!current.isEmpty()) {
                writer.write(", ");
            }
            writer.write(employee);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
