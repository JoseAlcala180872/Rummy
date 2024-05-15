package com.itson.cliente;

import com.itson.dominio.Jugador;
import com.itson.rummy.Rummy;
import com.itson.dominio.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente implements Runnable{
    
    
      private String nombre;
      private Socket socket;
      private static Cliente socketCliente;
      private static final String HOST="localhost";
      private static final int PORT=5000; 
      private static ObjectInputStream in ;
      private static ObjectOutputStream ou ;
      private Cliente() {

             
      }
      
      @Override
    public void run() {
        this.iniciarSocket();

       
        try { 
            // Enviamos mensaje de conexión a servidor
            ou.writeUTF("CONNECT");
            ou.flush();
            while (true) {
                // esperamos la respuesta
                String r =in.readUTF();
                System.out.println(r);
                // si la respuesta es conexión se incia la primer interacción
                if(r.equalsIgnoreCase("[SERVER]:CONNECT")){
                    Jugador j=new Jugador(); 
                    ou.writeObject(j);
                    ou.flush();
                    String id =in.readUTF();
                    // el server envía el id del cliente
                    System.out.println("[SERVER]:CLIENTID -> "+id);
                    
                }
                if(r.equals("[SERVER]:CREARPARTIDA")){
                    
                    Partida p =(Partida)in.readObject();
                    System.out.println(p);
                    
                }
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Rummy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

      private void iniciarSocket(){
          try {
            this.socket = new Socket(HOST, PORT);
            ou = new ObjectOutputStream(this.getSocket().getOutputStream());
            in = new ObjectInputStream(this.getSocket().getInputStream());
            
          }catch (IOException e){
              System.out.println(e.getMessage());
          }

      }

      public static Cliente getInstance() throws IOException{
          if(socketCliente==null){
              socketCliente= new Cliente();
          }
          return socketCliente;
      }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public ObjectOutputStream getOu() {
        return ou;
    }
    
}
