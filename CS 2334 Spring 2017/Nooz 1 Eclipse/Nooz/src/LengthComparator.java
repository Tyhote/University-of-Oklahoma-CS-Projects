import java.util.Comparator;

public class LengthComparator implements Comparator<NewsStory>{

	@Override
	public int compare(NewsStory newsStory1, NewsStory newsStory2) {
		return Integer.compare(newsStory1.getLengthInWords(), newsStory2.getLengthInWords());
	}

}
