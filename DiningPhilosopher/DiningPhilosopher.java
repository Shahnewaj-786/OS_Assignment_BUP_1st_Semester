public class DiningPhilosopher {

    static class Fork {

    }

    static class Philosopher extends Thread {

        Fork left;
        Fork right;


        public Philosopher(Fork left, Fork right){
            this.left = left;
            this.right = right;
            //start();
        }


        public void run(){
            //think!
            synchronized (left){
                synchronized (right){
                    //eat!
                }
            }
        }

    }


    static int nPhilosophers = 6;

    public static void main (String[] arg) {
        if (arg.length>0){
            nPhilosophers = Integer.parseInt(arg[0])
        }

        //Verify.beginAtomic();
        Fork[] forks = new Fork[nPhilosophers];
        for (int i = 0; i<nPhilosophers; i++){
            forks[i] = new Fork();
        }
        for (int i=0; i < nPhilosophers; i++){
            Philosopher p = new Philosopher(forks[i], forks[(i+1) % nPhilosophers]);
            p.start();
        }
        //verify.endAtomic();
    }
}
