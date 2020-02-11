package util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonParser {

    public static <T> T parseJson(final String response, final Class<?> modelClass) {
        return new Gson().fromJson(response, (Type) modelClass);
    }
}
