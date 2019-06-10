package lapr.project.gpsd.model;

public class AdapterXML implements FileType{
    
    private String adapterFileType = "XML";

    public AdapterXML() {
    }

    @Override
    public void export(String filename, String[] line) {
        ExportXML.export(filename, line);
    }

    @Override
    public String getAdapterFileType() {
        return this.adapterFileType;
    }

}
