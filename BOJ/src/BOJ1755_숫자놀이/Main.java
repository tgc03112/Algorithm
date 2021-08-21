package BOJ1755_숫자놀이;

import java.util.Arrays;
import java.util.Scanner;

public class Main {	//1. 숫자 놀이

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//String 으로 입력으로 받아옵니다. 12와 같은 두자리수 숫자로 들어올 경우 문자열을 쪼개서 onetwo처럼 저장해주기 위함입니다.
		String strM = sc.next();
		String strN = sc.next();
		
		//배열의 크기를 정해주기 위해서 숫자로 변환시킵니다. 숫자와 문자를 함께 저장해 문자로 정렬하고 출력을 숫자만 해줄예정입니다.
		int M = Integer.parseInt(strM);
		int N = Integer.parseInt(strN);
		
		//숫자와 숫자를 문자열로 바꾼 값을 동시에 저장하기 위한 배열을 만듭니다. Data라는 class안에 숫자와 문자열을 동시에 저장할 수 있습니다.
		Data[] arr = new Data[N-M+1];	
		int idx = 0;
		
		//입력으로 들어온 M~N까지의 숫자를 문자열로 바꾸는 과정을 반복합니다.
		for(int i=M;i<=N;i++) {
			
			String k = Integer.toString(i);	//숫자 i를 문자로 바꿔 줍니다.
			
//			System.out.println(k);	//출력확인용
				
			String str = "";	//str을 초기화 해줍니다.
			
			for(int j=0;j<k.length();j++) {	//자리수 만큼 반복해서 문자열에 21이라면 twoone 이런식으로 저장해줍니다.
				if(k.charAt(j)=='1') {
					str=str+"one";
				}
				else if(k.charAt(j)=='2') {
					str=str+"two";
				}
				else if(k.charAt(j)=='3') {
					str=str+"three";
				}
				else if(k.charAt(j)=='4') {
					str=str+"four";
				}
				else if(k.charAt(j)=='5') {
					str=str+"five";
				}
				else if(k.charAt(j)=='6') {
					str=str+"six";
				}
				else if(k.charAt(j)=='7') {
					str=str+"seven";
				}
				else if(k.charAt(j)=='8') {
					str=str+"eight";
				}
				else if(k.charAt(j)=='9') {
					str=str+"nine";
				}
				else if(k.charAt(j)=='0') {
					str=str+"zero";
				}
			}
			
			arr[idx] = new Data(i, str);	//문자열과 숫자를 arr에 저장합니다.
//			System.out.println(str);	//출력확인용
			idx++;	//arr의idx를 증가시킵니다.
		}
		Arrays.sort(arr);	//arr를 정렬합니다. arr에서 str사전순으로 정렬됩니다.
		int t = 0;
		for(int i=0;i<arr.length;i++) {	//정렬은 str로 하고 출력은 arr배열의 숫자만 출력해줍니다.
			if(t==10) {
				System.out.println();
				t=0;
			}
			t++;
			System.out.print(arr[i].num+" ");
		}
	}
}

//숫자와 문자열로 바꾼 데이터를 동시에 저장하기 위함입니다.
class Data implements Comparable<Object>{
	int num;
	String str;
	
	public Data(int num, String str) {
		this.num = num;
		this.str = str;
	}

//	데이터의 정렬은 str을 사전순으로  정렬합니다.
	@Override
	public int compareTo(Object o) {
		return str.compareTo(((Data)o).str);
	}
}
