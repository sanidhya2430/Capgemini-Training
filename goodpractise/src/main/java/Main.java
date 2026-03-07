import com.capgi.dao.PlayerDAOImpl;
import com.capgi.dao.playerDAO;
import com.capgi.entity.Player;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        playerDAO dao = new PlayerDAOImpl();

        //INSERT
        // dao.insertPlayer(new Player(18,"virat","INDIA"));
        //dao.updatePlayer(new Player(18,"messi","argentina"));
        //dao.deletePlayer(7);
        List<Player> player = dao.getAllPlayer();

        for(Player p:player){
            System.out.println(p);
        }
    }
}
