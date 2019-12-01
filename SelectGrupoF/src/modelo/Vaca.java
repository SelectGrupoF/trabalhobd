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
public class Vaca {
    private Integer brinco;
    private Integer situacao;
    private Integer origem;
    private LocalDate nascimento; //é necessário fazer a seguinte importação: java.time.LocalDate;
    private String observa; 
    private Raca cod_raca;
    private Lactacao cod_lac;
    private Producao cod_leite;
    private Inseminacao cod_ins;
    private Vaca cod_mae;

    public Integer getBrinco() {
        return brinco;
    }

    public void setBrinco(Integer brinco) {
        this.brinco = brinco;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Integer getOrigem() {
        return origem;
    }

    public void setOrigem(Integer origem) {
        this.origem = origem;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getObserva() {
        return observa;
    }

    public void setObserva(String observa) {
        this.observa = observa;
    } 

    public Raca getCod_raca() {
        return cod_raca;
    }

    public void setCod_raca(Raca cod_raca) {
        this.cod_raca = cod_raca;
    }

    public Lactacao getCod_lac() {
        return cod_lac;
    }

    public void setCod_lac(Lactacao cod_lac) {
        this.cod_lac = cod_lac;
    }

    public Producao getCod_leite() {
        return cod_leite;
    }

    public void setCod_leite(Producao cod_leite) {
        this.cod_leite = cod_leite;
    }

    public Inseminacao getCod_ins() {
        return cod_ins;
    }

    public void setCod_ins(Inseminacao cod_ins) {
        this.cod_ins = cod_ins;
    }

    public Vaca getCod_mae() {
        return cod_mae;
    }

    public void setCod_mae(Vaca cod_mae) {
        this.cod_mae = cod_mae;
    }
    

    @Override
    public String toString() {
        return "Vaca{" + "cod_raca=" + cod_raca + ", cod_lac=" + cod_lac + ", cod_leite=" + cod_leite + ", cod_ins=" + cod_ins + ", cod_mae=" + cod_mae + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.brinco);
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
        final Vaca other = (Vaca) obj;
        if (!Objects.equals(this.brinco, other.brinco)) {
            return false;
        }
        return true;
    }
    
   
}
