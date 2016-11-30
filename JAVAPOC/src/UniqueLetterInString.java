import java.util.HashMap;


public class UniqueLetterInString {

	public static void main(String[] args) {
		String s ="stress";
		//0654566445998
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
	            if(hm.containsKey(c))
	            {
	            // increment count corresponding to c
	            	hm.put(  c ,  hm.get(c) +1 );
	            }
	            else
	            {
	            	hm.put( c , 1 ) ;
	            }
		}
System.out.println("hm is>> " +hm);
		for (int i =0 ; i < hm.size() ; i++ )
        {
           char c= s.charAt(i);
            if( hm.get(c)  == 1 ){
            	  System.out.println("char is >>> " + c);
            	  break;
            }
            
        }
	
		
	}

}
