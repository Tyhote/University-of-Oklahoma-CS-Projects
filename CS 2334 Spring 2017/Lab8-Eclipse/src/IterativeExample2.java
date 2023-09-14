import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IterativeExample2 {
	private static void printFriends(Friend friend, int distance) {
		if(distance == 0){
			System.out.println(friend);
			return;
		}
		List<Friend> aux1 = friend.getFriends();
		List<Friend> aux2 = new ArrayList<Friend>();
		boolean aux1Populated = true;
		--distance;
		while(distance != 0){
			if(aux1Populated){
				aux2 = new ArrayList<Friend>();
				for(int i = 0; i < aux1.size(); ++i){
					aux2.addAll(aux1.get(i).getFriends());
				}
				aux1Populated = false;
			}else{
				aux1 = new ArrayList<Friend>();
				for(int i = 0; i < aux2.size(); ++i){
					aux1.addAll(aux2.get(i).getFriends());
				}
				aux1Populated = true;
			}
			--distance;
		}
		if(aux1Populated){
			for(int i = 0; i < aux1.size(); ++i){
				System.out.println(aux1.get(i));
			}
		}else{
			for(int i = 0; i < aux2.size(); ++i){
				System.out.println(aux2.get(i));
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Friend> friendList = new ArrayList<Friend>();

		Friend reuben = new Friend("Reuben");
		Friend soumitra = new Friend("Soumitra");
		Friend ken = new Friend("Ken");
		Friend elisa = new Friend("Elisa");
		Friend isaac = new Friend("Isaac");

		friendList.add(reuben);
		friendList.add(soumitra);
		friendList.add(ken);
		friendList.add(elisa);
		friendList.add(isaac);

		reuben.addFriend(soumitra);
		reuben.addFriend(ken);

		soumitra.addFriend(reuben);

		ken.addFriend(reuben);
		ken.addFriend(elisa);

		elisa.addFriend(ken);
		elisa.addFriend(isaac);

		isaac.addFriend(elisa);

		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String inputName = "";
		String inputValue = "";
		Friend inputFriend = null;
		int inputInt = 0;

		System.out.println("Blank entry at any prompt exits program.");

		while (true) {
			System.out.print("Enter a person's name: ");
			try {
				inputName = inputReader.readLine();
			} catch (IOException e) {
				System.err.println("Error reading from console.");
			}

			if (inputName.equals("")) {
				System.out.println("Run complete.");
				System.exit(0);
			}

			inputFriend = new Friend(inputName);

			if (friendList.contains(inputFriend)) {
				inputFriend = friendList.get(friendList.indexOf(inputFriend));
				System.out.print("Enter a non-negative integer: ");
				try {
					inputValue = inputReader.readLine();
				} catch (IOException e) {
					System.err.println("Error reading from console.");
				}

				if (inputValue.equals("")) {
					System.out.println("Run complete.");
					System.exit(0);
				}

				try {
					inputInt = Integer.valueOf(inputValue);
				} catch (NumberFormatException e) {
					System.err.println("Must enter integer.");
					continue;
				}

				if (inputInt < 0) {
					System.out.println("Must be non-negative");
				} else {
					printFriends(inputFriend, inputInt);
				}
			} else {
				System.out.println(inputFriend + " not found.");
			}
		}
	}
}