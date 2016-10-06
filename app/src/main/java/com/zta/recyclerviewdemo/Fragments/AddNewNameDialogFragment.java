package com.zta.recyclerviewdemo.Fragments;

import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zta.recyclerviewdemo.Model.NameItem;
import com.zta.recyclerviewdemo.R;
import com.zta.recyclerviewdemo.Utility.Validate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link DialogFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnNewNameAddedListener} interface
 * to handle interaction events.
 * Use the {@link AddNewNameDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddNewNameDialogFragment extends DialogFragment {

    public static final String ADD_NEW_NAME_DIALOG_FRAGMENT_TAG = "add_new_name_dialog_fragment";

    View dialogView;

    @BindView(R.id.edt_first_name)
    EditText edtFirstName;
    @BindView(R.id.edt_last_name)
    EditText edtLastName;
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.btn_cancel)
    Button btnCancel;


    private OnNewNameAddedListener newNameAddedListener;

    public AddNewNameDialogFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddNewNameDialogFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddNewNameDialogFragment newInstance() {
        AddNewNameDialogFragment fragment = new AddNewNameDialogFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        dialogView = inflater.inflate(R.layout.fragment_add_new_name, container, false);
        ButterKnife.bind(this, dialogView);
        return dialogView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNewNameAddedListener) {
            newNameAddedListener = (OnNewNameAddedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        newNameAddedListener = null;
    }

    @OnClick(R.id.btn_add)
    public void onAddButtonClick() {

        String firstName = edtFirstName.getText().toString().trim();
        String lastName = edtLastName.getText().toString().trim();

        if (firstName != null && lastName != null
                && !firstName.isEmpty() && !lastName.isEmpty()) {
            addNewName(firstName, lastName);
        } else {
            Toast.makeText(getActivity(), R.string.enter_names_error_message, Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.btn_cancel)
    public void onCancelButtonClick() {
        getDialog().dismiss();

    }

    /**
     * Checks the names
     *
     * @param firstName
     * @param lastName
     */
    private void addNewName(String firstName, String lastName) {

        if (Validate.validateName(firstName) && Validate.validateName(lastName)) {

            newNameAddedListener.onNewNameAddition(new NameItem(firstName, lastName));
            getDialog().dismiss();

        } else {
            Toast.makeText(getActivity(), R.string.invalid_names_error_message, Toast.LENGTH_SHORT).show();
        }

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
    public interface OnNewNameAddedListener {
        void onNewNameAddition(NameItem newNameItem);
    }
}
