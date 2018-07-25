package telas;

import dao.CategoriaDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Categoria;


public class ListCategorias extends javax.swing.JInternalFrame {

  
    public ListCategorias() {
        initComponents();
        carregarTabela();
    }

    private void carregarTabela(){
        String[] colunas = {"Código", "Nome"};
        List<Categoria> listaDeCategorias = CategoriaDAO.getCategorias();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(colunas);
        
        
        for( Categoria cat : listaDeCategorias){
            Object[] obj = { cat.getCodigo(), cat.getNome()};
            modelo.addRow(obj);
            
            
        }
        
        
        tableCategorias.setModel(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCategorias = new javax.swing.JTable();

        setTitle("Categoria");
        setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setText("Tipo");

        tableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nome"
            }
        ));
        jScrollPane1.setViewportView(tableCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(386, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Lista Categoria");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCategorias;
    // End of variables declaration//GEN-END:variables
}
