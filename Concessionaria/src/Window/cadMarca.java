package Window;

import bd.dbos.*;
import bd.daos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class cadMarca implements ActionListener 
{
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(14,1));
        JLabel label = new JLabel("idMarca: ");
        JTextField idMarca = new JTextField();
        JLabel label1 = new JLabel("Nome Marca: ");
        JTextField nomeMarca = new JTextField();
        JLabel label2 = new JLabel("Fundação: ");
        JTextField fundacao = new JTextField();
        JLabel label3 = new JLabel("Proprietário: ");
        JTextField proprietario = new JTextField();
        JButton incluir = new JButton("Incluir Dados");
        JButton visualizar = new JButton("Buscar");
        JButton verTabela = new JButton("Ver tabela");
        JButton atualizar = new JButton("Atualizar linha");
        JButton deletar = new JButton("Deletar linha (informe apenas o ID)");
        JButton voltar = new JButton("Voltar para tela principal");
        
    cadMarca()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setVisible(true);
        
        panel.add(label);
        panel.add(idMarca);
        panel.add(label1);
        panel.add(nomeMarca);
        panel.add(label2);
        panel.add(fundacao);
        panel.add(label3);
        panel.add(proprietario);
        panel.add(incluir);
        panel.add(visualizar);
        panel.add(verTabela);
        panel.add(atualizar);
        panel.add(deletar);
        panel.add(voltar);
        frame.add(panel);

        incluir.addActionListener(this);
        visualizar.addActionListener(this);
        verTabela.addActionListener(this);
        atualizar.addActionListener(this);
        deletar.addActionListener(this);
        voltar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==incluir)
        {
            try {
            Marca data = new Marca(Integer.parseInt(idMarca.getText()), nomeMarca.getText(), Integer.parseInt(fundacao.getText()), proprietario.getText());
            Marcas.incluir(data);
            JOptionPane.showMessageDialog(frame,"Dados incluídos com sucesso total!!!");
            }
            
            catch(Exception erro)
            {
                erro.printStackTrace();
               JOptionPane.showMessageDialog(frame,"Não foi possível incluir os dados!");
            }
        }
    

        if(e.getSource()==visualizar)
        {
            try
            {
                Marca data = Marcas.getMarca(Integer.parseInt(idMarca.getText()));
                idMarca.setText(""+data.getIdMarca());
                nomeMarca.setText(data.getNomeMarca());
                fundacao.setText(""+data.getFundacao());
                proprietario.setText(data.getProprietario());
            
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(frame,"Não foi possível visualizar os dados!");
            }
        }
        if(e.getSource()==verTabela)
        {
            new tabelaMarca();
        }

        if(e.getSource()==atualizar)
        {
             try {
            Marca data = new Marca(Integer.parseInt(idMarca.getText()), nomeMarca.getText(), Integer.parseInt(fundacao.getText()), proprietario.getText());
            Marcas.alterar(data);
            JOptionPane.showMessageDialog(frame,"Dados atualizados!");
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(frame,"Não foi possível atualizar os dados!");
            }
        }

        if(e.getSource()==deletar)
        {
             try {
                 Marcas.excluir(Integer.parseInt(idMarca.getText()));
                 JOptionPane.showMessageDialog(frame,"Dados deletados com sucesso total!!!");
            }
            catch(Exception erro)
            {
                erro.printStackTrace();
                JOptionPane.showMessageDialog(frame,"Não foi possível deletar os dados!");
            }
        }

        if(e.getSource()==voltar)
        {
            frame.dispose();
        }
    }
}
