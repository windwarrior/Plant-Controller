package nl.utwente.plantcontroller.model;

public class Assemblagelijn {
    private boolean isBusy = false;
    private Product product;
    private int hoeveelheid;


    public void startRun(Productrun r) {
        System.out.println("oi");
        isBusy = true;
        product = r.getProductSoort();
        hoeveelheid = r.getHoeveelheid();
        Thread t = new Thread(new Delayer((long)r.getProductSoort().getProductieDuur(), r.getHoeveelheid(), r.getProductSoort(), this));
        t.start();
    }

    public boolean isBusy(){
        return isBusy;
    }

    public void setBusy(boolean isBusy){
        if(!isBusy){
            product = null;
            hoeveelheid = 0;
        }
        this.isBusy = isBusy;
    }

    public Product getProduct(){
        return product;
    }
    
    public synchronized void verminderHoeveelheid(){
        this.hoeveelheid--;
    }
    

    private class Delayer implements Runnable{
        private long millis;
        private int hoeveelheid;
        private Product p;
        private Assemblagelijn a;
        public Delayer(long millis, int hoeveelheid, Product p, Assemblagelijn a){
            this.millis = millis;
            this.hoeveelheid = hoeveelheid;
            this.p = p;
            this.a = a;
        }

        @Override
        public void run() {
            for(int i = 0; i < hoeveelheid; i++){
                try {

                    Thread.sleep(millis);
                } catch (InterruptedException e) {}
                System.out.println("updating vooraad");
                p.updateVooraad(1);
                a.verminderHoeveelheid();
            }
            a.setBusy(false);
        }

    }

    public synchronized int getHoeveelheid() {
        // TODO Auto-generated method stub
        return hoeveelheid;
    }
}
