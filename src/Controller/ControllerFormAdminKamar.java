/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOKamar;
import DAOInterface.IDAOKamar;
import Model.TabelModelKamar;
import Model.Kamar;
import View.FormAdminKamar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HUAWEI D15
 */
public class ControllerFormAdminKamar {
    FormAdminKamar frame;
    IDAOKamar implKamar;
    List<Kamar> lk;

    
public ControllerFormAdminKamar (FormAdminKamar frame){
    this.frame = frame;
    implKamar = new DAOKamar();
    lk = implKamar.getAll();
}
    
    //mengosongkan field
public void reset() {
    frame.getTxtID().setText("");
    frame.getTxtNomorKamar().setText("");
    frame.getTxtTipeKamar().setText("");
    frame.getTxtHarga().setText("");
    frame.getTxtStatus().setSelectedItem("");
}


public void isiTable() {
    lk = implKamar.getAll();
    TabelModelKamar tmb = new TabelModelKamar(lk);
    frame.getTableData().setModel(tmb);
}

public void isiField(int row){
    frame.getTxtID().setText(Integer.toString(lk.get(row).getId()));
    frame.getTxtNomorKamar().setText(lk.get(row).getNomorKamar());
    frame.getTxtTipeKamar().setText(lk.get(row).getTipeKamar());
    frame.getTxtHarga().setText(lk.get(row).getHarga());
    frame.getTxtStatus().setSelectedItem(lk.get(row).getStatus());
}

public void insert() {
    if (!frame.getTxtID().getText().trim().isEmpty()& !frame.getTxtNomorKamar().getText().trim().isEmpty() & !frame.getTxtHarga().getText().trim().isEmpty()) {
        Kamar b = new Kamar();
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        b.setNomorKamar(frame.getTxtNomorKamar().getText());
        b.setTipeKamar(frame.getTxtTipeKamar().getText());
        b.setHarga(frame.getTxtHarga().getText());
        b.setStatus((String) frame.getTxtStatus().getSelectedItem());
        implKamar.insert(b);
        JOptionPane.showMessageDialog(null, "Simpan Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
    }
}
public void refresh(){
    reset();
    isiTable();
}

public void update(){
    if (!frame.getTxtID().getText().trim().isEmpty()) {
        Kamar b = new Kamar();
        b.setNomorKamar(frame.getTxtNomorKamar().getText());
        b.setTipeKamar(frame.getTxtTipeKamar().getText());
        b.setHarga(frame.getTxtHarga().getText());
        b.setStatus((String) frame.getTxtStatus().getSelectedItem());
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        implKamar.update(b);
        JOptionPane.showMessageDialog(null, "Update data sukses");
        
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
    }
}

public void delete() {
    if (!frame.getTxtID().getText().trim().isEmpty()) {
        int id = Integer.parseInt(frame.getTxtID().getText());
        implKamar.delete(id);
        JOptionPane.showMessageDialog(null, "Hapus Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
    }
}

public void isiTableCariNama(){
    lk = implKamar.getCariNama(frame.getTxtCariNama().getText());
    TabelModelKamar tmb = new TabelModelKamar(lk);
    frame.getTableData().setModel(tmb);
}

public void cariKamar() {
    if (!frame.getTxtCariNama().getText().trim().isEmpty()) {
    implKamar.getCariNama(frame.getTxtCariNama().getText());
    isiTableCariNama();
} else{
    JOptionPane.showMessageDialog(frame, "Silahkan Pilih Data");
}
}
}
