package MainPage;

public class Arrays {

	public static void main(String[] args) {
	String	a[][]=new String [3][2];
	a[0][0]="Hi";
	a[0][1]="%";
	a[1][0]="good";
	a[1][1]="bey";
	a[2][0]="d";
	a[2][1]="ed";
	/*for (int row=0;row<a.length;row++) {
		for(int col=0;col<a[0].length;col++)
			System.out.println(a[row][col]);
	}*/
	System.out.println(a.length);
	System.out.println(a[0].length);
	}
}