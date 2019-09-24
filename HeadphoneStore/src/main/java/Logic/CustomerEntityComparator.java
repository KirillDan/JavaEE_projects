package Logic;

import java.util.Comparator;

import Entitys.CustomerEntity;

public class CustomerEntityComparator implements Comparator<CustomerEntity> {

	@Override
	public int compare(CustomerEntity arg0, CustomerEntity arg1) {
		
		return arg0.getSecondname().compareToIgnoreCase(arg1.getSecondname());
	}

}
