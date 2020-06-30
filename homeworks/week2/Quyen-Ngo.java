import java.util.HashSet;
import java.util.Scanner;

public class Quyen-Ngo {

	public static void main(String[] args) {

		//Time complexity : O(n)
		//Space complexity: O(n)		


		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		HashSet<Character> hs = new HashSet<Character>();
		char[] arr = s.toCharArray();
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if (!(hs.add(arr[i]))) {
				arr[i]= ' ';
				count++;
			}
		}
		
		char[] array = new char[arr.length-count];
		int z =0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i]!=' ') {
				array[z] = arr[i];
				z++;
			}
		}

		System.out.println(String.valueOf(array));
		

	}

}
