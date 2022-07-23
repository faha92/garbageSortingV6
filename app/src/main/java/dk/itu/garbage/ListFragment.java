package dk.itu.garbage;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ListFragment extends Fragment {
  private TextView listThings;
  private Button backButton;


  // Data model
  ItemsViewModel itemsDB;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    final View v = inflater.inflate(R.layout.fragment_list, container, false);
    listThings = v.findViewById(R.id.listItems);
    backButton= v.findViewById(R.id.back_button);
    itemsDB= new ViewModelProvider(requireActivity()).get(ItemsViewModel.class);
    itemsDB.getValue().observe(getViewLifecycleOwner(), items -> listThings.setText(items.listItems()));
    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
      backButton.setOnClickListener(view ->
          getActivity()
              .getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.main_fragment,
                  new UIFragment()).commit());
    }
    return v;
  }
}
