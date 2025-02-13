package file;

import java.io.File;
import java.util.Date;

public class FileInfoExam {
	public static void printFileInfo(String directoryPath, String filename) {
		File file = new File(directoryPath, filename);
		
		System.out.println("파일이 존재 하나요? : " + file.exists());	//파일이 존재하는지 여부 확인 - true
		System.out.println("파일 객체 인가요? : " + file.isFile());	//파일 객체인지 확인 - true
		System.out.println("폴더 객체 나요? : " + file.isDirectory());	//폴더 객체인지 확인 - false
		System.out.println("파일의 전체경로 : " + file.getAbsolutePath());	//파일의 절대경로 확인 - C:\Users\User\Desktop\fileexam\subfolder1\subfolder1-1\sub1-1_sample.txt
		System.out.println("파일이름 : " + file.getName());	//파일의 이름 확인 - sub1-1_sample.txt
		System.out.println("파일크기 : " + file.length());	//파일의 크기(byte) 확인	- 0
		System.out.println("파일이 마지막으로 수정된 시간 : " + file.lastModified());	// 파일이 마지막으로 수정된 시간	- 1739412847025
		System.out.println("파일이 마지막으로 수정된 시간 : " + new Date(file.lastModified()));	// Thu Feb 13 11:14:07 KST 2025
		System.out.println("파일 경로 : " + file.getParent());	// 파일이 존재하는 경로 - C:\Users\User\Desktop\fileexam\subfolder1\subfolder1-1
		System.out.println("객체가 폴더일 경우. 폴더내에 존재하는 모든 항목의 목록 :" + file.listFiles());	// 객체가 폴더일 경우. 폴더내에 존재하는 모든 항목의 목록 - null
		System.out.println("-------------------------------------------------------------------------------");
	}
	
	/*
	 * 탐색을 시작하고 싶은 폴더를 주면
	 * 하위에 존재하는 모든 폴더와 파일들의 목록 출력
	 */
	public static void traversingAndPrintFilesInfo(String startDirectoryPath) {
		//startDirectoryPath경로의 File 인스턴스 를 생성.
		//file이 file이라면? -> file의 전체경로(파일의 크기) 를 출력
		//file이 폴더라면? -> file의 자식요소 (폴더 + 파일) 들을 얻어온다, file의 자식 요소(폴더+파일)을 반복. traversingAndPrintFilesInfo(자식요소의 전체경로);
		File file = new File(startDirectoryPath);
		if(file.exists()) {		
			if(file.isDirectory()) {
				File[] listFiles = file.listFiles();
				for(File childFile : listFiles) {
					if(childFile.isDirectory()) {
						traversingAndPrintFilesInfo(childFile.getAbsolutePath());
					}else {
						System.out.println(childFile.getAbsolutePath());
					}
				}
				
			} else if(file.isFile()) {
				System.out.println("경로: " + file.getAbsolutePath() + ", " + file.length());
			}
		}
	}
	
	public static void main(String[] args) {
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "company.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "example.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam", "sample.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder1", "sub_company.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder1", "sub_example.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder1", "sub_sample.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder1\\subfolder1-1", "sub1-1_sample.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder1\\subfolder1-1", "example.txt");
//		printFileInfo("C:\\Users\\User\\Desktop\\fileexam\\subfolder2", "sub_sample.txt");
		
		traversingAndPrintFilesInfo("C:\\Users\\User\\Desktop\\fileexam");//dir	
		System.out.println();
		traversingAndPrintFilesInfo("C:\\Users\\User\\Desktop\\fileexam\\sample.txt");//file
		
	}
}
