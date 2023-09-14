import java.util.ArrayList;

/*
 * -name: String
 * -donations: ArrayList<Double>
 * --------------------------------
 * +Donor(name: String)
 * +Donor(name: String, donation: double)
 * +getName(): String
 * +getTotalDonations(): Double
 * +toString(): String
 * +addDonation(donation: double)
 */
public class Donor {
	private String name;
	private ArrayList<Double> donations = new ArrayList<Double>();
	
	public Donor(String name)
	{
		this.name = name;
	}
	
	public Donor(String name, double donation)
	{
		this.name = name;
		donations.add(donation);
	}
	
	public String getName()
	{
		return name;
	}
	
	public Double getTotalDonations()
	{
		Double temp  = new Double(0);
		for(int i = 0; i < donations.size(); ++i)
		{
			temp += donations.get(i);
		}
		return temp;
	}
	
	public String toString()
	{
		if(donations.size() != 0)
			{
				return name + "\n" + donations.toString();
			}
		return name;
	}
	
	public void addDonation(Double donation)
	{
		donations.add(donation);
	}
}
