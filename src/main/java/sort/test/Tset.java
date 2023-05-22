package sort.test;


public class Tset {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer sample1 = 0;
		Sample sample2 = new Sample(0);
		Sample sample3 = new Sample(100);
		
		
		doSomething(sample1, sample2, sample3);
		
		System.out.println(sample1);
		System.out.println(sample2.value);
		System.out.println(sample3.value);
		

	}
	public static void doSomething(Integer p1, Sample p2, Sample p3) {
		p1 += 100;
		Sample temp;
		temp = p2;
		p2 = p3;
		p3 = temp;
	}

}
