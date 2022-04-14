package pw.edu.atj.blogatj.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class Post implements Serializable {
    private String text;
    private String displayTime;
    private String user;
    private LocalDateTime time;

    public Post(String text, String user) {
        this.text = text;
        this.time = LocalDateTime.now();
        this.displayTime = time.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.user = user;
    }

    public Post() {
    }

    public String getText() {
        return text;
    }

    public String getTime() {
        return displayTime;
    }

    public String getUser() {
        return user;
    }

    public static Comparator<Post> getComparator(SortParameter... sortParameters) {
        return new PostComparator(sortParameters);
    }

    public enum SortParameter {
        TIME
    }

    private static class PostComparator implements Comparator<Post> {
        private SortParameter[] parameters;

        private PostComparator(SortParameter[] parameters) {
            this.parameters = parameters;
        }

        public int compare(Post o1, Post o2) {
            int comparison;
            for (SortParameter parameter : parameters) {
                switch (parameter) {
                    case TIME:
                        comparison = o1.time.compareTo(o2.time);
                        if (comparison != 0) return comparison;
                        break;
                }
            }
            return 0;
        }
    }

}
