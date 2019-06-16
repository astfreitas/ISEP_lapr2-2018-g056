package lapr.project.gpsd.model;

public interface FileType {
    /**
     * Exports data to a file
     * @param filename filename
     * @param line data
     */
    public abstract void export(String filename, String[] line);
    
    /**
     * Returns the file type
     * @return file type
     */
    @Override
    public abstract String toString();
}
