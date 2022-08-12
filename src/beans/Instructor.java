package beans;

public class Instructor {
	private String InstructorID;
	private String firstName;
	private String lastName;
	private String email;
	private String room;
	private String phone;
	
	public Instructor() {
		
	}
	public String getInstructorID() {
		return InstructorID;
	}
	public void setInstructorID(String ID) {
		this.InstructorID = ID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String First) {
		this.firstName = First;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String Last) {
		this.lastName = Last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		this.email = Email;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String Room) {
		this.room = Room;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String Phone) {
		this.phone = Phone;
	}
}
