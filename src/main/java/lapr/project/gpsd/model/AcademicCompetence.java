package lapr.project.gpsd.model;

import java.util.Objects;

public class AcademicCompetence {

    private String course;
    private String level;
    private double grade;

    public AcademicCompetence(String course, String level, double grade) {

        if ((course == null) || (course.isEmpty())
                || (level == null) || (level.isEmpty())
                || grade < 0) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.course = course;
        this.level = level;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public double getScore() {
        return grade;
    }

    public void setScore(double score) {
        this.grade = score;
    }

    @Override
    public String toString() {
        return "Course: " + course + ", Level: " + level + ", Grade: " + grade ;
    }

     /**
     *
     * Compares two instances of AcademicCompetence and returns true/false if
     * they are equals or possess the same atributes
     *
     * @param otherAcademComp AcademicCompetence to compare
     * @return True/false if they are equals or possess the same atributes
     */
    @Override
    public boolean equals(Object otherAcademComp) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == otherAcademComp) {
            return true;
        }
        // null check
        if (otherAcademComp == null) {
            return false;
        }
        // type check and cast
        if (getClass() != otherAcademComp.getClass()) {
            return false;
        }
        // field comparison
        AcademicCompetence obj = (AcademicCompetence) otherAcademComp;
        return (Objects.equals(course, obj.course) || Objects.equals(level, obj.level) || Objects.equals(grade, obj.grade));
    }
}
