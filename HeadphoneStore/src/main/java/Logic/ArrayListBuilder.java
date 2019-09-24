package Logic;

import java.util.ArrayList;

public class ArrayListBuilder<T extends Object> extends ArrayList{

	public ArrayListBuilder adds(Object obj) {
		this.add(obj);
		return (ArrayListBuilder) this;
	}
	public ArrayListBuilder adds(Object[] objs) {
		for(Object obj : objs){
			this.add(obj);
		}
		return (ArrayListBuilder) this;
	}
	public ArrayList buildArrayList() {
		return (ArrayList) this;
	}

}
