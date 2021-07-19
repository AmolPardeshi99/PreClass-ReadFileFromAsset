package com.example.readfilefromasset;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mBtnReadData;
    private RecyclerView recyclerView;
    private List<FormulasModel> formulasModelList = new ArrayList<>();
    private FormulaAdapter formulaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsandListeners();
        setRecyclerAdapter();
    }

    private void setRecyclerAdapter() {
        formulaAdapter = new FormulaAdapter(formulasModelList);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(formulaAdapter);
    }

    private void initViewsandListeners() {
        mBtnReadData = findViewById(R.id.btnReadData);
        recyclerView = findViewById(R.id.recyclerView);

        mBtnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBackgroundThread();
            }

            private void startBackgroundThread() {
                Thread thread = new Thread(runnable);
                thread.start();
            }

            private Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    readJsonfromAssets();
                }
            };

            private void readJsonfromAssets() {
                try {
                    InputStream inputStream = getAssets().open("formula.json");
                    int data = inputStream.read();
                    StringBuilder builder = new StringBuilder();

                    while (data != -1) {
                        char ch = (char) data;
                        builder.append(ch);
                        data = inputStream.read();
                    }
                    Log.d("Amol", builder.toString());
                    buildPojofromJson(builder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            private void buildPojofromJson(StringBuilder builder) {
                String json = builder.toString();
                Gson gson = new Gson();
                Type type = new TypeToken<ResponseModel>() {
                }.getType();
                ResponseModel responseModel = gson.fromJson(json, type);
                formulasModelList = responseModel.getFormulas();
                updateUI();
            }

            private void updateUI() {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        formulaAdapter.UpdateList(formulasModelList);
                    }
                });
            }
        });
    }
}