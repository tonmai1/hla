package week1.unit2;

/**
 * Java OOP Foundation - Unit 2. Each file can run on its own via Run As > Java
 * Application in Eclipse.
 */
public class Example05StaticFinal {

	public static void main(String[] args) {
		System.out.println("Federation: " + Config.FEDERATION_NAME);
		System.out.println("Before: " + Config.packageCount);
		new PackageData();
		new PackageData();
		System.out.println("After two objects: " + Config.packageCount);
		// Config.FEDERATION_NAME = "NEW"; // Compile ERROR: final cannot change
	}

	static class Config {
		static int packageCount = 0; // Shared by all objects
		static final String FEDERATION_NAME = "HLA_DEMO"; // Constant
	}

	static class PackageData {
		PackageData() {
			Config.packageCount++;
		}
	}
}
