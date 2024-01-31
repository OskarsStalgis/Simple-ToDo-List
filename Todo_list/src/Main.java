import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBlogic db = new DBlogic();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to SimpleTODO. What would you like to do?");

        while(true) {

            System.out.println("Enter: c - to create a new task, r - to view all tasks, u - to update a task, a - to update task status, d - to delete a task, q - to quit SimpleTODO)?");
            String userChoice = scan.nextLine();

            switch (userChoice) {
                case "c":
                    System.out.println("New task: ");
                    String userValue = scan.nextLine();
                    db.create(userValue);
                    break;

                case "r":
                    db.read();
                    break;

                case "u":
                    System.out.println("Select the task you would like to update?");
                    String userRow = scan.nextLine();

                    System.out.println("Write the new task: ");
                    String userUpdateRow = scan.nextLine();

                    db.update(userRow, userUpdateRow);
                    break;

                case "a":
                    System.out.println("Select the task you would like to update?");
                    String statusRow = scan.nextLine();

                    db.updateStatus(statusRow);
                    break;

                case "d":
                    System.out.println("Select the task you would like to delete?");
                    String rowID = scan.nextLine();

                    db.delete(rowID);

                    System.out.println("Task deleted successfully");
                    break;

                case "q":
                    end();
                    return;

                default:
                    System.out.println("Something wrong");
            }
        }
    }
    public static void end () {
        System.out.println("Thank you for using SimpleTODO. Good bye!");
    }
}