package lapr.project.gpsd.model;

public class AcademicCompetence {

    private String course;
    private String level;
    private double score;

    public AcademicCompetence(String course, String level, double score) {

        if ((course == null) || (course.isEmpty())
                || (level == null) || (level.isEmpty())) {
            throw new IllegalArgumentException("None of the arguments can be null or empty.");
        }
        this.course = course;
        this.level = level;
        this.score = score;
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
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
