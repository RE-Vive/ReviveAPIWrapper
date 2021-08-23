package revive.wrapper.objects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class MapTimes {
	private Map<String, Integer> times = new HashMap<>();

	public int getTimeFor(String map) {
		return times.get(map);
	}

	public Set<String> getMaps() {
		return times.keySet();
	}

	public static TypeAdapter<MapTimes> getAdapter() {
		return new TypeAdapter<MapTimes>() {

			@Override
			public void write(JsonWriter out, MapTimes value) throws IOException {
				out.beginObject();
				value.times.forEach((c, v) -> {
					try {
						out.name("time_" + c);
						out.value(v);
					} catch (IOException e) {
					}
				});
				out.endObject();
			}

			@Override
			public MapTimes read(JsonReader in) throws IOException {
				JsonToken token = in.peek();
				if (token.equals(JsonToken.NULL)) {
					in.nextNull();
					return null;
				}
				MapTimes result = new MapTimes();
				in.beginObject();
				while (in.hasNext()) {
					String mapName = in.nextName().replace("time_", "");
					result.times.put(mapName, in.nextInt());
				}
				in.endObject();
				return result;
			}
		};
	}
}
