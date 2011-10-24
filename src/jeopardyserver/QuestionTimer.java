/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jeopardyserver;

import java.util.TimerTask;

/**
 *
 * @author parkerwightman
 */
public class QuestionTimer extends TimerTask{

    boolean buzzer;
    JeopardyServerController controller;

    public QuestionTimer(JeopardyServerController controller, boolean buzzer)
    {
        this.buzzer = buzzer;
        this.controller = controller;
    }

    @Override
    public void run() {
        if(buzzer)
        {
            controller.buzzerTimerRanOut();
        }
        else
        {
             controller.questionTimerRanOut();
        }
    }

}
