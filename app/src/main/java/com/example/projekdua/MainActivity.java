package com.example.projekdua;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView textMessage;
    EditText editMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textMessage = findViewById(R.id.textMessage);
        editMessage = findViewById(R.id.editMessage);
        btnSend = findViewById(R.id.btnSend);

        // Cek apakah ada pesan balasan dari Activity2
        Intent intent = getIntent();
        String reply = intent.getStringExtra("replyMessage");
        if (reply != null) {
            textMessage.setText("Balasan: " + reply);
        }

        btnSend.setOnClickListener(v -> {
            String message = editMessage.getText().toString();
            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("message", message);
            startActivity(i);
        });
    }
}

