/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOKamar;
import DAOInterface.IDAOKamar;
import Model.Kamar;
import Model.TabelModelKamar;
import View.FormUserKamar;
import java.util.List;
/**
 *
 * @author HUAWEI D15
 */
public class ControllerUserKamar {
    FormUserKamar frameK;
    IDAOKamar implKamar;
    List<Kamar> lk;
    
public ControllerUserKamar(FormUserKamar frameK){
    this.frameK = frameK;
    implKamar = new DAOKamar();
    lk = implKamar.getAll();
}

public void isiTableKamar() {
    lk = implKamar.getAll();
    TabelModelKamar tmb = new TabelModelKamar(lk);
    frameK.getTableDataKamar().setModel(tmb);
}    
}
