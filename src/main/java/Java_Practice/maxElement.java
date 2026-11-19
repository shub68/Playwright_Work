package Java_Practice;

public class maxElement {

	public static void main(String arg[]) {
		
		int arr[]= {18,2,101,99,12};
		int max=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<max) {
				max=arr[i];
			}
		}
		System.out.println(max);
	}
}
