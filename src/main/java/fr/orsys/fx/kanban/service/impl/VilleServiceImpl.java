package fr.orsys.fx.kanban.service.impl;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import fr.orsys.fx.kanban.business.Ville;
import fr.orsys.fx.kanban.dao.VilleDao;
import fr.orsys.fx.kanban.dao.impl.VilleDaoImpl;
import fr.orsys.fx.kanban.service.VilleService;

public class VilleServiceImpl implements VilleService {

	private VilleDao villeDao = new VilleDaoImpl();
	
	@Override
	public List<Ville> importerVilles() {
	
		List<Ville> villes = new ArrayList<>();
		
		try {
			URL url;

			url = new URL("https://www.clelia.fr/villes2020.csv");

			// Patron Decorator
			Reader reader = new InputStreamReader(new BufferedInputStream(url.openStream()), "UTF-8");

			// Patron Builder
			CSVFormat csvFormat = CSVFormat.newFormat(';').builder().setHeader().setSkipHeaderRecord(true).build();
			
			CSVParser csvParser = csvFormat.parse(reader);

			// Patron Iterator
			CSVRecord csvRecord = null;
			while (csvParser.iterator().hasNext()) {
				csvRecord = csvParser.iterator().next();
				Ville ville = new Ville(csvRecord.get("Code_commune_INSEE"), csvRecord.get("Nom_commune"), csvRecord.get(2));
				// On lit les degrés décimaux
                String coordonneesGps = csvRecord.get("coordonnees_gps");
                if (!coordonneesGps.equals("")) {
                    String[] dd = coordonneesGps.split(",");
                    ville.setLatitude(Double.parseDouble(dd[0]));
                    ville.setLongitude(Double.parseDouble(dd[1]));
                }                    
				ville.setComplement(csvRecord.get(4));
				villes.add(ville);
			}

			csvParser.close();
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Ville ville : villes) {
			try {
				villeDao.create(ville);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return villes;
	}

//	@Override
//	public List<Ville> recupCP42330VillesForEach() {
//		List<Ville> villesCorrespondantes = new ArrayList<>();
//		for (Ville ville : villes) {
//			if (ville.getCodePostal().equals("42330")) {
//				villesCorrespondantes.add(ville);
//			}			
//		}
//		return villesCorrespondantes;
//	}
//	
//	@Override
//	public List<Ville> recupCP42330VillesStream() {
//		return villes
//				.stream()
//				.filter(v -> v.getCodePostal().equals("42330"))
//				.collect(Collectors.toList());
//	}
//	
//	@Override
//	public List<Ville> recupCP42330VillesParallelStream() {
//		return villes
//				.parallelStream()
//				.filter(v -> v.getCodePostal().equals("42330"))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public List<Ville> recupererVillesDuDepartement(String filtreDepartement, String filtreNom) {
//		return villes
//				.stream()
//				.filter(v -> v.getCodePostal().startsWith(filtreDepartement) && v.getNom().toUpperCase().startsWith(filtreNom.toUpperCase()))
//				.collect(Collectors.toList());
//	}
//
//	@Override
//	public List<String> recupererVillesAyantCPNonUnique() {
//		return villes
//				.stream()
//				.collect(Collectors.groupingBy(v -> v.getNomDepartementComplement(), Collectors.counting()))           
//        		.entrySet()
//                .stream()
//                .filter(nbCodesPostaux -> nbCodesPostaux.getValue() > 1)                   
//                .sorted(Comparator.comparing(Map.Entry::getValue))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//	}
//
//	@Override
//	public List<Ville> recupererVillesDuSudOuest() {
//		return villes
//				.stream()
//				.filter(v -> v.getLatitude()>=44.3 && v.getLatitude()<=46.6)
//				.filter(v -> v.getLongitude()>=-1.8 && v.getLongitude()<=-0.5)
//				.collect(Collectors.toList());		
//	}
//	
//	@Override
//	public Map<Ville, Object> chargerVillesDansMap() {
//		return convertirListeEnMap(villes, v -> v.getCodeInsee());
//	}
//	
//	private <T, R> Map<T, R> convertirListeEnMap(List<T> list, Function<T, R> func) {
//
//        Map<T, R> result = new HashMap<>();
//        for (T t : list) {
//            result.put(t, func.apply(t));
//        }
//        return result;
//
//    }
	
	@Override
	public int recupererNbVilles() {
		try {
			return villeDao.count();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
