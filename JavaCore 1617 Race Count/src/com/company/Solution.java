package com.company;

/*

1617 Race countdown
1. Understand what the program does.
2. Implement the logic of the run method so that every second through a space
a count was issued starting with countSeconds to 1, and then the word [March!] (see examples).
3. If the thread is running for 3.5 seconds or more, interrupt it with the interrupt method and display the word [Interrupted!] Inside the thread.
Example for countSeconds = 4:
"4 3 2 1 Interrupted!"
4. If the thread runs for less than 3.5 seconds, it must end on its own.
Example for countSeconds = 3:
"3 2 1 March!"
PS: sleep method throws InterruptedException.

Requirements:
1. The racing method of the RacingClock class must contain a loop.
2. A RacingClock class object must decrease the countSeconds variable by one every second.
3. The main method should call Thread.sleep (3500).
4. The main method should call the interrupt method on the clock object.
5. If countSeconds is 3, then the program should output "3 2 1 March!".
6. If countSeconds is 4, then the program should output "4 3 2 1 Interrupted!".


 */

import java.util.ArrayList;
import java.util.List;

/*
Horse Racing
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (1 <= countSeconds) {
                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                }
            } catch (InterruptedException e) {
                System.out.println("Прервано!");
                return;
            }
            System.out.println("Марш!");
        }
    }
}


