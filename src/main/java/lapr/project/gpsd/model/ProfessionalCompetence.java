package lapr.project.gpsd.model;

public class ProfessionalCompetence {

    private String description;

    public ProfessionalCompetence(String description) {
        if ((description == null) || (description.isEmpty())){
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Description: " + description;
    }
    
    

}
