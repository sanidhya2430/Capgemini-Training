package batchprocessing.dao;

import batchprocessing.entity.Player;

import java.sql.SQLException;
import java.util.List;

public interface PlayerDAO {
    void insertBatch(List<Player> player)throws SQLException;
    void updateBatch(List<Player> player)throws SQLException;
    void deleteBatch(List<Integer> player)throws SQLException;
    List<Player> FetchAll() throws SQLException;
}
