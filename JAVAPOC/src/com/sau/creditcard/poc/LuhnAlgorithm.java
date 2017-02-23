package com.sau.creditcard.poc;

public class LuhnAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   String card ="5346800014188796"; //correct id
	//	String card="4386800014184890";
     
		int totCount=0;
		int oddCount=0;
		for(int i=0;i<card.length();i++){
			int x = getsum(Character.getNumericValue(card.charAt(++i))*2);
			totCount+=x;
		}
		
		for(int i=0;i<card.length();i++){
			int y = Character.getNumericValue(card.charAt(i));
			totCount+=y;
			i++;
		}
		
		//System.out.println(totCount);
		System.out.println(check(card));
	}
	   static int getsum(int n) {
		   return n == 0 ? 0 : n % 10 + getsum(n/10);
		}
	   
	   public static String check(String ccNumber)
	    {
	            int sum = 0;
	            boolean alternate = false;
	            for (int i = ccNumber.length() - 1; i >= 0; i--)
	            {
	                    int n = Integer.parseInt(ccNumber.substring(i, i + 1));
	                    if (alternate)
	                    {
	                            n *= 2;
	                            if (n > 9)
	                            {
	                                    n = (n % 10) + 1;
	                            }
	                    }
	                    sum += n;
	                    alternate = !alternate;
	            }
	            System.out.println(sum);
	          //  return (sum % 10 == 0);
	            return (sum % 10 == 0)? "Valid":"InValid";
	    }
}
