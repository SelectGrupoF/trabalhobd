/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Evelin
 */
public class Manejo {
    private Integer codigo; 
    private String obs;
    private LocalDate datas; //é necessário fazer a seguinte importação: java.time.LocalDate;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public LocalDate getDatas() {
        return datas;
    }

    public void setDatas(LocalDate datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "ControladorManejo{" + "obs=" + obs + '}';
    }
    
    
}
