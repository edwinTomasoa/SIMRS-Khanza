package keuangan;
import fungsi.WarnaTable;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.var;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class DlgCashflow extends javax.swing.JDialog {
    private DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Jurnal jur=new Jurnal();
    private Connection koneksi=koneksiDB.condb();
    private ResultSet rs;

    /** Creates new form DlgProgramStudi */
    public DlgCashflow(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        Object[] row={"","",""};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbDokter.setModel(tabMode);

        tbDokter.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbDokter.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 3; i++) {
            TableColumn column = tbDokter.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(100);
            }else if(i==1){
                column.setPreferredWidth(440);
            }else if(i==2){
                column.setPreferredWidth(150);
            }
        }
        tbDokter.setDefaultRenderer(Object.class, new WarnaTable());       
       
     
    }
    private Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    private DecimalFormat df2 = new DecimalFormat("###,###,###,###,###,###,###");    
    private double kasawal=0,penerimaan=0,pengeluaran=0,total=0,debkred=0;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kd2 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        scrollPane1 = new widget.ScrollPane();
        tbDokter = new widget.Table();
        panelisi4 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        BtnCari = new widget.Button();
        panelisi1 = new widget.panelisi();
        BtnPrint = new widget.Button();
        label9 = new widget.Label();
        BtnKeluar = new widget.Button();

        Kd2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Kd2.setName("Kd2"); // NOI18N
        Kd2.setPreferredSize(new java.awt.Dimension(207, 23));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Cash Flow/Arus Kas ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(70, 70, 70))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        scrollPane1.setName("scrollPane1"); // NOI18N
        scrollPane1.setOpaque(true);

        tbDokter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDokter.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbDokter.setName("tbDokter"); // NOI18N
        scrollPane1.setViewportView(tbDokter);

        internalFrame1.add(scrollPane1, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Tanggal Transaksi /Posting Jurnal :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(210, 23));
        panelisi4.add(label11);

        Tgl1.setEditable(false);
        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(110, 23));
        panelisi4.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(30, 23));
        panelisi4.add(label18);

        Tgl2.setEditable(false);
        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(110, 23));
        panelisi4.add(Tgl2);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('1');
        BtnCari.setToolTipText("Alt+1");
        BtnCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelisi4.add(BtnCari);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(100, 56));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('P');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+P");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

        label9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label9.setName("label9"); // NOI18N
        label9.setPreferredSize(new java.awt.Dimension(305, 30));
        panelisi1.add(label9);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
/*
private void KdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TKdKeyPressed
    Valid.pindah(evt,BtnCari,Nm);
}//GEN-LAST:event_TKdKeyPressed
*/

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            Tgl1.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            
            Sequel.queryu("delete from temporary");
            int row=tabMode.getRowCount();
            for(int i=0;i<row;i++){  
                Sequel.menyimpan("temporary","'0','"+
                                tabMode.getValueAt(i,0).toString()+"','"+
                                tabMode.getValueAt(i,1).toString()+"','"+
                                tabMode.getValueAt(i,2).toString()+"','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''","Posting Jurnal"); 
            }
            
            Map<String, Object> param = new HashMap<>();
            param.put("namars",var.getnamars());
            param.put("alamatrs",var.getalamatrs());
            param.put("kotars",var.getkabupatenrs());
            param.put("propinsirs",var.getpropinsirs());
            param.put("kontakrs",var.getkontakrs());
            param.put("emailrs",var.getemailrs());
            param.put("logo",Sequel.cariGambar("select logo from setting")); 
            Valid.MyReport("rptCashFlow.jrxml","report","::[ Arus Kas/Cash Flow Perusahaan ]::",
                "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,Tgl2,BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,Tgl1);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        prosesCari();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, Tgl2, BtnPrint);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        prosesCari();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgCashflow dialog = new DlgCashflow(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCari;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.TextBox Kd2;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.InternalFrame internalFrame1;
    private widget.Label label11;
    private widget.Label label18;
    private widget.Label label9;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi4;
    private widget.ScrollPane scrollPane1;
    private widget.Table tbDokter;
    // End of variables declaration//GEN-END:variables

    private void prosesCari() {
       Valid.tabelKosong(tabMode);
       tabMode.addRow(new Object[]{"","",""});       
       try{   
            tabMode.addRow(new Object[]{"A. Kas Awal : ","",""});     
            tabMode.addRow(new Object[]{"","Rekening","Saldo Awal"});
            rs=koneksi.prepareStatement("select rekening.kd_rek, rekening.nm_rek, sum(rekeningtahun.saldo_awal) "+
                                           "from rekening inner join rekeningtahun "+
                                           "on rekening.kd_rek=rekeningtahun.kd_rek "+
                                           "where rekening.tipe='N' and rekening.balance='D' "+
                                           "and rekeningtahun.thn between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' "+
                                           "and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"' "+
                                           "group by rekening.kd_rek order by rekening.kd_rek").executeQuery();
            int i=1;
            kasawal=0;
            while(rs.next()){
                debkred=rs.getDouble(3)/*+Sequel.cariIsiAngka("select (sum(detailjurnal.debet)-sum(detailjurnal.kredit)) "+
                         "from jurnal inner join detailjurnal on detailjurnal.no_jurnal=jurnal.no_jurnal where "+
                         "detailjurnal.kd_rek='"+rs.getString(1)+"' and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+
                         "' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"'");                
                if(debkred<0){
                    debkred=debkred*(-1);
                }*/;
                
                kasawal=kasawal+debkred;
                if(!(debkred==0)){
                    tabMode.addRow(new Object[]{"",i+". "+rs.getString(1)+" "+rs.getString(2),df2.format(debkred)});  
                    i++;
                }                    
            }
            
            /*rs=koneksi.prepareStatement("select rekening.kd_rek, rekening.nm_rek, sum(rekeningtahun.saldo_awal) "+
                                           "from rekening inner join rekeningtahun "+
                                           "on rekening.kd_rek=rekeningtahun.kd_rek "+
                                           "where rekening.tipe='N' and rekening.balance='K' "+
                                           "and rekeningtahun.thn between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' "+
                                           "and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"' "+
                                           "group by rekening.kd_rek order by rekening.kd_rek").executeQuery();
            while(rs.next()){
                debkred=rs.getDouble(3)+Sequel.cariIsiAngka("select (sum(detailjurnal.kredit)-sum(detailjurnal.debet)) "+
                         "from jurnal inner join detailjurnal on detailjurnal.no_jurnal=jurnal.no_jurnal where "+
                         "detailjurnal.kd_rek='"+rs.getString(1)+"' and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+
                         "' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"'");
                if(debkred<0){
                    debkred=debkred*(-1);
                }
                
                kasawal=kasawal+debkred;
                tabMode.addRow(new Object[]{"",i+". "+rs.getString(2),df2.format(debkred)});   
                i++;
            }*/;
            tabMode.addRow(new Object[]{"","Jumlah Total Kas Awal : ",df2.format(kasawal)});
            
            //penerimaan kas
            tabMode.addRow(new Object[]{"","",""});
            tabMode.addRow(new Object[]{"B. Kas Masuk : ","",""}); 
            tabMode.addRow(new Object[]{"","Rekening","Kas Masuk"});
            i=1;
            penerimaan=0;
            rs=koneksi.prepareStatement("select detailjurnal.kd_rek, rekening.nm_rek,(sum(detailjurnal.kredit)-sum(detailjurnal.debet)) as ttlkredit "+
                                            " from jurnal inner join detailjurnal inner join rekening "+
                                            " on jurnal.no_jurnal=detailjurnal.no_jurnal "+
                                            " and detailjurnal.kd_rek=rekening.kd_rek "+
                                            " where rekening.tipe='R' and rekening.balance='K' "+
                                            " and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' "+
                                            " and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' "+
                                            " group by detailjurnal.kd_rek order by detailjurnal.kd_rek").executeQuery();            
            while(rs.next()){
                debkred=rs.getDouble(3)+Sequel.cariIsiAngka(
                        "select sum(rekeningtahun.saldo_awal) from rekeningtahun where rekeningtahun.kd_rek='"+rs.getString(1)+"' and rekeningtahun.thn "+
                        "between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"'");
                /*if(debkred<0){
                    debkred=debkred*(-1);
                }*/
                
                penerimaan=penerimaan+debkred;
                tabMode.addRow(new Object[]{"",i+". "+rs.getString(1)+" "+rs.getString(2),df2.format(debkred)});  
                i++;
            } 
            /*
            rs=koneksi.prepareStatement("select detailjurnal.kd_rek, rekening.nm_rek,(sum(detailjurnal.kredit)-sum(detailjurnal.debet)) as ttlkredit "+
                                            " from jurnal inner join detailjurnal inner join rekening "+
                                            " on jurnal.no_jurnal=detailjurnal.no_jurnal "+
                                            " and detailjurnal.kd_rek=rekening.kd_rek "+
                                            " where rekening.tipe='N' and rekening.balance='K' "+
                                            " and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' "+
                                            " and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' "+
                                            " group by detailjurnal.kd_rek order by detailjurnal.kd_rek").executeQuery();
            
            while(rs.next()){
                penerimaan=penerimaan+rs.getDouble(3)+Sequel.cariIsiAngka(
                        "select sum(rekeningtahun.saldo_awal) from rekeningtahun where rekeningtahun.kd_rek='"+rs.getString(1)+"' and rekeningtahun.thn "+
                        "between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"'");
                debkred=rs.getDouble(3)+Sequel.cariIsiAngka(
                        "select sum(rekeningtahun.saldo_awal) from rekeningtahun where rekeningtahun.kd_rek='"+rs.getString(1)+"' and rekeningtahun.thn "+
                        "between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"'");
                /*if(debkred<0){
                    debkred=debkred*(-1);
                }
                
                tabMode.addRow(new Object[]{"",i+". "+rs.getString(2),df2.format(debkred)});  
                i++;
            }*/
            
            tabMode.addRow(new Object[]{"","Jumlah Total Kas Masuk : ",df2.format(penerimaan)});
            
            //pengeluaran kas
            tabMode.addRow(new Object[]{"","",""});
            tabMode.addRow(new Object[]{"C. Kas Keluar : ","",""}); 
            tabMode.addRow(new Object[]{"","Rekening","Kas Keluar"});
            i=1;
            pengeluaran=0;
            rs=koneksi.prepareStatement("select detailjurnal.kd_rek, rekening.nm_rek,(sum(detailjurnal.debet)-sum(detailjurnal.kredit)) as ttldebet "+
                                            " from jurnal inner join detailjurnal inner join rekening "+
                                            " on jurnal.no_jurnal=detailjurnal.no_jurnal "+
                                            " and detailjurnal.kd_rek=rekening.kd_rek "+
                                            " where rekening.tipe='R' and rekening.balance='D' "+
                                            " and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' "+
                                            " and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' "+
                                            " group by detailjurnal.kd_rek order by detailjurnal.kd_rek").executeQuery();
            
            while(rs.next()){
                debkred=rs.getDouble(3)+Sequel.cariIsiAngka(
                        "select sum(rekeningtahun.saldo_awal) from rekeningtahun where rekeningtahun.kd_rek='"+rs.getString(1)+"' and rekeningtahun.thn "+
                        "between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"'");
                /*if(debkred<0){
                    debkred=debkred*(-1);
                }*/
                
                pengeluaran=pengeluaran+debkred;                
                tabMode.addRow(new Object[]{"",i+". "+rs.getString(1)+" "+rs.getString(2),df2.format(debkred)});  
                i++;
            } 
            
            /*rs=koneksi.prepareStatement("select detailjurnal.kd_rek, rekening.nm_rek,(sum(detailjurnal.debet)-sum(detailjurnal.kredit)) as ttldebet "+
                                            " from jurnal inner join detailjurnal inner join rekening "+
                                            " on jurnal.no_jurnal=detailjurnal.no_jurnal "+
                                            " and detailjurnal.kd_rek=rekening.kd_rek "+
                                            " where rekening.tipe='N' and rekening.balance='D' "+
                                            " and jurnal.tgl_jurnal between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"' "+
                                            " and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"' "+
                                            " group by detailjurnal.kd_rek order by detailjurnal.kd_rek").executeQuery();
            
            while(rs.next()){
                debkred=rs.getDouble(3)+Sequel.cariIsiAngka(
                        "select sum(rekeningtahun.saldo_awal) from rekeningtahun where rekeningtahun.kd_rek='"+rs.getString(1)+"' and rekeningtahun.thn "+
                        "between '"+Valid.SetTgl(Tgl1.getSelectedItem()+"").substring(0,4)+"' and '"+Valid.SetTgl(Tgl2.getSelectedItem()+"").substring(0,4)+"'");
                /*if(debkred<0){
                    debkred=debkred*(-1);
                }
                
                pengeluaran=pengeluaran+debkred;                
                tabMode.addRow(new Object[]{"",i+". "+rs.getString(2),df2.format(debkred)});  
                i++;
            } */
            tabMode.addRow(new Object[]{"","Jumlah Total Kas Keluar : ",df2.format(pengeluaran)});
            //total kas
            tabMode.addRow(new Object[]{"","",""});
            tabMode.addRow(new Object[]{">> Total Kas","A + ( B - C )  : ",""});      
            tabMode.addRow(new Object[]{"",df2.format(kasawal)+" + ( "+df2.format(penerimaan)+" - "+df2.format(pengeluaran)+" )  : ",df2.format(kasawal+penerimaan-pengeluaran)});
            tabMode.addRow(new Object[]{"","",""});
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        
    }
    
    public void isCek(){
        BtnPrint.setEnabled(var.getcashflow());
    }
     
 
}
