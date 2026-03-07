package com.capgi.dao;

import com.capgi.entity.Player;
import com.capgi.repository.PlayerRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements playerDAO{
    @Override
    public void insertPlayer(Player player) {
        String sql = "INSERT INTO player VALUES(?,?,?)";
        try(Connection conn = PlayerRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,player.getPlayerid());
            pstmt.setString(2,player.getPlayername());
            pstmt.setString(3, player.getPlayercountry());

            pstmt.executeUpdate();
            System.out.println("Player Inserted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePlayer(Player player) {
        String sql="UPDATE player SET playername=? ,playercountry=? WHERE playerid=?";
        try(Connection conn = PlayerRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1, player.getPlayername());
            pstmt.setString(2, player.getPlayercountry());
            pstmt.setInt(3, player.getPlayerid());

            int row= pstmt.executeUpdate();
            System.out.println("Player Updated");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deletePlayer(int playerId) {
        String sql="DELETE FROM player WHERE playerId=?";
        try(Connection conn = PlayerRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1,playerId);
            int rowsDeleted = pstmt.executeUpdate();
            System.out.println("row deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Player> getAllPlayer() {
        String sql = "SELECT * FROM player";
        List<Player> PlayerList = new ArrayList<>();
        try(Connection conn = PlayerRepository.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("playerId");
                String name = rs.getString("playername");
                String country = rs.getString("playercountry");
                Player player = new Player(id, name, country);

                PlayerList.add(player);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return PlayerList;
    }
}
