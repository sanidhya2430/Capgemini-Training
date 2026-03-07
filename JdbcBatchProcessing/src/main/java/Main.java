import batchprocessing.dao.PlayerDAO;
import batchprocessing.dao.PlayerDAOImpl;
import batchprocessing.entity.Player;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        PlayerDAO dao = new PlayerDAOImpl();

//        List<Player> insertplayer = Arrays.asList(
//                new Player(333,"Gayle","West Indies"),
//                new Player(7,"thala","india"),
//                new Player(45,"rohit","india")
//        );
//        dao.insertBatch(insertplayer);
//        List<Player> updateplayer = Arrays.asList(
//                new Player(18,"virat","india"),
//                new Player(45,"hitman","india")
//        );
//        dao.updateBatch(updateplayer);
//        List<Integer> deleteplayer = Arrays.asList(
//                10,18
//        );
//        dao.deleteBatch(deleteplayer);
        List<Player> player = dao.FetchAll();
        for (Player p :player){
            System.out.println(p);
        }


    }
}
