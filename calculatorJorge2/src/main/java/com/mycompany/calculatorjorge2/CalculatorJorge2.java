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
    /*aqui declaro 4 objetos*/
    /*3 son lineas de entrada y salida*/
    /*1 es de tip tabla*/
    private JTextField num1Field, num2Field, resultadoField;
    private JComboBox<String> operaciones;
    
    /*aqui creo el constructor donde se crea la ventana y sus objetos*/
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

        
        add(numerosPanel);
        add(operacionPanel);
        add(calcularButton);
        add(resultadoField);

        /*aqui vuelve visible la ventana*/
        setVisible(true);
    }

  
    @Override
    /*aqui se crea la logica de la tabla de operaciones y los calculos*/
    public void actionPerformed(ActionEvent e) {
/*aqui uso try para que solo reciba numeros para los calculos y cuando recibe una letra o un caracter no valido lo manda a catch*/ 
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
                    /*aqui suela el error si quiere dividir entre 0*/
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
        /*Utilice SwingUtilities.invokeLater() para asegurar de que la creación de la interfaz gráfica se realice en el hilo de eventos de Swing.*/
        SwingUtilities.invokeLater(CalculatorJorge2::new);
    }
}
