package lapr.project.gpsd.model;

import java.util.Objects;

public class AcademicCompetence {

    private String course;
    private String level;
    private double grade;

    /**
     *
     * Creates an instance of academic competence
     *
     * @param course Course
     * @param level Level
     * @param grade Grade
     */
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

    /**
     *
     * Gets the course
     *
     * @return Course
     */
    public String getCourse() {
        return course;
    }

    /**
     *
     * Sets the course
     *
     * @param course course
     */
    public void setCourse(String course) {
        this.course = course;
    }

    /**
     *
     * Gets the level
     *
     * @return level
     */
    public String getLevel() {
        return level;
    }

    /**
     *
     * Sets the level
     *
     * @param level level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     *
     * Gets the score
     *
     * @return score
     */
    public double getScore() {
        return grade;
    }

    /**
     *
     * Sets the score
     *
     * @param score score
     */
    public void setScore(double score) {
        this.grade = score;
    }

    /**
     *
     * Gets the academic competence info
     *
     * @return academic competence info
     */
    @Override
    public String toString() {
        return "Course: " + course + ", Level: " + level + ", Grade: " + grade;
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
