import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class URLTest {
	
	public static final String PARAMETER_SUBSTITUTION_IDENTIFIER_START = "\\{\\{";
	
	public static final String PARAMETER_SUBSTITUTION_IDENTIFIER_END = "\\}\\}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String substituteParameters(String inputText, Map<String, Object> parameters) {

		String outputText = inputText;

		if (inputText != null && parameters != null) {

			for (String key : parameters.keySet()) {

				Object parameterValueObject = parameters.get(key);

				if (parameterValueObject != null) {

					StringBuilder parameterValue = new StringBuilder();

					if (parameterValueObject instanceof List && ((List) parameterValueObject).size() > 0) {

						for (Object obj : (List) parameterValueObject) {
							parameterValue = parameterValue.append(obj);
							parameterValue.append(",");
						}

						parameterValueObject = parameterValue.substring(0, parameterValue.length() - 1);

					}

					outputText = outputText.replaceAll(
							PARAMETER_SUBSTITUTION_IDENTIFIER_START + key
									+ PARAMETER_SUBSTITUTION_IDENTIFIER_END,
							parameterValueObject.toString());

				}

			}
		}

		return outputText;
	}

	
	
}
