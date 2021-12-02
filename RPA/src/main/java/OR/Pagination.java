package OR;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Pagination {
	String pageNumber_Button;
	List<WebElement> pages;
	WebElement currentPage;
	int CurrentPageNumber;
	int pageSize;
	String tableRowXpath = "//table[@id='example']//tr[contains(@class,'odd') or contains(@class,'even')]";
	HashMap<Integer, HashMap<Integer, HashMap<String, String>>> completeData;

	OR or = new OR();

	public Pagination(String pageNumberXpath) {
		this.pageNumber_Button = pageNumberXpath;
		pages = or.getElements(pageNumber_Button);
		pageSize = pages.size();
		getCurrentPage();
	}

	public void moveForward() {
		CurrentPageNumber = getCurrentPage();
		if (CurrentPageNumber != pageSize) {
			or.click(or.getElement(pageNumber_Button + "[contains(text(),'" + (CurrentPageNumber + 1) + "')]"));
		} else {
			System.out.println("Cannot move Forward");
		}
	}

	public void moveBackward() {
		int CurrentPageNumber = getCurrentPage();
		if (CurrentPageNumber != 1) {
			or.click(or.getElement(pageNumber_Button + "[contains(text(),'" + (CurrentPageNumber - 1) + "')]"));
		} else {
			System.out.println("Cannot move Backward");
		}

	}

	public int getCurrentPage() {
		for (int i = 1; i <= pageSize; i++) {
			WebElement temp = or.getElement(pageNumber_Button + "[contains(text(),'" + i + "')]");

			if (or.getAttribute(temp, "class").contains("current")) {
				currentPage = temp;
			}
		}
		return Integer.parseInt(or.getText(currentPage));

	}

	public HashMap<Integer, HashMap<Integer, HashMap<String, String>>> allPages() {
		completeData = new HashMap<Integer, HashMap<Integer, HashMap<String, String>>>();
		for (int i = 1; i <= pageSize; i++) {
			completeData.put(getCurrentPage(), getData());
			moveForward();
		}
		//System.out.println(completeData);
		return completeData;
	}

	public HashMap<Integer, HashMap<Integer, HashMap<String, String>>> singlePage(int pageNumber) {

		if (pageNumber <= pageSize && pageNumber >= 0) {
			completeData = new HashMap<Integer, HashMap<Integer, HashMap<String, String>>>();
			or.click(or.getElement(pageNumber_Button + "[contains(text(),'" + pageNumber + "')]"));
			completeData.put(getCurrentPage(), getData());
		} else {
			System.out.println("Enter valid page nummber");
		}
		return completeData;
	}

	public HashMap<Integer, HashMap<Integer, HashMap<String, String>>> pagesBetweenRange(int from, int to) {
		completeData = new HashMap<Integer, HashMap<Integer, HashMap<String, String>>>();
		if ((from <= pageSize && from > 0) && (to <= pageSize && to > 0)) {
			if (from < to) {
				for (int i = from; i <= to; i++) {
					or.click(or.getElement(pageNumber_Button + "[contains(text(),'" + i + "')]"));
					completeData.put(getCurrentPage(), getData());
					moveForward();
				}
			} else if (to < from) {
				for (int i = from; i >= to; i--) {
					
					or.click(or.getElement(pageNumber_Button + "[contains(text(),'" + i + "')]"));
					System.out.println(getCurrentPage());
					completeData.put(getCurrentPage(), getData());
					moveBackward();
				}

			}
		} else {
			System.out.println("Enter valid range");
		}

		System.out.println(completeData.size());
		return completeData;
	}

	public HashMap<Integer, HashMap<String, String>> getData() {
		String[] Heading = { "name", "position", "office", "age", "startDate", "salary" };
		HashMap<Integer, HashMap<String, String>> tableDetails = new HashMap<Integer, HashMap<String, String>>();
		List<WebElement> ele = or.getElements(tableRowXpath);
		int ID = 0;

		for (WebElement e : ele) {
			ID += 1;
			List<WebElement> row = or.getChilds(e, "./td");
			HashMap<String, String> rowDetails = new HashMap<String, String>();
			for (int i = 0; i < row.size(); i++) {
				String tempData = or.getText(row.get(i));
				rowDetails.put(Heading[i], tempData);

			}
			tableDetails.put(ID, rowDetails);
		}
		return tableDetails;

	}

}
