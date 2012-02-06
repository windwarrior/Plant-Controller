package nl.utwente.plantcontroller.model;

public class Assemblagelijn {
    private boolean isBusy = false;
    private Product product;
    private int hoeveelheid;

    /**
     * Start een productie run
     * @precondition r.voldoendeVoorraad() == true
     * @param r
     */
    public void startRun(Productrun r) {
        isBusy = true;
        r.claimVooraden(10);
        product = r.getProductSoort();
        hoeveelheid = r.getHoeveelheid();
        Thread t = new Thread(new Delayer((long)r.getProductSoort().getProductieDuur(), r.getHoeveelheid(), r.getProductSoort(), this));
        t.start();
    }
    
    /**
     * Returns true als de Assemblagelijn bezig is met het maken van producten
     * @return
     */
    public boolean isBusy(){
        return isBusy;
    }
    
    /**
     * Zet de staat van deze Assemblagelijn op isBusy
     * @postcondition this.isBusy = isBusy;
     * @param isBusy
     */
    public void setBusy(boolean isBusy){
        if(!isBusy){
            product = null;
            hoeveelheid = 0;
        }
        this.isBusy = isBusy;
    }
    
    /**
     * Geeft het product wat deze assemblageLijn aan het maken is
     * als deze productielijn niet bezig is, dan wordt er null gereturnt
     * @return
     */
    public Product getProduct(){
        return product;
    }
    
    /**
     * Vermindert de hoeveelheid die deze Assemeblagelijn nog moet produceren
     */
    public synchronized void verminderHoeveelheid(){
        this.hoeveelheid--;
    }
    
    /**
     * Inner klasse die het productie proces simuleert.
     * @author lennart
     *
     */
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
                p.voegVooraadToe(1);
                a.verminderHoeveelheid();
            }
            a.setBusy(false);
        }

    }
    
    /**
     * Geeft de hoeveelheid producten die nog geproduceert moet worden
     * @return
     */
    public synchronized int getHoeveelheid() {
        return hoeveelheid;
    }
}
