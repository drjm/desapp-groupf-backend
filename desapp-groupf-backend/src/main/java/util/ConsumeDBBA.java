package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

import model.Place;

public class ConsumeDBBA {

	public List<Place> getElements() {
		List<Place> places = new ArrayList<Place>();

		try {
			// obtengo el archivo la pagina del gobierno de la ciudad
			String url = "https://recursos-data.buenosaires.gob.ar/ckan2/locales-bailables/registro-locales-bailables.csv";
			URLConnection conn = new URL(url).openConnection();
			conn.connect();
			InputStream csvInp = conn.getInputStream();

			// Creo un objeto CsvReader para leer el CSV
			CsvReader places_import = new CsvReader(csvInp, StandardCharsets.UTF_8);

			places_import.readHeaders();

			// recorro el csv obteniendo una lista de lugares
			while (places_import.readRecord()) {

				String[] placeArray = places_import.getRawRecord().split(";");
				places.add(new Place(placeArray[3], placeArray[4]));

			}
			// Cierro el archivo
			places_import.close();

			for (Place us : places) {
				System.out.println(us.getName() + " : " + us.getAddress());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return places;
	}
}
