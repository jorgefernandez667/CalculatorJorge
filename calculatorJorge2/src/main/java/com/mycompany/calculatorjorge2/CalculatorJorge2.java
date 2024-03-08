/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.calculatorjorge2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ferna
 */
public class CalculatorJorge2 extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultadoField;
    private JComboBox<String> operaciones;
    
    public CalculatorJorge2() {
        
        setTitle("Calculadora");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

     
        JPanel numerosPanel = new JPanel(new GridLayout(1, 4));
        num1Field = new JTextField();
        num2Field = new JTextField();
        numerosPanel.add(new JLabel("Número 1:"));
        numerosPanel.add(num1Field);
        numerosPanel.add(new JLabel("Número 2:"));
        numerosPanel.add(num2Field);

        JPanel operacionPanel = new JPanel(new FlowLayout());
        operaciones = new JComboBox<>(new String[]{"Suma", "Resta", "Multiplicación", "División"});
        operacionPanel.add(operaciones);

        resultadoField = new JTextField();
        resultadoField.setEditable(false);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);

        // Agregar componentes a la ventana
        add(numerosPanel);
        add(operacionPanel);
        add(calcularButton);
        add(resultadoField);

        
        setVisible(true);
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
try {
        double num1 = Double.parseDouble(num1Field.getText());
        double num2 = Double.parseDouble(num2Field.getText());
        String operacion = (String) operaciones.getSelectedItem();
        double resultado = 0;

        switch (operacion) {
            case "Suma":
                resultado = num1 + num2;
                break;
            case "Resta":
                resultado = num1 - num2;
                break;
            case "Multiplicación":
                resultado = num1 * num2;
                break;
            case "División":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: división por cero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                break;
        }

        resultadoField.setText(Double.toString(resultado));
    } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Debes ingresar números válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorJorge2::new);
    }
}
