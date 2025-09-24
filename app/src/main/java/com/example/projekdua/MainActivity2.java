package com.example.projekdua;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textReceived;
    EditText editReply;
    Button btnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        textReceived = findViewById(R.id.textReceived);
        editReply = findViewById(R.id.editReply);
        btnReply = findViewById(R.id.btnReply);

        // Ambil pesan dari Activity1
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if (message != null) {
            textReceived.setText("Dari Activity 1: " + message);
        }

        btnReply.setOnClickListener(v -> {
            String reply = editReply.getText().toString();
            Intent i = new Intent(MainActivity2.this, MainActivity.class);
            i.putExtra("replyMessage", reply);
            startActivity(i);
        });
    }
}
