package sg.edu.nus.iss.app.pafworkshop21.util;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class JsonUtil {
    public static String notFoundJson(String customerId) {
        JsonObject jObj = Json.createObjectBuilder()
                .add("message", "Customer %s not found".formatted(customerId))
                .build();
        return jObj.toString();
    }
}
