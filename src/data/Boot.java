package data;

import static helpers.Artist.*;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;


public class Boot {
	
	public Boot() {
		//Starta programmet, BeginSession(); kommer från Artist.java (Mer info där).
		BeginSession();
		
		//While loop så allting kan gå om och om igen, tills vi säger STOPP!
		while(!Display.isCloseRequested()) {
			
			//Två kuber som visas på skärmen "DrawQuad" kommer ifrån Artist.java.
			DrawQuad(50, 50, 100, 100);
			DrawQuad(100, 100, 150, 150);
			
			//För att vara helt ärlig vet jag inte vad detta betyder men att skärmen ska uppdatera varje gång 60 gånger i sekunden.
			//Det är typ som att säga att Display.sync(60); betyder 60FPS.
			Display.update();
			Display.sync(60);
			
		}
		//Skärmen försvinner när vi ber den att stängas.
		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();
	}
}
