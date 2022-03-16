package com.example.bai02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinDm;
    EditText et_Ma, et_Ten;
    Button btn_Nhap;
    ListView lv_SanPham;

    ArrayList<Catalog> arraySpin = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpin = null;
    ArrayList<Product> arrayListView = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgetsControl();
        fakeDataCatalog();
        addEventsForFormWidgets();

    }
    public void getWidgetsControl() {
        et_Ten = findViewById(R.id.editText_TenSP);
        et_Ma = findViewById(R.id.editText_MaSP);
        spinDm = findViewById(R.id.spinner_DanhMuc);
        lv_SanPham = findViewById(R.id.list);
        btn_Nhap = findViewById(R.id.button_NhapSP);

        adapterSpin = new ArrayAdapter<Catalog>(MainActivity.this, android.R.layout.simple_spinner_item, arraySpin);
        adapterSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDm.setAdapter(adapterSpin);

        adapterListView = new ArrayAdapter<Product>(MainActivity.this, android.R.layout.simple_list_item_1, arrayListView);
        lv_SanPham.setAdapter(adapterListView);
    }

    public void fakeDataCatalog() {
        arraySpin.add(new Catalog("1", "Samsung"));
        arraySpin.add(new Catalog("2", "IPhone"));
        arraySpin.add(new Catalog("3", "IPad"));
        adapterSpin.notifyDataSetChanged();
    }

    public  void addEventsForFormWidgets() {
        btn_Nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductForCatalog();
            }
        });

        spinDm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadProductByCatalog(arraySpin.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void addProductForCatalog() {
        Product p = new Product();
        p.setId(et_Ma.getText().toString());
        p.setName(et_Ten.getText().toString());
        Catalog c = (Catalog) spinDm.getSelectedItem();
        c.addProduct(p);
        loadProductByCatalog(c);
    }

    public void loadProductByCatalog(Catalog c) {
        arrayListView.clear();
        arrayListView.addAll(c.getListSP());
        adapterListView.notifyDataSetChanged();
    }
}