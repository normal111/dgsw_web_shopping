package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectComment();

    Comment selectComment(Long id);

    List<Comment> selectProduct(Long product_id);

    Comment insetComment(Comment comment);

    Comment updateComment(Comment comment);

    boolean deleteComment(Long id);
}
