/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Kamar;
import java.util.List;

/**
 *
 * @author HUAWEI D15
 */
public interface IDAOKamar {
    public void insert(Kamar b);
    public void update(Kamar b);
    public void delete(int id);
    public List<Kamar> getAll();
    public List<Kamar> getCariNama(String nama);
}
