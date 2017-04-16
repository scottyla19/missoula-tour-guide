package com.example.android.missoulahoodguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ParksFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ParksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ParksFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ParksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParksFragment newInstance(String param1, String param2) {
        ParksFragment fragment = new ParksFragment();
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
        View rootView = inflater.inflate(R.layout.word_lits, container, false);
        final ArrayList<HoodLocation> locs = new ArrayList<HoodLocation>();

//
        locs.add(new HoodLocation("Southside Lions","Central and Bancroft", Uri.parse("geo:46.851080, -114.008693?z=18"), "Slides, swings, water park, merry-go-round, sandbox"));
        locs.add(new HoodLocation("Playfair Park","Pattee Creek Drive and Stephens Ave. S", Uri.parse("geo:46.842874, -114.0148923?z=18"),"Slides, swings, water park, tennis courts, basketball, sand volleyball, soccer, baseball"));
        locs.add(new HoodLocation("Lester Park","Lester and Agnes", Uri.parse("geo:46.843175, -113.999453?z=18"), "Slides, swings, sandbox"));
        locs.add(new HoodLocation("Bonner Park","Beverly and Ronald", Uri.parse("geo:46.854719, -113.993340?z=18"), "Slides, swings, water park, tennis courts, basketball"));
        locs.add(new HoodLocation("Lewis and Clark Playground","Benton and Hollis", Uri.parse("geo:46.844322, -114.004123?z=18"),"Slides, swings, jungle gym, basketball, soccer"));


        HoodLocationAdapter itemsAdapter = new HoodLocationAdapter(this.getContext(), R.layout.list_item,locs);

        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setBackgroundColor(getResources().getColor(R.color.colorParks));
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                Uri geoLoc = locs.get(position).getmGeoLoc();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLoc);
                getActivity().startActivity(intent);


            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
