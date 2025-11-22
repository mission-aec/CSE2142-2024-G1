
//File Name EmployeeManager.java
import java.io.*;
import java.util.*;

public class EmployeeManager {
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
        // Check arguments
        if (args[0].equals("l")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String element[] = line.split(",");
                for (String employee : element) {
                    System.out.println(employee);
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("s")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                System.out.println(line);
                String element[] = line.split(",");
                Random random = new Random();
                int idx = random.nextInt(element.length);
                System.out.println(element[idx]);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt", true));
                String number = args[0].substring(1);
                writer.write(", " + number);
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String l = reader.readLine();
                String element[] = l.split(",");
                boolean found = false;
                String sub = args[0].substring(1);
                for (int i = 0; i < element.length && !found; i++) {
                    if (element[i].equals(sub)) {
                        System.out.println("Employee found!");
                        found = true;
                    }
                }
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                char[] characters = line.toCharArray();
                boolean inWord = false;
                int count = 0;
                for (char chars : characters) {
                    if (chars == ' ') {
                        if (!inWord) {
                            count++;
                            inWord = true;
                        } else {
                            inWord = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + characters.length);
            } catch (Exception exception) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("u")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String element[] = line.split(",");
                String number = args[0].substring(1);
                for (int i = 0; i < element.length; i++) {
                    if (element[i].equals(number)) {
                        element[i] = "Updated";
                    }
                }
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", element));
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Updated.");
        } else if (args[0].contains("d")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("employees.txt")));
                String line = reader.readLine();
                String element[] = line.split(",");
                String number = args[0].substring(1);
                List<String> list = new ArrayList<>(Arrays.asList(element));
                list.remove(number);
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("employees.txt"));
                writer.write(String.join(",", list));
                writer.close();
            } catch (Exception exception) {
            }
            System.out.println("Data Deleted.");
        }
    }
}
