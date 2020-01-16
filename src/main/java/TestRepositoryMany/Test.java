package TestRepositoryMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
public class Test {
	@Autowired
	private OrderReporsitory order;
	
	
	public static void main(String[] args) {
		Test t = new Test();
		t.print();
	}
	public void print() {
		order.orderRepor1Print();
		order.orderRepor2Print();
	}

}
