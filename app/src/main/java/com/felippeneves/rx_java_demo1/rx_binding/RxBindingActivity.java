package com.felippeneves.rx_java_demo1.rx_binding;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.felippeneves.rx_java_demo1.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import io.reactivex.disposables.Disposable;

public class RxBindingActivity extends AppCompatActivity {

    private EditText etInputField;
    private TextView tvInput;
    private Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_binding);

        etInputField = findViewById(R.id.etInputField);
        tvInput = findViewById(R.id.tvInput);
        btnClear = findViewById(R.id.btnClear);

//        etInputField.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                tvInput.setText(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
//
//        btnClear.setOnClickListener(v -> {
//            etInputField.setText("");
//        });

        Disposable disposable1 = RxTextView.textChanges(etInputField)
                .subscribe(charSequence -> tvInput.setText(charSequence));

        Disposable disposable2 = RxView.clicks(btnClear)
                .subscribe(unit -> etInputField.setText(""));
    }
}
