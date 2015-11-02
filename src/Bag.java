public class Bag implements Cloneable, IMyCollection{
	
	private Object[] item;
	int size,count;
	
	public Bag(int size){
		this.size = size;
		this.count = 0;
		item = new Object[size];
	}

	public boolean isEmpty(){
		return count == 0;
	}

	/*public Object getlast(){
	 Object result = item[count-1];
	 count--;
	 return result;
 }
	 */

	public boolean isFull(){
		return count == size;
	}

	public void put(Object o){
		if(isFull()) {
			System.out.println("Bag is full");
		}
		item[count++] = o;
	}

	public Object take(){
		if(isEmpty()){
			System.out.println("No item");
			return false;
		}
		
		int i = (int)(Math.random()*count);
		Object foundObject = item[i];
		item[i] = null;
		
		for(; i < this.size-1; i++){
			int j = i + 1;
			item[i] = item[j];
			if( j == size){
				item[j] = null;
			}
		}
		count--;
		return foundObject;
	}

	public int size(){
		return size;
	}

	public int count(){
		return count;
	}

	public boolean contains(Object o){
		int jg = 0;
		for (int i = 0; i < count; i++) {
			if (item[i].equals(o)) jg = 1;
		}
		if(jg == 1)return true;
		else return false;
	}

	public boolean remove(Object n){
		for (int i = 0; i < count; i++) {
			if (item[i] == n) {
				item[i] = null;
				while(i<count-1) {
					item[i] = item[i+1];
					item[i+1] = null;
					i++;
				}
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public boolean equals(Object other){
		int jg = 0;

		if(other == this)
			return true; 
		if(other == null)
			return false;
		if(!(other instanceof Bag))
			return false;

		final Bag s = (Bag)other;

		if((this.size()!= s.size())||(this.count()!=s.count())){
			return false;
		}else
		{
			while(!this.isEmpty()&&!s.isEmpty()){
				for(int i=0;i<this.count;i++){
					for(int j=0;j<this.count;j++){
						if(this.item[i].equals(s.item[j]))jg++;
					}
				}
				if(jg == this.count)return true;
				/*if(this.getlast().equals(s.getlast()) == false)
			 {
				 System.out.println("You added:");
				 return false;
			 }*/
			}
			return false;
		}
	}
	
	@Override 
	public int hashCode(){
		int sum = 0;
		int result = 17;
		result = 31*result + size;
		result = 31*result + count;
		for(int i=0;i<=count-1;i++){
			sum = sum + item[i].hashCode();
		}
		result = 31*result + sum;
		return result;
	}
	
	@Override 
	public Bag clone(){
		try {
			Bag result = (Bag) super.clone();
			result.item = item.clone();
			return result;
		}catch (CloneNotSupportedException e){
			throw new AssertionError();
		}
	}
	
}

