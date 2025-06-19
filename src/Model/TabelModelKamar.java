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
public class TabelModelKamar extends AbstractTableModel{

    List<Kamar> lk;
    
    public TabelModelKamar(List<Kamar> lk){
        this.lk = lk;
    }
    
    @Override
    public int getRowCount() {
        return lk.size();
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
                return "NomorKamar";
            case 2:
                return "TipeKamar";
            case 3:
                return "Harga";
            case 4:
                return "Status";
            default :
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return lk.get(rowIndex).getId();
            case 1:
                return lk.get(rowIndex).getNomorKamar();
            case 2:
                return lk.get(rowIndex).getTipeKamar();
            case 3:
                return lk.get(rowIndex).getHarga();
            case 4:
                return lk.get(rowIndex).getStatus();
            default :
                return null;
        }
    }
    
}
