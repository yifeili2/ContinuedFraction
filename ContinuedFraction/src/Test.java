
public class Test {
	public static void main(String[] args){
		//ContinuedFrac cf=new ContinuedFrac(3);
		//cf.add(7);
		//cf.add(15);
		
//		
//		int[] arr={3,7,15,1,292};
//		ContinuedFrac cf1=new ContinuedFrac(arr);
//		System.out.println(cf1.getNext().getOrder());
//		System.out.println(cf1.getNumO(1));
//		System.out.println(cf1.getNumO(2));
//		System.out.println(cf1.getNumO(3));
//		System.out.println(cf1.getNumO(4));
//		System.out.println(cf1.getNumO(5));
//		System.out.println(cf1.toString());
//		System.out.println(cf1.toValue());
//		cf1.Trunc();
//		System.out.println(cf1.toString());
//		System.out.println(cf1.toValue());
//		cf1.Trunc();
//		System.out.println(cf1.toString());
//		System.out.println(cf1.toValue());
//		System.out.println(cf1.toSequence());
//		int[] arr1={2,2,2,2,2,2,2,2};
//		ContinuedFrac cf2=new ContinuedFrac(arr1);
//		System.out.println(cf2.getOrder());
//		System.out.println(cf1.toString());
//		ContinuedFrac cf3=new ContinuedFrac(Math.PI,5);
//		System.out.println(cf3.toString());
//		System.out.println(cf1.getNext().getOrder());
		ContinuedFrac cf4=new ContinuedFrac((double) 1.37,10);
//		System.out.println(cf4.toString());
		System.out.println(cf4.toFracSeq());
		System.out.println(cf4.toValue());
		System.out.println(cf4.Reduce().toString());
		
		
		
		
		
	}

}
