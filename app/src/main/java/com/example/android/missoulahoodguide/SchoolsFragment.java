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
 * {@link SchoolsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SchoolsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SchoolsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SchoolsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SchoolsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SchoolsFragment newInstance(String param1, String param2) {
        SchoolsFragment fragment = new SchoolsFragment();
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
        locs.add(new HoodLocation("Sentinel High School","901 South Ave. W", Uri.parse("geo:46.847126, -114.009570?z=18"),"Grades 9-12"));
        locs.add(new HoodLocation("Washington Middle School","645 W Central Ave, Missoula, MT 59801", Uri.parse("geo:46.850220, -114.006706?z=18"),"Grades 6-8"));
        locs.add(new HoodLocation("Lewis and Clark Elementary","2901 Park St, Missoula, MT 59801", Uri.parse("geo:46.844243, -114.003219?z=18"),"Grades K-5"));
        locs.add(new HoodLocation("Russell Elementary School","3216 S Russell St, Missoula, MT 59801", Uri.parse("geo:46.841076, -114.017504?z=18"),"Grades K-5"));


        HoodLocationAdapter itemsAdapter = new HoodLocationAdapter(this.getContext(), R.layout.list_item, locs);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setBackgroundColor(getResources().getColor(R.color.colorSchools));

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
