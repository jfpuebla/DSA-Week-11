import java.util.*;

public class ProductOrganizer{
    //Insert here the methods only for our class


    //seperate method for the category
    public static String categoryInput(){
        //input category
        Scanner input =new Scanner(System.in);

        //final category for the user
        String finalCategory="";

        while (true){

            System.out.println("Here are the corresponding Categories with its shortcut key");
            System.out.println("If you want to quit category input, just type 'quit'");
            System.out.println(
            "Frozen Foods--FF\nDrinks--Dr\nCleaning Supplies--CS\n"+
            "Fruites n Veggies--FV\nCooking Foods--CF\nGeneral Foods--GF\nHealth n Beauty--HB\n"+
            "Pharmacy--Ph\nOthers--Ot\n");


            //list for the categories shortcut key
            ArrayList<String> categoryArr = new ArrayList<>( Arrays.asList("ff","dr","cs","fv","cf",
            "gf","hb","ph","ot","quit"));

            System.out.print("Enter your category here: ");//category input
            String categoryChoice=input.nextLine();
            categoryChoice=categoryChoice.toLowerCase();

            //checks if the user's choice is a shortcut key for the categories
            if (categoryArr.contains(categoryChoice)){

                //similar to else if but in organized manner
                switch (categoryChoice){
                    case "ff":
                        finalCategory="Frozen Foods";
                        break;
                    case "dr":
                        finalCategory="Drinks";
                        break;
                    case "cs":
                        finalCategory="Cleaning Supplies";
                        break;
                    case "fv":
                        finalCategory="Fruits n Veggies";
                        break;
                    case "cf":
                        finalCategory="Cooking Foods";
                        break;
                    case "gf":
                        finalCategory="General Food";
                        break;
                    case "hb":
                        finalCategory="Health and Beauty";
                        break;
                    case "ph":
                        finalCategory="Pharmacy";
                        break;
                    case "ot":
                        finalCategory="Others";
                        break;
                    case "quit":
                        finalCategory="null";
                        break;

                }

            }else{
                System.out.println("Please try again...\n");
                continue;
            } 

            return finalCategory;
        }
    }

    //welcome messages and some instructions
    public static void introMessage(){
        System.out.println("Welcome to our Product Organizer Program");
        System.out.println(
        "To start the program, just input the product \n"+
        "and its corresponding price and category\n"+
        "TAKE NOTE: The category is only limited to\n\n"+
        "[Frozen Foods, Drinks, Cleaning Supplies, Fruits n Veggies,\n" +
        "Cooking Foods,General Foods,Health n Beauty, Pharmacy, Others]"
        );
    }

    //returns the user's product type (Category,price,name)
    public static void askInput(){
        //to check the rerun of product name
        boolean proceed=false;

        String productName=""; float price=0;
        
        while (true){

            System.out.println("\nEnter here your product Name, Price , and Category");
            System.out.println("To choose Category, just type the its corresponding value:");
            System.out.println("Type 'STOP' if you want to stop adding products");
            Scanner input =new Scanner(System.in);//sets input


            //input product name of the product 
            if (proceed==false){
                System.out.print("Input the NAME of your product: ");
                productName= input.nextLine();

                
                if (productName=="STOP"){
                    System.out.println("You are now quitting the program");
                    break;
                }else {
                    System.out.println(productName +"is my name");
                    System.out.println("wowowow");
                }
                // sets to true to avoid rerun if price input is wrong
                proceed=true;
            }

            //checking if the price is a number
            try{
                System.out.print("Input the PRICE of your product: ");
                price= input.nextFloat();
            }
            catch(Exception e){
                System.out.println("\nYour input is wrong please try again\n");
                continue;
            } 

            //if user quits the category input loop, restarts the product inputs all over again
            String productCategory=categoryInput();
            if (productCategory=="null"){// if user quits, restarts all input
                System.out.println("Restarting the program...");
                System.out.println("...........................\n");
                proceed=false;//set to false to rerun the product name
                continue;
            }

            System.out.println("this is the answer of user"+productCategory+productName+price);
            //to go back again to naming input
            proceed=false;


        }

        
    }




// //------------------------------------------------------------------------------------
//     //PRICE METHODS BELOW

//     //returns the sorted price in ASCENDING order
//     public static ascPriceSort(){

//     }

//     //returns the sorted price in DESCENDING order
//     public static desPriceSort(){

//     }
// //-------------------------------------------------------------------------------------
//     //returns the category in alphabetical order (A to Z NOT Z to A para speed code hihi)
//     public static sortCategory(){

//     }

// //-----------------------------------------------------------------------------------------
//     //ALPHABETICAL NAMES METHODS BELOW

//     //ascending of name sort from A to Z
//     public static ascNameSort(){

//     }

//     //descending of name sort from Z to A
//     public static desNameSort(){

//     }
// //-------------------------------------------------------------------------------------------
//     //deletes the product
//     public static deleteProduct(){

//     }
//     //adds the product
//     public static addProduct(){

//     }

//     //prints the needed things here
//     public static void printSomethingHere(){

//     }




    //algorithms insider here
    
}