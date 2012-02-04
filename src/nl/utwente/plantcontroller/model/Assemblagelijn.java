package nl.utwente.plantcontroller.model;

public class Assemblagelijn {
		private boolean isBusy = false;
		
		
		public void startRun(Productrun r) {
		    isBusy = true;
		    
		    
		    // Do something
		    
		    
		    isBusy = false;
		}
		
		public boolean isBusy(){
		    return isBusy;
		}
}
