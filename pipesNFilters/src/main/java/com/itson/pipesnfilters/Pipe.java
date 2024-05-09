
package com.itson.pipesnfilters;

/**
 *
 * @author 
 */
public interface Pipe<T> {
    
    //Este metodo le dice cual es el filtro que sigue 
    public void nextFilter(Filter siguienteFiltro);
    //Pos ejecuta lo que tenga que ejecutar para pasar la data
    public T process(T data)throws Exception;
    //Pa saber pa donde va
    public Filter getTarget();
}

