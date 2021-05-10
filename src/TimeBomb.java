public class TimeBomb extends  Thread {

    private int seconds;
    private boolean counterHasReachedZero;

    public TimeBomb(int seconds) {
        this.seconds = seconds;
    }


    public void activate(){
        System.out.println("bomb has been activated");
        this.start();
    }


    public void disarm(){
        if(!counterHasReachedZero)
        System.out.println("bomb has been deactivated");
        this.interrupt();

    }

    @Override
    public void run() {
       while (seconds>=0){
           try {
               Thread.sleep(1000);
               seconds--;
               System.out.println("There are "+seconds+ " seconds left");

               if(seconds==0) {
                   System.out.println("BOOOOOM");
                    counterHasReachedZero= true;
                    break;
               }
           } catch (InterruptedException e) {
               break;
           }
       }
    }
}
