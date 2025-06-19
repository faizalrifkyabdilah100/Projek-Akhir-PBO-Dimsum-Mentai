/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author HUAWEI D15
 */
public class TabelModelReservasi extends AbstractTableModel{
    
    List<Reservasi> lr;
    
    public TabelModelReservasi(List<Reservasi> lr){
        this.lr = lr;
    }

    @Override
    public int getRowCount() {
        return lr.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "ID Tamu";
            case 2:
                return "No Kamar";
            case 3:
                return "Tanggal Check-In";
            case 4:
                return "Tanggal Check-Out";
            case 5:
                return "Status";
            default :
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lr.get(rowIndex).getId();
            case 1:
                return lr.get(rowIndex).getGuestID();
            case 2:
                return lr.get(rowIndex).getRoomID();
            case 3:
                return lr.get(rowIndex).getCheckIn();
            case 4:
                return lr.get(rowIndex).getCheckOut();
            case 5:
                return lr.get(rowIndex).getStatus();
            default:
            return null;
        }
    }
    
}
