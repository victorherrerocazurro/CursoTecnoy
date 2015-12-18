package com.ejemplo;

public class Lanzador {

	public static void main(String[] args) {
		/*Dios zeus = new Dios();
		Dios jupiter = new Dios();
		Dios saturno = new Dios();*/
		
		Dios dios = Dios.dameElUnicoDiosQueExiste();
		Dios dios2 = Dios.dameElUnicoDiosQueExiste();
		
		if(dios == dios2){
			System.out.println("Dios es unico!!!");
		}

	}

}
