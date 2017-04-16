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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiningFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiningFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public DiningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiningFragment newInstance(String param1, String param2) {
        DiningFragment fragment = new DiningFragment();
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
        locs.add(new HoodLocation("Drum Coffee","600 South Ave W, Missoula, MT 59801", Uri.parse("geo:46.849101, -114.006411?z=18"), "Coffee and treats"));
        locs.add(new HoodLocation("Taco Del Sol","1116 W Central Ave, Missoula, MT 59801", Uri.parse("geo:46.851100, -114.015691?z=18"), "Burrito shop" ));
        locs.add(new HoodLocation("Staggering Ox","1220 SW Higgins Ave # 4, Missoula, MT 59803", Uri.parse("geo:46.834753, -114.016093?z=18"), "Sandwich shop" ));
        locs.add(new HoodLocation("Dairy Queen","1735 S Higgins Ave, Missoula, MT 59801", Uri.parse("geo:46.854601, -113.997801?z=18"), "Ice cream" ));
        locs.add(new HoodLocation("El Diablo","1429 S Higgins Ave, Missoula, MT 59801", Uri.parse("geo:46.857384, -113.997683?z=18"), "Burrito shop" ));
        locs.add(new HoodLocation("Krispy Kreme Doughnuts","1025 W Central Ave, Missoula, MT 59801", Uri.parse("geo:46.850440, -114.013359?z=18"), "Doughnuts" ));
        locs.add(new HoodLocation("Tagliare Deli","1433 S Higgins Ave, Missoula, MT 59801", Uri.parse("geo:46.857285, -113.997728?z=18"), "Deli and sandwich shop" ));
        locs.add(new HoodLocation("Acropolis Greek Gyros","117 South Ave W #3, Missoula, MT 59801", Uri.parse("geo:46.848601, -113.998283?z=18"), "Greek cuisine" ));
        locs.add(new HoodLocation("Subway","2325 S Higgins Ave, Missoula, MT 59801", Uri.parse("geo:46.849140, -113.997559?z=18"), "Sandwich shop" ));




        HoodLocationAdapter itemsAdapter = new HoodLocationAdapter(this.getContext(), R.layout.list_item, locs);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setBackgroundColor(getResources().getColor(R.color.colorDining));

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
