package com.example.pictopocketiv.search;

import static androidx.browser.customtabs.CustomTabsClient.getPackageName;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pictopocketiv.R;
import com.example.pictopocketiv.arasaac.ArasaacModel;
import com.example.pictopocketiv.arasaac.ArasaacService;
import com.example.pictopocketiv.forms.WaitingFragment;
import com.example.pictopocketiv.localpersistence.LocalPersistenceService;
import com.example.pictopocketiv.states.MainActivityStateMV;

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
        TIEMPO, TRANSPORTE, DEPORTE, ANIMALES
    }

    private static final String TAG = PictoAddCategroyFragment.class.getSimpleName();

    private Button mTiempobtn;
    private Button mTransportebtn;
    private Button mDeportesbtn;

    private Button mAnimalesbtn;
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
        mAnimalesbtn = view.findViewById(R.id.buttonanimales);
    }

    private void setListenersUI() {
        mTiempobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadCollection(ButtonActions.TIEMPO);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mDeportesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadCollection(ButtonActions.DEPORTE);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mTransportebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadCollection(ButtonActions.TRANSPORTE);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });

        mAnimalesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadCollection(ButtonActions.ANIMALES);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void loadCollection(ButtonActions action) throws Throwable {
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
            case ANIMALES:
                json = "animalesPictos.json";
                break;
        }

        if(json!=null){
            //aqui cargamos el json con el metodo del POPULATOR ASYNCTASK==??
            //mirar bien como se hace porque se queda esperando
            goDBPopulation(json);
            //toast
        }
    }

    private void goDBPopulation(String jsonName) throws Throwable {
        // If empty DB try to populate
        // Use this to check the response
        // Wait to populate before go next state
        LocalPersistenceService.populateDBNew(
                getContext(),"com.example.pictopocketiv","es",500, jsonName);
        //toast
        Toast.makeText(getActivity(), "Completado correctamente!", Toast.LENGTH_LONG).show();
        getActivity().finish();
    }
}