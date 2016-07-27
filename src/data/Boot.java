package data;



import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

import static helpers.Artist.*;

public class Boot {
	
	public Boot() {
		
		BeginSession();
		
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
