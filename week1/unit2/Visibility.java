package week1.unit2;

/**
 * public / (no keyword) / private
 */
public class Visibility {
	public String pub = "public: any package";
	String pack = "no keyword: same package only";
	private String priv = "private: this class only";

	public void showAll() {
		System.out.println(pub);
		System.out.println(pack);
		System.out.println(priv);
	}
}
