package kr.hs.dgsw.shopping_back.Service;

import kr.hs.dgsw.shopping_back.Domain.Comment;
import kr.hs.dgsw.shopping_back.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> selectComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment selectComment(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment insetComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.findById(comment.getId())
                .map(found -> {
                    found.setProduct_id(Optional.ofNullable(comment.getProduct_id()).orElse(found.getProduct_id()));
                    found.setUser_id(Optional.ofNullable(comment.getUser_id()).orElse(found.getUser_id()));
                    return found;
                })
                .orElse(null);
    }

    @Override
    public boolean deleteComment(Long id) {
        try {
            commentRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
