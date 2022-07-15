package lecture0715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboardInput {
	public static void main(String[] args) {
		System.out.println("키보드로 한줄을 입력하세요!");
		
		// 키보드(표준입력 - System.in)를 통해 데이터를 1줄 입력받을거에요
		// 이 System.in 이라는 제공된 Stream은 사용하기 너무 힘듦
		
		// 문자열 기반으로 입력을 받음
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br =  new BufferedReader(isr);
		
		try {
			String input = br.readLine();
			System.out.println("입력받은 문자열은 : " + input);
		} catch (IOException e) {
		}
	}
}
