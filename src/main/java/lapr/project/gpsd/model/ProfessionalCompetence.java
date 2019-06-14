package lapr.project.gpsd.model;

import java.util.Objects;

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
    
    /**
     *
     * Compares two instances of ProfessionalCompetence and returns true/false if they are
     * equals or possess the same atributes
     *
     * @param otherProfComp ProfessionalCompetence to compare
     * @return True/false if they are equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherProfComp) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherProfComp) {
            return true;
        }
        // null check
        if (otherProfComp == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherProfComp.getClass()) {
            return false;
        }
        // field comparison
        ProfessionalCompetence obj = (ProfessionalCompetence) otherProfComp;
        return (Objects.equals(description, obj.description));
    }

}
