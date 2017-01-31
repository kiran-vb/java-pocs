package com.sau.creditcard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.csvreader.CsvWriter;
 
public class CreditCardCheck {
	
	public enum Industry {
	    AIRLINES("Airlines"),
	    TRAVEL("Travle"),
	    BANKINGANDFINANCE("Banking and Financial"),
	    MERCHANDISINGBANKINGANDFINANCE("Merchandising and Banking/Financial"),
	    PETROLIUM("Petroleum"),
	    HELTHCARETELCOMM("Healthcare, Telecommunications"),
	    NATIONALASSIGNMENT("National Assignment");
	    private final String industry;
	    private Industry(final String industry) {
	        this.industry = industry;
	    }
	    @Override
	    public String toString() {
	        return industry;
	    }
	}
	public enum Issuer {
		AMEX("Amex"),
		MASTERCARD("MasterCard"),
		VISA("Visa"),
		DISCOVER("Discover");
	    private final String issuer;
	    private Issuer(final String issuer) {
	        this.issuer = issuer;
	    }
	    @Override
	    public String toString() {
	        return issuer;
	    }
	}
	
	static List<String> cardNumbersList=null;
	static int inputTrailCount=1;
	static String csvFile = "C:\\Users\\veigandl\\git\\core-java-poc-git\\JAVAPOC\\src\\com\\sau\\creditcard\\cardInfo.csv";
	static{
		String line = "";
        String cvsSplitBy = ",";
        cardNumbersList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(new File(csvFile)))) {
            while ((line = br.readLine()) != null) {
            	String[] country = line.split(cvsSplitBy);
                cardNumbersList.add(country[0].replaceAll("\"", ""));
               }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		readInputCard();
	}
	
	private static void readInputCard(){
		try{
			
			   Scanner sc=new Scanner(System.in);  
		       System.out.println("Enter your Credit Card Number !!! ");  
			   String ccNumber = sc.next();
			   System.out.println("CC number ::::: " + ccNumber );
			   
			   boolean cardExist = cardCheckInFile(ccNumber);
			   if(cardExist){
				   
			   }else{
				   validateCardNumber(ccNumber);
		       }
			}catch(Exception ex){
					ex.printStackTrace();
			}
	}

	private static void validateCardNumber(String ccNumber) {
		String pattern = "[0-9]+";
		  Pattern r = Pattern.compile(pattern);
	      Matcher m = r.matcher(ccNumber);
	      if (m.matches()) {
	        System.out.println("MATCH");
	        getCardInfo(ccNumber);
	      }else {
	         System.out.println(inputTrailCount +" ::::: NO MATCH");
	         if(inputTrailCount<=3){
	        	 inputTrailCount++;
	        	 readInputCard(); 
	         }else{
	        	 System.out.println("Failed 3 attempts please wait and try after 30 seconds !!!!s");
	        	 //print 30 seconds !!!!
	        	 inputTrailCount=0;
	        	 readInputCard();
	         }
	         
	      }
		
		
	}
/**
 * 
 * @param ccNumber
 * Storing below information
 * Card id, industry information,issuer information,
   user account,card status
 * 
 */
	private static void getCardInfo(String ccNumber) {
		final String cardNumber = ccNumber;
		
		CreditCardCheck creditCardCheck = new CreditCardCheck();
		final CreditCardCheck.CardInfo cardInfo = creditCardCheck.new CardInfo();
		cardInfo.setCardNumber(ccNumber);
		cardInfo.setAccountNumber(getAccountNumber(ccNumber));
		
		
		Thread mii = new Thread() {
		    public void run() {
		        System.out.println(Thread.currentThread().getName() +" ::: "+Thread.currentThread().getPriority());
		        getMii(cardNumber);
		    }

			private void getMii(String cardNumber) {
			    switch(cardNumber.charAt(0)){  
			    case '1':  case '2': cardInfo.setIndustry(Industry.AIRLINES.toString());break; 
			    case '3': cardInfo.setIndustry(Industry.TRAVEL.toString());break;  
			    case '4': case '5': cardInfo.setIndustry(Industry.BANKINGANDFINANCE.toString());break; 
			    case '6': cardInfo.setIndustry(Industry.MERCHANDISINGBANKINGANDFINANCE.toString());break;  
			    case '7': cardInfo.setIndustry(Industry.PETROLIUM.toString());break;  
			    case '8': cardInfo.setIndustry(Industry.HELTHCARETELCOMM.toString());break;  
			    case '9': cardInfo.setIndustry(Industry.NATIONALASSIGNMENT.toString());break;  
			    default:System.out.println("Not in List of industries !!!");  
			    }  
			}
		};
		Thread bin = new Thread() {
		    public void run() {
		    	System.out.println(Thread.currentThread().getName() +" ::: "+Thread.currentThread().getPriority());
		        getBin(cardNumber);
		    }

			private void getBin(String cardNumber) {
				if(cardNumber.substring(0, 2).equals("34") || cardNumber.substring(0, 2).equals("37")){
					cardInfo.setIssurer(Issuer.AMEX.toString());
				}else if(cardNumber.charAt(0)=='4'){
					cardInfo.setIssurer(Issuer.VISA.toString());
				}else if(cardNumber.substring(0, 2).equals("51") || cardNumber.substring(0, 2).equals("55")){
					cardInfo.setIssurer(Issuer.MASTERCARD.toString());
				}else if(cardNumber.substring(0, 4).equals("6011") || cardNumber.substring(0, 3).equals("644") || cardNumber.substring(0, 2).equals("65")){
					cardInfo.setIssurer(Issuer.DISCOVER.toString());
				}
				
			}
		};
		Thread checkDigit = new Thread() {
		    public void run() {
		    	 System.out.println(Thread.currentThread().getName() +" ::: "+Thread.currentThread().getPriority());
		    	 cardInfo.setCardStatus(getLuhn(cardNumber));
		    }
		};
		
		Thread write2Csv = new Thread() {
		    public void run() {
		    	 System.out.println(Thread.currentThread().getName() +" ::: "+Thread.currentThread().getPriority());
		    	 write2Csv(cardInfo);
		    }

			private void write2Csv(CardInfo cardInfo) {
				try{
					System.out.println("cardInfo is :::: " + cardInfo);
				    CsvWriter csvOutput = new CsvWriter(new FileWriter(new File(csvFile), true), ',');
			        
			        csvOutput.write(cardInfo.getCardNumber());
					csvOutput.write(cardInfo.getIndustry());
					csvOutput.write(cardInfo.getIssurer());
					csvOutput.write(cardInfo.getAccountNumber());
					csvOutput.write(cardInfo.getCardStatus());
					csvOutput.endRecord();
					csvOutput.close();
					
				}catch(Exception ex){
					
				}
			
			}
		};
		
		mii.setName("MII THread");mii.setPriority(1);mii.start();
		bin.setName("BIN Thread");bin.setPriority(2);bin.start();
		checkDigit.setName("CHECK DIGIT THREAD");checkDigit.setPriority(3);checkDigit.start();
		write2Csv.setName("WRITE TO CSV");write2Csv.setPriority(4);write2Csv.start();
	}

	
	public static boolean cardCheckInFile(String card){
		return cardNumbersList.contains(card);
	}
	
	public static String getAccountNumber(String cardNumber){
		return cardNumber.substring(6, cardNumber.length()-1);
	}
	
	
	public static String getLuhn(String ccNumber)
    {
            int sum = 0;
            boolean alternate = false;
            for (int i = ccNumber.length() - 1; i >= 0; i--)
            {
                    int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                    if (alternate)
                    {
                            n *= 2;
                            if (n > 9)
                            {
                                    n = (n % 10) + 1;
                            }
                    }
                    sum += n;
                    alternate = !alternate;
            }
            return (sum % 10 == 0)?"Valid":"InValid";
    }
	
	private class CardInfo{
		private String cardNumber;
		private String industry;
		private String issurer;
		private String accountNumber;
		private String cardStatus;
		
		
		public String getCardNumber() {
			return cardNumber;
		}
		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public String getIssurer() {
			return issurer;
		}
		public void setIssurer(String issurer) {
			this.issurer = issurer;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getCardStatus() {
			return cardStatus;
		}
		public void setCardStatus(String cardStatus) {
			this.cardStatus = cardStatus;
		}
		
		public String toString(){
			return getCardNumber() +","+getIndustry()+","+getIssurer()+","+getAccountNumber()+","+getCardStatus();
		}
		
		
	}
}