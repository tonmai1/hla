package week1.unit2;

/** Same package as Visibility: public and no-keyword both work. */
public class SamePackageUser {
	public static void main(String[] args) {
		Visibility v = new Visibility();
		System.out.println(v.pub);
		System.out.println(v.pack);
		// System.out.println(v.priv); // ERROR: private
		v.showAll();
	}
}
