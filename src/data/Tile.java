package data;

import org.newdawn.slick.opengl.Texture;
//Tile.java �r till f�r att skapa alla texturer till alla tiles p� spelet.
public class Tile {
	
	private float x, y, width, height;
	private Texture texture;
	
	public Tile(float x, float y, float width, float height, Texture texture) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

}
