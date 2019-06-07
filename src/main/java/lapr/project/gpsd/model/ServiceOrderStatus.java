package lapr.project.gpsd.model;

public class ServiceOrderStatus {

    /**
     * stributes of class ServiceOrderStatus
     */
    private String servOrderStatus;
    private String servOrderDetail;

    /**
     * constructor of ServiceOrderStatus with 1 parameter
     *
     * @param servOrderStatus
     */
    public ServiceOrderStatus(String servOrderStatus) {
        this.servOrderDetail = "N/A";
        this.servOrderStatus = servOrderStatus;
    }

    /**
     * constructor of ServiceOrderStatus with 2 parameters
     *
     * @param servOrderStatus
     * @param servOrderDetail
     */
    public ServiceOrderStatus(String servOrderStatus, String servOrderDetail) {
        this.servOrderStatus = servOrderStatus;
        this.servOrderDetail = servOrderDetail;
    }

    /**
     * returns the service order status
     *
     * @return service order status
     */
    public String getServOrderStatus() {
        return servOrderStatus;
    }

    /**
     * modifies the service order detail (of status)
     *
     * @param servOrderDetail
     */
    public void setServOrderDetail(String servOrderDetail) {
        this.servOrderDetail = servOrderDetail;
    }

    /**
     * modifies the service orde status
     *
     * @param servOrderStatus
     */
    public void setServOrderStatus(String servOrderStatus) {
        this.servOrderStatus = servOrderStatus;
    }

}
