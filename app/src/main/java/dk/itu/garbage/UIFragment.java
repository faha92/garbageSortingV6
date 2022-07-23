package dk.itu.garbage;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class UIFragment extends Fragment {
  //GUI variables
  Button addItem, listItems, deleteItem;
  private TextView newWhat, newWhere;
  String where;

  //Model: Database of items
  private ItemsViewModel itemsDB;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    super.onCreateView(inflater, container, savedInstanceState);
    final View v= inflater.inflate(R.layout.fragment_ui, container, false);

    //Text Fields
    newWhat=  v.findViewById(R.id.what_text);
    newWhere= v.findViewById(R.id.where_text);
    //Buttons
    listItems = v.findViewById(R.id.list);
    addItem= v.findViewById(R.id.add_button);
    deleteItem = v.findViewById(R.id.delete_item_button);


    // Shared data
    itemsDB= new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);

    // adding a new thing
    addItem.setOnClickListener(view -> {
      String whatS= newWhat.getText().toString().trim();
      String whereS= newWhere.getText().toString().trim();
      if ((whatS.length() > 0) && (whereS.length() > 0)) {
        itemsDB.addItem(whatS, whereS);
        newWhat.setText("");
        newWhere.setText("");
      } else Toast.makeText(getActivity(), R.string.empty_toast, Toast.LENGTH_LONG).show();
    });



    // Look up garbage
    addItem.setOnClickListener(view -> {


      String garbageInput = newWhat.getText().toString();
      String result = ItemsDB.garbageLookup((garbageInput));
      newWhat.setText(result);

      Toast.makeText(getActivity(), newWhat.getText(),
              Toast.LENGTH_SHORT).show();

    });
    return v;
  }


}