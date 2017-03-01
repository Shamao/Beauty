package princessmakeup.buykee.com.beauty.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by Steam on 16/12/13.
 */

public class GsonUtils {

    private static GsonUtils mInstance;
    private static Gson mGson;

    public Gson getGson() {
        return mGson;
    }

    private GsonUtils() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, STRING);
        mGson = gsonBuilder.create();
    }

    public static GsonUtils getInstance() {
        if (mInstance == null) {
            mInstance = new GsonUtils();
        }
        return mInstance;
    }

    /**
     * 处理NULL字符串，转成空字符串 ""
     */
    public static final TypeAdapter<String> STRING = new TypeAdapter<String>() {
        @Override
        public void write(JsonWriter out, String value) throws IOException {
            try {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.value(value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public String read(JsonReader in) throws IOException {
            try {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return "";//原先是返回Null，这里改为返回空字符串
                }
                return in.nextString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }
    };


    /**
     * 转化成json:String
     *
     * @param json
     * @param t
     * @param <T>
     * @return
     */
    public <T> T fromJson(String json, T t) {
        return (T) mGson.fromJson(json, t.getClass());
    }

    /**
     * 转换成对象  看单元test GsonTest
     *
     * @param t
     * @param <T>
     * @return
     */
    public <T> String toJson(T t) {
        return mGson.toJson(t, t.getClass());
    }
}
