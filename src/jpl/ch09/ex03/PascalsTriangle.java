package jpl.ch09.ex03;

public class PascalsTriangle {

	int triangle[][] = new int[12][12];
	
	
	

	public void showpascal() {

		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j <= i; j++) {
				if(j ==0 || j - i == 0){
					triangle[i][j] = 1;
				}
				else{
					triangle[i][j] =triangle[i - 1][j - 1] + triangle[i - 1][j];
				}

			}

		}
		
		for(int i = 0; i <triangle.length; i++){
			for(int j = 0; j <= i;j++){
				System.out.print(triangle[i][j] + " ");
			}
			System.out.println();
		}

	}
}