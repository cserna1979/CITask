package com.example.csern.citask;

import android.content.Context;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentTask.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class FragmentTask extends Fragment {

    private OnFragmentInteractionListener mListener;
    private User user;
    private TextView textViewDate;

    public FragmentTask() {
        // Required empty public constructor
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_task, container, false);

        textViewDate = (TextView) view.findViewById (R.id.textViewDate);

        Calendar calendar = Calendar.getInstance();
        textViewDate.setText(new SimpleDateFormat("MM-yyyy").format(calendar.getTime()));
        createCalendar(calendar);


        return view;
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

    public void createCalendar (Calendar calendar) {
        int dayInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar calForFirstDay = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        int firstDay = calForFirstDay.get(Calendar.DAY_OF_WEEK);
    }
}
