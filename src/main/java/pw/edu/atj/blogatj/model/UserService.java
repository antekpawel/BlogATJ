package pw.edu.atj.blogatj.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;

public class UserService {
    private static HashMap<String, String> users;
    String fileURL = "C:/Users/pawel/IdeaProjects/BlogATJ/src/main/resources/users.json";


    public UserService() {
        users = new HashMap<String, String>();
        readFromJSON();
    }


    public void addUser(String name, String pass) {
        users.put(name, pass);
        saveToJSON();
    }

    public void removeUser(String user) {
        users.remove(user);
        saveToJSON();
    }

    public boolean userIsValid(User user){
        if (user == null || user.getUsername().equals("")) return false;

        String passwordFromSource = users.get(user.getUsername());
        if(passwordFromSource != null) {
            return user.getPassword().equals(passwordFromSource);
        }else
            return false;
    }


    public boolean userExist(String user) {
        if (user == null || user.equals("")) return false;
        if (users.containsKey(user)) return true;
        return false;
    }

    public void readFromJSON() {
        Gson file = new Gson();
        HashMap<String, String> read;
        try {
            FileReader fileReader = new FileReader(fileURL);
            read = file.fromJson(fileReader, new TypeToken<HashMap<String, String>>() {}.getType());
            users.putAll(read);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveToJSON() {
        Gson file = new Gson();
        try {
            String jsonString = file.toJson(users);
            FileWriter fileWriter = new FileWriter(fileURL);
            fileWriter.write(jsonString);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
