import java.util.Scanner;

public class RunSample {

	public static void main(String[] args) 
	{
		System.out.println("sample");
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.next().split(" ");
		for(String s: input)
		{
			String[] type = s.split("=");
			for(String s: type)
			{
				System.out.println(s);
			}
		}
	}
} 
