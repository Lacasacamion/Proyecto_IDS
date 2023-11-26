package com.mycompany.ids_proyect;

import javax.swing.JOptionPane;

public class Panel extends javax.swing.JFrame {
    private int numero_hitos;
    private int bac;
    public Panel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        L5 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L1 = new javax.swing.JLabel();
        T1 = new javax.swing.JTextField();
        T3 = new javax.swing.JTextField();
        T2 = new javax.swing.JTextField();
        B1 = new javax.swing.JButton();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        L7 = new javax.swing.JLabel();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L5.setText("Ingrese el numero de hitos:");
        Background.add(L5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        L4.setText("Ingrese el BAC:");
        Background.add(L4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

        L1.setText("Ingrese el nombre del proyecto:");
        Background.add(L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        T1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T1ActionPerformed(evt);
            }
        });
        Background.add(T1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 227, -1));

        T3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T3ActionPerformed(evt);
            }
        });
        Background.add(T3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 90, -1));

        T2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T2ActionPerformed(evt);
            }
        });
        Background.add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, -1));

        B1.setText("Crear proyecto");
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });
        Background.add(B1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));
        Background.add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 190, 20));
        Background.add(L3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 190, 20));
        Background.add(L6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 190, 20));
        Background.add(L7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 240, 20));

        B2.setText("Prorrateado");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });
        Background.add(B2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, -1, -1));

        B3.setText("No prorrateado");
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });
        Background.add(B3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void T1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T1ActionPerformed

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        // TODO add your handling code here:
         String nombre = T1.getText();
         int bac = 0;
         int numero_hitos = 0;
        //Validar entrada del nombre del proyecto
        if(nombre == null || nombre.isEmpty()){
            JOptionPane.showMessageDialog(null, "El nombre no es valido");
            T1.setText("");
            return; //SAlir del metodo si no se valida
        }
  
        //Validar entrada de BAC
        if(!validarBAC(T3.getText().trim())){
            JOptionPane.showMessageDialog(null, "El BAC no es valido");
            T3.setText("");
            return;//Salir del metodo si no se valida
        }
        else{
            bac=Integer.parseInt(T3.getText());
        }
        //Validar entrada de hitos
        if(!validarhito(T2.getText().trim())){
            JOptionPane.showMessageDialog(null, "Los numeros de hitos no son validos");
            T2.setText("");
            return;//salir si no se valida
        }
        else{
            numero_hitos=Integer.parseInt(T2.getText());
        }
        
        
        // Mostrar el mensaje de éxito solo si todas las condiciones son válidas
        L2.setText("El proyecto ha sido creado :)");
        L3.setText("El nombre del proyecto es :"+nombre);
        L6.setText("El BAC es : "+bac);
        L7.setText("El numero de hitos del proyecto es : "+numero_hitos);

    }//GEN-LAST:event_B1ActionPerformed

    public static boolean validarNombre(String nombre){
        return nombre.matches("[A-Za-z]*");
    }
    public static boolean validarBAC(String bac){
        try{
            int numero = Integer.parseInt(bac);
            return numero > 0;
        }catch (NumberFormatException e){
            return false; // No se pudo convertir a un número entero válido
        }
    }
    public static boolean validarhito(String hito){
        try{
            int numero = Integer.parseInt(hito);
            return numero > 1;
        }catch (NumberFormatException e){
            return false; // No se pudo convertir a un número entero válido
        }
    }
    
    private void T2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T2ActionPerformed

    private void T3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T3ActionPerformed

    //Si las condiciones se cumplen y es de tipo prorrateado, se abre la interzas de prorrateado, 
    //y se le pasan los valores de numero de hitos y el bac
    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        // TODO add your handling code here:
        // Obtén el valor de T2 (número de hitos) y T3 (valor de BAC)
        String hitosText = T2.getText().trim();
        String bacText = T3.getText().trim();

        if (validarhito(hitosText) && validarBAC(bacText)) {
            numero_hitos = Integer.parseInt(hitosText);
            bac = Integer.parseInt(bacText);

            Prorrateado prorrateado = new Prorrateado( numero_hitos, bac);
            prorrateado.setVisible(true);
        }
    }//GEN-LAST:event_B2ActionPerformed

    //Si las condiciones se cumplen y es de tipo no prorrateado, se abre la interfaz de no prorrateado,
    // y se le pasan los valores de numero de hitos y bac
    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        // TODO add your handling code here:
        
        // Obtén el valor de T2 (número de hitos) y T3 (valor de BAC)
        String hitosText = T2.getText().trim();
        String bacText = T3.getText().trim();

        if (validarhito(hitosText) && validarBAC(bacText)) {
            numero_hitos = Integer.parseInt(hitosText);
            bac = Integer.parseInt(bacText);

            No_Prorrateado no_prorrateado = new No_Prorrateado(numero_hitos);
            no_prorrateado.setVisible(true);
        } 
    }//GEN-LAST:event_B3ActionPerformed
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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JPanel Background;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JLabel L7;
    private javax.swing.JTextField T1;
    private javax.swing.JTextField T2;
    private javax.swing.JTextField T3;
    // End of variables declaration//GEN-END:variables
}
