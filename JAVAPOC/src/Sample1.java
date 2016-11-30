
public class Sample1 {

	public static void main(String[] args) {
	
		int age=10;
		String name="Kiran";
		System.out.println("from main");
		secondFun(age,name);

	}
	
	public static void secondFun(int age1,String name1){
		System.out.println("from SecondFun");
		System.out.println(name1);
		System.out.println(age1);
	}

}
