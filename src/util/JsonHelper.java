package util;

import model.User;

import javax.json.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class JsonHelper {
    // Parse JSON data
    public static JsonObject getJson(String body) {
        InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));

        JsonReader jsonReader = Json.createReader(stream);

        JsonObject jsonObject = jsonReader.readObject();

        try {
            jsonReader.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    // Build JsonObject for POST response
    public static JsonObject generatePostJson(User user) {
        return Json.createObjectBuilder().add("id", user.getId())
                .add("username", user.getUsername())
                .add("password", user.getPassword()).build();
    }

    // Build JsonArray for GET response
    public static JsonArray generateGetJson(List<User> users) {
        JsonArrayBuilder userBuilder = Json.createArrayBuilder();

        for (User user : users) {
            userBuilder.add(Json.createObjectBuilder()
                    .add("id", user.getId())
                    .add("username", user.getUsername())
                    .add("password", user.getPassword()));
        }

        return userBuilder.build();
    }
}
