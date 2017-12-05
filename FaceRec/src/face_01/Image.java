package face_01;

public class Image {

protected String faceId;
 protected int top;
 protected int left;
 protected int width;
 protected int height;
 protected int age;
 protected String gender;
 protected String glasses;
 
 protected double contempt;
 protected double surprise;
 protected double happiness;
 protected double neutral;
 protected double sadness;
 protected double disgust;
 protected double anger;
 protected double faer;
public String getFaceId() {
	return faceId;
}
public void setFaceId(String faceId) {
	this.faceId = faceId;
}
public int getTop() {
	return top;
}
public void setTop(int top) {
	this.top = top;
}
public int getLeft() {
	return left;
}
public void setLeft(int left) {
	this.left = left;
}
public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getHeight() {
	return height;
}
public void setHeight(int height) {
	this.height = height;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getGlasses() {
	return glasses;
}
public void setGlasses(String glasses) {
	this.glasses = glasses;
}
public double getContempt() {
	return contempt;
}
public void setContempt(double contempt) {
	this.contempt = contempt;
}
public double getSurprise() {
	return surprise;
}
public void setSurprise(double surprise) {
	this.surprise = surprise;
}
public double getHappiness() {
	return happiness;
}
public void setHappiness(double happiness) {
	this.happiness = happiness;
}
public double getNeutral() {
	return neutral;
}
public void setNeutral(double neutral) {
	this.neutral = neutral;
}
public double getSadness() {
	return sadness;
}
public void setSadness(double sadness) {
	this.sadness = sadness;
}
public double getDisgust() {
	return disgust;
}
public void setDisgust(double disgust) {
	this.disgust = disgust;
}
public double getAnger() {
	return anger;
}
public void setAnger(double anger) {
	this.anger = anger;
}
public double getFaer() {
	return faer;
}
public void setFaer(double faer) {
	this.faer = faer;
}
public Image(String faceId, int top, int left, int width, int height, int age, String gender, String glasses,
		double contempt, double surprise, double happiness, double neutral, double sadness, double disgust,
		double anger, double faer) {
	super();
	this.faceId = faceId;
	this.top = top;
	this.left = left;
	this.width = width;
	this.height = height;
	this.age = age;
	this.gender = gender;
	this.glasses = glasses;
	this.contempt = contempt;
	this.surprise = surprise;
	this.happiness = happiness;
	this.neutral = neutral;
	this.sadness = sadness;
	this.disgust = disgust;
	this.anger = anger;
	this.faer = faer;
}
public Image() {
	super();
	// TODO Auto-generated constructor stub
}
}
