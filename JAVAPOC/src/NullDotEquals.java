
public class NullDotEquals {

	public  String fullName;
	

	public String Bday;
	public String email;
	
	
	public NullDotEquals() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String FromEilte = null;
		System.out.println("true".equals(FromEilte));
		System.out.println(!FromEilte.equals("true"));
	}

}
