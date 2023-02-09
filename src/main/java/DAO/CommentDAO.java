package DAO;

import Model.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
    private final Connection connection;
    private final String SELECT_COMMENT_BY_ID_BLOG = "select * from account where id_Blog=?";
    private final String UPDATE_COMMENT_BY_ID = " update  comment set content = ? where id = ? ";
    private final String DELETE_COMMENT_BY_ID= " delete from comment where  id = ? " ;
    private final String INSERT_COMMENT = " insert into comment( content, createAT, blog_id,account_id,comment_id) value (?,,?,?,?) ";


    public CommentDAO() {
        connection = MyConnection.getConnection();
    }

    public List<Comment> findAll(int id_Blog) {
        List<Comment> listComment = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMENT_BY_ID_BLOG)) {
            preparedStatement.setInt(1, id_Blog);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listComment.add(new Comment(resultSet.getInt(1), resultSet.getString(2), resultSet.getTimestamp(3).toLocalDateTime(), resultSet.getInt(4),
                        resultSet.getInt(5),resultSet.getInt(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listComment;
    }

    public void updateComment(Comment comment) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COMMENT_BY_ID)) {
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setInt(2, comment.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteComment(int id){
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COMMENT_BY_ID)) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createComment(Comment comment){
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMMENT)) {
            connection.setAutoCommit(false);
            preparedStatement.setString(1, comment.getContent());
            preparedStatement.setTimestamp(2, Timestamp.valueOf( comment.getCreateAT()));
            preparedStatement.setInt(3,  comment.getBlog_id());
            preparedStatement.setLong(4,  comment.getAccount_id());
            preparedStatement.setLong(5,  comment.getComment_id());
             preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}



