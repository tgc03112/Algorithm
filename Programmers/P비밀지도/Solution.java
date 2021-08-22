package P비밀지도;

/*
	문자열을 charAt으로 쪼개어 바꾸는 문제 
	해설을 보니 비트마스킹 문제라고 하는데 비트마스킹이 기억안나도 충분히 직관적으로 풀 수 있다
	
	Integer.toBinaryString : 10진수를 2진수로 바꿔줌
	
	String 문자열 변환하는 메소드 or math 알아두기, import 알아두기  
*/

public class Solution {
	public static void main(String[] args) {
		int[] test1 = {9, 20, 28, 18, 11};
		int[] test2 = {30, 1, 21, 17, 28};
		String[] res = solution(5,test1,test2);
		
		System.out.println(res.toString());
	}
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		String[][] map1 = new String[n][n]; 
		String[][] map2 = new String[n][n]; 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map1[i][j] = "0";
				map2[i][j] = "0";
			}
		}
		
		for(int i=0;i<n;i++) {
			String convert1 = Integer.toBinaryString(arr1[i]);
			int k=0;
			for(int j=n-convert1.length();j<n;j++) {
				map1[i][j] = Character.toString(convert1.charAt(k++));
			}
		}
		
		for(int i=0;i<n;i++) {
			String convert2 = Integer.toBinaryString(arr2[i]);
			int k=0;
			for(int j=n-convert2.length();j<n;j++) {
				map2[i][j] = Character.toString(convert2.charAt(k++));
			}
		}
		
		for(int i=0;i<n;i++) {
			String str = "";
			for(int j=0;j<n;j++) {
				if(map1[i][j].equals("1") || map2[i][j].equals("1")) {
					str+="#";
				}
				else{
					str+=" ";
				}
			}
			answer[i] = str;
		}
        return answer;
    }
}
