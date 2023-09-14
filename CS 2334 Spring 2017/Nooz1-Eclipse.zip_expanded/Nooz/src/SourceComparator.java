import java.util.Comparator;

public class SourceComparator implements Comparator<NewsStory>{

	@Override
	public int compare(NewsStory arg0, NewsStory arg1) {
		return arg0.getSource().compareTo(arg1.getSource());
	}
	

}
