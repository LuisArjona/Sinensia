package ej1;

public class Ej1 {
	
	public static void local() {
		int localVar=20;
		System.out.println("LocalVar: "+localVar);
	}

	public static void main(String[] args) {
		int globalVar=10;
		System.out.println("GlobalVar: "+globalVar);
		local();
		
		if(true) {
			int blockVar=30;
			System.out.println("BlockVar: "+blockVar);
		}

	}

}
