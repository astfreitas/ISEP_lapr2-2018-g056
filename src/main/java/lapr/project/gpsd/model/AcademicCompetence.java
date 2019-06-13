package lapr.project.gpsd.model;

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

}
