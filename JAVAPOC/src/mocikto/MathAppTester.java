package mocikto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
//import static org.mockito.Matchers.




@RunWith(MockitoJUnitRunner.class)
public class MathAppTester {

	/* //@InjectMocks annotation is used to create and inject the mock object
	   @InjectMocks 
	   MathApp mathApplication = new MathApp();
	   //@Mock annotation is used to create the mock object to be injected
	   @Mock
	   CalcService calcService;*/
	
	private MathApp mathApplication;
	   private CalcService calcService;
	   
	   @Before
	   public void setUp(){
		      mathApplication = new MathApp();
		      calcService = Mockito.mock(CalcService.class);
		      mathApplication.setCalculatorService(calcService);
	   }
	   

	   @Test
	   public void testAdd(){
	      //add the behavior of calc service to add two numbers
	      Mockito.when(calcService.add(10.0,20.0)).thenReturn(30.00);
	      
	    
	      //test the add functionality
	      Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
	      
	   
	    //Mockito.verify((calcService).add(10.0, 20.0));
	     
	    Mockito.verify(calcService).add(10.0, 20.0);
	   
	   }
	   @Test
	   public void testSub(){
		      Mockito.when(calcService.subtract(20, 10)).thenReturn(20.00);
		      Assert.assertEquals(mathApplication.subtract(20,10),20,0);
	   }
	
}
