package com.austinnightingale.drywalltally.tally;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.austinnightingale.drywalltally.R;
import com.austinnightingale.drywalltally.TallyApplication;
import com.austinnightingale.drywalltally.db.TallyArea;
import com.austinnightingale.drywalltally.job.dialogs.TallyInputDialog;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

/**
 * Created by Austin on 8/17/2016.
 */
public class CeilingsFragment extends Fragment implements Ceiling.View, NumberPickerListener {

    public static CeilingsFragment newInstance() {
        return new CeilingsFragment();
    }

    @Inject
    Ceiling.Presenter ceilingPrenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TallyApplication) getActivity().getApplication()).getComponent().inject(this);
        ceilingPrenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ceilings, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ceilingPrenter.setView(this);
        ceilingPrenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        ceilingPrenter.onPause();
        ceilingPrenter.setView(null);
    }

    @Override
    public int getID() {
        int id;
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra(TallyArea.ID)) {
            id = intent.getIntExtra(TallyArea.ID, -1);
        } else {
            throw new IllegalArgumentException("no job Id in Intent");
        }
        return id;
    }

    @Override
    public void setPickerResults(String column, int value) {
        ceilingPrenter.updateJob(column, value);
    }

    @Override
    public void setNegativeError() {
        Toast.makeText(this.getContext(), "Value can't be a negative number", Toast.LENGTH_SHORT).show();
    }


    private void showDialog(String column, String title) {
        TallyInputDialog inputDialog = TallyInputDialog.newInstance(
                column,
                "Set " + title
                , InputType.TYPE_CLASS_NUMBER,
                true,
                this
        );
        inputDialog.show(getActivity().getSupportFragmentManager(), "number picker");
    }

    /**
     * Bind Views
     */
    @BindView(R.id.ceil8Tally)
    TextView ceil8Text;
    @BindView(R.id.ceil9Tally)
    TextView ceil9Text;
    @BindView(R.id.ceil10Tally)
    TextView ceil10Text;
    @BindView(R.id.ceil12Tally)
    TextView ceil12Text;
    @BindView(R.id.ceil14Tally)
    TextView ceil14Text;
    @BindView(R.id.ceil16Tally)
    TextView ceil16Text;


    /**
     * 8' Ceiling
     */
    @OnClick(R.id.ceil8Plus)
    public void ceiling8Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_8, 1);
    }

    @OnClick(R.id.ceil8Minus)
    public void ceiling8Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_8, -1);
    }

    @Override
    public void updateCeil8Text(String tally) {
        ceil8Text.setText(tally);
    }

    @OnLongClick(R.id.ceil8View)
    public boolean ceiling8LP() {
        showDialog(TallyArea.CEIL_8, "c8'");
        return true;
    }


    /**
     * 9' Ceiling
     */
    @OnClick(R.id.ceil9Plus)
    public void ceiling9Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_9, 1);
    }

    @OnClick(R.id.ceil9Minus)
    public void ceiling9Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_9, -1);
    }

    @Override
    public void updateCeil9Text(String tally) {
        ceil9Text.setText(tally);
    }

    @OnLongClick(R.id.ceil9View)
    public boolean ceiling9LP() {
        showDialog(TallyArea.CEIL_9, "c9'");
        return true;
    }

    /**
     * 10' Ceiling
     */
    @OnClick(R.id.ceil10Plus)
    public void ceiling10Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_10, 1);
    }

    @OnClick(R.id.ceil10Minus)
    public void ceiling10Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_10, -1);
    }

    @Override
    public void updateCeil10Text(String tally) {
        ceil10Text.setText(tally);
    }

    @OnLongClick(R.id.ceil10View)
    public boolean ceiling10LP() {
        showDialog(TallyArea.CEIL_10, "c10'");
        return true;
    }

    /**
     * 12' Ceiling
     */
    @OnClick(R.id.ceil12Plus)
    public void ceiling12Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_12, 1);
    }

    @OnClick(R.id.ceil12Minus)
    public void ceiling12Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_12, -1);
    }

    @Override
    public void updateCeil12Text(String tally) {
        ceil12Text.setText(tally);
    }

    @OnLongClick(R.id.ceil12View)
    public boolean ceiling12LP() {
        showDialog(TallyArea.CEIL_12, "c12'");
        return true;
    }

    /**
     *
     *  14' Ceiling
     */
    @OnClick(R.id.ceil14Plus)
    public void ceiling14Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_14, 1);
    }

    @OnClick(R.id.ceil14Minus)
    public void ceiling14Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_14, -1);
    }
    @Override
    public void updateCeil14Text(String tally) {
        ceil14Text.setText(tally);
    }

    @OnLongClick(R.id.ceil14View)
    public boolean ceiling14LP() {
        showDialog(TallyArea.CEIL_14, "c14'");
        return true;
    }

    /**
     *
     *  16' Ceiling
     */
    @OnClick(R.id.ceil16Plus)
    public void ceiling16Plus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_16, 1);
    }

    @OnClick(R.id.ceil16Minus)
    public void ceiling16Minus() {
        ceilingPrenter.updateJob(TallyArea.CEIL_16, -1);
    }
    @Override
    public void updateCeil16Text(String tally) {
        ceil16Text.setText(tally);
    }

    @OnLongClick(R.id.ceil16View)
    public boolean ceiling16LP() {
        showDialog(TallyArea.CEIL_16, "c16'");
        return true;
    }


}
