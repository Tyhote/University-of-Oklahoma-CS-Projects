import java.util.Comparator;

public class TopicComparator implements Comparator<NewsStory>{

	@Override
	public int compare(NewsStory arg0, NewsStory arg1) {
		return arg0.getTopic().compareTo(arg1.getTopic());
	}

}
