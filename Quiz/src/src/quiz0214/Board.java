package quiz0214;

import java.util.List;
import java.util.Scanner;

public class Board implements PostManager {
    private final Scanner scanner;
    private final PostRepository postRepository;

    public Board() {
        this.scanner = new Scanner(System.in);
        this.postRepository = new PostRepository();
    }


    // 게시글 등록
    @Override
    public Post createPost() {
        String title;
        String writer;
        String content;

        title = repeatPrompt("제목을 입력하세요: ");
        writer = repeatPrompt("작성자를 입력하세요: ");

        System.out.print("내용을 입력하세요. (선택): ");
        content = this.scanner.nextLine();

        String txtFileName = title + ".txt";
        Post post = new Post(title, writer, content);
        postRepository.savePost(post, txtFileName);
        System.out.println("**게시물 등록이 완료 되었습니다.**");
        return post;
    }

    private String repeatPrompt(String s) {
        String param = null;
        while (param == null) {
            System.out.print(s);
            String input = this.scanner.nextLine();
            if (!input.isEmpty()) {
                param = input;
            }
        }
        return param;
    }

    // 게시글 전체 조회
    @Override
    public void findAllPosts() {
        for (int i = 0; i < postRepository.getPosts().size(); i++) {
            System.out.print("Index: " + i + " | ");
            System.out.println("게시글 제목: " + postRepository.getPosts().get(i).getTitle() +
                    " | 작성자: " + postRepository.getPosts().get(i).getWriter() +
                    " | 내용: " + postRepository.getPosts().get(i).getContent() +
                    " | 작성일: " + postRepository.getPosts().get(i).getCreatedDate() +
                    " | 작성 시: " + postRepository.getPosts().get(i).getCreatedTime()
            );
        }
    }

    // 게시글 단일 조회
    @Override
    public Post findPostById(int idx) {
        Post post = postRepository.findPostById(idx);
        System.out.println(
                " Index: " + idx +
                        "\n 제목: " + post.getTitle() +
                        "\n 작성자: " + post.getWriter() + " | 작성일시: " + post.getCreatedDate() + " " + post.getCreatedTime() +
                        "\n 내용: " + post.getContent() +
                        "\n 댓글 목록: "
        );
        checkComments(post.getComments());
        return post;
    }

    private void checkComments(List<Comment> comments) {
        if (comments.isEmpty()) {
            System.out.println("**댓글이 없습니다. 첫 댓글의 주인공이 되어 보세요!**");
            return;
        }
        for (Comment comment : comments) {
            System.out.println(comment);
        }
    }

    // 게시글 수정
    @Override
    public Post modifyPost() {
        System.out.print("수정하려는 게시글 번호를 입력하세요: ");
        int idx = scanner.nextInt();
        if (idx < 0 || idx >= postRepository.getPosts().size()) {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }

        String title = repeatPrompt("제목을 입력하세요: ");
        String txtFileName = title + ".txt";
        System.out.print("내용을 입력하세요. (선택): ");
        String content = this.scanner.nextLine();

        Post post = new Post(txtFileName, postRepository.findPostById(idx).getWriter(), content);

        postRepository.deletePost(idx);
        postRepository.savePost(post, post.getTitle());
        System.out.print("게시글 수정이 완료되었습니다.");
        return post;
    }

    // 게시글 삭제
    @Override
    public void removePost(int idx) {
        System.out.println(idx + "번 게시글을 삭제합니다. 계속 진행할까요? (y/n)");
        String input = this.scanner.nextLine();

        if (input.equalsIgnoreCase("N")) {
            System.out.println("삭제가 취소되었습니다.");
        } else if (input.equalsIgnoreCase("Y")) {
            postRepository.deletePost(idx);
            System.out.println("삭제가 완료되었습니다.");
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.findAllPosts();
        System.out.println("-----------------------");
//        board.createPost();   //o
//        board.findPostById(0); //o
//        board.modifyPost();   //o
//        board.removePost(0);  //o

    }

}
