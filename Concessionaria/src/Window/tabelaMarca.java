package Window;

import bd.dbos.*;
import bd.core.MeuResultSet;
import bd.daos.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class tabelaMarca
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new GridLayout(1,1));

    JTextArea area = new JTextArea(20,10);
    public tabelaMarca()
    {
        String dados = "";

        try {
            MeuResultSet result = Marcas.getMarcas();
            while(result.next())
                dados += ""+result.getInt("idMarca")+"       "+result.getString("nomeMarca")+"       "
                +result.getInt("fundacao")+"       "+result.getString("proprietario")+"\n";
        } catch (Exception e) {
           JOptionPane.showMessageDialog(frame,"ERROR");
        }   
        area.setText(dados);
        panel.add(area);
        frame.setSize(400,300);
        frame.setVisible(true);
        frame.add(panel);
    }
}
