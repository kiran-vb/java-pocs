package ds;

public class Insertion {

	
	public static void main(String[] args){
		
		   //int LA[] = {1,3,5,7,8};
		   int LA[] = new int[10];
		   LA[0]=1;
		   LA[1]=3;
		   LA[2]=5;
		   LA[3]=7;
		   LA[4]=9;
		   
		   int item = 10, k = 3, n = 5;
		   int i = 0, j = n;
		
		   while( j >= k) {
		      LA[j+1] = LA[j];
		      j = j - 1;
		      for(i = 0; i<n; i++) {
			      System.out.print(LA[i]);
			}
		      System.out.println();
		   }
		   
		   LA[k] = item;
		   n = n + 1;
		   for(i = 0; i<n; i++) {
			      System.out.println(LA[i]);
			}
	}
	
}
