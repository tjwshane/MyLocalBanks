package sg.edu.rpc346.id22035553.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button dbsButton;
    Button ocbcButton;
    Button uobButton;

    String wordClicked = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbsButton = findViewById(R.id.dbsButton);
        registerForContextMenu(dbsButton);

        ocbcButton = findViewById(R.id.ocbcButton);
        registerForContextMenu(ocbcButton);

        uobButton = findViewById(R.id.uobButton);
        registerForContextMenu(uobButton);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == dbsButton){
            wordClicked = "DBS";
        } else if (v == ocbcButton){
            wordClicked = "OCBC";
        } else if (v == uobButton){
            wordClicked = "UOB";
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbsButton.setText("DBS");
            ocbcButton.setText("OCBC");
            uobButton.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            dbsButton.setText("星展银行");
            ocbcButton.setText("华侨银行");
            uobButton.setText("大华银行");
            return true;
        } else {
            dbsButton.setText("Error translation");
            ocbcButton.setText("Error translation");
            uobButton.setText("Error translation");
        }
        return super.onOptionsItemSelected(item);
    }

    private void openwebsite(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void contactbank(String name, String number) {
        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        intentCall.setData(Uri.parse("tel:" + number));
        startActivity(intentCall);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0:
                openwebsite("https://www.dbs.com.sg");
                return true;
            case 1:
                contactbank("DBS", "18001111111");
                return true;
            case 2:
                openwebsite("https://www.ocbc.com");
                return true;
            case 3:
                contactbank("OCBC", "18003633333");
                return true;
            case 4:
                openwebsite("https://www.uob.com.sg");
                return true;
            case 5:
                contactbank("UOB", "18002222121");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}