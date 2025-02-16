package quiz0214;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository {
    private static final String FILE_DIRECTORY_PATH = "C:\\quiz\\comment";


    public List<Comment> getCommentsByFileDirectory(String fileName) {
        String newFileName = fileName + ".txt";
        List<Comment> arr = new ArrayList<>();
        File file = new File(FILE_DIRECTORY_PATH, newFileName);

        if (!file.exists()) {
            return arr;
        }

        try {
            List<String> fileLines = Files.readAllLines(file.toPath());

            if (fileLines.size() % 4 != 0) {
                throw new IllegalArgumentException("잘못된 댓글 형식: " + newFileName);
            }

            for (int i = 0; i < fileLines.size(); i += 4) {
                String writer = fileLines.get(i);
                String content = fileLines.get(i + 1);
                String createdDate = fileLines.get(i + 2);
                String createdTime = fileLines.get(i + 3);

                Comment comment = new Comment(writer, content);
                comment.setCreatedDate(createdDate);
                comment.setCreatedTime(createdTime);
                arr.add(comment);
            }

        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 중 에러가 발생했습니다: " + e.getMessage());
        }
        return arr;
    }


    public void createComment(Comment comment, Post post) {
        String fileName = post.getTitle() + ".txt";
        File file = new File(FILE_DIRECTORY_PATH, fileName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            // 기존 파일에 이어 쓰기
            Files.write(file.toPath(), comment.convertToList(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("경로: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("댓글 저장 중 오류 발생: " + e.getMessage());
        }
    }

    public void removeComment(Post post, int commentIdx) {
        File file = new File(FILE_DIRECTORY_PATH, post.getTitle() + ".txt");

        if (!file.exists()) {
            System.out.println("해당 게시글에 댓글이 없습니다.");
            return;
        }

        try {
            List<String> fileLines = Files.readAllLines(file.toPath());

            if (commentIdx < 0) {
                System.out.println("유효 하지 않은 댓글 번호 입니다.");
                return;
            }

            int startLine = commentIdx * 4;
            for (int i = 0; i < 4; i++) {
                fileLines.remove(startLine);
            }
            // 수정된 내용 다시 저장 (덮어쓰기)
            Files.write(file.toPath(), fileLines, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

        } catch (IOException e) {
            System.out.println("파일 수정 중 오류 발생: " + e.getMessage());
        }
    }

    public void changeCommentFolderName(String oldTitle, String newTitle){
        File oldFile = new File(FILE_DIRECTORY_PATH, oldTitle + ".txt");
        File newFile = new File(FILE_DIRECTORY_PATH, newTitle + ".txt");

        if(oldFile.exists()){
            if(oldFile.renameTo(newFile)){
                System.out.println("댓글 파일명이 수정되었습니다: " + newFile.getName());
            }else{
                System.out.println(" 댓글 파일명 변경 실패.");
            }
        }
    }
}