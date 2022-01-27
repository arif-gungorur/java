package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Shopping {
    static List<String> productList = new ArrayList<>(Arrays.asList("00 Potato","01 Onion","02 Pepper","03 Olive","04 Cheese"));
    static List<Double> priceList = new ArrayList<>(Arrays.asList(2.10,  3.10, 1.20, 1.90, 6.10));
    static List<String> cartProductList = new ArrayList<>();
    static List<Double> cartKgList=new ArrayList<>();
    static List<Double>cartPriceList=new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String yesOrNoShopping = " ";
        double total=0 ;
        do {
            productList();
            System.out.println("Please write the code of the product you want");
            int productNo = scan.nextInt();
            System.out.println("Please write the kg of the product you want");
            double productKg = scan.nextDouble();
            addToCart(productNo,productKg);
            total=cartTotal() ;
            System.out.println("if you want to continue to shopping type 'Yes'");
            yesOrNoShopping =scan.nextLine();


        } while (yesOrNoShopping.equalsIgnoreCase("yes"));
        payment(total);
    }

    private static double cartTotal() {
        double cartPrice = 0 ;
        double cartKg = 0 ;
        for (int i = 0; i < cartProductList.size(); i++) {
            cartPrice+=cartPriceList.get(i) ;
            cartKg+=cartKgList.get(i);

        }
        System.out.println("Total Price = "+cartPrice +" Total Kilo = " + cartKg);
        return cartPrice ;
    }
    private static void payment(double total) {
        System.out.println("You should pay =  " + total);
        double payment = 0;

        do {
            System.out.println("Please enter your payment ");
            payment += scan.nextDouble();
            if (payment<total) {
                System.out.println("You underpaid. Also the amount you have to pay = " + (total-payment));

            }
        }
        while (payment<total);
        double change = payment-total ;
        if (change>0) {
            System.out.println("Thank you for choosing us , change = " + change);
        }

    }

    private static void addToCart(int productNo, double productKg) {
        cartProductList.add(productList.get(productNo));
        cartKgList.add(productKg);
        cartPriceList.add(priceList.get(productNo)*productKg);



    }

    private static void productList() {
        System.out.println("No\t Products \t Prices");
        System.out.println("=====\t ======== \t =======");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(" " +i + "\t"+ productList.get(i)+"\t"+priceList.get(i));


        }




    }

}


