package lapr.project.gpsd.model;

public class AdapterCSV implements FileType {

    private final String adapterFileType = "csv";

    /**
     * 
     * Creates an instance of AdapterCSV
     * 
     */
    public AdapterCSV() {
    }

    /**
     * 
     * Returns the file type
     * 
     * @return File type
     */
    @Override
    public String toString() {
        return this.adapterFileType;
    }

    /**
     *
     * Exports the Service Orders list to a .csv file.Implemented using OpenCSV
     * library.
     *
     * @param filename Path to the file being written
     * @param line Line being written
     */
    @Override
    public void export(String filename, String[] line) {
        ExportCSV.export(filename, line);
    }

}
