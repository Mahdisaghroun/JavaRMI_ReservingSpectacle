package Server.serv;

public class Spectacle {
long id ;
String intitude;
int nb_place;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getIntitude() {
	return intitude;
}
public void setIntitude(String intitude) {
	this.intitude = intitude;
}
public int getNb_place() {
	return nb_place;
}
public void setNb_place(int nb_place) {
	this.nb_place = nb_place;
}
public Spectacle(long id, String intitude, int nb_place) {
	super();
	this.id = id;
	this.intitude = intitude;
	this.nb_place = nb_place;
}

}
