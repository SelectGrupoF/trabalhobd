/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Evelin
 */
public class Inseminacao {
     private Integer codigo;
    private Integer situacao;
    private String observo;
    private Touro cod_touro;
    private LocalDate datai; //é necessário fazer a seguinte importação: java.time.LocalDate;
    private LocalDate datap; //é necessário fazer a seguinte importação: java.time.LocalDate;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public String getObservo() {
        return observo;
    }

    public void setObservo(String observo) {
        this.observo = observo;
    }

    public Touro getCod_touro() {
        return cod_touro;
    }

    public void setCod_touro(Touro cod_touro) {
        this.cod_touro = cod_touro;
    }

    public LocalDate getDatai() {
        return datai;
    }

    public void setDatai(LocalDate datai) {
        this.datai = datai;
    }

    public LocalDate getDatap() {
        return datap;
    }

    public void setDatap(LocalDate datap) {
        this.datap = datap;
    }

    @Override
    public String toString() {
        return "ControladorInseminacao{" + "cod_touro=" + cod_touro + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inseminacao other = (Inseminacao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
}
