package cui;

public class H02_oef3
{

	public static void main(String[] args)
	{
		H02_oef3 app = new H02_oef3();
		app.werkMetSwitchCase(3);
	}

	private void werkMetSwitchCase(int i)
	{
		int k;
		
		k = switch (i) {
		case 1 -> 3;
		case 2 -> 6;
		case 3,4 -> 10;
		default -> 20;
		};
		
		
//		switch (i) {
//		case 1 -> k = 3;
//		case 2 -> k = 6;
//		case 3,4 -> k = 10;
//		default -> k = 20;
//		}
		
//		switch (i) {
//		case 1:
//			k = 1;
//			break;
//		case 2: 

// 			k = 2;
// 			break;
// 		case 3:
// 			k = 10;
// 			break;
// 		case 4:
// 			k = 10;
// 			break;
// 		default:
// 			k = 20;
// 			break;
// //		}
		
		
		
//		if (i == 1)
//			k = 3;
//		else if (i == 2)
//			k = 6;
//		else if (i == 3 || i == 4)
//			k = 10;
//		else 
//			k = 20;
		System.out.printf("i = %d, k = %d", i, k);
		
	}

}
