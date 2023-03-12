package view;

import java.util.concurrent.Semaphore;

import Controller.Caminhada;

public class CaminhdaPrincipal {

	public static void main(String[] args) {
	Semaphore se = new Semaphore (1);
	for (int cam =1; cam <= 4; cam ++) {
		Thread c = new Caminhada( cam,se);
		c.start();
	}

	}

}
