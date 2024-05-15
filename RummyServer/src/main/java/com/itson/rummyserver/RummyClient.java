/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.rummyserver;

import com.itson.dominio.Jugador;
import com.itson.dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author el_fr
 */
public class RummyClient implements SocketInterface{
    private String id;
    private Jugador jugador;
    private Partida partida;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public String getId() {
        return id;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }
    
    
    @Override
    public void run() {
        while (true) {
            try {
                // esperamos el comando del cliente
                String comando=this.in.readUTF();
                switch (comando) {
                    case "CONNECT":
                        System.out.println("[CLIENTE]:CONNECT-> CLIENTID: "+id);
                        this.sendMessageto(this.id, "CONNECT");
                        this.jugador=(Jugador)this.in.readObject(); 
                        this.jugador.id=this.id;
                        // se envia el id al nuevo cliente
                        this.out.writeUTF(this.id);
                        this.out.flush();
                        break;
                        
                    case "CONFIGURARJUGADOR":
                        // obtiene los datos de configuración del jugador y se mantiene en el servidor
                        System.out.println("[CLIENTE]:CONFIGURARJUGADOR-> CLIENTID: "+id);
                        Jugador j=(Jugador)this.in.readObject();
                        this.jugador.id=this.id;
                        this.jugador.nombre=j.nombre;
                        this.jugador.setAvatar(j.getAvatar());
                        System.out.println(this.jugador);
                        this.out.flush();
                        break;
                    case "CREARPARTIDA":
                        System.out.println("[CLIENTE]:CREARPARTIDA-> CLIENTID: "+id);
                        if(partida!=null){
                            return;
                        }
                        this.partida = new Partida();
                        this.partida.jugadores=new ArrayList<>();
                        this.partida.jugadores.add(jugador);
                        this.sendMessageto(this.id, "CREARPARTIDA");
                        this.getOut().writeObject(partida);
                        this.getOut().flush();
                        break;
                    case "INICIARPARTIDA":
                        //PIPE INICIAR
                        
                        
                        break;

                    default:
                        break;
                }
                
            } catch (IOException ex) {
                Logger.getLogger(RummyClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RummyClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    @Override
    public void broadcast(String str) {
        try {
            RummyServer.getInstance().broadcast(str);
        } catch (IOException ex) {
            Logger.getLogger(RummyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessageto(String id, String str) {
        try {
            RummyServer.getInstance().sendMessageto(id, str);
        } catch (IOException ex) {
            Logger.getLogger(RummyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessageto(String id, Object obj){
        try{
            RummyServer.getInstance().sendMessageto(id, obj);
        }catch(IOException ex){
           Logger.getLogger(RummyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
