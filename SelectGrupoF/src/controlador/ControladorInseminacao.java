/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoInseminacao;
import javax.swing.JOptionPane;
import modelo.Inseminacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tela.manutencao.ManutencaoInseminacao;

/**
 *
 * @author Clovis
 */
public class ControladorInseminacao {

    public static void inserir(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setDatai(LocalDate.parse(man.jtfDatai.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSituacao(Integer.parseInt(man.jtfSituacao.getText()));
        objeto.setObservo(man.jtfObservo.getText());
        objeto.setDatap(LocalDate.parse(man.jtfDatap.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setCod_touro((Touro)man.jcbCod_touro.getSelectedItem());
        
        
        
        boolean resultado = DaoInseminacao.inserir(objeto);
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

    public static void alterar(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setDatai(LocalDate.parse(man.jtfDatai.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSituacao(Integer.parseInt(man.jtfSituacao.getText()));
        objeto.setObservo(man.jtfObservo.getText());
        objeto.setDatap(LocalDate.parse(man.jtfDatap.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setCod_touro((Touro)man.jcbCod_touro.getSelectedItem());
        
        
        boolean resultado = DaoInseminacao.alterar(objeto);
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

    public static void excluir(ManutencaoInseminacao man){
        Inseminacao objeto = new Inseminacao();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoInseminacao.excluir(objeto);
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
        modelo.addColumn("Situação");
        modelo.addColumn("Observação");
        modelo.addColumn("Data do parto");
        modelo.addColumn("Código do touro");
        List<Inseminacao> resultados = DaoInseminacao.consultar();
        for (Inseminacao objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getDatai().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getSituacao());
            linha.add(objeto.getObservo());
            linha.add(objeto.getDatap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            linha.add(objeto.getCod_touro());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(ManutencaoInseminacao man, int pk){ 
        Inseminacao objeto = DaoInseminacao.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfDatai.setText(objeto.getDatai().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfSituacao.setText(objeto.getSituacao().toString());
        man.jtfObservo.setText(objeto.getObservo());
        man.jtfDatap.setText(objeto.getDatap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jcbCod_touro.setSelectedItem(objeto.getCod_touro());
        
        
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    
    public static void atualizaComboCod_touro(ManutencaoInseminacao man) {
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(DaoInseminacao.consultar().toArray());
        man.jcbCod_touro.setModel(defaultComboBoxModel);
}
}
