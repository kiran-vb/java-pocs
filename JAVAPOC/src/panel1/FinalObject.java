package panel1;

 

	class A
	{
	    int i = 10;

	    public void setI(int b)
	    {
	        i = b;
	    }

	    public int getI()
	    {
	        return i;
	    }
	}

	public class FinalObject
	{    
	    public static void main(String args[]) throws Throwable
	    { 
	        final A ob = new A();
	        ob.setI(12);
	        System.out.println(ob.getI());
	        m1(ob);
	    }
	    static void m1(A obj){
	    	obj = new A();
	    }
	   // 'final' simply makes the object reference unchangeable. The object it points to is not immutable by doing this. 
	   //  INSTANCE can never refer to another object, but the object it refers to may change state.
	}

