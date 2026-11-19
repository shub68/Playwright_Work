package Java_Practice;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="Shubham";
		
		String rev="";
		
		for(int i=str.length()-1;i>=0;i--) {
			rev=rev + str.charAt(i);
		}
System.out.println(rev);
	}

}
