package org.example.seminar4;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table (name = "courses")
public class Course {
    private static final String[] coursName = new String[]
            {"Алгебра", "Биология", "Литература", "Физкультура",
                    "История", "Геометрия", "Обществоведение", "География"};
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private int duration;

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public static Course create() {
        return new Course(coursName[random.nextInt(coursName.length)], random.nextInt(1, 10));
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
