import java.util.Scanner;

public class ProductOrganizer{
    //Insert here the methods only for our class


    //try and catch method
    // public static checkInput(){

    // }

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

        while (true){

            System.out.println("\nEnter here your product Name, Price , and Category");
            System.out.println("To choose Category, just type the its corresponding value:");
            Scanner input =new Scanner(System.in);//sets input

            //input product name of the product 
            System.out.print("Input the NAME of your product: ");
            String productName= input.nextLine();

            //checking if the price is a number
            try{
                System.out.print("Input the PRICE of your product: ");
                float price= input.nextFloat();
            }
            catch(Exception e){
                System.out.println("\nYour input is wrong please try again");
                continue;
            } 

            break;

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