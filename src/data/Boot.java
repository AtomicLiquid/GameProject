package data;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;


public class Boot {
	
	public Boot() {
		//Starta programmet, BeginSession(); kommer fr�n Artist.java (Mer info d�r).
		BeginSession();
		
		//While loop s� allting kan g� om och om igen, tills vi s�ger STOPP!
		while(!Display.isCloseRequested()) {
			
			//Tv� kuber som visas p� sk�rmen "DrawQuad" kommer ifr�n Artist.java.
			DrawQuad(50, 50, 100, 100);
			DrawQuad(100, 100, 150, 150);
			
			//F�r att vara helt �rlig vet jag inte vad detta betyder men att sk�rmen ska uppdatera varje g�ng 60 g�nger i sekunden.
			//Det �r typ som att s�ga att Display.sync(60); betyder 60FPS.
			Display.update();
			Display.sync(60);
			
		}
		//Sk�rmen f�rsvinner n�r vi ber den att st�ngas.
		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();
	}
}
