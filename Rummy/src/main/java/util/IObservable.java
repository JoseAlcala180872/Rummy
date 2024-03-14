/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author 
 */
public interface IObservable<T> {
    public void suscribir(IObserver observador);
    public void desuscribir(IObserver observador);
    public void notificar(T datos);
}
