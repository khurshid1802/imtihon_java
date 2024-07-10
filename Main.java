import model.ToDo;
import model.User;
import service.ToDoService;
import service.UserService;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    static UserService userService = new UserService();
    static ToDoService toDoService = new ToDoService();
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static User currentUser;

    public static void main(String[] args) {
        welcomeMenu();
    }

    private static void welcomeMenu() {
        int stepCode = 90;
        while (stepCode != 0) {
            System.out.println("1.Login\t2.Register\t0.Exit");
            System.out.print("Enter command: ");
             stepCode = scannerInt.nextInt();
            switch (stepCode) {
                case 0 -> {
                    return;
                }
                case 1 -> login();
                case 2 -> register();
            }
        }
    }

    public static void register(){
        System.out.print("Enter name: ");
        String fullName = scannerStr.nextLine();
        System.out.print("Enter username: ");
        String username = scannerStr.nextLine();
        System.out.print("Enter password: ");
        String password = scannerStr.nextLine();
        User user = new User(fullName,username,password);

        if(userService.addUser(user)==-1){
            System.out.println("Already exists ?");
        }else {
            System.out.println("user successfully added");
        }
    }

    public static void login(){
        System.out.print("Enter username: ");
        String username = scannerStr.nextLine();
        System.out.print("Enter password: ");
        String password = scannerStr.nextLine();
        User user = userService.login(username, password);
        if (user == null){
            System.out.println("User not found ?");
        }else {
            System.out.println("Welcome "+user.fullName);
            currentUser = user;
            userMenu();
        }
    }

    private static void userMenu() {
        while (true){
            System.out.println("1.Add ToDo\t2.completeToDo\t3.Show ToDo\t4.UserToDo List\t0.LogOut");
            System.out.print("Enter command: ");
            int command = scannerInt.nextInt();
            switch (command) {
                case 0 -> {return;}
                case 1 -> addToDo();
                case 2 -> completeToDo();
                case 3 -> toDoService.showUserTodo(currentUser.id);
                case 4 -> showUsers();
            }
        }
    }

    private static void completeToDo(){
        System.out.print("Enter todo: ");
        String text = scannerStr.nextLine();
        toDoService.completeToDo(text);
    }

    private static void addToDo() {
        System.out.print("Enter your todo: ");
        String todo = scannerStr.nextLine();
        ToDo toDo = new ToDo(currentUser.id,todo);
        toDoService.addToDo(toDo);
    }

    private static void showUsers() {
        System.out.print("Enter username");
        String username = scannerStr.nextLine();
        User user = userService.getUserByUsername(username);
        toDoService.showUserTodo(user.id);
    }
}

