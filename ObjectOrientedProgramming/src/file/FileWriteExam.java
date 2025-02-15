package src.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileWriteExam {
	public static void fileWriteUseNewIO(String directoryPath, String fileName, List<String> data) {
		//1. 새로 작성할 파일 인스턴스 만들기
		File file = new File(directoryPath, fileName);
		//2. 파일을 만든 위치가 존재하는지 확인하기.  
		//만약 C:/example/directory/hi 가 들어오는데 directrory가 없으면, mkdir은 directory만 만들고, mkdirs는 hi까지 다 만듬
		if(!file.getParentFile().exists()){
			//3. 없다면 폴더 새롭게 만들기
			file.getParentFile().mkdirs();
		}
		
		//4. 같은 이름의 파일이 이미 존재하는지 확인하기
		int index = 2;
		while (file.exists()) {
			//5. 다른 이름의 파일이 나올 때 까지 파일 명에 순번 붙이기
			String newFileName = fileName.substring(0, fileName.lastIndexOf("."));// 0부터 시작해서 . 이 나올 때 까지 잘라라..
			newFileName += " (" + (index++) + ").";
			newFileName += fileName.substring(fileName.lastIndexOf(".") + 1); // . 뒤 의 확장자만 추출해서 더함
			
			
			file = new File(directoryPath, newFileName);
		}
		// 6. 파일 쓰기
		try {
			Files.write(file.toPath(), data);
			//쓴 파일 위치 출력
			System.out.println(file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

		
	

	}

	public static void fileWriteUseOldIO(String directoryPath, String fileName, List<String> data) {

	}
	
	
	
	public static void main(String[] args) {
		List<String> data = new ArrayList<>();
		data.add(new Product("스마트폰1", 200001, 100).toFileFormat());
		data.add(new Product("스마트폰2", 200002, 90).toFileFormat());
		data.add(new Product("스마트폰3", 200003, 80).toFileFormat());
		data.add(new Product("스마트폰4", 200004, 70).toFileFormat());
		data.add(new Product("스마트폰5", 200005, 60).toFileFormat());
		
		
		fileWriteUseNewIO("C:\\Users\\User\\Desktop\\fileioexam", "storedProduct.txt", data);
	}

}
