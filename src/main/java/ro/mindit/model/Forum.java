package ro.mindit.model;

public class Forum {

	private int id;
	private String name;

	public Forum() {
		super();
	}

	public Forum(int id) {
		super();
		this.id = id;
	}

	public Forum(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
