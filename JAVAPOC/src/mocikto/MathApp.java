package mocikto;

public class MathApp implements CalcService{

	
	private CalcService calcService;

	   public void setCalculatorService(CalcService calcService){
	      this.calcService = calcService;
	   }
	   
	   public double add(double input1, double input2){
	      return calcService.add(input1, input2);
	   }
	   
	   public double subtract(double input1, double input2){
	      return calcService.subtract(input1, input2);
	   }
	
}
