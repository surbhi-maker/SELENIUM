package Class29_FluentWait;

public class AnnonymousClass{

	public static void main(String[] args) {

		SampleInterface objnew = new SampleInterface() {

			public void show() {
				System.out.println("I am in Show method");
			}

			public void display() {
				System.out.println("I am in Display method");
			}

		};

		objnew.display();
		objnew.show();
	}
}
