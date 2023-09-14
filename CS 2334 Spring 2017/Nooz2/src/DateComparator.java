import java.util.Comparator;

public class DateComparator implements Comparator<NewsStory> {
	static final DateComparator DATE_COMPARATOR = new DateComparator();

	@Override
	public int compare(NewsStory arg0, NewsStory arg1) {
		int compResult = arg0.getDate().compareTo(arg1.getDate());
		if (compResult != 0) {
			return compResult;
		}

		if (arg0 instanceof NewspaperStory) {
			if (!(arg1 instanceof NewspaperStory)) {
				return -1;
			} else {
				return 0;
			}
		} else if (arg1 instanceof NewspaperStory) {
			return 1;
		} else {
			NewsStory aux0;
			NewsStory aux1;
			if (arg0 instanceof TVNewsStory) {
				aux0 = (TVNewsStory) arg0;
			} else if (arg0 instanceof OnlineNewsStory) {
				aux0 = (OnlineNewsStory) arg0;
			}
			if (arg1 instanceof TVNewsStory) {
				aux1 = (TVNewsStory) arg1;
			} else if (arg1 instanceof OnlineNewsStory) {
				aux1 = (OnlineNewsStory) arg1;
			}

			return aux0.getPartOfDay().compareTo(aux1.getPartOfDay());
		}
	}

}
