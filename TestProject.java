package csci.pkg1300.eop;
 
import java.util.Scanner;
import java.util.Arrays;

public class TestProject {

    public static void main(String[] args) {

        EnterNickname();
        DisplayMenu();
        ChooseAndDisplayDrinks();
        ProceedToCounter();
        
    }
    
    public static void EnterNickname(){
        Scanner input = new Scanner (System.in);
        System.out.printf("Enter Your Nickname: ");
        String nickname = input.next();
        
        System.out.println();
        System.out.println("   --------------------------------------------------    ");
        System.out.println("   |      Hi " + nickname + ", Welcome To NEO-TOKIO CAFE!       |   ");
        System.out.println("   |   We Are a Coffee and Drinks Specialist Cafe   |   ");
        System.out.println("   |      What Would You Like to Order Today?       |   ");
        System.out.println("   --------------------------------------------------    ");
        System.out.println();
    }
    
    public static void DisplayMenu(){
        System.out.println("              Here is Your Order Number:");
        System.out.println("                         " + GenerateOrderID(100, 999));
        System.out.println();
        System.out.println("------------- Welcome To NEO-TOKIO CAFE ---------------");
        System.out.println("------------------------ MENU -------------------------");
        System.out.println("|   [CODE]   [COFFEE]                     [PRICE]     |");
        System.out.println("|   COF01    ESPRESSO                       RM7       |");
        System.out.println("|   COF02    AMERICANO                      RM8       |");
        System.out.println("|   COF03    LATTE                          RM9       |");
        System.out.println("|   COF04    CAPPUCCINO                     RM9       |");
        System.out.println("|   COF05    MOCHA                          RM9       |");
        System.out.println("|   COF06    MACCHIATO                      RM9       |");
        System.out.println();        
    }
    
    public static int GenerateOrderID(int x, int y) {
        int OrderID = (int) (Math.random() * (y - x + 1) + x);
        return OrderID;
    }
    
    public static void ChooseAndDisplayDrinks(){
        
        String[][] drinkMenu = {
            {"COF01", "ESPRESSO", "RM7"},
            {"COF02", "AMERICANO", "RM8"},
            {"COF03", "LATTE", "RM9"},
            {"COF04", "CAPPUCCINO", "RM9"},
            {"COF05", "MOCHA", "RM9"},
            {"COF06", "MACHIATO", "RM9"},
        };
        
        Scanner input = new Scanner(System.in);
        
        int maxDrinks = 100; 

        String[] selectedDrinks = new String[maxDrinks];
        String[] selectedPrice = new String[maxDrinks];

        
        for (int i = 0; i < maxDrinks; i++) {
            System.out.print("Enter drink code #" + (i + 1) + " (or type 'done' to finish): ");
            String drinkCode = input.next();

            if (drinkCode.equalsIgnoreCase("done")) {
                break;
            }

            String drinkName = findDrinkName(drinkMenu, drinkCode);

            if (drinkName != null) {
                selectedDrinks[i] = drinkName;
            } else {
                System.out.println("Invalid drink code. Try again.");
                i--; 
            }
            
            String drinkPrice = findDrinkPrice(drinkMenu, drinkCode);

            if (drinkPrice != null) {
                selectedPrice[i] = drinkPrice;
            } else {
                System.out.println("Invalid drink code. Try again.");
                i--; 
            }
        }
        
        double totalOrderPrice = 0.0;

        for (int i = 0; i < selectedDrinks.length; i++) {
        if (selectedDrinks[i] != null) {
            totalOrderPrice += Double.parseDouble(selectedPrice[i].substring(2));
            }
        }

        System.out.println();
        
        System.out.println("Your Selected Drinks:");
        for (String drink : selectedDrinks) {
            if (drink != null) {
                System.out.println("----- " + drink + " -----");
            }
        }
        
        System.out.println();
        
        System.out.println("Price For Each Drinks:");
        for (String price : selectedPrice) {
            if (price != null) {
                System.out.println("----- " + price + " -----");
            }
        }
        System.out.println();
    
        System.out.println("Your Total Order Price: RM" + totalOrderPrice);
        System.out.println();

    }
    
    public static String findDrinkName(String[][] drinkMenu, String drinkCode) {
        for (int i = 0; i < drinkMenu.length; i++) {
            if (drinkMenu[i][0].equalsIgnoreCase(drinkCode)) {
                return drinkMenu[i][1];
            }
        }
        return null; 
    }
    
    public static String findDrinkPrice(String[][] drinkMenu, String drinkCode) {
        for (int i = 0; i < drinkMenu.length; i++) {
            if (drinkMenu[i][0].equalsIgnoreCase(drinkCode)) {
                return drinkMenu[i][2];
            }
        }
        return null; 
    }
    
    public static void ProceedToCounter(){
        System.out.println("         Please Proceed To Counter For Payment         ");
        System.out.println("      Please Show Your Order Number To The Cashier     ");
        System.out.println();
        System.out.println("-------------- THANK YOU FOR VISITING US --------------");
        System.out.println("------------------- HAVE A NICE DAY -------------------");
        System.out.println("------------------- YOI ICHINICHI O -------------------");
        System.out.println("-------------------- NEO-TOKIO CAFE -------------------");
        System.out.println();

    }
}


