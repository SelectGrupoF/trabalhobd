/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Evelin
 */
public class ManejoVaca {
    
    private Manejo cod_man;
    private Vaca cod_vaca;     

    public Manejo getCod_man() {
        return cod_man;
    }

    public void setCod_man(Manejo cod_manejo) {
        this.cod_man = cod_manejo;
    }

    public Vaca getCod_vaca() {
        return cod_vaca;
    }

    public void setCod_vaca(Vaca cod_vaca) {
        this.cod_vaca = cod_vaca;
    }

    @Override
    public String toString() {
        return "ManejoVaca{" + "cod_man=" + cod_man + ", cod_vaca=" + cod_vaca + '}';
    }
    
    
}
