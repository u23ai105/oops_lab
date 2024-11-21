package FigPackage;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class singlecharacter {
	private String inputstring;
	public singlecharacter(String inputstring){
		this.inputstring=inputstring;
	}
	public void printfrequency() {
		Map<Character,Integer>mp=new HashMap<>();
		for(char ch:inputstring.toCharArray()) mp.put(ch, mp.getOrDefault(ch, 0)+1);
		boolean found=false;
		for(Map.Entry<Character,Integer> entry:mp.entrySet()) {
			if(entry.getValue()>1) {
				System.out.println("Characters appear more than 1 time so it is not a good string");
				found=true;
			}
		}
		if(!found) {
			System.out.println("No characters exceeded the given threshold of 1.");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        singlecharacter c1=new singlecharacter(inputString);
		c1.printfrequency();
		scanner.close();
	}
}
