import java.util.ArrayList;

public class CityConstruct {
    City mainCity;
    ArrayList<Person> cityPeople = new ArrayList<>();
    ArrayList<Person> schoolPeople = new ArrayList<>();
    ArrayList<Person> cityHallPeople = new ArrayList<>();

    /**
     * creates a new city to utilize data storage and functions
     */
    public CityConstruct() {
        mainCity = new City("Main City");
    }

    /**
     * adds person object to two arraylists, cityPeople will permanently hold all people created
     * and People will hold person objects temporarily, based on where person label is dragged to
     * @param p
     */
    public void addLabeltoCity(Person p) {
        cityPeople.add(p);
        mainCity.People.add(p);
    }

    /**
     * Checks if city hall has anyone in it, if so, also checks if the passed person p is one of those people.
     * If person p is already in city hall function does nothing, if they are not already in city hall or city hall
     * is empty, adds person to city hall and removes them from other locations if they are stored there.
     * @param p represents the passed person object
     */
    public void movePersonCityHall(Person p){
        if (cityHallPeople.size() > 0) {
            for (int i = 0; i < cityHallPeople.size(); i++) {
                if (p.getName() == cityHallPeople.get(i).getName()) {
                } else {
                    cityHallPeople.add(p);
                    mainCity.People.remove(p);
                    for (int j = 0; j < schoolPeople.size(); j++) {
                        if (p.getName() == schoolPeople.get(j).getName())
                            schoolPeople.remove(p);
                    }
                }
            }
        }
        else {
            cityHallPeople.add(p);
            mainCity.People.remove(p);
            for (int j = 0; j < schoolPeople.size(); j++) {
                if (p.getName() == schoolPeople.get(j).getName())
                    schoolPeople.remove(p);
            }
        }

    }

    /**
     * Acts the same as movePersonCityHall but with the school label
     * @param p represents the passed person object
     */
    public void movePersonSchool(Person p) {
        if (schoolPeople.size() > 0) {
            for (int i = 0; i < schoolPeople.size(); i++) {
                if (p.getName() == schoolPeople.get(i).getName()) {
                } else {
                    schoolPeople.add(p);
                    mainCity.People.remove(p);
                    for (int j = 0; j < cityHallPeople.size(); j++) {
                        if (p.getName() == cityHallPeople.get(j).getName())
                            cityHallPeople.remove(p);
                    }
                }
            }
        } else {
            schoolPeople.add(p);
            mainCity.People.remove(p);
            for (int j = 0; j < cityHallPeople.size(); j++) {
                if (p.getName() == cityHallPeople.get(j).getName())
                    cityHallPeople.remove(p);
            }
        }
    }

    /**
     * re-adds person to People araylist, removes them from school or city hall if they are there
     * @param p represents the passed person object
     */
    public void movePersonCity(Person p){
        mainCity.People.add(p);
        for (int i=0;i<schoolPeople.size();i++){
            if (p.getName() == schoolPeople.get(i).getName())
                schoolPeople.remove(p);
        }
        for (int i=0;i<cityHallPeople.size();i++){
            if (p.getName() == cityHallPeople.get(i).getName())
                cityHallPeople.remove(p);
        }
    }

    /**
     * returns names of all people within school, city hall, and the city
     * @return names
     */
    public String getschoolNames(){
        String names = "People in School: \n";
        for (int i =0; i < schoolPeople.size();i++){
            names += schoolPeople.get(i).getName() + " ";
        }
        return names;
    }
    public String getCityHallNames(){
        String names = "People in City Hall: \n";
        for (int i=0;i<cityHallPeople.size();i++){
            names += cityHallPeople.get(i).getName() + " ";
        }
        return names;
    }
    public String getcityNames(){
        String names = "People in the City: \n";
        for (int i =0; i <mainCity.People.size();i++){
            names += String.format(mainCity.People.get(i).getName() + " ");
        }
        return names;
    }

}
