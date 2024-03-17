/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Yeisi
 */
public class FichasEnPozo {
    ArrayList<Fichas> pozo;

    public ArrayList<Fichas> getPozo() {
        return pozo;
    }

    public void setPozo(int maximoFichas) {
        System.out.println("El maximo de fichas son: "+maximoFichas);
        pozo = new ArrayList<>();
        ArrayList<FichaNumero> ficha=new ArrayList<>();
        
            for (int i = 0; i < 2; i++) {
            //rojas
            for (int j = 1; j < maximoFichas+1; j++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(j);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
                
            }
            //amarillas
            for (int k = 1; k < maximoFichas+1; k++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(k);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
            //verdes
            for (int l = 1; l < maximoFichas+1; l++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(l);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
            //negras
            for (int m = 1; m < maximoFichas+1; m++) {
                FichaNumero fichaNumero=new FichaNumero();
                fichaNumero.setNumero(m);
                ficha.add(fichaNumero);
                pozo.add(fichaNumero);
            }
        }            
    }
}
