/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoManejo;
import javax.swing.JOptionPane;
import modelo.Manejo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tela.manutencao.ManutencaoManejo;

/**
 *
 * @author Clovis
 */
public class ControladorManejo {

    public static void inserir(ManutencaoManejo man){
        Manejo objeto = new Manejo();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setDatas(LocalDate.parse(man.jtfDatas.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setObs(man.jtfObs.getText());
        
       
      
       
        boolean resultado = DaoManejo.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoManejo man){
        Manejo objeto = new Manejo();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setDatas(LocalDate.parse(man.jtfDatas.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setObs(man.jtfObs.getText());
        
        
        boolean resultado = DaoManejo.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoManejo man){
        Manejo objeto = new Manejo();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoManejo.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        
        modelo.addColumn("Data");
        
        modelo.addColumn("Observação");
        
        List<Manejo> resultados = DaoManejo.consultar();
        for (Manejo objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            
            linha.add(objeto.getDatas().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            
            linha.add(objeto.getObs());
            
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoManejo man, int pk){ 
        Manejo objeto = DaoManejo.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
       
        man.jtfDatas.setText(objeto.getDatas().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
       
        man.jtfObs.setText(objeto.getObs());
        
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
}
