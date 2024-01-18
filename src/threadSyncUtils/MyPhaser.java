package threadSyncUtils;

import java.util.concurrent.Phaser;

/**
 * Created by kantipin on 16.05.2016.
 */
public class MyPhaser extends Phaser {
    @Override
    public boolean onAdvance(int phase, int numberOfParticipants) {
       switch(phase) {
           case(0) :
               return waitAllRegister();
           case(1) :
               return completeExercise(1);
           case(2) :
               return completeExercise(2);
           case(3) :
               return completeExercise(3);
           default :
               return true;
       }
    }

    private boolean waitAllRegister() {
        System.out.printf("Phaser: all students have arrived. Starting exam. Number of participants: %d\n", getRegisteredParties());
        return false;
    }

    private boolean completeExercise(int exam) {
        System.out.printf("Phaser: exercise %d completed\n", exam);
        if (exam < 3) {
            System.out.printf("Phaser: starting execution of exercise %d\n", exam+1);
            return false;
        } else {
            System.out.printf("Phaser: all tasks complete. Finishing exam.\n");
            return true;
        }
    }

}
