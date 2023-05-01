package com.example.lab05;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt_data);
    }
    public void on_dialog_click(View v)
    {
        String s = txt.getText().toString();

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("abc", s);

        startActivityForResult(i, 555);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode == 555)
        {
            if (data != null)
            {
                String s = data.getStringExtra("qwe");
                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void exit(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы уверены, что хотите выйти из приложения?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish(); // Завершаем работу приложения
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // Пользователь отказался выйти из приложения, продолжаем работу
            }
        });
        builder.show();
    }
}