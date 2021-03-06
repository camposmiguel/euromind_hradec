package com.miguelcr.contextmenu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.miguelcr.contextmenu.entities.Fruit;
import com.miguelcr.contextmenu.entities.FruitDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Fruit> fruits;
    EditText textNewItem;

    private FruitDao fruitDaoManager;
    FruitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textNewItem = (EditText) findViewById(R.id.editTextNewItem);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fruitDaoManager = DatabaseConnection.getFruitDao(this);


        // 1. Array of data
        fruits = fruitDaoManager.loadAll();


        // 2. Adapter to draw the data inside the ListView
        adapter = new FruitAdapter(this,R.layout.item_list_fruit,fruits);

        // 3. ListView
        listView = (ListView) findViewById(R.id.listViewFruits);

        // Connect the Listview and Adapter
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textNewItem.getText().toString().isEmpty()) {
                    Snackbar.make(view, "You need to write something", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    String text = textNewItem.getText().toString();
                    Fruit newFruit = new Fruit();
                    newFruit.setName(text);

                    // Add the new object to database
                    fruitDaoManager.insert(newFruit);

                    // Refresh the listView
                    fruits.clear();
                    fruits.addAll(fruitDaoManager.loadAll());
                    adapter.notifyDataSetChanged();
                    textNewItem.setText("");
                }
            }
        });
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        String message = "";
        switch (item.getItemId()) {
            case R.id.action_context_edit:
                message = "Edit clicked";
                break;
            case R.id.action_context_delete:
                message = "Delete clicked";
                break;
            case R.id.action_context_share:
                message = "Share clicked";
                break;
            default:
                return super.onContextItemSelected(item);
        }

        Toast.makeText(this,fruits.get(info.position)+" "+message,Toast.LENGTH_LONG).show();
        return true;
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
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }
}
