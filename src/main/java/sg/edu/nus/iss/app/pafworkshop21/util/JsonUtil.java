package sg.edu.nus.iss.app.pafworkshop21.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.SQLException;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class JsonUtil {
    public static String notFoundJson(String customerId) {
        JsonObject jObj = Json.createObjectBuilder()
                .add("message", "Customer %s not found".formatted(customerId))
                .build();
        return jObj.toString();
    }

    public static String blobToString(Blob blob) throws SQLException, UnsupportedEncodingException {
        int blobLength = (int) blob.length();
        byte[] blobAsBytes = blob.getBytes(1, blobLength);
        blob.free();
        ByteBuffer buff = ByteBuffer.wrap(blobAsBytes);
        String s = new String(buff.array(),"UTF-8");
        return s;
    }
}
