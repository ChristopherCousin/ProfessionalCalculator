package Utils;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


	//Quiero quitar el viejo JFrame que tiene que no me gusta y haciendo eso tambien quito algunas fucniones como esta
	//Asi que la he implementado por mi cuenta.
public class FrameDragListener extends MouseAdapter {

 	//Creamos un JFrame
    private final JFrame frame;
    //Un puntero que tendra las cordenadaras del mouse
    private Point mouseDownCompCoords = null;

    //En el constructor le ponemos como parametro el JFrame que queramos mover
    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }
    //cordenadas del raton
    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }
    //Detectamos cuando el usuario haga click
    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }
    //Ahora movemos la ventana acorde con el mouse event and currCords.
    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
}