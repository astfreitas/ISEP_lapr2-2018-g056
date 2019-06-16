package lapr.project.gpsd.model;

public class AdapterXML implements FileType{
    
    private String adapterFileType = "xml";

    /**
     * 
     * Creates an instance of AdapterXML
     * 
     */
    public AdapterXML() {
    }

    /**
     * 
     * Receives data and sends it to the XML exporter
     * 
     * @param filename filename
     * @param line line to be written
     */
    @Override
    public void export(String filename, String[] line) {
        ExportXML.export(filename, line);
    }

    /**
     * 
     * Returns the file type
     * 
     * @return file type
     */
    @Override
    public String toString() {
        return this.adapterFileType;
    }

}
