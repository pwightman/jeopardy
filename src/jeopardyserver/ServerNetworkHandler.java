/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jeopardyserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author parkerwightman
 */
public class ServerNetworkHandler implements Runnable {

  ServerSocket socket;
  JeopardyServerController controller;
  JeopardyServerHostHandler hostHandler;
  JeopardyServerHUDHandler hudHandler;
  public int Id;
  HashMap<Integer, JeopardyServerPlayerHandler> playerSockets;

  public ServerNetworkHandler(JeopardyServerController controller) {
    playerSockets = new HashMap<Integer, JeopardyServerPlayerHandler>(3);
    this.controller = controller;

  }

  public void run() {
    try {
      socket = new ServerSocket(3366);
      System.out.println("Ready...");
      while (true) {
        Socket temp = socket.accept();
        System.out.println("Connection accepted");
        signin(temp);
      }
    } catch (IOException ex) {
      Logger.getLogger(ServerNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public JeopardyServerPlayerHandler getPlayerHandler(int id) {
    return playerSockets.get(id);
  }

  public void signin(Socket s) {
    BufferedReader reader = null;
    try {

      reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
      System.out.println("Reading from socket on server...");
      int signIn = Integer.parseInt(reader.readLine());
      System.out.println("Read singin");
      System.out.println(signIn);
      if (signIn == JeopardyProtocol.SIGNIN) {
        String type = reader.readLine();
        
        if (type.equals("host")) {
          System.out.println("Setup host socket");
          hostHandler = new JeopardyServerHostHandler(s, controller, reader);
          Thread t = new Thread(hostHandler);
          t.start();
        } 
        else if (type.equals("player")) {
          String name = reader.readLine();
          int id = controller.addPlayer(name);
          //controller.ad
          JeopardyServerPlayerHandler player = new JeopardyServerPlayerHandler(s, controller, reader, id);
          playerSockets.put(id, player);
          new Thread(player).start();
          System.out.println("Setup player socket");
        } 
        else if (type.equals("hud")) {
          hudHandler = new JeopardyServerHUDHandler(s, controller, reader);
          new Thread(hudHandler).start();
          System.out.println("HUD Connected");
        } else {
          System.out.println("Bad parameter sent for signin");
        }
      } else if (signIn == JeopardyProtocol.RECONNECT){
        
      }
    } catch (IOException ex) {
      Logger.getLogger(ServerNetworkHandler.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public JeopardyServerHUDHandler getHUDHandler() {
    return hudHandler;
  }

  public JeopardyServerHostHandler getHostHandler() {
    return hostHandler;
  }
}
