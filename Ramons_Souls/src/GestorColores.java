import java.awt.Color;

public enum GestorColores {
    NEGRO_OSCURO(15, 56, 15),
    VERDE_OSCURO(48, 98, 48),
    VERDE_CLARO(139, 172, 15),
    BLANCO_MUY_CLARO(155, 188, 15),
    MARRON_OSCURO(40, 40, 8),
    MARRON_MEDIO(88, 70, 0),
    MARRON_CLARO(138, 98, 22),
    BEIGE(181, 148, 49),
    GRIS_OSCURO(33, 33, 33),
    GRIS_MEDIO(85, 85, 85),
    GRIS_CLARO(170, 170, 170),
    AZUL_OSCURO(29, 43, 83),
    AZUL_MEDIO(66, 116, 165),
    AZUL_CLARO(102, 191, 255),
    ROJO_OSCURO(115, 28, 28),
    ROJO_MEDIO(187, 53, 59),

    private final Color color;

    GestorColores(int r, int g, int b) {
        this.color = new Color(r, g, b);
    }

    public Color getColor() {
        return color;
    }
}
