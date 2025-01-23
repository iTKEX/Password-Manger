package my.myproject;

import java.util.Scanner;
import static my.myproject.Assistant.loggedUser;
import static my.myproject.Assistant.userDataList;
import static my.myproject.Assistant.usersList;

public class ProgramMethod {

    /* check if user already sign in */
    public void checkSignInMenu() {
        if (loggedUser != null) {
            System.out.println("You'r alreday sign in !");
            Assistant.appMenu();
        }
    }

    /* check if user sign in */
    public void checkSignIn() {
        if (loggedUser == null) {
            System.out.println("Error ..\n you don't sign in !!");
            System.out.println("______________________________\n\n");
            Assistant.appMenu();
        }
    }

    /* check if there any account in program*/
    public void checkUserListIsEmpty() {
        if (usersList.isEmpty()) {
            System.out.println("No Accounts !!\n\n");
            Assistant.signInMenu();
        }
    }

    /* for search if the account in user list */
    public void checkSignInData(String username, String password) {
        boolean alreadyAccount = false;
        for (User signInAccount : usersList) {
            if (signInAccount.getUsername().equalsIgnoreCase(username)
                    && signInAccount.getPassword().equals(password)) {
                alreadyAccount = true;
                Assistant.loggedUser = signInAccount;
                System.out.println("Sign in SUCCSESSFUL..");
                System.out.println("______________________________\n\n");
                Assistant.appMenu();
            }
        }
        if (!alreadyAccount) {
            System.out.println("""
                               Wrong username or password !!
                                Try agin
                               ______________________________
                               
                               
                               """);
            Assistant.signInMenu();
        }
    }

    /* check if the userDatalist is empty */
    public void checkDataListIsEmpty() {
        if (userDataList.isEmpty()) {
            System.out.println("You don't add information yet.");
            System.out.println("______________________________\n\n");
            Assistant.appsOptionMenu();
        }
    }

    /* for delet object form userDataList*/
    public void deletApp(String app) {
        boolean deletApp = false;
        /* search for the app user want to delet */
        for (UserData i : userDataList) {
            if (i.getApp().equalsIgnoreCase(app)) {
                deletApp = true;
                userDataList.remove(i);
                System.out.println("Delet App SUCCSESSFUL ..");
                System.out.println("______________________________\n\n");
                Assistant.appMenu();
            }
        }
        if (!deletApp) {
            System.out.println("Not found !!");
            System.out.println("______________________________\n\n");
            Assistant.deletApp();
        }
    }

    /* for clone userDataList */
    public void deletAllApps() {
        Scanner input = new Scanner(System.in);

        System.out.println("Are you sure want to delet " + userDataList.size());
        System.out.println("Yes");
        System.out.println("No");
        String choiceDel = input.nextLine();

        switch (choiceDel) {
            case "yes":
                userDataList.clear();
                System.out.println("Delet All Apps SUCCSESSFUL ..");
                System.out.println("______________________________\n\n");
                Assistant.deletApp();
                break;
            case "no":
                Assistant.appsOptionMenu();
            default:
                System.out.println("""
                                     Error ..
                                      invaild choice
                                       check the number and try agin ..""");
        }
    }
}
