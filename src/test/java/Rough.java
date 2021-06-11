import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Rough {
	public static void findTextInThisWorkSpace(String workSpace, String textToFind) {

		List<File> l = (List<File>) FileUtils.listFiles(new File(workSpace), new String[]{"java", "xml"}, true);
		l.parallelStream().filter(a -> {
			String allData = "";
			try {
				allData = Files.readString(a.toPath());
			} catch (IOException e) {
				System.err.println("Error Here : " + a.getAbsolutePath());
			}
			return allData.toLowerCase().contains(textToFind.toLowerCase());
		}).forEach(x -> System.out.println(x.getAbsolutePath()));
	}

	public static void main(String[] args) {

		findTextInThisWorkSpace(".", "wi");
	}
}
