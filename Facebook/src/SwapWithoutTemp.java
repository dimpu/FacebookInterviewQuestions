
public class SwapWithoutTemp {
	public static void main(String[] args){
		int a = 2;
		int b = 4;
		/*a = a ^ b;
		b = a ^ b;
		a = a ^ b;*/
		/* OR */
		a = a + b;
		b = a - b;
		a = a - b;
		String s = "a b";
		String[] chars  = s.split(" ");
		System.out.println(chars.length);
		for(String i : chars)
			System.out.println(i);
		System.out.println("b = " + a);
		System.out.println("a = " + b);
		
	}
}
