package nl.gst.rabo.blockbliek;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import nl.gst.rabo.blockbliek.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    Map<String,User> users;

    public UserRepository() throws FileNotFoundException {
        Gson gson = new Gson();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("users.json").getFile());

        JsonReader reader = new JsonReader(new FileReader(file));
        User[] data = gson.fromJson(reader, User[].class);
        this.users = new HashMap<>();
        for(User user:data){
            this.users.put(user.getName(), user);
        }
    }

    public User getUser(String name){
        return users.get(name);
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
