package week1.unit3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Example07HandleValue {
	public static void main(String[] args) {
		// Slides 2-3: Conceptual Handle -> byte[] mapping (NOT an HLA API).
		// Here Strings stand in for real RTI Handle objects.
		Map<String, byte[]> attributes = new HashMap<>();
		attributes.put("LocationHandle", "Bangkok".getBytes(StandardCharsets.UTF_8));
		attributes.put("StatusHandle", "READY".getBytes(StandardCharsets.UTF_8));
		for (Map.Entry<String, byte[]> entry : attributes.entrySet()) {
			String value = new String(entry.getValue(), StandardCharsets.UTF_8);
			System.out.println(entry.getKey() + " -> " + value + " (bytes=" + Arrays.toString(entry.getValue()) + ")");
		}
		// In actual HLA, use AttributeHandleValueMap / ParameterHandleValueMap
		// and the encoder required by each attribute's FOM data type.
	}
}
