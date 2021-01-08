package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		String path1 = "C:\\eclipse_workspace\\exercicio_arquivos_secao17\\in.csv";
		File path2 = new File(path1);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path1))) {
			String line = br.readLine();
			while (line != null) {
				String[] lineSplit = line.split(",");
				Product product = new Product(lineSplit[0], Double.parseDouble(lineSplit[1]), Integer.parseInt(lineSplit[2]));
				list.add(product);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}
		
		boolean newFolder = new File(path2.getParent() + "\\out").mkdir();
		String path3 = path2.getParent() + "\\out";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path3 + "\\summary.csv"))) {
			for (Product prod : list) {
				bw.write(prod.getName() + "," + String.format("%.2f", prod.valueTotal()));
				bw.newLine();
			}
			
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}
			
	}

}
