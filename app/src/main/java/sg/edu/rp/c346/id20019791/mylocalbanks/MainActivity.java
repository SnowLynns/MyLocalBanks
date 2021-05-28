package sg.edu.rp.c346.id20019791.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button DBS;
    Button OCBC;
    Button UOB;

    String viewSelected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBS = findViewById(R.id.buttonDBS);
        OCBC = findViewById(R.id.buttonOCBC);
        UOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.v("Context", "create context");
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact The Bank");

        if (v == DBS) {
            viewSelected = "toptextview";
            Log.v("Context", "DBS selected");
        } else if (v == OCBC) {
            viewSelected = "middletextview";
            Log.v("Context", "OCBC selected");
        } else if (v == UOB) {
            viewSelected = "bottomtextview";
            Log.v("Context", "UOB selected");
        }
    }

    //checking what happens when a button is tapped
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (viewSelected.equalsIgnoreCase("toptextview")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //website selected//call bank

                Intent DBS = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(DBS);


                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1

                String phone = "+1800 111 1111";

                Intent DBS = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(DBS);

            }
            ;
            return true;  //menu item successfully handled


        } else if (viewSelected.equalsIgnoreCase("middletextview")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //call bank
                Intent OCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(OCBC);


                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1

                //website selected
                String phone = "+1800 363 3333";

                Intent OCBC = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(OCBC);
            }
            ;
            return true;  //menu item successfully handled
        } else {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //call bank
                Intent UOB = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(UOB);

                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1

                //website selected
                String phone = "+1800 222 2121";

                Intent UOB = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(UOB);
            }
            ;
        }
        return super.onContextItemSelected(item);
    }
}
