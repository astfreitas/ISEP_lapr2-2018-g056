package lapr.project.gpsd.model;

public class AdapterXML implements FileType{
    
    private String adapterFileType = "xml";

    public AdapterXML() {
    }

    @Override
    public void export(String filename, String[] line) {
        ExportXML.export(filename, line);
    }

    @Override
    public String toString() {
        return this.adapterFileType;
    }

}
