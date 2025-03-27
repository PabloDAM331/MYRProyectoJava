

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Color;

public class Ventana extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;//Esto es para saber en la versión que estás
    private static final int ALTO = 1280;//Establezco el tamaño del alto
    private static final int ANCHO = 720;//Establesco el tamaño del año
    private static final String NOMBRE = "Ramon's Souls";//
    private static JFrame ventana;
    private Thread thread;
    private static volatile boolean enFuncionamiento = false;
    private static int aps = 0;
    private static int fps=0;


    public Ventana() {
        this.setPreferredSize(new Dimension(ALTO, ANCHO));
        ventana = new JFrame("Ramon's Souls");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(true);
        ventana.add(this, "Center");
        ventana.pack();
        ventana.setLocationRelativeTo((Component)null);
        ventana.setVisible(true);
        setBackground(Color.BLACK);



    }


    public synchronized void iniciar(){
        enFuncionamiento = true;

        thread = new Thread(this, "graficos");
        thread.start();

    }

    public synchronized void detener(){
        enFuncionamiento= false;
        try {
            thread.join();//Sirve para pagar el programa de una maneraa menos abrupta
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void acutalizar(){
        aps++;
    }
    public void mostrar(){
        fps++;
    }


    @Override
    public void run() {
        final int nanos_segundos = 1000000000;//cauntos naos  hay en un segundo
        final byte aps_objetivo = 60;//La cantIdad de actualizaciones que queremos en 1 segundo
        final double nanos_actualizacion = nanos_segundos / aps_objetivo;//la cantidad de nanos segundos por cada actualizacion

        long ref_actualizacion = System.nanoTime();// Se va atribuir una cantidad de nano segundos
        long ref_contador = System.nanoTime();

        double tiempoTranscurrido;//tiempo transcurrido
        double delta = 0;//la cantidad de tiempo que ha trascurrido al iniciar una catualización

        while(enFuncionamiento){
            final long inicio = System.nanoTime();// inicio del bucle
            tiempoTranscurrido =  inicio-ref_actualizacion;

            delta += tiempoTranscurrido/nanos_actualizacion;//calculamos delta

            ref_actualizacion = inicio;// el timpo de referencia de actuañlizacion es igual a tirmpo de inicio

            while (delta >= 1) {
                acutalizar();
                delta--;
            }

            mostrar();

            if(System.nanoTime()-ref_contador > nanos_segundos){
                ventana.setTitle(NOMBRE + "  APS:  "+ aps + "   FPS:  " + fps);
                aps = 0;
                fps = 0;
                ref_contador = System.nanoTime();
            }
        }

    }




}