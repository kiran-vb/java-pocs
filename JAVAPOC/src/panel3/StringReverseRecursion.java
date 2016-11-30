package panel3;

public class StringReverseRecursion {
	 
    String reverse = "";
     
    public String reverseString(String str){
         
        if(str.length() == 1){
            return str;
        } else {
            reverse += str.charAt(str.length()-1)+reverseString(str.substring(0,str.length()-1));
            return reverse;
        }
    }
     
    public static void main(String a[]){
    	StringReverseRecursion srr = new StringReverseRecursion();
        System.out.println("Result: "+srr.reverseString("Kiran"));
    }
}
//- See more at: http://www.java2novice.com/java-interview-programs/string-reverse-recursive/#sthash.ApXQ5OIP.dpuf
