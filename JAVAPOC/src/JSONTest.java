import org.json.simple.JSONObject;

public class JSONTest{
	public static void main(String[] args){
		
		JSONGenerator payload = new JSONGenerator();
		payload.beginDoc("payload_parameters");
		
		JSONObject j = new JSONObject();
	
		payload.addPair("LOG_SYSTEM", "testtt");
	       payload.addPair("EXP_PART_NUM", "CN100");
	       payload.addPair("EMB_COMP", "");
	       payload.addPair("EMB_ADDR", "");
	       payload.addPair("EMB_IPAD", "X");
	      
	       payload.addPair("EMB_EMAL", "");
	       payload.addPair("RPL_SCRN", "");
	       payload.addPair("STATUS_GET", "");
	       
	       payload.addPair("NAME", "Kevin Nuclear");
	       payload.addPair("STREET", "Tandem Blvd");
	       payload.addPair("HOUSE_NUM", "14231");
	       payload.addPair("CITY", "Austin");
	       payload.addPair("REGION", "Travis");
	      
	       payload.addPair("PCODE", "78751");
	       payload.addPair("COUNTRY", "US");
	       payload.addPair("EMAIL","kevin.james@yahoo.us");
	       
	       
	       payload.addPair("IP_ADDR", "141.158.70.23");
	       payload.addPair("LANGUISO", "EN");
	       payload.addPair("SEARCHTERM1", "");
	       
	       payload.endDoc();
	       
	       System.out.println(payload.toJSON());
	       
		
		
	}
}

class JSONGenerator {
 
	private StringBuffer buf = new StringBuffer();
	public static final String CURL_BEGIN = "{";
	public static final String CURL_END = "}";
	public static final String SQUARE_BEGIN = "[";
	public static final String SQUARE_END = "]";
	public static final String COLON = ":";
	public static final String COMMA = ",";
	public static final String QUOTES = "\"";
	public static final String NEW_LINE = "";
	private int pairCount = 0;
 
	/**
	 * Begin the JSON Doc
	 * 
	 * @param value
	 */
	public void beginDoc(String value) {
		buf.append(CURL_BEGIN).append(QUOTES).append(value).append(QUOTES);
	}
 
	
	
	/**
	 * Add Object Attribute
	 * @param key
	 * @param value
	 */
	public void addPair(String key, String value) {
		if (pairCount > 0) {
			buf.append(COMMA);
		} else {
			buf.append(COLON).append(CURL_BEGIN);
		}
		buf.append(QUOTES).append(key).append(QUOTES).append(COLON).append(
				QUOTES).append(value).append(QUOTES);
		pairCount++;
 
	}
 
	/**
	 * Add array to the JSON doc
	 * 
	 * @param name
	 * @param values
	 */
	public void addArray(String name, String values[]) {
		StringBuffer ar = new StringBuffer();
		for (int i = 0; i < values.length; i++) {
			// append comma
			if (i > 0) {
				ar.append(COMMA);
			}
			ar.append(QUOTES).append(values[i]).append(QUOTES);
		}
 
		if (pairCount > 0) {
			buf.append(COMMA).append(NEW_LINE);
		} else {
			buf.append(COLON).append(CURL_BEGIN).append(NEW_LINE);
		}
 
		// add it as pair
		buf.append(QUOTES).append(name).append(QUOTES).append(COLON);
		buf.append(SQUARE_BEGIN);
		buf.append(ar.toString());
		buf.append(SQUARE_END);
	}
 
	/**
	 * End JSON doc
	 */
	public void endDoc() {
		buf.append(NEW_LINE);
		if (pairCount > 0) {
			buf.append(CURL_END);
		}
		buf.append(CURL_END);
	}
 
	public String toJSON() {
		return buf.toString();
	}
}