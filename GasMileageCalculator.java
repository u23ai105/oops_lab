package lab678;
import java.util.Scanner;
public class GasMileageCalculator {
	private double totalmiles=0.0;
	private double totalgallons=0.0;
	private int tripcount=0;
	public void addTrip(Trip trip) {
		totalmiles+=trip.getmiles();
		totalgallons+=trip.getgallons();
		tripcount++;
	}
	public void displaytripmileage(Trip trip) {
		double milespergallon=trip.calculate();
		System.out.println("Miles per gallon for this trip : "+milespergallon);
	}
	public void dispalycombined() {
		if(tripcount>0) {
			double combined=totalmiles/totalgallons;
			System.out.println("Combined miles per gallon for all the trips : "+combined);
		}
	}
	public void displayfinalmileage() {
		if(tripcount>0) {
			System.out.println("final combined miles per gallon for all trips : "+totalmiles/totalgallons);
		}
		else {
			System.out.println("no trips recorded.");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GasMileageCalculator calculator=new GasMileageCalculator();
		while(true) {
			System.out.println("enetr miles driven fo the trip (-1 to quit)");
			double miles=scanner.nextDouble();
			if(miles==-1) break;
			System.out.println("enetr gallons used for the trip");
			double gallons=scanner.nextDouble();
			if(gallons<=0) {
				System.out.println("Gallons use must be greater than 0 please enter again.");
				continue;
			}
			Trip trip =new Trip(miles,gallons);
			calculator.addTrip(trip);
			calculator.displaytripmileage(trip);
			calculator.dispalycombined();
			System.out.println();
		}
		calculator.displayfinalmileage();
		scanner.close();
	}
}
