package beans;

public class Courses {
	private String classID;
	private String classType;
	private String classNumber;
	private String classTitle;
	private String classSection;
	private String classRoom;
	private String classDays;
	private String classStartTime;
	private String classEndTime;
	private String classMaxSize;
	private String classCurrentSize;
	private String classInstructorEmployeeID;
	private String year;
	private String semester;
	private String credits;
	private String grade;
	private String prerequisite1;
	private String prerequisite2;
	private String prerequisite3;
	public Courses() {
		
	}
	
	public Courses(String iD, String type, String number, String title, String section, String room, String days,
			String start, String end, String max, String current, String InstructorID, String year, String semester, String credits){//,
			//String prereq1, String prereq2, String prereq3) {
		this.classID=iD;
		this.classType=type;
		this.classNumber=number;
		this.classTitle=title;
		this.classSection=section;
		this.classRoom=room;
		this.classDays=days;
		this.classStartTime=start;
		this.classEndTime=end;
		this.classMaxSize=max;
		this.classCurrentSize=current;
		this.classInstructorEmployeeID=InstructorID;
		this.year=year;
		this.semester=semester;
		this.credits=credits;
		//this.prerequisite1=prereq1;
		//this.prerequisite2=prereq2;
		//this.prerequisite3=prereq3;
	}
	
	public String getClassID() {
		return classID;
	}
	public void setClassID(String classID) {
		this.classID = classID;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String number) {
		this.classNumber=number;
	}
	public String getClassTitle() {
		return classTitle;
	}
	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}
	
	public String getClassSection() {
		return classSection;
	}
	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}
	
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	
	public String getClassDays() {
		return classDays;
	}
	public void setClassDays(String classDateTime) {
		this.classDays = classDateTime;
	}
	public String getClassStartTime() {
		return classStartTime;
	}
	public void setClassStartTime(String startTime) {
		this.classStartTime = startTime;
	}
	public String getClassEndTime() {
		return classEndTime;
	}
	public void setClassEndTime(String endTime) {
		this.classEndTime = endTime;
	}
	public String getClassMaxSize() {
		return classMaxSize;
	}
	public void setClassMaxSize(String classMaxSize) {
		this.classMaxSize = classMaxSize;
	}
	
	public String getClassCurrentSize() {
		return classCurrentSize;
	}
	public void setClassCurrentSize(String classCurrentSize) {
		this.classCurrentSize = classCurrentSize;
	}
	
	public String getClassInstructorEmployeeID() {
		return classInstructorEmployeeID;
	}
	public void setClassInstructorEmployeeID(String classInstructorEmployeeID) {
		this.classInstructorEmployeeID = classInstructorEmployeeID;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPrerequisite1() {
		return prerequisite1;
	}
	public void setPrerequisite1(String Prerequisite1) {
		this.prerequisite1 = Prerequisite1;
	}
	public String getPrerequisite2() {
		return prerequisite2;
	}
	public void setPrerequisite2(String Prerequisite2) {
		this.prerequisite2 = Prerequisite2;
	}
	public String getPrerequisite3() {
		return prerequisite3;
	}
	public void setPrerequisite3(String Prerequisite3) {
		this.prerequisite3 = Prerequisite3;
	}
}
