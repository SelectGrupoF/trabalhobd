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
public class Vaca {
    private Integer brinco;
    private Integer situacao;
    private Integer origem;
    private LocalDate nascimento; //é necessário fazer a seguinte importação: java.time.LocalDate;
    private String observa; 
    private Integer cod_raca;
    private Integer cod_lac;
    private Integer cod_leite;
    private Integer cod_ins;
    private Integer cod_mae;

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

    public Integer getCod_raca() {
        return cod_raca;
    }

    public void setCod_raca(Integer cod_raca) {
        this.cod_raca = cod_raca;
    }

    public Integer getCod_lac() {
        return cod_lac;
    }

    public void setCod_lac(Integer cod_lac) {
        this.cod_lac = cod_lac;
    }

    public Integer getCod_leite() {
        return cod_leite;
    }

    public void setCod_leite(Integer cod_leite) {
        this.cod_leite = cod_leite;
    }

    public Integer getCod_ins() {
        return cod_ins;
    }

    public void setCod_ins(Integer cod_ins) {
        this.cod_ins = cod_ins;
    }

    public Integer getCod_mae() {
        return cod_mae;
    }

    public void setCod_mae(Integer cod_mae) {
        this.cod_mae = cod_mae;
    }

    @Override
    public String toString() {
        return "Vaca{" + "cod_raca=" + cod_raca + ", cod_lac=" + cod_lac + ", cod_leite=" + cod_leite + ", cod_ins=" + cod_ins + ", cod_mae=" + cod_mae + '}';
    }
    
   
}
