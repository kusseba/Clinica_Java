/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms_profecionales;

import Datos.Pacientes;
import Entidades.Paciente;
import miselaneos.FrmIntern;
import static Recepcion.FrmSistema.iconos;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author kusse
 */
public class FrmLocation extends FrmIntern {

    public static int id = 1;
    private DefaultTableModel modelo;
    private TableRowSorter<TableModel> orden;

    /**
     * Creates new form FrmLocalice
     */
    public FrmLocation() {
        initComponents();
    }
    
     private void _init() {
        modelo = new DefaultTableModel();
        modelo.addColumn("#");
        modelo.addColumn("id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Afecciones");
        jTable.setModel(modelo);
    }
     
    private void _cargarPacientes(){
        ArrayList<Pacientes> pacientesList = new ArrayList<Pacientes>();
        Pacientes cnxPacientes = new Pacientes();
        if(cnxPacientes.isokConexion()) {
            pacientesList = cnxPacientes.listarPacientes("SELECT * FROM Pacientes order by id");
            
            cnxPacientes.isCerrarConexion();
        }
        
        modelo.setRowCount(0);
        
        for(int index = 0; index <  pacientesList.size(); index++) {
            Pacientes p = pacientesList.get(index);
            modelo.addRow(p.toObject());
        }
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCentro = new javax.swing.JPanel();
        pnlCentroGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblFilter1 = new etiquetas.LblFilter();
        txtFilter = new texto.TxtMayusculas();
        btnRefresh1 = new botones.BtnRefresh();
        pnlLocalition = new javax.swing.JPanel();
        id1 = new etiquetas.Id();
        txtNro = new texto.TxtNro();
        lbl1 = new etiquetas.Lbl();
        txtLocalidad = new texto.TxtMayusculas();
        pnlButton = new javax.swing.JPanel();
        btnNew1 = new botones.BtnNew();
        btnDelete1 = new botones.BtnDelete();
        btnEdit1 = new botones.BtnEdit();
        lbl2 = new etiquetas.Lbl();
        lbl3 = new etiquetas.Lbl();
        txtLocalidad1 = new texto.TxtMayusculas();
        txtLocalidad2 = new texto.TxtMayusculas();
        txtLocalidad3 = new texto.TxtMayusculas();

        setTitle("Historia Clinica");
        setFrameIcon(iconos.getLocation(16)
        );
        getContentPane().setLayout(new java.awt.BorderLayout());

        pnlCentro.setLayout(new java.awt.BorderLayout());

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable);

        jPanel1.setPreferredSize(new java.awt.Dimension(384, 40));

        txtFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFilter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout pnlCentroGridLayout = new javax.swing.GroupLayout(pnlCentroGrid);
        pnlCentroGrid.setLayout(pnlCentroGridLayout);
        pnlCentroGridLayout.setHorizontalGroup(
            pnlCentroGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroGridLayout.createSequentialGroup()
                .addGroup(pnlCentroGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCentroGridLayout.setVerticalGroup(
            pnlCentroGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroGridLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pnlCentro.add(pnlCentroGrid, java.awt.BorderLayout.CENTER);

        pnlLocalition.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Paciente"));
        pnlLocalition.setPreferredSize(new java.awt.Dimension(330, 361));

        lbl1.setText("Nombre:");

        pnlButton.add(btnNew1);
        pnlButton.add(btnDelete1);
        pnlButton.add(btnEdit1);

        lbl2.setText("Edad:");

        lbl3.setText("Afecciones:");

        javax.swing.GroupLayout pnlLocalitionLayout = new javax.swing.GroupLayout(pnlLocalition);
        pnlLocalition.setLayout(pnlLocalitionLayout);
        pnlLocalitionLayout.setHorizontalGroup(
            pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
            .addGroup(pnlLocalitionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLocalitionLayout.createSequentialGroup()
                        .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlLocalitionLayout.createSequentialGroup()
                        .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLocalidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLocalitionLayout.setVerticalGroup(
            pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLocalitionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(txtLocalidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlLocalitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pnlCentro.add(pnlLocalition, java.awt.BorderLayout.LINE_END);

        getContentPane().add(pnlCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private botones.BtnDelete btnDelete1;
    private botones.BtnEdit btnEdit1;
    private botones.BtnNew btnNew1;
    private botones.BtnRefresh btnRefresh1;
    private etiquetas.Id id1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private etiquetas.Lbl lbl1;
    private etiquetas.Lbl lbl2;
    private etiquetas.Lbl lbl3;
    private etiquetas.LblFilter lblFilter1;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlCentroGrid;
    private javax.swing.JPanel pnlLocalition;
    private texto.TxtMayusculas txtFilter;
    private texto.TxtMayusculas txtLocalidad;
    private texto.TxtMayusculas txtLocalidad1;
    private texto.TxtMayusculas txtLocalidad2;
    private texto.TxtMayusculas txtLocalidad3;
    private texto.TxtNro txtNro;
    // End of variables declaration//GEN-END:variables
}
