/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Reservasi;
import java.util.List;

/**
 *
 * @author HUAWEI D15
 */
public interface IDAOReservasi {
    public void insert(Reservasi b);
    public void update(Reservasi b);
    public void delete(int id);
    public List<Reservasi> getAll();
    //public List<Reservasi> getCariNama(String nama);
}
