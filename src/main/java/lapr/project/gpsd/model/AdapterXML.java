package lapr.project.gpsd.model;

public class AdapterXML implements FileType{
    
    private String adapterFileType = "XML";

    public AdapterXML() {
    }

    @Override
    public void export(String filename, String[] line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdapterFileType() {
        return this.adapterFileType;
    }

}
