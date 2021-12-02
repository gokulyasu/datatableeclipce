package Json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {
	Gson gson;
	int ID;
	FileWriter file;
	WebPageJsonFormat wpf;

	public JsonWriter() {
		ID = 0;
		gson = new GsonBuilder().setPrettyPrinting().create();
		wpf = new WebPageJsonFormat();

	}

	public void writeJson(ArrayList<String> data) throws IOException {
		WebPageJsonFormat det = createDetailsObject(data);
		try {

			file = new FileWriter("D:\\New folder\\RPA\\src\\main\\java\\Json\\data.json");
			gson.toJson(det.map, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}

	}
	public void writeJson(HashMap<Integer, HashMap<Integer, HashMap<String, String>>> data) throws IOException {
		WebPageJsonFormat det = createDetailsObject(data);
		try {

			file = new FileWriter("D:\\New folder\\RPA\\src\\main\\java\\Json\\data.json");
			gson.toJson(det.finalData, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			file.close();
		}

	}

	private WebPageJsonFormat createDetailsObject(HashMap<Integer, HashMap<Integer, HashMap<String, String>>> data) {
	wpf.finalData=data;
		return wpf;
	}
	private WebPageJsonFormat createDetailsObject(ArrayList<String> data) {
		ID += 1;
		HashMap<String, String> details = new HashMap<String, String>();

		for (int i = 0; i < data.size(); i++) {
			details.put(wpf.Heading[i], data.get(i));
		}
		wpf.map.put(ID, details);
		return wpf;
	}
}
