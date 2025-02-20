package stream.file;

import java.io.File;
import java.io.IOException;
import java.lang.classfile.instruction.NewMultiArrayInstruction;
import java.nio.file.Files;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import stream.file.file.City;
import stream.file.file.Country;
import stream.file.file.Regions;
import stream.file.file.States;
import stream.file.file.Subregion;

public class ReadCSV {
	private static final String CSV_PATH = "C:\\Users\\User\\Desktop\\csvexam\\";

	// 이 메소드 하나로 여러개의 new States, new Cities 등을 해야하는데.. 그럼if문을 도배해야함 -> Function으로
	// T를 줄테니 R을 내놔라
	public <R> List<R> loadData(FileName fileName, Function<String[], R> function, Predicate<R> condition) {

		try {
			return Files.lines(new File(CSV_PATH, fileName.fileName).toPath()) // Stream<String>
					.skip(1) // 첫번째 줄은 건너 뛰어라.
					.map(st -> st.split(",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))")).map(array -> function.apply(array)) // Stream<R>
					.filter(inst -> condition != null ? condition.test(inst) : true) // Stream<R>
					.toList(); // List<R>

		} catch (IOException e) {
			throw new RuntimeException(e); // 웹에선 괜찮다 예외를던지다가 서버에서 잡히기 때문에. 근데 로컬에선 웹이 아니기 때문에 바로 런타입 앱이 죽어버린다
		}
	}

	public void printAllRegions() {
		this.loadData(FileName.REGIONS, Regions::new, null).forEach(region -> {
			System.out.println("Region Id: " + region.getId());
			System.out.println("Region Name: " + region.getName());
		});
	}

	public void printAllSubRegions() {
		this.loadData(FileName.SUBREGIONS, Subregion::new, null).forEach(sub -> {
			System.out.println("SubRegion Id: " + sub.getId());
			System.out.println("SubRegion Name: " + sub.getName());
		});
	}

	public void printAllCountries() {
		this.loadData(FileName.COUNTRIES, Country::new, null).forEach(con -> {
			System.out.println("Countries Id: " + con.getId());
			System.out.println("Countries Name: " + con.getName());
		});
	}

	public void printAllStates() {
		this.loadData(FileName.STATES, States::new, null).forEach(st -> {
			System.out.println("States Id: " + st.getId());
			System.out.println("States Name: " + st.getName());
		});
	}

	public void printAllCities() {
		this.loadData(FileName.CITIES, City::new, null).forEach(ct -> {
			System.out.println("City Id: " + ct.getId());
			System.out.println("City Name: " + ct.getName());
			System.out.println("Country Id: " + ct.getCountryId());
		});
	}

	public void printAllCitiesOfSouthKorea() {
		this.loadData(FileName.CITIES, City::new, ct -> ct.getCountryName().contains("South Korea")).forEach(kr -> {
			System.out.println("City Id: " + kr.getId());
			System.out.println("City Name: " + kr.getName());
			System.out.println();
		});
	}

	// -----------------------------------------------------------------------------------------------------------------

	// state의 Id에 소속된 모든 도시들을 출력한다.
	public void printAllCitiesOfState(int stateId) {
		this.loadData(FileName.STATES, arr -> new States(arr), state -> state.getId() == stateId) // List<State>
				.stream()
				.flatMap(state -> this
						.loadData(FileName.CITIES, cityArr -> new City(cityArr), ct -> ct.getStateId() == state.getId()) // Stream이
																															// 겹쳐
																															// 있음
						.stream()) // 연결된 map을 가져올 때 -> flatMap = T를 받으면 Stream 을 돌려준다
				.forEach(city -> System.out.println(city.getName()));
	}

	/*
	 * Country Id를 조회 -> get Cities country -> city가져올 때 flatMap -> city에서
	 */
	public void printAllCitiesOfCountry(int countryId) {
		// countryId 로 Country 조회
		this.loadData(FileName.COUNTRIES, countryArray -> new Country(countryArray),
				country -> country.getId() == countryId).stream()
				// 조회된 Country의 id로 state 조회
				.flatMap(country -> this.loadData(FileName.STATES, stateArr -> new States(stateArr),
						st -> st.getCountryId() == country.getId()).stream())
				// 조회된 state의 id로 city 조회
				.flatMap(state -> this.loadData(FileName.CITIES, cityArray -> new City(cityArray),
						city -> city.getStateId() == state.getId()).stream())
				// city 출력
				.forEach(city -> System.out
						.println(city.getName() + " / " + city.getStateName() + " / " + city.getCountryName()));
	}

	public void printAllCitiesOfSubRegion(int subRegionId) {
		// SubRegion 의 id로 Region 검색
		this.loadData(FileName.SUBREGIONS, subRegionArray -> new Subregion(subRegionArray),
				subRegion -> subRegion.getId() == subRegionId).stream()
				.flatMap(subRegion -> this.loadData(FileName.REGIONS, regionArr -> new Regions(regionArr),
						region -> region.getId() == subRegion.getRegionId()).stream())
				.flatMap(region -> this.loadData(FileName.COUNTRIES, countryArr -> new Country(countryArr),
						country -> country.getRegionId() == region.getId()).stream())
				.flatMap(country -> this.loadData(FileName.CITIES, cityArr -> new City(cityArr),
						city -> city.getCountryId() == country.getId()).stream())
				.forEach(city -> System.out.println(city.getName() + " / " + city.getCountryName()));
	}

	public void printAllCitiesOfRegion(int regionId) {
		// region의 id로 country 가져오기
		this.loadData(FileName.REGIONS, regionArr -> new Regions(regionArr), region -> region.getId() == regionId)
				.stream() // Stream<Region>
				.flatMap(region -> this.loadData(FileName.COUNTRIES, countryArr -> new Country(countryArr),
						country -> country.getRegionId() == region.getId()).stream())
				.flatMap(country -> this.loadData(FileName.CITIES, cityArr -> new City(cityArr),
						city -> city.getCountryId() == country.getId()).stream())
				.forEach(city -> System.out.println(city.getName() + " / " + city.getCountryName()));
	}

	/*
	 * 한 도시의 정보와 해당 도시의 state 정보를 함께 조회한다. cityName 조회하고자 하는 도시 "Seoul" Seoul의 정보와
	 * state의 정보를 함께 조회
	 */
	public City getOneCityWithState(String cityName) {
		return this.loadData(FileName.CITIES, cityArr -> new City(cityArr), city -> city.getName().equals(cityName))
				.stream().map(city -> {
					// city 인스턴스의 state 에 해당 도시의 state 정보를 채운다.
					States stateOfCity = this
							.loadData(FileName.STATES, stateArr -> new States(stateArr),
									state -> state.getId() == city.getStateId()) // .get(0)
							.stream().findFirst().orElse(null);

					city.setStates(stateOfCity);
					return city;
				}).findFirst().orElse(null);
	}

	/*
	 * Country에 소속된 모든 도시들의 정보 + Country에 소속된 모든 State의 정보 + State에 소속된 모든 도시
	 */
	public Country getOneCountry(String countryName) {
		List<States> states = this.loadData(FileName.STATES, stateArray -> new States(stateArray), null);
		List<City> cities = this.loadData(FileName.CITIES, cityArr -> new City(cityArr), null);

		return this
				.loadData(FileName.COUNTRIES, countrArray -> new Country(countrArray),
						country -> country.getName().equals(countryName)) // List<Country>
				.stream() // Stream<Country>

				.map(country -> {
					// 1. country의 state를 모두 조회. => country -> states(List) -> add
					List<States> countryStates = states.stream()
							.filter(state -> state.getCountryId() == country.getId())	//Stream<States>
							
							// state = states 타입.
							.map(state -> {		
								List<City> cityStatus = cities.stream().filter(city -> city.getStateId() == state.getId()).toList();
								state.setCities(cityStatus);
								return state;
							})
							.toList();
					// 2. country의 모든 state에 해당하는 city를 모두 조회. => country -> states(List) -> each
					// state -> city add
					country.setStates(countryStates);
					return country;
				}) // Stream<Country>

				.findFirst() // Optional<Country>
				.orElse(null); // Country
	}

	/*
	 * SubRegionName에 해당하는 SubRegion 정보 + Country 정보 + 각 Country들의 State정보 + City 정보
	 * 까지
	 */
	public Subregion getOneSubRegion(String subRegionName) {
		List<Country> countries = this.loadData(FileName.COUNTRIES, countryArr -> new Country(countryArr), null);
		List<States> states = this.loadData(FileName.STATES, stateArray -> new States(stateArray), null);
		List<City> cities = this.loadData(FileName.CITIES, cityArr -> new City(cityArr), null);
		
		return this
				.loadData(FileName.SUBREGIONS, subArr -> new Subregion(subArr), subRegion -> subRegion.getName().equals(subRegionName))
				.stream()
				.map( subRegion ->{
					List<Country> countryList = countries.stream()
							.filter( country -> country.getSubregionId() == subRegion.getId())
							.map( country -> {
								
								List<States> countryStates = states.stream()
										.filter( state -> state.getCountryId() == country.getId())
										.map( state -> {
											
											List<City> cityStatus = cities.stream()
													.filter( city -> city.getStateId() == state.getId())
													.toList();
											state.setCities(cityStatus);
											return state;
											
										}).toList();
								country.setStates(countryStates);
								return country;
							})
							.toList();
					subRegion.setCountries(countryList);
					return subRegion;
				})
				.findFirst()
				.orElse(null);
	}

	public static void main(String[] args) {
		ReadCSV csv = new ReadCSV();
//		csv.printAllRegions();
//		csv.printAllCities();
//		csv.printAllStates();
//		csv.printAllCountries();
//		csv.printAllSubRegions();
//		csv.printAllCitiesOfSouthKorea();

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

//0220==========================================================================================================================================================
//		csv.printAllCitiesOfState(3849);	// 같이 풀기 {3849 : seoul}
//		csv.printAllCitiesOfCountry(116);	// 같이 풀기	{116 : South Korea}	
//		csv.printAllCitiesOfSubRegion(12);	// 스스로 풀기 {12 : Eastern Asia}
//		csv.printAllCitiesOfRegion(3);	// 스스로 풀기 {3 : Asia}

//		City city = csv.getOneCityWithState("Seoul");	// 같이 풀기
//		System.out.println("City name: " + city.getName());
//		System.out.println("City StateId: " + city.getStateId());
//		System.out.println("City StateName: " + city.getStates().getName());
//		System.out.println("City StateType: " + city.getStates().getType());

//		Country country = csv.getOneCountry("\"South Korea\""); // 같이 풀기
//		System.out.println("Country Name: " + country.getName());
//		country.getStates().forEach(state -> {
//			System.out.println("Country's State Name: " + state.getName());
//
//			state.getCities().forEach(eachCity -> System.out.println("Country's City Name: " + eachCity.getName()));
//		});

		Subregion subregions = csv.getOneSubRegion("\"Eastern Asia\""); // 스스로 풀기
		System.out.println( "SubRegions Name: " + subregions.getName());
		subregions.getCountries().forEach( country -> {
			System.out.println("Country Name: " + country.getName());
			country.getStates().forEach( state ->{
				System.out.println("State Name: " + state.getName());
				state.getCities().forEach( city -> {
					System.out.println("City Name: " + city.getName());
				});
			});
		});
	}
}
