package lapr.project.gpsd.model;

import java.util.Objects;

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

    @Override
    public String toString() {
        return " Status is " + servOrderStatus + " (details: " + servOrderDetail + ") ";
    }
    
    /**
     * 
     * Compares two instances of ServiceOrderStatus and returns true/false if they are
     * equals or possess the same atributes
     * 
     * @param o ServiceOrderStatus to compare
     * @return True/false if they are
     * equals or possess the same atributes
     */
     @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o) {
            return true;
        }
        // null check
        if (o == null) {
            return false;
        }
        // type check and cast
        if (getClass() != o.getClass()) {
            return false;
        }
        // field comparison
        ServiceOrderStatus obj = (ServiceOrderStatus) o;
        return (Objects.equals(servOrderStatus, obj.servOrderStatus) || 
                Objects.equals(servOrderDetail, obj.servOrderDetail));
    }
}
