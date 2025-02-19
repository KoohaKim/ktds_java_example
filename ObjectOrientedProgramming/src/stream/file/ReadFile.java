package stream.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {

	private static final String FILE_PATH = "C:\\Users\\User\\Desktop\\";
	private static final String FILE_NAME = "text.txt";

	public void printFileDescription() {
		Stream<String> fileStream = null;

		try {
			fileStream = Files.lines(new File(FILE_PATH, FILE_NAME).toPath());

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

		if(fileStream != null) {
			
			fileStream.filter(line -> line.length() > 0) //줄바꿈제거
					 .map(line -> line.replace("\t", " "))
					 .map(line -> line.replaceAll("(KBS|KBS1|KBS2|SBS|MBC|TVN|JTBC|MNET|넷플릭스)", "")) // 방송사 -> ""으로
					 .map(line -> line.replaceAll("(< | > |  ! )", "")) // 특수문자 -> ""으로
					 .filter(line -> line.contains("MC"))
//					 .filter("MC"::contains)
					 .filter(line -> line.length() < 50)
					 .filter(line -> !line.endsWith("MC상"))
					 .map(line -> line.trim()) // 좌우 공백 있으면 날려라
					 .forEach(System.out::println);	
		}
		
	}
	
	
	
	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.printFileDescription();
		
        
		List<Integer> arr = new ArrayList<>();

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		int be = arr.get(0);
		arr.remove(0);
		int a = arr.get(0);
		
		System.out.println(arr);
		System.out.println(be);
		System.out.println(a);
	}
}
