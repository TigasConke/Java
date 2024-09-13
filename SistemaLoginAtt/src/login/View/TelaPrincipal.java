package login.View;

public class TelaPrincipal extends javax.swing.JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroCliente = new javax.swing.JMenuItem();
        menuConsultar = new javax.swing.JMenu();
        menuCadastroCliente1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setText("Cadastro");
        menuCadastro.setToolTipText("");

        menuCadastroCliente.setText("cliente");
        menuCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroClienteActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroCliente);

        jMenuBar1.add(menuCadastro);

        menuConsultar.setText("Consulta");
        menuConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarActionPerformed(evt);
            }
        });

        menuCadastroCliente1.setText("consulta");
        menuCadastroCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCliente1ActionPerformed(evt);
            }
        });
        menuConsultar.add(menuCadastroCliente1);

        jMenuBar1.add(menuConsultar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroClienteActionPerformed
        TelaCadastroCliente tela = new TelaCadastroCliente();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadastroClienteActionPerformed

    private void menuConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarActionPerformed
        TelaConsultaCliente tela = new TelaConsultaCliente();
        tela.setVisible(true);
    }//GEN-LAST:event_menuConsultarActionPerformed

    private void menuCadastroCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCliente1ActionPerformed
         TelaConsultaCliente tela = new TelaConsultaCliente();
        tela.setVisible(true);
    }//GEN-LAST:event_menuCadastroCliente1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCliente;
    private javax.swing.JMenuItem menuCadastroCliente1;
    private javax.swing.JMenu menuConsultar;
    // End of variables declaration//GEN-END:variables
}
