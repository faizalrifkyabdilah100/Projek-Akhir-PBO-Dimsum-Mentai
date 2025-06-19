/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOTamu;
import DAOInterface.IDAOTamu;
import Model.TabelModelTamu;
import Model.Tamu;
import View.HomeAdmin;
import java.util.List;

/**
 *
 * @author HUAWEI D15
 */
public class ControllerHomeAdmin {
    HomeAdmin frameT;
    IDAOTamu implTamu;
    List<Tamu> lt;

    
public ControllerHomeAdmin(HomeAdmin frameT){
    this.frameT = frameT;
    implTamu = new DAOTamu();
    lt = implTamu.getAll();
    
}   


public void isiTableTamu() {
    lt = implTamu.getAll();
    TabelModelTamu tmb = new TabelModelTamu(lt);
    frameT.getTableData().setModel(tmb);
}    
}
