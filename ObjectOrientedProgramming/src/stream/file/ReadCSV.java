package stream.file;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import stream.file.file.City;
import stream.file.file.Countries;
import stream.file.file.Regions;
import stream.file.file.States;
import stream.file.file.Subregions;

public class ReadCSV {
	private static final String CSV_PATH = "C:\\Users\\User\\Desktop\\csvexam\\";

	// 이 메소드 하나로 여러개의 new States, new Cities 등을 해야하는데.. 그럼if문을 도배해야함 -> Function으로
	// T를 줄테니 R을 내놔라
	public <R> List<R> loadData(FileName fileName, Function<String[], R> function, Predicate<R> condition) {

		try {
			return Files.lines(new File(CSV_PATH, fileName.fileName).toPath()) // Stream<String>
					.skip(1) // 첫번째 줄은 건너 뛰어라.
					.map(st -> st.split(",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))"))
					.map(array -> function.apply(array)) // Stream<R>
					.filter( inst -> condition != null ?  condition.test(inst) : true)	//Stream<R>
					.toList(); // List<R>
			
		} catch (IOException e) {
			throw new RuntimeException(e); // 웹에선 괜찮다 예외를던지다가 서버에서 잡히기 때문에. 근데 로컬에선 웹이 아니기 때문에 바로 런타입 앱이 죽어버린다
		}
	}

	
	
	public void printAllRegions() {
		this.loadData(FileName.REGIONS, Regions::new, null)
			.forEach( region -> {
				System.out.println("Region Id: " + region.getId());
				System.out.println("Region Name: " + region.getName());
			});
	}
	
	public void printAllSubRegions() {
		this.loadData(FileName.SUBREGIONS, Subregions::new, null)
			.forEach( sub -> {
				System.out.println("SubRegion Id: " + sub.getId());
				System.out.println("SubRegion Name: " + sub.getName());
			});
	}
	
	public void printAllCountries() {
		this.loadData(FileName.COUNTRIES, Countries::new, null)
			.forEach( con -> {
				System.out.println("Countries Id: " + con.getId());
				System.out.println("Countries Name: " + con.getName());
			});
	}
	
	public void printAllStates() {
		this.loadData(FileName.STATES, States::new, null)
			.forEach( st -> {
				System.out.println("States Id: " + st.getId());
				System.out.println("States Name: " + st.getName());
			});
	}
	
	public void printAllCities() {
		this.loadData(FileName.CITIES, City::new, null)
		.forEach( ct -> {
			System.out.println("City Id: " + ct.getId());
			System.out.println("City Name: " + ct.getName());
			System.out.println("Country Id: " + ct.getCountryId());
		});
	}
	
	public void printAllCitiesOfSouthKorea() {
		this.loadData( FileName.CITIES, City::new, ct -> ct.getCountryName().contains("South Korea") )
			.forEach( kr -> {
				System.out.println("City Id: " + kr.getId());
				System.out.println("City Name: " + kr.getName());
				System.out.println();
			});
	}
	


	
	
	public static void main(String[] args) {
		ReadCSV csv = new ReadCSV();
//		csv.printAllRegions();
//		csv.printAllCities();
//		csv.printAllStates();
//		csv.printAllCountries();
//		csv.printAllSubRegions();
		csv.printAllCitiesOfSouthKorea();
		
		
		
//		List<City> cities = csv.loadData(FileName.CITIES, City::new);
//		List<Countries> countries = csv.loadData(FileName.COUNTRIES, Countries::new);
//		List<Regions> regions = csv.loadData(FileName.REGIONS, Regions::new, null);
//		List<Regions> regions = csv.loadData( FileName.REGIONS, Regions::new, region -> region.getName().equals("Asia") );
//		List<States> states = csv.loadData(FileName.STATES, States::new); // (array) -> new States(array)
//		List<Subregions> subregions = csv.loadData(FileName.SUBREGIONS, Subregions::new);

//		states.forEach(System.out::println);
//		countries.forEach(System.out::println);
//		cities.forEach(System.out::println);
//		regions.forEach(System.out::println);
//		subregions.forEach(System.out::println);
	}
}
