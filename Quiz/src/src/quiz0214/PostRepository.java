package quiz0214;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static final String FILE_DIRECTORY_PATH = "C:\\quiz";
    private final List<Post> posts;

    public PostRepository() {
        this.posts = getPostsByFileDirectory();
    }


    // 저장
    public void savePost(Post post, String fileName) {
        File file = new File(FILE_DIRECTORY_PATH, fileName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        int index = 2;
        while (file.exists()) {
            String newFileName = fileName.substring(0, fileName.lastIndexOf("."));
            newFileName += " (" + (index++) + ").";
            newFileName += fileName.substring(fileName.lastIndexOf(".") + 1);
            file = new File(FILE_DIRECTORY_PATH, newFileName);
        }

        try {
            Files.write(file.toPath(), post.convertToList());
            System.out.println("경로: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // 폴더 조회
    private List<Post> getPostsByFileDirectory() {
        List<Post> arr = new ArrayList<>();
        File directory = new File(FILE_DIRECTORY_PATH);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                arr.add(loadPostFromFile(file.getName()));
            }
        }
        return arr;
    }


    private Post loadPostFromFile(String fileName) {
        File file = new File(FILE_DIRECTORY_PATH, fileName);
        String title;
        String writer;
        String content;
        String createdDate;
        String createdTime;

        if (!file.exists()) {
            throw new RuntimeException("파일이 존재하지 않습니다. " + FILE_DIRECTORY_PATH);
        }
        if (!fileName.endsWith(".txt")) {
            throw new IllegalArgumentException("지원하지 않는 파일 형식입니다: " + fileName);
        }

        try {
            List<String> fileLines = Files.readAllLines(file.toPath());

            if (fileLines.size() < 4) {
                throw new IllegalArgumentException("파일 데이터가 부족합니다: " + fileName);
            }

            title = fileName.substring(0, fileName.lastIndexOf("."));
            writer = fileLines.get(0);
            content = fileLines.get(1);
            createdDate = fileLines.get(2);
            createdTime = fileLines.get(3);

            Post post = new Post(title, writer, content);
            post.setCreatedDate(createdDate);
            post.setCreatedTime(createdTime);

            return post;

        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 중 에러가 발생했습니다: " + e.getMessage());
        }
    }


    //삭제
    public void deletePost(int idx) {
        Post post = findPostById(idx);
        File file = new File(FILE_DIRECTORY_PATH, post.getTitle() + ".txt");

        if (file.exists()) {
            if (file.delete()) {
                posts.remove(idx);
            }
        }
    }


    public Post findPostById(int idx) {
        if (idx >= posts.size() || idx < 0) {
            throw new IllegalArgumentException("해당 게시글은 존재하지 않습니다");
        }

        return posts.get(idx);
    }




    public List<Post> getPosts() {
        return this.posts;
    }
}
