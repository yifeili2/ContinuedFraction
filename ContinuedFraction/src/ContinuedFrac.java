
public class ContinuedFrac {
	private int Num = 0;
	private ContinuedFrac next;
	private int order=0;
	
	public ContinuedFrac(int[] arr){
		if (arr.length==1){
			Num=arr[0];
			next=null;
			order=1;
		}else{
			Num=arr[0];
			int[] temp=new int[arr.length-1];
			for (int i=0;i<arr.length-1;i++){
				temp[i]=arr[i+1];
			}
			next=new ContinuedFrac(temp);
			order=1+this.next.getOrder();
		}
	}
	
	public ContinuedFrac(double d,int l){
		if (l==1){
			this.Num=(int) d;
			this.next=null;
			this.order=l;
		}else{
			this.Num=(int) d;
			if (Math.abs(d-this.Num)>1e-9){
				this.next=new ContinuedFrac(1/(d-this.Num),l-1);
			}else{
				this.next=new ContinuedFrac(0,l-1);
			}
			this.order=l;
		}
		
	}
	
	public int getOrder(){
		return order;
	}
	
	public ContinuedFrac getNext(){
		return this.next;
	}
	
	public ContinuedFrac (int x){
		Num=x;
		next=null;
	}
	
	public int getNum(){
		return Num;
	}
	
	public void add(int x){
		if (this.next==null){
			this.next=new ContinuedFrac(x);
		}else{
			this.next.add(x);
		}
	}
	
	public String toString(){
		if(next==null){
			return Integer.toString(this.getNum());
		}else{
			return Integer.toString(this.getNum())+','+this.next.toString();
		}
	}
	
	public ContinuedFrac Reduce(){//incomplete
				
		if (this.Num==0) return null;
		else if (this.next==null){
			return this;
		}else{
			this.next=this.next.Reduce();
			return this;
		}
	}
	

	public double toValue(){
		if (next==null){
			double d=this.Num;
			return d;
		}else{
			double d=this.Num+1/(this.next.toValue());
			return d;
		}
	}
	
	public String toSequence(){
		if (this.next==null){
			String s=Double.toString(this.toValue());
			return s;
		}else{
			String s=Double.toString(this.toValue());
			return this.Trunc().toSequence()+','+s;
		}
	}
	
	public ContinuedFrac Trunc(){
		if (this.next==null) return null;
		else{
			this.next=this.next.Trunc();
			return this;
		}
	}
	
	public String toFracSeq(){
		int[] p=new int[this.getOrder()];
		int[] q=new int[this.getOrder()];
		p[0]=this.getNumO(0);
		q[0]=1;
		if (this.getOrder()>=2){
			p[1]=this.getNumO(1)*this.getNumO(0)+1;
			q[1]=this.getNumO(1);
			
			if (this.getOrder()>2){
				for (int i=2;i<this.getOrder();i++){
					if (this.getNumO(i)==0){
						p[i]=p[i-1];
						q[i]=q[i-1];
					}else{
					p[i]=this.getNumO(i)*p[i-1]+p[i-2];
					q[i]=this.getNumO(i)*q[i-1]+q[i-2];
					}
				}
			}
		}
		String s="";
		for (int j=0;j<this.getOrder();j++){
			s=s+p[j]+'/'+q[j]+',';
		}
		return s.substring(0, s.length()-1);
	}
	
	public int getNumO(int m){
		if (m>=this.getOrder()){
			return 0;
		}else if (m==0){
			return this.Num;
		}else{
			return this.next.getNumO(m-1);
		}
		
	}

}
