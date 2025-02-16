package quiz0214;

import java.util.List;
import java.util.Scanner;

public class Board implements PostManager, CommentManager {
    private final Scanner scanner;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public Board() {
        this.scanner = new Scanner(System.in);
        this.postRepository = new PostRepository();
        this.commentRepository = new CommentRepository();
        mapToCommentAndPost();
    }

    private void mapToCommentAndPost() {
        for (Post post : postRepository.getPosts()) {
            List<Comment> comments = commentRepository.getCommentsByFileDirectory(post.getTitle());
            post.getComments().addAll(comments);
        }
    }

    // 게시글 등록
    @Override
    public void createPost() {
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
        postRepository.getPosts().add(post);
        System.out.println("**게시물 등록이 완료 되었습니다.**");
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
    public void findPostById() {
        int idx = getValidIdx("조회할 게시글 번호를 입력하세요: ");

        Post post = postRepository.findPostById(idx);
        System.out.println(
                " Index: " + idx +
                        "\n 제목: " + post.getTitle() +
                        "\n 작성자: " + post.getWriter() + " | 작성일시: " + post.getCreatedDate() + " " + post.getCreatedTime() +
                        "\n 내용: " + post.getContent() +
                        "\n 댓글 목록: "
        );
        checkComments(post.getComments());
    }

    private int getValidIdx(String s) {
        int idx;
        while (true) {
            System.out.println(s);
            String input = scanner.nextLine();

            try {
                idx = Integer.parseInt(input);
                if (idx >= 0 && idx < postRepository.getPosts().size()) {
                    return idx;
                } else {
                    System.out.println("유효하지 않은 게시글 번호입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

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
    public void modifyPost() {
        int idx = getValidIdx("수정하려는 게시글 번호를 입력하세요: ");

        Post oldPost = postRepository.findPostById(idx);
        String oldTitle = oldPost.getTitle();


        String txtFileName = repeatPrompt("제목을 입력하세요: ");
        System.out.print("내용을 입력하세요. (선택): ");
        String content = this.scanner.nextLine();

        Post post = new Post(txtFileName + ".txt", oldPost.getWriter(), content);

        postRepository.deletePost(idx);
        postRepository.savePost(post, post.getTitle());
        postRepository.getPosts().add(post);

        commentRepository.changeCommentFolderName(oldTitle, txtFileName);

        System.out.print("게시글 수정이 완료되었습니다.");
    }

    // 게시글 삭제
    @Override
    public void removePost() {
        int idx = getValidIdx("삭제할 게시글 번호를 입력하세요: ");
        System.out.println(idx + "번 게시글을 삭제합니다. 계속 진행할까요? (y/n)");
        String input = this.scanner.nextLine();

        if (input.equalsIgnoreCase("N")) {
            System.out.println("삭제가 취소되었습니다.");
        } else if (input.equalsIgnoreCase("Y")) {
            postRepository.deletePost(idx);

        }
    }

    // 댓글 등록
    @Override
    public void createComment() {
        int idx = getValidIdx("댓글을 추가할 게시글 번호를 입력하세요: ");

        Post post = postRepository.findPostById(idx);
        System.out.println(idx + "번 게시글의" + (post.getComments().size() + 1) + "번 째 댓글을 등록합니다.");

        String content = repeatPrompt("댓글 내용을 입력하세요:");
        String writer = repeatPrompt("댓글 작성자를 입력하세요:");

        Comment comment = new Comment(content, writer);

        post.addComment(comment);
        commentRepository.createComment(comment, post);

        System.out.println("댓글 작성 완료");
    }

    // 댓글 삭제
    @Override
    public void removeComment() {
        int postIdx = getValidIdx("해당하는 게시글 번호를 입력하세요: ");
        Post post = postRepository.findPostById(postIdx);
        int commentIdx;

        while (true) {
            System.out.println("삭제할 댓글 번호를 입력하세요: ");
            String input = scanner.nextLine();

            try {
                commentIdx = Integer.parseInt(input);
                if (commentIdx > 0 || commentIdx < post.getComments().size()) {
                    break;
                } else {
                    System.out.println("유효하지 않은 게시글 번호입니다. 다시 입력해주세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

        if (post.getComments().size() <= commentIdx) {
            throw new IllegalArgumentException("해당 댓글은 존재하지 않습니다.");
        }

        System.out.println(postIdx + "번 게시글의" + post.getComments().size() + "번 댓글을 삭제합니다. 계속 진행할까요? (y/n)");
        String input = this.scanner.nextLine();

        if (input.equalsIgnoreCase("N")) {
            System.out.println("삭제가 취소되었습니다.");
        } else if (input.equalsIgnoreCase("Y")) {
            post.getComments().remove(commentIdx);
            commentRepository.removeComment(post, commentIdx);
            System.out.println("삭제가 완료되었습니다.");
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }


    public void run() {
        while (true) {
            printMenu();
            BoardAction action = getActionByUserInput();

            if (action == null) {
                System.out.println("잘못된 기능입니다. 다시 입력해주세요.");
                continue;
            }

            if (action == BoardAction.EXIT) {
                System.out.println("게시판 애플리케이션을 종료합니다.");
                break;
            }

            executeAction(action);
        }
    }

    private void printMenu() {
        System.out.println("기능을 선택하세요.");
        for (BoardAction action : BoardAction.values()) {
            System.out.println("'" + action.getNumber() + ". " + action.getDescription());
        }
        System.out.print("기능 번호를 입력하세요: ");
    }

    private BoardAction getActionByUserInput() {
        int value;
        while (true) {
            String input = scanner.nextLine();

            try {
                value = Integer.parseInt(input);
                for (BoardAction action : BoardAction.values()) {
                    if (value >= 0 && value == action.getNumber()) {
                        return action;
                    }
                }
                System.out.println("유효하지 않은 번호입니다. 다시 입력해주세요.");
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    private void executeAction(BoardAction action) {
        switch (action) {
            case LIST_POSTS -> findAllPosts();
            case VIEW_POST, VIEW_COMMENTS -> findPostById();
            case CREATE_POST -> createPost();
            case MODIFY_POST -> modifyPost();
            case DELETE_POST -> removePost();
            case ADD_COMMENT -> createComment();
            case DELETE_COMMENT -> removeComment();
            default -> System.out.println("잘못된 기능입니다. 다시 입력해주세요.");
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
        board.run();
    }

}
