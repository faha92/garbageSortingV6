package dk.itu.garbage;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public  class ItemsDB extends ViewModel {
  public static final List<Item> values = new ArrayList<>();
  private static String where;


  public ItemsDB() {
    values.add(new Item("coffee", "Food"));
    values.add(new Item("jars", "Glass"));
    values.add(new Item("Orange", "Food"));
    values.add(new Item("Wine", "Glass"));
    values.add(new Item("Juice", "Plastic"));
  }

  public void addItem(String what, String where) {
    values.add(new Item(what, where));
  }

  public void removeItem(String what) {
    for (Item t : values) {
      if (t.getWhat().equals(what)) {
        values.remove(t);
        break;
      }
    }
  }

  public int size() {
    return values.size();
  }

  public String listItems() {
    StringBuilder r = new StringBuilder();
    for (Item i : values) r.append(i.getWhat()).append(" should be placed in: ").append(i.getWhere()).append("\n");
    return r.toString();
  }


  public static String garbageLookup(String garbage) {

    for (Item i : values) {

      if (i.getWhat().contains(garbage)) {
        where = i.getWhere();

        break;
      }

    }
    return garbage + " should be placed in: " + where;}
}

