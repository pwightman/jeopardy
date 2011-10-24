/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardygame;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author parkerwightman
 */
public class MusicPlayer implements Runnable{

    File file;

    public MusicPlayer(File filename)
    {
        file = filename;
    }

    public void run()
    {
        
    }
}
