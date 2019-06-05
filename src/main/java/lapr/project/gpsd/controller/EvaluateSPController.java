package lapr.project.gpsd.controller;

import java.util.List;
import lapr.project.gpsd.model.*;

public class EvaluateSPController {

    private Company company;
    private ServiceProviderRegistry spr;
    private ServiceProvider sp;
    private List<ServiceProvider> spl;
    private List<Integer> r;
    private List<String> labels;
    private List<Double> arl;
    private double ar;
    private ServiceProviderStatistics sps;
    private String label;

    public EvaluateSPController() {
        if (!AplicacaoGPSD.getInstance().getSessaoAtual().isLoggedInWithRole(Constants.PAPEL_FRH)) {
            throw new IllegalStateException("Utilizador não Autorizado");
        }
        this.company = AplicacaoGPSD.getInstance().getEmpresa();
    }

    public List<ServiceProvider> getServiceProviders() {
        this.spr = company.getServiceProviderRegistry();
        this.spl = spr.getServiceProviders();
        return spl;
    }

    public ServiceProviderStatistics newSPStatistics(String email) {
        this.sp = spr.getServiceProviderByEmail(email);
        this.r = sp.getRatings();
        this.arl = spr.getAverageRatings();
        this.ar = sp.getAverageRating();
        this.sps = new ServiceProviderStatistics(ar, arl);
        return this.sps;
    }
    
    public List<String> getLabels() {
        this.labels = ServiceProviderStatistics.getLabels();
        return labels;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public boolean setSPClassification() {
        return sp.setClassification(label);
    }
   
}
