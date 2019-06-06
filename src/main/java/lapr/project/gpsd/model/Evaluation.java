package lapr.project.gpsd.model;


public class Evaluation {
    private int rating;
    private ServiceOrder servOrder;

    /**
     * 
     * Creats an instance of Evaluation
     * 
     * @param rating Rating
     * @param servOrder Service Order
     */
    public Evaluation(int rating, ServiceOrder servOrder) {
        this.rating = rating;
        this.servOrder = servOrder;
    }

    /**
     * 
     * Returns the rating
     * 
     * @return Rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * 
     * Returns the Service Order
     * 
     * @return Service Order
     */
    public ServiceOrder getServOrder() {
        return servOrder;
    }
}
