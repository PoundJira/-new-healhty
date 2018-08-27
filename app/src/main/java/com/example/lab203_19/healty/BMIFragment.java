package com.example.lab203_19.healty;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LAB203_19 on 20/8/2561.
 */

public class BMIFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bmi, container, false);
    }
    public void onActivityCreated(
            @Nullable Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);

        initCalculateBtn();

    }
    void initCalculateBtn (){
        Button _registerBtn = (Button) getView().findViewById(R.id.bmi_caculate_btn);
        _registerBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText _height = (EditText) getView().findViewById(R.id.bmi_height);
                EditText _weight = (EditText) getView().findViewById(R.id.bmi_weight);

                String _heightStr = _height.getText().toString();
                String _weightStr = _weight.getText().toString();

                Float _heightFloat = Float.parseFloat(_heightStr);
                Float _weightFloat = Float.parseFloat(_weightStr);

                if(_heightStr.isEmpty() || _weightStr.isEmpty()){
                    Toast.makeText(
                            getActivity(),
                            "please fill that all information",
                            Toast.LENGTH_SHORT
                    ).show();
                    Log.d("BMI","FIELD NAME IS EMPTY");
                }
                else{
                    Float _bmi_value1 = _weightFloat /((_heightFloat/100)*(_heightFloat/100));
                    TextView _bmi_label = (TextView) getView().findViewById(R.id.bmi_value);
                    _bmi_label.setText(_bmi_value1.toString());
                    Log.d("BMI","BMI IS VALUE");
                }
            }
        });
    }
}
