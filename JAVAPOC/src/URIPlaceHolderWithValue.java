import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;


public class URIPlaceHolderWithValue {

	public static void main(String[] args) {
		
		
		Map<String,Object> map = new HashMap<>();
		map.put("REASON", "INCIDENT_OPEN");
		map.put("SUBREASON", "PAYMENT_ERR");
		map.put("BANK", "AXIS");
		
		String val = "{\"first\": 123}";
		String val1= "{\"REASON\":\"INCIDENT_OPEN\"}";
		
		String url = "https://hpenterprise-dev.mirakl.net/api/reasons/:REASON/:SUBREASON/:BANK";
		
		if(!url.contains("?")){
			for(String key : map.keySet()){
				String value = (String)map.get(key);
				url = url.replaceAll(":"+key, value);
			}
		}
		
		System.out.println(url);
		

	}

}
