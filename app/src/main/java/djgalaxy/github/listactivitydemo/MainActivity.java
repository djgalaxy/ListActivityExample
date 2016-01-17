package djgalaxy.github.listactivitydemo;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ListActivity {

    private static final String[] LISTITEMS = {"ListItem 1", "ListItem 2", "ListItem 3", "ListItem 4", "ListItem 5", "ListItem 6", "ListItem 7", "ListItem 8", "ListItem 9", "ListItem 10", "ListItem 11", "ListItem 12", "ListItem 13", "ListItem 14", "ListItem 15", "ListItem 16", "ListItem 17", "ListItem 18", "ListItem 19", "ListItem 20"};
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Creating and setting an adapter for a simple list.
        ArrayAdapter<String> simpleListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LISTITEMS);
        setListAdapter(simpleListAdapter);

        ListView listView = getListView(); // Not required for a simple list.

        // For single choice list, uncomment the following block:
        /*
        // Creating and setting an adapter for a single choice list.
        ArrayAdapter<String> singleChoiceListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, LISTITEMS);
        setListAdapter(singleChoiceListAdapter);

        // Setting list choice mode to single.
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        */

        // For multiple choice, uncomment the following block:
        /*
        // Creating and setting an adapter for a multiple choice list.
        ArrayAdapter<String> multipleChoiceListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, LISTITEMS);
        setListAdapter(multipleChoiceListAdapter);

        // Setting list choice mode to multiple.
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.d(TAG, "Selection = " + LISTITEMS[position] + " Position = " + position + " ID = " + id);
        Toast.makeText(MainActivity.this, "You selected " + LISTITEMS[position] + "!", Toast.LENGTH_SHORT).show();
        SparseBooleanArray checkedItemPositions = l.getCheckedItemPositions();
        Log.d(TAG, "CheckedItemPositions = " + checkedItemPositions); // null for simple list.
    }
}
