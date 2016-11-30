package panel1;

public class SubStringTest {

	public static void main(String[] args) {
		String str= "Kiran";
		
		for(int i= 0;i<str.length();i++){
			System.out.println(str.charAt(i) + str.substring(0, i+1));
		}
		
		String str1="b2b:chrob_mgr";
	       System.out.println(str1.substring(4,str1.indexOf('_')));

	}

}
