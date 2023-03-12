package Controller;

import java.util.concurrent.Semaphore;

public class Caminhada extends Thread {
	private int ca;
	private Semaphore se;
	
	public Caminhada(int ca, Semaphore se) {
		this.ca = ca;
		this.se = se;
	}
	public void run() {
		caminha();
		try {
			se.acquire();
			porta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			se.release();
			proximo();
		}
		
	}

	private void caminha() {
		int disF = (int)((Math.random()*201)+ 0);
		int desl = (int)((Math.random()*2.1)+ 4 );
		int tempo = 1000;
		int disI = 0;
			while (disI< disF) {
				disI +=desl ;
				System.out.println("Pessoa " + ca + " percorreu " + disI + " m" );
				try {
					sleep(tempo);
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
			System.out.println("pessoa " + ca + "Chegou na porta ");
				}
				
	private void porta() {
		System.out.println("Pessoa "+ ca + "  Abrindo a porta");
		int pt = (int)((Math.random()*1001)+ 1000);
		try {
			sleep(pt);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	private void proximo() {
		System.out.println(" Pessoa "+ ca + " indo para o próximo Corredor");
	
	}
}
