package spring5.sec_1.demo.domains;

public class User {
	private String fullName;
	private int age;
	private boolean employed;
	private String maritalStatus;
	
	public User() {}

	public User(String fullName, int age, boolean employed, String maritalStatus) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.employed = employed;
		this.maritalStatus = maritalStatus;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
}
