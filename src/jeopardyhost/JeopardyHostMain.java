/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyhost;

/**
 *
 * @author parkerwightman
 */
public class JeopardyHostMain {

    public static void main(String[] args)
    {
        JeopardyHostController hostC = new JeopardyHostController();
        hostC.connectToServer();
    }
}
