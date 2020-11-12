
public class Test {

	public static void main(String[] args) {
		String s = "String";
		
		//System.out.println(s.substring(0,1));
		
		
		String converter1 = MorseCodeConverter.convertToEnglish("--. --- --- -.. -... -.-- . / .-- --- .-. .-.. -..");

		System.out.println(converter1);
		
		System.out.println(MorseCodeConverter.printTree());
		
	}

}
