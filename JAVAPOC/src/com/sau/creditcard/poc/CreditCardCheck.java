package com.sau.creditcard.poc;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.csvreader.CsvWriter;

public class CreditCardCheck {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private JLabel msglabel;
	private JTextField textField;
	private int trailCount = 0;

	static List<String> cardNumbersList = null;
	static int inputTrailCount = 1;
	static String csvFile = "cardInfo.csv";
	static Map<String, List<String>> cardMap = new HashMap<>();
	static List<String> cardInfoList = null;
	static {
		String line = "";
		String cvsSplitBy = ",";
		cardNumbersList = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(
				csvFile)))) {
			cardNumbersList.clear();
			while ((line = br.readLine()) != null) {
				String[] cardInfo = line.split(cvsSplitBy);
				cardNumbersList.add(cardInfo[0].replaceAll("\"", ""));
				cardInfoList = new ArrayList<>();
				for (int i = 0; i < cardInfo.length; i++) {
					System.out.print(cardInfo[i]);
					cardInfoList.add(cardInfo[i]);
				}
				System.out.println();
				cardMap.put(cardInfo[0].replaceAll("\"", ""), cardInfoList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CreditCardCheck() {
		prepareGUI();
	}

	public static void main(String[] args) {
		CreditCardCheck swingContainerDemo = new CreditCardCheck();
		swingContainerDemo.showJFrameDemo();
	}

	public static String getAccountNumber(String cardNumber) {
		return cardNumber.substring(6, cardNumber.length() - 1);
	}

	public static String getLuhn(String ccNumber) {
		int sum = 0;
		boolean alternate = false;
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0) ? "Valid" : "InValid";
	}

	/**
	 * 
	 * @param ccNumber
	 *            Storing below information Card id, industry information,issuer
	 *            information, user account,card status
	 * 
	 */
	private static void writeCard2Csv(String ccNumber) {
		final String cardNumber = ccNumber;

		CreditCardCheck creditCardCheck = new CreditCardCheck();
		final CreditCardCheck.CardInfo cardInfo = creditCardCheck.new CardInfo();
		cardInfo.setCardNumber(ccNumber);
		cardInfo.setAccountNumber(getAccountNumber(ccNumber));

		Thread mii = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " ::: "
						+ Thread.currentThread().getPriority());
				getMii(cardNumber);
			}

			private void getMii(String cardNumber) {
				switch (cardNumber.charAt(0)) {
				case '1':
					cardInfo.setIndustry(Industry.AIRLINES.toString());
					break;
				case '2':
					cardInfo.setIndustry(Industry.AIRLINES.toString());
					break;
				case '3':
					cardInfo.setIndustry(Industry.TRAVEL.toString());
					break;
				case '4':
					cardInfo.setIndustry(Industry.BANKINGANDFINANCE.toString());
					break;
				case '5':
					cardInfo.setIndustry(Industry.BANKINGANDFINANCE.toString());
					break;
				case '6':
					cardInfo.setIndustry(Industry.MERCHANDISINGBANKINGANDFINANCE
							.toString());
					break;
				case '7':
					cardInfo.setIndustry(Industry.PETROLIUM.toString());
					break;
				case '8':
					cardInfo.setIndustry(Industry.HELTHCARETELCOMM.toString());
					break;
				case '9':
					cardInfo.setIndustry(Industry.NATIONALASSIGNMENT.toString());
					break;
				default:
					System.out.println("Not in List of industries !!!");
				}
			}
		};
		Thread bin = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " ::: "
						+ Thread.currentThread().getPriority());
				getBin(cardNumber);
			}

			private void getBin(String cardNumber) {
				// var cardNumber = "34567899999999"
				if (cardNumber.substring(0, 2).equals("34")
						|| cardNumber.substring(0, 2).equals("37")) {
					cardInfo.setIssurer(Issuer.AMEX.toString());
				} else if (cardNumber.charAt(0) == '4') {
					cardInfo.setIssurer(Issuer.VISA.toString());
				} else if (cardNumber.substring(0, 2).equals("51")
						|| cardNumber.substring(0, 2).equals("55")) {
					cardInfo.setIssurer(Issuer.MASTERCARD.toString());
				} else if (cardNumber.substring(0, 4).equals("6011")
						|| cardNumber.substring(0, 3).equals("644")
						|| cardNumber.substring(0, 2).equals("65")) {
					cardInfo.setIssurer(Issuer.DISCOVER.toString());
				} else {
					cardInfo.setIssurer("NOT LISTED INDUSTRY");
				}

			}
		};
		Thread checkDigit = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " ::: "
						+ Thread.currentThread().getPriority());
				cardInfo.setCardStatus(getLuhn(cardNumber));
			}
		};

		Thread write2Csv = new Thread() {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " ::: "
						+ Thread.currentThread().getPriority());
				write2Csv(cardInfo);
			}

			private void write2Csv(CardInfo cardInfo) {
				try {
					System.out.println("cardInfo is :::: " + cardInfo);
					CsvWriter csvOutput = new CsvWriter(new FileWriter(
							new File(csvFile), true), ',');

					csvOutput.write(cardInfo.getCardNumber());
					csvOutput.write(cardInfo.getIndustry());
					csvOutput.write(cardInfo.getIssurer());
					csvOutput.write(cardInfo.getAccountNumber());
					csvOutput.write(cardInfo.getCardStatus());
					csvOutput.endRecord();
					csvOutput.close();

				} catch (Exception ex) {

				}

			}
		};

		mii.setName("MII THread");
		mii.setPriority(1);
		mii.start();
		bin.setName("BIN Thread");
		bin.setPriority(2);
		bin.start();
		checkDigit.setName("CHECK DIGIT THREAD");
		checkDigit.setPriority(3);
		checkDigit.start();
		write2Csv.setName("WRITE TO CSV");
		write2Csv.setPriority(4);
		write2Csv.start();
	}
/**
 * 
 * @param card
 * @return
 */
	public static boolean cardCheckInFile(String card) {
		System.out.println(cardNumbersList);
		return cardNumbersList.contains(card);
	}
/**
 * 
 * @param ccNumber
 * @return
 */
	private static boolean validateCardNumber(String ccNumber) {
		String pattern = "[0-9]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(ccNumber);
		return m.matches() && ccNumber.length() >= 13
				&& ccNumber.length() <= 16;
	}
/**
 * 
 */
	private void prepareGUI() {
		mainFrame = new JFrame("CREDIT CARD CHECK");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);

		statusLabel.setSize(350, 100);

		msglabel = new JLabel("Welcome to CREDIT CARD CHECK ", JLabel.CENTER);
		textField = new JTextField("", JTextField.CENTER);
		textField.setSize(150, 100);
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.add(textField);
		// mainFrame.setS
		mainFrame.setVisible(true);

	}

	private void showJFrameDemo() {
		headerLabel.setText("PLEASE ENTER CARD NUMBER");

		final JFrame frame = new JFrame();
		frame.setSize(400, 100);
		frame.setLayout(new FlowLayout());
		frame.add(msglabel);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				frame.dispose();
			}
		});
		JButton okButton = new JButton("SUBMIT");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber = textField.getText();
				if (validateCardNumber(cardNumber)) {
					int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(null,
							"CARD IS USERD ALREADY ?",
							"FOR FAST CARD RETRIEVAL", dialogButton);

					if (dialogResult == JOptionPane.YES_OPTION) {
						JOptionPane.showInputDialog("CARD HOLDER INFO ::: "
								+ cardMap.get(cardNumber));
					} else {
						noOptionSelected(cardNumber);
					}
				} else {
					trailCount++;
					System.out.println("trailCount ::: " + trailCount);
					if (trailCount == 3) {
						JOptionPane.showMessageDialog(null, trailCount
								+ "::: invalid input ::: " + cardNumber);
						JOptionPane.showMessageDialog(null,
								"Please try after 30 seconds  !!!!!!");
						trailCount = 0;
						showWaitDailog();
					} else {
						JOptionPane.showMessageDialog(null, trailCount
								+ "::: invalid input ::: " + cardNumber);
					}
				}

			}

			
/**
 * 
 * @param cardNumber
 */
			private void noOptionSelected(String cardNumber) {
				boolean cardExist = cardCheckInFile(cardNumber);
				if (cardExist) {
					System.out.println("Card Exist !!!");
					JOptionPane.showInputDialog("CARD ALREADY EXIST ::: "
							+ cardMap.get(cardNumber));
				} else {
					if (!validateCardNumber(cardNumber)) {
						trailCount++;
						System.out.println("trailCount ::: " + trailCount);
						if (trailCount == 3) {
							JOptionPane.showMessageDialog(null, trailCount
									+ "::: invalid input ::: " + cardNumber);
							JOptionPane.showMessageDialog(null,
									"Please try after 30 seconds  !!!!!!");
							trailCount = 0;
							showWaitDailog();
						} else {
							JOptionPane.showMessageDialog(null, trailCount
									+ "::: invalid input ::: " + cardNumber);
						}
					} else {
						writeCard2Csv(cardNumber);
					}
				}
			}
/**
 * 
 */
			private void showWaitDailog() {
				frame.setVisible(true);
				TimerTask timerTask = new TimerTask() {
					int second = 30;

					@Override
					public void run() {
						print30Seconds();
					}

					private void print30Seconds() {
						frame.setTitle("Application will close in " + second--
								+ " seconds.");
					}

				};
				Timer timer = new Timer(true);
				timer.scheduleAtFixedRate(timerTask, 0, 1 * 1000);
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				timer.cancel();
				frame.dispose();

			}
		});
		controlPanel.add(okButton);
		mainFrame.setVisible(true);
	}
/**
 * 
 * @author veigandl
 *
 */
	private class CardInfo {
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

		public String toString() {
			return getCardNumber() + "," + getIndustry() + "," + getIssurer()
					+ "," + getAccountNumber() + "," + getCardStatus();
		}

	}
/**
 * 
 * @author veigandl
 *
 */
	public enum Industry {
		AIRLINES("Airlines"), TRAVEL("Travle"), BANKINGANDFINANCE(
				"Banking and Financial"), MERCHANDISINGBANKINGANDFINANCE(
				"Merchandising and Banking/Financial"), PETROLIUM("Petroleum"), HELTHCARETELCOMM(
				"Healthcare, Telecommunications"), NATIONALASSIGNMENT(
				"National Assignment");
		private final String industry;

		private Industry(final String industry) {
			this.industry = industry;
		}

		@Override
		public String toString() {
			return industry;
		}
	}
/**
 * 
 * @author veigandl
 *
 */
	public enum Issuer {
		AMEX("Amex"), MASTERCARD("MasterCard"), VISA("Visa"), DISCOVER(
				"Discover");
		private final String issuer;

		private Issuer(final String issuer) {
			this.issuer = issuer;
		}

		@Override
		public String toString() {
			return issuer;
		}
	}
}
