package P가짜영수증찾기;

public class Solution {
	public static void main(String[] args) {
		boolean res = solution("");
		System.out.println("결과 : "+res);
	}
	public static boolean solution(String amountText) {
        boolean answer = true;
        //문자열 길이
        int leng = amountText.length();
        
        //1번
        for(int i=0;i<leng;i++) {
        	char a = amountText.charAt(i);
        	if(a=='0'||a=='1'||a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9'||a==',') {
        	}
        	else {
        		answer = false;
        		break;
        	}
        }
        
        //2번
        if(!amountText.equals("0")) {
        	char a = amountText.charAt(0);        	
        	if(a =='0' || a == ',') {
        		answer = false;
        	}
	    }
        
        //4번
        if(amountText.charAt(0) == ',' || amountText.charAt(leng-1) == ',') {
        	answer = false;
        }
        
        
        //3번, 4자리 이상인 경우
        amountText = amountText.concat("0");
        StringBuffer sb = new StringBuffer(amountText); 
        String reversedStr = sb.reverse().toString();
        
        
        if(leng>=4) {
        	for(int i=0;i<leng;i++) {
        		char a = reversedStr.charAt(i);
        		//,가 있어야될 자리가 아닌데 ,가 있는 경우
        		if((i%4)!=0) {
        			if(a==',') {
        				answer = false;
        			}
        		}
        	}
        }
        
        return answer;
    }
}
