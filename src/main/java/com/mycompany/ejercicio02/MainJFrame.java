/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ejercicio02;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mander
 */
public class MainJFrame extends javax.swing.JFrame {

    VowelCounter vowelCounter;
    Number number;

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        runLexerJButton = new javax.swing.JButton();
        vowelsJLabel = new javax.swing.JLabel();
        numberJLabel = new javax.swing.JLabel();
        cleanJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        numbersInfoJTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        valiablesInfoJText = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        entryJText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        runLexerJButton.setText("Analizar");
        runLexerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runLexerJButtonActionPerformed(evt);
            }
        });

        vowelsJLabel.setText("Resultados Vocales:");

        numberJLabel.setText("ResultadosNumeros:");

        cleanJButton.setText("Limpiar");
        cleanJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanJButtonActionPerformed(evt);
            }
        });

        numbersInfoJTable.setAutoCreateRowSorter(true);
        numbersInfoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numero", "Linea", "Columna"
            }
        ));
        jScrollPane1.setViewportView(numbersInfoJTable);

        valiablesInfoJText.setColumns(20);
        valiablesInfoJText.setRows(5);
        jScrollPane2.setViewportView(valiablesInfoJText);

        entryJText.setColumns(20);
        entryJText.setRows(5);
        jScrollPane3.setViewportView(entryJText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                            .addComponent(numberJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vowelsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(runLexerJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cleanJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vowelsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(numberJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(runLexerJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cleanJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runLexerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runLexerJButtonActionPerformed
        Reader reader = new StringReader(entryJText.getText());
        vowelCounter = new VowelCounter(reader);
        try {
            int output = vowelCounter.yylex();
            while (output != VowelCounter.YYEOF) {
                vowelCounter.yylex();
            }
            valiablesInfoJText.setText("Palabras con 1 vocal: " + vowelCounter.getOneVowelCounter() + "\nPalabaras con 2 vocales " + vowelCounter.getTwoVowelCounter() + "\nPalabaras con 3 vocales " + vowelCounter.getTreeVowelCounter() + "\nPalabaras con 4 vocales " + vowelCounter.getForVowelCounter() + "\nPalabaras con 5 vocales " + vowelCounter.getFiveVowelCounter());
            addNumbers(vowelCounter.numberInfo);
            DefaultTableModel model = (DefaultTableModel) numbersInfoJTable.getModel();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_runLexerJButtonActionPerformed

    private void cleanJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanJButtonActionPerformed
        valiablesInfoJText.setText("");
        entryJText.setText("");
        DefaultTableModel model = (DefaultTableModel) numbersInfoJTable.getModel();
        this.numbersInfoJTable.setModel(new DefaultTableModel(null, new String[] {"Numero", "Linea", "Columna"}));
    }//GEN-LAST:event_cleanJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);

            }
        });
    }

    private void addNumbers(ArrayList<Number> numberList) {
        DefaultTableModel model = (DefaultTableModel) numbersInfoJTable.getModel();
        this.numbersInfoJTable.setModel(model);
        for (Number numberInfo : numberList) {
            model.insertRow(0, new Object[]{numberInfo.getValue(), numberInfo.getLine(), numberInfo.getColumn()});
        }
        this.numbersInfoJTable.setModel(model);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanJButton;
    private javax.swing.JTextArea entryJText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel numberJLabel;
    private javax.swing.JTable numbersInfoJTable;
    private javax.swing.JButton runLexerJButton;
    private javax.swing.JTextArea valiablesInfoJText;
    private javax.swing.JLabel vowelsJLabel;
    // End of variables declaration//GEN-END:variables
}
