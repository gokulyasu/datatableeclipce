package Flow.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebElement;

import Json.JsonWriter;
import OR.OR;
import OR.Pagination;

public class WebToJson {

	public String pageNumber_Button = "//div[@id='example_paginate']/span/a";

	// String tableRowXpath = "//table[@id='example']//tr[contains(@class,'odd') or
	// contains(@class,'even')]";

	OR or = new OR();
	JsonWriter json = new JsonWriter();
	// WebToConsole wc;

	List<WebElement> pages;
	int pageSize;
	ArrayList<String> data;

	public WebToJson() {

	}

	public void pageControl() throws IOException {
		System.out.println("Select the Option");
		System.out.println("1.All Pages");
		System.out.println("2.Between some range");
		System.out.println("3.Single page");
		int option = new Scanner(System.in).nextInt();
		Pagination pg = new Pagination(pageNumber_Button);
		if (option == 1) {
			json.writeJson(pg.allPages());

		} else if (option == 2) {
			System.out.print("From : ");
			int from = new Scanner(System.in).nextInt();
			System.out.print("\nTo : ");
			int to = new Scanner(System.in).nextInt();
			json.writeJson(pg.pagesBetweenRange(from, to));

		} else if (option == 3) {
			System.out.println("Enter the Page Number");
			int pagenumber = new Scanner(System.in).nextInt();
			json.writeJson(pg.singlePage(pagenumber));
		} else {
			System.out.println("Enter valide option");
		}

	}

}
