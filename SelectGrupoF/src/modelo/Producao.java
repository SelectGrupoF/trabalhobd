/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;

/**
 *
 * @author Clovis
 */
public class Producao {
    private Integer codigo;
    private Integer turno;
    private LocalDate data;
    private Integer total;
    private String obs;
    private Integer cod_pessoa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Integer cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    @Override
    public String toString() {
        return "Producao{" + "cod_pessoa=" + cod_pessoa + '}';
    }
    
    
}
