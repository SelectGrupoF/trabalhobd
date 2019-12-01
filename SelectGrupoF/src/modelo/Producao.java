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
 * @author Clovis
 */
public class Producao {
    private Integer codigo;
    private Integer turno;
    private LocalDate data;
    private Integer total;
    private String obse;
    private Pessoa cod_pessoa;

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

    public String getObse() {
        return obse;
    }

    public void setObse(String obs) {
        this.obse = obs;
    }

    public Pessoa getCod_pessoa() {
        return cod_pessoa;
    }

    public void setCod_pessoa(Pessoa cod_pessoa) {
        this.cod_pessoa = cod_pessoa;
    }

    @Override
    public String toString() {
        return "Producao{" + "cod_pessoa=" + cod_pessoa + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.codigo);
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
        final Producao other = (Producao) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
}
