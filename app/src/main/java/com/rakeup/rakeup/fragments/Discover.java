package com.rakeup.rakeup.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rakeup.rakeup.R;

public class Discover extends Fragment {

    EditText editText1;
    EditText editText2;
    Button btn1;
    Button btn2;
    Button btn3;
    Spinner spinner;
    ArrayAdapter<String> dataAdapterForIlceler;

    private String[] ilceler = {"ADALAR","ARNAVUTKÖY","ATAŞEHİR","AVCILAR","BAğCILAR","BAHÇELİEVLER","BAKIRKÖY","BAŞAKŞEHİR","BAYRAMPAŞA","BEŞİKTAŞ","BEYLİKDÜZÜ","BEYOĞLU","BÜYÜKÇEKMECE","BEYKOZ","ÇATALCA","ÇEKMEKÖY","ESENLER","ESENYURT","EYÜP","FATİH","GAZİOSMANPAŞA","GÜNGÖREN","KADIKÖY","KAĞITHANE","KARTAL","KÜÇÜKÇEKMECE","MALTEPE","PENDİK","SANCAKTEPE","SARIYER","SİLİVRİ","SULTANBEYLİ","SULTANGAZİ","ŞİLE","ŞİŞLİ","TUZLA","ÜSKÜDAR","ÜMRANİYE","ZEYTİNBURNU"};


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_discover, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText1 = (EditText) getActivity().findViewById(R.id.et1);
        editText2 = (EditText) getActivity().findViewById(R.id.et2);
        btn1 = (Button) getActivity().findViewById(R.id.button1);
        btn2 = (Button) getActivity().findViewById(R.id.button2);
        btn3 = (Button) getActivity().findViewById(R.id.button3);
        spinner = (Spinner) getActivity().findViewById(R.id.spinner);

        dataAdapterForIlceler = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ilceler);
        spinner.setAdapter(dataAdapterForIlceler);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText1.getText().length() > 0){
                    String aaa = editText1.getText().toString().substring(0, editText1.getText().length()-1);
                    Toast.makeText(getActivity(), aaa, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final View.OnClickListener listenerET1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control(view, editText1);
            }
        };

        final View.OnClickListener listenerET2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control(view, editText2);
            }
        };

        editText1.setCursorVisible(false);
        editText2.setCursorVisible(false);
        editText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b) {
                    btn1.setOnClickListener(listenerET1);
                    btn2.setOnClickListener(listenerET1);
                }else {
                    btn1.setOnClickListener(listenerET2);
                    btn2.setOnClickListener(listenerET2);
                }
            }
        });

    }

    private void control(View view, EditText editText) {
        String temp = editText.getText().toString();
        switch (view.getId()) {
            case R.id.button1:
                editText.setText(temp + "1");
                break;
            case R.id.button2:
                editText.setText(temp + "2");
                break;
        }
    }

}