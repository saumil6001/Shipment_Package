package com.saumil.project2;
import java.util.Scanner;

public class Package {

        private double length, width, height;
        private Scanner input = new java.util.Scanner(System.in);

        //Basic Constructor to initiate all feilds.
        public Package() {
                this.length = 1;
                this.width = 1;
                this.height = 1;
        }

        //Constructor to intiate Class and Set feilds. 
        public Package(double length, double width, double height) {
                this.length = length;
                this.width = width;
                this.height = height;
        }

        //Repalceing all feilds of Object in class. 
        public Package(Package pac) {
                this.length=pac.length;
                this.width = pac.width;
                this.height = pac.height;
        }

        //Scanner object to input length, with and height.
        public void inputLength() {
                System.out.print("Enter Legth: ");
                this.length=input.nextDouble(); 
        }
	
        //Scanner object to input length, with and height.	
        public void inputWidth() {
                System.out.print("Enter Width: ");
                this.width=input.nextDouble(); 
        }
	
        //Scanner object to input length, with and height.
        public void inputHeight() {
                System.out.print("Enter Height: ");
                this.height=input.nextDouble(); 
        }
	
        //display package dimension. 	
        public void displayDimension() {	
               System.out.print(this.length +" X " +this.width +" X "+ this.height+", ");
        }
	
        // calculate volume of package.
        public double calcVolume() {
             return this.length*this.width*this.height;
        }

	
}





