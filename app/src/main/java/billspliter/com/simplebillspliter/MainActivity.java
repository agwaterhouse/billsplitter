package billspliter.com.simplebillspliter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {
private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
         AdView mAdView = (AdView) findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);



        final EditText e1 = (EditText) findViewById(R.id.num1);
        final EditText e2 = (EditText) findViewById(R.id.num2);
        final TextView t1 = (TextView) findViewById(R.id.sum);
        addButton = (Button)findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double n1;
                double n2;

                if (e2.getText().toString().length() == 0 || e1.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(),"You Must Enter A Number For Both Fields", Toast.LENGTH_LONG).show();                }
                else {

                    n1 = Double.parseDouble(e1.getText().toString());
                    n2 = Double.parseDouble(e2.getText().toString());

                    if (n2 <= 0) {
                        Toast.makeText(getApplicationContext(),"You Can't divide by 0", Toast.LENGTH_LONG).show();                }
                    else {
                        Double thesum = n1 / n2;
                        t1.setText(Double.toString(thesum));

                    }

                }




            }
        });
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
}
