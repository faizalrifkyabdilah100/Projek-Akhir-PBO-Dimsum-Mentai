/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOTamu;
import DAOInterface.IDAOTamu;
import Model.TabelModelTamu;
import Model.Tamu;
import View.FormUserTamu;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HUAWEI D15
 */
public class ControllerFormUserTamu {
    FormUserTamu frame;
    IDAOTamu implTamu;
    List<Tamu> lt;

    
public ControllerFormUserTamu(FormUserTamu frame){
    this.frame = frame;
    implTamu = new DAOTamu();
    lt = implTamu.getAll();
}
    
    //mengosongkan field
public void reset() {
    frame.getTxtID().setText("");
    frame.getTxtNama().setText("");
    frame.getTxtEmail().setText("");
    frame.getTxtNoTelepon().setText("");
    frame.getTxtAlamat().setText("");
}


public void isiTable() {
    lt = implTamu.getAll();
    TabelModelTamu tmb = new TabelModelTamu(lt);
    frame.getTableData().setModel(tmb);
}

public void isiField(int row){
    frame.getTxtID().setText(Integer.toString(lt.get(row).getId()));
    frame.getTxtNama().setText(lt.get(row).getNama());
    frame.getTxtEmail().setText(lt.get(row).getEmail());
    frame.getTxtNoTelepon().setText(lt.get(row).getNoTelepon());
    frame.getTxtAlamat().setText(lt.get(row).getAlamat());
}

public void insert() {
    if (!frame.getTxtNama().getText().trim().isEmpty()& !frame.getTxtEmail().getText().trim().isEmpty() & !frame.getTxtNoTelepon().getText().trim().isEmpty()) {
        Tamu b = new Tamu();
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        b.setNama(frame.getTxtNama().getText());
        b.setEmail(frame.getTxtEmail().getText());
        b.setNoTelepon(frame.getTxtNoTelepon().getText());
        b.setAlamat(frame.getTxtAlamat().getText());
        implTamu.insert(b);
        JOptionPane.showMessageDialog(null, "Simpan Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
    }
}
public void refresh(){
    reset();
    isiTable();
}
public void delete() {
    if (!frame.getTxtID().getText().trim().isEmpty()) {
        int id = Integer.parseInt(frame.getTxtID().getText());
        implTamu.delete(id);
        JOptionPane.showMessageDialog(null, "Hapus Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
    }
}
public void isiTableCariNama(){
    lt = implTamu.getCariNama(frame.getTxtCariNama().getText());
    TabelModelTamu tmb = new TabelModelTamu(lt);
    frame.getTableData().setModel(tmb);
}
public void carinama() {
    if (!frame.getTxtCariNama().getText().trim().isEmpty()) {
    implTamu.getCariNama(frame.getTxtCariNama().getText());
    isiTableCariNama();
} else{
    JOptionPane.showMessageDialog(frame, "Silahkan Pilih Data");
}
}




}

