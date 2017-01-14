package jpl.ch10.ex01;

public class SpecialChar {
	
	public static String returnSpecialChar(String message){
		String smessage ="a";
		
		for(int i = 0; i < message.length(); i++){
			if(message.charAt(i) == '\"'){
				smessage.concat("\\\"");
			}else if(message.charAt(i) == '\''){
				smessage.concat("\\\'");
			}else
				smessage.concat(message.substring(i, i + 1));
			
		}
		
		
		
		return smessage;
		
		
		
	}
	
	

	public static void main(String[] args) {
		System.out.println(returnSpecialChar("ab\"c"));

	}

}
