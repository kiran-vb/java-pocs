package generics;
class CompTest implements Comparable<CompTest>{

	@Override
	public int compareTo(CompTest o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
public class TestGen {

	public static void main(String[] args) {
		GenericClass<CompTest> s =new GenericClass<>();
		s.setGenType(new CompTest());
		GenericClass<CompTest> s1 =new GenericClass<>();
		s1.setGenType(new CompTest());
		boolean flg = TestGen.compare(s, s1);
		System.out.println("Flag is >> "+flg);
		
	}
	
	//********************************************UPPER BOUND  >>>>> <T extends Comparable<T>> ***************//////////////////////
	
	// 
	
	/*Suppose we want to restrict the type of objects that can be used in the parameterized type,
    for example in a method that compares two objects and we want to make sure that the accepted objects are Comparables.
    To declare a bounded type parameter, list the type parameter’s name, followed by the extends keyword,
	followed by its upper bound, similar like below metho*/
	
	
	//********************************************UPPER BOUND >>>>>  <T extends Comparable<T>> *****************//////////////////////
	public static <T extends Comparable<T>>  boolean compare(GenericClass<T> o1,GenericClass<T> o2){
		return o1.getGenType().equals(o2.getGenType());
	}

}
