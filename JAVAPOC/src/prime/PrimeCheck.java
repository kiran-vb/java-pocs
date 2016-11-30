package prime;

import java.util.HashMap;

public class PrimeCheck {
	 static HashMap<Integer,Boolean> map = new HashMap<>();
	public static HashMap<Integer,Boolean> check(int number){
		
		map.clear();
		 int i,m=0,flag=0;    
		  m=number/2;    
		  for(i=2;i<=m;i++){    
		   if(number%i==0){    
		  // System.out.println("Number is not prime");    
		   flag=1;    
		   break;    
		   }    
		  }    
		  if(flag==0){    
			  map.put(number, true);
		  }else{
		  map.put(number, false);
		  }
		return map;
	}

}
