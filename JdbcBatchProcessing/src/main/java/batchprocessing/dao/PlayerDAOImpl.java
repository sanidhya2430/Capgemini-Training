package batchprocessing.dao;

import batchprocessing.entity.Player;
import batchprocessing.repository.PlayerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO{
    @Override
    public void insertBatch(List<Player> player) throws SQLException {
        Connection connection= PlayerRepository.getConnection();
        String insertQ = "INSERT INTO player VALUES(?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(insertQ);

        for(Player p:player){
            stmt.setInt(1,p.getPlayerid());
            stmt.setString(2,p.getPlayername());
            stmt.setString(3,p.getPlayercountry());
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("inserted rows " + result.length);
    }

    @Override
    public void updateBatch(List<Player> player) throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String updateQ = "UPDATE player SET playername=?,playercountry=? WHERE playerId = ?";
        PreparedStatement stmt = connection.prepareStatement(updateQ);

        for(Player p:player){
            stmt.setString(1,p.getPlayername());
            stmt.setString(2, p.getPlayercountry());
            stmt.setInt(3,p.getPlayerid());
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("updated rows" + result.length);

    }

    @Override
    public void deleteBatch(List<Integer> player) throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        String deleteQ = "DELETE FROM player WHERE playerid=?";
        PreparedStatement stmt= connection.prepareStatement(deleteQ);
        for(Integer p:player){
            stmt.setInt(1,p);
            stmt.addBatch();
        }
        int[] result = stmt.executeBatch();
        System.out.println("delete rows" + result.length);

    }

    @Override
    public List<Player> FetchAll() throws SQLException {
        Connection connection = PlayerRepository.getConnection();
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM player";
        PreparedStatement stmt= connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("playerid");
            String name = rs.getString("playername");
            String country = rs.getString("playercountry");
            Player player=new Player(id,name,country);
            list.add(player);
        }

        return list;
    }
}
