import java.util.*;

public class ProductOrganizer{
    //Insert here the methods only for our class

    //A list within a list for the products
    //List of ALL products with their corresponding price and category
    static ArrayList<ArrayList<String>> allProductList= new ArrayList<ArrayList<String>>();

    // EACH product with price and category formed inside a list
    static ArrayList<String> eachProductList= new ArrayList<String>();

    static float categoryStart,categoryEnd, ascNameStart, ascNameEnd, desNameStart, desNameEnd, priceStart,priceEnd;

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
        int something=0;
        
        while (true){

            System.out.println("\nEnter here your product Name, Price , and Category");
            System.out.println("To choose Category, just type the its corresponding value:");
            System.out.println("Type '0' if you want to STOP adding products");
            Scanner input =new Scanner(System.in);//sets input


            //input product name of the product 
            if (proceed==false){

                System.out.print("Input the NAME of your product: ");
                productName= input.nextLine();

                //checks if user types 0
                try{
                    something=Integer.parseInt(productName);

                    //if user types 0, the program will quit
                    if (something==0){
                        System.out.println("You are now quitting the program");
                        break;

                    //if user types other number, the program will restart
                    } else if (something!=0){

                        continue;
                    }
                //if user type a string not a number, saves the product name
                }catch(Exception e){

                }

            

                // sets to true to avoid rerun if price input is wrong
                proceed=true;
            }

            //checking if the price is a number
            try{
                System.out.print("Input the PRICE of your product: ");
                price = input.nextFloat();
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

            //adds the product name , price and product category in the eachProductList
            // this is the format -- [Product Name, Price(String form), Product Category] 
            eachProductList.add(productName);
            eachProductList.add(String.valueOf(price));//converts from int to string for the list
            eachProductList.add(productCategory);
       
            // System.out.println(eachProductList);

            //FORMAT for allProductList -- a list within a list 
            // [ [name1,price1,category 1], [name2,price2,category 2]...]
            allProductList.add(eachProductList);//adds the product list to the overall lists

            // System.out.println(allProductList);
            
            //setting a new list for th eachProduct List(removes previous elements)
            eachProductList= new ArrayList<String>();

            //to go back again to naming input
            proceed=false;

        }

    }




// //-------------------------------------------------------------------------------------
//     //returns the category in alphabetical order 
//     public static sortCategory(){
        public static void sortCategory(int lowerIndex, int higherIndex) {
            categoryStart=System.nanoTime();
            int i = lowerIndex;
            int j = higherIndex;
            String pivot = allProductList.get(lowerIndex + (higherIndex - lowerIndex) / 2).get(2);

            while (i <= j) {
                while (allProductList.get(i).get(2).compareToIgnoreCase(pivot) < 0 ) {
                    i++;
                }
                while (allProductList.get(j).get(2).compareToIgnoreCase(pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    Collections.swap(allProductList, i, j);
                    i++;
                    j--;
                }
            }
            if (lowerIndex < j) {
                sortCategory(lowerIndex, j);
            }
            if (i < higherIndex) {
                sortCategory(i, higherIndex);
            }  
        }

        public static void sortCategoryPrint() {
            int len = allProductList.size();
            sortCategory(0, len - 1);
            for (int a = 0 ; a < allProductList.size() ; a ++) {
                String cat = allProductList.get(a).get(2);
                try {
                    if (cat != allProductList.get(a-1).get(2)) {
                        System.out.println("\n" + cat + ": \n");
                        System.out.println(allProductList.get(a));
                    } else {
                        System.out.println(allProductList.get(a));
                    }         
                } catch (Exception e) {
                    System.out.println("--- BY CATEGORY -- \n" + cat + ": \n" + allProductList.get(a));
                }
            }
            categoryEnd=System.nanoTime();   
            System.out.printf("The Time Complexity of Category Method is %.5f \n",categoryEnd-categoryStart);       
        }

   
//     }
// //-----------------------------------------------------------------------------------------
//     //ALPHABETICAL NAMES METHODS BELOW (QuickSort)

//     //ascending of name sort from A to Z
        public static void ascNameSort(int lowerIndex, int higherIndex) {
            ascNameStart=System.nanoTime();
            int i = lowerIndex;
            int j = higherIndex;
            String pivot = allProductList.get(lowerIndex + (higherIndex - lowerIndex) / 2).get(0);

            while (i <= j) {
                while (allProductList.get(i).get(0).compareToIgnoreCase(pivot) < 0 ) {
                    i++;
                }
                while (allProductList.get(j).get(0).compareToIgnoreCase(pivot) > 0) {
                    j--;
                }
                if (i <= j) {
                    Collections.swap(allProductList, i, j);
                    i++;
                    j--;
                }
            }
            if (lowerIndex < j) {
                ascNameSort(lowerIndex, j);
            }
            if (i < higherIndex) {
                ascNameSort(i, higherIndex);
            }  
        }
        public static void ascNameSortPrint() {
            int len = allProductList.size();
            ascNameSort(0, len - 1);
            System.out.println("\n --- NAME SORT: ASCENDING --- \n" +allProductList);   
            ascNameEnd=System.nanoTime();      
            System.out.printf("The Time Complexity of Ascending Product Name Method is %.5f \n",ascNameEnd-ascNameStart);
        }

        //     //descending of name sort from Z to A

        public static void descNameSort(int lowerIndex, int higherIndex) {
            desNameStart=System.nanoTime();
            int i = lowerIndex;
            int j = higherIndex;
            String pivot = allProductList.get(lowerIndex + (higherIndex - lowerIndex) / 2).get(0);

            while (i <= j) {
                while (allProductList.get(i).get(0).compareToIgnoreCase(pivot) > 0 ) {
                    i++;
                }
                while (allProductList.get(j).get(0).compareToIgnoreCase(pivot) < 0) {
                    j--;
                }
                if (i <= j) {
                    Collections.swap(allProductList, i, j);
                    i++;
                    j--;
                }
            }
            if (lowerIndex < j) {
                descNameSort(lowerIndex, j);
            }
            if (i < higherIndex) {
                descNameSort(i, higherIndex);
            }  
        }
        public static void descNameSortPrint() {
            int len = allProductList.size();
            descNameSort(0, len - 1);
            System.out.println("\n --- NAME SORT: DESCENDING --- \n" + allProductList);      
            desNameEnd=System.nanoTime();
            System.out.printf("The Time Complexity of Descending Product Name Method is %.5f \n\n",desNameEnd-desNameStart);

        }
        //prints the price of each product in a list.
        public static void showAllProductPrices(){
            String tempStr;
            float strToInt;
            int floatToInt;
            int tempArr[]=new int[allProductList.size()];
            int count=0;
            //putting all prices in a new array
            for (ArrayList<String> sample:allProductList){
                tempStr=sample.get(1);
                strToInt=Float.parseFloat(tempStr);
                floatToInt=(int)strToInt;
                tempArr[count]=floatToInt;
                count+=1;
            }
            System.out.println(Arrays.toString(tempArr));
            
            priceStart=System.nanoTime();
            int a;
            int b;
            int temp;
            int price=allProductList.size();
            for(a = 0; a<price; a++) 
				for(a=0; a<(price-1); a++) {
					for(b=0; b<price-a-1; b++) {	
						if(tempArr[b] > tempArr[b+1]) 
							{
							temp = tempArr[b];
							tempArr[b]= tempArr[b+1];
							tempArr[b+1] = temp;
							}
						}
                    }
            System.out.println("Ascending price list of products is: ");
                for (a=0; a<price; a++) 
                    System.out.println(tempArr[a]);
            priceEnd=System.nanoTime();
            System.out.printf("The Time Complexity of Price Method is %.5f \n\n",priceEnd-priceStart);
            }
        }
    
    

// //-------------------------------------------------------------------------------------------   