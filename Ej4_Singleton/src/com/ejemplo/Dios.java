package com.ejemplo;

public class Dios {

	private static Dios unicoDios = new Dios();
	
	private Dios() {
		super();
	}
	
	public static Dios dameElUnicoDiosQueExiste(){
		return unicoDios;
	}
	
}
