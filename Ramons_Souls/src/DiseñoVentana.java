import java.awt.*;

public class DiseñoVentana extends Canvas {
    GestorColores gc= new GestorColores();
    public DiseñoVentana(){
        setBackground(gc.colores.getFirst());
    }
    public void paint(Graphics g) {

    }

}
