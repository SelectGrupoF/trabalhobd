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
public class Lactacao {
    private Integer codigo;
    private LocalDate inicio; //é necessário fazer a seguinte importação: java.time.LocalDate;
    private LocalDate fim; //é necessário fazer a seguinte importação: java.time.LocalDate;
    private String obser;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public String getObser() {
        return obser;
    }

    public void setObser(String obser) {
        this.obser = obser;
    }

    @Override
    public String toString() {
        return "ControladorLactacao{" + "obser=" + obser + '}';
    }
    
    
}
