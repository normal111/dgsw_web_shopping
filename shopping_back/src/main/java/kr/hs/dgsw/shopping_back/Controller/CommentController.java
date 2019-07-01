package kr.hs.dgsw.shopping_back.Controller;

import kr.hs.dgsw.shopping_back.Domain.Comment;
import kr.hs.dgsw.shopping_back.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/select")
    public List<Comment> selectComment() {
        return commentService.selectComment();
    }

    @GetMapping("/select/{id}")
    public Comment selectComment(@PathVariable Long id) {
        return commentService.selectComment(id);
    }

    @GetMapping("/selectProduct/{product_id}")
    public List<Comment> selectProduct(@PathVariable Long product_id) {
        return commentService.selectProduct(product_id);
    }

    @PostMapping("/insert")
    public Comment selectComment(@RequestBody Comment comment) {
        return commentService.insetComment(comment);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean updateComment(@PathVariable Long id) {
        return commentService.deleteComment(id);
    }

}
