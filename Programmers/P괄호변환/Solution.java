package P괄호변환;

/*
stack을 사용해서 설명된 알고리즘 조건대로 문제를 풀면 됩니다.
'('일 경우 무조건 stack에 넣어줍니다.
')'인 경우에 짝이 맞으면 앞에 있는 '('를 꺼내줍니다. 
만약 stack에 아무것도 없는 경우 균형잡힌괄호 문자열이 아니기 떄문에 false를 반환해서 처리합니다.

if(left == right) {
	pos = i+1;
	return res;
}

여기에서 left와 right의 짝이 맞아지는 순간이 처음으로 문자열을 나눌 수 있는 위치입니다.
그 다음부터는 문자열을 나눈 뒤 알고리즘 설명대로 진행하면 됩니다.
*/

import java.util.Stack;

public class Solution {
	static int pos;
	public static void main(String[] args) {
		String res = solution("()))((()");
		
		System.out.println(res);
	}
	public static String solution(String p) {
        String answer = "";
        
        if(p.equals("")) {	//빈 문자열 반환
        	return answer;
        }
        boolean bool = check(p);
        		
        String u = p.substring(0,pos);
        String v = p.substring(pos,p.length());
        
        if(bool) {
        	return u + solution(v);
        }
        answer = "(" + solution(v) + ")";
        
        for(int i=1;i<u.length()-1;i++) {
        	if(u.charAt(i) == '(') {
        		answer += ")";
        	}
        	else {
        		answer += "(";
        	}
        }
        return answer;
    }
	
	//균형 잡힌 괄호 문자열인지 확인
	public static boolean check(String str) {
		boolean res = true;
		int left = 0;
		int right = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == '(') {
				left++;
				stack.push(str.charAt(i));
			}
			else {	//')'인 경우
				right++;
				if(stack.size()==0) {	//균형잡힌괄호 문자열이 아님
					res = false;
				}
				else {	//괄호 짝이 맞는 경우
					stack.pop();
				}
			}
			if(left == right) {
				pos = i+1;
				return res;
			}
		}
		return true;
	}
}
