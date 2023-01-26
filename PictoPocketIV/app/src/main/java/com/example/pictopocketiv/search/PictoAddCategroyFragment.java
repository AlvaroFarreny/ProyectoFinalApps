package com.example.pictopocketiv.search;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pictopocketiv.R;
import com.example.pictopocketiv.arasaac.ArasaacModel;
import com.example.pictopocketiv.arasaac.ArasaacService;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PictoAddCategroyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PictoAddCategroyFragment extends Fragment {

    private static enum ButtonActions{
        TIEMPO, TRANSPORTE, DEPORTE
    }

    private static final String TAG = PictoAddCategroyFragment.class.getSimpleName();

    private Button mTiempobtn;
    private Button mTransportebtn;
    private Button mDeportesbtn;
    public PictoAddCategroyFragment() {
        // Required empty public constructor
    }

    /**
     * New Instance
     * @return
     */
    public static PictoAddCategroyFragment newInstance(AppCompatActivity activity) {
        PictoAddCategroyFragment fragment = new PictoAddCategroyFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_ACTIVITY, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mTerm = getArguments().getString(ARG_SEARCH_TERM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_picto_addcategory, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUI(view);
    }


    /** UI **/
    private void setUI(View view) {
        setWidgetsUI(view);
        setListenersUI();
    }

    private void setWidgetsUI(@NonNull View view) {
        // btn HACER UN ENUM PARA GESTIONAR ESTOS BOTONES!!!
        mTiempobtn = view.findViewById(R.id.buttontiempo);
        mDeportesbtn = view.findViewById(R.id.buttondeportes);
        mTransportebtn = view.findViewById(R.id.buttontransporte);
    }

    private void setListenersUI() {
        mTiempobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCollection(ButtonActions.TIEMPO);
            }
        });

        mDeportesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCollection(ButtonActions.DEPORTE);
            }
        });

        mTransportebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadCollection(ButtonActions.TRANSPORTE);
            }
        });
    }

    private void loadCollection(ButtonActions action){
        String json = null;

        switch(action){
            case TIEMPO:
                json = "tiempoPictos.json";
                break;
            case DEPORTE:
                json = "deportesPictos.json";
                break;
            case TRANSPORTE:
                json = "transportePictos.json";
                break;
        }

        if(json!=null){
            //aqui cargamos el json con el metodo del POPULATOR ASYNCTASK==??
            //mirar bien como se hace porque se queda esperando

            //toast
        }
    }
}