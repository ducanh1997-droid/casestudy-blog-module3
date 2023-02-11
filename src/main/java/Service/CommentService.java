package Service;

import DAO.CommentDAO;
import Model.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentService {
    public List<Comment> listComment;
    public CommentDAO commentDAO;
    public CommentService() {
        listComment=new ArrayList<>();
        commentDAO=new CommentDAO();
    }

    public List<Comment> findAll(int id_Blog){
        return commentDAO.findAll(id_Blog);
    }
    public void updateComment(Comment comment){
        commentDAO.updateComment(comment);
    }
    public void deleteComment(int id){
        commentDAO.deleteComment(id);
    }
    public void createComment(Comment comment){
        commentDAO.createComment(comment);
    }


}
