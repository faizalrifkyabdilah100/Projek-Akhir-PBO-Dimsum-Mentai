/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOReservasi;
import DAOInterface.IDAOReservasi;
import Model.Reservasi;
import Model.TabelModelReservasi;
import View.FormAdminReservasi;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HUAWEI D15
 */
public class ControllerFormAdminReservasi {
    FormAdminReservasi frame;
    IDAOReservasi implReservasi;
    List<Reservasi> lr;
    
    public ControllerFormAdminReservasi(FormAdminReservasi frame){
    this.frame = frame;
    implReservasi = new DAOReservasi();
    lr = implReservasi.getAll();
}
    
    public void reset() {
    frame.getTxtID().setText("");
    frame.getTxtGuestID().setSelectedItem("");
    frame.getTxtRoomID().setSelectedItem("");
    frame.getTxtCheckIn().setText("");
    frame.getTxtCheckOut().setText("");
    frame.getTxtStatus().setSelectedItem("");
}
    public void isiTable() {
    lr = implReservasi.getAll();
    TabelModelReservasi tmb = new TabelModelReservasi(lr);
    frame.getTableData().setModel(tmb);
}
    
public void isiField(int row){
    frame.getTxtID().setText(Integer.toString(lr.get(row).getId()));
    frame.getTxtGuestID().setSelectedItem(Integer.toString(lr.get(row).getGuestID()));
    frame.getTxtRoomID().setSelectedItem(Integer.toString(lr.get(row).getRoomID()));
    frame.getTxtCheckIn().setText(lr.get(row).getCheckIn());
    frame.getTxtCheckOut().setText(lr.get(row).getCheckOut());
    frame.getTxtStatus().setSelectedItem(lr.get(row).getStatus());
}


public void insert() {
    if (!frame.getTxtID().getText().trim().isEmpty() && !frame.getTxtGuestID().getSelectedItem().toString().trim().isEmpty() && !frame.getTxtRoomID().getSelectedItem().toString().trim().isEmpty()) {
        Reservasi b = new Reservasi();
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        b.setGuestID(Integer.parseInt((String) frame.getTxtGuestID().getSelectedItem()));
        b.setRoomID(Integer.parseInt((String) frame.getTxtRoomID().getSelectedItem()));
        b.setCheckIn(frame.getTxtCheckIn().getText());
        b.setCheckOut(frame.getTxtCheckOut().getText());
        b.setStatus((String) frame.getTxtStatus().getSelectedItem());
        implReservasi.insert(b);
        JOptionPane.showMessageDialog(null, "Simpan Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
    }
}

public void update(){
    if (!frame.getTxtID().getText().trim().isEmpty()) {
        Reservasi b = new Reservasi();
        b.setGuestID(Integer.parseInt((String) frame.getTxtGuestID().getSelectedItem()));
        b.setRoomID(Integer.parseInt((String) frame.getTxtRoomID().getSelectedItem()));
        b.setCheckIn(frame.getTxtCheckIn().getText());
        b.setCheckOut(frame.getTxtCheckOut().getText());
        b.setStatus((String) frame.getTxtStatus().getSelectedItem());
        b.setId(Integer.parseInt(frame.getTxtID().getText()));
        implReservasi.update(b);
        JOptionPane.showMessageDialog(null, "Update data sukses");
        
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
    }
}

public void refresh(){
    reset();
    isiTable();
}
public void delete() {
    if (!frame.getTxtID().getText().trim().isEmpty()) {
        int id = Integer.parseInt(frame.getTxtID().getText());
        implReservasi.delete(id);
        JOptionPane.showMessageDialog(null, "Hapus Data Sukses");
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
    }
}
}
