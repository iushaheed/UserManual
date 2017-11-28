package co.bondtech.usermanual;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

/**
 * Created by User on 11/1/2017.
 */

public class ScanBarcode extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView mImageV;
    int[] imgRes;
    int head;
    ScrollView sv;
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mImageV=findViewById(R.id.imageView);
        imgRes= new int[]{R.drawable.ea, R.drawable.eb, R.drawable.ec,R.drawable.ed,R.drawable.ee,R.drawable.ef};
        head=-1;
        sv=findViewById(R.id.scrollView);
        mTextView1=findViewById(R.id.tv1);
        mTextView2=findViewById(R.id.tv2);
        mTextView3=findViewById(R.id.tv3);
        mTextView4=findViewById(R.id.tv4);
        mTextView5=findViewById(R.id.tv5);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            Intent i = new Intent(this, LoginInfo.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_one) {
            Intent i = new Intent(this, AddUnit.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_two) {
            Intent i = new Intent(this, AddCategory.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_three) {
            Intent i = new Intent(this, AddItem.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_four) {
            Intent i = new Intent(this, ScanBarcode.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_five) {
            Intent i = new Intent(this, Sell.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_six) {
            Intent i = new Intent(this, Receipt.class);
            startActivity(i);
            finish();
        }
        else if (id == R.id.nav_seven) {
            Intent i = new Intent(this, Report.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getPreviousImg(View view) {
//        int test=Math.abs(head--);
        if(head>0){
            head=head-1;
            changeTextColor(head);
            mImageV.setImageResource(imgRes[head]);
        }
    }

    public void getNextImg(View view) {
//        Toast.makeText(this, ""+head, Toast.LENGTH_SHORT).show();
//        head=((head+1)%imgRes.length);
//        mImageV.setImageResource(imgRes[head]);
        if(head<imgRes.length-1){
            head=head+1;
            changeTextColor(head);
            mImageV.setImageResource(imgRes[head]);
        }
    }

    private void changeTextColor(int head) {
        if(head==0){
            mTextView5.setTextColor(rgb(0,0,0));
            mTextView1.setTextColor(rgb(255,0,0));
            mTextView2.setTextColor(rgb(0,0,0));
            sv.scrollTo(0, mTextView1.getTop());
        }else if(head==1){
            mTextView1.setTextColor(rgb(0,0,0));
            mTextView2.setTextColor(rgb(255,0,0));
            mTextView3.setTextColor(rgb(0,0,0));
            sv.scrollTo(0, mTextView2.getTop());

        }else if(head==2){
            mTextView2.setTextColor(rgb(0,0,0));
            mTextView3.setTextColor(rgb(255,0,0));
            mTextView4.setTextColor(rgb(0,0,0));
            sv.scrollTo(0, mTextView3.getTop());

        }else if(head==3){
            mTextView3.setTextColor(rgb(0,0,0));
            mTextView4.setTextColor(rgb(255,0,0));
            mTextView5.setTextColor(rgb(0,0,0));
            sv.scrollTo(0, mTextView4.getTop());

        }else if(head==4){
            mTextView4.setTextColor(rgb(0,0,0));
            mTextView5.setTextColor(rgb(255,0,0));
            mTextView1.setTextColor(rgb(0,0,0));
            sv.scrollTo(0, mTextView5.getTop());
        }
    }
}
