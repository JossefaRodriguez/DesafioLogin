package com.example.desafio3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.desafio3.databinding.FragmentSecondBinding;


public class secondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        String secondMessage = "Recuerda que para que la contraseña sea segura debe cumplir con estas características:\n" +
                "> Al menos 5 caracteres\n" +
                "> Al menos 1 letra mayúscula\n" +
                "Otras Características que hacen la contraseña más segura\n" +
                "> Al menos 1 carácter especial (como .,%$)\n" +
                "> Al menos 1 número.";
        // Se establece el mensaje sobre el string.
        binding.textView2.setText(secondMessage);

        return binding.getRoot();
    }
}