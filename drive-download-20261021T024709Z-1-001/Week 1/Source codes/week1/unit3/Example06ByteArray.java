package week1.unit3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Example06ByteArray {
	public static void main(String[] args) {
		// Slide 8: Encoded bytes received by HLA-like callbacks.
		byte[] tag = { 72, 76, 65 };
		String text = new String(tag, StandardCharsets.UTF_8);
		System.out.println("Raw bytes: " + Arrays.toString(tag));
		System.out.println("Decoded text: " + text); // HLA

		String message = "PK001";
		byte[] encoded = message.getBytes(StandardCharsets.UTF_8);
		System.out.println("Encoded PK001: " + Arrays.toString(encoded));
		System.out.println("Decoded again: " + new String(encoded, StandardCharsets.UTF_8));
		// Real HLA types require their specified HLA encoders/decoders.
	}
}
