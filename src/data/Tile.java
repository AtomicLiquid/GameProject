package data;

import org.newdawn.slick.opengl.Texture;
//Tile.java är till för att skapa alla texturer till alla tiles på spelet.
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
