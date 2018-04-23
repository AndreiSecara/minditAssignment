package ro.mindit.model;

public class Post {

	private int id;
	private String postContent;

	public Post() {
		super();
	}

	public Post(int id) {
		super();
		this.id = id;
	}
	
	public Post(int id, String postContent) {
		super();
		this.id = id;
		this.postContent = postContent;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

}
