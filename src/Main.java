
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import jeopardygame.JeopardyHUD;
import jeopardygame.JeopardyHUDController;
import jeopardyhost.JeopardyHostController;
import jeopardyplayer.JeopardyPlayerController;
import jeopardyserver.JeopardyServerController;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mac
 */
public class Main {
    public static void main(String[] args)
    {
        JeopardyServerController serverC = new JeopardyServerController();
        JeopardyHostController hostC = new JeopardyHostController();
        hostC.connectToServer();
        JeopardyPlayerController player1C = new JeopardyPlayerController();
        player1C.startSignin();
        JeopardyPlayerController player2C = new JeopardyPlayerController();
        player2C.startSignin();
        JeopardyPlayerController player3C = new JeopardyPlayerController();
        player3C.startSignin();
        //JeopardyPlayerController player2C = new JeopardyPlayerController(serverC);
//        JeopardyPlayerController player3C = new JeopardyPlayerController(serverC);

        JeopardyHUDController hud = new JeopardyHUDController();
        hud.connect();


    }
}
