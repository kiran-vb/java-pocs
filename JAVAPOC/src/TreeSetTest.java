import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet ts = new TreeSet();
		Dog d = new Dog();
		ts.add(d);
		System.out.println();
		//add();
		ArrayList al = new ArrayList();
		add(al);
		Set s =new HashSet();
		add(s);
	}
	
	static void add(Collection l){
		System.out.println();
	}

}
class Dog implements Comparable<Dog>{
	int j=10;

	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return 0;
	}
}