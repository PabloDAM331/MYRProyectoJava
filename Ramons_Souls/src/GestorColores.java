import java.awt.Color;
import java.util.ArrayList;

public class GestorColores extends Color {
    ArrayList<Color> colores=new ArrayList<Color>();
    Color color_background = Color.BLACK;

    public void addColores(){
        colores.add(color_background);


    }

    public GestorColores(int rgb1, int rgb2, int rgb3, ArrayList<Color> colores) {
        super(rgb1, rgb2, rgb3);
        this.colores=colores;

    }
    public GestorColores(){
        super(0,0,0);
    }


}
