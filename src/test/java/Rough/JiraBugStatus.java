package Rough;

import java.util.Base64;

public class JiraBugStatus {

	public static void main(String[] args) {

		Base64.Encoder en = Base64.getEncoder();
		String s = en.encodeToString("krishn".getBytes());
		System.out.println(s);
	}
}
