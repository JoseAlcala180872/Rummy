package com.itson.rummyserver;

import com.itson.cliente.Cliente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class RummyServer implements SocketInterface {

    private static RummyServer server;
    private ServerSocket servidorSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Map<String, RummyClient> clients;

    private RummyServer() throws IOException {
        this.clients = new HashMap<>();
        this.iniciarServidor();
    }

    public static RummyServer getInstance() throws IOException {
        if (server == null) {
            server = new RummyServer();
            return server;
        }
        return server;
    }

    @Override
    public void run() {
        System.out.println("Servidor iniciado en puerto: " + this.servidorSocket.getLocalPort());
        try {

            while (true) {
                Socket nSocket = this.servidorSocket.accept();
                String idClient = this.crearIdCliente();

                RummyClient rclient = new RummyClient();

                rclient.setId(idClient);
                rclient.setIn(new ObjectInputStream(nSocket.getInputStream()));
                rclient.setOut(new ObjectOutputStream(nSocket.getOutputStream()));
                this.clients.put(idClient, rclient);

                new Thread(rclient).start();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void iniciarServidor() {
        try {
            servidorSocket = new ServerSocket(5000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String crearIdCliente() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            int indice = (int) Math.floor(Math.random() * chars.length());
            String caracter = String.valueOf(chars.charAt(indice));
            id.append(caracter);
        }

        return id.toString();

    }

    /**
     * enviar mensaje a todos los clientes
     *
     * @param str
     */
    @Override
    public void broadcast(String str) {

        try {
            this.out.writeUTF("");
        } catch (IOException ex) {
            Logger.getLogger(RummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendMessageto(String id, String str) {
        try {
            this.clients.get(id).getOut().writeUTF("[SERVER]:" + str);
            this.clients.get(id).getOut().flush();
        } catch (IOException ex) {
            Logger.getLogger(RummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendMessageto(String id, Object str) {
        try {
            this.clients.get(id).getOut().writeObject(str);
            this.clients.get(id).getOut().flush();
        } catch (IOException ex) {
            Logger.getLogger(RummyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Map<String,RummyClient> getClients(){
        return this.clients;
    }

}
