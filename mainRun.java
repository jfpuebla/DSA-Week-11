public class mainRun {
    public static void main (String[] args){
        //Insert here the main flow of our program 
        ProductOrganizer.introMessage();
        ProductOrganizer.askInput();
        System.out.println(ProductOrganizer.eachProductList[productName]);

        ProductOrganizer.ascNameSortPrint();
        ProductOrganizer.descNameSortPrint();
    }

}
