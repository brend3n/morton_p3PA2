package morton_p3;
import java.util.Scanner;

public class morton_p3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		
		String[] topics = {"Soccer", "Hockey", "Football", "Baseball", "Basketball"} ;
		int[][] responses = new int[5][10];
		int[] topicSum = new int[5];
		int[] count = new int[5];
		double[] topicAverage = new double[5];
		
		int i;
		int rating;
		char choice = 'a';
		
		int min = 10000;
		int max = -1;
		
		String minTopic = "";
		String maxTopic = "";
		
		
		// Get ratings for each topic
		while(choice != 'q')
		{
			System.out.println("Rate each sport from 1 to 10");
			System.out.println("");
			System.out.println("10 ... Most important");
			System.out.println(".");
			System.out.println(".");
			System.out.println(".");
			System.out.println("1 ... Least important");
			System.out.println("");
			
			for(i = 0; i < 5; i++)
			{
				System.out.print("Enter rating for " + topics[i] +" :");
				rating = scan.nextInt();
				
				if(rating == 10) {
					responses[i][9]++;
					
				}else if(rating == 9) {
					responses[i][8]++;
					
				}else if(rating == 8) {
					responses[i][7]++;
					
				}else if(rating == 7) {
					responses[i][6]++;
					
				}else if(rating == 6) {
					responses[i][5]++;
					
				}else if(rating == 5) {
					responses[i][4]++;
					
				}else if(rating == 4) {
					responses[i][3]++;
					
				}else if(rating == 3) {
					responses[i][2]++;
					
				}else if(rating == 2) {
					responses[i][1]++;
					
				}else if(rating == 1) {
					responses[i][0]++;
					
				}else {
					System.out.println("You have entered an invalid rating");
					System.out.println("Valid ratings are between 1-10");
					i--;
					continue;
					
				}
				
			}
			
			System.out.println("Enter 'c' to have another person rate these topics");
			System.out.println("Otherwise, enter 'q' to see the results");
			
			choice = scan.next().charAt(0);
			
			
		}
		
		
		System.out.println("");
		
		
		
		// Add up totals for each topic and counts amount of votes for each topic
		for(i = 0; i < 5;i++)
		{
			for(int j = 0; j < 10; j++) 
			{
				topicSum[i] += (responses[i][j] * (j + 1));
				count[i] += responses[i][j];
			}
		}
		
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		// Calculate average for each topic
		for(i = 0; i < 5; i++)
		{
			topicAverage[i] = (double)topicSum[i] / count[i]; 
		}
		
		
		
		
		// Display 5x10 table of results of poll
		
		System.out.printf("%-10s%7d%7d%7d%7d%7d%7d%7d%7d%7d%7d%10s\n", " ", 1,2,3,4,5,6,7,8,9,10, "Average");	
		System.out.printf("%-10s-----------------------------------------------------------------------------------\n", " ");
		for(i = 0; i < 5; i++)
		{
	
			System.out.printf("%-10s", topics[i]);
			for(int j = 0; j < 10; j++)
			{
				
				System.out.printf("%7d",responses[i][j]);
				
			}
			System.out.printf("%10.2f", topicAverage[i]);
			System.out.println("");
		}
		
		
		
		
		
		// Find topics with max and min number of votes
		for(i = 0; i < 5; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(topicSum[i] > max)
				{
					max = topicSum[i];
					maxTopic = topics[i];
					
				}
				if(topicSum[i] < min)
				{
					min = topicSum[i];
					minTopic = topics[i];
				}
				
			}
		}
		
		
		
		System.out.println("");
		
		System.out.println("Highest Rated Topic: " + maxTopic + "\nPoints: " + max);
		System.out.println("Lowest Rated Topic: " + minTopic + "\nPoints: " + min);
		
		
		
		
		
		
	}

}
