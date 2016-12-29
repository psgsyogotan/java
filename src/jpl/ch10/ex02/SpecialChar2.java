package jpl.ch10.ex02;

public class SpecialChar2 {
	
	public SpecialChar2(){
		
	}
	
	public String returnstring(String message){
		String remessage = "";
		
		for(int i = 0; i < message.length();i++){
			switch(message.charAt(i)){
			case '\"':
				remessage = remessage +"\\\"";	
				break;
			case '\'':
				remessage = remessage +"\\\'";
				break;
				
			default:
				remessage = remessage +message.charAt(i);
				break;
			}	
		}
		
		
		return remessage;
		
	}

}
