
public class Driver_TristanDow {
	public static void main(String[] args)
	{
		// Testing constructor Donor(name: String) and the same with toString
		Donor Kevin = new Donor("Kevin");
		System.out.println(Kevin);
		
		// Testing constructor Donor(name: String, donations: Double) and the same with toString
		Donor James = new Donor("James", 500);
		System.out.println(James);
		
		// Testing getName method
		System.out.println(James.getName());
		
		// Testing addDonation method and showing result
		James.addDonation(new Double(200));
		System.out.println(James);
		
		// Testing getTotalDonations method
		System.out.println(James.getTotalDonations());
	}
}
