package week1.unit3;

import java.util.ArrayList;
import java.util.List;

public class Example05PackageImport {
	// Slide 7: package = namespace/folder; import = use classes from a package.
	// This nested class keeps the single-file lesson runnable by itself.
	static class PackageData {
		final String trackingNumber;

		PackageData(String trackingNumber) {
			this.trackingNumber = trackingNumber;
		}
	}

	static class PackageManager {
		private final List<PackageData> packages = new ArrayList<>();

		void add(PackageData pkg) {
			packages.add(pkg);
		}

		void printAll() {
			for (PackageData pkg : packages)
				System.out.println(pkg.trackingNumber);
		}
	}

	public static void main(String[] args) {
		PackageManager manager = new PackageManager();
		manager.add(new PackageData("PK001"));
		manager.add(new PackageData("PK002"));
		manager.printAll();
		// Real project: move PackageData and PackageManager to separate .java files.
	}
}
