package Java_Practice;

public class findDuplicateElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,1,3,4,3,3,5,7,5,7,9,7};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]&& i!=j) {
					System.out.println(arr[i]);
				}
			}
		}
	}

}
