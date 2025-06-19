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
public class TabelModelTamu extends AbstractTableModel{
    
    List<Tamu> lt;
    
    public TabelModelTamu(List<Tamu> lt){
        this.lt = lt;
    }
    
    @Override
    public int getRowCount() {
        return lt.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Email";
            case 3:
                return "No Telepon";
            case 4:
                return "Alamat";
            default :
                return null;
        }
    }
        
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch (columnIndex){
            case 0:
                return lt.get(rowIndex).getId();
            case 1:
                return lt.get(rowIndex).getNama();
            case 2:
                return lt.get(rowIndex).getEmail();
            case 3:
                return lt.get(rowIndex).getNoTelepon();
            case 4:
                return lt.get(rowIndex).getAlamat();
            default :
                return null;
        }
    }
    
}
