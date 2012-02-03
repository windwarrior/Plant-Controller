package nl.utwente.plantcontroller.model;

public class ProductRun {
    private Product delivers;
    
    public ProductRun(Product delivers){
        this.delivers = delivers;
    }
    
    public Product getEindproduct(){
        return delivers;
    }
}
