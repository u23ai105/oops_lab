package FigPackage;
public class PasswordValidator {
	public static void validator(String password) {
		int n=password.length();
		if(n<=5 && n>=12) System.out.println("the given password length is not valid, password length must be between 5 and 12");
		boolean num=false,small=false,cap=false,special=false,ispattern=false;
		for(char ch:password.toCharArray()) {
			if(Character.isLowerCase(ch)) small=true;
			else if(Character.isUpperCase(ch)) {
				cap=true;
				break;
			}
			else if(Character.isDigit(ch)) num=true;
			else{
				special=true;
				break;
			}
			}
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<=n;j++) {
			String pattern=password.substring(i,j);
			int nextpatternindex=j;
			if(nextpatternindex+j-i<=n) {
				String nextpattern=password.substring(nextpatternindex,nextpatternindex+j-i);
				if(pattern.equals(nextpattern)) ispattern=true;
			}
			}
		}
		if(cap) System.out.println("the given password has a uppercase character so it is not valid");
		else if(special) System.out.println("the given password has a special character so it is not valid");
		else if(ispattern) System.out.println("the given password has a pattern so it is not valid");
		else if(!num)  System.out.println("the given password doesnot have a number so it is not valid");
		else if(!small)  System.out.println("the given password has a doesnot have a lowercase character so it is not valid");
		else System.out.println("The password is valid");
	}
	public static void main(String[] args) {
		validator("abcanan1");
		validator("abc11se");
		validator("123sd123");
		validator("adfasdsdf");
		validator("Aasdfasd12");
	}
	}
