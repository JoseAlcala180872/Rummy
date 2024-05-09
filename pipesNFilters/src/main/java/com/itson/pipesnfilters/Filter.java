package com.itson.pipesnfilters;

/**
 *
 * @author
 */
public interface Filter<T> {

    //este es el metodo de la logica, que se hara con la Data
    public T process(T data) throws Exception;

    //Pos nomas le asigna un canal por donde pasar la Data
    public void nextPipe(Pipe siguientePipe);

}
