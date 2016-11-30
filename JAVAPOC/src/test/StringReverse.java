package test;

public class StringReverse {
	String reverse = "";
    
    public String reverseString(String str){
    	
    	
         
        if(str.length() == 1){
            return str;
        } else {
            reverse += str.charAt(str.length()-1)
                    +reverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }
     
    public static void main(String a[]){
    	StringReverse srr = new StringReverse();
        System.out.println("Result: "+srr.reverseString("Java2novice"));
        
        
        "Java2novice".substring(0,"Java2novice".length()-1);
        System.out.println(  "Java2novice".substring(0,"Java2novice".length()-1));
    }

}
