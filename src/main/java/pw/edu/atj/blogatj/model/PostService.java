package pw.edu.atj.blogatj.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static pw.edu.atj.blogatj.controller.LoginValidationServlet.ACTUAL_USER;

public class PostService {
    private static List<Post> posts = new ArrayList<>();
    private static Comparator<Post> cp = Post.getComparator(Post.SortParameter.TIME);
    String fileURL = "C:/Users/pawel/IdeaProjects/BlogATJ/src/main/resources/archive.json";


    public static List<Post> getPost(){
        Collections.sort(posts, cp.reversed());
        return posts;
    }

    public void addPost(Post post) { posts.add(post); }

    public void removePost(int no) {
        if (ACTUAL_USER.getUsername().equals(posts.get(no).getUser())) {
            posts.remove(no);
            saveToJSON();
        }

    }

    public void readFromJSON() {
        Gson file = new Gson();
        List<Post> read;
        try {
            FileReader fileReader = new FileReader(fileURL);
            read = file.fromJson(fileReader, new TypeToken<List<Post>>() {}.getType());
            posts.addAll(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToJSON() {
        Gson file = new Gson();
        try {
            String jsonString = file.toJson(posts);
            FileWriter fileWriter = new FileWriter(fileURL);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
