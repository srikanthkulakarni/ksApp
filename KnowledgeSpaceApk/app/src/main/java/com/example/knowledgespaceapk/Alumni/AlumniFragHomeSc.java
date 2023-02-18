package com.example.knowledgespaceapk.Alumni;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;

import com.example.knowledgespaceapk.Alumni.Directory.AlumniDirectoryMainScF;
import com.example.knowledgespaceapk.Alumni.Opportunity.AlumniOpportunityFrag;
import com.example.knowledgespaceapk.R;
import com.google.android.material.card.MaterialCardView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlumniFragHomeSc#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlumniFragHomeSc extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FrameLayout frameLayAlumniFragHomeSc;
    private ScrollView scrollVAlumniFragHomeSc;
    private MaterialCardView HallOfFrameMaterialCardVAlumniFragMainSc,OpportunitiesMaterialCardVAlumniFragMainSc,AlumniDirectoryMaterialCardVAlumniFragMainSc;

    public AlumniFragHomeSc() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlumniFragHomeSc.
     */
    // TODO: Rename and change types and number of parameters
    public static AlumniFragHomeSc newInstance(String param1, String param2) {
        AlumniFragHomeSc fragment = new AlumniFragHomeSc();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_alumni_frag_home_sc,container,false);

        frameLayAlumniFragHomeSc = view.findViewById(R.id.frameLayAlumniFragHomeSc);




        scrollVAlumniFragHomeSc = view.findViewById(R.id.scrollVAlumniFragHomeSc);

        OpportunitiesMaterialCardVAlumniFragMainSc = view.findViewById(R.id.OpportunitiesMaterialCardVAlumniFragMainSc);
        OpportunitiesMaterialCardVAlumniFragMainSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FrameLayout fl = activity.findViewById(R.id.frameLayAlumniFragHomeSc);
                fl.removeAllViews();
                Fragment fragment = new AlumniOpportunityFrag();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc,fragment).commit();
                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_alumni_frag_home_sc));
            }
        });

        AlumniDirectoryMaterialCardVAlumniFragMainSc = view.findViewById(R.id.AlumniDirectoryMaterialCardVAlumniFragMainSc);
        AlumniDirectoryMaterialCardVAlumniFragMainSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FrameLayout fl = activity.findViewById(R.id.frameLayAlumniFragHomeSc);
                fl.removeAllViews();
                Fragment fragment = new AlumniDirectoryMainScF();
                FragmentManager manager = activity.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayAlumniFragHomeSc,fragment).commit();
                fragmentTransaction.addToBackStack(String.valueOf(R.layout.fragment_alumni_frag_home_sc));
            }
        });



        return  view;
    }
}