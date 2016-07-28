package helpers;

import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

// Artist �r en klass som hj�lper att ha allt det jobbiga i en fil s� vi bara kan kalla allting
//till Boot.java.

public class Artist {
	
	//V�r resolution f�r spelet och l�gger det i en int (integer) f�r att g�ra det enklare att kalla till det.
	public static final int WIDTH = 1280, HEIGHT = 960;
	
	public static void BeginSession() {
		
		//Vi ger namnet till v�r spel "ULTIMATE GAME X2000" detta st�r vid titeln l�ngst upp till v�nster p� f�nstret.
		Display.setTitle("Ultimate Game X2000");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		//H�r kallar vi efter en massa grejer till v�r kod som kommer antingen fr�n LWJGL (Lightweight Java Game Libary) eller slick-util.jar som jag inte riktigt
		//vet vart allt kommer ifr�n.
		//Mer info https://www.lwjgl.org/
		//Jag anv�nder version 2.9.7. (Tror jag).
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	// Program som s�tter ut vita blocks.
	public static void DrawQuad(float x, float y, float width, float height) {
		
		glBegin(GL_QUADS);
		glVertex2f(x, y);                        //Top left Corner
		glVertex2f(x + width, y);                //Top Right Corner
		glVertex2f(x + width, y + height);       //Bottom Right Corner
		glVertex2f(x, y + height);               //Bottom Left Corner
		glEnd();
		
	}
	// Programmet som s�ger vart alla texturer ska s�ttas.
	public static void DrawQuad(Texture tex, float x, float y, float width, float height){
		tex.bind();
		glTranslatef(x, y, 0);
		glBegin(GL_QUADS);
		glTexCoord2f(0, 0);
		glVertex2f(0, 0);
		glTexCoord2f(1, 0);
		glVertex2f(width, 0);
		glTexCoord2f(1, 1);
		glVertex2f(width, height);
		glTexCoord2f(0, 1);
		glVertex2f(0, height);
		glLoadIdentity();
		glEnd();
		
	}
	//Programmet som laddar texturerna till sk�rmen.
	public static Texture LoadTexture(String path, String fileType) {
		Texture tex = null;
		InputStream in = ResourceLoader.getResourceAsStream(path);
		//				try {
		tex = TextureLoader.getTexture(fileType, in);
		//				} catch (IOException e) {
		//				e.printStackTrACE();
		//				}
		// Det beh�vs nog ingen try loop h�r men l�gger den i kommentar ifall att. 
		return tex;
		
	}
	
	
}











