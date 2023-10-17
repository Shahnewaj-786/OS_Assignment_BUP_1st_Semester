public class DiningPhilosopher {

    static class Fork {

    }

    static class Philosopher extends Thread {

        Fork left;
        Fork right;


        public Philosopher(Fork left, Fork right){
            this.left = left;
            this.right = right;
        }

    }
}
