/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOReservasi;
import Koneksi.Koneksi;
import Model.Reservasi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HUAWEI D15
 */
public class DAOReservasi implements IDAOReservasi{
    
    Connection connection;
    final String insert = "INSERT INTO reservation (id, guest_id, room_id,tanggalCheckIn, tanggalCheckOut, status) VALUES (?, ?, ?, ?,?,?);";
    final String update = "UPDATE reservation set guest_id=?, room_id=?, tanggalCheckIn=?, tanggalCheckOut=?, status=? where id=? ;";
    final String delete = "DELETE FROM reservation where id=? ;";
    final String select = "SELECT * FROM reservation";
    //final String carinama = "SELECT * FROM reservation where nama like ?";
    
    public DAOReservasi(){
        connection = Koneksi.connection();
    }

    @Override
    public List<Reservasi> getAll() {
        List<Reservasi> lt = null;
        try {
            lt = new ArrayList<Reservasi>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Reservasi b = new Reservasi();
                b.setId(rs.getInt("Id"));
                b.setGuestID(rs.getInt("guest_id"));
                b.setRoomID(rs.getInt("room_id"));
                b.setCheckIn(rs.getString("tanggalCheckIn"));
                b.setCheckOut(rs.getString("tanggalCheckOut"));
                b.setStatus(rs.getString("status"));
                lt.add(b);
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAOReservasi.class.getName()).log(Level.SEVERE, null, ex);
        
    }
        return lt;
    }

    @Override
    public void insert(Reservasi b) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, b.getId());
            statement.setInt(2, b.getGuestID());
            statement.setInt(3, b.getRoomID());
            statement.setString(4, b.getCheckIn());
            statement.setString(5, b.getCheckOut());
            statement.setString(6, b.getStatus());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                b.setId(rs.getInt(1));
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                statement.close();
        } catch (SQLException ex) {
            System.out.println("Gaagal Input");
        }
        }
    }

    @Override
    public void update(Reservasi b) {
        PreparedStatement statement = null;
        try {
        statement = connection.prepareStatement(update);
        statement.setInt(1, b.getGuestID());
        statement.setInt(2, b.getRoomID());
        statement.setString(3, b.getCheckIn());
        statement.setString(4, b.getCheckOut());
        statement.setString(5, b.getStatus());
        statement.setInt(6, b.getId());
        statement.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Berhasil update");
    } finally {
        try{
            statement.close();
        } catch (SQLException ex){
            System.out.println("Gagal input");
        }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("berhasil delete");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("gagal Update");
            }
        }
    }
    

    /*@Override
    public List<Reservasi> getCariNama(String nama) {
        List<Reservasi> lt = null;
        try {
            lt = new ArrayList<Reservasi>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reservasi b = new Reservasi();
                b.setId(rs.getInt("Id"));
                b.setNama(rs.getString("Nama"));
                b.setEmail(rs.getString("Email"));
                b.setNoTelepon(rs.getString("Telepon"));
                b.setAlamat(rs.getString("Alamat"));
                lt.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTamu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lt;
    }*/
}
