/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.rummyserver;

import com.itson.dominio.Partida;
import java.util.List;

/**
 *
 * @author el_fr
 */
public interface SocketInterface extends Runnable{
    
    public void broadcast(String str);
    public void sendMessageto(String id,String str);
}
