package com.example.android.inclassassignment09_mingk;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView displayText;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference bookRef = database.getReference("My Book");
    private DatabaseReference booksRef = database.getReference("Many books");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = (TextView)findViewById(R.id.display_text);

        bookRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Book b = dataSnapshot.getValue(Book.class);
                if (b != null) {
                    displayText.setText(b.toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Error loading Firebase",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void setBook(View view){
        bookRef.setValue(new Book("Harry Potter", "J.K.Rowling", "fiction",true));
    }

    public void addBook(View view){
        booksRef.push().setValue(new Book("Jane Eyre","Charlotte Bronte", "fiction",false));

    }
}
