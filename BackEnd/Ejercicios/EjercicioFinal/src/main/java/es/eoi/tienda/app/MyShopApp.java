package es.eoi.tienda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import es.eoi.tienda.entities.Product;
import es.eoi.tienda.enums.Category;
import es.eoi.tienda.enums.Vat;
import es.eoi.tienda.services.ProductService;
import es.eoi.tienda.services.ProductServiceImpl;

public class MyShopApp {

	public static final String SEPARATOR = "===============================================";
	public static ProductService myService;

	public static void main(String[] args) {

		myService = new ProductServiceImpl();

		printMenu();

	}

	private static void printMenu() {

		System.out.println(SEPARATOR);
		System.out.println("PRODUCTATOR V.1.0");
		System.out.println("1 - New product");
		System.out.println("2 - List all products");
		System.out.println("3 - Search product");
		System.out.println("4 - Modify product");
		System.out.println("5 - Delete product");
		System.out.println("6 - Sell product");
		System.out.println("7 - Super executive report");
		System.out.print("--> Insert option: ");

		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Integer option = 0;

		try {
			option = Integer.parseInt(input);

			switch (option) {
			case 1:
				newProduct();
				break;

			case 2:
				listAllProducts();
				break;

			case 3:
				searchProduct();
				break;

			case 4:
				// TODO
				break;

			case 5:
				// TODO
				break;

			case 6:
				// TODO
				break;

			case 7:
				// TODO
				break;
			default:
				System.out.println("ERROR: The option don't exist, try again :)");
				break;
			}

			printMenu();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (in != null) {
				in.close();
			}
		}

	}

	private static void newProduct() {

		Scanner in = new Scanner(System.in);
		System.out.println(SEPARATOR);

		System.out.print("--> Insert name: ");
		String name = in.nextLine();
		if (name.length() > 15) {
			name = name.substring(0, 14).trim();
		}

		System.out.print("--> Insert description: ");
		String description = in.nextLine();
		if (name.length() > 30) {
			description = description.substring(0, 29).trim();
		}

		Vat vat = askVat(in);

		System.out.print("--> Insert price: ");
		Double price = in.nextDouble();
		in.nextLine();

		System.out.print("--> Insert number of maximum stock: ");
		Integer availableProducts = in.nextInt();
		in.nextLine();

		Category category = askCategory(in);

		Product myProd = new Product(name, description, vat, price, availableProducts, category);
		myService.create(myProd);

	}

	private static Vat askVat(Scanner in) {
		Vat vat = null;
		Integer option = 0;
		do {
			System.out.println("[ VATs ]");
			System.out.println("1 - 4%");
			System.out.println("2 - 10%");
			System.out.println("3 - 21%");
			System.out.print("--> Insert VAT: ");
			option = in.nextInt();
			in.nextLine();

			switch (option) {
			case 1:
				vat = Vat.FOUR;
				break;
			case 2:
				vat = Vat.TEN;
				break;
			case 3:
				vat = Vat.TWENTYONE;
				break;
			default:
				System.out.println("ERROR: Unknown option");
				break;
			}
		} while (option != 1 && option != 2 && option != 3);
		return vat;
	}

	private static Category askCategory(Scanner in) {
		Integer option;
		Category category = null;
		option = 0;
		do {
			System.out.println("[ CATEGORIES ]");
			System.out.println("1 - Food");
			System.out.println("2 - Material");
			System.out.println("3 - Mecanic");
			System.out.println("4 - Luxury");
			System.out.print("--> Insert category: ");
			option = in.nextInt();

			switch (option) {
			case 1:
				category = Category.FOOD;
				break;
			case 2:
				category = Category.MATERIAL;
				break;
			case 3:
				category = Category.MECANIC;
				break;
			case 4:
				category = Category.LUXURY;
				break;
			default:
				System.out.println("ERROR: Unknown option");
				break;
			}
		} while (option != 1 && option != 2 && option != 3 && option != 4);
		return category;
	}

	public static void listAllProducts() {

		System.out.println(SEPARATOR);
		System.out.println("Listado de todos los productos");

		for (Product myProd : myService.readAll()) {
			System.out.println(myProd);
		}

	}

	private static void searchProduct() {

		System.out.println(SEPARATOR);
		System.out.println("Buscar un producto por los siguientes campos: ");
		System.out.println("1 - Codigo");
		System.out.println("2 - Nombre de producto");
		System.out.println("3 - Categoria");
		System.out.print("--> Insert field: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Integer option = 0;
		List<Product> foundProducts = new ArrayList<Product>();

		try {
			option = Integer.parseInt(input);

			switch (option) {
			case 1:
				System.out.print("--> Insert code: ");
				Integer code = in.nextInt();
				in.nextLine();
				foundProducts = myService.read(code);
				break;
			case 2:
				System.out.print("--> Insert name: ");
				String name = in.nextLine();
				foundProducts = myService.read(name);
				break;
			case 3:
				Category category = askCategory(in);
				foundProducts = myService.read(category);
				break;
			default:
				System.out.println("ERROR: Unknown option");
				break;
			}

			if (foundProducts.isEmpty()) {
				System.out.println("ERROR: The field is not correct");
			} else {
				for (Product product : foundProducts) {

					System.out.println(product);
				}
			}

			searchProduct();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
