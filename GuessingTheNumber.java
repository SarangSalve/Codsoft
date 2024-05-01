package Projects;

import java.util.Scanner;

public class GuessingTheNumber {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int a,c=0;
		
		int num=(int)(Math.random()*100);
		
	//	System.out.println(num);
		
		for(int i=1;i<=5;i++) {
		
		do {
			
		System.out.println("Enter Number");
		a=sc.nextInt();
		c++;
		
		if(a==num) {
			System.out.println("Correct Choice");
			break;
		}else if( a<num) {
			
			System.out.println("Your Number is Too Low");
		}else if(a>num) {
			
			System.out.println("Your Number is Too High");
		}
			
		else if(a<0) {
			System.out.println("Invaild Choice");
		}
		
		
		}while(a!=0);
		System.out.println();
		System.out.println("Your Correct Choice in ="+c+ "Times");
		
	}
	}
}
