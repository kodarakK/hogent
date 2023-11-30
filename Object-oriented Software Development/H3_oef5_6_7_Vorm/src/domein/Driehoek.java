package domein;

public class Driehoek
{
	private int a;
	private int b;
	private int c;
	
	private static final int DEFAULT_ZIJDE = 1;
	
	public Driehoek(int a, int b, int c)
	{
		setA(a);
		setB(b);
		setC(c);
	}

	public boolean isRechthoekig() {
    return a*a==b*b+c*c || b*b==a*a+c*c || c*c==b*b+a*a;
  }
	
	

	private void setA(int a)
	{
		this.a = (a <= 0)?DEFAULT_ZIJDE:a;
	}



	private void setB(int b)
	{
		this.b = (b <= 0)?DEFAULT_ZIJDE:b;
	}



	private void setC(int c)
	{
		this.c = (c <= 0)?DEFAULT_ZIJDE:c;
	}



	public int getA()
	{
		return a;
	}

	public int getB()
	{
		return b;
	}

	public int getC()
	{
		return c;
	}

	
	
	
}
