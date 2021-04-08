package com.saumil.project2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class Shipment {

        private Package package1;
        private Package package2;
        private NumberFormat currency;
        private DecimalFormat decimal;
	
        // I am using cost_package in multiple methods so I have extra feilds to   
        private double cost_package1;
        private double cost_package2;
	
	
	
        // Initialization of fields in Constructor.
        public Shipment() {
                package1 = new Package();
                package2 = new Package();
                currency = NumberFormat.getCurrencyInstance(Locale.CANADA);
                decimal = new DecimalFormat("0.0");

         }

        // To Forward Call to display so we don't have to call display in main method.
        // Main->inputPackage -> Display->InputPacage-> Volume -> Cost -> Comparison
        // method.
        public void inputPackage() {
               display();
        }

        // public method to input or modify package dimensions.
        public void inputPackage(Package pac) {
                pac.inputLength();
                pac.inputWidth();
                pac.inputHeight();

        }

        // Public Method to avoid repetition of Code and get Cost using Package Object
        // from main method in case needed..
        public double calculateCost(Package pac) {

                double shipmetVolume = pac.calcVolume();
                double cost = 3;

                if (shipmetVolume > 1) {
                       cost += shipmetVolume - 1;
                }

                return cost;
       }

        // Public Method to avoid repetition of Code and get Volume using Package Object
        // from main method in case needed..
        public String shipmetVolume(Package pac) {
                return decimal.format(pac.calcVolume());
        }

        // Made method private so we don't call it from Main before populating package
        // to avoid null point execption.
        private void shipmentVolume() {
                System.out.print("\nFirst Package dimension: ");
                package1.displayDimension();
                System.out.println("Volume= " + shipmetVolume(package1));
                System.out.print("Second Package dimension: ");
                package2.displayDimension();
                System.out.println("Volume= " + shipmetVolume(package2));
        }

        // To Get Desired output in sequence.
        public void display() {
                System.out.println("Welcome to John Doe's calculator!\n\nEnter First package dimensions.");
                inputPackage(package1);

                System.out.print("\nEnter Second package dimensions.\n");
                inputPackage(package2);

                shipmentVolume();
		        
                cost_package1= calculateCost(package1);
                cost_package2=calculateCost(package2);
	
                System.out.println("Package 1 will cost " + currency.format(cost_package1) + " to ship.");
                System.out.println("Package 2 will cost " + currency.format(cost_package2) + " to ship.");
		
                compair();
        }

	
        //private method so  we don't call it from main before initialing package and get null point exception.
        private void compair() {

                double difference; 
		
                if (cost_package1 >= cost_package2) {
                        difference= cost_package1/cost_package2;
                        compair("The first package", "the second package ",difference );
                } else {
                        difference= cost_package2/cost_package1;
                        compair("The second package", "the first package ", difference);
                }

        }

        // private method to display message
        private void compair(String pac, String pac1, double difference) {
		
                if(difference==1) {		
                        System.out.println(pac +" is same as "+ pac1);	
                } else if (difference>1 && difference <2 ) {
                        System.out.println(pac+ " is slightly more than the "+ pac1);
                } else if(difference >=2 && difference <3) {
                        System.out.println(pac+ " is twice "+ pac1);			
                }else if(difference >=3 && difference <4) {
                        System.out.println(pac+ " is triple "+ pac1);			
                }else if(difference >=4 && difference <5) {
                        System.out.println(pac+ " is quadruple "+ pac1);			
                }else {
                        System.out.println(pac+ " is "+ difference +" times "+ pac1);
                }
		
		
        }

}
