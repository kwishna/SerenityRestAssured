package Rough;

import java.util.Base64;

public class JiraBugStatus {

	public static void main(String[] args) {

		Base64.Encoder en = Base64.getEncoder();
		String s = en.encodeToString("krishna.singh16@wipro.com:396575".getBytes());
		System.out.println(s);
	}
}
