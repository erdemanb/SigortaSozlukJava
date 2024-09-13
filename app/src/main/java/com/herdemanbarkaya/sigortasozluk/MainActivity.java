package com.herdemanbarkaya.sigortasozluk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHelper dbHelper; // DBHelper örneği
    private String correctAnswer; // Doğru cevabı saklamak için
    private int score = 0; // Skoru saklamak için

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // DBHelper örneğini oluşturun
        dbHelper = new DBHelper(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Soruları yükle
        loadQuestion();

        Button option1Button = findViewById(R.id.option1Button);
        Button option2Button = findViewById(R.id.option2Button);
        Button option3Button = findViewById(R.id.option3Button);
        Button option4Button = findViewById(R.id.option4Button);

        // Butonlara tıklama dinleyicileri ekleyin
        option1Button.setOnClickListener(v -> handleButtonClick(option1Button.getText().toString()));
        option2Button.setOnClickListener(v -> handleButtonClick(option2Button.getText().toString()));
        option3Button.setOnClickListener(v -> handleButtonClick(option3Button.getText().toString()));
        option4Button.setOnClickListener(v -> handleButtonClick(option4Button.getText().toString()));
    }

    private void handleButtonClick(String selectedOption) {
        if (selectedOption.equals(correctAnswer)) {
            // Doğru cevap
            score += 10; // Skoru artır
            loadQuestion(); // Yeni soru yükle
        } else {
            // Yanlış cevap
            // Uyarı veya tekrar deneme işlemleri
        }
        updateScore(); // Skoru güncelle
    }

    private void loadQuestion() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Rastgele bir kelime seçin
        Cursor cursor = db.rawQuery("SELECT id, word, meaning FROM Words ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            long wordId = cursor.getLong(cursor.getColumnIndex("id"));
            correctAnswer = cursor.getString(cursor.getColumnIndex("word")); // Doğru cevabı sakla
            String meaning = cursor.getString(cursor.getColumnIndex("meaning"));

            // Anlam cümlesini UI'ye yerleştirin
            TextView meaningTextView = findViewById(R.id.meaningTextView);
            meaningTextView.setText(meaning);

            // 4 seçenekli butonlar için verileri oluşturun
            loadOptions(wordId);
        }
        cursor.close();
    }

    private void loadOptions(long correctWordId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<String> options = new ArrayList<>();

        // Doğru seçeneği ekleyin
        Cursor cursor = db.rawQuery("SELECT word FROM Words WHERE id = ?", new String[]{String.valueOf(correctWordId)});
        if (cursor.moveToFirst()) {
            options.add(cursor.getString(cursor.getColumnIndex("word")));
        }
        cursor.close();

        // Yanlış seçenekler ekleyin
        cursor = db.rawQuery("SELECT word FROM Words WHERE id != ? ORDER BY RANDOM() LIMIT 3", new String[]{String.valueOf(correctWordId)});
        while (cursor.moveToNext()) {
            options.add(cursor.getString(cursor.getColumnIndex("word")));
        }
        cursor.close();

        // Seçenekleri karıştırın
        Collections.shuffle(options);

        // Butonları güncelleyin
        Button option1Button = findViewById(R.id.option1Button);
        Button option2Button = findViewById(R.id.option2Button);
        Button option3Button = findViewById(R.id.option3Button);
        Button option4Button = findViewById(R.id.option4Button);

        option1Button.setText(options.get(0));
        option2Button.setText(options.get(1));
        option3Button.setText(options.get(2));
        option4Button.setText(options.get(3));
    }

    private void updateScore() {
        TextView scoreTextView = findViewById(R.id.tvScore);
        scoreTextView.setText("Score: " + score);
    }
}