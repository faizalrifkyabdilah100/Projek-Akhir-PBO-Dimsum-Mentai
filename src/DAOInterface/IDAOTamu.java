/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Tamu;
import java.util.List;

/**
 *
 * @author HUAWEI D15
 */
public interface IDAOTamu {
    public void insert(Tamu b);
    public void update(Tamu b);
    public void delete(int id);
    public List<Tamu> getAll();
    public List<Tamu> getCariNama(String nama);
}
