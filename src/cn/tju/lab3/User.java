package cn.tju.lab3;

@Table("user")
public class User{
	
    private int id;
    private String username;
    private int age;
    private String email;
    private String telephone;

    
    @Column("id")
	public int getId() {
		return id;
	}

    @Column("username")
	public String getUsername() {
		return username;
	}

    @Column("age")
	public int getAge() {
		return age;
	}

    @Column("email")
	public String getEmail() {
		return email;
	}

    @Column("telephone")
	public String getTelephone() {
		return telephone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
