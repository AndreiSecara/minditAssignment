package ro.mindit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import ro.mindit.model.Post;

@Repository
public class PostDAOImpl implements PostDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/////////// UTILITY
	/////////// METHODS//////////////////////////////////////////////////////////////

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	private static final class PostMapper implements RowMapper<Post> {
		public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
			Post post = new Post();
			post.setId(rs.getInt("id"));
			post.setPostContent(rs.getString("postContent"));
			return post;
		}
	}

	private SqlParameterSource getSqlParameterSourceByModel(Post post) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (post != null) {
			parameterSource.addValue("id", post.getId());
			parameterSource.addValue("postContent", post.getPostContent());
		}
		return parameterSource;
	}
	//////// DAO
	//////// METHODS//////////////////////////////////////////////////////////////////////

	
	public List<Post> listPosts(int id) {
		String sql = "SELECT * FROM posts WHERE id= :id";
		List<Post> list = namedParameterJdbcTemplate.query(sql, getSqlParameterSourceByModel(new Post(id)), new PostMapper());
		return list;
	}

	
	//IN REVIEW
	public void addPost(Post post) {
		String sql = "INSERT INTO posts (id,postContent) VALUES (:id, :postContent)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterSourceByModel(post));
	}

}
