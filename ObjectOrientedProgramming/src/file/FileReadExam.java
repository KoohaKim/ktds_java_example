package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileReadExam {

	public static void roadProduct() {
		File targetFile = new File("C:\\Users\\User\\Desktop\\fileioexam", "products.txt");

		List<Product> products = new ArrayList<>();

		try {
			List<String> fileLine = Files.readAllLines(targetFile.toPath());
			for (String line : fileLine) {
				products.add(new Product(line.split(",")));
			}

		} catch (IOException e) {
			System.out.println("파일을 읽는 중 에러가 발생했습니다.");
			System.out.println("원인: " + e.getMessage());
		}

		for (Product eacProduct : products) {
			System.out.println(eacProduct);
		}
	}

	
	
	
	
	
	public static void fileReadUseNewIO(String directoryPath, String fileName) {
		File targetFile = new File(directoryPath, fileName);

		try {
			List<String> fileLine = Files.readAllLines(targetFile.toPath());
			for (String line : fileLine) {
				System.out.println(line);
			}

		} catch (IOException e) {
			System.out.println("파일을 읽는 중 에러가 발생했습니다.");
			System.out.println("원인: " + e.getMessage());
		}
	}

	public static void fileReadUseOldIO(String directoryPath, String fileName) {
		// 읽어오려는 파일의 객체를 만든다. (targetFile)
		File targetFile = new File(directoryPath, fileName);

		if (!targetFile.exists() || !targetFile.isFile()) {
			return;
		}

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		// 파일을 읽기 위한 fileReader 객체를 만든다. (fileReader)
		try {
			// Note, 파일의 내용을 바이트 단위로 읽는다.
			// 영어, 숫자, 특수문자 : 1 byte "abc"
			// 그 외 나머지 외국어들 : 3byte "한글"
			fileReader = new FileReader(targetFile);

			// 파일을 한 줄 씩 읽기 위한 BufferedReader 객체를 만든다 (bufferedReader)
			// Note 내부에서 FileReader를 이용해서 한줄 자체를 통째로 읽음.
			// 캐리지리턴(\n) 이 나올 때 까지 바이트를 계속 읽는다.
			bufferedReader = new BufferedReader(fileReader);

			// br을 통해 EOF 까지 한줄 씩 읽는다.
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				// 한 줄씩 출력
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println(targetFile.getName() + "파일이 존재하지 않습니다. message: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.out.println("파일을 읽는 중 에러가 발생했습니다.");
			System.out.println("원인: " + e.getMessage());
			return;
		} finally {
			if (bufferedReader != null) {
				try {
					// close bufferedReader
					bufferedReader.close();
				} catch (Exception e) {
				}
			}

			if (fileReader != null) {
				try {
					// close fileReader
					fileReader.close();
				} catch (Exception e) {
				}
			}
		}

	}

	public static void main(String[] args) {
//		fileReadUseOldIO("C:\\Users\\User\\Desktop\\fileioexam", "readSample.txt");
//		fileReadUseNewIO("C:\\Users\\User\\Desktop\\fileioexam", "readSample.txt");
		roadProduct();
	}
}
