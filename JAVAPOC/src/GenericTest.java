import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;


public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Object> pathParameters = new HashMap<String, Object>();
		//pathParameters.put("addr", "Santa Clara");
		pathParameters.put("", "");
		pathParameters.put("", "");
		pathParameters.put("", "");
		System.out.println(pathParameters);
		
		Queue queueA = new LinkedList();
		
		Random rn = new Random();
		int max=10;
		while(max<=0){
			int  n = rn.nextInt(max) + 1;
			queueA.add(n);
			max--;
		}
		
		System.out.println(queueA);
		
	}

}
