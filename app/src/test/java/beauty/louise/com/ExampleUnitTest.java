package beauty.louise.com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void t_Add() throws Exception {
        List<String> tempList = new ArrayList<>();
        tempList.add("1");
        tempList.add("1");
        tempList.add("1");

        tempList.add(1, "0");

        System.out.print(tempList.toString());
    }


    public static class D implements JsonDeserializer<MResult> {

        @Override
        public MResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject obj = json.getAsJsonObject();
            JsonArray asJsonArray = obj.get("list").getAsJsonArray();
            MResult result = new MResult();
            List<MBaseItem> list  = new ArrayList<>();
            for (JsonElement jsonElement : asJsonArray) {
                JsonObject jsonOb = jsonElement.getAsJsonObject();
                int type = jsonOb.get("type").getAsInt();
                Gson newGson = new Gson();
                MBaseItem item = null;
                switch (type) {
                    case 0:
                        item = newGson.fromJson(jsonOb.get("value"), MItem1.class);
                        break;
                    case 1:
                        item = newGson.fromJson(jsonOb.get("value"), MItem2.class);
                        break;
                }
                list.add(item);
            }
            result.setList(list);
            return result;
        }
    }

    @Test
    public void test_gson() {
        String json =
                "{\"list\" : [{\"type\":0,\"value\" : { \"a\" : \"sss\"}},{\"type\":1,\"value\" : {\"b\":\"sss\"}}]}";

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(MResult.class, new D());
        Gson gson = builder.create();
        MResult result = gson.fromJson(json, MResult.class);
        List<MBaseItem> list = result.getList();
        for (int i = 0; i< list.size(); i++) {
            System.out.println(list.get(i).getClass().getName());
        }
    }

}