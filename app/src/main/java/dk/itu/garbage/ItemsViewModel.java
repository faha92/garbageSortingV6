package dk.itu.garbage;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemsViewModel extends ViewModel {
  private static MutableLiveData<ItemsDB> items;

  public ItemsViewModel() {
    items= new MutableLiveData<>();
    items.setValue(new ItemsDB());
  }

  public MutableLiveData<ItemsDB> getValue() { return items; }

  public void addItem(String what, String where){
    ItemsDB temp= items.getValue();
    temp.addItem(what, where);
    items.setValue(temp);
  }

  public void removeItem(String what){
    ItemsDB temp= items.getValue();
    temp.removeItem(what);
    items.setValue(temp);
  }
}