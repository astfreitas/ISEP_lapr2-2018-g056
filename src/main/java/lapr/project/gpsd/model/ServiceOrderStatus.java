/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.gpsd.model;

/**
 *
 * @author mdias
 */
public class ServiceOrderStatus {
    
    private String servOrderDetail;
    private String servOrderStatus;

    public ServiceOrderStatus(String servOrderStatus) {
        this.servOrderStatus = servOrderStatus;
        this.servOrderDetail = "N/A";
    }

    public ServiceOrderStatus(String servOrderDetail, String servOrderStatus) {
        this.servOrderDetail = servOrderDetail;
        this.servOrderStatus = servOrderStatus;
    }

    public String getServOrderStatus() {
        return servOrderStatus;
    }

    public void setServOrderDetail(String servOrderDetail) {
        this.servOrderDetail = servOrderDetail;
    }

    public void setServOrderStatus(String servOrderStatus) {
        this.servOrderStatus = servOrderStatus;
    }

   
    
    
    
    
}
