package quiz0214;

public enum BoardAction {
    LIST_POSTS(1, "게시글 목록 조회"),
    VIEW_POST(2, "게시글 내용 조회"),
    CREATE_POST(3, "게시글 등록"),
    MODIFY_POST(4, "게시글 수정"),
    DELETE_POST(5, "게시글 삭제"),
    ADD_COMMENT(6, "댓글 등록"),
    VIEW_COMMENTS(7, "댓글 조회"),
    DELETE_COMMENT(8, "댓글 삭제"),
    EXIT(0, "종료");

    private final int number;
    private final String description;

    BoardAction(int number, String description) {
        this.number = number;
        this.description = description;
    }


    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
