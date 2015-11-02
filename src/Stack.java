public class Stack implements Cloneable, IMyCollection{

	private Object[] data;
	private int top = -1;
	int maxsize;

	public Stack(int maxsize) {
		this.maxsize = maxsize;
		data = new Object[maxsize];
	}

	public int getSize(){
		return maxsize;
	}

	public int getCount(){
		return top+1;
	}

	public Object getTop(){
		return data[top];
	}

	public boolean isEmpty(){
		return top == -1;
	}

	public boolean isFull(){
		return top + 1 == maxsize;
	}

	public void put(Object o){
		if(isFull()){
			System.out.println("Fail to push,The Stack is full");
		}
		data[++top] = o;
		System.out.println("New object has been pushed");
	}

	public Object take(){

		if(isEmpty()){
			System.out.println("No item");
		}
		Object t = data[top];
		data[top--]=null;
		return t;
	}
	
	@Override 
	public boolean equals(Object other){

		if(other == this)
			return true; 
		if(other == null)
			return false;
		if(!(other instanceof Stack))
			return false;

		Stack s = (Stack)other;
		//

		if((this.getSize()!= s.getSize())||(this.getCount()!=s.getCount())){
			return false;
		}
		//
		else
		{
			while(!this.isEmpty()&&!s.isEmpty()){
				if(this.take().equals(s.take()) == false)
				{
					return false;
				}
			}
			return true;
		}
	}
	
	@Override 
	public int hashCode(){
		int result = 17;
		result = 31*result + maxsize;
		result = 31*result + top;
		for(int i=0;i<=top;i++){
			result = 31*result + data[i].hashCode();
		}
		return result;
	}
	
	@Override 
	public Stack clone(){
		try {
			Stack result = (Stack) super.clone();
			result.data = data.clone();
			return result;
		}catch (CloneNotSupportedException e){
			throw new AssertionError();
		}
	}
}
