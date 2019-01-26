import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCount {
	
	Map<String, Integer> countJava8(String input) {
	    return Pattern.compile("\\W+")
	                  .splitAsStream(input)
	                  .collect(Collectors.groupingBy(String::toLowerCase,
	                                                 Collectors.summingInt(s -> 1)));
	}
	
	static String readFile(String path, Charset encoding) 
			  throws IOException 
			{
			  byte[] encoded = Files.readAllBytes(Paths.get(path));
			  return new String(encoded, encoding);
			}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long timeNow = System.currentTimeMillis(); 
		
		String path = "war_peace_text.txt";
		String data = readFile(path, Charset.defaultCharset());
		Map<String, Integer> count = new WordCount().countJava8(data);
		System.out.println(count);
		long timeNow2 = System.currentTimeMillis(); 
		System.out.println("start time: "+new Date(timeNow));
		System.out.println("end time: "+new Date(timeNow2));
		
		

	}

}
