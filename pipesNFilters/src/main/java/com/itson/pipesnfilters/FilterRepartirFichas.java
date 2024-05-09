/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.pipesnfilters;

/**
 *
 * @author
 */
public class FilterRepartirFichas<T> implements Filter<T> {

    @Override
    public T process(T data) {
        System.out.println("REPARTIR FICHAS EN TODOS LOS JUGADORES");
        return data;
    }

    @Override
    public void nextPipe(Pipe siguientePipe) {
    }

}
