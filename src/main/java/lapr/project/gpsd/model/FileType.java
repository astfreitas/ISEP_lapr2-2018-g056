package lapr.project.gpsd.model;

public interface FileType {
    public abstract void export(String filename, String[] line);
    @Override
    public abstract String toString();
}
