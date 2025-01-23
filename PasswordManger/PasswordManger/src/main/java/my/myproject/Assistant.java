package my.myproject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/* class for link other classes */
public class Assistant {

    static ArrayList<User> usersList = new ArrayList<User>();
    static ArrayList<UserData> userDataList = new ArrayList<UserData>();
    /* Object for link between user and data and sign in to program*/
    public static User loggedUser;

    /* Method for dispaly sign up menu */
    public static void signUp() {

        ProgramMethod signIn = new ProgramMethod();
        signIn.checkSignInMenu();

        System.out.println("****** Sign up ******");
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name :");
        System.out.print("Name : ");
        String name = input.nextLine();

        System.out.println("Please enter your username :");
        System.out.print("Username: ");
        String username = input.nextLine();

        System.out.println("Please enter your password :");
        System.out.print("Password: ");
        String password = input.nextLine();

        User creatNewUser = new User();

        creatNewUser.setName(name);
        creatNewUser.setUsername(username);
        creatNewUser.setPassword(password);
        /* add current user to user list*/
        Assistant.usersList.add(creatNewUser);

        System.out.println("\n");
        System.out.println("** Now you have account. **");
        System.out.println("** Thank you for sign up. **");
        System.out.println("______________________________\n\n");

        loggedUser = creatNewUser;
        Assistant.appMenu();

    }

    /*  Method for sign in account */
    public static void signInUser() {
        Scanner input = new Scanner(System.in);

        ProgramMethod method = new ProgramMethod();
        method.checkUserListIsEmpty();
        method.checkSignInMenu();

        System.out.println("**** Sign in ****");
        System.out.println("______________________________");

        System.out.println("Enter ");
        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String password = input.nextLine();

        method.checkSignInData(username, password);
    }

    /* Method for sign in Menu */
    public static void signInMenu() {

        System.out.println("**** Welcome ****");
        System.out.println("______________________________");

        Scanner input = new Scanner(System.in);
        System.out.print("""
                         1. sign in 
                         2. sign up 
                         3. edit your account password
                         4. sign out 
                         5. return to PasswordManger menu 
                         """);
        System.out.print("Enter number : ");
        String inputChoice = input.nextLine();
        System.out.println("______________________________\n\n");

        switch (inputChoice) {
            case "1" -> {
                System.out.print("______________________________\n\n");
                Assistant.signInUser();
            }
            case "2" -> {
                System.out.print("______________________________\n\n");
                Assistant.signUp();
            }
            case "3" -> {
                System.out.print("______________________________\n\n");
                Assistant.editUserPassword();
            }
            case "4" -> {
                System.out.print("______________________________\n\n");
                Assistant.signOut();
            }
            case "5" -> {
                System.out.println("______________________________\n\n");
                Assistant.appMenu();
            }
            default -> {
                System.out.println("Error .. \n invaild number \n  check the number and try agin ..");
                Assistant.signInMenu();
            }

        }
    }

    /* Method for add new app information to owner data */
    public static void addNewAppInformation() {
        ProgramMethod method = new ProgramMethod();
        method.checkSignIn();

        System.out.println("** Add new App **");
        System.out.println("______________________________");

        Scanner input = new Scanner(System.in);
        Date today = new Date();

        UserData newAppInformation = new UserData();

        System.out.print("App : ");
        String app = input.nextLine();

        System.out.print("Username : ");
        String username = input.nextLine();

        System.out.print("Password : ");
        String passowrd = input.nextLine();

        System.out.println("______________________________\n\n");
        /* add new information to the user */
        newAppInformation.setApp(app);
        newAppInformation.setUsername(username);
        newAppInformation.setPassword(passowrd);
        newAppInformation.setDate(today);
        newAppInformation.setOwner(Assistant.loggedUser);

        userDataList.add(newAppInformation);
        Assistant.appsOptionMenu();

    }

    /* Method for delet app from owner data */
    public static void deletApp() {

        ProgramMethod method = new ProgramMethod();
        method.checkSignIn();
        method.checkDataListIsEmpty();

        Scanner input = new Scanner(System.in);

        System.out.println("**** Delet App Menu ****");
        System.out.println("______________________________");
        System.out.println("""
                           Enter 
                           1. Delet App 
                           2. Delet all Apps information 
                           3. Return Apps option menu 
                           """);
        System.out.print("Enter number : ");
        String choice = input.nextLine();

        switch (choice) {
            case "1" -> {
                System.out.println("Enter App : ");
                String app = input.nextLine();
                method.deletApp(app);
            }
            case "2" -> {
                method.deletAllApps();
            }
            case "3" ->
                Assistant.appsOptionMenu();
            default -> {
                System.out.println("""
                                     Error ..
                                      invaild number
                                       check the number and try agin ..""");
                System.out.println("______________________________\n\n");
                Assistant.deletApp();
            }

        }
    }

    /* Method for edit infromation owner data */
    public static void editAppInformation() {

        ProgramMethod method = new ProgramMethod();
        method.checkSignIn();
        method.checkDataListIsEmpty();

        Scanner input = new Scanner(System.in);
        Date today = new Date();

        System.out.println("**** Edit App Information ****");
        System.out.println("______________________________");
        System.out.print("Enter App : ");
        String app = input.nextLine();

        boolean editAppInformation = false;
        /* search for user data */
        for (UserData i : userDataList) {
            if (i.getApp().equalsIgnoreCase(app)) {

                editAppInformation = true;
                System.out.println("""
                                   Do you want 
                                    1. Edit App username 
                                    2. Edit App password 
                                    3. Edit All 
                                    4. return to Apps option menu 
                                   """);
                System.out.print("Enter number :");
                String choice = input.nextLine();

                switch (choice) {
                    case "1" -> {
                        System.out.println("Enter App new username : ");
                        String newUsername = input.nextLine();
                        i.setUsername(newUsername);
                        i.setDate(today);
                        System.out.println("Username is updated SUCCSESSFUL ..");
                        System.out.println("______________________________\n\n");
                        Assistant.appsOptionMenu();
                    }
                    case "2" -> {
                        System.out.println("Enter App new password : ");
                        String newPassword = input.nextLine();
                        i.setPassword(newPassword);
                        i.setDate(today);
                        System.out.println("Password is updated SUCCSESSFUL ..");
                        System.out.println("______________________________\n\n");
                        Assistant.appsOptionMenu();
                    }
                    case "3" -> {
                        System.out.println("Enter App new username : ");
                        String newUsername = input.nextLine();
                        i.setUsername(newUsername);
                        System.out.println("Enter new App password : ");
                        String newPassword = input.nextLine();
                        i.setPassword(newPassword);
                        i.setDate(today);
                        System.out.println("Username and Password is updated SUCCSESSFUL ..");
                        System.out.println("______________________________\n\n");
                        Assistant.appsOptionMenu();
                    }
                    case "4" -> {
                        System.out.println("______________________________\n\n");
                        Assistant.appsOptionMenu();
                    }
                    default -> {
                        System.out.println("""
                                             Error ..
                                              invaild number
                                               check the number and try agin ..""");
                        System.out.println("______________________________\n\n");
                        Assistant.editAppInformation();
                    }

                }
            }
            if (!editAppInformation) {
                System.out.println("Not found !!");
                System.out.println("______________________________\n\n");
                Assistant.editAppInformation();
            }
        }
    }

    /* Method for display one app owner choice */
    public static void showAppInformtion() {

        ProgramMethod method = new ProgramMethod();
        method.checkSignIn();
        method.checkDataListIsEmpty();

        Scanner input = new Scanner(System.in);
        Date today = new Date();

        System.out.print("Enter App : ");
        String app = input.nextLine();
        System.out.println("");
        System.out.println("____________________________________________");
        /* search for the user data if is wrong or write */
        for (UserData appInfo : userDataList) {
            if (!appInfo.getApp().equalsIgnoreCase(app)) {
                System.out.println("Not found app !!");
                System.out.println("______________________________\n\n");
                Assistant.appsOptionMenu();
            }

            if (appInfo.getApp().equalsIgnoreCase(app)) {
                System.out.println("App information is :");
                System.out.println("@ App :" + appInfo.getApp()
                        + "|| Username :" + appInfo.getUsername()
                        + "|| Password :" + appInfo.getPassword()
                        + "|| Last view :" + appInfo.getDate() + "\n");
                System.out.println("____________________________________________\n\n");
                appInfo.setDate(today);
                Assistant.appsOptionMenu();
            }
        }
    }

    /* Method for show all data for user */
    public static void showAllAppsInformation() {

        ProgramMethod method = new ProgramMethod();
        method.checkSignIn();
        method.checkDataListIsEmpty();

        /* print all user data */
        System.out.println("** All your information : **");
        for (UserData data : userDataList) {
            if (data.getOwner().equals(Assistant.loggedUser)) {
                System.out.println("App : " + data.getApp()
                        + " || Username : " + data.getUsername()
                        + "  || Password : " + data.getPassword()
                        + "  || Last view : " + data.getDate());
                Date today = new Date();
                data.setDate(today);
            }
        }
        System.out.println("______________________________\n\n");
        Assistant.appsOptionMenu();
    }

    /* Method to sign out user from programm */
    public static void signOut() {
        /* check if user sign in */
        if (loggedUser == null) {
            System.out.println("Your sign out Already !!");
            System.out.println("______________________________\n\n");
            Assistant.signInMenu();
        }
        /* sign out user*/
        loggedUser = null;
        System.out.println("Log out SUCCSESSFUL");
        System.out.println("______________________________\n\n");
        Assistant.appMenu();
    }

    /* Method for change user password */
    public static void editUserPassword() {
        ProgramMethod method = new ProgramMethod();
        method.checkUserListIsEmpty();

        Scanner input = new Scanner(System.in);
        System.out.println("**** Edit user password ****");
        System.out.println("______________________________");
        System.out.println("If you want back to App menu Enter 0 .\n");
        System.out.print("Enter name : ");
        String Name = input.nextLine();
        if (Name.equals("0")) {
            Assistant.appMenu();
        }
        System.out.print("Enter username : ");
        String Username = input.nextLine();

        boolean editUserPassword = false;
        /* search for user data */
        for (User i : usersList) {
            if (i.getName().equals(Name)
                    && i.getUsername().equals(Username)) {

                editUserPassword = true;
                System.out.println("Enter new password : ");
                String Password = input.nextLine();
                loggedUser.setPassword(Password);
                System.out.println("Owner password updated SUCCSESSFUL..");
                Assistant.appMenu();
            }
            if (!editUserPassword) {
                System.out.println("Not found !!");
                Assistant.editUserPassword();
            }
        }
        System.out.println("______________________________\n\n");
    }

    /* Method for all app options menu */
    public static void appsOptionMenu() {
        System.out.println("***** Apps Option *****");
        System.out.println("__________________________________________");
        System.out.println("""
                           Please select number :
                            1. Add new App information . 
                            2. Edit App information .
                            3. Delet Apps information .
                            4. Show App information .
                            5. Show All app infromation .
                            6. Return to App menu .""");
        System.out.println("__________________________________________");
        System.out.print("Enter number :");
        System.out.println("\n\n");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        switch (choice) {
            case "1" ->
                Assistant.addNewAppInformation();
            case "2" ->
                Assistant.editAppInformation();
            case "3" ->
                Assistant.deletApp();
            case "4" ->
                Assistant.showAppInformtion();
            case "5" ->
                Assistant.showAllAppsInformation();
            default -> {
                System.out.println("Error .. \n invaild number \n  check the number and try agin ..");
                System.out.println("______________________________\n\n");
                Assistant.appsOptionMenu();
            }

        }
    }

    /* Method for programm menu */
    public static void appMenu() {
        System.out.println("****- Welcome to your PasswordManger -****");
        System.out.println("__________________________________________");
        System.out.println("""
                           Please select number :
                            1. Sign in menu . 
                            2. Apps options menu .
                            3. Exit APP """);
        System.out.println("__________________________________________");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number : ");
        String userChoice = input.nextLine();
        System.out.println("______________________________\n\n");

        switch (userChoice) {
            case "1" ->
                Assistant.signInMenu();
            case "2" ->
                Assistant.appsOptionMenu();
            case "3" ->
                System.exit(0);
            default -> {
                System.out.println("Error .. \n invaild number \n  check the number and try agin ..");
                System.out.println("______________________________\n\n");
                Assistant.appMenu();
                break;
            }
        }
    }
}
