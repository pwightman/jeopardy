/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.util.HashMap;

/**
 *
 * @author parkerwightman
 */
 public class JeopardyProtocol {

   private HashMap<String,Integer> protocols;
     public static int STOPBUZZING = 0;
     public static int FILEINFO = 1;
     public static int CHOOSEQUESTION = 2;
     public static int READYNEXT = 3;
     public static int ANSWERED = 4;
     public static int BEGINBUZZING = 5;
     public static int PLAYMUSIC = 6;
     public static int CHANGESCORE = 7;
     public static int SIGNIN = 8;
     public static int SIGNEDIN = 9;
     public static int BUZZIN = 10;
     public static int SENDBOARD = 11;
     public static int SCORE = 12;
     public static int ENDBUZZING = 13;
     public static int DAILYDOUBLE = 14;
     public static int DISPLAYDAILYDOUBLE = 15;
     public static int PLAYTIMEROUTSOUND = 16;
     public static int THINKING = 17;
     public static int RECONNECT = 18;

   // Private constructor prevents instantiation from other classes
   private JeopardyProtocol() {
       protocols = new HashMap<String,Integer>();
//       protocols.put("stopbuzz", STOPBUZZING);
//       protocols.put("fileinfo", FILEINFO);
//       protocols.put("fileinfo", FILEINFO);
//       protocols.put("fileinfo", FILEINFO);
//       protocols.put("fileinfo", FILEINFO);
//       protocols.put("fileinfo", FILEINFO);
//       protocols.put("fileinfo", FILEINFO);
   }

   /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance()
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
   private static class SingletonHolder {
     public static final JeopardyProtocol INSTANCE = new JeopardyProtocol();
   }

   public static HashMap<String,Integer> getInstance() {
     return SingletonHolder.INSTANCE.protocols;
   }

 }

