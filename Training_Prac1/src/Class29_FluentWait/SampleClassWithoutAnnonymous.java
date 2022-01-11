package Class29_FluentWait;

public class SampleClassWithoutAnnonymous implements SampleInterface {

	public static void main(String[] args) {

		SampleInterface obj1 = new SampleClassWithoutAnnonymous();

		obj1.show();
		obj1.display();
	}

	@Override
	public void show() {
		System.out.println("I am in Show method");

	}

	@Override
	public void display() {
		System.out.println("I am in Display method");

	}

}
