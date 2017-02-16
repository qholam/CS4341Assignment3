import java.util.Arrays;
import java.util.Scanner;

public class RunSample {

	private static String requestType;
	private static String requestCondition;
	private static String examcond;
	private static String humiditycond;
	private static String snowcond;
	private static String icycond;
	private static String tempcond;
	private static String daycond;
	private static String stresscond;
	private static String cloudycond;
	private static int iteracond;
	private static String[] input;
	private static String[] type;

	public static void main(String[] args) 
	{
		System.out.println("sample");
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine().split(" ");
		int i = 0;
		for(String s: input)
		{
			type = s.split("=");
			for(String str: type)
			{
				System.out.println(i + " " + str);
				if(i == 0)
				{
					requestType = str;
				}
				else if(i == 1)
				{
					requestCondition = str;
				}else if(i == 2)
				{
					iteracond = Integer.parseInt(str);
					System.out.println(iteracond);
				} else
				{
					if(str.toLowerCase().equals("humidity"))
					{
						humiditycond = type[1];
					} 
					else if(str.toLowerCase().equals("day"))
					{
						daycond = type[1];
					}
					else if(str.toLowerCase().equals("snow"))
					{
						snowcond = type[1];
					}
					else if(str.toLowerCase().equals("temperature"))
					{
						tempcond = type[1];
					}
					else if(str.toLowerCase().equals("exam"))
					{
						examcond = type[1];
					}
					else if(str.toLowerCase().equals("cloudy"))
					{
						cloudycond = type[1];
					}
				}
				i++;
			}
		}
	}
} 
