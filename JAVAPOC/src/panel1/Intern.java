package panel1;

public class Intern {

	public static void main(String[] args) {
		String s1 = "Rakesh";
		String s2 = "Rakesh";
		String s3 = "Rakesh".intern();
		String s4 = new String("Rakesh");
		String s5 = new String("Rakesh").intern();
		String s6 = new String("rakesh");

		if ( s1 == s2 ){
		    System.out.println("s1 and s2 are same");  // 1.
		}

		if ( s1 == s3 ){
		    System.out.println("s1 and s3 are same" );  // 2.
		}

		if ( s1 == s4 ){
		    System.out.println("s1 and s4 are same" );  // 3.
		}

		if ( s1 == s5 ){
		    System.out.println("s1 and s5 are same" );  // 4.
		}

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s5.hashCode());
		System.out.println(s6.hashCode());
		

	}

}
