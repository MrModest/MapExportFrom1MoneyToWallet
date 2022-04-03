package mrmodest.demoproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FromOneMoneyToWalletCategoryMapper {
    private static final Map<String, String> dictionary;

    static {
        dictionary = new HashMap<>();

        dictionary.put("Internet & Phone (Home internet)", "Internet");
        dictionary.put("Other (Abyss)", "Missing");
        dictionary.put("Internet & Phone (Phone)", "Phone, mobile phone");
        dictionary.put("Electronic & Gadgets", "Electronics, accessories");
        dictionary.put("Other (Card service)", "Charges, Fees");
        dictionary.put("Fare", "Public transport");
        dictionary.put("Food (Eating out)", "Eating out");
        dictionary.put("Temp", "Groceries");
        dictionary.put("Common expense (Cat)", "Pets, animals");
        dictionary.put("Food (For home)", "Box food");
        dictionary.put("Home (Rent)", "Rent");
        dictionary.put("Home (Other)", "Housing");
        dictionary.put("Hygiene & Health (Other)", "Health care, doctor");
        dictionary.put("Common expense", "Common expense");
        dictionary.put("Other", "Missing");
        dictionary.put("Work (Salary)", "Wage, invoices");
        dictionary.put("Other (Interest on deposit)", "Interests, dividends");
        dictionary.put("Education (italki)", "Education, development");
        dictionary.put("Internet & Phone (Subscribes)", "Books, audio, subscriptions");
        dictionary.put("Travel", "Holiday, trips, hotels");
        dictionary.put("Clothes & Shoes", "Clothes & shoes");
        dictionary.put("Gifts (Other)", "Charity, gifts");
        dictionary.put("Leisure (Restaurants)", "Cafe & Restaurants");
        dictionary.put("Education", "Education, development");
        dictionary.put("Gifts (Friends)", "Charity, gifts");
        dictionary.put("Food (Snacks)", "Snacks");
        dictionary.put("Hygiene & Health (Personal hygiene and care)", "Health and beauty");
        dictionary.put("Hygiene & Health (Fitness)", "Active sport, fitness");
        dictionary.put("Food", "Food & Drinks");
        dictionary.put("Other (Other)", "Others");
        dictionary.put("Leisure (Activity)", "Active leisure");
        dictionary.put("Food (Delivery)", "Delivery food");
        dictionary.put("Gifts (Flowers)", "Flowers");
        dictionary.put("Leisure (Other)", "Another entertainments");
        dictionary.put("Leisure", "Another entertainments");
        dictionary.put("Leisure (Cinema)", "Another entertainments");
        dictionary.put("Work (Bonus)", "Wage, invoices");
        dictionary.put("Work (Vacation)", "Wage, invoices");
        dictionary.put("Debt (Returned to me)", "Debts");
        dictionary.put("Hygiene & Health (Medicine)", "Health care, doctor");
        dictionary.put("Hygiene & Health (Pharmacy)", "Health care, doctor");
        dictionary.put("Other (Sex products)", "Free time");
        dictionary.put("Internet & Phone (Other)", "Books, audio, subscriptions");
        dictionary.put("Debt (Taken from me.)", "Debts");
        dictionary.put("Work (Other)", "Interests, dividends");
        dictionary.put("Food (Lunch)", "Lunch & Brunch");
        dictionary.put("Food (Brunch)", "Lunch & Brunch");
        dictionary.put("Gifts (Skillaz)", "Charity, gifts");
        dictionary.put("Travel (Fare)", "Public transport");
        dictionary.put("Travel (Food)", "Holiday, trips, hotels");
        dictionary.put("Home (Household goods)", "Home, garden");
        dictionary.put("Internet & Phone (Apps)", "Software, apps, games");
        dictionary.put("Travel (Tickets)", "Holiday, trips, hotels");
        dictionary.put("Hygiene & Health", "Health care, doctor");
        dictionary.put("Gifts", "Charity, gifts");
        dictionary.put("Home (Furniture and appliances)", "Home, garden");
        dictionary.put("Travel (Leisure)", "Holiday, trips, hotels");
        dictionary.put("Other (Wedding)", "Another entertainments");
        dictionary.put("Home (Communal payment)", "Energy, utilities");
    }

    public static String map(String oneMoneyCategory) {
        return Optional.ofNullable(dictionary.get(oneMoneyCategory))
            .orElse("Missing");
    }
}
