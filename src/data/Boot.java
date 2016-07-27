package data;

import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glMatrixMode;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class Boot {
	
	public Boot() {
		Display.setTitle("Ultimate Game X2000");
		try {
			Display.setDisplayMode(new DisplayMode(600, 400));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 600, 400, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		float width = 50;
		float height = 50;
		float x = 100;
		float y = 100;
		
		while(!Display.isCloseRequested()) {
			glBegin(GL_LINES);
			glVertex2f(10, 10);
			glVertex2f(100, 100);
			glEnd();
			
			glBegin(GL_QUADS);
			glVertex2f(x, y);                        //Top left Corner
			glVertex2f(x + width, y);                //Top Right Corner
			glVertex2f(x + width, y + height);       //Bottom Right Corner
			glVertex2f(x, y + height);               //Bottom Left Corner
			glEnd();
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}

	public static void main(String[] args) {
		new Boot();
	}
}
