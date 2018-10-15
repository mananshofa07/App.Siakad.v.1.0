
package Form;

    import Tool.KoneksiDB;
    import java.awt.Dimension;
    import java.awt.Toolkit;
    import java.sql.*;
    import javax.swing.JOptionPane;
    import javax.swing.table.DefaultTableModel; 

public class IfrJurusan extends javax.swing.JInternalFrame {

    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    String sqlselect, sqlinsert, sqldelete;
    private DefaultTableModel tbljurusan;
    String vkd_jur, vjurusan;
    
    public IfrJurusan() {
        initComponents();
        
        formTengah();
        clearForm();
        disableInput();
        setTabelJurusan();
        showDataJurusan();
    }
    
    private void clearForm(){
         txtKdJur.setText("");
         txtJurusan.setText("");
         btnSimpan.setText("Simpan");
    }
    
    private void disableInput(){  
        txtKdJur.setEnabled(false);
        txtJurusan.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnHapus.setEnabled(false);
    }
    
    private void enableInput(){
        txtKdJur.setEnabled(true);
        txtJurusan.setEnabled(true);
        btnSimpan.setEnabled(true);
    }
    
    private void setTabelJurusan(){  
        String[] kolom1 = {"KD. Jur", "Jurusan"};
        tbljurusan = new DefaultTableModel(null, kolom1){
          Class[] types = new Class[]{
            java.lang.String.class,
            java.lang.String.class
          };  
          public Class getColumClass(int columnIndex){
              return types [columnIndex];
          }
          
          //agar tabel tidak bisa diedit
          public boolean isCellEditable(int row, int col){
              int cola = tbljurusan.getColumnCount();
              return (col < cola) ? false : true;
          }
        };
        tbJurusan.setModel(tbljurusan);
        tbJurusan.getColumnModel().getColumn(0).setPreferredWidth(75);
        tbJurusan.getColumnModel().getColumn(1).setPreferredWidth(250);
    }
    
    private void clearTabelJurusan(){
        int row = tbljurusan.getRowCount();
        for(int i=0; i<row; i++){
            tbljurusan.removeRow(0);
        }
    }
    
    private void showDataJurusan(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            clearTabelJurusan();
            sqlselect = "select * from tbjurusan order by kd_jur asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sqlselect);
            while(res.next()){
                vkd_jur = res.getString("kd_jur");
                vjurusan = res.getString("jurusan");
                
                Object[] data = {vkd_jur, vjurusan};
                tbljurusan.addRow(data);
            }
            lbRecord.setText("Record : "+tbJurusan.getRowCount());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error method showDatajurusan() : "+ex);
        }
    }
    
    private void aksiSimpan(){
        vkd_jur = txtKdJur.getText();
        vjurusan = txtJurusan.getText(); 
        if(btnSimpan.getText().equals("Simpan")){
            sqlinsert = "insert into tbjurusan values ('"+vkd_jur+"', '"+vjurusan+"') ";
        }else{
            sqlinsert = "update tbjurusan set jurusan='"+vjurusan+"' "
                    + "where kd_jur='"+vkd_jur+"'";
        }
        
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            Statement state = _Cnn.createStatement();
            state.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
            showDataJurusan(); clearForm(); disableInput();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, "Error Method aksiSimpan() : " +ex);
        }
    }
    
    private void aksiHapus(){
        int jawab = JOptionPane.showConfirmDialog(this, "Anda yakin akan menghapus data ini? Kode : "+vkd_jur, 
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                sqldelete = "delete from tbjurusan where kd_jur='"+vkd_jur+"' ";
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqldelete);
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                showDataJurusan(); clearForm(); disableInput();
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(this, "Error Method aksiHapus() : " +ex);
            }
        }   
    }
    
    private void formTengah(){
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension framesize = this.getSize();
        if(framesize.height < screensize.height){
            framesize.height = screensize.height;
        }
        if(framesize.width < screensize.width){
            framesize.width = screensize.width;
        }
        this.setLocation((screensize.width - framesize.width)/2, 
                (screensize.height - framesize.height)/2);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtJurusan = new javax.swing.JTextField();
        txtKdJur = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbJurusan = new javax.swing.JTable();
        lbRecord = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setClosable(true);
        setTitle(".: Form Jurusan");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Admin-Schoolar-Icon.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Input Date"));
        jPanel1.setOpaque(false);

        txtJurusan.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Jurusan :"));
        txtJurusan.setOpaque(false);
        txtJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJurusanActionPerformed(evt);
            }
        });

        txtKdJur.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Kode Jurusan :"));
        txtKdJur.setOpaque(false);
        txtKdJur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKdJurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtKdJur, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKdJur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Navigasi"));

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trans-add.png"))); // NOI18N
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save-black.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trans-hapus.png"))); // NOI18N
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tabel Data Jurusan : Klik 2x untuk mengubah / menghapus data"));

        tbJurusan.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tbJurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Kode Jurusan", "Jurusan"
            }
        ));
        tbJurusan.setRowHeight(22);
        tbJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbJurusanMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbJurusan);
        if (tbJurusan.getColumnModel().getColumnCount() > 0) {
            tbJurusan.getColumnModel().getColumn(1).setResizable(false);
        }

        lbRecord.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbRecord.setText("Record : 0");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Form Jurusan");

        jLabel4.setText("Form ini digunakan untuk mengubah data jurusan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJurusanActionPerformed

    private void txtKdJurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKdJurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKdJurActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        enableInput();
        txtKdJur.requestFocus(true);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        if(txtKdJur.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Kode jurusan harus di isi", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else if(txtJurusan.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Jurusan Harus di isi", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            aksiSimpan();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if(txtKdJur.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Anda Belum memililh ", "Informasi", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            aksiHapus();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tbJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbJurusanMouseClicked
        int brs = tbJurusan.getSelectedRow();
        vkd_jur = tbJurusan.getValueAt(brs, 0).toString();
        vjurusan = tbJurusan.getValueAt(brs, 1).toString();
        
        txtKdJur.setText(vkd_jur);
        txtJurusan.setText(vjurusan);
        enableInput();
        btnHapus.setEnabled(true);
        txtKdJur.setEnabled(false);
        btnSimpan.setText("Ubah");
        txtJurusan.requestFocus(true);
    }//GEN-LAST:event_tbJurusanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbRecord;
    private javax.swing.JTable tbJurusan;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtKdJur;
    // End of variables declaration//GEN-END:variables
}
