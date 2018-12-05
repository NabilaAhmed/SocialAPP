package com.example.android.application.AccountActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.application.Adapter.PostAdapter;
import com.example.android.application.MainActivity;
import com.example.android.application.Objects.Client;
import com.example.android.application.Objects.Post;
import com.example.android.application.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String MY_PREFS_NAME = "save";
    Button post;
    EditText post_containt;
    ListView listView;
    DatabaseReference MainREf;
    DatabaseReference postsRef;
    DatabaseReference reference;
    private int counter = 0;
    String ClientID;
    List<Client> clientREtrivin;
    List<Post> postsArray;
    private int i = 0;
    String sessionId;
int v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        MainREf = FirebaseDatabase.getInstance().getReference("Client");
        postsRef = FirebaseDatabase.getInstance().getReference("Post");
        clientREtrivin = new ArrayList<>();
        postsArray = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        post = (Button) findViewById(R.id.btnpost);
        post_containt = (EditText) findViewById(R.id.post);
//        sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        sessionId = getIntent().getStringExtra("counter");
//        int v = Integer.parseInt(sessionId);

if(sessionId==null){
    counter=0;
}
else {
    counter=1;
}
        setSupportActionBar(toolbar);
        setTitle("Home");

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
        String b = prefs.getString("name", null);


        if (counter == 0) {
            ClientID = MainREf.push().getKey();
            String ClientEmail = "";
            String Level_One = "";
            String Level_Two = "";
            String Level_Three = "";
            String balance = "";
            Toast.makeText(Home.this, "counter" + sessionId, Toast.LENGTH_SHORT).show();

            Client client = new Client(ClientID, ClientEmail, Level_One, Level_Two, Level_Three, balance);
            reference = MainREf.child(ClientID);
            reference.setValue(client);
            counter = 1;
        }

//        Toast.makeText(Home.this, "ghghgh" + b, Toast.LENGTH_SHORT).show();
//        Toast.makeText(Home.this, "ghghgh" + sessionId, Toast.LENGTH_SHORT).show();

        if (b != null && b.equals(" ")) {
            String dt = ClientID;
            prefs.edit().putString("name", dt).commit();

        } else {
//            Toast.makeText(Home.this, "get shred in home and initalize", Toast.LENGTH_SHORT).show();
//
//            SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
//            editor.putString("name", ClientID);
//            editor.apply();
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        // check uer is here or not


        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String PostID = postsRef.push().getKey();

                DatabaseReference reference1 =  postsRef.child(PostID);

                reference = postsRef.child(ClientID);
                String Post_Content = post_containt.getText().toString().trim();
                String Post_Owner = ClientID;
                String PostSharers = "0";
                Post post = new Post(PostID, Post_Content, Post_Owner, PostSharers);
                DatabaseReference childREf11 = postsRef.child(PostID);
                childREf11.setValue(post);
                Toast.makeText(Home.this, "Done!!!!", Toast.LENGTH_SHORT).show();
// send share& share of share member



            }
        });


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
        getMenuInflater().inflate(R.menu.home, menu);
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

        if (id == R.id.LogOut) {
            SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, 0);
            String dt = null;
            prefs.edit().putString("name", dt).commit();

            startActivity(new Intent(Home.this, MainActivity.class));

            // Handle the camera action
        } else if (id == R.id.Balance) {


        }
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();


        DatabaseReference MainREf = FirebaseDatabase.getInstance().getReference("Post");


        MainREf.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postsArray.clear();
                for (DataSnapshot reference : dataSnapshot.getChildren()) {
                    Post post = reference.getValue(Post.class);
                    postsArray.add(post);

                }
                PostAdapter postAdapter = new PostAdapter(Home.this, postsArray);
                listView.setAdapter(postAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String str = view.;
        Toast.makeText(getBaseContext(),"xksmxkzsmxkazm", Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(getBaseContext(),your_new_Intent.class);
    }
});
    }

}
