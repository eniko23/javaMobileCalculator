package com.example.hesapmakinesisinav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTxtBirinciSayi, numberSigned;
    Button btnTopla, btnFark, btnBolme, btnCarp;
    TextView txtViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml deki id ler
        editTxtBirinciSayi = findViewById(R.id.EditTxtBirinciSayi);
        numberSigned = findViewById(R.id.numberSigned);
        btnTopla = findViewById(R.id.btnTopla);
        btnFark = findViewById(R.id.btnFark);
        btnBolme = findViewById(R.id.btnBolme);
        btnCarp = findViewById(R.id.btnCarp);
        txtViewSonuc = findViewById(R.id.txtViewSonuc);

        btnTopla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        btnFark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        btnCarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        btnBolme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }

    private void performOperation(String operation) {
        String birinciSayiStr = editTxtBirinciSayi.getText().toString();
        String ikinciSayiStr = numberSigned.getText().toString();

        if (birinciSayiStr.isEmpty() || ikinciSayiStr.isEmpty()) {
            txtViewSonuc.setText("");
            return;
        }

        int sayi1 = Integer.parseInt(birinciSayiStr);
        int sayi2 = Integer.parseInt(ikinciSayiStr);
        int sonuc = 0;

        switch (operation) {
            case "+":
                sonuc = sayi1 + sayi2;
                break;
            case "-":
                sonuc = sayi1 - sayi2;
                break;
            case "*":
                sonuc = sayi1 * sayi2;
                break;
            case "/":
                if (sayi2 != 0) {
                    sonuc = sayi1 / sayi2;
                } else {
                    txtViewSonuc.setText("");
                    return;
                }
                break;
        }

        txtViewSonuc.setText("Sonuç: " + sonuc);
    }
}
