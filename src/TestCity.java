/**
 * Declares the TestCity class which holds the main function to create a City and run the program.
 */
public class TestCity {
	public static void main(String[] args) {
		City HW2City = new City();
		HW2City.payAllEmployees(11.50);
		CityView city = new CityView();
		city.CreateCityGraphic();


	}
}
