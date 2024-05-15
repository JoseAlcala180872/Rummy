/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.itson.dominio.Jugador;
import javax.swing.JFrame;
import util.IObservable;
import util.IObserver;

/**
 *
 * @author 
 */
public class ModeloInicio implements IObservable<ModeloInicio>{
    private IObserver<ModeloInicio> suscriptor;
    private Jugador jugador;
    
    public ModeloInicio(){}
    
    public ModeloInicio(Jugador jugador){
        this.jugador=jugador;
        }
    
    
    @Override
    public void suscribir(IObserver observador) {
        this.suscriptor=observador;
    }

    @Override
    public void desuscribir(IObserver observador) {
        this.suscriptor=null;
    }

    @Override
    public void notificar(ModeloInicio datos) {
        this.suscriptor.actualizar(datos);
        
    }

    public Jugador getJugador() {
        return this.jugador;
    }
    
    
}
