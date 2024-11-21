package lab678;
import java.util.Scanner;
public class Trip {
	Scanner input=new Scanner(System.in);
	private double miles;
	private double gallons;
	public Trip(double miles,double gallons) {
		this.miles=miles;
		this.gallons=gallons;
	}
	public double getmiles() {return miles;}
	public double getgallons() {return gallons;}
	public double calculate() {
		return miles/gallons;
	}
}




